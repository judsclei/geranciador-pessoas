package com.afvb.personApiExample.service.person;

import com.afvb.personApiExample.dto.MessageResponseDTO;
import com.afvb.personApiExample.dto.request.person.PersonDTO;
import com.afvb.personApiExample.models.person.Person;
import com.afvb.personApiExample.repositorys.person.PersonRepository;
import com.afvb.personApiExample.services.person.PersonService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import static com.afvb.personApiExample.utils.person.PersonUtils.fakePerson;
import static com.afvb.personApiExample.utils.person.PersonUtils.fakePersonDTO;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class PersonServiceTest {

    @Mock
    private PersonRepository personRepository;

    @InjectMocks
    private PersonService personService;

    @Test
    void testGivenPersonDTOThenReturnSavedMessage() {
        PersonDTO personDTO = fakePersonDTO();
        Person expectedSavedPerson = fakePerson();

        when(personRepository.save(any(Person.class))).thenReturn(expectedSavedPerson);

        MessageResponseDTO expectedsuccesMessage = createExpectedMethodResponse(expectedSavedPerson.getId(), "\"Created Person with ID \"");

        MessageResponseDTO succesMessage = personService.Create(personDTO);

        assertEquals(expectedsuccesMessage, succesMessage);
    }

    private MessageResponseDTO createExpectedMethodResponse(Long id, String message) {
        return MessageResponseDTO
                .builder()
                .message( message + id)
                .build();
    }
}
