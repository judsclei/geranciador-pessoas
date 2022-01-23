package com.afvb.personApiExample.utils.person;

import com.afvb.personApiExample.dto.request.person.PersonDTO;
import com.afvb.personApiExample.dto.request.person.PhoneDTO;
import com.afvb.personApiExample.models.person.Person;
import com.afvb.personApiExample.models.person.Phone;

import java.time.LocalDate;
import java.util.Collections;
import java.util.List;

import static java.util.Collections.singletonList;

public class PersonUtils {

    private static final String FIRST_NAME = "Jose";
    private static final String LAST_NAME = "da Silva";
    private static final String CPF_NUMBER = "741.963.987-56";
    private static final long PERSON_ID = 1L;
    public static  final LocalDate BIRTH_DATE = LocalDate.of(1999, 05, 15);

    public static PersonDTO fakePersonDTO(){
        return PersonDTO.builder()
                .firstName(FIRST_NAME)
                .lastName(LAST_NAME)
                .cpf(CPF_NUMBER)
                .birthDate("15-05-1999")
                .phones(singletonList(PhoneUtils.fakePhone()))
                .build();
    }


    public static Person fakePerson()
    {
        return Person.builder()
                .id(PERSON_ID)
                .firstName(FIRST_NAME)
                .lastName(LAST_NAME)
                .cpf(CPF_NUMBER)
                .birthDate(BIRTH_DATE)
                .phones(singletonList(PhoneUtils.fakePhone()))
                .build();
    }
}
