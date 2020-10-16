package com.andromotica.petagram.presentador;

import android.content.Context;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.andromotica.petagram.fragments.IPetFragment;
import com.andromotica.petagram.pojo.MiPet;
import com.andromotica.petagram.restApi.EndpointApi;
import com.andromotica.petagram.restApi.adapter.RestApiAdapter;
import com.andromotica.petagram.restApi.model.PetResponse;
import com.google.gson.Gson;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MipetPresentador implements IMipetPresentador {

    private IPetFragment iPetFragment;
    private Context context;
    private ArrayList<MiPet> miPets;
    ImageView imageViewq;
    TextView nameProfile;

    public MipetPresentador(IPetFragment iPetFragment, Context context, ImageView imageViewq, TextView nameProfile) {
        this.iPetFragment = iPetFragment;
        this.context = context;
        this.imageViewq = imageViewq;
        this.nameProfile = nameProfile;
        obtenerMediosRecientes();

    }

    @Override
    public void obtenerMediosRecientes() {
        RestApiAdapter restApiAdapter = new RestApiAdapter();
        Gson gsonMediaRecent = restApiAdapter.construyeGsonDeserializadorMediaRecent();
        EndpointApi endpointApi = restApiAdapter.establecesConexionRestApiInstagram(gsonMediaRecent);

        Call<PetResponse> petResponseCall = endpointApi.getAllMediaJulyMora444();
        petResponseCall.enqueue(new Callback<PetResponse>() {
            @Override
            public void onResponse(Call<PetResponse> call, Response<PetResponse> response) {
                PetResponse petResponse = response.body();
                miPets = petResponse.getMiPets();
                mostrarContactosRV();
                setFotoPerfil();
                setNombrePerfil();

            }

            @Override
            public void onFailure(Call<PetResponse> call, Throwable t) {
                Toast.makeText(context, "Algo paso en la conexion intenta de nuevo", Toast.LENGTH_LONG).show();
                Log.d("FALLA LA CONEXION", t.toString());
            }
        });
    }

    @Override
    public void mostrarContactosRV() {
        iPetFragment.inicializarAdaptadorRV(iPetFragment.crearAdaptador(miPets));
        iPetFragment.generarGridLayout();
    }

    @Override
    public void setFotoPerfil() {
        for (MiPet p:miPets) {
            MiPet miPet;
            miPet = miPets.get(3);

            Picasso.with(context)
                    .load(miPet.getFoto())
                    .into(imageViewq);
        }
    }

    @Override
    public void setNombrePerfil() {
        for (MiPet p:miPets) {
            MiPet miPet;
            miPet = miPets.get(0);

            nameProfile.setText(miPet.getNombre());
        }

    }
}
