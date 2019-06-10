package com.example.SchoolBusApp.fragment;

import android.Manifest;
import android.content.pm.PackageManager;
import android.location.Location;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.Fragment;
import android.support.v4.content.ContextCompat;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.Toast;

import com.example.SchoolBusApp.R;
import com.example.SchoolBusApp.adapter.PassengerAdapter;
import com.example.SchoolBusApp.model.BusStopModel;
import com.example.SchoolBusApp.model.PassengerArray;
import com.example.SchoolBusApp.model.PassengerModel;
import com.google.android.gms.location.FusedLocationProviderClient;
import com.google.android.gms.location.LocationServices;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;


import java.util.ArrayList;

import static com.example.SchoolBusApp.util.Constants.DEFAULT_ZOOM;
import static com.example.SchoolBusApp.util.Constants.LOCATION_PERMISSION_REQUEST_CODE;

public class MainScreenFragment_admin extends Fragment implements OnMapReadyCallback {


    SupportMapFragment supportMapFragment;
    ListView listViewBusStop;
    public static ArrayList<PassengerModel> listBusStop = new ArrayList<>();
    private static final String TAG = "MainScreenFragment_user";
    private static final String FINE_LOCATION = Manifest.permission.ACCESS_FINE_LOCATION;
    private static final String COURSE_LOCATION = Manifest.permission.ACCESS_COARSE_LOCATION;
    private FusedLocationProviderClient fusedLocationProviderClient;
    //vars
    private Boolean mLocationPermissionsGranted = false;
    private GoogleMap map;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootview = inflater.inflate(R.layout.main_screen_fragment_admin, container, false);
        return rootview;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        listViewBusStop = getActivity().findViewById(R.id.listViewBusStop);
        getLocationPermission();
//        TODO: umieścić listę userów/przystanków(z liczbą userów)

        getBusRoute(getBusStopList(getAllPasengers()));


//        TODO: na mapę wrzucić trasę między przystankami

//        listEvents = new ArrayList<>();
//        getEvents();
    }

    private ArrayList<BusStopModel> getBusRoute(ArrayList<BusStopModel> busStopList) {
//        @TODO: Clarke & Wright
        return null;
    }

    private ArrayList<BusStopModel> getBusStopList(PassengerArray allPasengers) {
//        @TODO: algorytm k-means
        return null;
    }

    private PassengerArray getAllPasengers() {
        PassengerArray lista = new PassengerArray();
        ArrayList<PassengerModel> listaB;
        listaB = lista.getLista();
        showPassengers(listaB);
        return lista;
    }


//    private void getEvents() {
//
//        Call<ArrayList<EventModel>> call = RetrofitClient.getInstance().getApi().getEvents(SharedPreferenceManager.read(SharedPreferenceManager.TOKEN, ""));
//        call.enqueue(new Callback<ArrayList<EventModel>>() {
//            @Override
//            public void onResponse(Call<ArrayList<EventModel>> call, Response<ArrayList<EventModel>> response) {
//
//                Log.d("Response Code ", Integer.toString(response.code()));
//                if (response.code() == 200) {
//                    showEvents(response);
//                } else {
//                    Toast.makeText(getActivity(), "Wystąpił błąd! Nie udało się pobrać wydarzeń.", Toast.LENGTH_SHORT).show();
//                    if (response.code() == 401) {
//                        SharedPreferences sharedPreferences;
//                        sharedPreferences = PreferenceManager.getDefaultSharedPreferences(initialActivity.getApplicationContext());
//                        Call<ResponseBody> logout = new RetrofitClient().getApi().notifyUnregister(sharedPreferences.getString("registrationID", ""),
//                                SharedPreferenceManager.read(SharedPreferenceManager.TOKEN, ""));
//                        logout.enqueue(new Callback<ResponseBody>() {
//                            @Override
//                            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
//                                if (response.code() == 200) {
//                                    //SharedPreferenceManager.remove(SharedPreferenceManager.RegisterID);
//                                    Log.d("unRegID", "Wyrejestrowanie z usługi udane");
//                                } else
//                                    Log.d("unRegID", "Wyrejestrowanie z usługi nie powiodło się");
//                            }
//
//                            @Override
//                            public void onFailure(Call<ResponseBody> call, Throwable t) {
//                                Log.d("unRegID", "Failure request");
//                            }
//                        });
//                        SharedPreferenceManager.remove(SharedPreferenceManager.TOKEN);
//                        Intent intent = new Intent(getActivity(), LoginActivity.class);
//                        startActivity(intent);
//                    }
//                }
//            }
//
//            @Override
//            public void onFailure(Call<ArrayList<EventModel>> call, Throwable t) {
//                Toast.makeText(getActivity(), t.getMessage(), Toast.LENGTH_SHORT).show();
//            }
//        });
//
//    }

    private void showPassengers(ArrayList<PassengerModel> list) {

        listBusStop.addAll(list);



        PassengerAdapter adapter = new PassengerAdapter(getActivity(), R.layout.passenger_record, listBusStop);
        listViewBusStop.setAdapter(adapter);
//        listEvents.setOnItemClickListener(new AdapterView.OnItemClickListener() {
//            @Override
//            public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {
//                showEventDetails(position);
//            }
//        });
    }

//    private void showEventDetails(int position) {
//        FragmentTransaction ft = getActivity().getSupportFragmentManager().beginTransaction();
//        ft.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN);
//        EventDetailsFragment detailsFragment = new EventDetailsFragment();
//
//        Bundle arg = new Bundle();
//        arg.putSerializable("event", listEvents.get(position));
//        detailsFragment.setArguments(arg);
//
//        ft.replace(R.id.fragment_container, detailsFragment);
//        ft.addToBackStack(null);
//        ft.commit();
//    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        map = googleMap;

        if (mLocationPermissionsGranted) {
            getDeviceLocation();

            if (ActivityCompat.checkSelfPermission(getActivity(), Manifest.permission.ACCESS_FINE_LOCATION)
                    != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(getActivity(),
                    Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
                return;
            }
            map.setMyLocationEnabled(true);
            map.getUiSettings().setMyLocationButtonEnabled(true);

        }
    }

    private void getDeviceLocation() {
        Log.d(TAG, "getDeviceLocation: getting the devices current location");

        fusedLocationProviderClient = LocationServices.getFusedLocationProviderClient(getActivity());

        try {
            if (mLocationPermissionsGranted) {

                final Task location = fusedLocationProviderClient.getLastLocation();
                location.addOnCompleteListener(new OnCompleteListener() {
                    @Override
                    public void onComplete(@NonNull Task task) {
                        if (task.isSuccessful()) {
                            Log.d(TAG, "onComplete: found location!");
                            Location currentLocation = (Location) task.getResult();

                            moveCamera(new LatLng(currentLocation.getLatitude(), currentLocation.getLongitude()),
                                    DEFAULT_ZOOM);

                        } else {
                            Log.d(TAG, "onComplete: current location is null");
                            Toast.makeText(getActivity(), "unable to get current location", Toast.LENGTH_SHORT).show();
                        }
                    }
                });
            }
        } catch (SecurityException e) {
            Log.e(TAG, "getDeviceLocation: SecurityException: " + e.getMessage());
        }
    }

    private void moveCamera(LatLng latLng, float zoom) {
        Log.d(TAG, "moveCamera: moving the camera to: lat: " + latLng.latitude + ", lng: " + latLng.longitude);
        map.moveCamera(CameraUpdateFactory.newLatLngZoom(latLng, zoom));
    }

    private void initMap() {
        Log.d(TAG, "initMap: initializing map");
        SupportMapFragment mapFragment = (SupportMapFragment) getChildFragmentManager().findFragmentById(R.id.mapView);

        mapFragment.getMapAsync(this);
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        Log.d(TAG, "onRequestPermissionsResult: called.");
        mLocationPermissionsGranted = false;

        switch (requestCode) {
            case LOCATION_PERMISSION_REQUEST_CODE: {
                if (grantResults.length > 0) {
                    for (int i = 0; i < grantResults.length; i++) {
                        if (grantResults[i] != PackageManager.PERMISSION_GRANTED) {
                            mLocationPermissionsGranted = false;
                            Log.d(TAG, "onRequestPermissionsResult: permission failed");
                            return;
                        }
                    }
                    Log.d(TAG, "onRequestPermissionsResult: permission granted");
                    mLocationPermissionsGranted = true;
                    //initialize our map
                    initMap();
                }
            }
        }
    }

    private void getLocationPermission() {
        Log.d(TAG, "getLocationPermission: getting location permissions");
        String[] permissions = {Manifest.permission.ACCESS_FINE_LOCATION,
                Manifest.permission.ACCESS_COARSE_LOCATION};

        if (ContextCompat.checkSelfPermission(getActivity(),
                FINE_LOCATION) == PackageManager.PERMISSION_GRANTED) {
            if (ContextCompat.checkSelfPermission(getActivity(),
                    COURSE_LOCATION) == PackageManager.PERMISSION_GRANTED) {
                mLocationPermissionsGranted = true;
                initMap();
            } else {
                ActivityCompat.requestPermissions(getActivity(),
                        permissions,
                        LOCATION_PERMISSION_REQUEST_CODE);
            }
        } else {
            ActivityCompat.requestPermissions(getActivity(),
                    permissions,
                    LOCATION_PERMISSION_REQUEST_CODE);
        }
    }

}
