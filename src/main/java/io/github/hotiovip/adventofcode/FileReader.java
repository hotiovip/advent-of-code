package io.github.hotiovip.adventofcode;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.nio.charset.StandardCharsets;

public class FileReader {
    private static final Logger logger = LoggerFactory.getLogger(FileReader.class);

    public static String readFile(String fileName) {
        try (var in = FileReader.class.getResourceAsStream("/%s".formatted(fileName))) {
            assert in != null;
            return new String(in.readAllBytes(), StandardCharsets.UTF_8);
        }
        catch (IOException | NullPointerException e) {
            logger.error("An Exception occurred while trying to readFile() with name '{}': {}", fileName, e.getMessage());
            return null;
        }
    }
}
