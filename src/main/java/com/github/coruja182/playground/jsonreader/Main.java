package com.github.coruja182.playground.jsonreader;

import com.github.coruja182.playground.jsonreader.model.Person;
import com.github.coruja182.playground.jsonreader.reader.PersonJsonFileReader;
import java.io.File;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        if (args.length == 0) {
            System.err.println("ERROR: file was not provided as argument");
            System.exit(1);
        }

        final PersonJsonFileReader reader = new PersonJsonFileReader();
        final List<Person> people = reader.readFromFile(new File(args[0]));

        if (people != null && !people.isEmpty()) {
            for (int index = 0; index < people.size(); index++) {
                Person eachPerson = people.get(index);
                System.out.printf("%d : Name: %s, Height: %d%n", index, eachPerson.getName(), eachPerson.getHeight());
            }
        }
    }
}
