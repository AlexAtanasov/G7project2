package mysecondapplication.android.com.mysecondapplication;

import android.content.Context;
import android.speech.tts.TextToSpeech;
import android.util.Log;
import java.util.Locale;

/**
 * Created by WorkTop on 3/9/2015.
 */

public class TxtS {
    private TextToSpeech TxtSp = null;
    private boolean load = false;

    private TextToSpeech.OnInitListener onInit = new TextToSpeech.OnInitListener() {

        public void onInit(int status) {

            if (status == TextToSpeech.SUCCESS) {
                int result = TxtSp.setLanguage(Locale.US);
                load = true;

                if (result == TextToSpeech.LANG_MISSING_DATA || result == TextToSpeech.LANG_NOT_SUPPORTED) {
                    Log.e("error", "Language not supported !!!!!!!");
                }
            } else {
                Log.e("error", "Unsuccessful initialization !!!!");
            }
        }
    };

    public void initialize(Context context) {
        try {
            TxtSp = new TextToSpeech(context, onInit);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void initText(String text) {
        if (load)
            TxtSp.speak(text, TextToSpeech.QUEUE_FLUSH, null);
        else
            Log.e("error", "TextToSpeech failed to Initialize");
    }

    public void addText(String text){
        if (load)
            TxtSp.speak(text, TextToSpeech.QUEUE_ADD, null);
        else
            Log.e("error", "TextToSpeech failed to Initialize");
    }

    public void shutDown() {
        TxtSp.shutdown();
    }
}

