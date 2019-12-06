
package com.addressbook.services;

import com.addressbook.model.Person;

import java.util.List;

public interface BookBehavior {

    public List<Person> readBook( );

    public void writeOnBook( List<Person> list);

    public List<Person> openBook(String filename);

    public void printAddressBook();

    public String createAdressBook(String fileName);
}