package com.afvb.personApiExample.controllers.person;

import com.afvb.personApiExample.dto.MessageResponseDTO;
import com.afvb.personApiExample.models.person.Person;
import com.afvb.personApiExample.repositorys.person.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.NoSuchElementException;

@RestController
@RequestMapping("/api/v1/people")
public class PersonController {

    private PersonRepository personRepository;

    @Autowired
    public PersonController(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

   /* @GetMapping("/")
    public List<JornadaTrabalho> obterJornadas()
    {
        return jornadaTrabalhoService.ObterJornadas();
    }

    @GetMapping("/{id}")
    public ResponseEntity<JornadaTrabalho> obterJornadaPorId(@PathVariable("id") Long id) throws Exception
    {
        return ResponseEntity.ok(jornadaTrabalhoService.ObterJornadaPorId(id).orElseThrow(() -> new NoSuchElementException("Jornada não encontrada.")));
    }*/

    @PostMapping("/")
    public MessageResponseDTO createPerson(@RequestBody Person person)
    {
       Person savedPerson = personRepository.save(person);
       return MessageResponseDTO
               .builder()
               .message("Created Person with ID " + savedPerson.getId())
               .build();
    }

   /* @PutMapping("/")
    public JornadaTrabalho alterarJornada(@RequestBody JornadaTrabalho jornadaTrabalho) {

        return jornadaTrabalhoService.Atualizar(jornadaTrabalho);
    }

    @DeleteMapping("/{id}")
    public HttpStatus excluirJornada(@PathVariable("id") Long id) throws Exception
    {
        try{
            this.jornadaTrabalhoService.Exlcluir(id);
        }catch (Exception ex)
        {
            System.out.println(ex.getMessage());
            HttpStatus badRequest = HttpStatus.BAD_REQUEST;
            return badRequest;

        }
        HttpStatus accepted = HttpStatus.ACCEPTED;
        return accepted;
    }*/
}
