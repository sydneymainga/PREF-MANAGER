package com.example.sydneyuser.Response;

import com.google.gson.Gson;

public class RegisterResponse {


    /**
     * id : 864
     * url : http://api.larntech.net/users/864/
     * username : string1syd
     * first_name : first_name
     * last_name : last_name
     * email : user2ss@example.com
     * is_active : true
     * date_joined : 2021-04-20 15:03:48
     * last_login : null
     */

    private int id;
    private String email;
    private String username;
    /*public String url;
    public String first_name;
    public String last_name;
   public boolean is_active;
    public String date_joined;
    public Object last_login;*/

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @Override
    public String toString() {
        return "RegisterResponse{" +
                "id=" + id +
                ", email='" + email + '\'' +
                ", username='" + username + '\'' +
                '}';
    }
}
