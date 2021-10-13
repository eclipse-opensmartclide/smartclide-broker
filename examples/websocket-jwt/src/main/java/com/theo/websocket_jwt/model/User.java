package com.theo.websocket_jwt.model;

public class User {

    private String username;

    private String password;

    private String authority;

    public User(){}

    public User(String username, String password){
        this.username = username;
        this.password = password;
        authority = "ROLE_USER";
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getAuthority() {
        return authority;
    }

    public void setAuthority(String authority) {
        this.authority = authority;
    }
}
