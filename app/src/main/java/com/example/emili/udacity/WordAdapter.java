package com.example.emili.udacity;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;
import java.util.zip.Inflater;

/**
 * Created by emili on 18/07/2017.
 */

public class WordAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    List<World> data;
    Context context;
    LayoutInflater layoutInflater;
    int taille;

    public WordAdapter(Context context, List<World> data){

        this.data = data;
        this.context = context;
        layoutInflater = LayoutInflater.from(context);
    }
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view = layoutInflater.inflate(R.layout.list_item, parent, false);
        return new MyHolder(view);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {

        MyHolder myHolder = (MyHolder) holder;
        World world = data.get(position);

        myHolder.firstString.setText(world.getFirstString());
        myHolder.secondString.setText(world.getSecondString());

        if(world.hasImage()){
            myHolder.imageView.setImageResource(world.getImageRousourceId());
            myHolder.imageView.setImageResource(View.VISIBLE);
        }
        else {

            myHolder.imageView.setImageResource(View.GONE);
        }
    }

    @Override
    public int getItemCount() {
        taille = data.size();

        return taille;
    }

    class MyHolder extends RecyclerView.ViewHolder{
        TextView firstString;
        TextView secondString;
        ImageView imageView;

        public MyHolder(View itemView) {
            super(itemView);

            firstString = (TextView) itemView.findViewById(R.id.firstString);
            secondString = (TextView) itemView.findViewById(R.id.secondString);
            imageView = (ImageView) itemView.findViewById(R.id.image);

        }
    }
}
