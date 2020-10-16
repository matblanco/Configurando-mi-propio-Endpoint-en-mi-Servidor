package com.andromotica.petagram.db;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import androidx.annotation.Nullable;

import com.andromotica.petagram.pojo.Pet;

import java.util.ArrayList;

public class BaseDatos extends SQLiteOpenHelper {


    public BaseDatos( Context context) {
        super(context, ConstantesBaseDatos.DATABASE_NAME, null, ConstantesBaseDatos.DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String queryCrearTablaPetisRaitnig = "CREATE TABLE " +    ConstantesBaseDatos.TABLE_PET + "(" +
                                            ConstantesBaseDatos.TABLE_PET_ID                + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                                            ConstantesBaseDatos.TABLE_PET_NAME              + " TEXT, " +
                                            ConstantesBaseDatos.TABLE_PET_PHOTO             + " INTEGER, " +
                                            ConstantesBaseDatos.TABLE_RAITING_PET_NUMBER    + " INTEGER "  +
                                         ")";
        db.execSQL(queryCrearTablaPetisRaitnig);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
        db.execSQL("DROP TABLE IF EXISTS " +  ConstantesBaseDatos.TABLE_PET);
    }

    public ArrayList<Pet> obtenerPetsRaking(){
        ArrayList<Pet> pets = new ArrayList<>();

        String query = "SELECT * FROM " + ConstantesBaseDatos.TABLE_PET;
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor registros = db.rawQuery(query, null);

        while (registros.moveToNext()){
            Pet petActual = new Pet();
            petActual.setId(registros.getInt(0));
            petActual.setNombre(registros.getString(1));
            petActual.setFoto(registros.getInt(2));
            petActual.setRaiting(registros.getInt(3));

            pets.add(petActual);
        }

        db.close();

        return pets;
    }

    public void insertarPet(ContentValues contentValues){
        SQLiteDatabase db = this.getWritableDatabase();
        db.insert(ConstantesBaseDatos.TABLE_PET,null, contentValues);
        db.close();
    }

    public void insertarRaitingPet(ContentValues contentValues, Pet pet){
        int raitinActual = pet.getRaiting();

        SQLiteDatabase db = this.getWritableDatabase();
        contentValues.put(ConstantesBaseDatos.TABLE_RAITING_PET_NUMBER,raitinActual );

        Log.d("raiting", String.valueOf(raitinActual));
        db.update(ConstantesBaseDatos.TABLE_PET, contentValues,   ConstantesBaseDatos.TABLE_PET_ID + "=" +pet.getId(), null);
        db.close();
    }

    public int obtenerPetsRankedNumber(Pet pet){
        int likes = 0;
        String query = "SELECT ("+ConstantesBaseDatos.TABLE_RAITING_PET_NUMBER+")" +
                " FROM " +  ConstantesBaseDatos.TABLE_PET +
                " WHERE " + ConstantesBaseDatos.TABLE_PET_ID + "=" +pet.getId();
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor registros = db.rawQuery(query, null);
        if (registros.moveToNext()){
            likes = registros.getInt(0);
        }
        db.close();
        return likes;
    }

    public ArrayList<Pet> obtenerPetsRanked(){
        ArrayList<Pet> pets = new ArrayList<>();
        String query = "SELECT * FROM " + ConstantesBaseDatos.TABLE_PET +
                " WHERE " + ConstantesBaseDatos.TABLE_RAITING_PET_NUMBER + ">=" +0;
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor registros = db.rawQuery(query, null);

        while (registros.moveToNext()){
            Pet petActual = new Pet();
            petActual.setId(registros.getInt(0));
            petActual.setNombre(registros.getString(1));
            petActual.setFoto(registros.getInt(2));
            petActual.setRaiting(registros.getInt(3));

            pets.add(petActual);
        }

        db.close();

        return pets;
    }


}
