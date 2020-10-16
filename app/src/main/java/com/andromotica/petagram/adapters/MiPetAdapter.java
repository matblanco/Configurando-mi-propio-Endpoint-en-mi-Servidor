package com.andromotica.petagram.adapters;

import android.app.Activity;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.andromotica.petagram.R;
import com.andromotica.petagram.pojo.MiPet;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class MiPetAdapter extends RecyclerView.Adapter<MiPetAdapter.MyPetViewHolder> {
    ArrayList<MiPet> miPets;
    Activity activity;

    public MiPetAdapter(ArrayList<MiPet> pets,  Activity activity){

        this.miPets = pets;
        this.activity = activity;
    }
    @NonNull
    @Override
    public MyPetViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.mipet, parent, false);
        return new MyPetViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MiPetAdapter.MyPetViewHolder holder, int position) {
        final MiPet miPet = miPets.get(position);
        holder.description.setText(miPet.getDescripcion());

        Picasso.with(activity)
                .load(miPet.getFoto())
                .placeholder(R.drawable.ic_hueso)
                .into(holder.petImage);
    }

    @Override
    public int getItemCount() {
        return miPets.size();
    }


    public static class MyPetViewHolder extends  RecyclerView.ViewHolder{

        TextView description;
        ImageView petImage;


        public MyPetViewHolder(View itemView) {
            super(itemView);

            description = (TextView) itemView.findViewById(R.id.miPetDesciption);
            petImage = (ImageView) itemView.findViewById(R.id.petImage);




        }
    }
}
