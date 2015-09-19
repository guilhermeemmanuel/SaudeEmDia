package com.northeast.saudeemdia.model;

/**
 * Created by Guiga on 19/09/2015.
 */
public class Person {

    private String name;
    private String address;
    private String birthday;
    private String sus;


    public Person(String name, String address, String birthday, String sus) {
        this.name = name;
        this.address = address;
        this.birthday = birthday;
        this.sus = sus;

    }

    public String getName() {
        return name;
    }

    public String getAddress() {
        return address;
    }

    public String getBirthday() {
        return birthday;
    }



    public String getSus() {
        return sus;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }



    public void setSus(String sus) {
        this.sus = sus;
    }

}
