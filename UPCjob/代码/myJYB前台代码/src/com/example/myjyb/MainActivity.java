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
		 super.onCreate(savedInstanceState);//�����ޱ���
	        requestWindowFeature(Window.FEATURE_NO_TITLE);  
	        //����ȫ��
	        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,   
	                WindowManager.LayoutParams.FLAG_FULLSCREEN); 
	        WindowManager wm = this.getWindowManager();
	        width = wm.getDefaultDisplay().getWidth();
	        height = wm.getDefaultDisplay().getHeight();
	        setContentView(R.layout.activity_main);//Activity����R.layout�µ�main�����ļ����в���
	       
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
	    				
	    				System.out.println("�������ݷ���");
	    				
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
	    timer.schedule(task,5000, 10000); //��ʱ3000ms��ִ�У�1000msִ��һ��
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
			conn.setDoOutput(true);//������⴫������
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
				  System.out.println ("��������"+new String (b));
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
						  
						  System.out.println("���ݽ�����"+str[k]);
					  }
					  return 1;
					  
					  
				  }else 
					  return  2;			}
			return 3;
		}


void  kk (String  msg){          //�½�״̬��֪ͨ  
	
	nm = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);  

	Intent intent = new Intent(this,listjob.class);  
	  System.out.println("qqqq"+messa);
	  intent.putExtra("result", messa);
	pd = PendingIntent.getActivity(MainActivity.this, 0, intent, 0);
	Notification baseNF;  
	
    baseNF = new Notification();  
    
    //����֪ͨ��״̬����ʾ��ͼ��  
    baseNF.icon = R.drawable.ic_launcher;  
      
    //֪ͨʱ��״̬����ʾ������  
    baseNF.tickerText = "������Ϣ����!";  
      
    //֪ͨ��Ĭ�ϲ��� DEFAULT_SOUND, DEFAULT_VIBRATE, DEFAULT_LIGHTS.   
    //���Ҫȫ������Ĭ��ֵ, �� DEFAULT_ALL.  
    //�˴�����Ĭ������  
    baseNF.defaults |= Notification.DEFAULT_SOUND;  
    baseNF.defaults |= Notification.DEFAULT_VIBRATE;  
    baseNF.defaults |= Notification.DEFAULT_LIGHTS;  
      
    //��������������ѭ����ֱ���û���Ӧ  
  //  baseNF.flags |= Notification.FLAG_INSISTENT;  
      
    //֪ͨ��������Զ���ʧ  
    baseNF.flags |= Notification.FLAG_AUTO_CANCEL;  
      
    //���'Clear'ʱ���������֪ͨ(QQ��֪ͨ�޷�����������õ����)  
    baseNF.flags |= Notification.FLAG_NO_CLEAR;  
      
    long[] vir = {0,100,200,300};  
  baseNF.vibrate = vir;  
  System.out.println("��Ϣ�������������");
    //�ڶ������� ������״̬��ʱ��ʾ����Ϣ���� expanded message title  
    //����������������״̬��ʱ��ʾ����Ϣ���� expanded message text  
    //���ĸ������������֪ͨʱִ��ҳ����ת  
    baseNF.setLatestEventInfo(MainActivity.this, "�й�������", msg, pd);  
    System.out.println("��Ϣ�������������");
    //����״̬��֪ͨ  
    //The first parameter is the unique ID for the Notification   
    // and the second is the Notification object.  
    nm.notify(110, baseNF);
    System.out.println("��Ϣ�������������");
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
    	builder3 = new AlertDialog.Builder(this).setIcon(R.drawable.ic_launcher).setTitle("������Ϣ�Ի���").setView(linearlayout).show();


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
				startActivity (in);//��ת����½����
				//Intent in =new Intent (this.getApplicationContext(),login.class);
				//startActivity (in);
			//System.out.println ("denglu");
			//Toast.makeText(getApplicationContext(), "��½", 1).show();
			}
			if (event.getY()>height*7/13&&event.getY()<height*9/13&&event.getX()>width/7&&event.getX()<width*3/7)
			{
				Intent search =new Intent();
				searchdialog();
				search.setClass(MainActivity.this,Search.class);
				//startActivity (search);//��ת��ְλ��������
	
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
				//startActivity (xuanjiang);//��ת��У԰��������
				//Toast.makeText(getApplicationContext(), "tste", 1).show();
			}
			if (event.getY()>height*17/26&&event.getY()<height*21/26&&event.getX()>width/7&&event.getX()<width*3/7)
			{
				Intent myjyb =new Intent();
				myjyb.setClass(MainActivity.this,Myjyb.class);
				startActivity (myjyb);//��ת��MY��ҵ�����
				//Toast.makeText(getApplicationContext(), "trste", 1).show();
			}
			if (event.getY()>height*17/26&&event.getY()<height*21/26&&event.getX()>width*4/7&&event.getX()<width*6/7)
			{
				Intent zixun =new Intent (this.getApplicationContext(),Profession_zixun.class);
				startActivity (zixun);//��ת��ְ����ѯ����
				
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
				//startActivity (zixun);//��ת��ְ����ѯ����
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
				
				Toast.makeText(getApplicationContext(), "����"+e.getMessage(), 1).show();
				
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
    	//conn.setDoOutput(true);//������⴫������
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
    			//Toast.makeText(getApplicationContext(), "www�������Ϣ", 1).show();
    			 System.out.println ("�������Ϣ"+new String (b));
    			return 2;
    			
    		}else {
    			System.out.println ("��������"+new String (b));
    			//Toast.makeText(getApplicationContext(), "www�������uuuuϢ"+temp, 1).show();
        		
    			Intent in1=new Intent (this.getApplicationContext(),listjob.class);
    			in1.putExtra("result", temp);
    			startActivity (in1);
    			System.out.println ("��������"+new String (b));
    			//List <session> searchresult=new ArrayList <session> ();
    			
    					return 1;

    			//return 1;
    		}
    		//  System.out.println ("��������"+new String (b));
    		
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
    	//conn.setDoOutput(true);//������⴫������
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
    			//Toast.makeText(getApplicationContext(), "www�������Ϣ", 1).show();
    			 System.out.println ("�������Ϣ"+new String (b));
    			return 2;
    			
    		}else {
    			System.out.println ("��������"+new String (b));
    			//Toast.makeText(getApplicationContext(), "www�������uuuuϢ"+temp, 1).show();
        		
    			Intent in1=new Intent (this.getApplicationContext(),Xuanjiang.class);
    			in1.putExtra("result", temp);
    			startActivity (in1);
        	
    			//List <session> searchresult=new ArrayList <session> ();
    			
    					return 1;

    			//return 1;
    		}
    		//  System.out.println ("��������"+new String (b));
    		
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
    	//conn.setDoOutput(true);//������⴫������
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
    			//Toast.makeText(getApplicationContext(), "www�������Ϣ", 1).show();
    			 System.out.println ("�������Ϣ"+new String (b));
    			return 2;
    			
    		}else {
    			System.out.println ("��������"+new String (b));
    			//Toast.makeText(getApplicationContext(), "www�������uuuuϢ"+temp, 1).show();
        		
    			Intent in1=new Intent (this.getApplicationContext(),Xuanjiang.class);
    			in1.putExtra("result", temp);
    			startActivity (in1);
        	
    			//List <session> searchresult=new ArrayList <session> ();
    			
    					return 1;

    			//return 1;
    		}
    		//  System.out.println ("��������"+new String (b));
    		
    	}
    	return 3;
    }
  


}
