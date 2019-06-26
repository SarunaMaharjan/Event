/*package com.example.event;

import android.content.Intent;
import android.graphics.ColorSpace;
import android.support.annotation.NonNull;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.*;
import com.firebase.client.Firebase;
import com.google.firebase.database.*;
import com.squareup.picasso.Picasso;

public class Decorationdesc extends AppCompatActivity implements AdapterView.OnItemSelectedListener {


    TextView deconame,decoprice,decodesc;
    ImageView decoimage;
    CollapsingToolbarLayout collapsingToolbarLayout;
    FloatingActionButton btnCart;
    ImageButton imb;

    String Decorationid="";

    FirebaseDatabase database;
    DatabaseReference ref;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_decorationdesc);



        Intent intent=new Intent(this, Decoration.class);

        Spinner spinner=findViewById(R.id.numberbutton);
        ArrayAdapter<CharSequence> arrayAdapter= ArrayAdapter.createFromResource(this,R.array.Quantity,android.R.layout.simple_spinner_item);
        arrayAdapter.setDropDownViewResource(android.R.layout.simple_dropdown_item_1line);
        spinner.setAdapter(arrayAdapter);
        spinner.setOnItemSelectedListener(this);

        database=FirebaseDatabase.getInstance();
        ref=database.getReference("Furniture");

        btnCart=(FloatingActionButton) findViewById(R.id.btncart);


        decodesc= findViewById(R.id.description);
        deconame=findViewById(R.id.decorationname);
        decoimage=findViewById(R.id.imag_dec);
        decoprice=findViewById(R.id.price);
        imb=findViewById(R.id.cartt);

        collapsingToolbarLayout= (CollapsingToolbarLayout) findViewById(R.id.collapsing);
        collapsingToolbarLayout.setExpandedTitleTextAppearance(R.style.ExpandedAppbar);
        collapsingToolbarLayout.setCollapsedTitleTextAppearance(R.style.CollapsedAppbar);




        if(getIntent() != null)
            Decorationid = getIntent().getStringExtra("decorationId");
       else
       // {getDecorationDetail(Decorationid);}



        imb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(Decorationdesc.this,"Item Added",Toast.LENGTH_LONG).show();
            }
        });
    }



   /* private void getDecorationDetail(String decorationid) {
        final Model model = new Model();
        ref.child(Decorationid).addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                Decoration decoration = dataSnapshot.getValue(Decoration.class);

                //set image
                Picasso.with(getBaseContext()).load(model.getImage())
                        .into(decoimage);
               collapsingToolbarLayout.setTitle(model.getName());
               decoprice.setText(model.getPrice());
               decodesc.setText(model.getDescription());
               deconame.setText(model.getName());
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id)
    {
        String text= parent.getItemAtPosition(position).toString();
        Toast.makeText(parent.getContext(),text,Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
}*/
