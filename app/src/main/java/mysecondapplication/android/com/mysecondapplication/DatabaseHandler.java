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

        Question id1  = new Question("Is Stockholm city in Sweden??", "yes", "no", "yes");
        this.insertIntoDb(id1);
        Question id2  = new Question("Is Boston capital of USA?", "yes", "no", "no");
        this.insertIntoDb(id2);
        Question id3  = new Question("Is Ottawa capital of Canada?", "yes", "no", "yes");
        this.insertIntoDb(id3);
        Question id4  = new Question("Is Bern city in France?", "yes", "no", "no");
        this.insertIntoDb(id4);
        Question id5  = new Question("Is Barcelona capital of Spain?", "yes", "no", "no");
        this.insertIntoDb(id5);
        Question id6  = new Question("Is Astana capital of Kazakhstan?", "yes", "no", "yes");
        this.insertIntoDb(id6);
        Question id7  = new Question("Is Dubai capital of UAE?", "yes", "no", "no");
        this.insertIntoDb(id7);
        Question id8  = new Question("Is Rio de Janeiro capital of Brazil?", "yes", "no", "no");
        this.insertIntoDb(id8);
        Question id9  = new Question("Is Vancouver capital of Canada?", "yes", "no", "no");
        this.insertIntoDb(id9);
        Question id10  = new Question("Is Lyon city in France?", "yes", "no", "yes");
        this.insertIntoDb(id10);
        Question id11  = new Question("Is Islamabad capital of Pakistan?", "yes", "no", "yes");
        this.insertIntoDb(id11);
        Question id12  = new Question("Is Guam part of USA?", "yes", "no", "yes");
        this.insertIntoDb(id12);
        Question id13  = new Question("Is Minsk capital of Ukraine?", "yes", "no", "no");
        this.insertIntoDb(id13);
        Question id14  = new Question("Is Istanbul capital of Turkey?", "yes", "no", "no");
        this.insertIntoDb(id14);
        Question id15  = new Question("Is Sofia capital of Bulgaria?", "yes", "no", "yes");
        this.insertIntoDb(id15);

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
