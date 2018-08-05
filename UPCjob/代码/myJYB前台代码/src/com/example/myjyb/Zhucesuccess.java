package com.example.myjyb;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MotionEvent;
import android.view.Window;
import android.view.WindowManager;

public class Zhucesuccess extends Activity{
	int width;
	int height;
	 protected void onCreate(Bundle savedInstanceState) {
	        super.onCreate(savedInstanceState);
	        requestWindowFeature(Window.FEATURE_NO_TITLE);  
	        //ÉèÖÃÈ«ÆÁ
	        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,   
	                WindowManager.LayoutParams.FLAG_FULLSCREEN); 
	        WindowManager wm = this.getWindowManager();
	        width = wm.getDefaultDisplay().getWidth();
	        height = wm.getDefaultDisplay().getHeight();
	        setContentView(R.layout.zhucesuccess);
	 }
@Override
public boolean onTouchEvent(MotionEvent event){
	switch (event.getAction()){
	case MotionEvent.ACTION_DOWN:
	if (event.getY()>height*22/51&&event.getY()<height*12/17&&event.getX()>width*3/29&&event.getX()<width*25/29){
		//·µ»ØµÇÂ½
	}
	if (event.getY()>height*2/3&&event.getY()<height*8/9&&event.getX()>width*3/5&&event.getX()<width*4/5)
	{
		
		//·µ»Ø¼ü
	}
	}
	return false;

}
}