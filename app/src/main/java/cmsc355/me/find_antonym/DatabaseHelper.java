package cmsc355.me.find_antonym;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by gelbe on 3/21/2018.
 */

public class DatabaseHelper extends SQLiteOpenHelper {

    private static final int DATABASE_VERSION = 1;
    private static final String DATABASE_NAME = "antonym.db";
    private static final String TABLE_NAME = "findantonym";
    private static final String COLUMN_WORD = "word";
    private static final String COLUMN_ANT = "antonym";
    SQLiteDatabase db;

    private static final String TABLE_CREATE = "create table findantonym (id integer primary key autoincrement, " +
            "word text not null, antonym text not null);";

    public DatabaseHelper(Context context){
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(TABLE_CREATE);
        this.db = db;
        ContentValues values= new ContentValues();
        values.put(COLUMN_WORD, "new");
        values.put(COLUMN_ANT,  "old");
        db.insert(TABLE_NAME, null, values);
        values.put(COLUMN_WORD, "first");
        values.put(COLUMN_ANT,  "last");
        db.insert(TABLE_NAME, null, values);
        values.put(COLUMN_WORD, "big");
        values.put(COLUMN_ANT,  "little");
        db.insert(TABLE_NAME, null, values);
        values.put(COLUMN_WORD, "smart");
        values.put(COLUMN_ANT,  "stupid");
        db.insert(TABLE_NAME, null, values);
        values.put(COLUMN_WORD, "good");
        values.put(COLUMN_ANT,  "bad");
        db.insert(TABLE_NAME, null, values);
        values.put(COLUMN_WORD, "short");
        values.put(COLUMN_ANT,  "long");
        db.insert(TABLE_NAME, null, values);
        values.put(COLUMN_WORD, "important");
        values.put(COLUMN_ANT,  "insignificant");
        db.insert(TABLE_NAME, null, values);
        //values.put(COLUMN_WORD, "happy");
        //values.put(COLUMN_ANT,  "sad");
        //db.insert(TABLE_NAME, null, values);
    }

    public void insertWord(findAntonym a){
        db = this.getWritableDatabase();
        ContentValues values= new ContentValues();

        String query = "select * from findantonym";
        Cursor cursor = db.rawQuery(query, null);

        values.put(COLUMN_WORD, a.getWord());
        values.put(COLUMN_ANT, a.getAnt());

        db.insert(TABLE_NAME,null,values);
        db.close();
    }

    public String searchAnt(String word){
        db = this.getReadableDatabase();
        String query = "select word, antonym from "+TABLE_NAME;
        Cursor cursor = db.rawQuery(query,null);
        String a, a2, b;
        b = null;
        if(cursor.moveToFirst()){
            do{
                a = cursor.getString(0);
                a2 = cursor.getString(1);
                if(a.equals(word)){
                    b = cursor.getString(1);
                    break;
                }
                else if(a2.equals(word)){
                    b = cursor.getString(0);
                    break;
                }
            }
            while(cursor.moveToNext());
        }
        return b;
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
        String query = "DROP TABLE IF EXISTS "+TABLE_NAME;
        db.execSQL(query);
        this.onCreate(db);
    }
}
