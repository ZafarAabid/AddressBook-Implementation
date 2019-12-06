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

    String lastopenedFilepath = "/home/user/workspace/AddressBookImplementation/src/books/AddressBook.json";
    static ObjectMapper mapper = new ObjectMapper();
    ActionOnBook actionOnBook;


    @Override
    public List<Person> readBook() {
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
            System.out.println("EXCEPTION:" + e.getMessage());
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public void writeOnBook(List<Person> list) {
        File file = new File("/home/user/workspace/AddressBookImplementation/src/books/AddressBook.json");
        try {
            mapper.writerWithDefaultPrettyPrinter().writeValue(file, list);
        } catch (IOException e) {
            System.out.println("EXCEPTION:" + e.getMessage());
        }
    }

    @Override
    public void printAddressBook() {
        List<Person> list = actionOnBook.readBook();
        Iterator printlistIterator = list.iterator();
        while (printlistIterator.hasNext()) {
            Person person = (Person) printlistIterator.next();
            System.out.println(person.toString());
        }
    }

    @Override
    public String createAdressBook(String fileName) {
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
                e.printStackTrace();
            }

        }
        return path;
    }


    @Override
    public List<Person> openBook(String fileName) {

        List<Person> list = new ArrayList();
        if (new File("/home/user/workspace/AddressBookImplementation/src/books/" + fileName).exists()) {
            lastopenedFilepath = "/home/user/workspace/AddressBookImplementation/src/books/" +fileName;
        }
         list = actionOnBook.readBook();
        return list;
    }

}
