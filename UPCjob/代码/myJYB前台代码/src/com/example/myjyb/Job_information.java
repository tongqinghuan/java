package com.example.myjyb;

import android.app.Activity;
import android.os.Bundle;
import android.view.Window;
import android.view.WindowManager;

public class Job_information extends Activity{
		int width;
		int height;
		 protected void onCreate(Bundle savedInstanceState) {
		        super.onCreate(savedInstanceState);
		        requestWindowFeature(Window.FEATURE_NO_TITLE);  
		        //…Ë÷√»´∆¡
		        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,   
		        		 WindowManager.LayoutParams.FLAG_FULLSCREEN); 
		        WindowManager wm = this.getWindowManager();
		        width = wm.getDefaultDisplay().getWidth();
		        height = wm.getDefaultDisplay().getHeight();
		        setContentView(R.layout.job_information);
		 }
}
