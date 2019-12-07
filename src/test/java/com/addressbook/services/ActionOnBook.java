package com.addressbook.services;

import com.addressbook.model.Person;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;

import java.io.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ActionOnBook implements BookBehavior {


    public ActionOnBook() {
    }

    public ActionOnBook(String path) {
        this.lastopenedFilepath = path;
    }

    static String lastopenedFilepath = "/home/user/workspace/AddressBookImplementation/src/books/AddressBook.json";
    static ObjectMapper mapper = new ObjectMapper();

    @Override
    public List<Person> readBook() throws AddressBookIssuesException {
        try {
            List<Person> personList = new ArrayList<>();
            Gson gson = new Gson();
            BufferedReader bufferedReader = new BufferedReader(new FileReader(lastopenedFilepath));
            Person[] peoples = gson.fromJson(bufferedReader, Person[].class);
            for (int i = 0; i < peoples.length; i++) {
                personList.add(peoples[i]);
            }
            return personList;
        } catch (FileNotFoundException e) {
            throw new AddressBookIssuesException("Error while Writing into a file", AddressBookIssuesException.ExceptionType.NO_SUCH_FILE);
        }
    }

    @Override
    public void writeOnBook(List<Person> list) throws AddressBookIssuesException {
        File file = new File("/home/user/workspace/AddressBookImplementation/src/books/AddressBook.json");
        try {
            mapper.writerWithDefaultPrettyPrinter().writeValue(file, list);
        } catch (IOException e) {
            throw new AddressBookIssuesException("Error while Writing into a file", AddressBookIssuesException.ExceptionType.NO_SUCH_FILE);
        }
    }


    @Override
    public void printAddressBook() throws AddressBookIssuesException {
        List<Person> list = readBook();
        Iterator printlistIterator = list.iterator();
        while (printlistIterator.hasNext()) {
            Person person = (Person) printlistIterator.next();
            System.out.println(person.toString());
        }
    }

    @Override
    public String createAdressBook(String fileName) throws AddressBookIssuesException {
        String path = "/home/user/workspace/AddressBookImplementation/src/books/" + fileName + ".json";
        if (new File(path).exists()) {
            return path;
        } else {
            File file = new File(path);
            try {
                file.createNewFile();
                FileWriter writer;
                writer = new FileWriter(file);
                writer.write("[]");
                writer.flush();
            } catch (IOException e) {
                throw new AddressBookIssuesException("Book name/path is improper OR issue with IO binding", AddressBookIssuesException.ExceptionType.NO_SUCH_FILE);
            }

        }
        return path;
    }


    @Override
    public List<Person> openBook(String fileName) throws AddressBookIssuesException {

        List<Person> list = new ArrayList<>();
        if (new File("/home/user/workspace/AddressBookImplementation/src/books/" + fileName).exists()) {
            lastopenedFilepath = "/home/user/workspace/AddressBookImplementation/src/books/" + fileName;
        }
        list = readBook();
        return list;
    }


    public Boolean saveAndSaveAs(String oldName, String newName) throws IOException {
        File oldFile = new File("/home/user/workspace/AddressBookImplementation/src/books/" + oldName + ".json");
        if (oldFile.exists()) {
            File newFile = new File("/home/user/workspace/AddressBookImplementation/src/books/" + newName + ".json");
            oldFile.renameTo(newFile);
        }
        if (new File("/home/user/workspace/AddressBookImplementation/src/books/" + newName + ".json").exists())
            return true;
        else return false;
    }
}
