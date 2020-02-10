package com.example.myapplication;

import com.google.gson.annotations.SerializedName;

public class User {
    @SerializedName("card")
    private String card;
    @SerializedName("email")
    private String email;
    @SerializedName("username")
    private String username;
    @SerializedName("password")
    private String password;

    public User (String username,String password, String email, String card){
        this.username = username;
        this.password = password;
        this.email = email;
        this.card = card;
    }

}
