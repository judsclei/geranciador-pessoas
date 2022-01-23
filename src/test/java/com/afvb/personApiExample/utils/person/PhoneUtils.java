package com.afvb.personApiExample.utils.person;

import com.afvb.personApiExample.dto.request.person.PhoneDTO;
import com.afvb.personApiExample.enums.person.PhoneType;
import com.afvb.personApiExample.models.person.Phone;

public class PhoneUtils {

    private static final String PHONE_NUMBER = "(31)99777-2989";
    private static final PhoneType PHONE_TYPE = PhoneType.cell;
    private static final long PHONE_ID = 1L;

    public static PhoneDTO fakePhoneDTO(){
        return PhoneDTO.builder()
                .number(PHONE_NUMBER)
                .type(PHONE_TYPE)
                .build();
    }

    public static Phone fakePhone(){
        return Phone.builder()
                .id(PHONE_ID)
                .number(PHONE_NUMBER)
                .type(PHONE_TYPE)
                .build();
    }
}
