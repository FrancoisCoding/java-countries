package com.francoiscoding.javacountries;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping("/population")
public class CountryPopController {
    // localhost:8080/population/size/100
    // Countries greater than population given
    @GetMapping(value = "/size/{people}")
    public ResponseEntity<?> getCountriesPopSize(@PathVariable long people) {
        ArrayList<Country> rtnPop = JavaCountriesApplication.myCountryList.findCountries(c -> c.getPopulation() >= people);
        rtnPop.sort((c1, c2) -> c1.getName().compareToIgnoreCase(c2.getName()));
        return new ResponseEntity<>(rtnPop, HttpStatus.OK);
    }

    // localhost:8080/population/min
    // Country with smallest population
    @GetMapping(value = "/min")
    public Country getMinPop() {
        long min = 1000000000;
        Country selectedcountry = null;

        for (Country c : JavaCountriesApplication.myCountryList.countryList) {
            if (c.getPopulation() <= min) {
                min = c.getPopulation();
                selectedcountry = c;
            }
        }
        return selectedcountrycountry;
    }

    // localhost:8080/population/max
    // Country with the largest population
    @GetMapping(value = "/max")
    public Country getMaxPop() {
        long max = 0;
        Country country = null;

        for (Country c : JavaCountriesApplication.myCountryList.countryList) {
            if (c.getPopulation() > max) {
                max = c.getPopulation();
                country = c;
            }
        }
        return thisCountry;
    }
}