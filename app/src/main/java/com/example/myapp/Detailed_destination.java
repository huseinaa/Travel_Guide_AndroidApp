package com.example.myapp;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class Detailed_destination extends Fragment {

    private static final String ARG_DESTINATION_NAME = "destinationName";
    private static final String ARG_DESTINATION_DESCRIPTION = "destinationDescription";
    private static final String ARG_IMAGE_RES_ID = "imageResId";

    public Detailed_destination() {
        // Required empty public constructor
    }

    public static Detailed_destination newInstance(String destinationName, String description, int imageResId) {
        Detailed_destination fragment = new Detailed_destination();
        Bundle args = new Bundle();
        args.putString(ARG_DESTINATION_NAME, destinationName);
        args.putString(ARG_DESTINATION_DESCRIPTION, description);
        args.putInt(ARG_IMAGE_RES_ID, imageResId);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_detailed_destination, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        if (getArguments() != null) {
            String destinationName = getArguments().getString(ARG_DESTINATION_NAME);
            String description = getArguments().getString(ARG_DESTINATION_DESCRIPTION);
            int imageResId = getArguments().getInt(ARG_IMAGE_RES_ID);

            TextView destinationNameView = view.findViewById(R.id.destinationName);
            TextView descriptionView = view.findViewById(R.id.description);
            ImageView imageView = view.findViewById(R.id.imageView);

            destinationNameView.setText(destinationName);
            descriptionView.setText(description);
            imageView.setImageResource(imageResId);
        }
    }
}
