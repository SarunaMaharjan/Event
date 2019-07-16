package com.example.event;

import android.content.Intent;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import com.firebase.ui.database.*;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.squareup.picasso.Picasso;

public class Furniture extends AppCompatActivity {

    ListView lv;
    FirebaseListAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_furniture);

        ActionBar actionBar = getSupportActionBar();
        actionBar.setTitle("Furnitures");

        //Intent intent = new Intent(this, MainActivity.class);

        lv= (ListView) findViewById(R.id.listview1);

        Query query= FirebaseDatabase . getInstance().getReference().child("Furniture");
        FirebaseListOptions<Model> options = new FirebaseListOptions.Builder<Model>()
                .setLayout(R.layout.descriptionbar)
                .setLifecycleOwner(Furniture.this)
                .setQuery(query, Model.class)
                .build();

        adapter = new FirebaseListAdapter(options) {
            @Override
            protected void populateView(View v, Object model, final int position)
            {

                ImageView img= v.findViewById(R.id.post);
                TextView title = v.findViewById(R.id.title);

                img.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent subfurniture= new Intent(Furniture.this,SubFurniture.class);
                        subfurniture.putExtra("Id",adapter.getRef(position).getKey());
                        startActivity(subfurniture);

                    }
                });

                Model mod= (Model) model;
                title.setText(mod.getTitle().toString());
                Picasso.with(Furniture.this)
                        .load(mod.getImage())
                        .into(img);
            }
        };

        lv.setAdapter(adapter);

    }

    @Override
    protected void onStart() {
        super.onStart();
        adapter.startListening();
    }

    @Override
    protected void onStop() {
        super.onStop();
        adapter.stopListening();
    }

    }

