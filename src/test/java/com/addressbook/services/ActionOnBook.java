package com.addressbook.services;

import com.addressbook.model.Person;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class ActionOnBook implements BookBehavior{

    public ActionOnBook() {}
    public ActionOnBook(String path) {this.path = path; }

    String path = "/home/user/workspace/AddressBookImplementation/src/test/java/AddressBook.json";
    static ObjectMapper mapper= new ObjectMapper();

    @Override
    public ArrayList readBook() {
        try {

            InputStream fileInputStream = new FileInputStream(new File(path));
            TypeReference<List<Person>> typeReference = new TypeReference<List<Person>>() {};
            ArrayList<Person> persons= mapper.readValue(fileInputStream,typeReference);
            return persons;
        } catch (FileNotFoundException e) {
            System.out.println("EXCEPTION:"+e.getMessage());
            e.printStackTrace();
        } catch (JsonParseException e) {
            System.out.println("EXCEPTION:"+e.getMessage());
            e.printStackTrace();
        } catch (JsonMappingException e) {
            e.printStackTrace();
            System.out.println("EXCEPTION:"+e.getMessage());
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public void writeOnBook(ArrayList list) {
            File file =new File("/home/user/workspace/AddressBookImplementation/src/test/java/AddressBook.json");
        try {
            mapper.writerWithDefaultPrettyPrinter().writeValue(file,list);
        } catch (IOException e) {
            System.out.println("EXCEPTION:"+e.getMessage());
        }
    }
    @Override
    public ArrayList openBook() {
        return null;
    }
    @Override
    public void printAddressBookList() {

    }
    @Override
    public void printAddressBook() {

    }
}
