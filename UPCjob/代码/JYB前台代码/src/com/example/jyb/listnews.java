package com.example.jyb;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONObject;










import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.Toast;

public class listnews extends Activity implements OnItemClickListener{
	int width;
	int height;
	List <job> searchresult=new ArrayList <job> ();
	ListView list;
	 List<job> jobs;
	 protected void onCreate(Bundle savedInstanceState) {
	        super.onCreate(savedInstanceState);
	        requestWindowFeature(Window.FEATURE_NO_TITLE);  
	        //设置全屏
	        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,   
	        		 WindowManager.LayoutParams.FLAG_FULLSCREEN); 
	        WindowManager wm = this.getWindowManager();
	        width = wm.getDefaultDisplay().getWidth();
	        height = wm.getDefaultDisplay().getHeight();
	        setContentView(R.layout.mainnews);
	        list=(ListView)findViewById (R.id.pubednews);
	        list.setOnItemClickListener(this);
	        Intent in=getIntent();

System.out.println("列表信息"+in.getStringExtra("result"));
//Toast.makeText(getApplicationContext(), "ss"+in.getStringExtra("result"), 1).show();
	      
			try {
				 
				jobs = parseJSON( in.getStringExtra("result"));

				System.out.println("ssssswwwwww"+jobs.size());
				for (int k=0;k<jobs.size();k++)
				{
					
					System.out.println("ssssswwwwww");
					searchresult.add(jobs.get(k));
					
					//searchresult
					
				}
			} catch (Exception e) {
				// TODO Auto-generated catch block
				
				System.out.println("11111aaaaa"+e.getMessage());
				e.printStackTrace();
			}
			List<HashMap<String, Object>> data = new ArrayList<HashMap<String,Object>>();
        	for(job job : searchresult){
				HashMap<String, Object> item = new HashMap<String, Object>();
				item.put("工作名称", job.getjobname());
				item.put("时间", job.getpublishtime());
				//item.put("name", sessions.getuser());
			///	listurl.add(sessions.getuser());
				data.add(item);
			}
        	SimpleAdapter adapter = new SimpleAdapter(listnews.this, data, R.layout.item1,
					new String[]{"工作名称","时间"}, new int[]{R.id.title, R.id.timelength});
			list.setAdapter(adapter);	
				
	        
	        
	 }
	 
	  private  List<job> parseJSON(String  json) throws Exception{
	  		List<job> list = new ArrayList<job>();
	  	
	  		
	  		JSONArray jsonArray = new JSONArray(json);
	  		for(int i = 0; i < jsonArray.length() ; i++){
	  			JSONObject jsonObject = jsonArray.getJSONObject(i);
	  			String  content = jsonObject.getString("requirment");
	  			String title = jsonObject.getString("jobnam");
	  			String name = jsonObject.getString("jobsalary");
	  			//String tell = jsonObject.getString("descript");
	  			
	  			String kind = jsonObject.getString("time");
	  			list.add(new job(title, name, content," ",kind));
	  	
	  		}
	  		return list;
	  	}
	 @Override
	 public boolean onTouchEvent(MotionEvent event){
	 	//Toast.makeText(getApplicationContext(), "abc", 1).show();
	 	switch (event.getAction()){
	 	case MotionEvent.ACTION_DOWN:
	 	if (event.getY()<height/13&&event.getX()<width/7){
	 		this.finish();//返回键，返回到职位搜索界面
	 	}
	 	if (event.getY()>height/51&&event.getY()<height*4/51&&event.getX()>width*25/29&&event.getX()<width*27/29)
	 	{
	 		Intent zhuce =new Intent (this.getApplicationContext(),Zhuce.class);
	 		startActivity (zhuce);//按删除将选中的记录回收到垃圾桶里
	 	}
	 	}
	 	return false;
	 }

	@Override
	public void onItemClick(AdapterView<?> arg0, View arg1, int arg2, long arg3) {
		// TODO Auto-generated method stub
		Intent in=new Intent (this.getApplicationContext(),newsdetail.class);
		System.out.println("ssooossuus"+jobs.get(arg2).getsalary());
	in.putExtra("titil", jobs.get(arg2).getjobname());
	in.putExtra("salary", jobs.get(arg2).getsalary()+jobs.get(arg2).getrequir());
	in.putExtra("requr", jobs.get(arg2).getrequir());
	in.putExtra("des", jobs.get(arg2).getrequir());
		startActivity (in);
	//	System.out.println("aa");
		
	}
	 }

