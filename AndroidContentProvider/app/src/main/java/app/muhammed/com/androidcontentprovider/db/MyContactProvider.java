package app.muhammed.com.androidcontentprovider.db;

import android.content.ContentProvider;
import android.content.ContentUris;
import android.content.ContentValues;
import android.content.UriMatcher;
import android.database.Cursor;
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


    private static final String CONTENT_STRING = "app.muhammed.com.androidcontentprovider.db";
    public static final String CONTENT_AUTHORITY = "content://" + CONTENT_STRING;
    public static final Uri CONTENT_AUTHORITY_URI = Uri.parse(CONTENT_AUTHORITY);

    public static final Uri CONTACT_PATH = Uri.withAppendedPath(Uri.parse(CONTENT_AUTHORITY), "CONTACT_MODEL");

    public static final Uri CONTACT_PATH_ID = Uri.withAppendedPath(Uri.parse(CONTENT_AUTHORITY), "CONTACT_MODEL/");
    private static final UriMatcher uriMatcher = new UriMatcher(UriMatcher.NO_MATCH);

    static {

        uriMatcher.addURI(CONTENT_STRING, "CONTACT_MODEL", CONTACTS);
        uriMatcher.addURI(CONTENT_STRING, "CONTACT_MODEL/#", CONTACTS_ID);

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
        Cursor cursor = null;
        switch (match) {
            case CONTACTS:
                break;
            case CONTACTS_ID:

                selection = "ID=?";

                selectionArgs = new String[]{String.valueOf(ContentUris.parseId(uri))};
                cursor = database.query("CONTACT_MODEL", projection, selection, selectionArgs, null, null, sortOrder);

                break;
            default:
                throw new IllegalArgumentException("Uri not found " + uri);
        }
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
        return null;
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
