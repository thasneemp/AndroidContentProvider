package app.muhammed.com.androidcontentprovider;

import android.content.ContentUris;
import android.content.ContentValues;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import app.muhammed.com.androidcontentprovider.db.MyContactProvider;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private Button mInsertButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mInsertButton = (Button) findViewById(R.id.button);


        mInsertButton.setOnClickListener(this);



    }

    @Override
    public void onClick(View view) {


        ContentValues values = new ContentValues();

        values.put("NAME", "Muhammed");
        values.put("PHONE", "8086461927");
        values.put("EMAIL", "muhammed.thasneem@yahoo.com");
        values.put("ADDRESS", "Ernakulam");

        Uri insert = getContentResolver().insert(Uri.withAppendedPath(MyContactProvider.CONTENT_AUTHORITY_URI, "CONTACT_MODEL"), values);

        Toast.makeText(this, String.valueOf(ContentUris.parseId(insert)), Toast.LENGTH_SHORT).show();

    }
}
