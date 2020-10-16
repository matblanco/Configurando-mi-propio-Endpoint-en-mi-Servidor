package com.andromotica.petagram.restApi.model;

public class ProfileDataResponse {
    String ig_id;
    String username;
    String id;

    public ProfileDataResponse(String ig_id, String username, String id) {
        this.ig_id = ig_id;
        this.username = username;
        this.id = id;
    }

    public ProfileDataResponse() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getIg_id() {
        return ig_id;
    }

    public void setIg_id(String ig_id) {
        this.ig_id = ig_id;
    }
}
