package com.example.event;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.firebase.ui.database.SnapshotParser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.squareup.picasso.Picasso;

public class Furniture extends AppCompatActivity {

    private RecyclerView recyclerView;
    private DatabaseReference databaseReference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_furniture);

        ActionBar actionBar = getSupportActionBar();
        actionBar.setTitle("Furnitures");

       Intent intent=new Intent(this,MainActivity.class);

        databaseReference= FirebaseDatabase.getInstance().getReference().child("Furniture");
        databaseReference.keepSynced(true);

        recyclerView=(RecyclerView) findViewById(R.id.myrecycleview);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        fetch();

    }


    private void fetch() {
        Query query = FirebaseDatabase.getInstance()
                .getReference()
                .child("Furniture");

        FirebaseRecyclerOptions<Model> options =
                new FirebaseRecyclerOptions.Builder<Model>()
                        .setQuery(query, new SnapshotParser<Model>() {
                            @NonNull
                            @Override
                            public Model parseSnapshot(@NonNull DataSnapshot snapshot) {
                                return new Model(snapshot.child("Title").getValue().toString(),
                                        snapshot.child("Image").getValue().toString());

                            }
                        })
                        .build();

       FirebaseRecyclerAdapter adapter = new FirebaseRecyclerAdapter<Model, ViewHolder>(options) {
            @Override
            public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
                View view = LayoutInflater.from(parent.getContext())
                        .inflate(R.layout.subfurniture, parent, false);

                return new ViewHolder(view);
            }


            @Override
            protected void onBindViewHolder(ViewHolder holder, final int position, Model model) {
                holder.setTitle(model.getTitle());
                holder.setImage(getApplicationContext(),model.getImage());


            }

        };
        recyclerView.setAdapter(adapter);


    }




    public class ViewHolder extends RecyclerView.ViewHolder {

        public TextView txtTitle;
        public ImageView post;

        public ViewHolder(View itemView) {
            super(itemView);
            txtTitle = itemView.findViewById(R.id.title);
            post = itemView.findViewById(R.id.post);
        }

        public void setTitle(String Title) {
            txtTitle.setText(Title);
        }


        public void setImage(Context ctx,String Image) {
            Picasso.with(ctx).load(Image).into(post);
        }
    }
}
