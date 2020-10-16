package com.andromotica.petagram.presentador;

import android.content.Context;
import android.util.Log;
import android.widget.TextView;

import androidx.annotation.NonNull;

import com.andromotica.petagram.restApi.EndpointApi;
import com.andromotica.petagram.restApi.adapter.RestApiAdapter;
import com.andromotica.petagram.restApi.model.ProfileDataResponse;
import com.andromotica.petagram.restApi.model.RegistroResponse;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.iid.FirebaseInstanceId;
import com.google.firebase.iid.InstanceIdResult;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class PersentadorNotificaciones implements IPresentadorNotificaciones {
    private Context context;
    private String id_ig;
    private String token;
    private String usernamep;
    private TextView username;

    public PersentadorNotificaciones(Context context) {
        this.context = context;

    }

    public PersentadorNotificaciones(String token,TextView username ) {
        this.token = token;
        this.username = username;
        ObteneProfileData();
    }

    @Override
    public void ObteneProfileData() {
        RestApiAdapter restApiAdapter = new RestApiAdapter();
        EndpointApi endpointApi = restApiAdapter.establecerConecionRestApiInstagramDataUser();
        final Call<ProfileDataResponse> profileDataResponse = endpointApi.getUserInformationBeteluCanelu();
        profileDataResponse.enqueue(new Callback<ProfileDataResponse>() {
            @Override
            public void onResponse(Call<ProfileDataResponse> call, Response<ProfileDataResponse> response) {
                ProfileDataResponse profileDataResponse1 = response.body();
                id_ig = profileDataResponse1.getIg_id();
                usernamep = profileDataResponse1.getUsername();
                username.setText(usernamep);
                Log.d("id_Dispositivo", usernamep);
                registrarDispositivo(token, id_ig);
            }

            @Override
            public void onFailure(Call<ProfileDataResponse> call, Throwable t) {
            }
        });
    }

    @Override
    public void registrarDispositivo(String id_dispositivo, String id_ig) {
        //Log.d("id_Dispositivo", id_ig);
        Log.d("id_Dispositivo", id_dispositivo);
        ProfileDataResponse profileDataResponse = new ProfileDataResponse();
        RestApiAdapter restApiAdapter = new RestApiAdapter();
        EndpointApi endpointApi = restApiAdapter.establecerConecionRestApiRegistroDispositivo();
        Call<RegistroResponse> registroResponse = endpointApi.registarDispositivoID(id_dispositivo,id_ig);
        registroResponse.enqueue(new Callback<RegistroResponse>() {
            @Override
            public void onResponse(Call<RegistroResponse> call, Response<RegistroResponse> response) {
                RegistroResponse registroResponse = response.body();
                //Log.d("id_dispositivo", registroResponse.toString());
            }
            @Override
            public void onFailure(Call<RegistroResponse> call, Throwable t) {
            }
        });
    }
}
