package com.example.event;

import android.animation.ArgbEvaluator;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.Button;

import java.util.ArrayList;
import java.util.List;

public class Front_slide extends AppCompatActivity {
     private ViewPager viewPager;
    Adapter adapter;
    List<Models> models;
    Integer[] colors = null;
    ArgbEvaluator argbEvaluator = new ArgbEvaluator();
    Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_front_slide);

        viewPager = findViewById(R.id.viewPager);
        button = findViewById(R.id.btnlogin);

        models = new ArrayList<>();
        models.add(new Models(R.drawable.flower,"Every flower is a soul blossoming in nature. ","FLOWERS"));
        models.add(new Models(R.drawable.p1,"Everybody has a little bit of the sun and moon in them.","LIGHTS"));
        models.add(new Models(R.drawable.b1,"Colorful balloons are able to lighten up the mood","BALLOONS"));


        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               startActivity(new Intent(Front_slide.this,Login.class));
            }
        });

        adapter = new Adapter(models,this);
        viewPager.setAdapter(adapter);
        viewPager.setPadding(130,0,130,0);

        Integer[] colors_temp = {
                getResources().getColor(R.color.color1),
                getResources().getColor(R.color.orange),
                getResources().getColor(R.color.color2)

        };

        colors = colors_temp;

        viewPager.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int i, float v, int i1) {
                if(i < (adapter.getCount() -1)  && i<(colors.length) -1){
                    viewPager.setBackgroundColor((Integer) argbEvaluator.evaluate(
                            v,
                            colors[i],colors[i + 1]
                            )
                    );
                }else{
                    viewPager.setBackgroundColor(colors[colors.length - 1]);
                }
            }

            @Override
            public void onPageSelected(int i) {

            }

            @Override
            public void onPageScrollStateChanged(int i) {

            }
        });
    }
}
