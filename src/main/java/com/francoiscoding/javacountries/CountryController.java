package com.francoiscoding.javacountries;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping("/names")
public class CountryController {
    // localhost:8080/names/all
    // Countries Alphabetically
    @RequestMapping(value = "/all")
    public ResponseEntity<?> getAllCountries() {
        JavaCountriesApplication.myCountryList.countryList.sort((c1, c2) -> c1.getName().compareToIgnoreCase(c2.getName()));
        return new ResponseEntity<>(JavaCountriesApplication.myCountryList.countryList, HttpStatus.OK);
    }

    // localhost:8080/names/start/a
    // Countries that start with given letter
    @GetMapping(value = "/start/{letter}")
    public ResponseEntity<?> getCountriesLetter(@PathVariable char letter) {

        ArrayList<Country> rtnCountries = JavaCountriesApplication.myCountryList.findCountries(c -> c.getName().toUpperCase().charAt(0) == Character.toUpperCase(letter));
        rtnCountries.sort((c1, c2) -> c1.getName().compareToIgnoreCase(c2.getName()));
        return new ResponseEntity<>(rtnCoun, HttpStatus.OK);
    }

    // localhost:8080/names/size/1
    // Countries with name longer than given length
    @GetMapping(value = "/size/{number}")
    public ResponseEntity<?> getCountriesNameSize(@PathVariable int number) {
        ArrayList<Country> rtnNames = JavaCountriesApplication.myCountryList.findCountries(c -> c.getName().length() >= number);
        rtnNames.sort((c1, c2) -> c1.getName().compareToIgnoreCase(c2.getName()));
        return new ResponseEntity<>(rtnNames, HttpStatus.OK);
    }
}