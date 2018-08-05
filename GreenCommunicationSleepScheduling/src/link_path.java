import java.util.ArrayList;

import org.json.JSONException;
import org.json.JSONObject;


public class link_path {
	public  String left_switchId;
	public  String left_port;
	public  String right_switchId;
	public  String right_port;
	public   static ArrayList<link_path> lk;
	public link_path tuple;
	public  void transfer() 
	
	{

		int length=0;
		lk=new ArrayList<link_path>(100);
		System.out.println("this is the second time  to get links");
		JSONObject links = topoGetter.topogetter();
		
		try {
			length = links.getJSONArray("links").length();
		} catch (JSONException e) {e.printStackTrace();}
		for(int i=0;i<length;i++)
		{
			tuple=new link_path();
			try {
				JSONObject temp=links.getJSONArray("links").getJSONObject(i);
				tuple.left_switchId =temp.getString("left");
				tuple.right_switchId=temp.getString("right");
				tuple.left_port=temp.getString("left-port");
				tuple.right_port=temp.getString("right-port");
				//System.out.println(tuple.left_switchId+tuple.right_switchId +tuple.left_port +tuple.right_port );
				lk.add( tuple);
				//System.out.println("["+lk.get(i).left_port+"  "+lk.get(i).left_switchId+"  "+lk.get(i).right_port+"  "+lk.get(i).right_switchId+"]");
			} catch (JSONException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			
			
		}
		System.out.println("hello sunshine!");
		for(int j=0;j<length;j++)
		{
      
			System.out.println(j+"the flow "+"["+lk.get(j).left_port+"  "+lk.get(j).left_switchId+"  "+lk.get(j).right_port+"  "+lk.get(j).right_switchId+"]");
		}
		System.out.println("hello world!");
		
	}
	}
