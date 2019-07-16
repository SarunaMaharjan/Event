package com.example.event;

import android.content.Intent;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import com.firebase.ui.database.FirebaseListAdapter;
import com.firebase.ui.database.FirebaseListOptions;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.squareup.picasso.Picasso;

public class Projector extends AppCompatActivity {

    ListView lv;
    FirebaseListAdapter adapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_projector);
       // Intent intent=new Intent(this,Homefragment.class);

        ActionBar actionBar = getSupportActionBar();
        actionBar.setTitle("Decoration");

        lv= (ListView) findViewById(R.id.listview1);

        Query query= FirebaseDatabase. getInstance().getReference().child("Projector");
        FirebaseListOptions<Model> options = new FirebaseListOptions.Builder<Model>()
                .setLayout(R.layout.descriptionbar)
                .setLifecycleOwner(Projector.this)
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
                        Intent subdecoration= new Intent(Projector.this,SubProjector.class);
                        subdecoration.putExtra("Id",adapter.getRef(position).getKey());
                        startActivity(subdecoration);

                    }
                });

                Model mod= (Model) model;
                title.setText(mod.getTitle().toString());
                Picasso.with(Projector.this)
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

