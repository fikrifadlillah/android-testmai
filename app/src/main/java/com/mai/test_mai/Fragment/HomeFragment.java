package com.mai.test_mai.Fragment;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;
import android.widget.ImageView;

import com.mai.test_mai.CustomGridView;
import com.mai.test_mai.R;
import com.synnapps.carouselview.CarouselView;
import com.synnapps.carouselview.ImageListener;

public class HomeFragment extends Fragment {
    GridView androidGridView;
    CarouselView carouselView;

    String[] gridViewString = {
            "Pulsa", "Paket Data", "PLN", "Telkom","Game", "TV","BPJS","Voucher","Wifi","PDAM","Cicilan"

    } ;
    int[] gridViewImageId = {
            R.drawable.smartphone,
            R.drawable.phonering,
            R.drawable.light,
            R.drawable.phone,
            R.drawable.game,
            R.drawable.tv,
            R.drawable.hospital,
            R.drawable.ticket,
            R.drawable.wifi,
            R.drawable.water,
            R.drawable.cc
    };
    int[] sampleImages = {R.drawable.slider};

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_home, container, false);

        carouselView = view.findViewById(R.id.carouselView);
        carouselView.setPageCount(sampleImages.length);

        CustomGridView adapterViewAndroid = new CustomGridView(getActivity().getApplicationContext(), gridViewString, gridViewImageId);
        androidGridView= view.findViewById(R.id.grid_view_image_text);
        androidGridView.setAdapter(adapterViewAndroid);

        ImageListener imageListener = new ImageListener() {
            @Override
            public void setImageForPosition(int position, ImageView imageView) {
                imageView.setImageResource(sampleImages[position]);
            }
        };
        carouselView.setImageListener(imageListener);
        return view;
    }
}
