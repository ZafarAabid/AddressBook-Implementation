package com.addressbook.test;

import com.addressbook.model.Person;
import com.addressbook.services.ActionOnBook;
import com.addressbook.services.ActionOnPerson;
import com.addressbook.services.AddressBookIssuesException;
import org.junit.Assert;
import org.junit.Test;

import java.io.*;
import java.util.List;

public class AddressBookImplementationTests {
    ActionOnPerson actionOnPerson = new ActionOnPerson();
    ActionOnBook actionOnBook = new ActionOnBook();

    @Test
    public void whileCreatingContact_ifSuccessfullyCreated_returnTrue() {
        Person person = new Person("zafar", "Xfr", "8087241183", "mmb", "Mh", 100070);
        Assert.assertEquals("zafar", person.getFirstName());
    }

    @Test
    public void givenPersonDetails_ifSuccessfullyAdded_returnTrue() {
        Person person = new Person("zafar", "Xfr", "8087241183", "mmb", "Mh", 100070);
        List<Person> list = null;
        try {
            list = actionOnPerson.addPerson(person);
        } catch (AddressBookIssuesException e) {
            Assert.assertEquals(e.type, AddressBookIssuesException.type);
        }
    }

    @Test
    public void givenPersonDetails_ifSuccessfullyEdited_returnTrue() {
        Person person = new Person("zafar", "Xfr", "8087241183", "mmb", "Mh", 100070);
        List<Person> list = null;
        try {
            Assert.assertTrue(actionOnPerson.editPerson("zafar", "XfR", new Person("11111", "newCity", "newState", 111111)));
            list = actionOnBook.readBook();
        } catch (AddressBookIssuesException e) {
            Assert.assertEquals(e.type, AddressBookIssuesException.type);
        }
    }

    @Test
    public void givenPersonDetails_ifSuccessfullyAdd_returnTrue() {
        Person person = new Person("zafar", "Xfr", "8087241183", "mmb", "Mh", 100070);
        List<Person> list = null;
        try {
            list = actionOnPerson.addPerson(person);
        } catch (AddressBookIssuesException e) {
            Assert.assertEquals(e.type, AddressBookIssuesException.type);
        }
    }


    @Test
    public void givenPersonDetails_ifSuccessfullyDeleted_returnTrue() {
        new Person("zafar", "Xfr", "8087241183", "mmb", "Mh", 100070);
        boolean flag = false;
        List<Person> list = null;
        try {
            flag = actionOnPerson.deletePerson("8087241183");
            list = actionOnBook.readBook();
        } catch (AddressBookIssuesException e) {
            Assert.assertTrue(flag);
        }
    }

    @Test
    public void givenPersonDetails_sortByLastName() {
        List<Person> list = null;
        try {
            list = actionOnPerson.sortByName();
            Assert.assertEquals("aabid", list.get(0).getLastName());
        } catch (AddressBookIssuesException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void givenPersonDetails_sortByZipCode() {
        try {
            List<Person> list = actionOnPerson.sortByZipCode();
            Assert.assertEquals(111111, (int) list.get(0).getZipCode());
        } catch (AddressBookIssuesException e) {
            Assert.assertEquals(e.type, AddressBookIssuesException.type);
        }
    }

    @Test
    public void givenFileName_ifExist_writeOnIt_elseCreateNewFile() {
        String str = null;
        try {
            str = actionOnBook.createAdressBook("newAddressBook");
        } catch (AddressBookIssuesException e) {
            Assert.assertTrue(new File(str).exists());
        }
    }

    @Test
    public void OpenBookByPassingFileName_IfWrong_ThrowsException() {
        try {
            List<Person> list = actionOnBook.openBook("AddressBook.json");

        } catch (AddressBookIssuesException e) {
            Assert.assertEquals(e.type,AddressBookIssuesException.type);
        }
    }

    @Test
    public void OpenBookByPassingFileName_ifImproper_throwsException() {
        try {
            List<Person> list = actionOnBook.openBook("AddressBook");
        } catch (AddressBookIssuesException e) {
            Assert.assertEquals("skjbchksbcdnkswb", e.type);
        }
    }

    @Test
    public void useSaveAs_IfFilenameSuccessfullychanged_returnTrue() throws IOException {
        Assert.assertTrue(actionOnBook.saveAndSaveAs("newAddressBook", "newOne"));
    }
}
