package com.example.SchoolBusApp.model;

import android.telecom.Call;

import com.example.SchoolBusApp.RetrofitClient;
import com.example.SchoolBusApp.SharedPreferenceManager;
import com.example.SchoolBusApp.service.UserAPIClient;

import java.util.ArrayList;

import lombok.Data;
import okhttp3.ResponseBody;
import retrofit2.Callback;
import retrofit2.Response;

@Data
public class PassengerArray {
    private ArrayList<PassengerModel> lista;

    public PassengerArray() {
//        Call<ResponseBody> call = new RetrofitClient.getApi().getAllUsers(SharedPreferenceManager.read(SharedPreferenceManager.TOKEN, ""));
//        call.enqueue(new Callback<ResponseBody>() {
//            @Override
//            public void onResponse(retrofit2.Call<ResponseBody> call, Response<ResponseBody> response) {
//                if (response.code()==200) lista= response.body().string();
//            }
//            @Override
//            public void onFailure(retrofit2.Call<ResponseBody> call, Throwable t) {
//            }
//        });

        lista = new ArrayList<>();
        lista.add(new PassengerModel(new UserJSONModel("5cfba96fc5db3c001715eb82", "zwykly.user@student.wat.edu.pl"), 52.2322678, 20.9999925));
        lista.add(new PassengerModel(new UserJSONModel("5cf6fc0bf3c6ad0017898a49", "zwykly.user2@student.wat.edu.pl"), 52.2322678, 20.9999925));
        lista.add(new PassengerModel(new UserJSONModel("5cf72de4bc1b9200176a367c", "zwykly.user3@student.wat.edu.pl"), 52.2322678, 20.9999925));
        lista.add(new PassengerModel(new UserJSONModel("5cf72deabc1b9200176a367d", "zwykly.user4@student.wat.edu.pl"), 52.2322678, 20.9999925));
        lista.add(new PassengerModel(new UserJSONModel("5cf72dedbc1b9200176a367e", "zwykly.user5@student.wat.edu.pl"), 52.2322678, 20.9999925));
        lista.add(new PassengerModel(new UserJSONModel("5cf72df0bc1b9200176a367f", "zwykly.user6@student.wat.edu.pl"), 52.2322678, 20.9999925));
        lista.add(new PassengerModel(new UserJSONModel("5cf72df4bc1b9200176a3680", "zwykly.user7@student.wat.edu.pl"), 52.2322678, 20.9999925));
        lista.add(new PassengerModel(new UserJSONModel("5cf72df7bc1b9200176a3681", "zwykly.user8@student.wat.edu.pl"), 52.2322678, 20.9999925));
        lista.add(new PassengerModel(new UserJSONModel("5cf72dfcbc1b9200176a3682", "zwykly.user9@student.wat.edu.pl"), 52.2322678, 20.9999925));
        lista.add(new PassengerModel(new UserJSONModel("5cf72e02bc1b9200176a3683", "zwykly.user10@student.wat.edu.pl"), 52.2322678, 20.9999925));
        lista.add(new PassengerModel(new UserJSONModel("5cf72e06bc1b9200176a3684", "zwykly.user11@student.wat.edu.pl"), 52.2322678, 20.9999925));
        lista.add(new PassengerModel(new UserJSONModel("5cf72e09bc1b9200176a3685", "zwykly.user12@student.wat.edu.pl"), 52.2322678, 20.9999925));
        lista.add(new PassengerModel(new UserJSONModel("5cf72e0ebc1b9200176a3686", "zwykly.user13@student.wat.edu.pl"), 52.2322678, 20.9999925));
        lista.add(new PassengerModel(new UserJSONModel("5cf72e11bc1b9200176a3687", "zwykly.user14@student.wat.edu.pl"), 52.2322678, 20.9999925));
        lista.add(new PassengerModel(new UserJSONModel("5cf72e17bc1b9200176a3688", "zwykly.user15@student.wat.edu.pl"), 52.2322678, 20.9999925));
        lista.add(new PassengerModel(new UserJSONModel("5cf72e1cbc1b9200176a3689", "zwykly.user16@student.wat.edu.pl"), 52.2322678, 20.9999925));
        lista.add(new PassengerModel(new UserJSONModel("5cf72e20bc1b9200176a368a", "zwykly.user17@student.wat.edu.pl"), 52.2322678, 20.9999925));
        lista.add(new PassengerModel(new UserJSONModel("5cf72e23bc1b9200176a368b", "zwykly.user18@student.wat.edu.pl"), 52.2322678, 20.9999925));
        lista.add(new PassengerModel(new UserJSONModel("5cf72e27bc1b9200176a368c", "zwykly.user19@student.wat.edu.pl"), 52.2322678, 20.9999925));
        lista.add(new PassengerModel(new UserJSONModel("5cf72e2dbc1b9200176a368d", "zwykly.user20@student.wat.edu.pl"), 52.2322678, 20.9999925));
        lista.add(new PassengerModel(new UserJSONModel("5cf72e31bc1b9200176a368e", "zwykly.user21@student.wat.edu.pl"), 52.2322678, 20.9999925));
        lista.add(new PassengerModel(new UserJSONModel("5cf72e35bc1b9200176a368f", "zwykly.user22@student.wat.edu.pl"), 52.2322678, 20.9999925));
        lista.add(new PassengerModel(new UserJSONModel("5cf72e38bc1b9200176a3690", "zwykly.user23@student.wat.edu.pl"), 52.2322678, 20.9999925));
        lista.add(new PassengerModel(new UserJSONModel("5cf72e3cbc1b9200176a3691", "zwykly.user24@student.wat.edu.pl"), 52.2322678, 20.9999925));
        lista.add(new PassengerModel(new UserJSONModel("5cf72e3fbc1b9200176a3692", "zwykly.user25@student.wat.edu.pl"), 52.2322678, 20.9999925));
    }
}
//        { "id": "5cfba96fc5db3c001715eb82", "latitude": "52.2322678", "longitude": "20.9999925" },
//        { "id": "5cf72e3fbc1b9200176a3692", "name": "zwykly.user25", "picture": "https://gravatar.com/avatar/c2acf58e9b066e2938e1571527f89204?d=identicon" },
//        { "id": "5cf72e3cbc1b9200176a3691", "name": "zwykly.user24", "picture": "https://gravatar.com/avatar/c394630b1673118748fd164f9f042237?d=identicon" },
//        { "id": "5cf72e38bc1b9200176a3690", "name": "zwykly.user23", "picture": "https://gravatar.com/avatar/db4abd4d068e9b0615a6e6dab9a75742?d=identicon" },
//        { "id": "5cf72e35bc1b9200176a368f", "name": "zwykly.user22", "picture": "https://gravatar.com/avatar/6cd46a1aa6e1420e05e52883c425eddb?d=identicon" },
//        { "id": "5cf72e31bc1b9200176a368e", "name": "zwykly.user21", "picture": "https://gravatar.com/avatar/fd8cf44491dcc67de7c7ca8e656ef44f?d=identicon" },
//        { "id": "5cf72e2dbc1b9200176a368d", "name": "zwykly.user20", "picture": "https://gravatar.com/avatar/66009abbf11e8aeacf725de36992af5d?d=identicon" },
//        { "id": "5cf72e27bc1b9200176a368c", "name": "zwykly.user19", "picture": "https://gravatar.com/avatar/bb7228bb1f323ee9e6c33e6336300cff?d=identicon" },
//        { "id": "5cf72e23bc1b9200176a368b", "name": "zwykly.user18", "picture": "https://gravatar.com/avatar/b90ea1386c6f56dc8a0940afc374808a?d=identicon" },
//        { "id": "5cf72e20bc1b9200176a368a", "name": "zwykly.user17", "picture": "https://gravatar.com/avatar/cd133137754a11cd6079583733144564?d=identicon" },
//        { "id": "5cf72e1cbc1b9200176a3689", "name": "zwykly.user16", "picture": "https://gravatar.com/avatar/f6e12441d8513ddbd5cff860aad208ec?d=identicon" },
//        { "id": "5cf72e17bc1b9200176a3688", "name": "zwykly.user15", "picture": "https://gravatar.com/avatar/3299ca8e88d642627b4147d081db91af?d=identicon" },
//        { "id": "5cf72e11bc1b9200176a3687", "name": "zwykly.user14", "picture": "https://gravatar.com/avatar/aa2400e3e6c3cf293c66c5a4965ad421?d=identicon" },
//        { "id": "5cf72e0ebc1b9200176a3686", "name": "zwykly.user13", "picture": "https://gravatar.com/avatar/831b8d972793f842319156a31b1af91b?d=identicon" },
//        { "id": "5cf72e09bc1b9200176a3685", "name": "zwykly.user12", "picture": "https://gravatar.com/avatar/0bf19b24b4d8c7c02be32a00435a4719?d=identicon" },
//        { "id": "5cf72e06bc1b9200176a3684", "name": "zwykly.user11", "picture": "https://gravatar.com/avatar/51d61ee0dc4f04979f829e2ad0132d82?d=identicon" },
//        { "id": "5cf72e02bc1b9200176a3683", "name": "zwykly.user10", "picture": "https://gravatar.com/avatar/e08a1fad1c4dcdf9f46c44b934cf5dc8?d=identicon" },
//        { "id": "5cf72dfcbc1b9200176a3682", "name": "zwykly.user9", "picture": "https://gravatar.com/avatar/f2fec13ae9c75e276db02373ae8aad66?d=identicon" },
//        { "id": "5cf72df7bc1b9200176a3681", "name": "zwykly.user8", "picture": "https://gravatar.com/avatar/dec31c3513c5cafb9458416af358b128?d=identicon" },
//        { "id": "5cf72df4bc1b9200176a3680", "name": "zwykly.user7", "picture": "https://gravatar.com/avatar/f2c33f0422fd849b9e0ab62db3a2ce23?d=identicon" },
//        { "id": "5cf72df0bc1b9200176a367f", "name": "zwykly.user6", "picture": "https://gravatar.com/avatar/541f54f300194c43deb97032082ff22b?d=identicon" },
//        { "id": "5cf72dedbc1b9200176a367e", "name": "zwykly.user5", "picture": "https://gravatar.com/avatar/f8815ba8403c04a09be92b49c5a8a25b?d=identicon" },
//        { "id": "5cf72deabc1b9200176a367d", "name": "zwykly.user4", "picture": "https://gravatar.com/avatar/6b2a55c7f51d56855bd8eb9639336b7f?d=identicon" },
//        { "id": "5cf72de4bc1b9200176a367c", "name": "zwykly.user3", "picture": "https://gravatar.com/avatar/7805fcec4f459b60268713e4db8cff10?d=identicon" },
//        { "id": "5cf6fc0bf3c6ad0017898a49", "name": "zwykly.user2", "picture": "https://gravatar.com/avatar/21407e1c462e95f6b073fd22bdadffcd?d=identicon" }
