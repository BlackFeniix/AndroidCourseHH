package com.hito.nikolay.lesson_6_utkin;


import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

public class MyFragmentPagerAdapter extends FragmentPagerAdapter {
    private static final int ITEM_COUNT = 3;

    public MyFragmentPagerAdapter(@NonNull FragmentManager fm) {
        super(fm);
    }

    @Override
    public int getCount() {
        return ITEM_COUNT;
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        switch (position) {
            case 1:
                return ViewPageElementFragment.newInstance(R.mipmap.img_2, "Картинка 2");
            case 2:
                return ViewPageElementFragment.newInstance(R.mipmap.img_3, "Картинка 3");
            case 0:
            default:
                return ViewPageElementFragment.newInstance(R.mipmap.img_1, "Картинка 1");
        }
    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
        super.destroyItem(container, position, object);

    }
}
