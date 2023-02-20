package com.example.demo.controller;

import com.example.demo.dto.LibriDTO;
import com.example.demo.model.ResponseMessageModel;
import com.example.demo.service.LibriService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/api/v1/libri")
public class LibriController {

    private final LibriService libriService;

    public LibriController(LibriService libriService) {
        this.libriService = libriService;
    }

    @GetMapping(value = "/get-all")
    public ResponseEntity<List<LibriDTO>> getAll() {
        return ResponseEntity.ok(libriService.getAll());
    }

    @GetMapping(value = "/get-by-id")
    public ResponseEntity<LibriDTO> getByID(@RequestParam Long id) {
        return ResponseEntity.ok(libriService.getById(id));
    }

    @PostMapping(value = "/save")
    public ResponseEntity<ResponseMessageModel> save(@RequestBody LibriDTO libro){
        if(Boolean.TRUE.equals(libriService.save(libro)))
            return ResponseEntity.ok(new ResponseMessageModel(true, "Libro salvato con successo"));
        return ResponseEntity.ok(new ResponseMessageModel(false, "Errore nel salvataggio del libro"));
    }



}
