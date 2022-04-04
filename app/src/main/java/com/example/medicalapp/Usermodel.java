package com.example.medicalapp;

public class Usermodel {

    private String username;
    private String Password;
    private int age;
    private int phonenumber;
    private String address;
    private boolean SMSEMAIL;

    /**  creates public array holding the information for each coloumn of the table in the database*/
    public Usermodel(String username, String password, int age, int phonenumber, String address, boolean SMSEMAIL) {
        this.username = username;
        this.Password = password;
        this.age = age;
        this.phonenumber = phonenumber;
        this.address = address;
        this.SMSEMAIL = SMSEMAIL;
    }

    @Override
    /**  returns the values for the Usermodel array*/
    public String toString() {
        return "Usermodel{" +
                "username='" + username + '\'' +
                ", Password='" + Password + '\'' +
                ", age=" + age +
                ", phonenumber=" + phonenumber +
                ", address='" + address + '\'' +
                ", SMSEMAIL=" + SMSEMAIL +
                '}';
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return Password;
    }

    public void setPassword(String password) {
        Password = password;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getPhonenumber() {
        return phonenumber;
    }

    public void setPhonenumber(int phonenumber) {
        this.phonenumber = phonenumber;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public boolean isSMSEMAIL() {
        return SMSEMAIL;
    }

    public void setSMSEMAIL(boolean SMSEMAIL) {
        this.SMSEMAIL = SMSEMAIL;
    }
}
