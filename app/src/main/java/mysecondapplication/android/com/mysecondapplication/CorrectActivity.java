package mysecondapplication.android.com.mysecondapplication;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;


<<<<<<< HEAD
=======

>>>>>>> effde1640110a71775475570ba927a3d4ae1b958
public class CorrectActivity extends Activity {
    MainActivity act = new MainActivity();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_correct);


        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
            delayReturn();
            }
        }, 3000);


    }

    public void delayReturn(){
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }

}
