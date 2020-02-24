package com.fraeds.fragmentcommunication;

public class Person {


    private String name = "";
    private int age = -1;
    private String telephone="";
    private String email = "";
    private String address = "";

    public Person(String name, int age, String telephone, String email, String address)
    {
        this.name = name;
        this.age = age;
        this.telephone = telephone;
        this.email = email;
        this.address = address;

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }






}
