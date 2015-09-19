package com.northeast.saudeemdia.controller;

import com.northeast.saudeemdia.model.Person;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Guiga on 19/09/2015.
 */
public class PersonController {

    private static PersonController controller;

    private List<Person> persons;

    private PersonController () {
        persons = new ArrayList<>();
    }

    public void addPerson(String name, String address, String birthday, String sus) {
        Person person = new Person(name, address, birthday, sus);
        persons.add(person);
    }

    public void getPersons() {



    }

    public static PersonController getInstance() {
        if(controller == null) {
            controller = new PersonController();
        }
        return controller;
    }

}
