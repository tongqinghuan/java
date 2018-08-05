package com.example.myjyb;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MotionEvent;
import android.view.Window;
import android.view.WindowManager;
public class Search_result extends Activity{
	int width;
	int height;
	 protected void onCreate(Bundle savedInstanceState) {
	        super.onCreate(savedInstanceState);
	        requestWindowFeature(Window.FEATURE_NO_TITLE);  
	        //设置全屏
	        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,   
	        		 WindowManager.LayoutParams.FLAG_FULLSCREEN); 
	        WindowManager wm = this.getWindowManager();
	        width = wm.getDefaultDisplay().getWidth();
	        height = wm.getDefaultDisplay().getHeight();
	        setContentView(R.layout.search_result);
	 }

 @Override
	public boolean onTouchEvent(MotionEvent event){
		switch (event.getAction()){
		case MotionEvent.ACTION_DOWN:
		if (event.getY()>height/51&&event.getY()<height*4/51&&event.getX()>width/29&&event.getX()<width*3/29){
			this.finish();//返回键，返回到职位搜索界面
		}
		}
		return false;

 }
}
