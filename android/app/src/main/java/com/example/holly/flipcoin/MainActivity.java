package com.example.holly.flipcoin;

import android.app.ProgressDialog;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class MainActivity extends AppCompatActivity {

    WebView webView; //Declaring WebView object
    ProgressDialog dialog; //Progress Dialog for showing loading message

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //Setting Custom xml Layout to Activity
        setContentView(R.layout.activity_main);

        //Initializing progressdialog
        dialog = new ProgressDialog(this);

        //initializing webView object from xml layout by Id
        webView = (WebView) findViewById(R.id.webView);

        //Setting Android Default WebViewClient to WebView
        webView.setWebViewClient(new WebViewClient(){
            @Override
            public void onPageStarted(WebView webView, String url, Bitmap favicon) {
                super.onPageStarted(webView, url, favicon);

                //Setting Loading message to progress dialog
                dialog.setMessage("Please wait...");
                //showing loading dialog;
                dialog.show();
            }

            @Override
            public void onPageFinished(WebView webView, String url) {
                super.onPageFinished(webView, url);
                //Hiding Loading dialog when page is loaded
                dialog.dismiss();
            }
        });

        //Enabling JavaScript in WEbView
        webView.getSettings().setJavaScriptEnabled(true);

        //Enabling javascript to let open windows if needed
        webView.getSettings().setJavaScriptCanOpenWindowsAutomatically(true);

        //Loading Url into the webview
        /**
         * Any URL can be used here.
         * URL pasted here will load in the webView
         */
        webView.loadUrl("http://kaspat.com/test-code/test.html");
    }
}
