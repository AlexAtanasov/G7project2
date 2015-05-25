package mysecondapplication.android.com.mysecondapplication;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.media.Image;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.os.Handler;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class StartMenuAct extends FragmentActivity {
    int distraction;
    boolean attention = false;
    VoiceRecognition vc;

    TxtS ttsp = null;
   

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start_menu);
        android.support.v4.app.FragmentManager fragmentManager = getSupportFragmentManager();
        android.support.v4.app.FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        AgaFragment agaFragment = new AgaFragment();
        fragmentTransaction.add(R.id.fragment_container, agaFragment);
        fragmentTransaction.commit();
        final TextView ds = (TextView) findViewById(R.id.displaySpeed);

        ttsp = new TxtS();
        ttsp.initialize(this);

        TextView textView1 = (TextView) findViewById(R.id.textView1);
        TextView textView2 = (TextView) findViewById(R.id.textView2);
        TextView textView3 = (TextView) findViewById(R.id.textView3);


        ImageView imageView1 = (ImageView) findViewById(R.id.imageView1);
        ImageView imageView2 = (ImageView) findViewById(R.id.imageView2);
        ImageView imageView3 = (ImageView) findViewById(R.id.imageView3);


        Bundle b = getIntent().getExtras();
        if (b != null) {
            distraction = b.getInt("Distraction");
        }

        
        if (distraction == 0 ||
                distraction == 1) {

            imageView1.setVisibility(View.VISIBLE);
            textView1.setVisibility(View.VISIBLE);
            imageView2.setVisibility(View.INVISIBLE);
            textView2.setVisibility(View.INVISIBLE);
            imageView3.setVisibility(View.INVISIBLE);
            textView3.setVisibility(View.INVISIBLE);

        }


        if (distraction == 2 ||
                distraction == 3) {

            imageView2.setVisibility(View.VISIBLE);
            textView2.setVisibility(View.VISIBLE);
            imageView1.setVisibility(View.INVISIBLE);
            textView1.setVisibility(View.INVISIBLE);
            imageView3.setVisibility(View.INVISIBLE);
            textView3.setVisibility(View.INVISIBLE);

            Handler h = new Handler();
            h.postDelayed(new Runnable() {
                @Override
                public void run() {
                    delayReturn2();
                }
            }, 3000);

        }
        if (distraction == 2) {
            attention = true;

            if (attention) {
                Handler h = new Handler();
                h.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        delayReturn4();
                    }
                }, 25000);

            }
        }

        if(distraction== 4){

            imageView3.setVisibility(View.VISIBLE);
            textView3.setVisibility(View.VISIBLE);
            imageView1.setVisibility(View.INVISIBLE);
            textView1.setVisibility(View.INVISIBLE);
            imageView2.setVisibility(View.INVISIBLE);
            textView2.setVisibility(View.INVISIBLE);

            Handler h = new Handler();
            h.postDelayed(new Runnable() {
                @Override
                public void run() {
                    delayReturn3();
                }
            }, 3000);
        }

    }

    public void onClickTextToSpeech (View view) {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }

    public void onClickTextOnly(View view) {
        Intent intent = new Intent(this, TOActivity.class);
        startActivity(intent);
    }

    public void onClickFocus(View view) {
        Handler h = new Handler();

        h.postDelayed(new Runnable() {
            @Override
            public void run() {

                String msg = "Really! Focus on the road!!!";
                ttsp.initText(msg);

            }
        }, 400);
    }

    public void delayReturn2() {
        String msg = "Moderate Driver Distraction. Press the YELLOW button to play the quiz";
        ttsp.initText(msg);

    }

    public void delayReturn3() {
        String msg2 = "High Driver Distraction! No game allowed! Please focus on the road!";
        ttsp.initText(msg2);

    }

    public void delayReturn4() {
        String msg3 = "You seem to be a little bored. What about a quiz game?";
        ttsp.initText(msg3);

    }
}
