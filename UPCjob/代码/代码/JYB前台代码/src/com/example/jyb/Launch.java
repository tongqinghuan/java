package com.example.jyb;

import java.util.Timer;
import java.util.TimerTask;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.Window;
import android.view.WindowManager;

public class Launch extends Activity{
	Timer timer;   
	int width;
	int height;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);  
        //����ȫ��
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,   
                WindowManager.LayoutParams.FLAG_FULLSCREEN); 
        WindowManager wm = this.getWindowManager();
        width = wm.getDefaultDisplay().getWidth();
        height = wm.getDefaultDisplay().getHeight();
        setContentView(R.layout.launch);

      
        
        timer = new Timer();   
        
        // ����ƻ����񣬸��ݲ����Ĳ�ͬ���������������Ĺ������ڹ̶�ʱ��ִ��ĳ�����ڹ̶�ʱ�俪ʼ�ظ�ִ��ĳ�����ظ�ʱ�����ɿأ����ӳٶ�ú�ִ��ĳ�������ӳٶ�ú��ظ�ִ��ĳ�����ظ�ʱ�����ɿ�   
        timer.schedule(new TimerTask() {   
       

            // TimerTask �Ǹ�������,ʵ�ֵ���Runable��   
            @Override  
            public void run() {   
startActivity (new Intent (Launch.this,MainActivity.class));
             Launch.this.finish();
             timer.cancel();
            }   

        }, 2000, 3000);   
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        
        // Inflate the menu; this adds items to the action bar if it is present.
       // getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
     
        return super.onOptionsItemSelected(item);
    }

    /**
     * A placeholder fragment containing a simple view.
     */
   
}
