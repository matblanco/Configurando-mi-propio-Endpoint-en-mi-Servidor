package com.andromotica.petagram.presentador;

import android.content.Context;

import com.andromotica.petagram.db.ConstructorPets;
import com.andromotica.petagram.fragments.IRecyclerViewHomeFragment;
import com.andromotica.petagram.pojo.Pet;

import java.util.ArrayList;

public class LikePetsActivity implements ILikePetsActivityPresentador {

    private IRecyclerViewHomeFragment iRecyclerViewHomeFragment;
    private Context context;
    private ConstructorPets constructorPets;
    private ArrayList<Pet> pets;

    public LikePetsActivity(IRecyclerViewHomeFragment iRecyclerViewHomeFragment, Context context) {
        this.iRecyclerViewHomeFragment = iRecyclerViewHomeFragment;
        this.context = context;
        obtenerPetsRanked();
    }

    @Override
    public void obtenerPetsRanked() {
        constructorPets = new ConstructorPets(context);
        pets = constructorPets.obtenerPetsRanked();
        mostrarPetsRV();

    }

    @Override
    public void mostrarPetsRV() {
        iRecyclerViewHomeFragment.inicializarAdaptadorRV(iRecyclerViewHomeFragment.crearAdaptador(pets));
        iRecyclerViewHomeFragment.generarLinearLayoutVertical();

    }
}
