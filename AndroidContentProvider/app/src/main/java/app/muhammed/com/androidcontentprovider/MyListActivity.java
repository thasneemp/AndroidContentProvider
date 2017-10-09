package app.muhammed.com.androidcontentprovider;

import android.database.Cursor;
import android.net.Uri;
import android.support.v4.app.LoaderManager;
import android.support.v4.content.CursorLoader;
import android.support.v4.content.Loader;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.ListViewCompat;

import app.muhammed.com.androidcontentprovider.adapters.MyCursorAdapter;
import app.muhammed.com.androidcontentprovider.db.MyContactProvider;

public class MyListActivity extends AppCompatActivity implements LoaderManager.LoaderCallbacks<Cursor> {

    private ListViewCompat mListViewCompat;
    private MyCursorAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_list);

        mListViewCompat = (ListViewCompat) findViewById(R.id.listView);


        adapter = new MyCursorAdapter(this, null, false);

        mListViewCompat.setAdapter(adapter);

        getSupportLoaderManager().initLoader(0, null, this);
    }

    @Override
    public Loader<Cursor> onCreateLoader(int id, Bundle args) {
        String[] projection = {

                "ID",
                "NAME"
        };

//        Cursor cursor = getContentResolver().query(Uri.withAppendedPath(MyContactProvider.CONTENT_AUTHORITY_URI, "CONTACT_MODEL"), projection, null, null, null);

        return new CursorLoader(this, Uri.withAppendedPath(MyContactProvider.CONTENT_AUTHORITY_URI, "CONTACT_MODEL"), projection, null, null, null);
    }

    @Override
    public void onLoadFinished(Loader<Cursor> loader, Cursor data) {

        adapter.swapCursor(data);

    }

    @Override
    public void onLoaderReset(Loader<Cursor> loader) {

        adapter.swapCursor(null);

    }
}
