package com.example.jyb;

import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.os.StrictMode;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnFocusChangeListener;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Login extends Activity implements OnClickListener{
	int width;
	int height;
	Dialog builder3;
	EditText name,pass;
	Button sure,cancel;
	ProgressDialog m_pDialog;
    ArrayList pamara=new ArrayList ();
	 protected void onCreate(Bundle savedInstanceState) {
	        super.onCreate(savedInstanceState);
	        requestWindowFeature(Window.FEATURE_NO_TITLE);  
	        //设置全屏
	        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,   
	        		 WindowManager.LayoutParams.FLAG_FULLSCREEN); 
	        WindowManager wm = this.getWindowManager();
           width = wm.getDefaultDisplay().getWidth();
	        height = wm.getDefaultDisplay().getHeight();
	        setContentView(R.layout.login);
	       // dialog3();//弹出提示框
	        StrictMode.setThreadPolicy(new StrictMode.ThreadPolicy.Builder().detectDiskReads().detectDiskWrites().detectNetwork().penaltyLog().build());
	        StrictMode.setVmPolicy(new StrictMode.VmPolicy.Builder().detectLeakedSqlLiteObjects().detectLeakedClosableObjects().penaltyLog().penaltyDeath().build());
	
	        final EditText editText1 = (EditText) findViewById(R.id.editText02);
	        final String string = editText1.getHint().toString();
	       // AbsoluteSizeSpan ass = new AbsoluteSizeSpan(8, true);     
	     // 附加属性到文本
	       // ( editText1).setSpan(ass, 0, editText1.length(), Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
	     // 设置hint
	    // editText1.setHint(new SpannedString(editText1)); // 一定要进行转换,否则属性会消失
	        editText1.setOnFocusChangeListener(new OnFocusChangeListener(){
	            @Override
	            public void onFocusChange(View arg0, boolean hasFocus) {
	                if(hasFocus){
	                    editText1.setText("");
	                }
	               // else
	                	//editText1.setText("text");
	                }});
	name=(EditText) findViewById(R.id.EditText01);
	pass=(EditText) findViewById(R.id.editText02);
	 }
	 private void dialog() {
			LayoutInflater layoutInflater = getLayoutInflater();
			View linearlayout = layoutInflater.inflate(R.layout.dialoglogin, null);
			sure = (Button)linearlayout.findViewById(R.id.d3_bt1); 
			cancel = (Button)linearlayout.findViewById(R.id.d3_bt2);
			builder3 = new AlertDialog.Builder(this).setIcon(R.drawable.icon).setView(linearlayout).setTitle("登录对话框").setMessage("确认登录吗？").show();
			sure.setOnClickListener(this);
			cancel.setOnClickListener(this);
		}
	 public  int  save(String name, String password) throws Exception{
			String path = "http://192.168.191.1:8080/job/servlet/login";
			Map<String, String> params = new HashMap<String, String>();//将用户名和密码放入HashMap中 
			params.put("username", name);//put 传递的是 具体的类型 File int 流等 , 不能传递字符串
			params.put("password", password);
			System.out.println("登陆结果是uuuuuuuuuuu");
			return sendPOSTRequest(path, params, "UTF-8");
		}
		/**
		 * 发送POST请求
		 * @param path 请求路径
		 * @param params 请求参数
		 * @return
		 */
		private  int sendPOSTRequest(String path, Map<String, String> params, String encoding) throws Exception{
			//  title=liming&length=30
			StringBuilder sb = new StringBuilder();//如果程序对附加字符串的需求很频繁，不建议使用+来进行字符串的串联，而应该使用java.lang.StringBuilder类,append 就是将信息追加到当前 StringBuilder 的结尾，
			int res=0;
			if(params!=null && !params.isEmpty()){
				for(Map.Entry<String, String> entry : params.entrySet()){
					sb.append(entry.getKey()).append("=");//get方式请求参数时对参数进行utf-8编码，URLEncoder
					sb.append(URLEncoder.encode(entry.getValue(), encoding));//防止客户端传递过去的参数发生乱码，需要对此重新编码成UTF-8 
					sb.append("&");
				}
				sb.deleteCharAt(sb.length()-1);//删除最后的一个"&"
			}
			System.out.println("登陆结果是uuuuuuuuuuu");
			byte[] data = sb.toString().getBytes();//得到实体数据
			
			HttpURLConnection conn = (HttpURLConnection) new URL(path).openConnection();
			conn.setConnectTimeout(5000);
			conn.setRequestMethod("POST");
			conn.setDoOutput(true);//允许对外传输数据
			conn.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
			conn.setRequestProperty("Content-Length", data.length+"");
			OutputStream outStream = conn.getOutputStream();
			outStream.write(data);//写到缓存
			outStream.flush();
			
			if(conn.getResponseCode() == 200){
				
				//只有取得服务器返回的http协议的任何一个属性时才能把请求发送出去
				InputStream in=conn.getInputStream();
				 int count = 0;
				  while (count == 0) {
				   count = in.available();
				  }
				  byte[] b = new byte[count+1];
				  in.read(b);//把变量in里的数据传到了b里面，b是字节型的数组，但很有可能出来乱码
				  
				  String tempstr=new String (b);//将b转换为字符串类型
				  System.out.println ("返回数据"+new String (b));
				  if (tempstr.contains("success")){
	               return 1;//成功登陆返回1
					  
					  
				  }else 
					  return  2;			}
			return 3;
		}



		public void onClick(View v) {
			// TODO Auto-generated method stub
			Intent in;
            switch (v.getId()){
			case R.id.d3_bt1:
				if (name.getText().toString().equals("")||pass.getText().toString().equals("")){
			
					Toast.makeText(this.getBaseContext(), "用户名和密码都不能为空！！！", 1).show();
				}
				else
				{
				try {
					int res,res1;
					String namestr=name.getText().toString();
					String password=pass.getText().toString();
					res=save(namestr,password);
				
					System.out.println("登陆结果是"+res);
					if (res==1){
						//constants.isregister=false;
			
						builder3.cancel();
						in=new Intent (this.getApplicationContext(),MainActivity.class);
						startActivity (in);
						//Toast.makeText(getApplicationContext(), "您已成功登录", 1).show();
					}else if (res==2){
						//Toast.makeText(getApplicationContext(), "学生登录失败，，"+res, 1).show();
						System.out.println ("登陆失败");
				        //startActivity (in);
						//Toast.makeText(getApplicationContext(), "您已成功登录", 1).show();
					}else {
						m_pDialog.cancel();
						Toast.makeText(getApplicationContext(), "无法连接到服务器，请检查网络。。错误码"+res, 1).show();
					}
				} 
				catch (Exception e) {
					// TODO Auto-generated catch block
					m_pDialog.cancel();
					Toast.makeText(getApplicationContext(), "无法连接到服务器，请检查网络。。错误信息"+e.getMessage(), 1).show();
					//e.printStackTrace();
				}
					// 让ProgressDialog显示

//				builder3.cancel();
				}
				break;
				
			case R.id.d3_bt2:
			builder3.cancel();
			this.finish();
			break;
		
			}
}
@Override
public boolean onTouchEvent(MotionEvent event){
	//Toast.makeText(getApplicationContext(), "abc", 1).show();
	switch (event.getAction()){
	case MotionEvent.ACTION_DOWN:
	if (event.getY()<height/13&&event.getX()<width/7){
		this.finish();//返回键，返回到主界面
	}
	if (event.getY()>height*21/51&&event.getY()<height*26/51&&event.getX()>width*3/29&&event.getX()<width*26/29)
	{
		dialog();
		//按登陆跳转到主界面
	}
	if (event.getY()>height*2/51&&event.getY()<height*3/51&&event.getX()>width*23/29&&event.getX()<width*26/29)
	{
		Intent zhuce =new Intent (this.getApplicationContext(),Zhuce.class);
		startActivity (zhuce);//按注册跳转到注册界面
	}
	
	}
	return false;
}
}

