package com.example.jyb;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MotionEvent;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
public class Xiugaimima extends Activity implements OnClickListener{
	int width;
	int height;
	EditText old_password;
	EditText new_password;
	EditText new_password2;
	Button sure,cancel;
	Dialog builder;
	ProgressDialog m_pDialog;
	String msg=new String ("00000");
	SharedPreferences mShared;
	/**程序中可以同时存在多个SharedPreferences数据， 根据SharedPreferences的名称就可以拿到对象**/  
    public final static String SHARED_MAIN = "session";  
	/**SharedPreferences中储存数据的Key名称**/  
    public final static String KEY_NAME = "mobileno"; 
    public final static String KEY_SESSION = "sessionid";
    public final static String KEY_NUMBER = "password"; 
	 protected void onCreate(Bundle savedInstanceState) {
	        super.onCreate(savedInstanceState);
	        requestWindowFeature(Window.FEATURE_NO_TITLE);  
	        //设置全屏
	        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,   
	        		 WindowManager.LayoutParams.FLAG_FULLSCREEN); 
	        WindowManager wm = this.getWindowManager();
	        width = wm.getDefaultDisplay().getWidth();
	        height = wm.getDefaultDisplay().getHeight();
	        setContentView(R.layout.xiugaimima);
	        mShared = getSharedPreferences(SHARED_MAIN, Context.MODE_PRIVATE);
	        old_password = (EditText)findViewById(R.id.EditText01);
	        new_password = (EditText)findViewById(R.id.editText02);
	        new_password2 = (EditText)findViewById(R.id.editText03);	
	 }
	 public  int save(String name, String new_password) throws Exception{
			String path = "http://mfpinyou.free.800m.net/servlet/registeer";
			Map<String, String> params = new HashMap<String, String>();
			params.put("name",name);
			params.put("password",new_password);
		//	params.put("new_password2", new_password2);
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
			conn.setDoOutput(true);//允许对外传输数据
			conn.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
			conn.setRequestProperty("Content-Length", data.length+"");
			OutputStream outStream = conn.getOutputStream();
			outStream.write(data);
			outStream.flush();
			
			if(conn.getResponseCode() == 200){
				InputStream in=conn.getInputStream();
				 int count = 0;
				  while (count == 0) {
				   count = in.available();
				  }
				  
				  byte[] b = new byte[count+1];
				  in.read(b);
				  String tt=new String (b);
				  System.out.println ("返回数据"+new String (b));
				  if (tt.contains("success"))	 
				return 1;
				  else if (tt.contains("existuser")){  
					  msg="";
					  return 2;  
				  }else return 3;
			}
			return 3;
		}
		@Override
		public void onClick(View v) {
			switch (v.getId()){
			case R.id.d3_bt3://确定键
	// TODO Auto-generated method stub
	 if(!new_password2.getText().toString().equals(new_password.getText().toString()))
	{
		Toast.makeText(getApplicationContext(), "两次输入密码不一致", 1000).show();
	}
	else{
		try {
			String oldpwd=new String (old_password.getText().toString());
			String newpwd=new String (new_password.getText().toString());
			String newpwd2=new String (new_password2.getText().toString());
			int res=save (old_password.getText().toString(),new_password.getText().toString());
			System.out.println("修改结果是"+res);
			if (res==1){
				m_pDialog.cancel();
				builder.cancel();
				Intent in=new Intent();
				in=new Intent (this.getApplicationContext(),Xiugaisuccess.class);
				//in.putExtra("oldpassword",oldpwd );
				//in.putExtra("newpassword",newpwd);
				//in.putExtra("newpassword2",newpwd2);
				startActivity (in);
				Toast.makeText(getApplicationContext(), "您已成功修改密码", 1).show();
				}
			//else if (res==2){
					//m_pDialog.cancel();
					//Toast.makeText(getApplicationContext(), "修改失败，您输入的新密码已被注册，请更换新密码", 1).show();
			
				//}
			else {
					m_pDialog.cancel();
					Toast.makeText(getApplicationContext(), "无法连接到服务器，请检查网络，，错误码"+res, 1).show();
				}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			m_pDialog.cancel();
		Toast.makeText(getApplicationContext(), "无法连接到服务器，请检查网络，，错误详细"+e.getMessage(), 1).show();
		}
	}
	break;
 case R.id.d3_bt4:
	 builder.cancel();
}
			}
		
		 @Override
			public boolean onTouchEvent(MotionEvent event){
				switch (event.getAction()){
				case MotionEvent.ACTION_DOWN:
					if (event.getY()>height/51&&event.getY()<height*4/51&&event.getX()>width*23/29&&event.getX()<width*27/29)
					{	if(old_password.getText().toString().equals("")||new_password.getText().toString().equals("")||new_password2.getText().toString().equals(""))
					{
						Toast.makeText(getApplicationContext(), "请输入完整信息", 1000).show();
					}
					
					else
						//Intent xiugai =new Intent (xiugaimima.this,xiugaichenggong.class);
						//点击“提交”按钮跳转到密码修改成功页面
					dialog3();
					}
					if (event.getY()>height/51&&event.getY()<height*4/51&&event.getX()>width/29&&event.getX()<width*3/29){
					this.finish();//点击“返回键”按钮跳转到My就业帮页面	
		// TODO Auto-generated method stub
				}
				}
		return false;
					}
		 
 private void dialog3() {
		LayoutInflater layoutInflater = getLayoutInflater();
		View linearlayout = layoutInflater.inflate(R.layout.dialogchangepwd, null);
		sure = (Button)linearlayout.findViewById(R.id.d3_bt3); 
		cancel = (Button)linearlayout.findViewById(R.id.d3_bt4);
		builder = new AlertDialog.Builder(this).setIcon(R.drawable.icon).setView(linearlayout).setTitle("修改密码对话框").setMessage("确认修改吗？").show();
		sure.setOnClickListener(this);
		cancel.setOnClickListener(this);
	}
}