package app.muhammed.com.androidcontentprovider.db;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by Muhammed on 08/10/17.
 */

public class MyDb extends SQLiteOpenHelper {
    public MyDb(Context context) {
        super(context, "contentprovider.db", null, 2);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {

    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }
}
