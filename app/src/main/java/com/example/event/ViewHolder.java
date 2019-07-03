package com.example.event;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.squareup.picasso.Picasso;

public class ViewHolder extends RecyclerView.ViewHolder {

    View mView;

    public ViewHolder(@NonNull View itemView) {
        super(itemView);

        mView = itemView ;
    }

    public  void setDeatils(Context ctx, String description,String image)
    {
        TextView mDesc = mView.findViewById(R.id.desc) ;
        ImageView mimage = mView.findViewById(R.id.post);

        mDesc.setText(description);
        Picasso.with(ctx).load(image).into(mimage);
    }
}
