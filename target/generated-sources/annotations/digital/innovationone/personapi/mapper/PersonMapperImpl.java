package digital.innovationone.personapi.mapper;

import digital.innovationone.personapi.dto.request.PersonDTO;
import digital.innovationone.personapi.dto.request.PersonDTO.PersonDTOBuilder;
import digital.innovationone.personapi.dto.request.PhoneDTO;
import digital.innovationone.personapi.dto.request.PhoneDTO.PhoneDTOBuilder;
import digital.innovationone.personapi.entity.Person;
import digital.innovationone.personapi.entity.Person.PersonBuilder;
import digital.innovationone.personapi.entity.Phone;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2020-12-20T15:56:10-0300",
    comments = "version: 1.4.1.Final, compiler: javac, environment: Java 11.0.9.1 (Oracle Corporation)"
)
public class PersonMapperImpl implements PersonMapper {

    @Override
    public Person toModel(PersonDTO personDTO) {
        if ( personDTO == null ) {
            return null;
        }

        PersonBuilder person = Person.builder();

        if ( personDTO.getBirthDate() != null ) {
            person.birthDate( LocalDate.parse( personDTO.getBirthDate(), DateTimeFormatter.ofPattern( "dd-MM-yyyy" ) ) );
        }
        if ( personDTO.getId() != null ) {
            person.id( personDTO.getId() );
        }
        person.firstName( personDTO.getFirstName() );
        person.lastName( personDTO.getLastName() );
        person.cpf( personDTO.getCpf() );

        return person.build();
    }

    @Override
    public PersonDTO toDTO(Person person) {
        if ( person == null ) {
            return null;
        }

        PersonDTOBuilder personDTO = PersonDTO.builder();

        personDTO.id( person.getId() );
        personDTO.firstName( person.getFirstName() );
        personDTO.lastName( person.getLastName() );
        personDTO.cpf( person.getCpf() );
        if ( person.getBirthDate() != null ) {
            personDTO.birthDate( DateTimeFormatter.ISO_LOCAL_DATE.format( person.getBirthDate() ) );
        }
        personDTO.phones( phoneListToPhoneDTOList( person.getPhones() ) );

        return personDTO.build();
    }

    protected PhoneDTO phoneToPhoneDTO(Phone phone) {
        if ( phone == null ) {
            return null;
        }

        PhoneDTOBuilder phoneDTO = PhoneDTO.builder();

        phoneDTO.id( phone.getId() );
        phoneDTO.type( phone.getType() );
        phoneDTO.number( phone.getNumber() );

        return phoneDTO.build();
    }

    protected List<PhoneDTO> phoneListToPhoneDTOList(List<Phone> list) {
        if ( list == null ) {
            return null;
        }

        List<PhoneDTO> list1 = new ArrayList<PhoneDTO>( list.size() );
        for ( Phone phone : list ) {
            list1.add( phoneToPhoneDTO( phone ) );
        }

        return list1;
    }
}
