package com.example.raisetechtask7remake;

import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class NameController {
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
    public ResponseEntity<String> postName(@RequestParam String name) {
        if (name.length() > 20) {
            return ResponseEntity.badRequest().body("nameは20文字以内");
        }
        return ResponseEntity.ok("Hello, " + name + "!");
    }

    @PatchMapping("/names/{id}")
    public ResponseEntity<Map<String, String>> update(
            @PathVariable("id") int id,
            @Validated @RequestBody UpdateForm form) {
        return ResponseEntity.ok(Map.of("message", "name successfully updated"));
    }

    @DeleteMapping("/names/{id}")
    public ResponseEntity<String> delete(@PathVariable("id") int id) {
        return ResponseEntity.ok("name successfully deleted");
    }

}
