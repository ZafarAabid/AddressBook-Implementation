package com.addressbook.services;

import java.util.ArrayList;

public interface BookBehavior {

    public ArrayList readBook( );

    public void writeOnBook(ArrayList list);

    public ArrayList openBook();

    public void printAddressBookList();

    public void printAddressBook();



}
