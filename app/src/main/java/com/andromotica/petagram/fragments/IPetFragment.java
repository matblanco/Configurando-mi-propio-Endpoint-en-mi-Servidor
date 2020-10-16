package com.andromotica.petagram.fragments;

import android.media.Image;
import android.widget.ImageView;

import com.andromotica.petagram.adapters.MiPetAdapter;
import com.andromotica.petagram.adapters.PetagramAdapter;
import com.andromotica.petagram.pojo.MiPet;
import com.andromotica.petagram.pojo.Pet;

import java.util.ArrayList;

public interface IPetFragment {

    public  void generarGridLayout();

    public MiPetAdapter crearAdaptador(ArrayList<MiPet> miPets);

    public void inicializarAdaptadorRV(MiPetAdapter adaptador);
}
