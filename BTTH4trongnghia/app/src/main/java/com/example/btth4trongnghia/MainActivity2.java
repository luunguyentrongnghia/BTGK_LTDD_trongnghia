package com.example.btth4trongnghia;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity2 extends AppCompatActivity {
    Button btnthoatprofile;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        btnthoatprofile=(Button) findViewById(R.id.buttonthoatprofile);
        ControlButton();
        BottomNavigationView navigationView = findViewById(R.id.bottom_nav);
        navigationView.setSelectedItemId(R.id.action_profile);
        navigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()){
                    case R.id.action_home:
                        Toast.makeText(MainActivity2.this, "Home", Toast.LENGTH_SHORT).show();
                        Intent intent3 = new Intent(MainActivity2.this, MainActivity5.class);
                        startActivity(intent3);
                        overridePendingTransition(0,0);
                        break;

                    case R.id.action_list:
                        Toast.makeText(MainActivity2.this, "List", Toast.LENGTH_SHORT).show();
                        Intent intent = new Intent(MainActivity2.this, MainActivity6.class);
                        startActivity(intent);
                        overridePendingTransition(0,0);
                        break;

                    case R.id.action_profile:
                        Toast.makeText(MainActivity2.this, "Profile", Toast.LENGTH_SHORT).show();;
                        overridePendingTransition(0,0);
                        break;
                }
                return true;
            }
        });
    }
    private void ControlButton(){
        btnthoatprofile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity2.this, MainActivity.class);
                startActivity(intent);
            }
        });
    }
}