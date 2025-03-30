package com.studys.restapi;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RestGetApiController {

    @GetMapping("/greet")
    public String greet(){
        return "Hello";
    }

    @GetMapping("/status")
    public ResponseEntity<String> customResponse(){
        return new ResponseEntity<>("Custom Response with Status ACCEPTE",
                HttpStatus.ACCEPTED);
    }
}
