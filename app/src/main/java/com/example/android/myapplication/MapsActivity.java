package com.example.android.myapplication;

import android.content.Intent;
import android.support.v4.app.FragmentActivity;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.LatLngBounds;
import com.google.android.gms.maps.model.MarkerOptions;

import java.util.Arrays;

public class MapsActivity extends AppCompatActivity implements OnMapReadyCallback {

    private GoogleMap mMap;

    //private GoogleMap mMap; 42.011705, -73.922199
    // Create a LatLngBounds that includes the city of Adelaide in Australia.
    private LatLngBounds ADELAIDE = new LatLngBounds(
            new LatLng(42.011705, -73.922199), new LatLng(42.033384, -73.896751));

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);
        Toolbar mToolBar = (Toolbar) findViewById(R.id.my_toolbar);
        setSupportActionBar(mToolBar);
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.action_start_search:
                Intent intent = new Intent(this, SearchList.class);
                startActivity(intent);
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.map_menu, menu);
        return true;
    }


    /**
     * Manipulates the map once available.
     * This callback is triggered when the map is ready to be used.
     * This is where we can add markers or lines, add listeners or move the camera. In this case,
     * we just add a marker near Sydney, Australia.
     * If Google Play services is not installed on the device, the user will be prompted to install
     * it inside the SupportMapFragment. This method will only be triggered once the user has
     * installed Google Play services and returned to the app.
     */
    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;
        String name = "";
        int position = -1;

        Intent intent = getIntent();
        String buildingName = intent.getStringExtra(SearchList.EXTRA_BUILDING_NAME);
        if (buildingName != null) {
        for (int i = 0; i<4; i++) {
            if (buildingName.equals(firstArray[i][0])) {
                name = buildingName;
                position = i;
            }
        }}

        if (name.equals("")) {
            //Add a marker in Sydney and move the camera
            LatLng elPrez = new LatLng(42.022603, -73.905763);
            mMap.addMarker(new MarkerOptions().position(elPrez)
                    .title("Botstein's House")
                    .snippet("This is Prez Botstein's House. It's a real nice pad"));
            mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(elPrez, 15));

            LatLng RKC = new LatLng(42.020019, -73.908047);
            mMap.addMarker(new MarkerOptions().position(RKC)
                    .title("Reems Kaden Center")
                    .snippet("Come meet Sven Anderson"));

            LatLng Fisher = new LatLng(42.031310, -73.902468);
            mMap.addMarker(new MarkerOptions().position(Fisher)
                    .title("Fisher Center")
                    .snippet("It's the crazy metal looking building"));

            LatLng HoneyField = new LatLng(42.023208, -73.912531);
            mMap.addMarker(new MarkerOptions().position(HoneyField)
                    .title("Honey Field")
                    .snippet("Best baseball facility in the northeast"));

            LatLng Library = new LatLng(42.022570, -73.906673);
            mMap.addMarker(new MarkerOptions().position(Library)
                    .title("Stevenson Library")
                    .snippet("Will Hunting is often seen here"));

            LatLng SAC = new LatLng(42.023638, -73.908755);
            mMap.addMarker(new MarkerOptions().position(SAC)
                    .title("Stevenson Athletic Center")
                    .snippet("Come get swoll"));

            LatLng newMarker = new LatLng(Double.parseDouble(firstArray[3][1]), Double.parseDouble(firstArray[3][2]));
            mMap.addMarker(new MarkerOptions().position(newMarker)
                    .title(firstArray[3][0])
                    .snippet(firstArray[3][3]));


// Constrain the camera target to the Adelaide bounds.
            mMap.setLatLngBoundsForCameraTarget(ADELAIDE);

            //String[] selectedArray = firstArray[1];
            Log.d("deep arr: ", "Deep arr: " + Arrays.deepToString(firstArray));
        } else {
            LatLng newMarker = new LatLng(Double.parseDouble(firstArray[position][1]), Double.parseDouble(firstArray[position][2]));
            mMap.addMarker(new MarkerOptions().position(newMarker)
                    .title(firstArray[position][0])
                    .snippet(firstArray[position][3]));
            mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(newMarker, 20));
            mMap.setLatLngBoundsForCameraTarget(ADELAIDE);
        }

    }
    // Array within array, Title, Latitude, Longitude, Snippet
    private final String[][] firstArray = new String[][] {
            new String[] {"Botstein's House", "42.022603", "-73.905763", "This is Prez Botstein's House. It's a real nice pad"}
            ,   new String[] {"Stevenson Athletic Center", "42.023638", "-73.908755", "Come get swoll"}
            ,   new String[] {"Stevenson Library", "42.022570", "-73.906673", "Will Hunting is often seen here"}
            ,   new String[] {"Cruger Village", "42.027779", "-73.907511", "Cruger Village is lit"}
    };
}
