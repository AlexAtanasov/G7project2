package mysecondapplication.android.com.mysecondapplication;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;



public class ActivityWrong extends Activity {

    Button backButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_wrong);


        backButton = (Button) findViewById(R.id.backButton);

        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setContentView(R.layout.activity_main);


            }
        });





    }
}
