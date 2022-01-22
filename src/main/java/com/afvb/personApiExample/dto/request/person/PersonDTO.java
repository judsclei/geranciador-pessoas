package com.afvb.personApiExample.dto.request.person;

import com.afvb.personApiExample.models.person.Phone;
import lombok.*;
import org.hibernate.validator.constraints.br.CPF;

import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import java.time.LocalDate;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@Builder
public class PersonDTO {

    private Long id;

    @NotEmpty
    @Size(min = 2, max = 60)
    private String firstName;

    @NotEmpty
    @Size(min = 2, max = 60)
    private String lastName;

    @NotEmpty
    @CPF
    private String cpf;

    private String birthDate;

    @Valid
    @NotEmpty
    private List<Phone> phones;
}
