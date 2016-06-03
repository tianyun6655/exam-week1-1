package com.example.tianyunchen.js_with_native;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.InstrumentationInfo;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.webkit.JavascriptInterface;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;

import untils.FileUntils;

public class MainActivity extends AppCompatActivity {

    private WebView webView;



    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
    }


    private void initView()
    {
        webView = (WebView)findViewById(R.id.webView);
        webView.getSettings().setJavaScriptEnabled(true);
        webView.getSettings().setAllowFileAccess(true);
        webView.getSettings().setAllowFileAccessFromFileURLs(true);
        webView.addJavascriptInterface(new JsInterface(this),"AndroidWebView");
        webView.setWebChromeClient(new WebChromeClient());
        webView.loadUrl("file:///"+this.getFilesDir().getAbsolutePath()+"javascript.html");



    }



    private class JsInterface{
        private Context mContext;
        public JsInterface(Context context){
            this.mContext = context;

        }

        @JavascriptInterface
        //Js call androidWebView will call this function
        public void showInfoFromJs(String name){
           // Toast.makeText(mContext,name,Toast.LENGTH_LONG).show();
            if(name.contains("pdf"))
            {
                    createAlert(name);
            }
            else
            {
                Toast.makeText(mContext,name,Toast.LENGTH_LONG).show();
            }
        }


    }

    public void sendInfoToJs(View view) {
        String msg = ((EditText) findViewById(R.id.input_et)).getText().toString();
        //调用js中的函数：showInfoFromJava(msg)
        webView.loadUrl("javascript:showInfoFromJava('" + msg + "')");
    }

    private void createAlert(String name)
    {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle(name)

                .setPositiveButton("打开PDF文件", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Intent intent = new Intent(MainActivity.this,PDFActivity.class);
                        startActivity(intent);
                    }
                });
           builder.show();
    }



}
