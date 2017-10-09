package app.muhammed.com.androidcontentprovider;

import android.content.ContentUris;
import android.content.ContentValues;
import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.LoaderManager;
import android.support.v4.content.CursorLoader;
import android.support.v4.content.Loader;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import app.muhammed.com.androidcontentprovider.db.MyDbContract;

public class MainActivity extends AppCompatActivity implements View.OnClickListener, LoaderManager.LoaderCallbacks<Cursor> {

    private Button mInsertButton;
    private Button mGotoButton;
    private TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mInsertButton = (Button) findViewById(R.id.button);
        mGotoButton = (Button) findViewById(R.id.button2);
        textView = (TextView) findViewById(R.id.textView);


        mInsertButton.setOnClickListener(this);
        mGotoButton.setOnClickListener(this);


        getSupportLoaderManager().initLoader(0, null, this);

    }

    @Override
    public void onClick(View view) {

        switch (view.getId()) {
            case R.id.button:
                ContentValues values = new ContentValues();

                values.put(MyDbContract.MyDBTable.NAME, "Muhammed");
                values.put(MyDbContract.MyDBTable.PHONE, "8086461927");
                values.put(MyDbContract.MyDBTable.EMAIL, "muhammed.thasneem@yahoo.com");
                values.put(MyDbContract.MyDBTable.ADDRESS, "Ernakulam");
                Uri contactPathUri = MyDbContract.CONTACT_PATH_URI;
                Uri insert = getContentResolver().insert(contactPathUri, values);

                Toast.makeText(this, String.valueOf(ContentUris.parseId(insert)), Toast.LENGTH_SHORT).show();
                break;
            default:
                startActivity(new Intent(this, MyListActivity.class));
                break;
        }


    }

    @Override
    public Loader<Cursor> onCreateLoader(int id, Bundle args) {
        String[] projection = {

                MyDbContract.MyDBTable.ID,
                MyDbContract.MyDBTable.NAME,
                MyDbContract.MyDBTable.EMAIL
        };
        return new CursorLoader(this, MyDbContract.CONTACT_PATH_URI, projection, null, null, null);
    }

    @Override
    public void onLoadFinished(Loader<Cursor> loader, Cursor data) {
        textView.setText("");
        while (data.moveToNext()) {
            textView.append("Name : " + data.getString(data.getColumnIndex(MyDbContract.MyDBTable.NAME)) + "\n");
        }
    }

    @Override
    public void onLoaderReset(Loader<Cursor> loader) {

    }
}
