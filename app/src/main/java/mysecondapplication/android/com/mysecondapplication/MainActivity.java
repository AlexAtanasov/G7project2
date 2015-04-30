package mysecondapplication.android.com.mysecondapplication;

        import android.content.Context;
        import android.content.Intent;
        import android.os.Bundle;
        import android.support.v7.app.ActionBarActivity;
        import android.util.Log;
        import android.view.Gravity;
        import android.view.View;
        import android.widget.Button;
        import android.widget.TextView;
        import android.widget.Toast;

        import java.util.List;


public class MainActivity extends ActionBarActivity {
    List<Question> quesList;
    int score = 0;
    int qid = 0;
    Question currentQ;
    TextView txtQuestion;
    TxtS ttsp = null;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



        DatabaseHandler db = new DatabaseHandler(this);
        quesList=db.getAllQuestions();
        currentQ=quesList.get(qid);
        txtQuestion=(TextView)findViewById(R.id.questionText);
        setQuestionView();

        ttsp = new TxtS();
        ttsp.initialize(this);
        ttsp.initText(currentQ.toString());




    }

    public void onClickYes(View view) {
     //   Intent intent = new Intent(this, CorrectActivity.class);
      //  startActivity(intent);

        if(currentQ.getAnswer().equals("yes")) {

            Context context = getApplicationContext();
            CharSequence text = "yes";
            int duration = Toast.LENGTH_SHORT;

            Toast toast;
            toast = Toast.makeText(context,"Correct!", Toast.LENGTH_SHORT);
            toast.show();
            score++;

            toast.setGravity(Gravity.CENTER_HORIZONTAL | Gravity.START, 370, 95);

            String cor = "Correct!";
            ttsp.initText(cor);
            score++;

        } else {
            Context context = getApplicationContext();
            CharSequence text = "yes";
            int duration = Toast.LENGTH_SHORT;

            Toast toast;
            toast = Toast.makeText(context,"Incorrect!", Toast.LENGTH_SHORT);
            toast.show();
            score++;

            toast.setGravity(Gravity.CENTER_HORIZONTAL | Gravity.START, 370, 95);

            String wro = "Incorrect!";
            ttsp.initText(wro);
        }

        currentQ = quesList.get(qid);
        setQuestionView();

    }

    public void onClickNo(View view){


        if(currentQ.getAnswer().equals("no")) {

            Context context = getApplicationContext();
            CharSequence text = "no";
            int duration = Toast.LENGTH_SHORT;

            Toast toast;
            toast = Toast.makeText(context,"Correct!", Toast.LENGTH_SHORT);
            toast.show();
            score++;

            toast.setGravity(Gravity.CENTER_HORIZONTAL | Gravity.START, 370, 95);

            String cor = "Correct!";
            ttsp.initText(cor);
            score++;

        } else {
            Context context = getApplicationContext();
            CharSequence text = "yes";
            int duration = Toast.LENGTH_SHORT;

            Toast toast;
            toast = Toast.makeText(context,"Incorrect!", Toast.LENGTH_SHORT);
            toast.show();
            score++;

            toast.setGravity(Gravity.CENTER_HORIZONTAL | Gravity.START, 370, 95);

            String wro = "Incorrect!";
            ttsp.initText(wro);
        }


        //  Intent intent = new Intent (this, WrongActivity.class);
       //  startActivity(intent);
        currentQ = quesList.get(qid);
        setQuestionView();

    }
    public void setQuestionView()
    {

        txtQuestion.setText(currentQ.getQuestion());

        qid++;
    }
}
