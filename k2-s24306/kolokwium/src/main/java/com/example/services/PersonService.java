package com.example.services;

import com.example.contract.AddressDto;
import com.example.contract.PersonDto;
import com.example.model.Address;
import com.example.model.Person;
import com.example.repositories.AddressRepository;
import com.example.repositories.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class PersonService {
    @Autowired
    private PersonRepository personRepository;
    @Autowired
    private AddressRepository addressRepository;

    public List<PersonDto> getAll(){
        List<PersonDto> personList = new ArrayList<>();
        for(Person p: personRepository.findAll()){
            personList.add(new PersonDto(p.getId(), p.getFirstName(), p.getLastName()));
        }
        return personList;
    }

    public PersonDto getbyId(int id){
        var person = personRepository.findById(id);
        return null;
        //return person;
        //return personRepository.findById(id);
    }

    public void save(PersonDto person){
        personRepository.save(new Person(person.getId(), person.getFirst_name(), person.getLast_name()));
    }

    public void delete(int personId){
        personRepository.deleteById(personId);
    }

    public void update(int personId, PersonDto person){
        Optional<Person> p = personRepository.findById(person.getId());
        p.setFirst_name(person.getFirst_name());
        p.setLast_name(person.getLast_name());
        personRepository.save(p);
    }

    public void addAddress(int personId, AddressDto address){
        var p = personRepository.findById(personId);
        var ad = new Address();
        ad.setId(address.getId());
        ad.setCity(address.getCity());
        ad.setStreet(address.getStreet());
        ad.setPostalCode(address.getPostal_code());
        ad.setPerson(p);
        p.getAdress().add(ad);
        personRepository.save(p);
        addressRepository.save(ad);
    }

    public List<AddressDto> getAddresses(int personId){
        List<AddressDto> addresses = new ArrayList<>();
        var person = personRepository.findById(personId);
        var address = person.getAddress();
        for(Address a: address){
            addresses.add(new AddressDto(a.getId(),
                                         a.getCity(),
                                         a.getStreet(),
                                         a.getPostalCode()));
        }
        return addresses;
    }
}
