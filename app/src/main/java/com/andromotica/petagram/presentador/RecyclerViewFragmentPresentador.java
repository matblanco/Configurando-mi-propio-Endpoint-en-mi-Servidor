package com.andromotica.petagram.presentador;

import android.content.Context;

import com.andromotica.petagram.R;
import com.andromotica.petagram.db.ConstructorPets;
import com.andromotica.petagram.fragments.IRecyclerViewHomeFragment;
import com.andromotica.petagram.pojo.Pet;

import java.util.ArrayList;

public class RecyclerViewFragmentPresentador implements IRecyclerViewFragmentPresentador{

    private IRecyclerViewHomeFragment iRecyclerViewHomeFragment;
    private Context context;
    private ConstructorPets constructorPets;
    private ArrayList<Pet> pets;

    public RecyclerViewFragmentPresentador(IRecyclerViewHomeFragment iRecyclerViewHomeFragment, Context context) {
        this.iRecyclerViewHomeFragment = iRecyclerViewHomeFragment;
        this.context = context;
        obtenerPetsRaiting();
    }

    @Override
    public void obtenerPetsRaiting() {
        constructorPets = new ConstructorPets(context);
        pets = constructorPets.obtenerPets();
        mostrarPetsRV();
    }

    @Override
    public void mostrarPetsRV() {
        iRecyclerViewHomeFragment.inicializarAdaptadorRV(iRecyclerViewHomeFragment.crearAdaptador(pets));
        iRecyclerViewHomeFragment.generarLinearLayoutVertical();

    }
}
