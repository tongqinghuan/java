package com.example.myjyb;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MotionEvent;
import android.view.Window;
import android.view.WindowManager;
public class Search extends Activity{
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
	        setContentView(R.layout.search);
	 }
@Override
public boolean onTouchEvent(MotionEvent event){
	//Toast.makeText(getApplicationContext(), "abc", 1).show();
	switch (event.getAction()){
	case MotionEvent.ACTION_DOWN:
		if (event.getY()>height/51&&event.getY()<height*4/51&&event.getX()>width/29&&event.getX()<width*3/29){
				this.finish();//���ؼ������ص�������
			}
		if (event.getY()>height*2/17&&event.getY()<height*3/17&&event.getX()>width*2/29&&event.getX()<width*26/29)
			{
				//��������ְλ�ؼ���
			}
	if (event.getY()>height*6/13&&event.getY()<height*7/13&&event.getX()>width/15&&event.getX()<width*13/15)
	{
		Intent search =new Intent();
		search.setClass(Search.this,Search_result.class);
		startActivity (search);//�����������������
	}
	if (event.getY()>height*15/26&&event.getY()<height*17/26&&event.getX()>width/15&&event.getX()<width*7/15)
	{
		//�鿴�����ղ�
	}
	}
	return false;
}
}