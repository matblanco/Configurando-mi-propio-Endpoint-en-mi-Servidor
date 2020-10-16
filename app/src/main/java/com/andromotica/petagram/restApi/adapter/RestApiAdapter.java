package com.andromotica.petagram.restApi.adapter;

import com.andromotica.petagram.restApi.ConstantesResApi;
import com.andromotica.petagram.restApi.EndpointApi;
import com.andromotica.petagram.restApi.deserializador.PetDeserializador;
import com.andromotica.petagram.restApi.model.PetResponse;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RestApiAdapter {

    public EndpointApi establecesConexionRestApiInstagram(Gson gson){
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(ConstantesResApi.ROOT_URL)
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build();

        return retrofit.create(EndpointApi.class);
    }

    public Gson construyeGsonDeserializadorMediaRecent(){
        GsonBuilder gsonBuilder = new GsonBuilder();
        gsonBuilder.registerTypeAdapter(PetResponse.class, new PetDeserializador());
        return  gsonBuilder.create();
    }

    public EndpointApi establecerConecionRestApiRegistroDispositivo(){
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(ConstantesResApi.ROOT_URL_POST)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
                ;
        return retrofit.create(EndpointApi.class);
    }

    public EndpointApi establecerConecionRestApiInstagramDataUser(){
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(ConstantesResApi.ROOT_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
                ;
        return retrofit.create(EndpointApi.class);
    }
}
