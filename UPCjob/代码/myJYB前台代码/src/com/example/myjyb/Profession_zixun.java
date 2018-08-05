package com.example.myjyb;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONObject;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MotionEvent;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ListView;
import android.widget.SimpleAdapter;
public class Profession_zixun extends Activity{
	int width;
	int height;
	List <Zixun> searchresult=new ArrayList <Zixun> ();
	ListView list;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);//设置无标题
        requestWindowFeature(Window.FEATURE_NO_TITLE);  
        //设置全屏
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,   
                WindowManager.LayoutParams.FLAG_FULLSCREEN); 
        WindowManager wm = this.getWindowManager();
        width = wm.getDefaultDisplay().getWidth();
        height = wm.getDefaultDisplay().getHeight();
        setContentView(R.layout.profession_zixun);//Activity采用R.layout下的main布局文件进行布局
        list=(ListView)findViewById (R.id.pubednews);
        Intent in=getIntent();
        List<Zixun> Zixun;
		try {
			Zixun = parseJSON( in.getStringExtra("result"));

			System.out.println("sssww"+Zixun.size());
			for (int k=0;k<Zixun.size();k++)
			{
				
				System.out.println("ssss");
				searchresult.add(Zixun.get(k));
				
				//searchresult
				
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		List<HashMap<String, Object>> data = new ArrayList<HashMap<String,Object>>();
    	for(Zixun zixun : searchresult){
			HashMap<String, Object> item = new HashMap<String, Object>();
			item.put("咨讯类型",zixun .getType());
			item.put("咨讯主题",zixun .getTitle());
			item.put("发布时间", zixun.getPub_time());
			//item.put("name", sessions.getuser());
		///	listurl.add(sessions.getuser());
			data.add(item);
		}
    	SimpleAdapter adapter = new SimpleAdapter(Profession_zixun.this, data, R.layout.profession_zixun,
				new String[]{"咨讯类型","咨讯主题","发布时间"}, new int[]{R.id.title, R.id.timelength});
		list.setAdapter(adapter);	
			
        
        
 }
 
  private  List<Zixun> parseJSON(String  json) throws Exception{
  		List<Zixun> list = new ArrayList<Zixun>();
  	
  		JSONArray jsonArray = new JSONArray(json);
  		for(int i = 0; i < jsonArray.length() ; i++){
  			JSONObject jsonObject = jsonArray.getJSONObject(i);
 
  			String title = jsonObject.getString("title");
  			String type = jsonObject.getString("type");
  			String  content = jsonObject.getString("content");
 			String pub_time = jsonObject.getString("pub_time");
  			list.add(new Zixun(title, type,content,pub_time));
  	
  		}
  		return list;
    }
    @Override
   	public
   	boolean onTouchEvent(MotionEvent event){
   		switch (event.getAction()){
   		case MotionEvent.ACTION_DOWN:
   			if (event.getY()>height/51&&event.getY()<height*4/51&&event.getX()>width/29&&event.getX()<width*3/29){
   				this.finish();//返回键，返回到主界面
   			}
   			if (event.getY()>height*2/17&&event.getY()<height*3/17&&event.getX()>width*2/29&&event.getX()<width*26/29)
   			{
   				//输入搜索职位关键字
   			}
   			}
   			return false;
   		}
   		}
