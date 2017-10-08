package app.muhammed.com.androidcontentprovider;

import android.database.Cursor;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import app.muhammed.com.androidcontentprovider.db.ContactModel;
import app.muhammed.com.androidcontentprovider.db.MyContactProvider;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private Button mInsertButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mInsertButton = (Button) findViewById(R.id.button);


        mInsertButton.setOnClickListener(this);


        String[] projection = {

                "ID",
                "NAME"
        };

        Cursor cursor = getContentResolver().query(Uri.withAppendedPath(MyContactProvider.CONTENT_AUTHORITY_URI, "CONTACT_MODEL/" + 1), projection, null, null, null);
        if (cursor.moveToFirst()) {



        }
    }

    @Override
    public void onClick(View view) {
        ContactModel contactModel = new ContactModel();

        contactModel.setName("Muhammed Thasneem");
        contactModel.setPhone("8086461927");
        contactModel.setEmail("muhammedthasneem@gmail.com");
        contactModel.setAddress("Ernakulam");

        contactModel.save();
    }
}
