package com.addressbook.services;

import com.addressbook.model.Person;
import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;


public class ActionOnPerson implements PersonsBehavior {

    ActionOnBook actionOnBook = new ActionOnBook();

    @Override
    public ArrayList addPerson(Person person) {
        ArrayList<Person> personList = actionOnBook.readBook();
        personList.add(person);
        for (Person persons:personList
             ) {
            System.out.println(persons.toString());
        }
        actionOnBook.writeOnBook(personList);
        return personList;
    }

}

