package com.andromotica.petagram.activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.andromotica.petagram.R;
import com.andromotica.petagram.adapters.PetagramAdapter;
import com.andromotica.petagram.fragments.IRecyclerViewHomeFragment;
import com.andromotica.petagram.pojo.Pet;
import com.andromotica.petagram.presentador.ILikePetsActivityPresentador;

import java.util.ArrayList;

public class LikePetsActivity extends AppCompatActivity implements IRecyclerViewHomeFragment {

    ArrayList<Pet> pets;
    private RecyclerView listaPets;
    Toolbar like;
    private ILikePetsActivityPresentador presentador;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_like_pets);

        like = findViewById(R.id.toolbarlike);
        setSupportActionBar(like);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);





        listaPets = findViewById(R.id.likepetslist);
        presentador = new com.andromotica.petagram.presentador.LikePetsActivity(this, this);




    }

    @Override
    public void generarLinearLayoutVertical() {

        LinearLayoutManager llm = new LinearLayoutManager(this);
        llm.setOrientation(LinearLayoutManager.VERTICAL);
        listaPets.setLayoutManager(llm);

    }

    @Override
    public PetagramAdapter crearAdaptador(ArrayList<Pet> pets) {
        PetagramAdapter adapter = new PetagramAdapter(pets, this);
        return adapter;
    }

    @Override
    public void inicializarAdaptadorRV(PetagramAdapter adaptador) {
        listaPets.setAdapter(adaptador);

    }
}