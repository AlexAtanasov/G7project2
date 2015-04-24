package mysecondapplication.android.com.mysecondapplication;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import android.os.Handler;

public class CorrectActivity extends Activity {
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
