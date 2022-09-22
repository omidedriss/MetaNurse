package com.example.metacogroup;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.Menu;
import android.widget.Spinner;
import android.widget.Toast;
import android.view.MenuItem;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;


import java.util.ArrayList;

public class NursePanelRecycle extends AppCompatActivity {
    ArrayList<NursepPanelRecycleClass> recycleview_arraylist ;
    ArrayList<NursePanelSpinnerClass> saeidian_spinner_array;
    NursePanelSpinnerAdapter adapter_spinner;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.recycleview);
        initList2();
        this.setTitle("لیست بیماران");

        Spinner spinner = (Spinner) findViewById(R.id.spinner_list);
        adapter_spinner = new NursePanelSpinnerAdapter(this, saeidian_spinner_array);
        spinner.setAdapter(adapter_spinner);

        initList();
        initList2();


        NursePanelRecycleAdapter adapter_saeidian = new NursePanelRecycleAdapter(recycleview_arraylist,NursePanelRecycle.this);
        RecyclerView shayan_listview = (RecyclerView) findViewById(R.id.recycle_list);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        shayan_listview.setLayoutManager(layoutManager);
        shayan_listview.setAdapter(adapter_saeidian);
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu,menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if (item.getItemId() == R.id.exit_login) {
            Intent i = new Intent(getApplicationContext(), NursePanelLogin.class);
            startActivity(i);
            SharedPreferences shareName = getSharedPreferences("namee", Context.MODE_PRIVATE);
            SharedPreferences.Editor editor = shareName.edit();
            editor.putString("passwordd","noPass");
            editor.commit();

        }
        ExitCustomDialog exitCustomDialog = new ExitCustomDialog(NursePanelRecycle.this);

        if (item.getItemId() == R.id.exit_menu) {
            exitCustomDialog.show();
        }
        if (item.getItemId() == R.id.ratting) {
            Intent i = new Intent(getApplicationContext(), emtiazdehi.class);
            startActivity(i);


        }

        return super.onOptionsItemSelected(item);
    }
    private void initList2()
    {

        saeidian_spinner_array =new ArrayList<>();
        NursePanelSpinnerClass klid=new NursePanelSpinnerClass();
        klid.name="اسم : حدیث" ;
        klid.family="فامیل : حسینی";
        klid.vaziat=" وضعیت : پرستار" ;
        klid.tedadbimaran= "تعداد بیماران : 20";
        klid.emtiaz=" امتیاز : 4.2" ;
        klid.code_personally="کد پرسنلی : 11167896";
        klid.profile_pic=(R.drawable.phone);
        saeidian_spinner_array.add(klid);


    }
    private void initList()
    {




//        saeidian_klid klids = new saeidian_klid();
        recycleview_arraylist =new ArrayList<>();
        NursepPanelRecycleClass klid1=new NursepPanelRecycleClass();
        klid1.name="اسم : زهرا" ;
        klid1.room="اتاق : 192" ;
        klid1.family= "فامیلی : عالمی" ;
        klid1.vaziat="وضعیت : کما ";
        klid1.danger=(R.drawable.danger);
        klid1.profile=(R.drawable.user);
        recycleview_arraylist.add(klid1);

        NursepPanelRecycleClass klid2 = new NursepPanelRecycleClass();
        klid2.name="اسم : آرزو" ;
        klid2.room="اتاق : 187" ;
        klid2.family= "فامیلی : بهبودی" ;
        klid2.vaziat="وضعیت :ایست قلبی ";
        klid2.danger=(R.drawable.danger);
        klid2.profile=(R.drawable.user);
        recycleview_arraylist.add(klid2);

        NursepPanelRecycleClass klid3 = new NursepPanelRecycleClass();
        klid3.name="اسم : ارغوان" ;
        klid3.room="اتاق : 192" ;
        klid3.family= "فامیلی : امامی" ;
        klid3.vaziat="وضعیت : وخیم ";

        klid3.profile=(R.drawable.user);
        recycleview_arraylist.add(klid3);

        NursepPanelRecycleClass klid4 = new NursepPanelRecycleClass();
        klid4.name="اسم : پونه" ;
        klid4.room="اتاق : 165" ;
        klid4.family= "فامیلی : برومند" ;
        klid4.vaziat="وضعیت : عادی ";

        klid4.profile=(R.drawable.user);
        recycleview_arraylist.add(klid4);

        NursepPanelRecycleClass klid5 = new NursepPanelRecycleClass();
        klid5.name="اسم : ثنا" ;
        klid5.room="اتاق : 11" ;
        klid5.family= "فامیلی : جعفری" ;
        klid5.vaziat="وضعیت : حاد";

        klid5.profile=(R.drawable.user);
        recycleview_arraylist.add(klid5);


    }
    public void menuu(){

    }

}