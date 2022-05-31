package com.example.buurttuindeelopdracht2.Entiteiten;

import java.io.Serializable;

public class AuthorityKey implements Serializable {
    private String username;
    private String authority;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getAuthority() {
        return authority;
    }

    public void setAuthority(String authority) {
        this.authority = authority;
    }
}
