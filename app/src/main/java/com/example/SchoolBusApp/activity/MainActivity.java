package com.example.SchoolBusApp.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.example.SchoolBusApp.fragment.AddPassengerFragment;
import com.example.SchoolBusApp.fragment.JoinFragment;
import com.example.SchoolBusApp.fragment.MainScreenFragment_admin;
import com.example.SchoolBusApp.fragment.MainScreenFragment_user;
import com.example.SchoolBusApp.fragment.SettingsFragment;
import com.example.SchoolBusApp.R;
import com.example.SchoolBusApp.SharedPreferenceManager;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener, OnMapReadyCallback {
    private DrawerLayout drawer;


    private static final String TAG = "MainActivity";

    //widgets
    private ProgressBar mProgressBar;

    //vars
    private boolean mLocationPermissionGranted = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        SharedPreferenceManager.init(getApplicationContext());
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        drawer = findViewById(R.id.drawer_layout);
        NavigationView navigationView = findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();
        if (savedInstanceState == null) {
            if (SharedPreferenceManager.read(SharedPreferenceManager.USER_TYPE, "").equals("admin"))
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, new MainScreenFragment_admin()).commit();
            else
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, new MainScreenFragment_user()).commit();
            navigationView.setCheckedItem(R.id.my_events);
        }

        TextView msg = navigationView.getHeaderView(0).findViewById(R.id.welcomeMessage);
        msg.setText("Witaj! Jesteś zalogowany jako:\n" + SharedPreferenceManager.read(SharedPreferenceManager.Login, ""));

    }


    @Override
    public void onBackPressed() {
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }


    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
        switch (menuItem.getItemId()) {
            case R.id.add_event:
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, new AddPassengerFragment()).commit();
                break;
            case R.id.my_events:
                if (SharedPreferenceManager.read(SharedPreferenceManager.USER_TYPE, "").equals("admin"))
                    getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, new MainScreenFragment_admin()).commit();
                else
                    getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, new MainScreenFragment_user()).commit();
                break;
            case R.id.join_event:
//                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, new JoinFragment()).addToBackStack(null).commit();
                break;
            case R.id.settings:
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, new SettingsFragment()).commit();
                break;
            case R.id.logOut_event:
//                SharedPreferences sharedPreferences;
//                sharedPreferences = PreferenceManager.getDefaultSharedPreferences(initialActivity.getApplicationContext());
//                Call<ResponseBody> logout = new RetrofitClient().getApi().notifyUnregister(sharedPreferences.getString("registrationID", ""),
//                        SharedPreferenceManager.read(SharedPreferenceManager.TOKEN, ""));
//                logout.enqueue(new Callback<ResponseBody>() {
//                    @Override
//                    public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
//                        if (response.code() == 200) {
//                            //SharedPreferenceManager.remove(SharedPreferenceManager.RegisterID);
//                            Log.d("unRegID", "Wyrejestrowanie z usługi udane");
//                        } else Log.d("unRegID", "Wyrejestrowanie z usługi nie powiodło się");
//                    }
//
//                    @Override
//                    public void onFailure(Call<ResponseBody> call, Throwable t) {
//                        Log.d("unRegID", "Failure request");
//                    }
//                });
                SharedPreferenceManager.remove(SharedPreferenceManager.TOKEN);
                SharedPreferenceManager.remove(SharedPreferenceManager.USER_TYPE);
                Intent activityIntent;
                activityIntent = new Intent(this, LoginActivity.class);
                startActivity(activityIntent);
                finish();
                break;
        }
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    @Override
    public void onMapReady(GoogleMap googleMap) {

    }

    @Override
    public void onPointerCaptureChanged(boolean hasCapture) {

    }

//    private boolean checkMapServices() {
//        if (isServicesOK()) {
//            if (isMapsEnabled()) {
//                return true;
//            }
//        }
//        return false;
//    }

//    private void buildAlertMessageNoGps() {
//        final AlertDialog.Builder builder = new AlertDialog.Builder(this);
//        builder.setMessage("This application requires GPS to work properly, do you want to enable it?")
//                .setCancelable(false)
//                .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
//                    public void onClick(@SuppressWarnings("unused") final DialogInterface dialog, @SuppressWarnings("unused") final int id) {
//                        Intent enableGpsIntent = new Intent(android.provider.Settings.ACTION_LOCATION_SOURCE_SETTINGS);
//                        startActivityForResult(enableGpsIntent, PERMISSIONS_REQUEST_ENABLE_GPS);
//                    }
//                });
//        final AlertDialog alert = builder.create();
//        alert.show();
//    }

//    public boolean isMapsEnabled() {
//        final LocationManager manager = (LocationManager) getSystemService(Context.LOCATION_SERVICE);
//
//        if (!manager.isProviderEnabled(LocationManager.GPS_PROVIDER)) {
//            buildAlertMessageNoGps();
//            return false;
//        }
//        return true;
//    }

//    private void getLocationPermission() {
//        /*
//         * Request location permission, so that we can get the location of the
//         * device. The result of the permission request is handled by a callback,
//         * onRequestPermissionsResult.
//         */
//        if (ContextCompat.checkSelfPermission(this.getApplicationContext(),
//                android.Manifest.permission.ACCESS_FINE_LOCATION)
//                == PackageManager.PERMISSION_GRANTED) {
//            mLocationPermissionGranted = true;
//            getChatrooms();
//        } else {
//            ActivityCompat.requestPermissions(this,
//                    new String[]{android.Manifest.permission.ACCESS_FINE_LOCATION},
//                    PERMISSIONS_REQUEST_ACCESS_FINE_LOCATION);
//        }
//    }

//    public boolean isServicesOK() {
//        Log.d(TAG, "isServicesOK: checking google services version");
//
//        int available = GoogleApiAvailability.getInstance().isGooglePlayServicesAvailable(MainActivity.this);
//
//        if (available == ConnectionResult.SUCCESS) {
//            //everything is fine and the user can make map requests
//            Log.d(TAG, "isServicesOK: Google Play Services is working");
//            return true;
//        } else if (GoogleApiAvailability.getInstance().isUserResolvableError(available)) {
//            //an error occured but we can resolve it
//            Log.d(TAG, "isServicesOK: an error occured but we can fix it");
//            Dialog dialog = GoogleApiAvailability.getInstance().getErrorDialog(MainActivity.this, available, ERROR_DIALOG_REQUEST);
//            dialog.show();
//        } else {
//            Toast.makeText(this, "You can't make map requests", Toast.LENGTH_SHORT).show();
//        }
//        return false;
//    }
//
//    @Override
//    public void onRequestPermissionsResult(int requestCode,
//                                           @NonNull String permissions[],
//                                           @NonNull int[] grantResults) {
//        mLocationPermissionGranted = false;
//        switch (requestCode) {
//            case PERMISSIONS_REQUEST_ACCESS_FINE_LOCATION: {
//                // If request is cancelled, the result arrays are empty.
//                if (grantResults.length > 0
//                        && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
//                    mLocationPermissionGranted = true;
//                }
//            }
//        }
//    }
//
//    @Override
//    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
//        super.onActivityResult(requestCode, resultCode, data);
//        Log.d(TAG, "onActivityResult: called.");
//        switch (requestCode) {
//            case PERMISSIONS_REQUEST_ENABLE_GPS: {
//                if (mLocationPermissionGranted) {
//                    getChatrooms();
//                } else {
//                    getLocationPermission();
//                }
//            }
//        }
//    }
//
//    @Override
//    protected void onResume() {
//        super.onResume();
//        if (checkMapServices()) {
//            if (mLocationPermissionGranted) {
//                getChatrooms();
//            } else {
//                getLocationPermission();
//            }
//        }
//    }
//
//    private void getChatrooms() {
//
//    }
}
