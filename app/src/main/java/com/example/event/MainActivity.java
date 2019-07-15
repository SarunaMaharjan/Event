package com.example.event;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.Window;
import android.widget.ImageButton;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private ImageButton i1,i2,i3,i4,i5,i6,i7,i8;
    private ImageButton home,account;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        this.requestWindowFeature(Window.FEATURE_NO_TITLE);

        i1=findViewById(R.id.i1);
        i2=findViewById(R.id.i2);
        i3=findViewById(R.id.i3);
        i4=findViewById(R.id.i4);
        i5=findViewById(R.id.i5);
        i6=findViewById(R.id.i6);
        i7=findViewById(R.id.i7);
        i8=findViewById(R.id.i8);





        i1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
              startActivity(new Intent(MainActivity.this, Food.class));
            }
        });

        i2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this,Decoration.class));
            }
        });

        i3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this,Furniture.class));
            }
        });

        i4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this,Games.class));
            }
        });

        i5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this,Lights.class));
            }
        });

        i6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this,Projector.class));
            }
        });

        i7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this,Sound.class));
            }
        });

        i8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this,Tent.class));
            }
        });







    }


    @Override
    public void onClick(View v) {

    }
}
