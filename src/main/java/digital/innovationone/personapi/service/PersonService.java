package digital.innovationone.personapi.service;

import digital.innovationone.personapi.dto.MessageResponseDTO;
import digital.innovationone.personapi.entity.Person;
import digital.innovationone.personapi.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

@Service
public class PersonService {
    private PersonRepository personRepository;

    @Autowired
    public PersonService(PersonRepository repository){
        this.personRepository=repository;
    }
    public MessageResponseDTO createPerson(Person person){
        Person savedPerson= personRepository.save(person);
        return MessageResponseDTO.builder().message("Create person with ID: "+savedPerson.getId()).build();

    }

}
