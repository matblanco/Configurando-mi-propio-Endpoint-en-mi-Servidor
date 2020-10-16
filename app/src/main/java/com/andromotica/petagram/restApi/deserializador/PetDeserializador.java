package com.andromotica.petagram.restApi.deserializador;


import android.util.Log;

import com.andromotica.petagram.pojo.MiPet;
import com.andromotica.petagram.restApi.JsonKeys;
import com.andromotica.petagram.restApi.model.PetResponse;
import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParseException;

import java.lang.reflect.Type;
import java.util.ArrayList;

public class PetDeserializador implements JsonDeserializer<PetResponse> {

    @Override
    public PetResponse deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) throws JsonParseException {

        Gson gson = new Gson();
        PetResponse petResponse = gson.fromJson(json, PetResponse.class);
        JsonArray petResponseData = json.getAsJsonObject().getAsJsonArray(JsonKeys.MEDIA_RESPONSE_ARRAY);

        petResponse.setMiPets(deserializarContactoDeJson(petResponseData));

        return petResponse;
    }

    private ArrayList<MiPet> deserializarContactoDeJson(JsonArray contacoResponseData){
        ArrayList<MiPet> miPets = new ArrayList<>();

        for (int i = 0; i <contacoResponseData.size() ; i++) {
            JsonObject contactoResponseDataObject = contacoResponseData.get(i).getAsJsonObject();
            String nombre = contactoResponseDataObject.get(JsonKeys.PET_NAME).getAsString();
            String descripcion = contactoResponseDataObject.get(JsonKeys.CAPTION).getAsString();
            String foto = contactoResponseDataObject.get(JsonKeys.MEDIA_URL).getAsString();


            MiPet petActual = new MiPet();
            petActual.setNombre(nombre);
            petActual.setDescripcion(descripcion);
            petActual.setFoto(foto);

            miPets.add(petActual);
        }
        return miPets;

    }
}


