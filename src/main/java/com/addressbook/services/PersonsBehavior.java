package com.addressbook.services;

import com.addressbook.model.Person;

import java.util.ArrayList;

public interface PersonsBehavior {

    public ArrayList addPerson(Person person);

    public boolean editPerson(String personFirstName,String personLastName);

    public ArrayList deletePerson(String personName);


}
