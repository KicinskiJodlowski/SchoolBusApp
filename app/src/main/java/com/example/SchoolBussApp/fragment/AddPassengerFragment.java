package com.example.SchoolBussApp.fragment;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;

import android.content.Intent;

import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.ArrayMap;
import android.util.Base64;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;

import android.view.ViewGroup;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageView;

import android.widget.TimePicker;
import android.widget.Toast;
import com.example.SchoolBussApp.R;
import com.example.SchoolBussApp.RetrofitClient;

import org.json.JSONObject;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.Calendar;
import java.util.Map;


import okhttp3.RequestBody;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static android.app.Activity.RESULT_OK;

public class AddPassengerFragment extends Fragment implements DatePickerDialog.OnDateSetListener, TimePickerDialog.OnTimeSetListener {

    Button btnDatePick, btnTimePick, btnAddPhoto, btnAddEvent;
    int day, month, year, hour, minute;

    EditText textEventTitle, textEventDesc;

    ImageView imageEvent;

    private static final int PICK_IMAGE = 100;

    Uri imageUri;

    Bitmap bitmap;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.add_event_fragment, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        initViews();

        btnAddPhoto.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openGallery();
            }
        });

        btnAddEvent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addEvent();
            }
        });

        btnDatePick.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Calendar c = Calendar.getInstance();
                year = c.get(Calendar.YEAR);
                month = c.get(Calendar.MONTH);
                day = c.get(Calendar.DAY_OF_MONTH);

                DatePickerDialog datePickerDialog = new DatePickerDialog(getActivity(),
                        AddPassengerFragment.this,
                        year, month, day);

                datePickerDialog.show();
            }
        });

        btnTimePick.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Calendar c = Calendar.getInstance();
                hour = c.get(Calendar.HOUR_OF_DAY);
                minute = c.get(Calendar.MINUTE);

                TimePickerDialog timePickerDialog = new TimePickerDialog(getActivity(),
                        AddPassengerFragment.this,
                        hour, minute, true);

                timePickerDialog.show();
            }
        });
    }

    private void initViews() {
        imageEvent = getActivity().findViewById(R.id.imageEvent);
        btnAddPhoto = getActivity().findViewById(R.id.btnAddPhoto);
        btnDatePick = getActivity().findViewById(R.id.eventStartDate);
        btnTimePick = getActivity().findViewById(R.id.eventStartTime);
        btnAddEvent = getActivity().findViewById(R.id.btnAddEvent);
        textEventTitle = getActivity().findViewById(R.id.eventTitle);
        textEventDesc = getActivity().findViewById(R.id.eventDesc);
    }

    @Override
    public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
        String validMonth, validDay;
        month += 1;
        if (month < 10) validMonth = String.format("0%d", month);
        else validMonth = String.format("%d", month);
        if (dayOfMonth < 10) validDay = String.format("0%d", dayOfMonth);
        else validDay = String.format("%d", dayOfMonth);

        String tmp = String.format("%d/", year) + validMonth + "/" + validDay;
        btnDatePick.setText(tmp);
    }

    @Override
    public void onTimeSet(TimePicker view, int hourOfDay, int minute) {

        String hourText, minuteText;
        if (hourOfDay < 10) hourText = String.format("0%d", hourOfDay);
        else hourText = String.format("%d", hourOfDay);
        if (minute < 10) minuteText = String.format("0%d", minute);
        else minuteText = String.format("%d", minute);

        String tmp = hourText + ":" + minuteText;
        btnTimePick.setText(tmp);
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(resultCode == RESULT_OK && requestCode == PICK_IMAGE)
        {
            imageUri = data.getData();
            try {
                bitmap = MediaStore.Images.Media.getBitmap(getContext().getContentResolver(), imageUri);
                imageEvent.setImageBitmap(bitmap);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public String convertToBase64(Bitmap bmap) {

        ByteArrayOutputStream stream = new ByteArrayOutputStream();
        bmap.compress(Bitmap.CompressFormat.JPEG, 5, stream);
        byte[] imageBytes = stream.toByteArray();

        return Base64.encodeToString(imageBytes, Base64.DEFAULT);
    }


    public void openGallery() {
        Intent gallery = new Intent(Intent.ACTION_PICK, MediaStore.Images.Media.INTERNAL_CONTENT_URI);
        startActivityForResult(gallery, PICK_IMAGE);
    }

    private void addEvent() {

        String title, date, desc, imgURL = "";
        title = textEventTitle.getText().toString().trim();
        date = btnDatePick.getText().toString().trim() + " " + btnTimePick.getText().toString().trim();
        desc = textEventDesc.getText().toString().trim();
        if(bitmap != null) imgURL = convertToBase64(bitmap);

        Map<String, Object> jsonParams = new ArrayMap<>();
        jsonParams.put("eventName", title);
        jsonParams.put("dateOfEvent", date);
        jsonParams.put("description", desc);
        jsonParams.put("imgURL", imgURL);

        RequestBody body = RequestBody.create(okhttp3.MediaType.parse("application/json; charset=utf-8"),(new JSONObject(jsonParams)).toString());

        Call<ResponseBody> call = RetrofitClient.getInstance().getApi().addEvent(LoginFragment.userTOKEN, body);

        call.enqueue(new Callback<ResponseBody>() {
            @Override
            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {

                Log.d("RESPONSE CODE", Integer.toString(response.code()));

                if(response.code() == 201) {
                    Toast.makeText(getActivity(), "Dodano nowe wydarzenie", Toast.LENGTH_SHORT).show();
                    getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, new MainScreenFragment()).commit();
                }
                else if(response.code() == 401) {
                    Toast.makeText(getActivity(), "Brak autoryzacji", Toast.LENGTH_SHORT).show();
                }
                else {
                    Toast.makeText(getActivity(), "Wystąpił błąd! Upewnij się, że wprowadzono nazwę oraz wybrano datę", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<ResponseBody> call, Throwable t) {
                Toast.makeText(getActivity(), t.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }
}
