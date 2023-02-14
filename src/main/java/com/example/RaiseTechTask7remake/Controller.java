package com.example.RaiseTechTask7remake;


import org.springframework.web.bind.annotation.*;


@RestController
public class Controller {
    @RequestMapping("/")
    public String home() {
        return "Hello World!";
    }
}