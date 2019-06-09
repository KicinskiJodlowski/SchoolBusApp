package com.example.SchoolBusApp.fragment;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.SchoolBusApp.R;
import com.example.SchoolBusApp.RetrofitClient;
import com.example.SchoolBusApp.SharedPreferenceManager;
import com.example.SchoolBusApp.activity.MainActivity;
import com.example.SchoolBusApp.model.UserJSONModel;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.util.Objects;

import okhttp3.Credentials;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class LoginFragment extends Fragment {


    public static String userTOKEN;
    public static String userID;
    private Intent activityIntent;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View loginView = inflater.inflate(R.layout.login_fragment, container, false);
        return loginView;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        Button registerViewButton = view.findViewById(R.id.RegisterButton);
        Button loginUserButton = view.findViewById(R.id.loginButton);
        registerViewButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.fragment_containerLogin, new RegisterFragment()).commit();
            }
        });
        loginUserButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                loginOnClick();
            }
        });
    }

    private void loginOnClick() {
        SharedPreferenceManager.write(SharedPreferenceManager.Login, ((EditText) Objects.requireNonNull(getActivity()).findViewById(R.id.userNameText)).getText().toString());
        String email = ((EditText) Objects.requireNonNull(getActivity()).findViewById(R.id.userNameText)).getText().toString();
        String password = ((EditText) getActivity().findViewById(R.id.passwordText)).getText().toString();
        Call<ResponseBody> call = RetrofitClient.getInstance().getApi().login(Credentials.basic(email, password), SharedPreferenceManager.read(SharedPreferenceManager.MASTER_KEY, ""));
        call.enqueue(new Callback<ResponseBody>() {
            @Override
            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                if (response.isSuccessful()) {
                    if (response.code() == 201) {
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
                        Call<ResponseBody> call2 = RetrofitClient.getInstance().getApi().user_role_check(SharedPreferenceManager.read(SharedPreferenceManager.TOKEN, ""), "1");
                        call2.enqueue(new Callback<ResponseBody>() {
                            @Override
                            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response2) {
                                if (response2.code() == 200)
                                    SharedPreferenceManager.write(SharedPreferenceManager.USER_TYPE, "admin");
                                else if (response2.code() == 401)
                                    SharedPreferenceManager.write(SharedPreferenceManager.USER_TYPE, "user");
                                //Toast.makeText(getActivity(), SharedPreferenceManager.read(SharedPreferenceManager.USER_TYPE, ""), Toast.LENGTH_SHORT).show();
                            }

                            @Override
                            public void onFailure(Call<ResponseBody> call, Throwable t) {
                            }
                        });
                    }
                } else {
                    Toast.makeText(getActivity(), "Nie udało się zalogować.", Toast.LENGTH_SHORT).show();
                }

                if (response.code() == 401) {
                    Toast.makeText(getActivity(), "Niewłaściwe dane logowania.", Toast.LENGTH_SHORT).show();
                }
                activityIntent = new Intent(getActivity(), MainActivity.class);
                startActivity(activityIntent);
                getActivity().finish();

            }

            @Override
            public void onFailure(Call<ResponseBody> call, Throwable t) {
                Toast.makeText(getActivity(), "Serwer nieosiągalny. Spróbuj ponownie później.", Toast.LENGTH_SHORT).show();
            }
        });

    }

//    private void notificationRegister() {
//        SharedPreferences sharedPreferences;
//        sharedPreferences = PreferenceManager.getDefaultSharedPreferences(initialActivity.getApplicationContext());
//        NotifyRegisterModel notifyRegisterModel = new NotifyRegisterModel(sharedPreferences.getString("FCMtoken", null));
//
//        Call<ResponseBody> call2 = RetrofitClient.getInstance().getApi().notifyRegister(sharedPreferences.getString("registrationID", ""),
//                SharedPreferenceManager.read(SharedPreferenceManager.TOKEN, ""), notifyRegisterModel);
//        call2.enqueue(new Callback<ResponseBody>() {
//            @Override
//            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
//                if (response.code() == 200) {
//                    Log.d("RegID", "Rejestracja do notyfikacji udana");
//                    activityIntent = new Intent(getActivity(), MainActivity.class);
//                    startActivity(activityIntent);
//                    //getActivity().finish();
//                } else Log.d("RegID", "Rejestracja do notyfikacji nieudana");
//            }
//
//            @Override
//            public void onFailure(Call<ResponseBody> call, Throwable t) {
//                Log.d("RegID", "Failure request");
//            }
//        });
//    }

}

