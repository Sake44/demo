package com.example.demo.service;

import com.example.demo.data.entity.Genere;
import com.example.demo.data.repository.GenereRepository;
import com.example.demo.dto.GenereDTO;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GenereService {
    private final GenereRepository genereRepository;

    public GenereService(GenereRepository genereRepository) {
        this.genereRepository = genereRepository;
    }

    /*
    * pattern repository
    * */
    public List<GenereDTO> getAll() {
        return genereRepository.findAll()
                .stream()
                .map(GenereDTO::fromEntityToDTO)
                .toList();
    }

    public GenereDTO getById(Long id) {
        return genereRepository.findById(id).map(GenereDTO::fromEntityToDTO).orElse(null);
    }

    public Boolean save(GenereDTO genere) {
        try {
            genereRepository.save(GenereDTO.fromDTOToEntity(genere));
        } catch(RuntimeException e) {
            System.out.println(e.getMessage());
            return false;
        }
        return true;
    }
}
