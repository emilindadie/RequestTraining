package com.example.emili.udacity;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


import java.util.ArrayList;
import java.util.List;


/**
 * Created by emili on 12/07/2017.
 */

public class ContactAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    List<Contact> data;
    Context context;
    LayoutInflater layoutInflater;
    int taille;
    public ContactAdapter(Context context, List<Contact> data){
        this.data = data;
        this.context = context;
        layoutInflater = LayoutInflater.from(context);
    }



    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = layoutInflater.inflate(R.layout.contact, parent, false);

        return new MyHolder(view);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        MyHolder myHolder = (MyHolder) holder;
         Contact contact = data.get(position);
        myHolder.nom.setText(contact.getNom());
        myHolder.email.setText(contact.getEmail());
        myHolder.genre.setText(contact.getGenre());

    }

    @Override
    public int getItemCount() {
        taille = data.size();
        return taille;
    }

    class MyHolder extends RecyclerView.ViewHolder{
        TextView nom;
        TextView email;
        TextView genre;

        public MyHolder(View itemView) {
            super(itemView);

            nom = (TextView) itemView.findViewById(R.id.nom);
            email = (TextView) itemView.findViewById(R.id.email);
            genre = (TextView) itemView.findViewById(R.id.genre);
        }
    }


    public void clear(List<Contact> data){
        data.clear();
    }


    public void ajouterTous(List<Contact> data){
        this.data = data;
    }



}

