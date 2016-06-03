package com.example.tianyunchen.js_with_native;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.joanzapata.pdfview.PDFView;

/**
 * Created by tianyun chen on 6/3/2016.
 */
public class PDFActivity extends AppCompatActivity {
    private PDFView pdfView;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pdf);
        init();
    }

    private void init()
    {
        pdfView = (PDFView)findViewById(R.id.pdfview);
        pdfView.fromAsset("pdftest.pdf")
                .defaultPage(1)
                .showMinimap(false)
                .enableSwipe(true)
                .load();
    }
}
