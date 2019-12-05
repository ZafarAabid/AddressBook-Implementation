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

    static ObjectMapper mapper= new ObjectMapper();
    @Override
    public ArrayList readBook() {
        try {

         //   mapper.disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES);
            InputStream fileInputStream = new FileInputStream(new File("/home/user/workspace/AddressBookImplementation/src/test/java/AddressBook.json"));
            TypeReference<List<Person>> typeReference = new TypeReference<List<Person>>() {};
            ArrayList<Person> persons= mapper.readValue(fileInputStream,typeReference);

            return persons;
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (JsonParseException e) {
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
}
