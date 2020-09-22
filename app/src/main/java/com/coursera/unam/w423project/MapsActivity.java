package com.coursera.unam.w423project;

import androidx.fragment.app.FragmentActivity;

import android.os.Bundle;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptor;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

public class MapsActivity extends FragmentActivity implements OnMapReadyCallback {

    private GoogleMap mMap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
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
        Bundle parametros = getIntent().getExtras();
        int id = parametros.getInt(getResources().getString(R.string.key_lugar));
        LatLng lugar = null;
        String titulo = "";
        BitmapDescriptor color = null;
        switch (id) {
            case R.id.ib_djinguereber:
                lugar = new LatLng(16.771630971333902,-3.009973731070304);
                titulo = "Mezquita Djinguereber";
                color = BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_AZURE);
                break;
            case R.id.ib_sidi_yahiya:
                lugar = new LatLng(16.77226675,-3.0071036232421875);
                titulo = "Mezquita Sidi Yahiya";
                color = BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_VIOLET);
                break;
            case R.id.ib_estadio:
                lugar = new LatLng(16.765261940653513,-3.0061556964863523);
                titulo = "Estadio de Timbuktú";
                color = BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_YELLOW);
                break;
            case R.id.ib_museo:
                lugar = new LatLng(16.772103503818393,-3.0054123385543834);
                titulo = "Museo Etnológico";
                color = BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_ROSE);
                break;
        }

        mMap = googleMap;

        mMap.addMarker(new MarkerOptions().position(lugar).title(titulo).icon(color));
        mMap.animateCamera(CameraUpdateFactory.newLatLngZoom(new LatLng(lugar.latitude, lugar.longitude), 16.0f));
    }
}