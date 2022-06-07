package com.example.buurttuindeelopdracht2.Entiteiten;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "Buren")
public class User {

    @Id
    @Column(nullable = false, unique = true)
    private String username;
    @Column(nullable = false, length = 255)
    private String password;
    @Column(nullable = false)
    private boolean enabled = true;
    @Column
    private String apikey;
    @Column
    private String email;
//    private IMG
    private String firstName;
    private String lastName;
    private String zipcode;
    private String streetName;
    private Long houseNumber;

    @OneToMany(mappedBy = "user")
    private Set<Tool> tools = new HashSet<>();

    @OneToMany(
            targetEntity = Authority.class,
            mappedBy = "username",
            cascade = CascadeType.ALL,
            orphanRemoval = true,
            fetch = FetchType.EAGER)
    private Set<Authority> authorities = new HashSet<>();

    public Set<Authority> getAuthorities() {
        return authorities;
    }
    public void setAuthorities(Set<Authority> authorities) {
        this.authorities = authorities;
    }

    public boolean isEnabled() {
        return enabled;
    }
    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }

    public String getApikey() {
        return apikey;
    }
    public void setApikey(String apikey) {
        this.apikey = apikey;
    }

    public String getLastName() {
        return lastName;
    }
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getUsername() {
        return username;
    }
    public void setUsername(String userName) {
        this.username = userName;
    }

    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }

    public String getFirstName() {
        return firstName;
    }
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getZipcode() {
        return zipcode;
    }
    public void setZipcode(String zipcode) {
        this.zipcode = zipcode;
    }

    public String getStreetName() {
        return streetName;
    }
    public void setStreetName(String streetName) {
        this.streetName = streetName;
    }

    public Long getHouseNumber() {
        return houseNumber;
    }
    public void setHouseNumber(Long houseNumber) {
        this.houseNumber = houseNumber;
    }

    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }

    public Set<Tool> getTools() {
        return tools;
    }
    public void setTools(Set<Tool> tools) {
        this.tools = tools;
    }

    public void addAuthority(Authority authority) {
        this.authorities = authorities;
    }

    public void removeAuthority(Authority authorityToRemove) {
        this.authorities = authorities;
    }
}
