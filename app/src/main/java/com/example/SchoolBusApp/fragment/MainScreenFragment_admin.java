package com.example.SchoolBusApp.fragment;

import android.Manifest;
import android.app.ProgressDialog;
import android.content.pm.PackageManager;
import android.graphics.Color;
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
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import com.directions.route.AbstractRouting;
import com.directions.route.Route;
import com.directions.route.RouteException;
import com.directions.route.Routing;
import com.directions.route.RoutingListener;
import com.example.SchoolBusApp.R;
import com.example.SchoolBusApp.RetrofitGoogleClient;
import com.example.SchoolBusApp.adapter.PassengerAdapter;
import com.example.SchoolBusApp.model.BusStopModel;
import com.example.SchoolBusApp.model.PassengerArray;
import com.example.SchoolBusApp.model.PassengerModel;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.GoogleApiClient;
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
import com.google.android.gms.maps.model.Polyline;
import com.google.android.gms.maps.model.PolylineOptions;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.gson.JsonObject;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static com.example.SchoolBusApp.util.Constants.DEFAULT_ZOOM;
import static com.example.SchoolBusApp.util.Constants.LOCATION_PERMISSION_REQUEST_CODE;

public class MainScreenFragment_admin extends Fragment implements OnMapReadyCallback, GoogleApiClient.OnConnectionFailedListener, RoutingListener, GoogleApiClient.ConnectionCallbacks {


    SupportMapFragment supportMapFragment;
    ListView listViewBusStop;
    public static ArrayList<PassengerModel> listBusStop = new ArrayList<>();
    private static final String TAG = "MainScreenFragment_user";
    private static final String FINE_LOCATION = Manifest.permission.ACCESS_FINE_LOCATION;
    private static final String COURSE_LOCATION = Manifest.permission.ACCESS_COARSE_LOCATION;
    private FusedLocationProviderClient fusedLocationProviderClient;
    PassengerArray passengerArray = new PassengerArray();
    //vars
    private static final int[] COLORS = new int[]{R.color.primary_dark,R.color.primary,R.color.primary_light,R.color.accent,R.color.primary_light};
    private Boolean mLocationPermissionsGranted = false;
    private GoogleMap map;
    private Button busStopAssignBtn, busRouteBtn;
    private ProgressDialog progressDialog;
    private List<Polyline> polylines;
    private LatLng start, end;

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
        busStopAssignBtn = view.findViewById(R.id.busStopAssignBtn);
        busRouteBtn = view.findViewById(R.id.busRouteBtn);
        polylines = new ArrayList<>();
        busStopAssignBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //map.clear();
                getBusStopList(passengerArray);
                busStopAssignBtn.setVisibility(View.GONE);
                busRouteBtn.setVisibility(View.VISIBLE);
            }
        });
        busRouteBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getBusRoute(getBusRoute(getBusStopList(passengerArray)));
                busRouteBtn.setVisibility(View.GONE);
            }
        });
        getLocationPermission();
//        TODO: umieścić listę userów/przystanków(z liczbą userów)

        passengerArray = getAllPasengers();


//        TODO: na mapę wrzucić trasę między przystankami

    }

    private ArrayList<BusStopModel> getBusRoute(ArrayList<BusStopModel> busStopList) {
//        @TODO: Clarke & Wright
        //map.addPolygon()
//         Call <ResponseBody> call = RetrofitGoogleClient.getInstance().getApi().getDirection("52.253151, 20.898911", "52.2536236, 20.8937548", getString(R.string.google_maps_direction_key));
//         call.enqueue(new Callback<ResponseBody>() {
//             @Override
//             public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
//                 try {
//                     JSONObject responseJSON = new JSONObject(response.body().string());
//                     JSONObject routes = responseJSON.getJSONObject("routes");
//                     JSONObject bounds = routes.getJSONObject("bounds");
//                     bounds.toString();
//                 } catch (JSONException e) {
//                     e.printStackTrace();
//                 } catch (IOException e) {
//                     e.printStackTrace();
//                 }
//             }
//
//             @Override
//             public void onFailure(Call<ResponseBody> call, Throwable t) {
//
//             }
//         });
//        LatLng szkola = new LatLng(52.253151, 20.898911);
        LatLng szkola = new LatLng(52.231372, 21.004150);
        map.addMarker(new MarkerOptions().position(szkola)
                .icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_AZURE))
                .title("Szkoła"));
        map.moveCamera(CameraUpdateFactory.newLatLng(szkola));
        List<LatLng> markerLocation = new ArrayList<>();
//        markerLocation.add(new LatLng(52.2637564, 20.9046566));
//        markerLocation.add(new LatLng(52.2551354, 20.9151138));
//        markerLocation.add(new LatLng(52.2499788, 20.9252302));
//        markerLocation.add(new LatLng(52.250021, 20.9103036));
//        markerLocation.add(new LatLng(52.2536236, 20.8937548));
        markerLocation.add(new LatLng(52.233242, 20.997888));
        markerLocation.add(new LatLng(52.230321, 20.983451));
        markerLocation.add(new LatLng(52.241283, 20.986676));
        markerLocation.add(new LatLng(52.237971, 20.996668));
        markerLocation.add(new LatLng(52.241617, 21.004180));
        markerLocation.add(new LatLng(52.232542, 21.025110));
        markerLocation.add(new LatLng(52.221993, 21.024193));
        markerLocation.add(new LatLng(52.217428, 21.010819));
        markerLocation.add(new LatLng(52.218263, 20.989154));
        markerLocation.add(new LatLng(52.224600, 21.002194));
        int i;
        start = szkola;
        end = markerLocation.get(0);
        route();
        for (i=0;i<markerLocation.size()-1;i++){
            start = markerLocation.get(i);
            end = markerLocation.get(i+1);
            route();
        }
        start = markerLocation.get(markerLocation.size()-1);
        end = szkola;
        route();

//        start = new LatLng(52.253151, 20.898911);
//        LatLng waypoint = new LatLng(52.2536236, 20.8937548);
//        end = new LatLng(52.2536236, 20.8937548);
//        route();

        return null;
    }

    public void route() {

//        progressDialog = ProgressDialog.show(getActivity(), "Proszę czekać.",
//                "Pobieram dane z serwera.", true);

        Routing routing = new Routing.Builder()
                .travelMode(Routing.TravelMode.DRIVING)
                .waypoints(start, end)
                .withListener(this)
                .key(getString(R.string.google_maps_direction_key))
                .build();
        routing.execute();
    }

    private ArrayList<BusStopModel> getBusStopList(PassengerArray allPasengers) {
//        @TODO: algorytm k-means
        List<LatLng> markerLocation = new ArrayList<>();
//        markerLocation.add(new LatLng(52.2536236, 20.8937548));
//        markerLocation.add(new LatLng(52.2637564, 20.9046566));
//        markerLocation.add(new LatLng(52.250021, 20.9103036));
//        markerLocation.add(new LatLng(52.2551354, 20.9151138));
//        markerLocation.add(new LatLng(52.2499788, 20.9252302));
        markerLocation.add(new LatLng(52.233242, 20.997888));
        markerLocation.add(new LatLng(52.230321, 20.983451));
        markerLocation.add(new LatLng(52.241283, 20.986676));
        markerLocation.add(new LatLng(52.237971, 20.996668));
        markerLocation.add(new LatLng(52.241617, 21.004180));
        markerLocation.add(new LatLng(52.232542, 21.025110));
        markerLocation.add(new LatLng(52.221993, 21.024193));
        markerLocation.add(new LatLng(52.217428, 21.010819));
        markerLocation.add(new LatLng(52.218263, 20.989154));
        markerLocation.add(new LatLng(52.224600, 21.002194));
        for (LatLng latLng : markerLocation
        ) {
            map.addMarker(new MarkerOptions().position(latLng)
                    .title(latLng.toString())
                    .icon(BitmapDescriptorFactory.fromResource(R.drawable.bus_stop)));
            map.moveCamera(CameraUpdateFactory.newLatLng(latLng));
        }
        return null;
    }

    private PassengerArray getAllPasengers() {
        PassengerArray lista = new PassengerArray();
        showPassengers(lista.getLista());

        busStopAssignBtn.setVisibility(View.VISIBLE);
        return lista;
    }


    private void showPassengers(ArrayList<PassengerModel> list) {

        listBusStop.addAll(list);


        PassengerAdapter adapter = new PassengerAdapter(getActivity(), R.layout.passenger_record, listBusStop);
        listViewBusStop.setAdapter(adapter);
    }

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
            for (PassengerModel p : new PassengerArray().getLista()
            ) {
                LatLng markerLocation = new LatLng(p.getLatitude(), p.getLongitude());
                map.addMarker(new MarkerOptions().position(markerLocation)
                        .title(p.getUser().getEmail()));
                map.moveCamera(CameraUpdateFactory.newLatLng(markerLocation));

            }

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


    @Override
    public void onRoutingFailure(RouteException e) {
        // The Routing request failed
//        progressDialog.dismiss();
        if (e != null) {
            Toast.makeText(getActivity(), "Error: " + e.getMessage(), Toast.LENGTH_LONG).show();
        } else {
            Toast.makeText(getActivity(), "Something went wrong, Try again", Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    public void onRoutingStart() {

    }

    @Override
    public void onRoutingSuccess(ArrayList<Route> arrayList, int shortestRouteIndex) {
//        progressDialog.dismiss();
        CameraUpdate center = CameraUpdateFactory.newLatLng(start);
        CameraUpdate zoom = CameraUpdateFactory.zoomTo(16);

        map.moveCamera(center);


//        if (polylines.size() > 0) {
//            for (Polyline poly : polylines) {
//                poly.remove();
//            }
//        }

        polylines = new ArrayList<>();
        //add route(s) to the map.
        for (int i = 0; i < arrayList.size(); i++) {

            //In case of more than 5 alternative routes
            int colorIndex = i % COLORS.length;

            PolylineOptions polyOptions = new PolylineOptions();
            polyOptions.color(getResources().getColor(COLORS[colorIndex]));
            polyOptions.width(10 + i * 3);
            polyOptions.addAll(arrayList.get(i).getPoints());
            Polyline polyline = map.addPolyline(polyOptions);
            polylines.add(polyline);

            Toast.makeText(getActivity(), "Route " + (i + 1) + ": distance - " + arrayList.get(i).getDistanceValue() + ": duration - " + arrayList.get(i).getDurationValue(), Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    public void onRoutingCancelled() {
        progressDialog.dismiss();
        Log.i(TAG, "Routing was cancelled.");
    }

    @Override
    public void onConnectionFailed(@NonNull ConnectionResult connectionResult) {
        Log.v(TAG,connectionResult.toString());
    }

    @Override
    public void onConnected(@Nullable Bundle bundle) {

    }

    @Override
    public void onConnectionSuspended(int i) {

    }
//    private double getDistanceInfo(double lat1, double lng1, String destinationAddress) {
//        StringBuilder stringBuilder = new StringBuilder();
//        Double dist = 0.0;
//        try {
//
//            destinationAddress = destinationAddress.replaceAll(" ","%20");
//            String url = "http://maps.googleapis.com/maps/api/directions/json?origin=" + latFrom + "," + lngFrom + "&destination=" + latTo + "," + lngTo + "&mode=driving&sensor=false";
//
//            HttpPost httppost = new HttpPost(url);
//
//            HttpClient client = new DefaultHttpClient();
//            HttpResponse response;
//            stringBuilder = new StringBuilder();
//
//
//            response = client.execute(httppost);
//            HttpEntity entity = response.getEntity();
//            InputStream stream = entity.getContent();
//            int b;
//            while ((b = stream.read()) != -1) {
//                stringBuilder.append((char) b);
//            }
//        } catch (ClientProtocolException e) {
//        } catch (IOException e) {
//        }
//
//        JSONObject jsonObject = new JSONObject();
//        try {
//
//            jsonObject = new JSONObject(stringBuilder.toString());
//
//            JSONArray array = jsonObject.getJSONArray("routes");
//
//            JSONObject routes = array.getJSONObject(0);
//
//            JSONArray legs = routes.getJSONArray("legs");
//
//            JSONObject steps = legs.getJSONObject(0);
//
//            JSONObject distance = steps.getJSONObject("distance");
//
//            Log.i("Distance", distance.toString());
//            dist = Double.parseDouble(distance.getString("text").replaceAll("[^\\.0123456789]","") );
//
//        } catch (JSONException e) {
//            // TODO Auto-generated catch block
//            e.printStackTrace();
//        }
//
//        return dist;
//    }
}
