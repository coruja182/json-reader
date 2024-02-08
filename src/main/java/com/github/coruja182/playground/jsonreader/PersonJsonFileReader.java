package com.github.coruja182.playground.jsonreader;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.coruja182.playground.jsonreader.model.Person;
import java.io.File;
import java.io.IOException;
import java.util.List;

public class PersonJsonFileReader {

    final ObjectMapper objectMapper;

    public PersonJsonFileReader() {
        this.objectMapper = new ObjectMapper();
    }

    public List<Person> readFromFile(final File inputFile) {
        if (inputFile == null || !inputFile.canRead()) {
            throw new RuntimeException("File does not exist or is not readable");
        }

        try {
            return objectMapper.readValue(inputFile, new TypeReference<>() {

            });
        } catch (IOException e) {
            throw new RuntimeException("JSON file is not parseable", e);
        }
    }
}
