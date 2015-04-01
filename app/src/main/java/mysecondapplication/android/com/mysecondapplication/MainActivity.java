package mysecondapplication.android.com.mysecondapplication;


        import android.app.Activity;
        import android.graphics.Color;
        import android.os.Bundle;
        import android.view.View;
        import android.widget.Button;
        import android.widget.RelativeLayout;


public class MainActivity extends Activity {

    RelativeLayout background;
    Button btnGreen, btnBlue;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        background = (RelativeLayout) findViewById(R.id.background);
        btnBlue = (Button) findViewById(R.id.btnBlue);
        btnGreen = (Button) findViewById(R.id.btnGreen);

        btnGreen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               setContentView(R.layout.activity_wrong);


            }
        });

        btnBlue.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setContentView(R.layout.activity_correct);

            }
        });
    }

}
