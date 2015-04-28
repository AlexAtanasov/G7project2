package mysecondapplication.android.com.mysecondapplication;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.content.ContentValues;


import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DatabaseHandler extends SQLiteOpenHelper {
    private static final int DATABASE_VERSION = 1;
    // Database Name
    private static final String DATABASE_NAME = "triviaQuiz";
    // tasks table name
    private static final String TABLE_QUEST = "quest";
    // tasks Table Columns names
    private static final String KEY_ID = "id";
    private static final String KEY_QUES = "question";
    private static final String KEY_ANSWER = "answer"; //correct option
    private static final String KEY_OPTA= "opta"; //option a
    private static final String KEY_OPTB= "optb"; //option b

    private SQLiteDatabase dbase;

    public DatabaseHandler(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }
    @Override
    public void onCreate(SQLiteDatabase db) {
        dbase=db;
        String sql = "CREATE TABLE IF NOT EXISTS " + TABLE_QUEST + " ( "
                + KEY_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " + KEY_QUES
                + " TEXT, " + KEY_ANSWER+ " TEXT, "+KEY_OPTA +" TEXT, "
                +KEY_OPTB +" TEXT)";
        db.execSQL(sql);
        addQuestions();
        //db.close();
    }



    private void addQuestions() {

        Question id1  = new Question("Is Stockholm a city in Sweden", "yes", "yes", "no");
        this.insertIntoDb(id1);
        Question id2  = new Question("Is Boston capital of USA?", "no", "yes", "no");
        this.insertIntoDb(id2);
        Question id3  = new Question("Is Ottawa capital of Canada?", "yes", "yes", "no");
        this.insertIntoDb(id3);
        Question id4  = new Question("Is Bern city in France?", "no", "yes", "no");
        this.insertIntoDb(id4);
        Question id5  = new Question("Is Barcelona capital of Spain?", "no", "yes", "no");
        this.insertIntoDb(id5);
        Question id6  = new Question("Is Astana capital of Kazakhstan?", "yes", "yes", "no");
        this.insertIntoDb(id6);
        Question id7  = new Question("Is Dubai capital of UAE?", "no", "yes", "no");
        this.insertIntoDb(id7);
        Question id8  = new Question("Is Rio de Janeiro capital of Brazil?", "no", "yes", "no");
        this.insertIntoDb(id8);
        Question id9  = new Question("Is Vancouver capital of Canada?", "no", "yes", "no");
        this.insertIntoDb(id9);
        Question id10  = new Question("Is Lyon city in France?", "no", "yes", "no");
        this.insertIntoDb(id10);
        Question id11  = new Question("Is Islamabad capital of Pakistan?", "yes", "yes", "no");
        this.insertIntoDb(id11);
        Question id12  = new Question("Is Guam part of USA?", "yes", "yes", "no");
        this.insertIntoDb(id12);
        Question id13  = new Question("Is Minsk capital of Ukraine?", "no", "yes", "no");
        this.insertIntoDb(id13);
        Question id14  = new Question("Is Istanbul capital of Turkey?", "no", "yes", "no");
        this.insertIntoDb(id14);
        Question id15  = new Question("Is Sofia capital of Bulgaria?", "yes", "yes", "no");
        this.insertIntoDb(id15);

  }

    public void onUpgrade(SQLiteDatabase db, int oldV, int newV) {
        // Drop older table if existed
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_QUEST);
        // Create tables again
        onCreate(db);
    }
    // Adding new question
    public void insertIntoDb(Question quest) {
        //SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(KEY_QUES, quest.getQuestion());
        values.put(KEY_ANSWER, quest.getAnswer());
        values.put(KEY_OPTA, quest.getOption_yes());
        values.put(KEY_OPTB, quest.getOption_no());

        // Inserting Row
        dbase.insert(TABLE_QUEST, null, values);
    }
    public List<Question> getAllQuestions() {
        List<Question> quesList = new ArrayList<Question>();
        // Select All Query
        String selectQuery = "SELECT  * FROM " + TABLE_QUEST;
        dbase=this.getReadableDatabase();
        Cursor cursor = dbase.rawQuery(selectQuery, null);
        // looping through all rows and adding to list
        if (cursor.moveToFirst()) {
            do {
                Question quest = new Question();
                quest.setId(cursor.getInt(0));
                quest.setQuestion(cursor.getString(1));
                quest.setAnswer(cursor.getString(2));
                quest.setOption_yes(cursor.getString(3));
                quest.setOption_no(cursor.getString(4));

                quesList.add(quest);
            } while (cursor.moveToNext());
        }
        // return quest list
        return quesList;
    }
    public int rowcount()
    {
        int row=0;
        String selectQuery = "SELECT  * FROM " + TABLE_QUEST;
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);
        row=cursor.getCount();
        return row;
    }
}
