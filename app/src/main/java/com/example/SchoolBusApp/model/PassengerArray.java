package com.example.SchoolBusApp.model;

import java.util.ArrayList;

import lombok.Data;

@Data
public class PassengerArray {
    private ArrayList<PassengerModel> lista = new ArrayList<>();

    public PassengerArray() {
//        Call<ResponseBody> call = new RetrofitHerokuClient.getApi().getAllUsers(SharedPreferenceManager.read(SharedPreferenceManager.TOKEN, ""));
//        call.enqueue(new Callback<ResponseBody>() {
//            @Override
//            public void onResponse(retrofit2.Call<ResponseBody> call, Response<ResponseBody> response) {
//                if (response.code()==200) lista= response.body().string();
//            }
//            @Override
//            public void onFailure(retrofit2.Call<ResponseBody> call, Throwable t) {
//            }
//        });

        //TESTOWANIE BEZ BIEGANIA Z TELEFONEM PO MIEŚCIE
        lista = new ArrayList<>();
//        lista.add(new PassengerModel(new UserJSONModel("5cfba96fc5db3c001715eb82", "zwykly.user1@student.wat.edu.pl"), 52.250458, 20.889897));
//        lista.add(new PassengerModel(new UserJSONModel("5cf6fc0bf3c6ad0017898a49", "zwykly.user2@student.wat.edu.pl"), 52.251962, 20.894242));
//        lista.add(new PassengerModel(new UserJSONModel("5cf72de4bc1b9200176a367c", "zwykly.user3@student.wat.edu.pl"), 52.254070, 20.891517));
//        lista.add(new PassengerModel(new UserJSONModel("5cf72deabc1b9200176a367d", "zwykly.user4@student.wat.edu.pl"), 52.253617, 20.898265));
//        lista.add(new PassengerModel(new UserJSONModel("5cf72dedbc1b9200176a367e", "zwykly.user5@student.wat.edu.pl"), 52.258011, 20.894853));
//        lista.add(new PassengerModel(new UserJSONModel("5cf72df0bc1b9200176a367f", "zwykly.user6@student.wat.edu.pl"),  52.265959, 20.899563));
//        lista.add(new PassengerModel(new UserJSONModel("5cf72df4bc1b9200176a3680", "zwykly.user7@student.wat.edu.pl"), 52.264790, 20.901601));
//        lista.add(new PassengerModel(new UserJSONModel("5cf72df7bc1b9200176a3681", "zwykly.user8@student.wat.edu.pl"), 52.265020, 20.907620));
//        lista.add(new PassengerModel(new UserJSONModel("5cf72dfcbc1b9200176a3682", "zwykly.user9@student.wat.edu.pl"), 52.261743, 20.905785));
//        lista.add(new PassengerModel(new UserJSONModel("5cf72e02bc1b9200176a3683", "zwykly.user10@student.wat.edu.pl"), 52.261270, 20.908714));
//        lista.add(new PassengerModel(new UserJSONModel("5cf72e06bc1b9200176a3684", "zwykly.user11@student.wat.edu.pl"), 52.249099, 20.907469));
//        lista.add(new PassengerModel(new UserJSONModel("5cf72e09bc1b9200176a3685", "zwykly.user12@student.wat.edu.pl"), 52.250156, 20.912576));
//        lista.add(new PassengerModel(new UserJSONModel("5cf72e0ebc1b9200176a3686", "zwykly.user13@student.wat.edu.pl"), 52.251831, 20.911235));
//        lista.add(new PassengerModel(new UserJSONModel("5cf72e11bc1b9200176a3687", "zwykly.user14@student.wat.edu.pl"), 52.249815, 20.908048));
//        lista.add(new PassengerModel(new UserJSONModel("5cf72e17bc1b9200176a3688", "zwykly.user15@student.wat.edu.pl"), 52.249204, 20.912190));
//        lista.add(new PassengerModel(new UserJSONModel("5cf72e1cbc1b9200176a3689", "zwykly.user16@student.wat.edu.pl"), 52.258632, 20.914691));
//        lista.add(new PassengerModel(new UserJSONModel("5cf72e20bc1b9200176a368a", "zwykly.user17@student.wat.edu.pl"), 52.254754, 20.911687));
//        lista.add(new PassengerModel(new UserJSONModel("5cf72e23bc1b9200176a368b", "zwykly.user18@student.wat.edu.pl"), 52.255082, 20.915657));
//        lista.add(new PassengerModel(new UserJSONModel("5cf72e27bc1b9200176a368c", "zwykly.user19@student.wat.edu.pl"), 52.254478, 20.917813));
//        lista.add(new PassengerModel(new UserJSONModel("5cf72e2dbc1b9200176a368d", "zwykly.user20@student.wat.edu.pl"), 52.252731, 20.915721));
//        lista.add(new PassengerModel(new UserJSONModel("5cf72e31bc1b9200176a368e", "zwykly.user21@student.wat.edu.pl"), 52.249388, 20.922259));
//        lista.add(new PassengerModel(new UserJSONModel("5cf72e35bc1b9200176a368f", "zwykly.user22@student.wat.edu.pl"), 52.249467, 20.923976));
//        lista.add(new PassengerModel(new UserJSONModel("5cf72e38bc1b9200176a3690", "zwykly.user23@student.wat.edu.pl"), 52.250459, 20.925387));
//        lista.add(new PassengerModel(new UserJSONModel("5cf72e3cbc1b9200176a3691", "zwykly.user24@student.wat.edu.pl"), 52.250850, 20.927329));
//        lista.add(new PassengerModel(new UserJSONModel("5cf72e3fbc1b9200176a3692", "zwykly.user25@student.wat.edu.pl"), 52.249730, 20.927200));

        lista.add(new PassengerModel(new UserJSONModel("5cf72e3fbc1b9200176a3692", "zwykly.user1@student.wat.edu.pl"),52.22013394, 21.01572655));
        lista.add(new PassengerModel(new UserJSONModel("5cf72e3fbc1b9200176a3692", "zwykly.user2@student.wat.edu.pl"),52.23872352, 20.99472913));
        lista.add(new PassengerModel(new UserJSONModel("5cf72e3fbc1b9200176a3692", "zwykly.user3@student.wat.edu.pl"),52.22758423, 20.98524081));
        lista.add(new PassengerModel(new UserJSONModel("5cf72e3fbc1b9200176a3692", "zwykly.user4@student.wat.edu.pl"),52.22956104, 20.98521492));
        lista.add(new PassengerModel(new UserJSONModel("5cf72e3fbc1b9200176a3692", "zwykly.user5@student.wat.edu.pl"),52.23593095, 21.02320454));
        lista.add(new PassengerModel(new UserJSONModel("5cf72e3fbc1b9200176a3692", "zwykly.user6@student.wat.edu.pl"),52.21849827, 21.01018544));
        lista.add(new PassengerModel(new UserJSONModel("5cf72e3fbc1b9200176a3692", "zwykly.user7@student.wat.edu.pl"),52.21630465, 20.99543216));
        lista.add(new PassengerModel(new UserJSONModel("5cf72e3fbc1b9200176a3692", "zwykly.user8@student.wat.edu.pl"),52.23790775, 21.0003662));
        lista.add(new PassengerModel(new UserJSONModel("5cf72e3fbc1b9200176a3692", "zwykly.user9@student.wat.edu.pl"),52.23284915, 21.02916227));
        lista.add(new PassengerModel(new UserJSONModel("5cf72e3fbc1b9200176a3692", "zwykly.user10@student.wat.edu.pl"),52.22838969, 20.99560464));
        lista.add(new PassengerModel(new UserJSONModel("5cf72e3fbc1b9200176a3692", "zwykly.user11@student.wat.edu.pl"),52.23309908, 20.99933061));
        lista.add(new PassengerModel(new UserJSONModel("5cf72e3fbc1b9200176a3692", "zwykly.user12@student.wat.edu.pl"),52.24090659, 21.00930492));
        lista.add(new PassengerModel(new UserJSONModel("5cf72e3fbc1b9200176a3692", "zwykly.user13@student.wat.edu.pl"),52.22508057, 20.99907475));
        lista.add(new PassengerModel(new UserJSONModel("5cf72e3fbc1b9200176a3692", "zwykly.user14@student.wat.edu.pl"),52.24212823, 21.00992881));
        lista.add(new PassengerModel(new UserJSONModel("5cf72e3fbc1b9200176a3692", "zwykly.user15@student.wat.edu.pl"),52.2300711, 20.98280971));
        lista.add(new PassengerModel(new UserJSONModel("5cf72e3fbc1b9200176a3692", "zwykly.user16@student.wat.edu.pl"),52.22090367, 21.01705612));
        lista.add(new PassengerModel(new UserJSONModel("5cf72e3fbc1b9200176a3692", "zwykly.user17@student.wat.edu.pl"),52.21646196, 21.00775166));
        lista.add(new PassengerModel(new UserJSONModel("5cf72e3fbc1b9200176a3692", "zwykly.user18@student.wat.edu.pl"),52.24286144, 21.00906833));
        lista.add(new PassengerModel(new UserJSONModel("5cf72e3fbc1b9200176a3692", "zwykly.user19@student.wat.edu.pl"),52.23155658, 21.027216));
        lista.add(new PassengerModel(new UserJSONModel("5cf72e3fbc1b9200176a3692", "zwykly.user20@student.wat.edu.pl"),52.22555075, 20.98220176));
        lista.add(new PassengerModel(new UserJSONModel("5cf72e3fbc1b9200176a3692", "zwykly.user21@student.wat.edu.pl"),52.23007416, 20.9800659));
        lista.add(new PassengerModel(new UserJSONModel("5cf72e3fbc1b9200176a3692", "zwykly.user22@student.wat.edu.pl"),52.23967844, 20.9806044));
        lista.add(new PassengerModel(new UserJSONModel("5cf72e3fbc1b9200176a3692", "zwykly.user23@student.wat.edu.pl"),52.22339605, 21.0297884));
        lista.add(new PassengerModel(new UserJSONModel("5cf72e3fbc1b9200176a3692", "zwykly.user24@student.wat.edu.pl"),52.24542738, 20.98930834));
        lista.add(new PassengerModel(new UserJSONModel("5cf72e3fbc1b9200176a3692", "zwykly.user25@student.wat.edu.pl"),52.23222283, 21.03156408));
        lista.add(new PassengerModel(new UserJSONModel("5cf72e3fbc1b9200176a3692", "zwykly.user26@student.wat.edu.pl"),52.23628229, 21.02679042));
        lista.add(new PassengerModel(new UserJSONModel("5cf72e3fbc1b9200176a3692", "zwykly.user27@student.wat.edu.pl"),52.2183599, 20.9935192));
        lista.add(new PassengerModel(new UserJSONModel("5cf72e3fbc1b9200176a3692", "zwykly.user28@student.wat.edu.pl"),52.23780249, 21.00195832));
        lista.add(new PassengerModel(new UserJSONModel("5cf72e3fbc1b9200176a3692", "zwykly.user29@student.wat.edu.pl"),52.22270676, 20.99805587));
        lista.add(new PassengerModel(new UserJSONModel("5cf72e3fbc1b9200176a3692", "zwykly.user30@student.wat.edu.pl"),52.2320864, 20.98374381));
        lista.add(new PassengerModel(new UserJSONModel("5cf72e3fbc1b9200176a3692", "zwykly.user31@student.wat.edu.pl"),52.23649034, 20.9848647));
        lista.add(new PassengerModel(new UserJSONModel("5cf72e3fbc1b9200176a3692", "zwykly.user32@student.wat.edu.pl"),52.24340152, 20.99135014));
        lista.add(new PassengerModel(new UserJSONModel("5cf72e3fbc1b9200176a3692", "zwykly.user33@student.wat.edu.pl"),52.23082967, 21.03106171));
        lista.add(new PassengerModel(new UserJSONModel("5cf72e3fbc1b9200176a3692", "zwykly.user34@student.wat.edu.pl"),52.22879468, 21.03105865));
        lista.add(new PassengerModel(new UserJSONModel("5cf72e3fbc1b9200176a3692", "zwykly.user35@student.wat.edu.pl"),52.23383856, 21.01959344));
        lista.add(new PassengerModel(new UserJSONModel("5cf72e3fbc1b9200176a3692", "zwykly.user36@student.wat.edu.pl"),52.23535913, 20.99630864));
        lista.add(new PassengerModel(new UserJSONModel("5cf72e3fbc1b9200176a3692", "zwykly.user37@student.wat.edu.pl"),52.22281723, 21.0261062));
        lista.add(new PassengerModel(new UserJSONModel("5cf72e3fbc1b9200176a3692", "zwykly.user38@student.wat.edu.pl"),52.21946279, 20.98220088));
        lista.add(new PassengerModel(new UserJSONModel("5cf72e3fbc1b9200176a3692", "zwykly.user39@student.wat.edu.pl"),52.2248005, 21.02580713));
        lista.add(new PassengerModel(new UserJSONModel("5cf72e3fbc1b9200176a3692", "zwykly.user40@student.wat.edu.pl"),52.21461404, 21.00759345));
        lista.add(new PassengerModel(new UserJSONModel("5cf72e3fbc1b9200176a3692", "zwykly.user41@student.wat.edu.pl"),52.23608147, 21.02900115));
        lista.add(new PassengerModel(new UserJSONModel("5cf72e3fbc1b9200176a3692", "zwykly.user42@student.wat.edu.pl"),52.22471665, 21.00650886));
        lista.add(new PassengerModel(new UserJSONModel("5cf72e3fbc1b9200176a3692", "zwykly.user43@student.wat.edu.pl"),52.23149993, 21.00570127));
        lista.add(new PassengerModel(new UserJSONModel("5cf72e3fbc1b9200176a3692", "zwykly.user44@student.wat.edu.pl"),52.23168299, 20.98926772));
        lista.add(new PassengerModel(new UserJSONModel("5cf72e3fbc1b9200176a3692", "zwykly.user45@student.wat.edu.pl"),52.24322449, 20.99833718));
        lista.add(new PassengerModel(new UserJSONModel("5cf72e3fbc1b9200176a3692", "zwykly.user46@student.wat.edu.pl"),52.23940143, 21.00002204));
        lista.add(new PassengerModel(new UserJSONModel("5cf72e3fbc1b9200176a3692", "zwykly.user47@student.wat.edu.pl"),52.23119756, 20.99878758));
        lista.add(new PassengerModel(new UserJSONModel("5cf72e3fbc1b9200176a3692", "zwykly.user48@student.wat.edu.pl"),52.2270787, 20.98405406));
        lista.add(new PassengerModel(new UserJSONModel("5cf72e3fbc1b9200176a3692", "zwykly.user49@student.wat.edu.pl"),52.24303368, 20.99394428));
        lista.add(new PassengerModel(new UserJSONModel("5cf72e3fbc1b9200176a3692", "zwykly.user50@student.wat.edu.pl"),52.24431022, 21.00870737));

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



