package com.example.event;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.squareup.picasso.Picasso;

public class Furniture extends AppCompatActivity {

    private RecyclerView recyclerView;
    private DatabaseReference databaseReference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_furniture);

       Intent intent=new Intent(this,MainActivity.class);

        databaseReference= FirebaseDatabase.getInstance().getReference().child("Furniture");
        databaseReference.keepSynced(true);

        recyclerView=(RecyclerView) findViewById(R.id.myrecycleview);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));


    }

    @Override
    protected void onStart() {
        super.onStart();

        FirebaseRecyclerAdapter<Model,ViewHolder> firebaseRecyclerAdapter=
                new FirebaseRecyclerAdapter<Model, ViewHolder>(Model.class,R.layout.subfurniture,ViewHolder.class,databaseReference) {
                    @Override
                    protected void populateViewHolder(ViewHolder viewHolder, Model model, int position)
                    {
                        viewHolder.setTitle(model.getTitle());
                        viewHolder.setImage(getApplicationContext(),model.getImage());
                    }
                };
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
