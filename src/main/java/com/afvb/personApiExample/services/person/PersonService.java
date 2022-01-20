package com.afvb.personApiExample.services.person;

import com.afvb.personApiExample.models.person.Person;
import com.afvb.personApiExample.repositorys.person.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PersonService {

  /*  @Autowired
    PersonRepository personRepository;

    public List<Person> GetPersons()
    {
        return personRepository.findAll();
    }

    public Optional<JornadaTrabalho> ObterJornadaPorId(Long id)
    {
        return jornadaTrabalhoRepository.findById(id);
    }

    public JornadaTrabalho Cadastrar(JornadaTrabalho jornadaTrabalho)
    {
        return jornadaTrabalhoRepository.save(jornadaTrabalho);
    }

    public JornadaTrabalho Atualizar(JornadaTrabalho jornadaTrabalho)
    {
        return jornadaTrabalhoRepository.save(jornadaTrabalho);
    }

    public void Exlcluir(Long id)
    {
        jornadaTrabalhoRepository.deleteById(id);
    }*/
}
