package com.example.buurttuindeelopdracht2.Dtos;

import com.example.buurttuindeelopdracht2.Entiteiten.Tool;

import java.util.HashSet;
import java.util.Set;

public class UserDto {

    private String userName;
    private String password;
    private Boolean enabled;
    private String role;
    //    private IMG
    private String firstName;
    private String lastName;
    private String zipcode;
    private String streetName;
    private Long houseNumber;
    private String email;

    private Set<Tool> tools = new HashSet<>();

    public Set<Tool> getTools() {
        return tools;
    }

    public void setTools(Set<Tool> tools) {
        this.tools = tools;
    }

    public Boolean getEnabled() {
        return enabled;
    }

    public void setEnabled(Boolean enabled) {
        this.enabled = enabled;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }


    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
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
}
