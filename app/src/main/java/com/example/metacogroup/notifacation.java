package com.example.metacogroup;

import android.os.Bundle;
import android.view.Menu;
import android.widget.Spinner;
import android.widget.Toast;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;


import java.util.ArrayList;

public class notifacation extends AppCompatActivity {
    ArrayList<saeidian_klid> recycleview_arraylist ;
    ArrayList<saeidian_klid2> saeidian_spinner_array;
    spinneradapter adapter_spinner;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.recycleview);
        initList2();
        Spinner spinner = (Spinner) findViewById(R.id.spinner_list);
        adapter_spinner = new spinneradapter(this, saeidian_spinner_array);
        spinner.setAdapter(adapter_spinner);

        initList();
        initList2();


        recycle_adapter adapter_saeidian = new recycle_adapter(recycleview_arraylist);
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
        if(item.getItemId()==R.id.exit_menu) {
            Toast.makeText(getApplicationContext(), "صفحه خروج اجباری :)", Toast.LENGTH_LONG).show();

        }

        return super.onOptionsItemSelected(item);
    }
    private void initList2()
    {

        saeidian_spinner_array =new ArrayList<>();
        saeidian_klid2 klid=new saeidian_klid2();
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
        saeidian_klid klid1=new saeidian_klid();
        klid1.name="اسم : زهرا" ;
        klid1.room="اتاق : 192" ;
        klid1.family= "فامیلی : عالمی" ;
        klid1.vaziat="وضعیت : پرستار";
        klid1.danger=(R.drawable.danger);
        klid1.profile=(R.drawable.user);
        recycleview_arraylist.add(klid1);

        saeidian_klid klid2 = new saeidian_klid();
        klid2.name="اسم : آرزو" ;
        klid2.room="اتاق : 187" ;
        klid2.family= "فامیلی : بهبودی" ;
        klid2.vaziat="وضعیت : پرستار";
        klid2.danger=(R.drawable.danger);
        klid2.profile=(R.drawable.user);
        recycleview_arraylist.add(klid2);

        saeidian_klid klid3 = new saeidian_klid();
        klid3.name="اسم : ارغوان" ;
        klid3.room="اتاق : 192" ;
        klid3.family= "فامیلی : امامی" ;
        klid3.vaziat="وضعیت : سرپرستار";

        klid3.profile=(R.drawable.user);
        recycleview_arraylist.add(klid3);

        saeidian_klid klid4 = new saeidian_klid();
        klid4.name="اسم : پونه" ;
        klid4.room="اتاق : 165" ;
        klid4.family= "فامیلی : برومند" ;
        klid4.vaziat="وضعیت : پرستار";

        klid4.profile=(R.drawable.user);
        recycleview_arraylist.add(klid4);

        saeidian_klid klid5 = new saeidian_klid();
        klid5.name="اسم : ثنا" ;
        klid5.room="اتاق : 11" ;
        klid5.family= "فامیلی : جعفری" ;
        klid5.vaziat="وضعیت : سر پرستار";

        klid5.profile=(R.drawable.user);
        recycleview_arraylist.add(klid5);


    }
    public void menuu(){

    }

}