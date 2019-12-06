package com.addressbook.model;

public class Person implements Comparable<Person> {
    private  String firstName;
    private  String lastName;
    private  String phNo;
    private  String city;
    private  String state;
    private  Integer zipCode;

    public Person(){}
    public Person(String firstName, String lastName, String phNo, String city, String state, Integer zipCode) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.phNo = phNo;
        this.city = city;
        this.state = state;
        this.zipCode = zipCode;
    }

    public Person(String phNo, String city, String state, Integer zipCode) {
        this.phNo = phNo;
        this.city = city;
        this.state = state;
        this.zipCode = zipCode;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getPhNo() {
        return phNo;
    }

    public void setPhNo(String phNo) {
        this.phNo = phNo;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public Integer getZipCode() {
        return zipCode;
    }

    public void setZipCode(Integer zipCode) {
        this.zipCode = zipCode;
    }

    @Override
    public int compareTo(Person person) {
        return this.getZipCode().compareTo(person.getZipCode());
    }


    @Override
    public String toString() {
        return "Person{" +
                "firstName=" + firstName + "\t\t" +
                ", lastName=" + lastName + "\t\t" +
                ", phNo=" + phNo + "\t\t" +
                ", city=" + city + "\t\t" +
                ", state=" + state + "\t\t" +
                ", zipCode=" + zipCode +
                '}';
    }
}
