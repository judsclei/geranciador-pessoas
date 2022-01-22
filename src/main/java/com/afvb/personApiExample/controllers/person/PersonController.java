package com.afvb.personApiExample.controllers.person;

import com.afvb.personApiExample.dto.MessageResponseDTO;
import com.afvb.personApiExample.dto.request.person.PersonDTO;
import com.afvb.personApiExample.exception.person.PersonNotFoundException;
import com.afvb.personApiExample.services.person.PersonService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/v1/people")
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class PersonController {

    private PersonService personService;

    @GetMapping("/")
    public List<PersonDTO> getPersons()
    {
        return personService.GetPersons();
    }

    @GetMapping("/{id}")
    public PersonDTO getById(@PathVariable("id") Long id) throws PersonNotFoundException
    {
        return personService.GetPersonById(id);
    }

    @PostMapping("/")
    @ResponseStatus(HttpStatus.CREATED)
    public MessageResponseDTO createPerson(@RequestBody @Valid PersonDTO personDTO)
    {
       return personService.Create(personDTO);
    }

   @PutMapping("/{id}")
    public MessageResponseDTO updatePerson(@PathVariable Long id, @RequestBody @Valid PersonDTO personDTO) throws PersonNotFoundException
   {

        return personService.Update(id, personDTO);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deletePerson(@PathVariable("id") Long id) throws PersonNotFoundException
    {
        personService.Delete(id);
    }
}
