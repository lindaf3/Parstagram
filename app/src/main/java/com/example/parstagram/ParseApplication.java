package com.example.parstagram;

import android.app.Application;

import com.parse.Parse;
import com.parse.ParseObject;

public class ParseApplication extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        //Register your parse models
        ParseObject.registerSubclass(Post.class);
        Parse.initialize(new Parse.Configuration.Builder(this)
                .applicationId("8Qyz7ob8vZIEX1uukQ55iOcijjUpDBKzYrbtqJ80")
                .clientKey("rLESItdVuJTYXJQyw8WvXIpdyDXAfoGvypGZhLCG")
                .server("https://parseapi.back4app.com")
                .build()
        );
    }
}
