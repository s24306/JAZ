package com.example.contract;

public class AddressDto {
    private Integer id;
    private String city;
    private String postal_code;
    private String street;

    public AddressDto(Integer id, String city, String postal_code, String street) {
        this.id = id;
        this.city = city;
        this.postal_code = postal_code;
        this.street = street;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getPostal_code() {
        return postal_code;
    }

    public void setPostal_code(String postal_code) {
        this.postal_code = postal_code;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }
}
