package com.example.expensemanagerpro;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class otp extends AppCompatActivity {
    ImageView otpcancelbtn;
    Button verifybtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_otp);
        otpcancelbtn = findViewById(R.id.otpcancelbtn);
        verifybtn = findViewById(R.id.optverifybtn);


        otpcancelbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(otp.this,Login.class);
                startActivity(intent);
            }
        });

        verifybtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(otp.this,Dashboard.class);
                startActivity(intent);
            }
        });
    }
}