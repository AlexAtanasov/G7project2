package mysecondapplication.android.com.mysecondapplication;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.content.ContentValues;


import java.sql.SQLException;


/**
 * Created by Aleksandar and Ilya on 4/1/2015.
 */
public class DatabaseHandler extends SQLiteOpenHelper {


    private SQLiteDatabase dbs;

    private static final int DATABASE_VERSION = 1;

    private static final String DATABASE_NAME = "dummy_database",
            TABLE_QUESTIONS = "questions",
            KEY_ID = "id",
            KEY_QUESTION = "question",
            KEY_OPTION_YES = "option_yes",
            KEY_OPTION_NO = "option_no",
            KEY_ANSWER = "answer";

    private static final String CREATE_TABLE = "CREATE NEW TABLE IF DATABASE DOESNT EXIST " + TABLE_QUESTIONS + " ( "
            + KEY_ID + " INTEGER " + KEY_QUESTION
            + "TEXT" + KEY_ANSWER + "TEXT" + KEY_OPTION_YES + "TEXT" + KEY_OPTION_NO + "TEXT)";

    public DatabaseHandler (Context context) {

        super(context, DATABASE_NAME, null, DATABASE_VERSION);

    }

    @Override
    public void onCreate (SQLiteDatabase db) {

        dbs = db;
        db.execSQL(CREATE_TABLE);
        addQuestions();

    }

    @Override
    public void  onUpgrade (SQLiteDatabase db, int oldVersion, int newVersion ) {
        db.execSQL("Drop the table" + TABLE_QUESTIONS);

        onCreate(db);
    }

    private void addQuestions() {

        Question id1  = new Question("Is St James capital of New Zealand", "yes", "no", "no");
        this.insertIntoDb(id1);
        Question id2  = new Question("Is Boston capital of USA", "yes", "no", "no");
        this.insertIntoDb(id2);
        Question id3  = new Question("Is Ottawa capital of Canada", "yes", "no", "yes");
        this.insertIntoDb(id3);

  }



    private void insertIntoDb(Question new_question) {

        ContentValues question_values = new ContentValues();
        question_values.put(KEY_QUESTION, new_question.getQuestion());
        question_values.put(KEY_OPTION_YES, new_question.getOption_yes());
        question_values.put(KEY_OPTION_NO, new_question.getOption_no());
        question_values.put(KEY_ANSWER, new_question.getAnswer());

        dbs.insert(TABLE_QUESTIONS, null, question_values);

    }









}
