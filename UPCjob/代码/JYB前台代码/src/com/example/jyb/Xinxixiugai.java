package com.example.jyb;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MotionEvent;
import android.view.Window;
import android.view.WindowManager;
public class Xinxixiugai extends Activity{
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
	        setContentView(R.layout.xinxixiugai);
	 }
	 @Override
	 public boolean onTouchEvent(MotionEvent event){
	 	switch (event.getAction()){
	 	case MotionEvent.ACTION_DOWN:
	 		if (event.getY()>height*22/51&&event.getY()<height*12/17&&event.getX()>width*3/29&&event.getX()<width*25/29){
				//������޸ġ���ť������ȷ���޸ġ��Ի���
			}
			if (event.getY()>height/51&&event.getY()<height*4/51&&event.getX()>width/29&&event.getX()<width*3/29){
				this.finish();//���ؼ������ص�MY��ҵ�����
			}
			}
	 	return false;
	 }
	 }

