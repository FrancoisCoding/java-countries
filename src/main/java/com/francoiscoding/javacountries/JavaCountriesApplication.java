package com.francoiscoding.javacountries;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class JavaCountriesApplication {

    public static CountryList countries;

    public static void main(String[] args) {
        countries = new CountryList();
        SpringApplication.run(JavaCountriesApplication.class, args);
    }

}
