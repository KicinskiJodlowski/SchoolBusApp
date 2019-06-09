package com.example.SchoolBusApp.model;

import lombok.Data;

@Data
public class PassengerModel {

    private UserJSONModel user;
    private double latitude;
    private double longitude;
    private String createdAt;
    private String updatedAt;

    public PassengerModel(UserJSONModel user, double latitude, double longitude) {
        this.user = user;
        this.latitude = latitude;
        this.longitude = longitude;
    }

    //    {
//        "count": 1,
//            "rows": [
//        {
//            "id": "5cf9def979a6b2001757ead7",
//                "user": {
//            "id": "5cf6f7cdf3c6ad0017898a43",
//                    "name": "zwykly.user",
//                    "picture": "https://gravatar.com/avatar/21ce2e01d2549e08600be77bf60b12a7?d=identicon"
//        },
//            "longitude": "20.896382",
//                "latitude": "52.252008",
//                "createdAt": "2019-06-07T03:50:17.416Z",
//                "updatedAt": "2019-06-07T03:50:17.416Z"
//        }
//    ]
//    }
}
