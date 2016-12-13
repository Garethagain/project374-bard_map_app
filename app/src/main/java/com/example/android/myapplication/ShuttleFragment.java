package com.example.android.myapplication;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.TextView;

/**
 * Created by drewcarlson1123 on 12/4/16.
 */

public class ShuttleFragment extends Fragment {
    private WebView mWebView;
    String TAG = "webview";

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_shuttle_view, container, false);

        mWebView = (WebView) view.findViewById(R.id.fragment_shuttle_view);
        mWebView.getSettings().setBuiltInZoomControls(true);
        mWebView.getSettings().setDisplayZoomControls(false);
        mWebView.setWebViewClient(new WebViewClient());
        mWebView.loadUrl("http://blogs.bard.edu/transportation/?page_id=5");

        return view;
    }

    private class ShuttleWebViewClient extends WebViewClient {

    }

    public boolean canGoBack() {
        return mWebView != null && mWebView.canGoBack();
    }

    public void moveBack() {
        mWebView.goBack();
    }
}
