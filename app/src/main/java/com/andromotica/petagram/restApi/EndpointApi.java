package com.andromotica.petagram.restApi;

import com.andromotica.petagram.restApi.model.PetResponse;
import com.andromotica.petagram.restApi.model.ProfileDataResponse;
import com.andromotica.petagram.restApi.model.RegistroResponse;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface EndpointApi {

    @GET(ConstantesResApi.URL_GET_RECENT_MEDIA_USER_BETELUCANELU)
    Call<PetResponse> getAllMediaBeteluCanelu();

    @GET(ConstantesResApi.URL_GET_RECENT_MEDIA_USER_JULYMORA)
    Call<PetResponse> getAllMediaJulyMora444();

    @GET(ConstantesResApi.URL_GET__USERDATA_BETELUCANELU)
    Call<ProfileDataResponse> getUserInformationBeteluCanelu();

    @FormUrlEncoded
    @POST(ConstantesResApi.KEY_POST_ID_DISPOSITIVO)
    Call<RegistroResponse> registarDispositivoID(@Field("iddispositivo") String iddispositivo, @Field("idusuarioinstagram") String idusuarioinstagram);
}
