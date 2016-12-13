package com.example.android.myapplication;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.BundleCompat;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.LayoutInflaterCompat;
import android.support.v4.view.ViewGroupCompat;
import android.support.v4.widget.ListViewCompat;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

/**
 * Created by drewcarlson1123 on 12/2/16.
 */

public class MenuListFragment extends Fragment {

    private ListView mListView;
    private ArrayAdapter<String> adapter;
    private String[] values = new String[]{
            "Campus Map",
            "Shuttle Schedule",
            "Kline/Manor Menu"
    };

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_menu_list, container, false);

        mListView = (ListView) view.findViewById(R.id.text1);

        final Context context = this.getContext();



        adapter = new ArrayAdapter<String>(context,
                android.R.layout.simple_list_item_1, android.R.id.text1, values);

        mListView.setAdapter(adapter);

        mListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                int itemPosition = position;

                String itemValue = (String) mListView.getItemAtPosition(position);

                Fragment newFragment;

                if (position == 0) {
                    Intent intent = new Intent(getActivity(), MapsActivity.class);
                    startActivity(intent);
//                    newFragment = new MapFragment();
                } else if (position == 1) {
                    newFragment = new ShuttleFragment();
                    getActivity().getSupportFragmentManager().beginTransaction()
                            .replace(R.id.fragment_container, newFragment)
                            .addToBackStack(null)
                            .commit();
                } else {
                    newFragment = new CafeteriaFragment();
                    getActivity().getSupportFragmentManager().beginTransaction()
                            .replace(R.id.fragment_container, newFragment)
                            .addToBackStack(null)
                            .commit();
                }

//                getActivity().getSupportFragmentManager().beginTransaction()
//                        .replace(R.id.fragment_container, newFragment)
//                        .addToBackStack(null)
//                        .commit();
            }
        });

        return view;
    };
}
