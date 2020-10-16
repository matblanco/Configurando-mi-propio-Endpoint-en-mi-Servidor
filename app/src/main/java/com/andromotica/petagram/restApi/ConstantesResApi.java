package com.andromotica.petagram.restApi;

public final class ConstantesResApi {

    public final static String ROOT_URL= "https://graph.instagram.com/";
    public final static String ACCES_TOKEN = "IGQVJYYXpTNDNRaHV3cDZAzeUZANMzhFLWdTOTN2TWlvREpLMlEzbWdNdmJLVU1ZAbDYxTlV4b0RiSmRBd3huNTdzQ1BibVhXMFBsMzBHaGFnUGdhUnZAfY08tQ3pXR3Rkbk9yWnBmekhB";
    public static final String KEY_ACCES_TOKEN = "&access_token=";
    public final static String KEY_GET_INFORMATION_USER= "me/media?fields=id,media_url,caption,timestamp,media_type,permalink,thumbnail_url,username";
    public final static String URL_GET_RECENT_MEDIA_USER_BETELUCANELU= KEY_GET_INFORMATION_USER + KEY_ACCES_TOKEN + ACCES_TOKEN;

    public final static String ACCES_TOKEN2 = "IGQVJYU1VDMDNKR0dIdlR1RV9NRGp6c2RsVzhhV1NJRXZACNGM2SUMxLW9nRU5nOU5SSXZAOeWdZAUEtLRlpzemZAZAVFh4UFZAvYzl6emwwYzh5YzlYY3BzTXAzSl9HbE5iVTd6UVZAobEV3";
    public static final String KEY_ACCES_TOKEN2 = "&access_token=";
    public final static String KEY_GET_INFORMATION_USER2= "me/media?fields=id,media_url,caption,timestamp,media_type,permalink,thumbnail_url,username";
    public final static String URL_GET_RECENT_MEDIA_USER_JULYMORA = KEY_GET_INFORMATION_USER2 + KEY_ACCES_TOKEN2 + ACCES_TOKEN2;

    public static final String ROOT_URL_POST="https://secret-brushlands-22663.herokuapp.com/";
    public static final String KEY_POST_ID_DISPOSITIVO = "registrar-usuario/";

    public final static String KEY_GETINFORMATION_INSTAGRAMUSER="me?fields=ig_id,username";

    public final static String URL_GET__USERDATA_BETELUCANELU = KEY_GETINFORMATION_INSTAGRAMUSER +KEY_ACCES_TOKEN+ACCES_TOKEN;

}
