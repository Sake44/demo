package com.example.demo.dto;

import com.example.demo.data.entity.Genere;
import com.example.demo.data.entity.Libri;
import lombok.Data;
import org.springframework.beans.BeanUtils;

import java.util.Set;
import java.util.stream.Collectors;

@Data
public class GenereDTO {
    private Long genereId;
    private String genere;
    private Set<LibriDTO> libri;

    public static GenereDTO fromEntityToDTO(Genere genere) {
        GenereDTO dto = new GenereDTO();
        BeanUtils.copyProperties(genere, dto,"libri");
        if(genere.getLibri() != null)
            dto.setLibri(genere.getLibri().stream()
                    .map(LibriDTO::fromEntityToDTOWithoutGenere).collect(Collectors.toSet()));
        return dto;
    }

    public static Genere fromDTOToEntity(GenereDTO dto) {
        Genere entity = new Genere();
        BeanUtils.copyProperties(entity, dto,"libri");
        return entity;
    }

    public static GenereDTO fromEntityToDTOWithoutLibri(Genere genere) {
        GenereDTO dto = new GenereDTO();
        BeanUtils.copyProperties(genere, dto,"libri");
        return dto;
    }
}
