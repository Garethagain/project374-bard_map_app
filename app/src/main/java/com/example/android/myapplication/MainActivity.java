package com.example.android.myapplication;

import android.content.Intent;
import android.support.v4.app.Fragment;

public class MainActivity extends SingleFragmentActivity {


    @Override
    protected Fragment createFragment() {
        return new MenuListFragment();
    }

    public void startMap() {
        Intent intent = new Intent(this, MapsActivity.class);
        startActivity(intent);
    }

//    @Override
//    public void onBackPressed() {
//        Fragment webview = getSupportFragmentManager().findFragmentById(R.id.fragment_shuttle_view);
//        boolean goBack = ((ShuttleFragment) webview).canGoBack();
//        if (!goBack) {
//            super.onBackPressed();
//        }
//        else ((ShuttleFragment) webview).moveBack();
//    }
}
