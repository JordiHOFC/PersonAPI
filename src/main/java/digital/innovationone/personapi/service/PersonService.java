package digital.innovationone.personapi.service;

import digital.innovationone.personapi.dto.request.PersonDTO;
import digital.innovationone.personapi.dto.response.MessageResponseDTO;
import digital.innovationone.personapi.entity.Person;
import digital.innovationone.personapi.exception.PersonNotFoundException;
import digital.innovationone.personapi.mapper.PersonMapper;
import digital.innovationone.personapi.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

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

        return createMessage(savedPerson.getId(), "Create person with ID: ");

    }
    public List<PersonDTO> listAll(){
        List<Person> allPeople = personRepository.findAll();
        return allPeople.stream().map(personMapper::toDTO).collect(Collectors.toList());
    }

    public Person verifyExist(Long id) throws PersonNotFoundException{
        Person peopleExist= personRepository.findById(id).orElseThrow(()->new PersonNotFoundException(id));
        return peopleExist;
    }
    public PersonDTO findById(Long id) throws PersonNotFoundException {
        return personMapper.toDTO(verifyExist(id));

    }
    public void delete(Long id) throws PersonNotFoundException {
        verifyExist(id);
        personRepository.deleteById(id);
    }

    public MessageResponseDTO updateById(Long id, PersonDTO personDTO) throws PersonNotFoundException {
        verifyExist(id);
        Person personToUpdate= personMapper.toModel(personDTO);

        Person updatePerson=personRepository.save(personToUpdate);

        return createMessage(updatePerson.getId(), "Update person with ID: ");
    }

    private MessageResponseDTO createMessage(Long id, String s) {
        return MessageResponseDTO.builder().message(s + id).build();
    }
}
