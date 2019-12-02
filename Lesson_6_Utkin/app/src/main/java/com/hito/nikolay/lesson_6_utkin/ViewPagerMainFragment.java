package com.hito.nikolay.lesson_6_utkin;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.ViewPager;

public class ViewPagerMainFragment extends Fragment {

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.view_pager, container, false);

        final ViewPager pager= rootView.findViewById(R.id.viewPagerThirdContainer);
        FragmentPagerAdapter adapterViewPager = new MyFragmentPagerAdapter(getChildFragmentManager());
        pager.setAdapter(adapterViewPager);

        return rootView;
    }
}
