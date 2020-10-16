package com.andromotica.petagram.restApi.model;

import android.util.Log;

import com.andromotica.petagram.pojo.MiPet;

import java.util.ArrayList;

public class PetResponse {

    ArrayList<MiPet> miPets;


    public ArrayList<MiPet> getMiPets() {
        return miPets;

    }

    public void setMiPets(ArrayList<MiPet> miPets) {
        this.miPets = miPets;
    }
}
