package digital.innovationone.personapi.service;

import digital.innovationone.personapi.dto.request.PersonDTO;
import digital.innovationone.personapi.dto.response.MessageResponseDTO;
import digital.innovationone.personapi.entity.Person;
import digital.innovationone.personapi.mapper.PersonMapper;
import digital.innovationone.personapi.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PersonService {
    private PersonRepository personRepository;
    private final PersonMapper personMapper= PersonMapper.INSTANCE;

    @Autowired
    public PersonService(PersonRepository repository){
        this.personRepository=repository;
    }
    public MessageResponseDTO createPerson(PersonDTO personDTO){
        Person personToSave= personMapper.toModel(personDTO);
        Person savedPerson=personRepository.save(personToSave);
        return MessageResponseDTO.builder().message("Create person with ID: "+savedPerson.getId()).build();

    }

}
