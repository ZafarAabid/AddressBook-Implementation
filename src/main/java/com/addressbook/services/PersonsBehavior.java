package com.addressbook.services;

import com.addressbook.model.Person;

import java.util.List;

public interface PersonsBehavior {

    public List addPerson(Person person) throws AddressBookIssuesException;

    public boolean editPerson(String personFirstName,String personLastName,Person person) throws AddressBookIssuesException;

    public boolean deletePerson(String personName) throws AddressBookIssuesException;

    public List sortByName() throws AddressBookIssuesException;

    public List sortByZipCode() throws AddressBookIssuesException;

    public void printEntries() throws AddressBookIssuesException;

}