package com.example.demo.service;

import com.example.demo.data.repository.AutoriRepository;
import com.example.demo.dto.AutoriDTO;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AutoriService {

    private final AutoriRepository autoriRepository;

    public AutoriService(AutoriRepository autoriRepository) {
        this.autoriRepository = autoriRepository;
    }

    public List<AutoriDTO> getAll() {
        return autoriRepository.findAll()
                .stream()
                .map(AutoriDTO::fromEntityToDTO)
                .toList();
    }

    public AutoriDTO getById(Long id) {
        return autoriRepository.findById(id).map(AutoriDTO::fromEntityToDTO).orElse(null);
    }

    public Boolean save(AutoriDTO autori) {
        try {
            autoriRepository.save(AutoriDTO.fromDTOToEntity(autori));
        } catch(RuntimeException e) {
            System.out.println(e.getMessage());
            return false;
        }
        return true;
    }


}
