package mysecondapplication.android.com.mysecondapplication;


import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.os.Handler;
import android.view.View;

public class ScoreActivity extends ActionBarActivity{


    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_score);




        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                delayReturn();
            }
        }, 5000);
    }


    public void onClickBack(View view) {

        Intent intent = new Intent(this, StartMenuAct.class);
        startActivity(intent);
    }

    public void delayReturn() {
        Intent intent = new Intent(this, StartMenuAct.class);
        startActivity(intent);


    }
}
