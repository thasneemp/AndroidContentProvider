package app.muhammed.com.androidcontentprovider.db;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by Muhammed on 08/10/17.
 */

public class MyDb extends SQLiteOpenHelper {
    public MyDb(Context context) {
        super(context, MyDbContract.DB_NAME, null, MyDbContract.DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL(MyDbContract.MyDBTable.CREATE_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }
}
