package com.addressbook.test;

import com.addressbook.model.Person;
import com.addressbook.services.ActionOnBook;
import com.addressbook.services.ActionOnPerson;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Iterator;

public class AddressBookImplementationTests {
    ActionOnPerson actionOnPerson =new ActionOnPerson();
    ActionOnBook actionOnBook = new ActionOnBook();
    @Test
    public void whileCreatingContact() {
        Person person = new Person("zafar","Xfr","8087241183","mmb","Mh",100070);
        Assert.assertEquals("zafar",person.getFirstName());
    }

    @Test
    public void givenPersonDetails_ifSuccessfullyAdded_returnTrue() {
        Person person =new Person("zafar","Xfr","8087241183","mmb","Mh",100070);
        ArrayList<Person> list=actionOnPerson.addPerson(person);
        Iterator iterator=list.iterator();
        for (Person persons:list) {
            System.out.println(persons.toString());
        }
        }

    @Test
    public void givenPersonDetails_ifSuccessfullyEdited_returnTrue() {
        Person person =new Person("zafar","Xfr","8087241183","mmb","Mh",100070);
        Assert.assertTrue(actionOnPerson.editPerson("zafar","XfR",new Person("11111","newCity","newState",0000)));
        ArrayList<Person> list =actionOnBook.readBook();
        Iterator iterator=list.iterator();
        for (Person persons:list) {
            System.out.println(persons.toString());
        }
    }

    @Test
    public void givenPersonDetails_ifSuccessfullyDeleted_returnTrue() {
        new Person("zafar","Xfr","8087241183","mmb","Mh",100070);
        boolean flag=actionOnPerson.deletePerson("8087241183");
        ArrayList<Person> list =actionOnBook.readBook();
        Iterator iterator=list.iterator();
        for (Person persons:list) {
            System.out.println(persons.toString());
        }
        Assert.assertTrue(flag);
    }



    }
