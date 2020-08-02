package ua.com.anker;

import android.app.Application;

import ua.com.anker.di.AppComponent;
import ua.com.anker.di.DaggerAppComponent;

public class App extends Application {
    private static AppComponent appComponent;

    @Override
    public void onCreate() {
        super.onCreate();
        appComponent = DaggerAppComponent.builder().applicationContext(this).build();
    }

    public static AppComponent getAppComponent() {
        return appComponent;
    }
}
