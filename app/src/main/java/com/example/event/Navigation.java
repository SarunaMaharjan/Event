package com.example.event;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageButton;

public class Navigation extends AppCompatActivity implements View.OnClickListener{


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_navigation);


        BottomNavigationView navigationView = findViewById(R.id.botton_nav);
        FrameLayout frameLayout = findViewById(R.id.frame);

        final Homefragment homefragment = new Homefragment();
        final CartFragment cartFragment = new CartFragment();
        final ProfileFragment profileFragment = new ProfileFragment();
        setFragment(homefragment);
        navigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
         @Override
         public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
             int id = menuItem.getItemId();
             if (id == R.id.home){
                 setFragment(homefragment);
             return  true;}
                 else if (id == R.id.cart) {
                 setFragment(cartFragment);
                 return true;
             }
                    else if(id ==R.id.pro) {
                 setFragment(profileFragment);
                 return true;
             }

                    return false;
         }
     });


     navigationView.setSelectedItemId(R.id.home);

    }

    private  void setFragment(Fragment fragment){
        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.frame,fragment);
        fragmentTransaction.commit();
    }

    @Override
    public void onClick(View v) {

    }
}
