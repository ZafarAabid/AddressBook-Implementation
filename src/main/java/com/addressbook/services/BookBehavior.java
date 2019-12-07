
package com.addressbook.services;

import com.addressbook.model.Person;

import java.util.List;

public interface BookBehavior {

    public List<Person> readBook( ) throws AddressBookIssuesException;

    public void writeOnBook( List<Person> list) throws AddressBookIssuesException;

    public List<Person> openBook(String filename) throws AddressBookIssuesException;

    public void printAddressBook() throws AddressBookIssuesException;

    public String createAdressBook(String fileName) throws AddressBookIssuesException;
}