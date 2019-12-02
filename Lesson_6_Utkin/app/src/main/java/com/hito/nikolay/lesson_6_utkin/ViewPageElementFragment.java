package com.hito.nikolay.lesson_6_utkin;

import android.os.Bundle;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

public class ViewPageElementFragment extends androidx.fragment.app.Fragment {

    private static final String ARG_PARAM1 = "1";
    private static final String ARG_PARAM2 = "param2";

    private int mImage;
    private String mName;

    public ViewPageElementFragment() {
        // Required empty public constructor
    }

    public static ViewPageElementFragment newInstance(int mImage, String mName) {
        ViewPageElementFragment fragment = new ViewPageElementFragment();
        Bundle args = new Bundle();
        args.putInt(ARG_PARAM1, mImage);
        args.putString(ARG_PARAM2, mName);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mImage = getArguments().getInt(ARG_PARAM1);
            mName = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_view_pager, null);
        ImageView imageView = rootView.findViewById(R.id.imageViewPager);
        TextView textView = rootView.findViewById(R.id.textViewPager);

        imageView.setImageResource(mImage);
        textView.setText(mName);

        return rootView;
    }
}