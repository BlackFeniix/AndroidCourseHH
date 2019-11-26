package com.hito.nikolay.lesson_4_utkin;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import com.google.android.material.snackbar.Snackbar;

public class MainActivity extends AppCompatActivity {
    public static final int SPAN_SIZE_1 = 1;
    public static final int SPAN_SIZE_2 = 2;

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

        final RecyclerView recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setHasFixedSize(true);

        final GridLayoutManager layoutManager = new GridLayoutManager(this, 2);
        recyclerView.setLayoutManager(layoutManager);

        final BaseInfo[] myDataset = new BaseInfo[]{
                new DetailInfo("Квитанции",R.drawable.ic_bill, "- 40 080,55 \u20BD", true),
                new DetailInfo("Счетчики",R.drawable.ic_counter, "Подайте показания", true),
                new DetailInfo("Рассрочка",R.drawable.ic_installment, "Сл. платеж 25.02.2018", false),
                new DetailInfo("Страхование",R.drawable.ic_insurance, "Полис до 12.01.2019", false),
                new DetailInfo("Интернет и ТВ",R.drawable.ic_tv, "Баланс 350 \u20BD", false),
                new DetailInfo("Домофон",R.drawable.ic_homephone, "Подключен", false),
                new DetailInfo("Охрана",R.drawable.ic_guard, "Нет", false),

                new DetailInfo("Квитанции",R.drawable.ic_bill, "- 40 080,55 \u20BD", true),
                new DetailInfo("Счетчики",R.drawable.ic_counter, "Подайте показания", true),
                new DetailInfo("Рассрочка",R.drawable.ic_installment, "Сл. платеж 25.02.2018", false),

                new BaseInfo("Контакты УК и служб", R.drawable.ic_uk_contacts),
                new BaseInfo("Мои заявки", R.drawable.ic_request),
                new BaseInfo("Памятка жителя А101", R.drawable.ic_about)
        };

        final Adapter mAdapter = new Adapter(myDataset);
        mAdapter.setCustomItemClickListener(new Adapter.CustomItemClickListener() {
            @Override
            public void onItemClick(View view, int position) {
                Snackbar.make(view, myDataset[position].title, Snackbar.LENGTH_LONG).show();
            }
        });
        recyclerView.setAdapter(mAdapter);


        float scaleRatio = getResources().getDisplayMetrics().density;
        float dimenPix = getResources().getDimension(R.dimen.item_offset);
        int dimenOrginal =(int)(dimenPix/scaleRatio);

        InfoItemGridSpacingDecorator myItemDecoration = new InfoItemGridSpacingDecorator(myDataset.length,dimenOrginal );
        recyclerView.addItemDecoration(myItemDecoration);

        layoutManager.setSpanSizeLookup(new GridLayoutManager.SpanSizeLookup() {
            @Override
            public int getSpanSize(int position) {
                if (mAdapter.getItemViewType(position) == 1)
                    return SPAN_SIZE_2;
                else
                    return SPAN_SIZE_1;
            }
        });
    }
}
