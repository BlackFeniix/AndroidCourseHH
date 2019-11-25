package com.hito.nikolay.lesson_4_utkin;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar toolbar = findViewById(R.id.toolbar);
        toolbar.inflateMenu(R.menu.main_menu);

        toolbar.setOnMenuItemClickListener(new Toolbar.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {
                item.setChecked(true);

                if (item.getTitle().equals("Home"))
                {
                    Toast.makeText(MainActivity.this, item.getTitle(), Toast.LENGTH_LONG).show();
                }

                if (item.getTitle().equals("Info menu"))
                {
                    ProgressDialog myProgressDialog = new ProgressDialog(MainActivity.this);
                    myProgressDialog.setMessage("Loading...");
                    myProgressDialog.setCancelable(false);
                    myProgressDialog.setButton(DialogInterface.BUTTON_NEGATIVE, "OK", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            dialog.dismiss();
                        }
                    });
                    myProgressDialog.show();
                }
                return true;
            }
        });

        RecyclerView recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setHasFixedSize(true);

        //recyclerView.addItemDecoration(new DividerItemDecoration(this, DividerItemDecoration.VERTICAL));

        GridLayoutManager layoutManager = new GridLayoutManager(this, 2);
        recyclerView.setLayoutManager(layoutManager);

        /*DividerItemDecoration itemDecorator = new DividerItemDecoration(recyclerView.getContext(), DividerItemDecoration.VERTICAL);
        itemDecorator.setDrawable(recyclerView.getDrawable(getContext(), R.drawable.shape_divider));
        itemDecorator.setDrawable(,R.drawable.shape_divider);
        itemDecorator.getItemOffsets();*/

        /*DividerItemDecoration mDividerItemDecoration = new DividerItemDecoration(recyclerView.getContext(),
                layoutManager.getOrientation());
        recyclerView.addItemDecoration(mDividerItemDecoration);*/

        BaseInfo[] myDataset = new BaseInfo[10];

        myDataset[0]= new DetailInfo("Квитанции",R.drawable.ic_bill, "- 40 080,55 \u20BD", true);
        myDataset[1]= new DetailInfo("Счетчики",R.drawable.ic_counter, "Подайте показания", true);
        myDataset[2]= new DetailInfo("Рассрочка",R.drawable.ic_installment, "Сл. платеж 25.02.2018", false);
        myDataset[3]= new DetailInfo("Страхование",R.drawable.ic_insurance, "Полис до 12.01.2019", false);
        myDataset[4]= new DetailInfo("Интернет и ТВ",R.drawable.ic_tv, "Баланс 350 \u20BD", false);
        myDataset[5]= new DetailInfo("Домофон",R.drawable.ic_homephone, "Подключен", false);
        myDataset[6]= new DetailInfo("Охрана",R.drawable.ic_guard, "Нет", false);
        final int lastElement = 6;

        myDataset[7] = new BaseInfo("Контакты УК и служб", R.drawable.ic_uk_contacts);
        myDataset[8] = new BaseInfo("Мои заявки", R.drawable.ic_request);
        myDataset[9] = new BaseInfo("Памятка жителя А101", R.drawable.ic_about);

        Adapter mAdapter = new Adapter(myDataset);
        recyclerView.setAdapter(mAdapter);

        layoutManager.setSpanSizeLookup(new GridLayoutManager.SpanSizeLookup() {
            @Override
            public int getSpanSize(int position) {
                if (position>(lastElement-1))
                    return 2;
                else
                    return 1;
            }
        });
    }
}
