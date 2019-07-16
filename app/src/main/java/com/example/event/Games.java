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


import static com.example.event.R.*;

public class Games extends AppCompatActivity {

    ListView lv;
    FirebaseListAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(layout.activity_games);

        //Intent intent=new Intent(this,MainActivity.class);

        ActionBar actionBar = getSupportActionBar();
        actionBar.setTitle("Games");


        lv= (ListView) findViewById(id.listview);

       Query query= FirebaseDatabase . getInstance().getReference().child("Games");
        FirebaseListOptions<Model> options = new FirebaseListOptions.Builder<Model>()
                .setLayout(layout.descriptionbar)
                .setLifecycleOwner(Games.this)
                .setQuery(query, Model.class)
                .build();

        adapter = new FirebaseListAdapter(options) {
            @Override
            protected void populateView(View v, Object model, final int position)
            {

                ImageView img= v.findViewById(id.post);
                TextView title = v.findViewById(R.id.title);

                img.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent subdecoration= new Intent(Games.this,SubGame.class);
                        subdecoration.putExtra("Id",adapter.getRef(position).getKey());
                        startActivity(subdecoration);

                    }
                });


                Model mod= (Model) model;
                title.setText(mod.getTitle().toString());
                Picasso.with(Games.this)
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
