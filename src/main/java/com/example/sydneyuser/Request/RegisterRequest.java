package com.example.sydneyuser.Request;


import com.google.gson.Gson;

public class RegisterRequest {


    /**
     * username : string
     * first_name : string
     * last_name : string
     * email : user@example.com
     * is_active : true
     * date_joined : 2021-04-20T14:32:05.319Z
     * password : string
     */
    public String username;
    public String first_name;
    public String last_name;
    public String email;
    public String password;
    private String date_joined = "2021-04-20T14:32:05.319Z" ;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getFirst_name() {
        return first_name;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public String getLast_name() {
        return last_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getDate_joined() {
        return date_joined;
    }

    public void setDate_joined(String date_joined) {
        this.date_joined = date_joined;
    }

    @Override
    public String toString() {
        return "RegisterRequest{" +
                "username='" + username + '\'' +
                ", first_name='" + first_name + '\'' +
                ", last_name='" + last_name + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", date_joined='" + date_joined + '\'' +
                '}';
    }
}
