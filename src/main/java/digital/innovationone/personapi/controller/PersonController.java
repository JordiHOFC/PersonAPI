package digital.innovationone.personapi.controller;

import digital.innovationone.personapi.dto.request.PersonDTO;
import digital.innovationone.personapi.dto.response.MessageResponseDTO;
import digital.innovationone.personapi.entity.Person;
import digital.innovationone.personapi.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/v1/people")
public class PersonController {

    private PersonService personService;

    @Autowired
    public PersonController(PersonService service){
        this.personService=service;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public MessageResponseDTO createPerson(@RequestBody @Valid PersonDTO personDTO){
        return personService.createPerson(personDTO);

    }
}