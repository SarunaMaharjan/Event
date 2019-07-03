package com.example.event;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.ViewGroup;
import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import static com.example.event.R.*;

public class Games extends AppCompatActivity {

    RecyclerView mRecycleview;
    FirebaseDatabase firebaseDatabase;
    DatabaseReference mRef;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(layout.activity_games);

        Intent intent=new Intent(this,MainActivity.class);

        ActionBar actionBar = getSupportActionBar();
        actionBar.setTitle("Games");

        mRecycleview = findViewById(id.recyclerview);

        mRecycleview.setLayoutManager(new LinearLayoutManager(this));

        firebaseDatabase = FirebaseDatabase.getInstance();
        mRef = firebaseDatabase.getReference("Data");

    }

    @Override
    protected void onStart() {
        super.onStart();

        FirebaseRecyclerAdapter<ModelG, ViewHolder> firebaseRecyclerAdapter =
                new FirebaseRecyclerAdapter<ModelG, ViewHolder>(ModelG.class,R. layout.subgame,ViewHolder.class,mRef) {

                    @Override
                    protected void populateViewHolder(ViewHolder viewHolder, ModelG model, int position) {
                        viewHolder.setDeatils(getApplicationContext(),model.getDesription(),model.getImage());
                    }
                    @NonNull
                    @Override
                    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
                        return null;
                    }


                };

        mRecycleview.setAdapter(firebaseRecyclerAdapter);
    }
}
