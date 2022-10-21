
package com.example.metacogroup;

import android.annotation.SuppressLint;
import android.app.Application;
import android.content.Context;
import android.os.Handler;

public class ApplicationContext extends Application {

    private static final String TAG = ApplicationContext.class.getName();

    public static ApplicationContext getInstance(Context context) {
        return (ApplicationContext)context.getApplicationContext();
    }
    @Override
    protected void attachBaseContext(Context base) {
        super.attachBaseContext(base);
    }
    @Override
    public void onCreate() {
        super.onCreate();


        TypefaceUtil.overrideFont(getApplicationContext(), "SERIF", "B_Yekan.ttf"); // font from assets: "assets/fonts/Roboto-Regular.ttf
        //MultiDex.install(this);
        //page = Main2Activity.GetInstance();
      //  G.context = getApplicationContext();

    }






}
