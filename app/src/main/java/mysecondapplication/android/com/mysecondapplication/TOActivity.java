package mysecondapplication.android.com.mysecondapplication;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Gravity;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

public class TOActivity extends ActionBarActivity {

    List<Question> quesList;
    int score = 0;
    int qid = 0;
    Question currentQ;
    TextView txtQuestion;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_to);

        DatabaseHandler db = new DatabaseHandler(this);
        quesList=db.getAllQuestions();
        currentQ=quesList.get(qid);
        txtQuestion=(TextView)findViewById(R.id.questionText);

        setQuestionView();


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




        } else {
            Context context = getApplicationContext();
            CharSequence text = "yes";
            int duration = Toast.LENGTH_SHORT;

            Toast toast;
            toast = Toast.makeText(context,"Incorrect!", Toast.LENGTH_SHORT);
            toast.show();


            toast.setGravity(Gravity.CENTER_HORIZONTAL | Gravity.START, 370, 95);


        }
        if(qid<11) {
            currentQ = quesList.get(qid);
            setQuestionView();
        }

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




        } else {
            Context context = getApplicationContext();
            CharSequence text = "yes";
            int duration = Toast.LENGTH_SHORT;

            Toast toast;
            toast = Toast.makeText(context,"Incorrect!", Toast.LENGTH_SHORT);
            toast.show();


            toast.setGravity(Gravity.CENTER_HORIZONTAL | Gravity.START, 370, 95);


        }

        currentQ = quesList.get(qid);

        if(qid<11) {

            setQuestionView();

         }


    }

    public void setQuestionView()
    {

        txtQuestion.setText(currentQ.getQuestion());

        qid++;

        if (qid==11) {


            Intent intent = new Intent(this, ScoreTOActivity.class);
            Bundle b = new Bundle();
            b.putInt("score", score);
            intent.putExtras(b);
            startActivity(intent);

        }
    }
}
