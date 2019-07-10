package com.example.event;

import android.support.annotation.NonNull;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import com.google.firebase.database.*;
import com.squareup.picasso.Picasso;

public class SubFood extends AppCompatActivity {

    ImageView img;
    Button cart;
    TextView price,description,delivery;

    String foodsId="";
    FirebaseDatabase database;
    DatabaseReference food;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sub_food);

        ActionBar actionBar = getSupportActionBar();
        actionBar.setTitle("Details");



        database = FirebaseDatabase.getInstance();
        food = database.getReference("Food");

        img= findViewById(R.id.post);
        price = findViewById(R.id.price);
        description = findViewById(R.id.description);
        delivery = findViewById(R.id.deli);
        cart = findViewById(R.id.cart);


        if (getIntent() != null)
            foodsId = getIntent().getStringExtra("Id");
        if(!foodsId.isEmpty())
        {
            getDetailFoods(foodsId);
        }

        cart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(),"ITEM ADDED TO CART",Toast.LENGTH_LONG).show();
            }
        });
    }


    private void getDetailFoods(String foodsId)
    {

        food.child(foodsId).addValueEventListener(new ValueEventListener() {
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
