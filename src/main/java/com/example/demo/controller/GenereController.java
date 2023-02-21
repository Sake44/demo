package com.example.demo.controller;

import com.example.demo.dto.GenereDTO;
import com.example.demo.model.ResponseMessageModel;
import com.example.demo.service.GenereService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/genere")
public class GenereController {

    private final GenereService genereService;

    public GenereController(GenereService genereService) {
        this.genereService = genereService;
    }

    @GetMapping(value = "/get-all")
    public ResponseEntity<List<GenereDTO>> getAll() {
        return ResponseEntity.ok(genereService.getAll());
    }

    @GetMapping(value = "/get-by-id")
    public ResponseEntity<GenereDTO> getById(@RequestParam Long id) {
        return ResponseEntity.ok(genereService.getById(id));
    }

    @PostMapping(value = "/save")
    public ResponseEntity<ResponseMessageModel> save(@RequestBody GenereDTO genereDTO) {
        if(Boolean.TRUE.equals(genereService.save(genereDTO)))
            return ResponseEntity.ok(new ResponseMessageModel(true, "Genere salvato correttamente"));
        return ResponseEntity.ok(new ResponseMessageModel(false, "Errore nel salvataggio del genere"));
    }

    @PostMapping(value = "/delete-by-id")
    public ResponseEntity<ResponseMessageModel> delete(@RequestParam Long id) {
        if(Boolean.TRUE.equals(genereService.deleteById(id)))
            return ResponseEntity.ok(new ResponseMessageModel( true, "Genere eliminato correttamente"));
        return ResponseEntity.ok(new ResponseMessageModel(false, "Errore nell'eliminazione del genere"));

    }
}
