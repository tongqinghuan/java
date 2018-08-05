import java.io.IOException;
import java.util.ArrayList;

import javax.swing.text.html.HTMLDocument.Iterator;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;


public class Routing {

    static int[] pathOne;
    static int path_length;
   public static ArrayList<NodePortTuple> route;
   public static int host_number=0;
   public static int k=0;
    static int src_host;//interface
    static int dst_host;//interface
	public static ArrayList<String> switchId;//store one path
	public static ArrayList<String>  path_node;
	public static void map_switch()
	{
        switchId=new ArrayList<String>(12);
        path_length=EnergySavingPath.finalRouterSize-2;
        System.out.println(String.valueOf(path_length));
        for(int i=0;i<=path_length;i++)
        {
        	System.out.println(String.valueOf(pathOne[i]));

        	switch(pathOne[i])
        	{
        	case 0: switchId.add("00:00:00:00:00:00:00:01");break;
        	case 1: switchId.add("00:00:00:00:00:00:00:02");break;
        	case 2: switchId.add("00:00:00:00:00:00:00:03");break;
        	case 3: switchId.add("00:00:00:00:00:00:00:04");break;
        	case 4: switchId.add("00:00:00:00:00:00:00:05");break;
        	case 5: switchId.add("00:00:00:00:00:00:00:06");break;
        	case 6: switchId.add("00:00:00:00:00:00:00:07");break;
        	case 7: switchId.add("00:00:00:00:00:00:00:08");break;
        	case 8: switchId.add("00:00:00:00:00:00:00:09");break;
        	case 9: switchId.add("00:00:00:00:00:00:00:0a");break;
        	case 10: switchId.add("00:00:00:00:00:00:00:0b");break;
        	case 11: switchId.add("00:00:00:00:00:00:00:0c");break;
        	}
        	
        }
       /* for(int j=0;j<path_length;j++)
        {

        	System.out.println(switchId.get(j));
        }*/
	}
	
	
	
	
	public static String map_host(int host_id)
	{
          switch(host_id)
            {
             case 12:return "10.0.0.1";
             case 13:return "10.0.0.2";
             case 14:return "10.0.0.3";
             case 15:return "10.0.0.4";
             case 16:return "10.0.0.5";
             case 17:return "10.0.0.6";
             case 18:return "10.0.0.7";
             case 19:return "0.0.0.0";
       
       }
       return null;
		
	}
	public static void convert()
	{
		int j=0;
        for(int i=EnergySavingPath.finalRouterSize-2;i>-1;i--)
        {
          pathOne[j]=EnergySavingPath.finalRouter[i];
          j++;
        	
        }
        pathOne[j]=0;
		System.out.println(String.valueOf(j));
	}
	public static String getPort(String host_id)//get the in_port of src_host
	{
		link_path array_lk=new link_path();
		
		//System.out.println("th elength of array"+array_lk.lk.size());
		for(int j=0;j<link_path.lk.size();j++)
		{
            //System.out.println(link.lk.get(j).left_port+"  "+link.lk.get(j).left_switchId+"  "+link.lk.get(j).right_port+"  "+link.lk.get(j).right_switchId);
			if(link_path.lk.get(j).left_port.equals(String.valueOf(-1))&&link_path.lk.get(j).left_switchId.equals( host_id))
			{

				return link_path.lk.get(j).right_port;
			}
			
		}
		return null;
	}
	public static void calpath(int src_host,int dst_host)
	{
		link_path array_lk;
		
		array_lk=new link_path();
		
		int length=0;
		NodePortTuple temp;
		pathOne=new int[10];
		 
		for(int i=0;i<EnergySavingPath.finalRouterSize;i++)
		{

			 System.out.println("sdhfkjd");
			 System.out.println(String.valueOf(EnergySavingPath.finalRouter[i]));
		}
		convert();
		map_switch();//get switchId(one of pathes)
		System.out.println(String.valueOf(path_length));
		for(int i=0;i<path_length;i++)
		{

			 System.out.println("glkjghkjkljhhhhjkjk");
			 System.out.println(String.valueOf(pathOne[i]));
		}
		
		JSONObject links = topoGetter.topogetter();
		
		try {
			//System.out.println("ni hao shijie");
			length = links.getJSONArray("links").length();
			
			 /*for(int i=0;i<path_length;i++)
				{
				 System.out.println("lalalalallalalalall");
					System.out.println(switchId.get(i));
				}*/
			 array_lk.transfer();//get the strorage of link   ArrayList<link> lk
			 temp=new NodePortTuple();
			 temp.src_portId =getPort(map_host(src_host));
			 System.out.println("nihao shijie!");
			 //java.util.Iterator<link_path> iterators = array_lk.lk.iterator();
			 System.out.println(String.valueOf(path_length));
			 
			 for(int i=0;i<path_length;i++)
				{
				 System.out.println("lalalalallalalalall");
					System.out.println(switchId.get(i));
				}
			 
			 
			 
			 for(int i=0;i<path_length;i++)
			 {
				
				 temp.nodeId =switchId.get(i);
				 
				 System.out.println( temp.nodeId);
				 if(i!=path_length-1)
				 {
                    for(int j=0;j<link_path.lk.size();j++)
                	{
                        System.out.println("["+link_path.lk.get(j).left_switchId+"  "+link_path.lk.get(j).right_switchId+"]");
                        System.out.println("["+switchId.get(i)+"  "+switchId.get(i+1)+"]");
                		if(link_path.lk.get(j).left_switchId .equals(switchId.get(i))&&link_path.lk.get(j).right_switchId .equals(switchId.get(i+1)))
                		{

                			temp.dst_portId =link_path.lk.get(j).left_port ;
                			route.add(temp);
                			System.out.println("["+temp.nodeId+","+temp.src_portId +","+temp.dst_portId +"]"+"\n");
                			temp=new NodePortTuple();
                			temp.src_portId=link_path.lk.get(j).right_port;
                			break;
                			
                		}
                		else if(link_path.lk.get(j).right_switchId .equals(switchId.get(i))&&link_path.lk.get(j).left_switchId .equals(switchId.get(i+1)))
                				
                				{
                			temp.dst_portId =link_path.lk.get(j).right_port ;
                			route.add(temp);
                			System.out.println("["+temp.nodeId+","+temp.src_portId +","+temp.dst_portId +"]"+"\n");
                			temp=new NodePortTuple();
                			temp.src_portId=link_path.lk.get(j).left_port;
                			break;
                				}
                	}
              }
				 
			 }
			
			 temp.dst_portId=getPort(map_host(dst_host));
			 route.add(temp);
			 System.out.println("["+temp.nodeId+","+temp.src_portId +","+temp.dst_portId +"]"+"\n");
			 
			 
	}
		catch (JSONException e) 
		   { 
			e.printStackTrace();
		   }
	    
		
	}
	public static void showPutle()//show tuple
	{

		for(int i=0;i<route.size();i++)
		{

			System.out.println("["+route.get(i).nodeId+"  "+route.get(i).src_portId+"  "+route.get(i).dst_portId+"]");
		}
	}
	public void srategy()
	{
            Flow flow;
            Flow flow2;
            flowop send;
            String status;
            System.out.println(String.valueOf(route.size()));
            for(int i=0;i<route.size();i++)
            {
                   flow=new Flow();
                   send=new flowop();
                   status=new String();
                   flow.name="flowmod1_"+i;
                   flow.hardTimeOut=String.valueOf(360);
                   flow.idleTimeOut=String.valueOf(360);
                   flow.active="true";
                   flow.sw=route.get(i).nodeId;
                   System.out.println("[Flow]"+route.get(i).nodeId);
                   
                   flow.IngressPort=route.get(i).src_portId;
                   System.out.println("[Flow]"+route.get(i).src_portId);
                   
                   flow.actions="output="+route.get(i).dst_portId;
                   System.out.println("[Flow]"+route.get(i).dst_portId);
                   //flow.priority=String.valueOf(Math.rint(65536/(i+1)));
                   flow.priority=String.valueOf(32767-i);
                   
                   flow2=new Flow();
                   flow2.name="flowmod2_"+i;
                   flow2.hardTimeOut=String.valueOf(360);
                   flow2.idleTimeOut=String.valueOf(360);
                   flow2.active="true";
                   flow2.sw=route.get(i).nodeId;
                   System.out.println("[Flow]"+route.get(i).nodeId);
                   
                   flow2.IngressPort=route.get(i).dst_portId;
                   System.out.println("[Flow]"+route.get(i).dst_portId);
                   
                   flow2.actions="output="+route.get(i).src_portId;
                   System.out.println("[Flow]"+route.get(i).src_portId);
                   //flow.priority=String.valueOf(Math.rint(65536/(i+1)));
                   flow2.priority=String.valueOf(32767-i);

                   try {
					status=send.push(flow);
					System.out.println("[Flow]"+status);
					status=send.push(flow2);
					System.out.println("[Flow]"+status);
				} catch (IOException | JSONException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
            	
            }
	}
}
