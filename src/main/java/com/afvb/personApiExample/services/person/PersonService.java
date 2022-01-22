package com.afvb.personApiExample.services.person;

import com.afvb.personApiExample.dto.MessageResponseDTO;
import com.afvb.personApiExample.dto.request.person.PersonDTO;
import com.afvb.personApiExample.exception.person.PersonNotFoundException;
import com.afvb.personApiExample.mapper.person.PersonMapper;
import com.afvb.personApiExample.models.person.Person;
import com.afvb.personApiExample.repositorys.person.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class PersonService {

    @Autowired
    PersonRepository personRepository;

    private  final PersonMapper personMapper = PersonMapper.INSTANCE;

    public List<PersonDTO> GetPersons()
    {
        List<Person> allPeople = personRepository.findAll();
        return allPeople.stream()
                .map(personMapper::toDTO)
                .collect(Collectors.toList());
    }

    public PersonDTO GetPersonById(Long id) throws PersonNotFoundException
    {
        Person person = verifyIfExists(id);
        return personMapper.toDTO(person);
    }

    public MessageResponseDTO Create(PersonDTO personDTO)
    {
        Person personSave = personMapper.toModel(personDTO);
        Person savedPerson = personRepository.save(personSave);
        return createMethodResponse (savedPerson.getId(), "\"Created Person with ID \"" );
    }

    public MessageResponseDTO Update(Long id ,PersonDTO personDTO) throws PersonNotFoundException
    {
        verifyIfExists(id);
        Person personUpdate = personMapper.toModel(personDTO);
        Person updatedPerson = personRepository.save(personUpdate);
        return createMethodResponse(updatedPerson.getId() , "\"Updated Person with ID \"");
    }

    public void Delete(Long id) throws PersonNotFoundException
    {
        verifyIfExists(id);
        personRepository.deleteById(id);
    }

    private MessageResponseDTO createMethodResponse(long id, String message) {
        return MessageResponseDTO
                .builder()
                .message( message + id)
                .build();
    }

    private Person verifyIfExists(Long id) throws PersonNotFoundException {
        return personRepository.findById(id)
                .orElseThrow(() -> new PersonNotFoundException(id));
    }
}
