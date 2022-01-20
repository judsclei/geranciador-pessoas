package com.afvb.personApiExample.repositorys.person;

import com.afvb.personApiExample.models.person.Person;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonRepository extends JpaRepository<Person, Long> {
}
