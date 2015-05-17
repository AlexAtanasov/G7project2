package mysecondapplication.android.com.mysecondapplication;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

import android.support.v7.app.ActionBarActivity;
import android.view.View;
import android.widget.TextView;


public class FocusActivity extends ActionBarActivity {

    TxtS ttsp = null;

    protected void onCreate(Bundle savedInstanceState) { // different intent!
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_focus);

        ttsp = new TxtS();
        ttsp.initialize(this);

        Handler h = new Handler();


        h.postDelayed(new Runnable() {
            @Override
            public void run() {

                String msg = "Really! Focus on the road!!!";
                ttsp.initText(msg);

            }
        }, 400);
    }

    public void onClickBack(View view) {
        Intent intent = new Intent(this, StartMenuAct.class);
        startActivity(intent);
    }
}
