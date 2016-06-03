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

public class MainActivity extends AppCompatActivity {
    private final int READ_FROM_SB =1;
    private final int READ_FROM_ASSETS=0;
    private int read_method=READ_FROM_SB;
    private String htmlPath;
    private WebView webView;
    private File innerfile;
    private String path;
    private String key;
    private String result;
    private String info;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);
        checkReadWay();
        initView();
    }

    private void checkReadWay()
    {
        innerfile = this.getFilesDir();
        result = "";
        key = "javascript.html";
        BrowserFile(innerfile);
        Log.d("MainAcitivty",read_method+"");
    }
    private void initView()
    {
        webView = (WebView)findViewById(R.id.webView);
        webView.getSettings().setJavaScriptEnabled(true);
        webView.getSettings().setAllowFileAccess(true);
        webView.getSettings().setAllowFileAccessFromFileURLs(true);
        webView.addJavascriptInterface(new JsInterface(this),"AndroidWebView");
        webView.setWebChromeClient(new WebChromeClient());
        if(read_method ==0)
        {
         readFromAsset();
        }
        else {
            readFromSB();
        }


    }

    private void readFromAsset(){
        webView.loadUrl("file:///android_asset/javascript.html");

    }
    private void readFromSB(){
       webView.loadUrl(result);
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
                    createAlert();
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

    private void createAlert()
    {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Open PDF")
                .setPositiveButton("打开PDF文件", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Intent intent = new Intent(MainActivity.this,PDFActivity.class);
                        startActivity(intent);
                    }
                });
           builder.show();
    }

    public void BrowserFile(File fileold) {
        if (key.equals("")) {
            Toast.makeText(this, "The file name is not correct", Toast.LENGTH_LONG).show();
        } else {
            search(fileold);
            if (result.equals("")) {
                read_method = READ_FROM_ASSETS;
            }
        }
    }
    private void search(File fileold)

    {

        try{

            File[] files=fileold.listFiles();

            if(files.length>0)

            {

                for(int j=0;j<files.length;j++)

                {

                    if(!files[j].isDirectory())

                    {

                        if(files[j].getName().indexOf(key)> -1)

                        {

                            path += "\n" + files[j].getPath();
                            result = info+path;
                            //shuju.putString(files[j].getName().toString(),files[j].getPath().toString());

                        }

                    }

                    else{

                        this.search(files[j]);

                    }

                }

            }

        }

        catch(Exception e)

        {



        }

    }
}
