package in.mandy.getthearea;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;


/**
 * Created by mandy on 03-Jul-16.
 */
public class SplashScreen extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.splash);
        Thread timerThread =new Thread(){
            public void run(){
                try{
                    sleep(2000);
                }catch (InterruptedException e){
                    e.printStackTrace();
                }finally {
                    Intent i=new Intent(SplashScreen.this,MainActivity.class);
                    startActivity(i);
                }

            }
        };
        timerThread.start();
    }
    protected void onPause(){
        super.onPause();
        finish();
    }
}
