package com.example.SchoolBusApp.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.example.SchoolBusApp.R;
import com.example.SchoolBusApp.model.PassengerModel;

import java.util.ArrayList;

public class PassengerAdapter extends ArrayAdapter<PassengerModel> {
    private static final String TAG = "PassengerRecordAdapter";

    private Context con;
    int res;

    public PassengerAdapter(Context context, int resource, ArrayList<PassengerModel> objects) {
        super(context, resource, objects);
        con = context;
        res = resource;
    }

    @NonNull
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        String title = getItem(position).getUser().getEmail();
        String latitude = String.valueOf(getItem(position).getLatitude());
        String longitude = String.valueOf(getItem(position).getLongitude());

        LayoutInflater inflater = LayoutInflater.from(con);
        convertView = inflater.inflate(res, parent, false);

        TextView passengerEmail = convertView.findViewById(R.id.textPassengerEmail);
        TextView passengerLatLon = convertView.findViewById(R.id.textPassengerLatLon);

        passengerEmail.setText(title);
        passengerLatLon.setText("Szerokość: "+latitude+ "   Dlugosc: "+longitude);

        return convertView;
    }
}
