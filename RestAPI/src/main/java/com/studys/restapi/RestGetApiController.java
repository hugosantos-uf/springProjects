package com.studys.restapi;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;

@RestController
public class RestGetApiController {

    @GetMapping("/greet")
    public String greet(){
        return "Hello";
    }

    @GetMapping("/greet/{name}")
    public String greetWithName(@PathVariable String name){
        return "Hello " + name;
    }

    @GetMapping("/meet")
    public String meet(@RequestParam(defaultValue = "guest") String name){
        return "Hello " + name;
    }

    @GetMapping("/status")
    public ResponseEntity<String> customResponse(){
        return new ResponseEntity<>("Custom Response with Status ACCEPTE",
                HttpStatus.ACCEPTED);
    }

    @GetMapping("/person")
    public ResponseEntity<Person> personResponseEntity() {
        Person person = new Person("Hugo", 22, "hugosantos.email", true, Arrays.asList("cience","software enginner"));
        return new ResponseEntity<>(person, HttpStatus.OK);
    }

    @GetMapping("/person/{id}")
    public ResponseEntity<Person> getPersonById(
            @PathVariable("id") Long id,
            @RequestParam(value = "includeEmail", defaultValue = "true") boolean includeEmail
    ) {
        Person person = new Person("Hugo", 22, includeEmail ? "hugosantos.email" : null, true, Arrays.asList("cience","software enginner"));
        return new ResponseEntity<>(person, HttpStatus.OK);
    }
}
