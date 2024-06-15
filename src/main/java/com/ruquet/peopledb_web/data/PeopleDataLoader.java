package com.ruquet.peopledb_web.data;

import com.ruquet.peopledb_web.biz.model.Person;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

//@Component
public class PeopleDataLoader implements ApplicationRunner {

    private PersonRepository personRepository;

    public PeopleDataLoader(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    @Override
    public void run(ApplicationArguments args) throws Exception {
        if (personRepository.count()==0) {
            List<Person> people = List.of(
                    new Person(null, "Juan", "Ruquet", LocalDate.of(1996, 06, 22), new BigDecimal("50000"), "testpeople@email.com"),
                    new Person(null, "Ivan", "Ruquet", LocalDate.of(1996, 06, 22), new BigDecimal("20"), "testpeople@email.com"),
                    new Person(null, "Alan", "Ruquet", LocalDate.of(1996, 06, 22), new BigDecimal("60"), "testpeople@email.com"),
                    new Person(null, "Crack", "Ruquet", LocalDate.of(1996, 06, 22),   new BigDecimal("150000"), "testpeople@email.com")
            );
            personRepository.saveAll(people);
        }
    }
}
