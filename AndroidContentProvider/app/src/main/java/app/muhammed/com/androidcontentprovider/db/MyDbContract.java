package app.muhammed.com.androidcontentprovider.db;

import android.net.Uri;

/**
 * Created by muhammed on 10/9/2017.
 */

public class MyDbContract {
    public static final String CONTENT_AUTHORITY = "app.muhammed.com.androidcontentprovider.db";
    public static final String CONTENT_AUTHORITY_URI = "content://app.muhammed.com.androidcontentprovider.db";
    public static final String DB_NAME = "contentprovider";
    public static final int DB_VERSION = 2;
    public static final Uri CONTACT_PATH_URI = Uri.withAppendedPath(Uri.parse(CONTENT_AUTHORITY_URI), MyDBTable.CONTACT_TABLE);
    public static final Uri CONTACT_PATH_ID_URI = Uri.withAppendedPath(Uri.parse(CONTENT_AUTHORITY_URI), MyDBTable.CONTACT_TABLE + "/");


    public MyDbContract() {
    }

    public static final class MyDBTable {

        public static final String CONTACT_TABLE = "contact_table";


        public static final String ID = "_id";
        public static final String NAME = "name";
        public static final String PHONE = "phone";
        public static final String EMAIL = "email";
        public static final String ADDRESS = "address";


        public static final String CREATE_TABLE = "CREATE TABLE "
                + CONTACT_TABLE + "(" + ID + " INTEGER PRIMARY KEY AUTOINCREMENT,"
                + NAME + " TEXT,"
                + PHONE + " TEXT,"
                + EMAIL + " TEXT,"
                + ADDRESS + " TEXT)";

    }
}
