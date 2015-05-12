package mysecondapplication.android.com.mysecondapplication;

        import android.content.Context;
        import android.content.Intent;
        import android.os.Bundle;
        import android.os.Handler;
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

        ttsp = new TxtS();

        ttsp.initialize(this);


        Handler h = new Handler();

        DatabaseHandler db = new DatabaseHandler(this);
        quesList=db.getAllQuestions();
        currentQ=quesList.get(qid);

        txtQuestion=(TextView)findViewById(R.id.questionFact);
        txtQuestion=(TextView)findViewById(R.id.questionText);


        setQuestionView();




        h.postDelayed(new Runnable() {
            @Override
            public void run() {

                ttsp.addText(currentQ.toFact());
                ttsp.addText(currentQ.toSuck());
            }
        }, 400);

    }

    public void onClickYes(View view) {

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


        } else {
            Context context = getApplicationContext();
            CharSequence text = "yes";
            int duration = Toast.LENGTH_SHORT;

            Toast toast;
            toast = Toast.makeText(context,"Incorrect!", Toast.LENGTH_SHORT);
            toast.show();
            toast.setGravity(Gravity.CENTER_HORIZONTAL | Gravity.START, 370, 95);

            String wro = "Incorrect!";
            ttsp.initText(wro);
        }

        currentQ = quesList.get(qid);
        setQuestionView();
        if(qid<11) {
            ttsp.addText(currentQ.toFact());
            ttsp.addText(currentQ.toSuck());
        }
    }

    public void onClickRepeat(View view) {

        //ttsp.addText(currentQ.toFact());
        ttsp.addText(currentQ.toSuck());

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


        } else {
            Context context = getApplicationContext();
            CharSequence text = "yes";
            int duration = Toast.LENGTH_SHORT;

            Toast toast;
            toast = Toast.makeText(context,"Incorrect!", Toast.LENGTH_SHORT);
            toast.show();


            toast.setGravity(Gravity.CENTER_HORIZONTAL | Gravity.START, 370, 95);

            String wro = "Incorrect!";
            ttsp.initText(wro);
        }

        currentQ = quesList.get(qid);
        setQuestionView();
        if(qid<11) {
            ttsp.addText(currentQ.toFact());
            ttsp.addText(currentQ.toSuck());
        }

    }
    public void setQuestionView()
    {

        txtQuestion.setText(currentQ.getFact());
        txtQuestion.setText(currentQ.getQuestion());

        qid++;

        if (qid==11) {

            Intent intent = new Intent(this, ScoreActivity.class);
            Bundle b = new Bundle();
            b.putInt("score", score);
            intent.putExtras(b);
            startActivity(intent);




        }
    }
}
