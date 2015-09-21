package com.northeast.saudeemdia.controller;

import com.northeast.saudeemdia.model.ChildPerson;
import com.northeast.saudeemdia.model.DiabeticPerson;
import com.northeast.saudeemdia.model.HypertensionPerson;
import com.northeast.saudeemdia.model.Person;
import com.northeast.saudeemdia.model.PregnantPerson;

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

    public void addPerson(Person person) {
        persons.add(person);
    }

    public List<Person> getPersons() {


        return persons;
    }


    public List<Person> getPersonsByCategory(String category) {
        List<Person> filterPersons = new ArrayList<>();
        for (Person p : persons) {
            if(category.equals("Hipertensos") && p instanceof HypertensionPerson) {
                filterPersons.add(p);
            } else if(category.equals("Diabeticos") && p instanceof DiabeticPerson) {
                filterPersons.add(p);
            } else if(category.equals("Criancas") && p instanceof ChildPerson) {
                filterPersons.add(p);
            } else if(category.equals("Gestantes") && p instanceof PregnantPerson) {
                filterPersons.add(p);
            }
        }

        return filterPersons;
    }

    public static PersonController getInstance() {
        if(controller == null) {
            controller = new PersonController();
        }
        return controller;
    }

}
