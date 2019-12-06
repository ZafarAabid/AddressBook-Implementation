package com.addressbook.services;

import java.util.ArrayList;
import java.util.List;

public interface BookBehavior {

    public List readBook( );

    public void writeOnBook(ArrayList list);

    public ArrayList openBook();

    public void printAddressBookList();

    public void printAddressBook();



}
