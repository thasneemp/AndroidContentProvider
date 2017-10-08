package app.muhammed.com.androidcontentprovider;

import com.facebook.stetho.Stetho;
import com.orm.SugarApp;

/**
 * Created by Muhammed on 08/10/17.
 */

public class MyApp extends SugarApp {
    @Override
    public void onCreate() {
        super.onCreate();
        Stetho.initializeWithDefaults(this);
    }
}
