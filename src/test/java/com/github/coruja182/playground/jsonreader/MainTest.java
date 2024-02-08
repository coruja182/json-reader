package com.github.coruja182.playground.jsonreader;

import java.io.File;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class MainTest {

    private static final File resourcesDirectory = new File("src/test/resources");

    @Test
    void successTest() {
        final File inputFile = new File(resourcesDirectory, "input-test.json");
        Assertions.assertTrue(inputFile.canRead());
        Main.main(new String[] {inputFile.getAbsolutePath()});
    }

    @Test
    void errorTest() {
        final File inputFile = new File(resourcesDirectory, "file-does-not-exist.json");
        Assertions.assertThrows(RuntimeException.class, () -> {
            Main.main(new String[] {inputFile.getAbsolutePath()});
        });
    }
}
