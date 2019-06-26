package com.example.event;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.*;

public class Decoration extends AppCompatActivity {


    ImageView imageView;
    GridView gridView;
    String[] decorations= {"Ribbon", "Balloon"};
    int[] decorationimages= {R.mipmap.even, R.mipmap.balloon};


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_decoration);
       // Intent intent=new Intent(this,MainActivity.class);


        gridView = findViewById(R.id.gridview);

        CustomAdapter customAdapter = new CustomAdapter ();
        gridView.setAdapter(customAdapter);
       /* gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent1=new Intent(getApplicationContext(),Decorationdesc.class);
            }
        });*/


    }

    private class CustomAdapter extends BaseAdapter
    {

        @Override
        public int getCount() {
            return decorationimages.length;
        }

        @Override
        public Object getItem(int position) {
            return null;
        }

        @Override
        public long getItemId(int position) {
            return 0;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            View view= getLayoutInflater().inflate(R.layout.rowdata, null);
            TextView name = view. findViewById(R.id.desc);
            ImageView image= view.findViewById(R.id.ribbon);

            name.setText(decorations[position]);
            image.setImageResource(decorationimages[position]);

            image.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    startActivity(new Intent(Decoration.this,Decorationdesc.class));
                }
            });

            return view;
        }
    }
}
