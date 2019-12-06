package com.addressbook.test;

import com.addressbook.model.Person;
import com.addressbook.services.ActionOnBook;
import com.addressbook.services.ActionOnPerson;
import org.junit.Assert;
import org.junit.Test;

import java.io.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class AddressBookImplementationTests {
    ActionOnPerson actionOnPerson =new ActionOnPerson();
    ActionOnBook actionOnBook = new ActionOnBook();
    @Test
    public void whileCreatingContact_ifSuccessfullyCreated_returnTrue() {
        Person person = new Person("zafar","Xfr","8087241183","mmb","Mh",100070);
        Assert.assertEquals("zafar",person.getFirstName());
    }

    @Test
    public void givenPersonDetails_ifSuccessfullyAdded_returnTrue() {
        Person person =new Person("zafar","Xfr","8087241183","mmb","Mh",100070);
        List<Person> list=actionOnPerson.addPerson(person);
        Iterator iterator=list.iterator();
        for (Person persons:list) {
            System.out.println(persons.toString());
        }
    }

    @Test
    public void givenPersonDetails_ifSuccessfullyEdited_returnTrue() {
        Person person =new Person("zafar","Xfr","8087241183","mmb","Mh",100070);
        Assert.assertTrue(actionOnPerson.editPerson("zafar","XfR",new Person("11111","newCity","newState",0000)));
        List<Person> list =actionOnBook.readBook();
        Iterator iterator=list.iterator();
        for (Person persons:list) {
            System.out.println(persons.toString());
        }
    }
    @Test
    public void givenPersonDetails_ifSuccessfullyAdd_returnTrue() {
        Person person =new Person("zafar","Xfr","8087241183","mmb","Mh",100070);
        List<Person> list=actionOnPerson.addPerson(person);
        Iterator iterator=list.iterator();
        for (Person persons:list) {
            System.out.println(persons.toString());
        }
    }


    @Test
    public void givenPersonDetails_ifSuccessfullyDeleted_returnTrue() {
        new Person("zafar","Xfr","8087241183","mmb","Mh",100070);
        boolean flag=actionOnPerson.deletePerson("8087241183");
        List<Person> list =actionOnBook.readBook();
        Iterator iterator=list.iterator();
        for (Person persons:list) {
            System.out.println(persons.toString());
        }
        Assert.assertTrue(flag);
    }


    @Test
    public void givenPersonDetails_sortByLastName() {
        List<Person> list =actionOnPerson.sortByName();
        Iterator iterator=list.iterator();
        for (Person persons:list) {
            System.out.println(persons.toString());
        }

    }

    @Test
    public void givenPersonDetails_sortByZipCode() {
        List<Person> list =actionOnPerson.sortByZipCode();
        Iterator iterator=list.iterator();
        for (Person persons:list) {
            System.out.println(persons.toString());
        }

    }
    
    @Test
    public void givenFileName_ifExist_writeOnIt_elseCreateNewFile() throws IOException {

        String str=actionOnBook.createAdressBook("newAddressBook");
        Assert.assertTrue(new File(str).exists());
    }

    @Test
    public void OpenBookByPassingFileName() {
        List<Person> list= actionOnBook.openBook("AddressBook.json");
        Iterator iterator=list.iterator();
        for (Person persons:list) {
            System.out.println(persons.toString());
        }

    }

    @Test
    public void useSaveAs_IfFilenameSuccessfullychanged_returnTrue() throws IOException {
        Assert.assertTrue(actionOnBook.saveAndSaveAs("newAddressBook","newOne"));
    }
}
