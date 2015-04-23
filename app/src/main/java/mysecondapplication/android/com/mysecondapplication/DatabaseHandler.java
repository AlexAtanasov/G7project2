package mysecondapplication.android.com.mysecondapplication;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;


import java.sql.SQLException;


/**
 * Created by Aleksandar and Ilya on 4/1/2015.
 */
public class DatabaseHandler extends SQLiteOpenHelper {

    private static final int DATABASE_VERSION = 1;


    private static final String DATABASE_NAME = "dummy_database.db",

    TABLE_QUESTIONS = "questions",
            KEY_ID = "id",
            KEY_QUESTIONS = "question",
            KEY_ANSWER = "answer";

    private static final String CREATE_TABLE = "NEW_TABLE" + TABLE_QUESTIONS + "(" + KEY_ID + "Number of question" + KEY_QUESTIONS  + "Question" + KEY_ANSWER + "Answer)";

    public DatabaseHandler (Context context) {

        super(context, DATABASE_NAME, null, DATABASE_VERSION);

    }

    @Override
    public void onCreate (SQLiteDatabase db) {

        db.execSQL(CREATE_TABLE);
        addQuestions();






    }

    private void addQuestions() {

        Question id1  = new Question("Is St James capital of New Zealand", "yes", "no", "no");



    }







    @Override
    public void  onUpgrade (SQLiteDatabase db, int oldVersion, int newVersion ) {
        db.execSQL("Drop the table" + TABLE_QUESTIONS);

        onCreate(db);
    }
}
