package app.muhammed.com.androidcontentprovider.adapters;

import android.content.Context;
import android.database.Cursor;
import android.support.v4.widget.CursorAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import app.muhammed.com.androidcontentprovider.R;

/**
 * Created by Muhammed on 09/10/17.
 */

public class MyCursorAdapter extends CursorAdapter {

    public MyCursorAdapter(Context context, Cursor c, boolean autoRequery) {
        super(context, c, autoRequery);
    }

    @Override
    public View newView(Context context, Cursor cursor, ViewGroup parent) {
        return LayoutInflater.from(context).inflate(R.layout.row, parent, false);
    }

    @Override
    public void bindView(View view, Context context, Cursor cursor) {

        TextView nameTextView = view.findViewById(R.id.textView2);
        TextView idTextView = view.findViewById(R.id.textView3);

        idTextView.setText("test");
        nameTextView.setText("test");


    }
}
