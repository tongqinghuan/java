package com.example.jyb;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONObject;












import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;
import android.widget.Toast;

public class newsdetail extends Activity implements OnItemClickListener ,OnClickListener{
	int width;
	int height;
	List <job> searchresult=new ArrayList <job> ();
	ListView list;
	TextView titlet,salary,requr,des;
	String url;
	 protected void onCreate(Bundle savedInstanceState) {
	        super.onCreate(savedInstanceState);
	        requestWindowFeature(Window.FEATURE_NO_TITLE);  
	        //设置全屏
	        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,   
	        		 WindowManager.LayoutParams.FLAG_FULLSCREEN); 
	        WindowManager wm = this.getWindowManager();
	        width = wm.getDefaultDisplay().getWidth();
	        height = wm.getDefaultDisplay().getHeight();
	        setContentView(R.layout.newsdetail);
Intent in=this.getIntent();
String title=in.getStringExtra("titil");
System.out.println("dddd"+title);
titlet=(TextView)findViewById(R.id.title);
salary=(TextView)findViewById(R.id.content);
//requr=(TextView)findViewById(R.id.req);
//des=(TextView)findViewById(R.id.des);
titlet.setText(title);
salary.setText(in.getStringExtra("salary"));
//requr.setText(in.getStringExtra("requr"));
	url=in.getStringExtra("requr")  ;      
//requr.setText(in.getStringExtra("des"));   
salary.setOnClickListener(this);
	 }
	 
	  private  List<job> parseJSON(String  json) throws Exception{
	  		List<job> list = new ArrayList<job>();
	  	
	  		
	  		JSONArray jsonArray = new JSONArray(json);
	  		for(int i = 0; i < jsonArray.length() ; i++){
	  			JSONObject jsonObject = jsonArray.getJSONObject(i);
	  			String  content = jsonObject.getString("requirment");
	  			String title = jsonObject.getString("jobnam");
	  			String name = jsonObject.getString("jobsalary");
	  			String tell = jsonObject.getString("descript");
	  			
	  			String kind = jsonObject.getString("time");
	  			list.add(new job(title, name, content,tell,kind));
	  	
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
		
		System.out.println("aa");
		
	}

	@Override
	public void onClick(View arg0) {
		
		 Intent intent = new Intent();        
	        intent.setAction("android.intent.action.VIEW");    
	        Uri content_url = Uri.parse(url);   
	        intent.setData(content_url);  
	        startActivity(intent);
		// TODO Auto-generated method stub
		
	}
	 }

