package com.example.jyb;

import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;
import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.app.ProgressDialog;
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

public class Zhuce extends Activity implements OnClickListener{
	EditText username,password,repass,major,grade,student_num;
	Button sure,cancel;
	Dialog builder3;
	ProgressDialog m_pDialog;
	String msg=new String ("00000");
	
	int ii=0;
	int width;
	int height;
	 //@SuppressLint("NewApi")
	protected void onCreate(Bundle savedInstanceState) {
	        super.onCreate(savedInstanceState);
	        requestWindowFeature(Window.FEATURE_NO_TITLE);  
	        //����ȫ��
	        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,   
	        		 WindowManager.LayoutParams.FLAG_FULLSCREEN); 
	        WindowManager wm = this.getWindowManager();
	        width = wm.getDefaultDisplay().getWidth();
	        height = wm.getDefaultDisplay().getHeight();
	        setContentView(R.layout.zhuce);
	        username=(EditText)this.findViewById(R.id.EditText01);
	        student_num=(EditText)this.findViewById(R.id.editText02);
	        grade=(EditText)this.findViewById(R.id.editText03);
	        major=(EditText)this.findViewById(R.id.editText04);
	        password=(EditText)this.findViewById(R.id.editText05);
	        repass=(EditText)this.findViewById(R.id.editText06);
	       // sure=(Button)findViewById(R.id.btn_command);???b2=(Button)findViewById(R.id.btn_cback);???
	       
	        StrictMode.setThreadPolicy(new StrictMode.ThreadPolicy.Builder().detectDiskReads().detectDiskWrites().detectNetwork().penaltyLog().build());
	        StrictMode.setVmPolicy(new StrictMode.VmPolicy.Builder().detectLeakedSqlLiteObjects().detectLeakedClosableObjects().penaltyLog().penaltyDeath().build());
	        final EditText editText1 = (EditText) findViewById(R.id.EditText01);
	        final String string = editText1.getHint().toString();
	       // AbsoluteSizeSpan ass = new AbsoluteSizeSpan(8, true);     
	     // �������Ե��ı�
	       // ( editText1).setSpan(ass, 0, editText1.length(), Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
	     // ����hint
	    // editText1.setHint(new SpannedString(editText1)); // һ��Ҫ����ת��,�������Ի���ʧ
	        editText1.setOnFocusChangeListener(new OnFocusChangeListener(){
	            @Override
	            public void onFocusChange(View arg0, boolean hasFocus) {
	                if(hasFocus){
	                    editText1.setText("");
	                }
	             }
	        });
	        final EditText editText2 = (EditText) findViewById(R.id.editText02);
	        final String string1 = editText1.getHint().toString();
	      
	        editText1.setOnFocusChangeListener(new OnFocusChangeListener(){
	            @Override
	            public void onFocusChange(View arg0, boolean hasFocus) {
	                if(hasFocus){
	                    editText2.setText("");
	                }
	               // else
	                	//editText2.setText("text");
	                }
	        });
	        final EditText editText3 = (EditText) findViewById(R.id.editText03);
	        final String string2 = editText1.getHint().toString();
	      
	        editText1.setOnFocusChangeListener(new OnFocusChangeListener(){
	            @Override
	            public void onFocusChange(View arg0, boolean hasFocus) {
	                if(hasFocus){
	                    editText3.setText("");
	                }
	               // else
	                	//editText3.setText("text");
	                }
	        });
	        final EditText editText4 = (EditText) findViewById(R.id.editText04);
	        final String string3 = editText1.getHint().toString();
	      
	        editText1.setOnFocusChangeListener(new OnFocusChangeListener(){
	            @Override
	            public void onFocusChange(View arg0, boolean hasFocus) {
	                if(hasFocus){
	                    editText4.setText("");
	                }
	                //else
	                	//editText4.setText("text");
	                }
	        });
	        final EditText editText5 = (EditText) findViewById(R.id.editText05);
	        final String string4 = editText1.getHint().toString();
	      
	        editText1.setOnFocusChangeListener(new OnFocusChangeListener(){
	            @Override
	            public void onFocusChange(View arg0, boolean hasFocus) {
	                if(hasFocus){
	                    editText5.setText("");
	                }
	                //else
	                	//editText5.setText("text");
	                }
	        });
	 }
	 public  int save(String username, String studentnumber,  String grade,String major, String password) throws Exception{
			String path = "http://192.168.191.1:8080/job/servlet/register";
			Map<String, String> params = new HashMap<String, String>();
			params.put("username", username);
			params.put("studentnumber",studentnumber);
			params.put("grade", grade);
			params.put("major", major);
			params.put("password",password);
			return sendPOSTRequest(path, params, "UTF-8");
		}

		/**
		 * ����POST����
		 * @param path ����·��
		 * @param params �������
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
			conn.setDoOutput(true);//������⴫������
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
				  System.out.println ("��������"+new String (b));
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
			//Toast.makeText(getApplicationContext(), "�����Ϣ��д���������ύ", 1).show();
			//View v=new View(null);
			switch (v.getId()){
			
			case R.id.d4_bt1://ȷ����
				
				if (!password.getText().toString().equals(repass.getText().toString())){
					repass.requestFocus();
					Toast.makeText(this.getApplicationContext(), "����д��ȷ�����������벻ͬ��������ȷ��", 1).show();
					
				}else {
					//����ProgressDialog����
					m_pDialog = new ProgressDialog(Zhuce.this);

					// ���ý�������񣬷��ΪԲ�Σ���ת��
					m_pDialog.setProgressStyle(ProgressDialog.STYLE_SPINNER);

					// ����ProgressDialog ����
					m_pDialog.setTitle("��ʾ");
					
					// ����ProgressDialog ��ʾ��Ϣ
					m_pDialog.setMessage("����ע�ᣬ���Ժ�");

					// ����ProgressDialog ����ͼ��
					m_pDialog.setIcon(R.drawable.icon);

					// ����ProgressDialog �Ľ������Ƿ���ȷ
					m_pDialog.setIndeterminate(false);
					
					// ����ProgressDialog �Ƿ���԰��˻ذ���ȡ��
					m_pDialog.setCancelable(true);
					
					// ����ProgressDialog ��һ��Button


					m_pDialog.show();
					try {
						
						String namestr=new String (username.getText().toString());
						String stu_number=new String (student_num.getText().toString());
						String gradestr=new String (grade.getText().toString());
						String majorstr=new String (major.getText().toString());
						String passwd=new String (password.getText().toString());
						String repasswd=new String (repass.getText().toString());
						int res=save (username.getText().toString(),student_num.getText().toString(),password.getText().toString(),
						grade.getText().toString(),major.getText().toString());
						System.out.println("ע������"+res);
						if (res==1){
							m_pDialog.cancel();
							builder3.cancel();
							Constants.isregister=true;
							Intent in;
							in=new Intent (this.getApplicationContext(),Login.class);
							//in.putExtra("username",namestr );//
							//in.putExtra("student_num", stu_number);
							//in.putExtra("grade",gradestr);
							//in.putExtra("major", majorstr);
							startActivity (in);
							//Toast.makeText(getApplicationContext(), "���ѳɹ�ע��", 1).show();
							}else if (res==2){
								m_pDialog.cancel();
								Toast.makeText(getApplicationContext(), "ע��ʧ�ܣ���������û����ѱ�ע�ᣬ������û����ٴ�ע��", 1).show();
						
							}else {
								m_pDialog.cancel();
								Toast.makeText(getApplicationContext(), "�޷����ӵ����������������磬��������"+res, 1).show();
							}
					} catch (Exception e) {
						// TODO Auto-generated catch block
						m_pDialog.cancel();
					Toast.makeText(getApplicationContext(), "�޷����ӵ����������������磬��������ϸ"+e.getMessage(), 1).show();
					}
				}
				break;
			case R.id.d4_bt2:
				builder3.cancel();
			}
		}
		@Override
		public boolean onTouchEvent(MotionEvent event){
			switch (event.getAction()){
			case MotionEvent.ACTION_DOWN:
			if (event.getY()>height*22/51&&event.getY()<height*12/17&&event.getX()>width*3/29&&event.getX()<width*25/29)
			{
				if (username.getText().toString().equals("")||password.getText().toString().equals("")
						||repass.getText().toString().equals("")||student_num.getText().toString().equals("")
						||grade.getText().toString().equals("")||major.getText().toString().equals("")){
					Toast.makeText(getApplicationContext(), "�����Ϣ��д���������ύ", 1).show();
				}
				else 
				  dialog3();
				}
		
			}
			
			 if (event.getY()>height/51&&event.getY()<height*4/51&&event.getX()>width/29&&event.getX()<width*3/29){
				this.finish();//���ؼ������ص�������
			} 
					return false;
			// TODO Auto-generated method stub
}
			
	 private void dialog3() {
			LayoutInflater layoutInflater = getLayoutInflater();
			View linearlayout = layoutInflater.inflate(R.layout.dialogzhuce, null);
			sure = (Button)linearlayout.findViewById(R.id.d4_bt1); 
			cancel = (Button)linearlayout.findViewById(R.id.d4_bt2);
			builder3 = new AlertDialog.Builder(this).setIcon(R.drawable.icon).setView(linearlayout).setTitle("ע��Ի���").setMessage("ȷ��ע����").show();
		sure.setOnClickListener(this);
		cancel.setOnClickListener(this);
		}
	//public boolean onTouchEvent(MotionEvent event){
		//switch (event.getAction()){
		//case MotionEvent.ACTION_DOWN:
		//if (event.getY()>height*22/51&&event.getY()<height*12/17&&event.getX()>width*3/29&&event.getX()<width*25/29){
			  //dialog3();
			//Intent success=new Intent (Zhuce.this,Zhucesuccess.class);
			//startActivity (success);//�����ע�ᡱ��ť��ת��ע��ɹ�ҳ��
		//}
		//

 }

