package mysecondapplication.android.com.mysecondapplication;

import android.app.Activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;


public class StartMenuAct extends FragmentActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start_menu);
        android.support.v4.app.FragmentManager fragmentManager = getSupportFragmentManager();
        android.support.v4.app.FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        AgaFragment agaFragment = new AgaFragment();
        fragmentTransaction.add(R.id.fragment_container,agaFragment);
        fragmentTransaction.commit();
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

