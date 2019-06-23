package com.example.SchoolBusApp.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.text.Editable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.SchoolBusApp.R;
import com.example.SchoolBusApp.RetrofitHerokuClient;
import com.example.SchoolBusApp.SharedPreferenceManager;
import com.example.SchoolBusApp.activity.MainActivity;
import com.example.SchoolBusApp.model.UserJSONModel;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class RegisterFragment extends Fragment {

    private Intent activityIntent;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.register_fragment, container, false);
        return rootView;

    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        Button loginViewButton = view.findViewById(R.id.signInButton);
        Button registerUserButton = view.findViewById(R.id.loginButton);
        final EditText password = view.findViewById(R.id.passwordText);
        EditText passwordRepeat = view.findViewById(R.id.passwordRepeatText);
        final Editable passwordText = password.getText();
        final Editable passwordRepeatText = passwordRepeat.getText();
        final TextView errorText = getActivity().findViewById(R.id.errorText);

        loginViewButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.fragment_containerLogin, new LoginFragment()).commit();
            }
        });
        registerUserButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getActivity().getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_HIDDEN);
                if (passwordRepeatText.toString().equals(passwordText.toString())) {
                    registerOnClick();
                } else errorText.setText("Podane hasła nie są tożsame.");
            }
        });
    }

    private void registerOnClick() {
//        UserJSONModel user = new UserJSONModel(((EditText) getActivity().findViewById(R.id.userNameText)).getText().toString(),
//                ((EditText) getActivity().findViewById(R.id.mailText)).getText().toString(),
//                ((EditText) getActivity().findViewById(R.id.passwordText)).getText().toString(),
//                ((EditText) getActivity().findViewById(R.id.fullNameText)).getText().toString(), "");
        final TextView errorText = getActivity().findViewById(R.id.errorText);
        Call<ResponseBody> call = RetrofitHerokuClient.getInstance().getApi().register(SharedPreferenceManager.read(SharedPreferenceManager.MASTER_KEY, ""),
                ((EditText) getActivity().findViewById(R.id.mailText)).getText().toString(), ((EditText) getActivity().findViewById(R.id.passwordText)).getText().toString());
        call.enqueue(new Callback<ResponseBody>() {
            @Override
            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                switch (response.code()) {
                    case 201:
                        try {
                            SharedPreferenceManager.write(SharedPreferenceManager.AUTH, response.body().string());
                        } catch (IOException e) {
                            Toast.makeText(getActivity(), "Server internal error: " + e.getMessage(), Toast.LENGTH_SHORT).show();
                        }

                        try {
                            SharedPreferenceManager.write(SharedPreferenceManager.TOKEN, new JSONObject(SharedPreferenceManager.read(SharedPreferenceManager.AUTH, "")).getString("token"));
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                        try {
                            UserJSONModel user = new UserJSONModel(new JSONObject(SharedPreferenceManager.read(SharedPreferenceManager.AUTH, "")).getJSONObject("user"));
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                        activityIntent = new Intent(getActivity(), MainActivity.class);
                        startActivity(activityIntent);
                        getActivity().finish();
                        break;
                    case 400:
                        errorText.setText("");
                        try {
                            errorText.append("Błąd rejestracji:\n"+new JSONObject(response.errorBody().string()).getString("message") + "\n");
                        } catch (JSONException e) {
                            e.printStackTrace();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                        break;
                    case 401:
                        errorText.setText("");
                        errorText.append("Server internal error: Master_token is invalid.");
                        break;
                    case 409:
                        errorText.setText("");
                        try {
                            errorText.append("Błąd rejestracji:\n"+new JSONObject(response.errorBody().string()).getString("message") + "\n");
                        } catch (JSONException e) {
                            e.printStackTrace();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                        break;
                }
//                List<Error> errors = response.body().getErrors();
//                if(errors.size()==0){
//                errorText.setText("");
//                for (Error e : errors) {
//                    errorText.append(e.getDescription()+ "\n");
//                }}else {
//                    Toast.makeText(getActivity(),"Pomyślnie zarejestrowano użytkownika - możesz się teraz zalogować.", Toast.LENGTH_LONG).show();
//                    getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.fragment_containerLogin, new LoginFragment()).commit();
//                }
            }

            @Override
            public void onFailure(Call<ResponseBody> call, Throwable t) {
                Toast.makeText(getActivity(), "Rejestracja nie powiodła się.", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
