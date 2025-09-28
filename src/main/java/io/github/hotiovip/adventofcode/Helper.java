package io.github.hotiovip.adventofcode;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.nio.charset.StandardCharsets;

public class Helper {
    private static final Logger logger = LoggerFactory.getLogger(Helper.class);

    public static String readFile(String fileName) {
        try (var in = Helper.class.getResourceAsStream("/%s".formatted(fileName))) {
            assert in != null;
            return new String(in.readAllBytes(), StandardCharsets.UTF_8);
        }
        catch (IOException | NullPointerException e) {
            logger.error("An Exception occurred while trying to readFile() with name '{}': {}", fileName, e.getMessage());
            return null;
        }
    }

    public static int[] parseStringArrayToInt(String[] array) {
        int[] intArray = new int[array.length];
        for (int i = 0; i < array.length; i++) {
            intArray[i] = Integer.parseInt(array[i]);
        }
        return intArray;
    }
}
