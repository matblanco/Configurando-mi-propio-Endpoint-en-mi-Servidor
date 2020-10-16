package com.andromotica.petagram.db;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

import com.andromotica.petagram.R;
import com.andromotica.petagram.pojo.Pet;

import java.util.ArrayList;

public class ConstructorPets {

    private static final int LIKE = 0;
    private Context context;

    public ConstructorPets(Context context) {
        this.context = context;
    }

    public ArrayList<Pet> obtenerPets(){

        /*

        ArrayList<Pet> pets = new ArrayList<Pet>();
        pets.add(new Pet(R.drawable.betel, "Betel",1));
        pets.add(new Pet(R.drawable.angel, "Angel", 2));
        pets.add(new Pet(R.drawable.cosiris, "Cosiris",2));
        pets.add(new Pet(R.drawable.gucci, "Gucci", 2));
        pets.add(new Pet(R.drawable.canela, "Canela",2));d
        return pets;

         */

        BaseDatos db = new BaseDatos(context);
        insertarCincoPets(db);

        return db.obtenerPetsRaking();
    }

    public void insertarCincoPets(BaseDatos db){
        ContentValues contentValues = new ContentValues();
        contentValues.put(ConstantesBaseDatos.TABLE_PET_NAME, "Canelu");
        contentValues.put(ConstantesBaseDatos.TABLE_PET_PHOTO, R.drawable.canela);
        db.insertarPet(contentValues);

        contentValues.put(ConstantesBaseDatos.TABLE_PET_NAME, "cosiris");
        contentValues.put(ConstantesBaseDatos.TABLE_PET_PHOTO, R.drawable.cosiris);
        db.insertarPet(contentValues);

        contentValues.put(ConstantesBaseDatos.TABLE_PET_NAME, "Betel");
        contentValues.put(ConstantesBaseDatos.TABLE_PET_PHOTO, R.drawable.betel);
        db.insertarPet(contentValues);
        db.close();
    }

    public void insertarRaiting(Pet pet){
        int raitinactual = pet.getRaiting();
        int aumentarRaiting = raitinactual + 1;
        pet.setRaiting(aumentarRaiting);
        BaseDatos db = new BaseDatos(context);
        ContentValues contentValues = new ContentValues();
        contentValues.put(ConstantesBaseDatos.TABLE_RAITING_PET_NUMBER, pet.getRaiting());
        db.insertarRaitingPet(contentValues, pet);
        db.close();
    }

    public int ObtenerRaitingPets(Pet pet){
        BaseDatos db = new BaseDatos(context);
        return db.obtenerPetsRankedNumber(pet);

    }

    public ArrayList<Pet> obtenerPetsRanked(){

        BaseDatos db = new BaseDatos(context);

        return db.obtenerPetsRanked();
    }





}
