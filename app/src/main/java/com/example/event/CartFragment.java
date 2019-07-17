package com.example.event;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.app.AlertDialog;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;


public class CartFragment extends Fragment {

    private  TextView price,quantity,totalprice,quan;
    private Button placeorder;
    ImageView img;
    String foodId="";

    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container , @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_cart, container, false);

       /*Intent cartIntent =new Intent(getActivity(),Cart.class);
       startActivity(cartIntent);*/

       price= view.findViewById(R.id.price);
       quan=view.findViewById(R.id.quan);
       totalprice=view.findViewById(R.id.totalprice);
       img=view.findViewById(R.id.post);
       quantity=view.findViewById(R.id.quantity);
       placeorder=view.findViewById(R.id.placeorder);

       placeorder.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v)
           {


               AlertDialog.Builder alertDialog = new AlertDialog.Builder(getActivity());
               alertDialog.setTitle("One more step!!");
               alertDialog.setMessage("Enter your address: ");
               alertDialog.show();

           }
       });






        return view;
    }



}
