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
    public boolean editPerson(String firstName,String lastName,Person newDetails) {
        ArrayList<Person> personList = null;
        boolean flagForDataFound=false;

        personList = actionOnBook.readBook();
        Iterator personListIterator = personList.iterator();
        while (personListIterator.hasNext()) {
            Person person = (Person) personListIterator.next();
            if ((person.getFirstName().equalsIgnoreCase(firstName))&&(person.getLastName().equalsIgnoreCase(lastName))) {

                flagForDataFound=true;

                person.setPhNo(newDetails.getPhNo());
                person.setCity(newDetails.getCity());
                person.setState(newDetails.getState());
                person.setZipCode(newDetails.getZipCode());
                actionOnBook.writeOnBook(personList);
            }
        }
        return flagForDataFound;
    }

    @Override
    public boolean deletePerson(String PhoneNumber) {
        {
            ArrayList<Person> personList = null;
            boolean flagForDataFound=false;
            personList = actionOnBook.readBook();
            Iterator personListIterator = personList.iterator();
            while (personListIterator.hasNext()) {
                Person person = (Person) personListIterator.next();
                if (person.getPhNo().equals(PhoneNumber)) {
                    flagForDataFound=true;

                    personList.remove(person);
                    actionOnBook.writeOnBook(personList);
                    break;
                }
            }
            return flagForDataFound;
        }

    }
}

