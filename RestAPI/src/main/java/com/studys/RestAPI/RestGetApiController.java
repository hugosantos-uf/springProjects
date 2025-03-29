package com.studys.RestAPI;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RestGetApiController {

    @GetMapping("/greet")
    public String greet(){
        return "Hello";
    }
}
