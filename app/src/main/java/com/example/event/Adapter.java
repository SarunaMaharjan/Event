package com.example.event;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v4.view.PagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class Adapter extends PagerAdapter {

    private List<Models> models;
    private LayoutInflater layoutInflater;
    private Context context;

    public Adapter(List<Models> models, Context context) {
        this.models = models;
        this.context = context;
    }

    @Override
    public int getCount() {
        return models.size();
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object o) {
        return view.equals(o);
    }

    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {
        layoutInflater = LayoutInflater.from(context);
        View view = layoutInflater.inflate(R.layout.item,container,false);

        ImageView imageView;
        TextView title,descrip;

        imageView= view.findViewById(R.id.image);
        title= view.findViewById(R.id.title);
        descrip = view.findViewById(R.id.descrip);
        imageView.setImageResource(models.get(position).getIm());
        title.setText(models.get(position).getTi());
        descrip.setText(models.get(position).getDes());

        container.addView(view,0);
        return view;
    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
        container.removeView((View)object);
    }
}
