package com.springboot.springbootrestservice.controller;

import com.springboot.springbootrestservice.model.Tovar;
import com.springboot.springbootrestservice.service.TovarService;
import org.springframework.beans.factory.annotation.*;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
public class TovarController {
    private final TovarService tovarService;

    @Autowired
    public TovarController(TovarService tovarService) {
        this.tovarService = tovarService;
    }

    @PostMapping(value = "/tovars")
    public ResponseEntity<?> create(@RequestBody Tovar tovar) {
        tovarService.create(tovar);
        tovarService.save_tovars();
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @GetMapping(value = "/tovars")
    public ResponseEntity<List<Tovar>> read() {
        final List<Tovar> tovars = tovarService.readAll();

        return tovars != null &&  !tovars.isEmpty()
                ? new ResponseEntity<>(tovars, HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @GetMapping(value = "/about")
    public ResponseEntity<?> about(String text) {
        text = "About us";
        final String about = tovarService.about(text);

        return about != null && !about.isEmpty()
                ? new ResponseEntity<>(about, HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @GetMapping(value = "/tovars/{id}")
    public ResponseEntity<Tovar> read(@PathVariable(name = "id") int id) {
        final Tovar tovar = tovarService.read(id);

        return tovar != null
                ? new ResponseEntity<>(tovar, HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PutMapping(value = "/tovars/{id}")
    public ResponseEntity<?> update(@PathVariable(name = "id") int id, @RequestBody Tovar tovar) {
        final boolean updated = tovarService.update(tovar, id);
        tovarService.save_tovars();
        return updated
                ? new ResponseEntity<>(HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_MODIFIED);
    }

    @DeleteMapping(value = "/tovars/{id}")
    public ResponseEntity<?> delete(@PathVariable(name = "id") int id) {
        final boolean deleted = tovarService.delete(id);
        tovarService.save_tovars();
        return deleted
                ? new ResponseEntity<>(HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_MODIFIED);
    }
}
