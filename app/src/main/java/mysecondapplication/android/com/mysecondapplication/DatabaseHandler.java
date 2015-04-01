package mysecondapplication.android.com.mysecondapplication;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;


/**
 * Created by Aleksandar on 4/1/2015.
 */
public class DatabaseHandler extends SQLiteOpenHelper {

    private static final int DATABASE_VERSION = 1;

    private static final int DATABASE_NAME = 1;

    private static final String DATABASE_NAME = "dummy_database",
    TABLE_QUESTIONS = "questions",
    KEY_ID = "id",
    KEY_QUESTIONS = "question",
    KEY_ANSWER = "answer";

    public DatabaseHandler (Context new_context) {

        super(new_context, DATABASE_NAME, null, DATABASE_VERSION);

    }

    @Override
    public void onCreate (SQLiteDatabase db) {

        db.execSQL("NEW_TABLE" + TABLE_QUESTIONS + "(" + KEY_ID + "Number of question" + KEY_QUESTIONS + "Answer)");


    }
    @Override
    public void  onUpgrade (SQLiteDatabase db, int oldVersion, int newVersion ) {
        db.execSQL("Drop the table" + TABLE_QUESTIONS);

        onCreate(db);
    }
}
