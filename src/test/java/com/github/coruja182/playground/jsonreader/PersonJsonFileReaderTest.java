package com.github.coruja182.playground.jsonreader;

import com.github.coruja182.playground.jsonreader.model.Person;
import java.io.File;
import java.util.List;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class PersonJsonFileReaderTest {

    private static final File resourcesDirectory = new File("src/test/resources");
    private final PersonJsonFileReader personJsonFileReader = new PersonJsonFileReader();

    @Test
    @DisplayName("GIVEN an input file IT SHOULD be able to parse correctly")
    public void jsonFileIsParsedOk() {
        // data
        final File inputFile = new File(resourcesDirectory, "input-test.json");

        // the actual class to be tested
        List<Person> people = personJsonFileReader.readFromFile(inputFile);

        // assertions
        Assertions.assertEquals(2, people.size());

        Assertions.assertEquals("Coruja One Eight Two", people.get(0).getName());
        Assertions.assertEquals(182, people.get(0).getHeight());

        Assertions.assertEquals("Son Goku", people.get(1).getName());
        Assertions.assertEquals(175, people.get(1).getHeight());
    }

    @Test
    @DisplayName("GIVEN a not readable file IT SHOULD throw a RuntimeException")
    public void fileDoesNotExistShouldThrowException() {
        Assertions.assertThrows(RuntimeException.class, () -> {
            personJsonFileReader.readFromFile(new File("this-file-does-not-exist.json"));
        });
    }
}
