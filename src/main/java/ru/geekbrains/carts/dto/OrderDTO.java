package ru.geekbrains.carts.dto;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;

import java.io.Serializable;

public class OrderDTO implements Serializable{

    private static final long serialVersionUID = 1L;

    @NotEmpty(message="FirstName is required")
    private String firstName;
    @NotEmpty(message="LastName is required")
    private String lastName;
    @NotEmpty(message="EmailId is required")
    @Email
    private String emailId;
    @NotEmpty(message="Phone is required")
    private String phone;

    @NotEmpty(message="Address Line is required")
    private String addressLine;
    @NotEmpty(message="City is required")
    private String city;

    @NotEmpty(message="Country is required")
    private String country;

    public String getFirstName(){
        return firstName;
    }

    public void setFirstName(String firstName){
        this.firstName = firstName;
    }

    public String getLastName(){
        return lastName;
    }

    public void setLastName(String lastName){
        this.lastName = lastName;
    }

    public String getEmailId(){
        return emailId;
    }

    public void setEmailId(String emailId){
        this.emailId = emailId;
    }

    public String getPhone(){
        return phone;
    }

    public void setPhone(String phone){
        this.phone = phone;
    }

    public String getAddressLine(){
        return addressLine;
    }

    public void setAddressLine(String addressLine){
        this.addressLine = addressLine;
    }

    public String getCity(){
        return city;
    }

    public void setCity(String city){
        this.city = city;
    }

    public String getCountry(){
        return country;
    }

    public void setCountry(String country){
        this.country = country;
    }
}
