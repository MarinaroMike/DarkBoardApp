package com.example.platypie_darkboard.backend_communication;

import com.google.gson.annotations.SerializedName;

public class User {
    private String name;
    private String username;
    private String hashedPassword;
    private String accountType;
    private String ID;

    @SerializedName("body")
    private String text;


    //Getters
    public String getName() {
        return name;
    }

    public String getUsername() {
        return username;
    }

    public String getHashedPassword() {
        return hashedPassword;
    }

    public String getAccountType() {
        return accountType;
    }

    public String getID() {
        return ID;
    }

    public String getText() {
        return text;
    }
}
