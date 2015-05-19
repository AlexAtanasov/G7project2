package mysecondapplication.android.com.mysecondapplication;

        import android.content.Context;
        import android.content.Intent;
        import android.os.Bundle;
        import android.os.Handler;
        import android.support.v7.app.ActionBarActivity;
        import android.view.Gravity;
        import android.view.View;
        import android.widget.TextView;
        import android.widget.Toast;
        import java.util.List;

public class MainActivity extends ActionBarActivity {
    List<Question> questionList;
    int score = 0;
    int questionID = 0;
    Question currentQuestion;
    TextView txtQuestion;
    TxtS ttsp = null;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ttsp = new TxtS();
        ttsp.initialize(this);

        Handler h = new Handler();

        DatabaseHandler db = new DatabaseHandler(this);
        questionList=db.getAllQuestions();
        currentQuestion=questionList.get(questionID);

        txtQuestion=(TextView)findViewById(R.id.questionFact);
        txtQuestion=(TextView)findViewById(R.id.questionText);

        setQuestionView();

        h.postDelayed(new Runnable() {
            @Override
            public void run() {

                ttsp.addText(currentQuestion.toFact());
                ttsp.addText(currentQuestion.getQuestion());
            }
        }, 400);
    }

    public void onClickYes(View view) {

       if(currentQuestion.getAnswer().equals("yes")) {

            score++;
            Context context = getApplicationContext();
            CharSequence text = "yes";
            int duration = Toast.LENGTH_SHORT;

            String cor = "Correct!";
            ttsp.initText(cor);

        } else {
            Context context = getApplicationContext();
            CharSequence text = "yes";
            int duration = Toast.LENGTH_SHORT;

            String wro = "Incorrect!";
            ttsp.initText(wro);
        }

        currentQuestion = questionList.get(questionID);
        setQuestionView();
        if(questionID < 11) {
            ttsp.addText(currentQuestion.toFact());
            ttsp.addText(currentQuestion.getQuestion());
        }
    }

    public void onClickRepeat(View view) {
        //ttsp.addText(currentQ.toFact());
        ttsp.addText(currentQuestion.getQuestion());
    }

    public void onClickNo(View view){

        if(currentQuestion.getAnswer().equals("no")) {

            score++;
            Context context = getApplicationContext();
            CharSequence text = "no";
            int duration = Toast.LENGTH_SHORT;

            String cor = "Correct!";
            ttsp.initText(cor);

        } else {

            Context context = getApplicationContext();
            CharSequence text = "yes";
            int duration = Toast.LENGTH_SHORT;

            String wro = "Incorrect!";
            ttsp.initText(wro);
        }

        currentQuestion = questionList.get(questionID);
        setQuestionView();
        if(questionID < 11) {
            ttsp.addText(currentQuestion.toFact());
            ttsp.addText(currentQuestion.getQuestion());
        }
    }

    public void setQuestionView(){
        txtQuestion.setText(currentQuestion.getFact());
        txtQuestion.setText(currentQuestion.getQuestion());

        questionID++;

        if (questionID == 11) {

            Intent intent = new Intent(this, ScoreActivity.class);
            Bundle b = new Bundle();
            b.putInt("score", score);
            intent.putExtras(b);
            startActivity(intent);
        }
    }
}
