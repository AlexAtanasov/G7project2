package mysecondapplication.android.com.mysecondapplication;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.speech.RecognizerIntent;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Viktor on 2015-05-19.
 */
public class VoiceRecognition extends Activity {
    int REQUEST_OK = 1;
    Question currentQuestion;
    TxtS ttsp = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    public void onListen() {
        Intent i = new Intent(RecognizerIntent.ACTION_RECOGNIZE_SPEECH);
        i.putExtra(RecognizerIntent.EXTRA_LANGUAGE_MODEL, "en-US");
        try {
            startActivityForResult(i, REQUEST_OK);
        } catch (Exception e) {
            Toast.makeText(this, "Error initializing speech to text engine.", Toast.LENGTH_LONG).show();
        }
    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == REQUEST_OK && resultCode == RESULT_OK) {
            ArrayList<String> thingsYouSaid = data.getStringArrayListExtra(RecognizerIntent.EXTRA_RESULTS);

            if (thingsYouSaid.get(0) == currentQuestion.getAnswer()) {

            }
            else if(thingsYouSaid.get(0) == "Repeat"){
                ttsp.addText(currentQuestion.getQuestion());
            }
            else{
                ttsp.addText("Unable to recognise");
            }
        }
    }
}
