package com.example.controllers;


import com.example.contract.AddressDto;
import com.example.contract.PersonDto;
import com.example.services.PersonService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class PersonController {
    private PersonService service;
    @RequestMapping(value = "/api/v1/person", method = RequestMethod.GET)
    public List<PersonDto> getAll(){
        return service.getAll();
    }
    @RequestMapping(value = "/api/v1/person", method = RequestMethod.POST)
    public void save(@RequestBody PersonDto person){
        service.save(person);
    }

    @RequestMapping(value = "api/v1/person/{id}", method = RequestMethod.GET)
    public PersonDto getPerson(@PathVariable Integer id){
        return service.getbyId(id);
    }

    @RequestMapping(value = "api/v1/person/{id}", method = RequestMethod.PUT)
    public void updatePerson(@PathVariable Integer id){
    }

    @RequestMapping(value = "api/v1/person/{id}", method = RequestMethod.DELETE)
    public void deletePerson(@PathVariable Integer id){
        service.delete(id);
    }

    @RequestMapping(value = "api/v1/person/{id}/addresses", method = RequestMethod.GET)
    public List<AddressDto> getAddresses(@PathVariable Integer id){
        return service.getAddresses(id);
    }

    @RequestMapping(value = "api/v1/person/{id}/addresses", method = RequestMethod.POST)
    public void addAddresses(@PathVariable Integer id, AddressDto address){
        service.addAddress(id, address);
    }
}
