package com.andromotica.petagram.fragments;

import com.andromotica.petagram.adapters.PetagramAdapter;
import com.andromotica.petagram.pojo.Pet;

import java.lang.reflect.Array;
import java.util.ArrayList;

public interface IRecyclerViewHomeFragment {

    public void generarLinearLayoutVertical();

    public PetagramAdapter crearAdaptador(ArrayList<Pet> pets);

    public void inicializarAdaptadorRV(PetagramAdapter adaptador);
}
