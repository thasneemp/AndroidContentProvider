package app.muhammed.com.androidcontentprovider.db;

import android.content.ContentProvider;
import android.content.ContentUris;
import android.content.ContentValues;
import android.content.UriMatcher;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

/**
 * Created by Muhammed on 08/10/17.
 */

public class MyContactProvider extends ContentProvider {
    public static final int CONTACTS = 101;
    public static final int CONTACTS_ID = 102;

    private static final UriMatcher uriMatcher = new UriMatcher(UriMatcher.NO_MATCH);

    static {

        uriMatcher.addURI(MyDbContract.CONTENT_AUTHORITY, MyDbContract.MyDBTable.CONTACT_TABLE, CONTACTS);
        uriMatcher.addURI(MyDbContract.CONTENT_AUTHORITY, MyDbContract.MyDBTable.CONTACT_TABLE + "/#", CONTACTS_ID);

    }

    private MyDb myDb;


    @Override
    public boolean onCreate() {

        myDb = new MyDb(getContext());

        return false;
    }

    @Nullable
    @Override
    public Cursor query(@NonNull Uri uri, @Nullable String[] projection, @Nullable String selection, @Nullable String[] selectionArgs, @Nullable String sortOrder) {

        int match = uriMatcher.match(uri);
        SQLiteDatabase database = myDb.getReadableDatabase();
        Cursor cursor;
        switch (match) {
            case CONTACTS:
                cursor = database.query(MyDbContract.MyDBTable.CONTACT_TABLE, projection, null, null, null, null, sortOrder);
                break;
            case CONTACTS_ID:
                selection = MyDbContract.MyDBTable.ID + "=?";
                selectionArgs = new String[]{String.valueOf(ContentUris.parseId(uri))};
                cursor = database.query(MyDbContract.MyDBTable.CONTACT_TABLE, projection, selection, selectionArgs, null, null, sortOrder);
                break;
            default:
                throw new IllegalArgumentException("Uri not found " + uri);
        }
        cursor.setNotificationUri(getContext().getContentResolver(), uri);
        return cursor;
    }

    @Nullable
    @Override
    public String getType(@NonNull Uri uri) {
        return null;
    }

    @Nullable
    @Override
    public Uri insert(@NonNull Uri uri, @Nullable ContentValues contentValues) {
        SQLiteDatabase database = myDb.getWritableDatabase();
        int match = uriMatcher.match(uri);
        switch (match) {
            case CONTACTS:

                long contact_model = database.insert(MyDbContract.MyDBTable.CONTACT_TABLE, null, contentValues);

                if (contact_model > 0) {

                    getContext().getContentResolver().notifyChange(uri, null);
                    return ContentUris.withAppendedId(uri, contact_model);
                } else {

                    throw new SQLException("Insertion failed " + uri);
                }


            default:
                throw new IllegalArgumentException("Uri not found " + uri);
        }
    }

    @Override
    public int delete(@NonNull Uri uri, @Nullable String s, @Nullable String[] strings) {
        return 0;
    }

    @Override
    public int update(@NonNull Uri uri, @Nullable ContentValues contentValues, @Nullable String s, @Nullable String[] strings) {
        return 0;
    }
}
