package com.example.calojy.ui2;

/**
 * Created by ice on 06-Apr-17.
 */

public class passenger {
    private String email;
    private String phone;
    private String pass;

    public passenger(String email,String pass,String phone){
        this.email=email;
        this.phone=phone;
        this.pass=pass;
    }

    public String getPhone() {
        return phone;
    }

    public String getEmail() {
        return email;
    }

    public String getPass() {
        return pass;
    }
}
