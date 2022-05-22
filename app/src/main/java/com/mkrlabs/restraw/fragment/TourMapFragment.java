package com.mkrlabs.restraw.fragment;

import android.Manifest;
import android.content.pm.PackageManager;
import android.location.Location;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.Display;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.google.android.gms.location.FusedLocationProviderClient;
import com.google.android.gms.location.LocationServices;
import com.google.android.gms.maps.CameraUpdate;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.mkrlabs.restraw.R;

import es.dmoral.toasty.Toasty;


public class TourMapFragment extends Fragment implements OnMapReadyCallback {

    private static final String TAG = "Map";
    private String FINE_LOCATION = Manifest.permission.ACCESS_FINE_LOCATION;
    private String COURSE_LOCATION = Manifest.permission.ACCESS_COARSE_LOCATION;
    private Boolean mLocationPermission;
    private GoogleMap googleMap;
    private int REQUEST_CODE = 1001;
    private float DEFAULT_ZOOM = 16f;

    private FusedLocationProviderClient fusedLocationProviderClient;

    public TourMapFragment() {
        // Required empty public constructor
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_tour_map, container, false);
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        getLocationPermission();

    }


    private void getLocationPermission() {


        String permission[] = {Manifest.permission.ACCESS_FINE_LOCATION,
                Manifest.permission.ACCESS_COARSE_LOCATION};

        if (ContextCompat.checkSelfPermission(this.getContext(), FINE_LOCATION) == PackageManager.PERMISSION_GRANTED) {

            if (ContextCompat.checkSelfPermission(this.getContext(), COURSE_LOCATION) == PackageManager.PERMISSION_GRANTED) {

                mLocationPermission = true;
                initMap();
            } else {
                ActivityCompat.requestPermissions(getActivity(), permission, REQUEST_CODE);
            }

        } else {
            ActivityCompat.requestPermissions(getActivity(), permission, REQUEST_CODE);
        }


    }

    private void getDeviceCurrentLocation() {

        Log.d(TAG, "getDeviceCurrentLocation ");
        fusedLocationProviderClient = LocationServices.getFusedLocationProviderClient(getContext());
        try {
            Task<Location> task = fusedLocationProviderClient.getLastLocation();

            task.addOnCompleteListener(new OnCompleteListener<Location>() {
                @Override
                public void onComplete(@NonNull Task<Location> task) {
                    if (task.isSuccessful()) {
                        Location userLocation = task.getResult();

                        if (userLocation != null) {
                            LatLng latLng = new LatLng(userLocation.getLatitude(), userLocation.getLongitude());
                            moveCameraToLocation(latLng, DEFAULT_ZOOM);

                        } else {
                            Toasty.info(getContext(), "Unable to find current location").show();
                        }
                    } else {
                        Toasty.info(getContext(), "Unable to find current location").show();
                    }
                }
            });
        } catch (SecurityException e) {
            Log.e(TAG, "SecurityException " + e.getMessage());
        }
    }
    private void moveCameraToLocation(LatLng latLng, float zoom) {
        Log.v(TAG, "Move Camera to Location ");

        String from =latLng.latitude+","+ latLng.longitude;
        String to = "23.752981287671716, 90.3777078984378";
        //getDirectionOfMap(from,to);

        LatLng versityLatLng = new LatLng(23.752981287671716,90.3777078984378);
        float[] results = new float[1];
        Location.distanceBetween(latLng.latitude, latLng.longitude,
                versityLatLng.latitude, versityLatLng.longitude, results);
        float distance = results[0];
        CameraUpdate cameraUpdate = CameraUpdateFactory.newLatLngZoom(latLng, zoom);
        googleMap.animateCamera(cameraUpdate);

        MarkerOptions markerOptions = new MarkerOptions()
                .position(latLng)
                .icon(BitmapDescriptorFactory.fromResource(R.drawable.map_user_home_pin_icon))
                .title("Sweet Home")
                .snippet("current location");
        //23.752981287671716, 90.3777078984378

        LatLng diuLatLng = new LatLng(23.752981287671716,90.3777078984378);
        MarkerOptions diuMarker = new MarkerOptions()
                .position(diuLatLng)
                .title("DIU ")
                .icon(BitmapDescriptorFactory.fromResource(R.drawable.restaurant_marker_modified))
                .snippet("Versity");
        googleMap.addMarker(markerOptions);
        googleMap.addMarker(diuMarker);


    }
    private void initMap() {
        SupportMapFragment supportMapFragment = (SupportMapFragment) getChildFragmentManager().
                findFragmentById(R.id.mapFragment);
        supportMapFragment.getMapAsync(this);
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {

        mLocationPermission = false;

        if (requestCode == REQUEST_CODE) {
            if (grantResults.length > 0) {

                for (int i = 0; i < grantResults.length; i++) {
                    if (grantResults[i] != PackageManager.PERMISSION_GRANTED) {
                        mLocationPermission = false;
                    }
                }
                mLocationPermission = true;
                initMap();
            }
        }
    }

    @Override
    public void onMapReady(@NonNull GoogleMap googleMap) {
        this.googleMap = googleMap;
        if (mLocationPermission) {
            getDeviceCurrentLocation();
        }
    }
}