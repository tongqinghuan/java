import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;


public class flowop {
	static String ip=topoViewer.ip;
	public static ArrayList<String> SwitchId;
	public static ArrayList<switch_flow> packet;
	public static String push(Flow flow) throws IOException, JSONException {
    
		String warning = "Warning! Pushing a static flow entry that matches IP " +
                "fields without matching for IP payload (ether-type 2048) will cause " +
                "the switch to wildcard higher level fields.";
                
		String jsonResponse = "";
		URL url = new URL("http://" + ip+ ":8080/wm/staticflowpusher/json");
		URLConnection conn = url.openConnection();
		conn.setDoOutput(true);
		OutputStreamWriter wr = new OutputStreamWriter(conn.getOutputStream());
		System.out.println(flow.serialize());
		wr.write(flow.serialize());
		wr.flush();

		// Get the response
		BufferedReader rd = new BufferedReader(new InputStreamReader(
				conn.getInputStream()));
		String line;
		while ((line = rd.readLine()) != null) {
			jsonResponse = jsonResponse.concat(line);
		}
		wr.close();
		rd.close();
		JSONObject json = new JSONObject(jsonResponse);
		System.out.println(jsonResponse);
		if (json.getString("status").equals("Entry pushed") || json.getString("status").equals(warning)) {
			
					return "Flow successfully pushed down to switches";

				
			}
		 else {
			return json.getString("status");
		}
	}
	public static String remove(String name) throws IOException, JSONException {

		String jsonResponse = "";
        String str="{\"name\":\"" + name + "\"}";
		URL url = new URL("http://" +ip+ ":8080/wm/staticflowpusher/json");
		HttpURLConnection connection = null;
		connection = (HttpURLConnection) url.openConnection();
		connection.setRequestMethod("POST");
		connection.setRequestProperty("X-HTTP-Method-Override", "DELETE");
		connection.setDoOutput(true);
		OutputStreamWriter wr = new OutputStreamWriter(
		connection.getOutputStream());
		wr.write(str);
		wr.flush();
        
		// Get Response
		BufferedReader rd = new BufferedReader(new InputStreamReader(
				connection.getInputStream()));
		String line;
		while ((line = rd.readLine()) != null) {
			jsonResponse = jsonResponse.concat(line);
		}
		wr.close();
		rd.close();

		JSONObject json = new JSONObject(jsonResponse);
		return json.getString("status");
	}
	public ArrayList getSwitch() 
	{
		ArrayList switchId=new ArrayList();
		JSONArray json = null;
		URL Switchid = null ;
		BufferedReader reader = null ;
		try {
			 Switchid = new URL("http://" +ip+ ":8080/wm/core/controller/switches/json");
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			HttpURLConnection connection = (HttpURLConnection)Switchid.openConnection();
			connection.connect();
			reader = new BufferedReader(new InputStreamReader(connection.getInputStream())); 
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			json = new JSONArray(reader.readLine());
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			reader.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		for(int i=0;i<json.length();i++)
		{
              try {
				switchId.add(json.getJSONObject(i).getString("switchDPID"));
				System.out.println(json.getJSONObject(i).getString("switchDPID"));
			} catch (JSONException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		return switchId;
	}
	public static void init ()
	{

		SwitchId=new ArrayList<String> (12);
		SwitchId.add("00:00:00:00:00:00:00:01");
		SwitchId.add("00:00:00:00:00:00:00:02");
		SwitchId.add("00:00:00:00:00:00:00:03");
		SwitchId.add("00:00:00:00:00:00:00:04");
		SwitchId.add("00:00:00:00:00:00:00:05");
		SwitchId.add("00:00:00:00:00:00:00:06");
		SwitchId.add("00:00:00:00:00:00:00:07");
		SwitchId.add("00:00:00:00:00:00:00:08");
		SwitchId.add("00:00:00:00:00:00:00:09");
		SwitchId.add("00:00:00:00:00:00:00:0a");
		SwitchId.add("00:00:00:00:00:00:00:0b");
		SwitchId.add("00:00:00:00:00:00:00:0c");
		
	}
	public static void getPacket() 
	{   
		switch_flow temp;
	
		 packet=new ArrayList<switch_flow>(12);
		JSONObject json = null;
		URL aggregate = null ;
		BufferedReader reader = null ;
		try {
			aggregate = new URL("http://" +ip+ ":8080/wm/core/switch/all/aggregate/json");
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			HttpURLConnection connection = (HttpURLConnection)aggregate.openConnection();
			connection.connect();
			reader = new BufferedReader(new InputStreamReader(connection.getInputStream())); 
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			json = new JSONObject(reader.readLine());
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			reader.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		init();
	
		for(int i=0;i<json.length();i++)
		{
			 temp=new switch_flow();
              try {
            	 temp.packetcount=json.getJSONObject(SwitchId.get(i)).getJSONObject("aggregate").getInt("packetCount");
				 temp.switchId=String.valueOf(i);
				 packet.add(temp);
				 System.out.println("this is the packetcount 0f switch");
				 System.out.println(packet.get(i).switchId+packet.get(i).packetcount);
				 
			} catch (JSONException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
	}
	
	
	public static JSONObject showflow(String sw)
	{

		JSONObject  json=new JSONObject ();
		String urlString = "http://" + ip
				+ ":8080/wm/core/switch/" + sw +"/flow/"+"/json";
		URL url = null;
		BufferedReader reader = null ;
		try {
			url=new URL(urlString);
			
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			URLConnection conn = url.openConnection();
			conn.connect();
			reader = new BufferedReader(new InputStreamReader(conn.getInputStream()));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			json = new JSONObject(reader.readLine());
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			reader.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(json);
		return json;
	}
	
}
