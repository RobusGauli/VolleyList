package com.bex.volleylist;

import android.app.Application;
import android.content.Context;

/**
 * Created by Robus on 7/20/2015.
 */
public class MyApplicationContext extends Application {
   public static MyApplicationContext myApplicationContext;
    static Context context;

    @Override
    public void onCreate() {
        super.onCreate();
        myApplicationContext = this;
    }

    public static Context getAppContext(){
        context = myApplicationContext.getApplicationContext();
        return context;
    }
}
