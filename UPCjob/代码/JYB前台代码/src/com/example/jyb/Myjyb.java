package com.example.jyb;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MotionEvent;
import android.view.Window;
import android.view.WindowManager;
public class Myjyb extends Activity{
	int width;
	int height;
	 protected void onCreate(Bundle savedInstanceState) {
	        super.onCreate(savedInstanceState);
	        requestWindowFeature(Window.FEATURE_NO_TITLE);  
	        //����ȫ��
	        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,   
	        		 WindowManager.LayoutParams.FLAG_FULLSCREEN); 
	        WindowManager wm = this.getWindowManager();
	        width = wm.getDefaultDisplay().getWidth();
	        height = wm.getDefaultDisplay().getHeight();
	        setContentView(R.layout.myjyb);
}
	 @Override
	 public boolean onTouchEvent(MotionEvent event){
	 	switch (event.getAction()){
	 	case MotionEvent.ACTION_DOWN:
	 	if (event.getY()<height/51&&event.getY()<height*4/51&&event.getX()>width/29&&event.getX()<width*3/29){
	 		this.finish();//���ؼ������ص�������
	 	}
	 	if (event.getY()>height/51&&event.getY()<height*3/51&&event.getX()>width*23/29&&event.getX()<width*27/29)
	 	{
	 		Intent zhuxiao =new Intent (this.getApplicationContext(),Zhuxiaosuccess.class);
	 		startActivity (zhuxiao);//��������ת��ע���ɹ�����
	 	}
	 	if (event.getY()>height*20/51&&event.getY()<height*23/51)
	 	{
	 		Intent push =new Intent (this.getApplicationContext(),Position_push.class);
	 		startActivity (push);//ְλ����
	 	}
	 	if (event.getY()>height*24/51&&event.getY()<height*28/51)
	 	{
	 		Intent xg =new Intent (this.getApplicationContext(),Xinxixiugai.class);
	 		startActivity (xg);//��ת���޸ĸ�����Ϣ
	 	}
	 	if (event.getY()>height*29/51&&event.getY()<height*32/51)
	 	{
	 		Intent xiugai =new Intent (this.getApplicationContext(),Xiugaimima.class);
	 		startActivity (xiugai);
	 		//�޸�����
	 	}
	 	}
	 	return false;
	 }
	 }

