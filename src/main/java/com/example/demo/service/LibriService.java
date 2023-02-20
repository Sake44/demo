package com.example.demo.service;

import com.example.demo.data.repository.LibriRepository;
import com.example.demo.dto.LibriDTO;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LibriService {
    private final LibriRepository libriRepository;

    public LibriService(LibriRepository libriRepository) {
        this.libriRepository = libriRepository;
    }

    public List<LibriDTO> getAll() {
        return libriRepository.findAll().stream().map(LibriDTO::fromEntityToDTO).toList();
    }

    public LibriDTO getById(Long id) {
        return libriRepository.findById(id).map(LibriDTO::fromEntityToDTO).orElse(null);
    }

    public Boolean save(LibriDTO libro) {
        try{
            libriRepository.save(LibriDTO.fromDTOToEntity(libro));
        } catch(RuntimeException e) {
            System.out.println(e.getMessage());
            return false;
        }
        return true;
    }
}
