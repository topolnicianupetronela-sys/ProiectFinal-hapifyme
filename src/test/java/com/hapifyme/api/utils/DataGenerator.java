package com.hapifyme.api.utils;

import com.github.javafaker.Faker;

public class DataGenerator {

    private static final Faker faker = new Faker();

    public static String randomEmail() {
        return "test_user_" + System.currentTimeMillis() + "@test.com";
    }

    public static String randomName() {
        return faker.name().fullName();
    }
}