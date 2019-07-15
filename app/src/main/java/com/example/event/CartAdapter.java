package com.example.event;


import android.content.Context;
import android.graphics.Color;
import android.support.annotation.ColorInt;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.TextView;
import com.amulyakhare.textdrawable.TextDrawable;

import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

class CartViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {


    public TextView cartname,price;
    public ImageView count;
   private AdapterView.OnItemClickListener itemClickListener;

    public void setCartname(TextView cartname) {
        this.cartname = cartname;
    }

    public CartViewHolder(@NonNull View itemView) {
        super(itemView);
        cartname = itemView.findViewById(R.id.cartitemname);
        price = itemView.findViewById(R.id.itemprice);
        count = itemView.findViewById(R.id.itemcount);
    }

    @Override
    public void onClick(View v) {

    }
}

public class CartAdapter extends  RecyclerView.Adapter<CartViewHolder>
{
    public CartAdapter(List<Order> listdata, Context context) {
        this.listdata = listdata;
        this.context = context;
    }

    private List<Order>listdata = new ArrayList<>();
    private Context context;



    @NonNull
    @Override
    public CartViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View itemView = inflater.inflate(R.layout.cartlayout,viewGroup,false);
        return  new CartViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull CartViewHolder cartViewHolder, int i) {

        TextDrawable  drawable= TextDrawable.builder()
                .buildRound("" + listdata.get(i).getQuantity(), Color.RED);

        cartViewHolder.count.setImageDrawable(drawable);

        Locale locale = new Locale("en", "US");
        NumberFormat fmt= NumberFormat.getCurrencyInstance(locale);
        int price =(Integer.parseInt(listdata.get(i).getPrice())) * (Integer.parseInt(listdata.get(i).getQuantity()));
        cartViewHolder.price.setText(fmt.format(price));
        cartViewHolder.cartname.setText(listdata.get(i).getProductName());
    }

    @Override
    public int getItemCount() {
        return listdata.size();
    }
}
