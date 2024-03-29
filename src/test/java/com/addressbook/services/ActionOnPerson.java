package com.addressbook.services;

import com.addressbook.model.Person;
import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;


public class ActionOnPerson implements PersonsBehavior {

    ActionOnBook actionOnBook = new ActionOnBook();

    @Override
    public List<Person> addPerson(Person person) throws AddressBookIssuesException {
        List<Person> personList = actionOnBook.readBook();
        personList.add(person);
        actionOnBook.writeOnBook(personList);
        return personList;
    }

    @Override
    public boolean editPerson(String firstName, String lastName, Person newDetails) throws AddressBookIssuesException {
        List<Person> personList = null;
        boolean flagForDataFound = false;

        personList = actionOnBook.readBook();
        Iterator personListIterator = personList.iterator();
        while (personListIterator.hasNext()) {
            Person person = (Person) personListIterator.next();
            if ((person.getFirstName().equalsIgnoreCase(firstName)) && (person.getLastName().equalsIgnoreCase(lastName))) {

                flagForDataFound = true;

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
    public boolean deletePerson(String PhoneNumber) throws AddressBookIssuesException {

        List<Person> personList = null;
        List<Person> newList = new ArrayList<>();

        boolean flagForDataFound = false;
        personList = actionOnBook.readBook();
        Iterator personListIterator = personList.iterator();
        while (personListIterator.hasNext()) {
            Person person = (Person) personListIterator.next();
            if (!person.getPhNo().equals(PhoneNumber)) {
                newList.add(person);
            } else if (person.getPhNo().equals(PhoneNumber)) {
                flagForDataFound = true;
            }
        }
        actionOnBook.writeOnBook(newList);
        return flagForDataFound;
    }

    @Override
    public List<Person> sortByName() throws AddressBookIssuesException {
        List<Person> personList = null;
        personList = actionOnBook.readBook();
        personList.sort((s1, s2) -> s1.getLastName().toLowerCase().compareTo(s2.getLastName().toLowerCase()));
        return personList;
    }

    @Override
    public List<Person> sortByZipCode() throws AddressBookIssuesException {
        List<Person> personList = null;
        personList = actionOnBook.readBook();
        personList.sort((s1, s2) -> s1.getZipCode().compareTo(s2.getZipCode()));
        return personList;
    }

    @Override
    public void printEntries() throws AddressBookIssuesException {
        actionOnBook.printAddressBook();
    }
}

