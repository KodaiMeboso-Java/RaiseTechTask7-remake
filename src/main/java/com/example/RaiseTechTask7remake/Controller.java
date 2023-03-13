package com.example.RaiseTechTask7remake;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;

import java.util.List;
import java.util.Map;

import org.springframework.web.util.UriComponentsBuilder;


@RestController
public class Controller {
    @RequestMapping("/")
    public String home() {
        String greeting = "Hello World!";
        return greeting;
    }

    @GetMapping("/names")
    public List<String> getName() {
        return List.of("アバン", "ダイ");
    }

    @PostMapping("/names")
    public ResponseEntity<String> create(@RequestBody CreateForm form) {
        URI url = UriComponentsBuilder.fromUriString("http://localhost:8080")
                .path("/names/id") // id部分は実際に登録された際に発⾏したidを設定する
                .build()
                .toUri();
        return ResponseEntity.created(url).body("name successfully created");
    }

    @PatchMapping("/names/{id}")
    public ResponseEntity<Map<String, String>> update(@PathVariable("id") int id, @RequestBody UpdateForm form) {
        return ResponseEntity.ok(Map.of("message", "name successfully updated"));
    }

    @DeleteMapping("/names/{id}")
    public ResponseEntity<String> delete(@PathVariable("id") int id) {
        return ResponseEntity.ok("name successfully deleted");
    }

}