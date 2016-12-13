package com.example.android.myapplication;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.widget.TextView;

/**
 * Created by drewcarlson1123 on 12/4/16.
 */

public class CafeteriaFragment extends Fragment {
    private WebView mWebView;
    String TAG = "webview";

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_cafeteria_view, container, false);

        mWebView = (WebView) view.findViewById(R.id.fragment_cafeteria_view);
        WebSettings webSettings = mWebView.getSettings();
        webSettings.setJavaScriptEnabled(true);
        webSettings.setBuiltInZoomControls(true);
        webSettings.setDisplayZoomControls(false);


        mWebView.loadUrl("https://new.dineoncampus.com/bard/whats-on-the-menu");

        return view;
    }

    public boolean canGoBack() {
        return mWebView != null && mWebView.canGoBack();
    }

    public void moveBack() {
        mWebView.goBack();
    }
}
