package com.hito.nikolay.lesson_6_utkin;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

public class ThirdFragment extends Fragment {
    private final static String SHOW_BANNER = "Показать баннер";
    private final static String HIDE_BANNER = "Скрыть баннер";

    private Fragment currentFragment = null;
    private FragmentTransaction ft;
    private FragmentManager myFragmentManager;
    private boolean isShowButton = false;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_third, container, false);

        Toolbar toolbar = rootView.findViewById(R.id.toolbar);
        toolbar.setTitle(R.string.item_third);

        myFragmentManager = getActivity().getSupportFragmentManager();
        final Button buttonShowViewPager = rootView.findViewById(R.id.buttonShowViewPager);
        buttonShowViewPager.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (isShowButton) {
                    buttonShowViewPager.setText(SHOW_BANNER);
                    isShowButton = false;

                    ft = myFragmentManager.beginTransaction();
                    ft.remove(currentFragment);
                    ft.commit();

                } else {
                    buttonShowViewPager.setText(HIDE_BANNER);
                    isShowButton = true;

                    currentFragment = new ViewPagerMainFragment();
                    ft = myFragmentManager.beginTransaction();
                    ft.add(R.id.frameLayoutThirdFragment, currentFragment);
                    ft.commit();
                }
            }
        });
        return rootView;
    }
}
