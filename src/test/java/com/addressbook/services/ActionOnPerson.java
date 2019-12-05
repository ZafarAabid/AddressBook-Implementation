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
        actionOnBook.writeOnBook(personList);
        return personList;
    }

    @Override
    public boolean editPerson(String personName) {
        ArrayList<Person> personList = null;
        boolean flagForDataFound=false;

        personList = actionOnBook.readBook();
        Iterator personListIterator = personList.iterator();
        while (personListIterator.hasNext()) {
            Person person = (Person) personListIterator.next();
            if (person.getFirstName().equals(personName)) {
                flagForDataFound=true;
                person.setPhNo("123456789");
                person.setCity("aaa");
                person.setState("zzz");
                person.setZipCode(11111);
                //setPersonInfo
                actionOnBook.writeOnBook(personList);
            }
        }
        return flagForDataFound;
    }

}

