
package com.capgemini.serviciosya.controller;


import com.capgemeini.serviciosya.beans.entity.CountryEntity;
import com.capgemeini.serviciosya.dao.ICountryDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;



@RestController
@RequestMapping ("countries")
public class CountryController {


    @Autowired
    private ICountryDao countryDao;


    public CountryController () {

        super ();
    }


    @RequestMapping (method = RequestMethod.GET, produces={MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<?> get () {

        // Return the value.
        return ResponseEntity.ok (this.countryDao.findAll ());
    }

    @RequestMapping (value = "/{id}", method = RequestMethod.GET, produces={MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<?> get (@PathVariable("id") Integer id) {


        CountryEntity c = this.countryDao.findOne (id);

        if (c == null) {

            return ResponseEntity.notFound().build();

        } else {

            return ResponseEntity.ok (this.countryDao.findOne (id));
        }
    }
}