package com.addressbook.services;

import com.addressbook.model.Person;

import java.util.List;

public interface PersonsBehavior {

    public List addPerson(Person person);

    public boolean editPerson(String personFirstName,String personLastName,Person person);

    public boolean deletePerson(String personName);

    public List sortByName();

    public List sortByZipCode();

    public void printEntries();

}
