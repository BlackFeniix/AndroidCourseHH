package com.hito.nikolay.lesson_6_utkin;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import androidx.fragment.app.Fragment;

public class SecondFragment extends Fragment {

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_second, container, false);

        Toolbar toolbar = rootView.findViewById(R.id.toolbar);
        toolbar.setTitle(R.string.item_two);
        toolbar.inflateMenu(R.menu.menu_toolbar_two);

        final RecyclerView recyclerView = rootView.findViewById(R.id.recyclerView);
        final LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getActivity(), LinearLayoutManager.VERTICAL, false);
        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.addItemDecoration(new HouseCounterItemDecorator(getResources().getDimensionPixelSize(R.dimen.gridSpacing), getRecyclerViewData().length));

        final RecyclerAdapter mAdapter = new RecyclerAdapter(getRecyclerViewData());
        recyclerView.setAdapter(mAdapter);

        return  rootView;
    }

    public HouseCounter[] getRecyclerViewData()
    {
        return new HouseCounter[] {
                new HouseCounter("Горячая вода","54656553", "Необходимо подать показания до 25.03.18", R.mipmap.ic_water_hot, true),
                new HouseCounter("Холодная вода","54656553", "Необходимо подать показания до 25.03.18", R.mipmap.ic_water_cold, true),
                new HouseCounter("Горячая вода","54656553", "Необходимо подать показания до 25.03.18", R.mipmap.ic_water_hot, false),
                new HouseElectricity("Электроэнергия","54656553", "Показания сданы 16.02.18 и будут учтены при следующем расчете 25.02.18", R.mipmap.ic_electro_copy, false)
        };
    }
}

