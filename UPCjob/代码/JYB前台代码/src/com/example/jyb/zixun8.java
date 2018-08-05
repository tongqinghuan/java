package com.example.jyb;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.json.JSONArray;
import org.json.JSONObject;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;
public class zixun8 extends Activity{
	int width;
	int height;
	List <Xuanj> searchresult=new ArrayList <Xuanj> ();
	ListView list;
	//private List<Map<String, Object>> mData;
	 protected void onCreate(Bundle savedInstanceState) {
	        super.onCreate(savedInstanceState);
	        requestWindowFeature(Window.FEATURE_NO_TITLE);  
	        //设置全屏
	        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,   
	        		 WindowManager.LayoutParams.FLAG_FULLSCREEN); 
	        WindowManager wm = this.getWindowManager();
	        width = wm.getDefaultDisplay().getWidth();
	        height = wm.getDefaultDisplay().getHeight();
	        setContentView(R.layout.xuanjiang);
	        list=(ListView)findViewById (R.id.pubednews);
	        Intent in=getIntent();
	        List<Xuanj> Xuanj;
			try {
				Xuanj = parseJSON( in.getStringExtra("result"));

				System.out.println("ssssswwwwww"+Xuanj.size());
				for (int k=0;k<Xuanj.size();k++)
				{
					
					System.out.println("ssss");
					searchresult.add(Xuanj.get(k));
					
					//searchresult
					
				}
			} catch (Exception e) {
				// TODO Auto-generated catch block
				System.out.println("cccc"+e.getMessage());
				
				e.printStackTrace();
			}
			List<HashMap<String, Object>> data = new ArrayList<HashMap<String,Object>>();
        	for(Xuanj Xj : searchresult){
				HashMap<String, Object> item = new HashMap<String, Object>();
				item.put("招聘会主题", Xj.getTime()+Xj .getTitle());
				System.out.println("zzzrrzzz"+Xj.getContent());
				item.put("宣讲时间", Xj.getPub_time());
				//item.put("地点", "hhhhiiii");
			///	listurl.add(sessions.getuser());
				data.add(item);
			}
        	System.out.println("111zzzrrzzz"+data.size());
        	SimpleAdapter adapter = new SimpleAdapter(zixun8.this, data, R.layout.item1,
					new String[]{"招聘会主题","宣讲时间","地点"}, new int[]{R.id.title, R.id.timelength,R.id.address});
        	String[] arr = { "孙悟空", "猪八戒", "唐僧" };
    		ArrayAdapter<String> adapter1 = new ArrayAdapter<String>(this,
    			android.R.layout.simple_list_item_multiple_choice, arr);


			list.setAdapter(adapter);	
				
	        
	        
	 }
	 
	  private  List<Xuanj> parseJSON(String  json) throws Exception{
	  		List<Xuanj> list = new ArrayList<Xuanj>();
	  	
	  		JSONArray jsonArray = new JSONArray(json);
	  		for(int i = 0; i < jsonArray.length() ; i++){
	  			JSONObject jsonObject = jsonArray.getJSONObject(i);
	 
	  			String title = jsonObject.getString("title");
	  			String time = jsonObject.getString("time");
	  			
	  			String place = jsonObject.getString("place");
	  			String pub_time = jsonObject.getString("pub_time");
	  			String  content = jsonObject.getString("content");
	  			System.out.println("ddddddd"+pub_time);
	  			list.add(new Xuanj(title, time, place,pub_time,content));
	  	
	  		}
	  		return list;
	  	}
	    // ListView 中某项被选中后的逻辑 
	   // protected void onListItemClick(ListView l, View v, int position, long id) { 
	          
	        //Log.v("MyListView4-click", (String)mData.get(position).get("title")); 
	    //} 
	    //public void showInfo(){ 
	        /*new AlertDialog.Builder(this) 
	        .setTitle("我的listview") 
	        .setMessage("介绍...") 
	        .setPositiveButton("确定", new DialogInterface.OnClickListener() { 
	            @Override
	            public void onClick(DialogInterface dialog, int which) { 
	            } 
	        }) 
	        .show(); 
	          */ 
	   // }
	  
			//@Override
			//public View getView(int arg0, View arg1, ViewGroup arg2) {
				// TODO Auto-generated method stub
				//return null;
			//} 

	 @Override
	 public boolean onTouchEvent(MotionEvent event){
	 	//Toast.makeText(getApplicationContext(), "abc", 1).show();
	 	switch (event.getAction()){
	 	case MotionEvent.ACTION_DOWN:
	 	if (event.getY()<height/13&&event.getX()<width/7){
	 		this.finish();//返回键，返回到主界面
	 	}
	 	}
	 	return false;
	 }
}
