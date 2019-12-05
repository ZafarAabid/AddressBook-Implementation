package com.addressbook.services;

import com.addressbook.model.Person;

import java.util.ArrayList;

public interface PersonsBehavior {

    public ArrayList addPerson(Person person);

    public ArrayList editPerson(String personName);

    public ArrayList deletePerson(String personName);


}
