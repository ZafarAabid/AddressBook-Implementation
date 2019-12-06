package com.addressbook.services;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public interface BookBehavior {

    public List readBook( );

    public void writeOnBook(ArrayList list);

    public List openBook();

    public void printAddressBookList();

    public void printAddressBook();

     public String checkFileAvailability(String fileName);
}
