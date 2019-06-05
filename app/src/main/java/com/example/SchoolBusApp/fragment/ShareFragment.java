package com.example.SchoolBusApp.fragment;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.SchoolBusApp.R;

public class ShareFragment extends Fragment {
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {


        return inflater.inflate(R.layout.share_event_fragment, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
//        Bundle bundle = this.getArguments();
//        BarcodeEncoder barcodeEncoder = new BarcodeEncoder();
//        Bitmap bitmap = null;
//        try {
//            bitmap = barcodeEncoder.encodeBitmap(bundle.getString("qrCode"), BarcodeFormat.QR_CODE, 600, 600);
//        } catch (WriterException e) {
//            e.printStackTrace();
//        }
//        ImageView imageViewQrCode = (ImageView) getActivity().findViewById(R.id.qrCode);
//        imageViewQrCode.setImageBitmap(bitmap);
//
    }


}
