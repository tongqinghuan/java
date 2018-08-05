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
import android.widget.TextView;
import android.widget.Toast;

public class zhaopindetail extends Activity implements OnItemClickListener{
	int width;
	int height;
	List <job> searchresult=new ArrayList <job> ();
	ListView list;
	TextView titlet,salary,requr,des,time,addr,company,hangye,numb,guimo,xingzhi;
	 protected void onCreate(Bundle savedInstanceState) {
	        super.onCreate(savedInstanceState);
	        requestWindowFeature(Window.FEATURE_NO_TITLE);  
	        //设置全屏
	        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,   
	        		 WindowManager.LayoutParams.FLAG_FULLSCREEN); 
	        WindowManager wm = this.getWindowManager();
	        width = wm.getDefaultDisplay().getWidth();
	        height = wm.getDefaultDisplay().getHeight();
	        setContentView(R.layout.zhaopindetailnew);
Intent in=this.getIntent();
String title=in.getStringExtra("title");

titlet=(TextView)findViewById(R.id.title );
salary=(TextView)findViewById(R.id.salar );
//requr=(TextView)findViewById(R.id.r);
//des=(TextView)findViewById(R.id.d);
time=(TextView)findViewById(R.id.time);
addr=(TextView)findViewById(R.id.addr);
company=(TextView)findViewById(R.id.company);
hangye=(TextView)findViewById(R.id.hangye);
numb=(TextView)findViewById(R.id.numb);
guimo=(TextView)findViewById(R.id.guimo);
xingzhi=(TextView)findViewById(R.id.xingzhi);
requr=(TextView)findViewById(R.id.degree);
des=(TextView)findViewById(R.id.des);
titlet.setText(title);
salary.setText(in.getStringExtra("salary"));
numb.setText(in.getStringExtra("numb"));
//requr.setText(in.getStringExtra("requr"));
	        time.setText(in.getStringExtra("time"));
	        addr.setText(in.getStringExtra("addr"));
	        requr.setText(in.getStringExtra("requr"));
company.setText(in.getStringExtra("company"));
//requr.setText(in.getStringExtra("requr"));
	        hangye.setText(in.getStringExtra("hangye"));
	        numb.setText(in.getStringExtra("numb"));
	        des.setText(in.getStringExtra("des"));
guimo.setText(in.getStringExtra("guimo"));
//requr.setText(in.getStringExtra("requr"));

xingzhi.setText(in.getStringExtra("xingzhi"));
	       // time.setText("time");
	        addr.setText(in.getStringExtra("addr"));
//requr.setText(in.getStringExtra("des"));       
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
	 }

