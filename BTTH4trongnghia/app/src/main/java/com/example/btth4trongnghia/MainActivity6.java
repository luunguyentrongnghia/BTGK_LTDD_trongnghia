package com.example.btth4trongnghia;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.util.ArrayList;

public class MainActivity6 extends AppCompatActivity {
    int image[]={R.drawable.oto1,R.drawable.oto2,R.drawable.oto3,R.drawable.oto4};
    String name[] = {"xe 1","xe 2","xe 3","xe 4"};
    ArrayList<Oto> myList;
    MyArrayAdapter myadapter;
    ListView lv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main6);
        lv = findViewById(R.id.lv);
        myList = new ArrayList<>();
        for (int i = 0;i<name.length;i++){
            myList.add(new Oto(image[i],name[i]));
        }
        myadapter = new MyArrayAdapter(MainActivity6.this,R.layout.layout_item,myList);
        lv.setAdapter(myadapter);
        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent myintent = new Intent(MainActivity6.this,supActivity.class);
                myintent.putExtra("name",name[i]);
                myintent.putExtra("img",image[i]);
                startActivity(myintent);
            }
        });
        BottomNavigationView navigationView = findViewById(R.id.bottom_nav);
        navigationView.setSelectedItemId(R.id.action_list);
        navigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()){
                    case R.id.action_home:
                        Toast.makeText(MainActivity6.this, "Home", Toast.LENGTH_SHORT).show();
                        Intent intent3 = new Intent(MainActivity6.this, MainActivity5.class);
                        startActivity(intent3);
                        overridePendingTransition(0,0);
                        break;

                    case R.id.action_list:
                        Toast.makeText(MainActivity6.this, "List", Toast.LENGTH_SHORT).show();
                        overridePendingTransition(0,0);
                        break;

                    case R.id.action_profile:
                        Toast.makeText(MainActivity6.this, "Profile", Toast.LENGTH_SHORT).show();
                        Intent intent = new Intent(MainActivity6.this, MainActivity2.class);
                        startActivity(intent);
                        overridePendingTransition(0,0);
                        break;
                }
                return true;
            }
        });
    }
}
