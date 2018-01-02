package jt.ttaa.customview;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.View;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.FrameLayout;
import android.widget.ProgressBar;

import com.zhy.autolayout.AutoLayoutActivity;

import jt.ttaa.R;


/**
 * Created by oceanzhang on 16/3/29.
 */
public class WebViewActivity extends AutoLayoutActivity {
    ProgressBar progressBar;
    private WebView webView;
    private View top;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        String title = getIntent().getStringExtra("title");
        setContentView(R.layout.activity_webview);
        progressBar = findViewById(R.id.fragment_statistics_progressbar);
        webView = findViewById(R.id.webview);
        top = findViewById(R.id.top);
        top.findViewById(R.id.Titlebar_left).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (webView.canGoBack()) {
                    webView.goBack();
                }else {
                    onBackPressed();
                }
            }
        });
        WebSettings webSettings = webView.getSettings();
        webSettings.setJavaScriptEnabled(true);
        webSettings.setDomStorageEnabled(true);
        webSettings.setAppCacheEnabled(true);
        webSettings.setDatabaseEnabled(true);
        webSettings.setTextSize(WebSettings.TextSize.NORMAL);
        webView.setWebChromeClient(webChromeClient);
        webView.setWebViewClient(webViewClient);
        webView.setOnKeyListener(new View.OnKeyListener() {
            @Override
            public boolean onKey(View v, int keyCode, KeyEvent event) {
                if (event.getAction() == KeyEvent.ACTION_DOWN) {
                    if (keyCode == KeyEvent.KEYCODE_BACK && webView.canGoBack()) {
                        webView.goBack();
                        return true;
                    }
                }
                return false;
            }
        });
        webView.requestFocus();
        String url = getIntent().getStringExtra("url");
//        String url = getQueryParameter("url");
        if (!TextUtils.isEmpty(url)) {
            url = url.startsWith("http://") ? url : "http://" + url;
            webView.loadUrl(url);
        }
        System.out.println("url" + url + "," + title);
    }

    private WebChromeClient webChromeClient = new WebChromeClient() {
        @Override
        public void onProgressChanged(WebView view, int newProgress) {
            if (progressBar != null) {
                progressBar.setProgress(newProgress);
                if (newProgress >= 100)
                    progressBar.setVisibility(View.GONE);
                else
                    progressBar.setVisibility(View.VISIBLE);
            }
            super.onProgressChanged(view, newProgress);
        }
    };

    private WebViewClient webViewClient = new WebViewClient() {
        @Override
        public boolean shouldOverrideUrlLoading(WebView view, String url) {
            view.loadUrl(url);
            return true;
        }

        @Override
        public void onUnhandledKeyEvent(WebView view, KeyEvent event) {
            super.onUnhandledKeyEvent(view, event);
            System.out.println(event.toString());
        }
    };


}
