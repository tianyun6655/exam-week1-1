package com.example.tianyunchen.js_with_native;

import android.app.Application;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import untils.FileUntils;

/**
 * Created by tianyun chen on 6/3/2016.
 */
public class MyApplication extends Application{
    @Override
    public void onCreate() {
       super.onCreate();
        copyfile();

    }

    private void copyfile()  {
        boolean flage =   FileUntils.CheckFileInSandBox(this,"javascript.html");
        if(!flage)
        {
            try {
                FileUntils.copyAssetsToSandBox(this,this.getAssets().open("javascript.html"));
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
