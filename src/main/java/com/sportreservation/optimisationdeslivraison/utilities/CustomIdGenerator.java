package com.sportreservation.optimisationdeslivraison.utilities;
import org.apache.commons.lang3.RandomStringUtils;

import java.util.Random;

public class CustomIdGenerator {
    private static final int ID_LENGTH = 8;
    private static final Random RANDOM = new Random();

    public static String generateIdp() {
        return String.format("%0" + ID_LENGTH + "d", RANDOM.nextInt((int) Math.pow(10, ID_LENGTH)));
    }
    public static String generateId() {
        return RandomStringUtils.randomAlphanumeric(8).toUpperCase();
    }
}
