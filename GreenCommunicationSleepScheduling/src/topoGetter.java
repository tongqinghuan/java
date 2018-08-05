
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

import javax.swing.JFrame;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class topoGetter {
	
	private static String topoinfo=null;

	public static JSONObject topogetter()
	{
		String ip = topoViewer.ip;
		JSONArray json = null,json3 = null,link=new JSONArray();//for links & device
		JSONObject json2 = null,topology=null;
	    URL features=null,links=null,device= null;
	try {
		//features = new URL("http://"+ip+":8080/wm/core/switch/all/features/json");
		features = new URL("http://"+ip+":8080/wm/core/switch/all/features/json");
		links = new URL("http://"+ip+":8080/wm/topology/links/json");
		device = new URL("http://"+ip+":8080/wm/device/");
	} catch (MalformedURLException e1) {
		e1.printStackTrace();
	}
	
		try {
			HttpURLConnection connection0 = (HttpURLConnection) features.openConnection();
			HttpURLConnection connection1 = (HttpURLConnection) links.openConnection();
			HttpURLConnection connection2 = (HttpURLConnection) device.openConnection();
			
			connection0.connect();
			connection1.connect();
			connection2.connect();
		
			BufferedReader reader0 = new BufferedReader(new InputStreamReader(connection0.getInputStream())); 
			BufferedReader reader1 = new BufferedReader(new InputStreamReader(connection1.getInputStream())); 
			BufferedReader reader2 = new BufferedReader(new InputStreamReader(connection2.getInputStream())); 
			
           try {
        	   json = new JSONArray(reader1.readLine());//links
        	   json2 = new JSONObject(reader0.readLine());//features
        	   json3 = new JSONArray(reader2.readLine());//device     	   
        	   //System.out.println("features"+json2);
			   }
			catch (JSONException e1) 
			{
			     e1.printStackTrace();
		    }           
            reader0.close();
            reader1.close();
            reader2.close();
        
			for(int i=0;i<json.length();i++)
			{
		
			    String s;
				int a=0,b=0,c=0,d=0,bandwidth=0;
				try {
					JSONObject j = json.getJSONObject(i);//get links
					for(int k=0;k<json2.getJSONObject(j.getString("src-switch")).getJSONArray("portDesc").length();k++)
					{
						if (!json2.getJSONObject(j.getString("src-switch")).getJSONArray("portDesc").getJSONObject(k).getString("portNumber").equals("local")) {
							//System.out.println(json2.getJSONObject(j.getString("src-switch")).getJSONArray("portDesc").getJSONObject(k).getInt("portNumber"));
							if(json2.getJSONObject(j.getString("src-switch")).getJSONArray("portDesc").getJSONObject(k).getInt("portNumber") == j.getInt("src-port"))
							{
								a = json2.getJSONObject(j.getString("src-switch")).getJSONArray("portDesc").getJSONObject(k).getInt("currentFeatures");
								c = a & 0x7f;
								switch(c)
								{
								case 1:
									a = 10;//10Mbps
									break;
								case 2:
									a = 10;//10Mbps FDX
									break;
								case 4:
									a = 100;//100Mbps
									break;
								case 8:
									a = 100;//100Mbps FDX
									break;
								case 16:
									a = 1024;//1Gbps
									break;
								case 32:
									a = 1024;//1Gbps FDX
									break;
								case 64:
									a = 10240;//10Gbps FDX
									break;
								}
								//System.out.println(a);*/
							}
						}
					}
					
					for(int l=0;l<json2.getJSONObject(j.getString("dst-switch")).getJSONArray("portDesc").length();l++)
					{
						if (!json2.getJSONObject(j.getString("dst-switch")).getJSONArray("portDesc").getJSONObject(l).getString("portNumber").equals("local")) {
							if(json2.getJSONObject(j.getString("dst-switch")).getJSONArray("portDesc").getJSONObject(l).getInt("portNumber") == j.getInt("dst-port"))
							{
								b = json2.getJSONObject(j.getString("dst-switch")).getJSONArray("portDesc").getJSONObject(l).getInt("currentFeatures");
								d = b & 0x7f;
								switch(d)
								{
								case 1:
									b = 10;//10Mbps
									break;
								case 2:
									b = 10;//10Mbps FDX
									break;
								case 4:
									b = 100;//100Mbps
									break;
								case 8:
									b = 100;//100Mbps FDX
									break;
								case 16:
									b = 1024;//1Gbps
									break;
								case 32:
									b = 1024;//1Gbps FDX
									break;
								case 64:
									b = 10240;//10Gbps FDX
									break;
								}
								//System.out.println(b);*/
							}
						}
					}				
					bandwidth = a >= b ? b : a;				
					s = "{\"left\":\""+j.getString("src-switch")+"\",\"left-port\":"+j.getInt("src-port")+",\"right\":\""+j.getString("dst-switch")+"\",\"right-port\":"+j.getInt("dst-port")+",\"bandwidth\":"+bandwidth+"}";					
					System.out.println("this is the link:");
					System.out.println(s);
					JSONObject js = new JSONObject(s);					
					link.put(js);
				} catch (JSONException e) 
				{
					
					e.printStackTrace();
				}
			}
			
			for(int i=0;i<json3.length();i++)
			{
				String s;
				int bandwidth=0,a=0;
			
				try {
					JSONArray temp = json2.getJSONObject(json3.getJSONObject(i).getJSONArray("attachmentPoint").getJSONObject(0).getString("switchDPID")).getJSONArray("portDesc");
					for(int j=0;j<temp.length();j++)
					{
						if(!temp.getJSONObject(j).getString("portNumber").equals("local")&&(temp.getJSONObject(j).getInt("portNumber") == json3.getJSONObject(i).getJSONArray("attachmentPoint").getJSONObject(0).getInt("port")));
						bandwidth = temp.getJSONObject(j).getInt("currentFeatures");
					}

					a = bandwidth & 0x7f;
					switch(a)
					{
					case 1:
						bandwidth = 10;//10Mbps
						break;
					case 2:
						bandwidth = 10;//10Mbps FDX
						break;
					case 4:
						bandwidth = 100;//100Mbps
						break;
					case 8:
						bandwidth = 100;//100Mbps FDX
						break;
					case 16:
						bandwidth = 1024;//1Gbps
						break;
					case 32:
						bandwidth = 1024;//1Gbps FDX
						break;
					case 64:
						bandwidth = 10240;//10Gbps FDX
						break;
					}
					
					//System.out.println(bandwidth);
					
				} catch (JSONException e1) {
					e1.printStackTrace();
				}
				
				try {
					s = "{\"left\":\""+json3.getJSONObject(i).getJSONArray("ipv4").getString(0)+"\",\"left-port\":"+-1+",\"right\":\""+json3.getJSONObject(i).getJSONArray("attachmentPoint").getJSONObject(0).getString("switchDPID")+"\",\"right-port\":"+json3.getJSONObject(i).getJSONArray("attachmentPoint").getJSONObject(0).getInt("port")+",\"bandwidth\":"+bandwidth+"}";
					JSONObject js = new JSONObject(s);
					link.put(js);
					//System.out.println(s);
				} catch (JSONException e) {
					e.printStackTrace();
				}
			}
			
			int host=0,switchs=0,all=0;
			for(int i=0;i<json3.length();i++)
			{
				try {
					if(json3.getJSONObject(i).getJSONArray("ipv4").getString(0).length() > 0)
					{
						host++;
					}
				} catch (JSONException e) {}
			}
			switchs = json2.length();
			all = host + switchs;
			
			String s = "\"nodes\":"+all;
			
			String topo = "{\"links\":"+link+','+s+"}";
			//System.out.println(topo);
			try {
				topology = new JSONObject(topo);
				//System.out.println(topology);
			} catch (JSONException e) {
				e.printStackTrace();
			}
			
			topoinfo = topo;
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		return topology;
	}

	public static String getString()
	{
		return topoinfo;
	}
	
	
}
