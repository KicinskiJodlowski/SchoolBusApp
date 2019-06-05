package com.example.SchoolBussApp.activity;

import android.content.Intent;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

import com.example.SchoolBussApp.SharedPreferenceManager;

public class InitialActivity extends AppCompatActivity {

    private static final String TAG = "InitialActivity";
    private static final int PLAY_SERVICES_RESOLUTION_REQUEST = 9000;
    public static Boolean isVisible = false;
    public static InitialActivity initialActivity;

    @Override

    protected void onCreate(@Nullable Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        SharedPreferenceManager.init(getApplicationContext());
        Intent activityIntent;
        //notification
        initialActivity = this;
        //registerWithNotificationHubs();

        if (checkTokenIsValid() == true) {

            activityIntent = new Intent(this, MainActivity.class);

        } else {

            activityIntent = new Intent(this, LoginActivity.class);

        }
        startActivity(activityIntent);
        finish();

    }

    private boolean checkTokenIsValid() {

        String session = SharedPreferenceManager.read(SharedPreferenceManager.TOKEN, "");
        if (session.equals("") || session == null) {
            return false;
        } else {
            return true;//
        }
    }
    /**
     * Check the device to make sure it has the Google Play Services APK. If
     * it doesn't, display a dialog that allows users to download the APK from
     * the Google Play Store or enable it in the device's system settings.
     */

//    private boolean checkPlayServices() {
//        GoogleApiAvailability apiAvailability = GoogleApiAvailability.getInstance();
//        int resultCode = apiAvailability.isGooglePlayServicesAvailable(this);
//        if (resultCode != ConnectionResult.SUCCESS) {
//            if (apiAvailability.isUserResolvableError(resultCode)) {
//                apiAvailability.getErrorDialog(this, resultCode, PLAY_SERVICES_RESOLUTION_REQUEST)
//                        .show();
//            } else {
//                Log.i(TAG, "This device is not supported by Google Play Services.");
//                ToastNotify("This device is not supported by Google Play Services.");
//                finish();
//            }
//            return false;
//        }
//        return true;
//    }

//    public void registerWithNotificationHubs() {
//        if (checkPlayServices()) {
//            // Start IntentService to register this application with FCM.
//            //if (SharedPreferenceManager.read(SharedPreferenceManager.FIREBASE_TOKEN, "") == "") {
//            Intent intent = new Intent(this, RegistrationIntentService.class);
//            startService(intent);
//            //}
//        }
//    }
    public void ToastNotify(final String notificationMessage) {
        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                Toast.makeText(InitialActivity.this, notificationMessage, Toast.LENGTH_LONG).show();
//                TextView helloText = (TextView) findViewById(R.id.text_hello);
//                helloText.setText(notificationMessage);
            }
        });
    }

}

