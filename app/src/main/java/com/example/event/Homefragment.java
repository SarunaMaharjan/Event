package com.example.event;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;


public class Homefragment extends Fragment implements View.OnClickListener{


    private ImageButton i1,i2,i3,i4,i5,i6,i7,i8;
    private ImageButton home,account;

    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container ,@Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_home, container, false);
        i1 = view.findViewById(R.id.i1);
        i2 = view.findViewById(R.id.i2);
        i3 = view.findViewById(R.id.i3);
        i4 = view.findViewById(R.id.i4);
        i5 = view.findViewById(R.id.i5);
        i6 = view.findViewById(R.id.i6);
        i7 = view.findViewById(R.id.i7);
        i8 = view.findViewById(R.id.i8);
        //
        //return inflater.inflate(R.layout.fragment_home,container,false);


        i1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getActivity(), Food.class));
            }
        });


        i2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(),Decoration.class);

                startActivity(intent);
            }
        });

        i3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getActivity(),Furniture.class));
            }
        });

        i4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getActivity(),Games.class));
            }
        });

        i5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getActivity(),Lights.class));
            }
        });

        i6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getActivity(),Projector.class));
            }
        });

        i7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getActivity(),Sound.class));
            }
        });

        i8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getActivity(),Tent.class));
            }
        });



        return view;

    }




    @Override
    public void onClick(View v) {

    }
}
