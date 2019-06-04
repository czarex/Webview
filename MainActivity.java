package com.example.lfcwwoms;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.view.View;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class MainActivity extends AppCompatActivity {
    //Declare private classes
    private WebView wv1;
    private WebView wv11;

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.navigation_home:
                   // mTextMessage.setText(R.string.title_home);
                    //Manage webviews
                    String url = "http://172.16.16.70/lfcwwcloud/login";
                    wv1=(WebView)findViewById(R.id.webView);
                    wv1.setWebViewClient(new MyBrowser());
                    wv1.getSettings().setLoadsImagesAutomatically(true);
                    wv1.getSettings().setJavaScriptEnabled(true);
                    wv1.setScrollBarStyle(View.SCROLLBARS_INSIDE_OVERLAY);
                    wv1.loadUrl(url);
                    return true;
                case R.id.navigation_cloud:
                   // mTextMessage.setText(R.string.title_dashboard);
                    //Manage webviews
                    String domain = "http://172.16.16.70/projects/";
                    wv11=(WebView)findViewById(R.id.webView);
                    wv11.setWebViewClient(new MyBrowser());
                    wv11.getSettings().setLoadsImagesAutomatically(true);
                    wv11.getSettings().setJavaScriptEnabled(true);
                    wv11.setScrollBarStyle(View.SCROLLBARS_INSIDE_OVERLAY);
                    wv11.loadUrl(domain);

                    return true;
                case R.id.navigation_sites:
                   // mTextMessage.setText(R.string.title_notifications);
                    //Manage webviews
                    String url1 = "http://172.16.16.70/news/";
                    wv1=(WebView)findViewById(R.id.webView);
                    wv1.setWebViewClient(new MyBrowser());
                    wv1.getSettings().setLoadsImagesAutomatically(true);
                    wv1.getSettings().setJavaScriptEnabled(true);
                    wv1.setScrollBarStyle(View.SCROLLBARS_INSIDE_OVERLAY);
                    wv1.loadUrl(url1);
                    return true;
            }
            return false;
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ActionBar actionBar = getSupportActionBar();
        actionBar.hide();

        //Manage navigations
        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);

        //Manage webviews
        String url = "http://172.16.16.70/";
        wv1=(WebView)findViewById(R.id.webView);
        wv1.setWebViewClient(new MyBrowser());
        wv1.getSettings().setLoadsImagesAutomatically(true);
        wv1.getSettings().setJavaScriptEnabled(true);
        wv1.setScrollBarStyle(View.SCROLLBARS_INSIDE_OVERLAY);
        wv1.loadUrl(url);



    }
    //Declare MyBrowser class
    private class MyBrowser extends WebViewClient {
        @Override
        public boolean shouldOverrideUrlLoading(WebView view, String url) {
            view.loadUrl(url);
            return true;
        }
    }

}
