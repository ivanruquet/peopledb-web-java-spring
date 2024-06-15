package com.ruquet.peopledb_web.web.controller;

import com.ruquet.peopledb_web.biz.model.Person;
import com.ruquet.peopledb_web.data.PersonRepository;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/people")
public class PeopleController {

    private PersonRepository personRepository;

    public PeopleController(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    @ModelAttribute("people")
    public Iterable<Person> getPeople(){
        return personRepository.findAll();
    }

    @GetMapping()
    public String showPeoplePage() {
        return "people";
    }

    @ModelAttribute
    public Person getPerson(){
        return new Person();
    }

    @PostMapping
    public String savePerson(@Valid Person person, Errors errors){

        if (!errors.hasErrors()) {
            personRepository.save(person);
            return "redirect:people";
        }
        return "people";
    }


    @PostMapping(params = "delete=true")
    public String deletePeople(@RequestParam Optional<List<Long>> selections){
        if (selections.isPresent()){
            personRepository.deleteAllById(selections.get());
        }
        return "redirect:people";

    }

    @PostMapping(params = "edit=true")
    public String updatePerson(@RequestParam Optional<List<Long>> selections, Model model){
        if (selections.isPresent()){
            Optional<Person> person = personRepository.findById(selections.get().get(0));
            model.addAttribute(person.get());
        }
        return "people";
    }

}
