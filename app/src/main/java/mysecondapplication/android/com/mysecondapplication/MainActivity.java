package mysecondapplication.android.com.mysecondapplication;

        import android.app.Activity;
        import android.content.Intent;
        import android.os.Bundle;
        import android.view.View;



public class MainActivity extends Activity {


    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void onClickYes(View view) {
        Intent intent = new Intent(this, CorrectActivity.class);
        startActivity(intent);
    }

    public void onClickNo(View view){
        Intent intent = new Intent (this, WrongActivity.class);
        startActivity(intent);
    }
}
