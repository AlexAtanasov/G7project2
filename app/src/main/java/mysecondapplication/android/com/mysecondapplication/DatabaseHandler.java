package mysecondapplication.android.com.mysecondapplication;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.content.ContentValues;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class DatabaseHandler extends SQLiteOpenHelper {
    private static final int DATABASE_VERSION = 7;    //ATT!!! If you made any change into db - increase this int!!!
    // Database Name
    private static final String DATABASE_NAME = "QUESTION";
    // tasks table name
    private static final String TABLE_QUEST = "quest";
    // tasks Table Columns names
    private static final String KEY_ID = "id";
    private static final String KEY_FACT = "fact";
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
                + KEY_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +KEY_FACT + " TEXT, " +KEY_QUES
                + " TEXT, " +KEY_ANSWER + " TEXT, "+KEY_OPTA +" TEXT, "
                +KEY_OPTB +" TEXT)";
        db.execSQL(sql);
        addQuestions();
    }

    private void addQuestions() {

        Question id1 = new Question("Did you know that Poland is the ninth largest country in Europe.", "Is Krakow the capital of Poland?", "no", "yes", "no");
        this.insertIntoDb(id1);

        Question id2 = new Question("About two-thirds of Africa is in the Northern Hemisphere.", "Is Nigeria the largest country in Africa?", "no", "yes", "no");
        this.insertIntoDb(id2);

        Question id3 = new Question("Did you know that only three percent of Turkey lies in Europe.", "Is Turkey part of the EU?", "no", "yes", "no");
        this.insertIntoDb(id3);

        Question id4 = new Question("Rome, which is located in the center of Italy, is located at the exact same latitude as Chicago.", "Is Chicago the largest city in USA?", "no", "yes", "no");
        this.insertIntoDb(id4);

        Question id5 = new Question("Did you know that Brazil is a five time football World champion.", "Is Rio the largest city in Brazil?", "yes", "yes", "no");
        this.insertIntoDb(id5);

        Question id6 = new Question("Teheran, with its scorching summers, is located on the exact same latitude as relatively mild Tokyo, Japan.", "Is Teheran the capital of Iran?", "yes", "yes", "no");
        this.insertIntoDb(id6);

        Question id7 = new Question("Did you know that Brazil is the largest country in South America.", "Is Rio the capital of Brazil?", "no", "yes", "no");
        this.insertIntoDb(id7);

        Question id8 = new Question("France is approximately 30% larger than the state of California.", "Is Los Angeles the capital of the state of California?", "no", "yes", "no");
        this.insertIntoDb(id8);

        Question id9 = new Question("Did you know that United Stated purchased Alaska from Russia in 1867 for 7.2 million dollars.", "Is Alaska the largest state in the USA?", "yes", "yes", "no");
        this.insertIntoDb(id9);

        Question id10 = new Question("About 90% of the worlds population lives in the Northern Hemisphere.", "Is Australia the largest county by area in the Southern Hemisphere?", "yes", "yes", "no");
        this.insertIntoDb(id10);

        Question id11 = new Question("Did you know that Russian is official language in Kazakhstan.", "Is Astana capital of Kazakhstan?", "yes", "yes", "no");
        this.insertIntoDb(id11);

        Question id12 = new Question("The composition of the Philippines archipelago includes 7107 islands.", "Is Manila the capital of the Philippines?", "yes", "yes", "no");
        this.insertIntoDb(id12);

        Question id13 = new Question("Did you know that Great Britain was a World ice hockey champion in 1936.", "Is United Kingdom in the European union?", "yes", "yes", "no");
        this.insertIntoDb(id13);

        Question id14 = new Question("Seven largest countries in the world occupy half of our planet’s territory.", "Is Argentina the largest country in South America?", "no", "yes", "no");
        this.insertIntoDb(id14);

        Question id15 = new Question("Did you know that Bulgaria is the biggest producer of roses in the world.", "Is Sofia the capital of Bulgaria?", "yes", "yes", "no");
        this.insertIntoDb(id15);

        Question id16 = new Question("The largest desert in Europe is Ryn Sands. It is located between the Volga river and the Ural mountain.", "Is Volga the longest river in Europe?", "yes", "yes", "no");
        this.insertIntoDb(id16);

        Question id17 = new Question("Did you know that Greenland is part of the Kingdom of Denmark.", "Is Bergen a city in Denmark?", "no", "yes", "no");
        this.insertIntoDb(id17);

        Question id18 = new Question("Japan lies on more than 3900 islands.", "Is Tokyo the largest city in Japan?", "yes", "yes", "no");
        this.insertIntoDb(id18);

        Question id19 = new Question("Did you know that Canada has more lakes than the rest of the world combined.", "Is Vancouver the capital of Canada?", "no", "yes", "no");
        this.insertIntoDb(id19);

        Question id20 = new Question("There are 3 towns called Peru in the USA.", "Is Lima the capital of Peru?", "yes", "yes", "no");
        this.insertIntoDb(id20);

        Question id21 = new Question("Did you know that Istanbul is the only city in the world located on two continents.", "Is Istanbul the capital of Turkey?", "no", "yes", "no");
        this.insertIntoDb(id21);

        Question id22 = new Question("Less than 1 percent of the Caribbean islands are inhabited.", "Is Jamaica the largest island in the Caribbean?", "no", "yes", "no");
        this.insertIntoDb(id22);

        Question id23 = new Question("Did you know that there are more Irish in New York City than in Dublin.", "Is Dublin the capital of Ireland?", "yes", "yes", "no");
        this.insertIntoDb(id23);

        Question id24 = new Question("Of the 25 highest peaks of the world, 19 are in the Himalayas.", "Are the Himalayas in South America?", "no", "yes", "no");
        this.insertIntoDb(id24);

        Question id25 = new Question("Did you know that Siberia contains more than 25% of the world's forests.", "Is Siberia a country?", "no", "yes", "no");
        this.insertIntoDb(id25);

        Question id26 = new Question("336 rivers empty into Lake Baikal, but it has only one that flows out.", "Is the Lake Baikal the deepest lake in the World?", "yes", "yes", "no");
        this.insertIntoDb(id26);

        Question id27 = new Question("Did you know that Spain literally means 'the land of rabbits.'", "Is Cordoba a city in Spain?", "yes", "yes", "no");
        this.insertIntoDb(id27);

        Question id28 = new Question("Cuba is the only Caribbean island, which has a railway.", "Is Havana the capital of Cuba?", "yes", "yes", "no");
        this.insertIntoDb(id28);

        Question id29 = new Question("Did you know that the first city to reach a population of 1 million people was Rome.", "Is Rome the capital of Italy?", "yes", "yes", "no");
        this.insertIntoDb(id29);

        Question id30 = new Question("There are the 17 active volcanoes In Japan", "Is Mount Fuji the highest mountain in Japan?", "yes", "yes", "no");
        this.insertIntoDb(id30);

        Question id31 = new Question("Did you know that next to Warsaw Chicago has the largest Polish population in the world.", "Is Warsaw the capital of Poland?", "yes", "yes", "no");
        this.insertIntoDb(id31);

        Question id32 = new Question("One of the largest Icelandic geysers, located on the slopes of the volcano Hekla, is called simply Geyser.", "Is Iceland in the EU?", "no", "yes", "no");
        this.insertIntoDb(id32);

        Question id33 = new Question("Did you know that almost to the end of the 1980s there was not a single phone in Bhutan.", "Is Bhutan a country in Africa?", "no", "yes", "no");
        this.insertIntoDb(id33);

        Question id34 = new Question("There are no rivers in Saudi Arabia", "Is Saudi Arabia the largest Arab state?", "yes", "yes", "no");
        this.insertIntoDb(id34);

        Question id35 = new Question("Did you know that the Red Sea is the warmest sea in the world.", "Is Israel on the coast of the Red Sea?", "yes", "yes", "no");
        this.insertIntoDb(id35);

        Question id36 = new Question("Indonesia is located on 17508 islands.", "Is Indonesia a kingdom?", "no", "yes", "no");
        this.insertIntoDb(id36);

        Question id37 = new Question("Did you know that in South America the only two countries that do not have access to the ocean are Bolivia and Paraguay.", "Is Bolivia bigger country by area than Paraguay?", "yes", "yes", "no");
        this.insertIntoDb(id37);

        Question id38 = new Question("Budapest was originally two separate cities, Buda and Pest. The 2 areas are separated by the Danube River.", "Is Budapest the capital of Slovakia?", "no", "yes", "no");
        this.insertIntoDb(id38);

        Question id39 = new Question("Did you know that the most distant spot from all of the oceans on Earth lies in China.", "Is Shanghai the largest city in China?", "yes", "yes", "no");
        this.insertIntoDb(id39);

        Question id40 = new Question("Iceland, the “Land of Fire and Ice” has more than 200 volcanoes and 120 glaciers.", "Is Reykjavik the capital of Iceland?", "yes", "yes", "no");
        this.insertIntoDb(id40);

        Question id41 = new Question("Did you know that India is the World's largest producer of bananas.", "Is Bombay the capital of India?", "no", "yes", "no");
        this.insertIntoDb(id41);

        Question id42 = new Question("Sweden is the third largest country in EU by area.", "Is Sweden in NATO?", "no", "yes", "no");
        this.insertIntoDb(id42);

        Question id43 = new Question("Did you know that the oldest continuously used national flag is that of Denmark.", "Is the oldest Legoland in Denmark?", "yes", "yes", "no");
        this.insertIntoDb(id43);

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
        values.put(KEY_FACT, quest.getFact());
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
        rowcount();
        if (cursor.moveToFirst()) {
            do {
                Question quest = new Question();
                quest.setId(cursor.getInt(0));
                quest.setFact(cursor.getString(1));
                quest.setQuestion(cursor.getString(2));
                quest.setAnswer(cursor.getString(3));
                quest.setOption_yes(cursor.getString(4));
                quest.setOption_no(cursor.getString(5));

                quesList.add(quest);

            } while (cursor.moveToNext());
        }
        Collections.shuffle(quesList);

        // return quest list

        return quesList;
    }
    public int rowcount(){
        int row=0;
        String selectQuery = "SELECT * FROM " + TABLE_QUEST;
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);
        row=cursor.getCount();
        return row;
    }
}
