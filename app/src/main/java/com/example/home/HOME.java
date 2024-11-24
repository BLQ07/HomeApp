package com.example.home;

import android.app.Application;

import com.parse.Parse;

public class HOME extends Application {
    @Override
    public void onCreate() {
                super.onCreate();
        Parse.initialize(new Parse.Configuration.Builder(this)
                .applicationId("9Md4f9BhI1A3cs1xtsWMgJKUzts8cxNDonJpTTqJ")
                .clientKey("NiJQCxFMiRUxaeSwJM3MJuGJSdjzoy2HYaKtSGRg")
                .server("https://parseapi.back4app.com/")
                .build()
        );   }
}
