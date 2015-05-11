package mysecondapplication.android.com.mysecondapplication;


import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;

import android.os.Handler;
import android.view.View;
import android.widget.TextView;

public class ScoreActivity extends ActionBarActivity{


    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_score);

        Bundle b = getIntent().getExtras();
        int score = b.getInt("score");

        TextView t =(TextView)findViewById(R.id.score2);
        t.setText(String.valueOf(score));



        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                delayReturn();
            }
        }, 8000);
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
