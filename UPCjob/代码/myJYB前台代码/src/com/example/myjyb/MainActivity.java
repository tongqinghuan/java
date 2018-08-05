package com.example.myjyb;

import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;
import java.util.Timer;
import java.util.TimerTask;

import android.support.v7.app.ActionBarActivity;
import android.support.v7.app.ActionBar;
import android.support.v4.app.Fragment;
import android.app.AlertDialog;
import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.os.StrictMode;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import android.os.Build;

public class MainActivity extends ActionBarActivity implements OnClickListener{
	int width;
	int height;
	AlertDialog  builder3;
	EditText key;
	Button sure,cancel;
	int count=0;
	Timer timer;
	int countstate=0;
	String messa;
	int state=0;
	private NotificationManager nm;  
	  private PendingIntent pd;  
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
	        setContentView(R.layout.activity_main);//Activity采用R.layout下的main布局文件进行布局
	       
	        StrictMode.setThreadPolicy(new StrictMode.ThreadPolicy.Builder().detectDiskReads().detectDiskWrites().detectNetwork().penaltyLog().build());
	        StrictMode.setVmPolicy(new StrictMode.VmPolicy.Builder().detectLeakedSqlLiteObjects().detectLeakedClosableObjects().penaltyLog().penaltyDeath().build());
	       
	        //if (savedInstanceState == null) {
	           // getSupportFragmentManager().beginTransaction()
	                    //.add(R.id.container, new PlaceholderFragment()).commit();
	       // }
	        
	        final Handler myHandler = new Handler() {  
	            public void handleMessage(Message msg) {
	            	if (msg.what==222){
	            
	            	
	            		
	            	try {
	            		
	            		
	            		System.out.println("qqqqqqqqqqqqqq");
	            		if (state==0){
	            			state=9;
	    				
	    				System.out.println("有心数据返回");
	    				
	            		}
	    			} catch (Exception e) {
	    				// TODO Auto-generated catch block
	    				e.printStackTrace();
	    			}

	            		
	            		
	            		
	            	
	            		
	            	//	kk("ssss");
	            	}
	            	
	            }   
	       };  
	       TimerTask task = new TimerTask(){  
	           public void run() {
	        	 
	        Message msg=new Message ();
	        msg.what=222;
	        myHandler.sendMessage(msg)
	        ;
	        
	        try {
	    		//pollgetjob("");
	    	} catch (Exception e) {
	    		// TODO Auto-generated catch block
	    		e.printStackTrace();
	    	}
	        System.out.println("ddddddd");
	    }  
	     };  
	      timer = new Timer(true);
	    timer.schedule(task,5000, 10000); //延时3000ms后执行，1000ms执行一次
	    //pd = PendingIntent.getActivity(MainActivity.this, 0, intent, 0);  


	    }
	
    
	  public  int pollgetjob(String userid) throws Exception{
	    	String path = "http://192.168.191.1:8080/job/servlet/getjobserv";
	    	Map<String, String> params = new HashMap<String, String>();
	    	params.put("id", userid);
	    	//params.put("password", password);
		//	System.out.println("qqqqqqqqqqqqqq");
	    	return  sendPOSTRequest(path, params, "UTF-8");
	    }
	  public  int getnews(String userid) throws Exception{
	    	String path = "http://192.168.191.1:8080/job/servlet/servlatenew";
	    	Map<String, String> params = new HashMap<String, String>();
	    	params.put("id", userid);
	    	//params.put("password", password);
		//	System.out.println("qqqqqqqqqqqqqq");
	    	return  getjobsendPOSTRequest(path, params, "UTF-8",1);
	    }



	private  int sendPOSTRequest(String path, Map<String, String> params, String encoding) throws Exception{
			//  title=liming&length=30
			StringBuilder sb = new StringBuilder();
			int res=0;
			if(params!=null && !params.isEmpty()){
				for(Map.Entry<String, String> entry : params.entrySet()){
					sb.append(entry.getKey()).append("=");
					sb.append(URLEncoder.encode(entry.getValue(), encoding));
					sb.append("&");
				}
				sb.deleteCharAt(sb.length() - 1);
			}
			byte[] data = sb.toString().getBytes();
			
			HttpURLConnection conn = (HttpURLConnection) new URL(path).openConnection();
			conn.setConnectTimeout(5000);
			conn.setRequestMethod("POST");
			conn.setDoOutput(true);//允许对外传输数据
			conn.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
			conn.setRequestProperty("Content-Length", data.length+"");
			try {
			OutputStream outStream = conn.getOutputStream();
			outStream.write(data);
			outStream.flush();
			}catch (Exception e){
				
				e.printStackTrace();
				
			}
			if(conn.getResponseCode() == 200){
				InputStream in=conn.getInputStream();
				 int count = 0;
				  while (count == 0) {
				   count = in.available();
				  }
				  byte[] b = new byte[count+1];
				  in.read(b);
					System.out.println("eeeeeqqqqqqqqqqqqqq");
				  String tempstr=new String (b);
				  System.out.println ("返回数据"+new String (b));
				  if (countstate==0){
					 messa=new String (tempstr);
				  kk ("jjjjj");
				  countstate=9;
				  
				  
				  }
		//	Intent 	in=new Intent(this.getApplicationContext(),listjob);
				  
				  //Toast.makeText(getApplicationContext(), "saaaaaaa"+tempstr, 1).show();
				  if (tempstr.contains("success")){
					  
					  String str[]=tempstr.split(",");
					  for (int k=0;k<str.length;k++)
					  
					  {
						 // pamara.add(str[k]);
						  
						  System.out.println("数据解析后"+str[k]);
					  }
					  return 1;
					  
					  
				  }else 
					  return  2;			}
			return 3;
		}


void  kk (String  msg){          //新建状态栏通知  
	
	nm = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);  

	Intent intent = new Intent(this,listjob.class);  
	  System.out.println("qqqq"+messa);
	  intent.putExtra("result", messa);
	pd = PendingIntent.getActivity(MainActivity.this, 0, intent, 0);
	Notification baseNF;  
	
    baseNF = new Notification();  
    
    //设置通知在状态栏显示的图标  
    baseNF.icon = R.drawable.ic_launcher;  
      
    //通知时在状态栏显示的内容  
    baseNF.tickerText = "有新消息到达!";  
      
    //通知的默认参数 DEFAULT_SOUND, DEFAULT_VIBRATE, DEFAULT_LIGHTS.   
    //如果要全部采用默认值, 用 DEFAULT_ALL.  
    //此处采用默认声音  
    baseNF.defaults |= Notification.DEFAULT_SOUND;  
    baseNF.defaults |= Notification.DEFAULT_VIBRATE;  
    baseNF.defaults |= Notification.DEFAULT_LIGHTS;  
      
    //让声音、振动无限循环，直到用户响应  
  //  baseNF.flags |= Notification.FLAG_INSISTENT;  
      
    //通知被点击后，自动消失  
    baseNF.flags |= Notification.FLAG_AUTO_CANCEL;  
      
    //点击'Clear'时，不清楚该通知(QQ的通知无法清除，就是用的这个)  
    baseNF.flags |= Notification.FLAG_NO_CLEAR;  
      
    long[] vir = {0,100,200,300};  
  baseNF.vibrate = vir;  
  System.out.println("消息，到达！！！！！");
    //第二个参数 ：下拉状态栏时显示的消息标题 expanded message title  
    //第三个参数：下拉状态栏时显示的消息内容 expanded message text  
    //第四个参数：点击该通知时执行页面跳转  
    baseNF.setLatestEventInfo(MainActivity.this, "有工作更新", msg, pd);  
    System.out.println("消息，到达！！！！！");
    //发出状态栏通知  
    //The first parameter is the unique ID for the Notification   
    // and the second is the Notification object.  
    nm.notify(110, baseNF);
    System.out.println("消息，到达！！！！！");
    }


	@Override
	public boolean onCreateOptionsMenu(Menu menu) {

		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}


    private void searchdialog() {
    	LayoutInflater layoutInflater = getLayoutInflater();
    	View linearlayout = layoutInflater.inflate(R.layout.dialogsearch, null);

    	key = (EditText)linearlayout.findViewById(R.id.d2_et1); 

    sure = (Button)linearlayout.findViewById(R.id.d5_bt1); 
    cancel = (Button)linearlayout.findViewById(R.id.d5_bt2);
    	builder3 = new AlertDialog.Builder(this).setIcon(R.drawable.ic_launcher).setTitle("搜索信息对话框").setView(linearlayout).show();


    	   sure.setOnClickListener(this);
    	   cancel.setOnClickListener(this);
    }
	 @Override
		public
		boolean onTouchEvent(MotionEvent event){
			switch (event.getAction()){
			case MotionEvent.ACTION_DOWN:
			if (event.getY()<height/9&&event.getX()>width*4/5){
				Intent in =new Intent();
				in.setClass(MainActivity.this,Login.class);
				startActivity (in);//跳转到登陆界面
				//Intent in =new Intent (this.getApplicationContext(),login.class);
				//startActivity (in);
			//System.out.println ("denglu");
			//Toast.makeText(getApplicationContext(), "登陆", 1).show();
			}
			if (event.getY()>height*7/13&&event.getY()<height*9/13&&event.getX()>width/7&&event.getX()<width*3/7)
			{
				Intent search =new Intent();
				searchdialog();
				search.setClass(MainActivity.this,Search.class);
				//startActivity (search);//跳转到职位搜索界面
	
				//Toast.makeText(getApplicationContext(), "trst", 1).show();
			}
			if (event.getY()>height*7/13&&event.getY()<height*9/13&&event.getX()>width*9/14&&event.getX()<width*6/7)
			{int res;
			
				Intent xuanjiang =new Intent();
				xuanjiang.setClass(MainActivity.this,Xuanjiang.class);
				try {
					res=getxuanjiang("sss");
					System.out.println("322"+res);
					if(res==1){
						System.out.println("111");					}
				} catch (Exception e) {
					System.out.println("222");
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				//startActivity (xuanjiang);//跳转到校园宣讲界面
				//Toast.makeText(getApplicationContext(), "tste", 1).show();
			}
			if (event.getY()>height*17/26&&event.getY()<height*21/26&&event.getX()>width/7&&event.getX()<width*3/7)
			{
				Intent myjyb =new Intent();
				myjyb.setClass(MainActivity.this,Myjyb.class);
				startActivity (myjyb);//跳转到MY就业帮界面
				//Toast.makeText(getApplicationContext(), "trste", 1).show();
			}
			if (event.getY()>height*17/26&&event.getY()<height*21/26&&event.getX()>width*4/7&&event.getX()<width*6/7)
			{
				Intent zixun =new Intent (this.getApplicationContext(),Profession_zixun.class);
				startActivity (zixun);//跳转到职场咨询界面
				
			}
			if (event.getY()>height*4/26&&event.getY()<height*7/26&&event.getX()>width*1/7&&event.getX()<width*3/7)
			{
				int res=0;
				
				try {
					res=getnews("aaa");
					System.out.println("456"+res);
					if(res==1){
						Intent in=new Intent(this.getApplicationContext(),listjob.class);
						//startActivity(in);
					}
				} catch (Exception e) {
					System.out.println("123"+e.getMessage());
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				Intent zixun =new Intent (this.getApplicationContext(),Profession_zixun.class);
				//startActivity (zixun);//跳转到职场咨询界面
			//	Toast.makeText(getApplicationContext(), "zuoxinxiaoxi", 1).show();
			}
			}
			return false;
		}
	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == R.id.action_settings) {
			return true;
		}
		return super.onOptionsItemSelected(item);
	}

	/**
	 * A placeholder fragment containing a simple view.
	 */
	public static class PlaceholderFragment extends Fragment {

		public PlaceholderFragment() {
		}

		@Override
		public View onCreateView(LayoutInflater inflater, ViewGroup container,
				Bundle savedInstanceState) {
			View rootView = inflater.inflate(R.layout.fragment_main, container,
					false);
			return rootView;
		}
	}

	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		switch(v.getId()){
		case R.id.d5_bt1:
			try {
				if (getjob(key.getText().toString())==1){
					;
				}
			} catch (Exception e) {
				// TODO Auto-generated catch block
				
				Toast.makeText(getApplicationContext(), "连接"+e.getMessage(), 1).show();
				
				e.printStackTrace();
			}
			break;

		case R.id.d5_bt2:
			builder3.cancel();
			break;
		}
	}
	public  int getjob(String userid) throws Exception{
    	String path = "http://192.168.191.1:8080/job/servlet/getjobserv";
    	Map<String, String> params = new HashMap<String, String>();
    	params.put("id", userid);
    	
    	//params.put("password", password);
    	return getjobsendPOSTRequest(path, params, "UTF-8",1);
    }

    private  int getjobsendPOSTRequest(String path, Map<String, String> params, String encoding,int kind) throws Exception{
    	//  title=liming&length=30
    	StringBuilder sb = new StringBuilder();
    	if(params!=null && !params.isEmpty()){
    		for(Map.Entry<String, String> entry : params.entrySet()){
    			sb.append(entry.getKey()).append("=");
    			sb.append(URLEncoder.encode(entry.getValue(), encoding));
    			sb.append("&");
    		}
    		sb.deleteCharAt(sb.length() - 1);
    	}
    	byte[] data = sb.toString().getBytes();
    	
    	HttpURLConnection conn = (HttpURLConnection) new URL(path).openConnection();
    	conn.setConnectTimeout(5000);
    	conn.setRequestMethod("POST");
    	//conn.setDoOutput(true);//允许对外传输数据
    	conn.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
    	conn.setRequestProperty("Content-Length", data.length+"");
    	//Toast.makeText(getBaseContext(), "ssss", 1).show();
    	OutputStream outStream = conn.getOutputStream();
    	outStream.write(data);
    	outStream.flush();
	
    	if(conn.getResponseCode() == 200){
    		InputStream in=conn.getInputStream();
    		 int count = 0;
    		  while (count == 0) {
    		   count = in.available();
    		  }
    			System.out.println("qqqqqqqqaaaaaaaaaaaaqqqqqqqqqqqq");
    		  byte[] b = new byte[count];
    		  in.read(b);
    		String temp=new String (b);
    		
    		if (temp.contains("failed")){
    			//Toast.makeText(getApplicationContext(), "www无相关信息", 1).show();
    			 System.out.println ("无相关信息"+new String (b));
    			return 2;
    			
    		}else {
    			System.out.println ("返回数据"+new String (b));
    			//Toast.makeText(getApplicationContext(), "www无相关信uuuu息"+temp, 1).show();
        		
    			Intent in1=new Intent (this.getApplicationContext(),listjob.class);
    			in1.putExtra("result", temp);
    			startActivity (in1);
    			System.out.println ("返回数据"+new String (b));
    			//List <session> searchresult=new ArrayList <session> ();
    			
    					return 1;

    			//return 1;
    		}
    		//  System.out.println ("返回数据"+new String (b));
    		
    	}
    	return 3;
    }
    public  int getxuanjiang(String userid) throws Exception{
    	String path = "http://192.168.191.1:8080/job/servlet/Xuanjiang";
    	Map<String, String> params = new HashMap<String, String>();
    	params.put("id", userid);
    	
    	//params.put("password", password);
    	return getxuanjiangsendPOSTRequest(path, params, "UTF-8",1);
    }
    private  int getxuanjiangsendPOSTRequest(String path, Map<String, String> params, String encoding,int kind) throws Exception{
    	//  title=liming&length=30
    	StringBuilder sb = new StringBuilder();
    	if(params!=null && !params.isEmpty()){
    		for(Map.Entry<String, String> entry : params.entrySet()){
    			sb.append(entry.getKey()).append("=");
    			sb.append(URLEncoder.encode(entry.getValue(), encoding));
    			sb.append("&");
    		}
    		sb.deleteCharAt(sb.length() - 1);
    	}
    	byte[] data = sb.toString().getBytes();
    	
    	HttpURLConnection conn = (HttpURLConnection) new URL(path).openConnection();
    	conn.setConnectTimeout(5000);
    	conn.setRequestMethod("POST");
    	//conn.setDoOutput(true);//允许对外传输数据
    	conn.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
    	conn.setRequestProperty("Content-Length", data.length+"");
    	//Toast.makeText(getBaseContext(), "ssss", 1).show();
    	OutputStream outStream = conn.getOutputStream();
    	outStream.write(data);
    	outStream.flush();
	
    	if(conn.getResponseCode() == 200){
    		InputStream in=conn.getInputStream();
    		 int count = 0;
    		  while (count == 0) {
    		   count = in.available();
    		  }
    			System.out.println("qqqqqqqqaaaaaaaaaaaaqqqqqqqqqqqq");
    		  byte[] b = new byte[count];
    		  in.read(b);
    		String temp=new String (b);
    		
    		if (temp.contains("failed")){
    			//Toast.makeText(getApplicationContext(), "www无相关信息", 1).show();
    			 System.out.println ("无相关信息"+new String (b));
    			return 2;
    			
    		}else {
    			System.out.println ("返回数据"+new String (b));
    			//Toast.makeText(getApplicationContext(), "www无相关信uuuu息"+temp, 1).show();
        		
    			Intent in1=new Intent (this.getApplicationContext(),Xuanjiang.class);
    			in1.putExtra("result", temp);
    			startActivity (in1);
        	
    			//List <session> searchresult=new ArrayList <session> ();
    			
    					return 1;

    			//return 1;
    		}
    		//  System.out.println ("返回数据"+new String (b));
    		
    	}
    	return 3;
    }
    private  int getnewssendPOSTRequest(String path, Map<String, String> params, String encoding) throws Exception{
    	//  title=liming&length=30
    	StringBuilder sb = new StringBuilder();
    	if(params!=null && !params.isEmpty()){
    		for(Map.Entry<String, String> entry : params.entrySet()){
    			sb.append(entry.getKey()).append("=");
    			sb.append(URLEncoder.encode(entry.getValue(), encoding));
    			sb.append("&");
    		}
    		sb.deleteCharAt(sb.length() - 1);
    	}
    	byte[] data = sb.toString().getBytes();
    	
    	HttpURLConnection conn = (HttpURLConnection) new URL(path).openConnection();
    	conn.setConnectTimeout(5000);
    	conn.setRequestMethod("POST");
    	//conn.setDoOutput(true);//允许对外传输数据
    	conn.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
    	conn.setRequestProperty("Content-Length", data.length+"");
    	//Toast.makeText(getBaseContext(), "ssss", 1).show();
    	OutputStream outStream = conn.getOutputStream();
    	outStream.write(data);
    	outStream.flush();
	
    	if(conn.getResponseCode() == 200){
    		InputStream in=conn.getInputStream();
    		 int count = 0;
    		  while (count == 0) {
    		   count = in.available();
    		  }
    			System.out.println("qqqqqqqqaaaaaaaaaaaaqqqqqqqqqqqq");
    		  byte[] b = new byte[count];
    		  in.read(b);
    		String temp=new String (b);
    		
    		if (temp.contains("failed")){
    			//Toast.makeText(getApplicationContext(), "www无相关信息", 1).show();
    			 System.out.println ("无相关信息"+new String (b));
    			return 2;
    			
    		}else {
    			System.out.println ("返回数据"+new String (b));
    			//Toast.makeText(getApplicationContext(), "www无相关信uuuu息"+temp, 1).show();
        		
    			Intent in1=new Intent (this.getApplicationContext(),Xuanjiang.class);
    			in1.putExtra("result", temp);
    			startActivity (in1);
        	
    			//List <session> searchresult=new ArrayList <session> ();
    			
    					return 1;

    			//return 1;
    		}
    		//  System.out.println ("返回数据"+new String (b));
    		
    	}
    	return 3;
    }
  


}
