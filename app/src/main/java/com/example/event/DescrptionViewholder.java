package com.example.event;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class DescrptionViewholder extends ViewHolder implements View.OnClickListener
{
   View view;
   TextView des,name,price;
   ImageView img;

    public DescrptionViewholder(@NonNull View itemView) {
        super(itemView);

        des=itemView.findViewById(R.id.description);
        name=itemView.findViewById(R.id.decorationname);
        price=itemView.findViewById(R.id.price);
        img=itemView.findViewById(R.id.imag_dec);

itemView.setOnClickListener(this);


    }

    @Override
    public void onClick(View v) {


    }
}
