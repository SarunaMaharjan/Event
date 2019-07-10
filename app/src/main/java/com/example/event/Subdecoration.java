package com.example.event;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.view.View;
import android.widget.*;
import com.firebase.ui.database.FirebaseListAdapter;
import com.firebase.ui.database.FirebaseListOptions;
import com.google.firebase.database.*;
import com.squareup.picasso.Picasso;

public class Subdecoration extends AppCompatActivity  {


    ImageView img;
    Button cart;
    TextView price,description,delivery;

    String foodId="";
    FirebaseDatabase database;
    DatabaseReference foods;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_subdecoration);

        ActionBar actionBar = getSupportActionBar();
        actionBar.setTitle("Details");

        database = FirebaseDatabase.getInstance();
        foods = database.getReference("Decoration");

        img= findViewById(R.id.post);
        price = findViewById(R.id.price);
        description = findViewById(R.id.description);
        delivery = findViewById(R.id.deli);
        cart = findViewById(R.id.cart);


        if (getIntent() != null)
            foodId = getIntent().getStringExtra("Id");
        if(!foodId.isEmpty())
        {
            getDetailFood(foodId);
        }

        cart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(),"ITEM ADDED TO CART",Toast.LENGTH_LONG).show();
            }
        });
    }


    private void getDetailFood(String foodId)
    {

        foods.child(foodId).addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                Model food =dataSnapshot.getValue(Model.class);

                Picasso.with(getBaseContext()).load(food.getImage()).into(img);
                price.setText("Rs. " + food.getPrice());
                description.setText("Detail:  " + food.getDescription());
                delivery.setText("Delivery Information : " + food.getDelivery());

            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
    }
}

