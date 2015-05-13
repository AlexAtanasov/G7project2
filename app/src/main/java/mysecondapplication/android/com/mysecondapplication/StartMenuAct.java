package mysecondapplication.android.com.mysecondapplication;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.util.Log;
import android.view.View;
import android.widget.TextView;


public class StartMenuAct extends FragmentActivity {
    int distraction;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start_menu);
        android.support.v4.app.FragmentManager fragmentManager = getSupportFragmentManager();
        android.support.v4.app.FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        AgaFragment agaFragment = new AgaFragment();
        fragmentTransaction.add(R.id.fragment_container,agaFragment);
        fragmentTransaction.commit();
        final TextView ds = (TextView) findViewById(R.id.displaySpeed);

        Bundle b = getIntent().getExtras();
            if(b != null) {
                distraction = b.getInt("Distraction");
            }
        //Log.d("blah", String.valueOf(distraction));

        if(distraction == 0 ||
           distraction== 1 ) {
           ds.setBackgroundColor(0xff00ff00);
        }
        if(distraction== 2||
           distraction== 3){
           ds.setBackgroundColor(0xffffff00);
        }
        if(distraction== 4){
           ds.setBackgroundColor(0xffff0000);
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
}
