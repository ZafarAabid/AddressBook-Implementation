package com.addressbook.test;

import com.addressbook.model.Person;
import com.addressbook.services.ActionOnPerson;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Iterator;

public class AddressBookImplementationTests {
    ActionOnPerson actionOnPerson =new ActionOnPerson();
    @Test
    public void whileCreatingContact() {
        Person person = new Person("zafar","Xfr","8087241183","mmb","Mh",100070);
        Assert.assertEquals("zafar",person.getFirstName());
    }

    @Test
    public void givenPersonDetails_ifSuccessfullyAdded_returnTrue() {
        Person person =new Person("zafar","Xfr","8087241183","mmb","Mh",100070);
        ArrayList list=actionOnPerson.addPerson(person);
        Iterator iterator=list.iterator();
        while (iterator.hasNext())
        {
            Person person1= (Person) iterator.next();
            System.out.println(person1.getFirstName());
        }

        }
    }
