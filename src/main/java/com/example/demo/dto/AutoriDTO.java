package com.example.demo.dto;

import com.example.demo.data.entity.Autori;
import lombok.Data;
import org.springframework.beans.BeanUtils;

import java.util.Set;
import java.util.stream.Collectors;


@Data
public class AutoriDTO {
    private Long autoreId;
    private String nomeCognome;
    private Set<LibriDTO> libro;

    public static AutoriDTO fromEntityToDTOWithoutLibri(Autori autore) {
        AutoriDTO dto = new AutoriDTO();
        BeanUtils.copyProperties(autore, dto,"libro");
        return dto;
    }

    public static AutoriDTO fromEntityToDTO(Autori autori) {
        AutoriDTO dto = new AutoriDTO();
        BeanUtils.copyProperties(autori, dto, "libro");
        dto.setLibro(autori.getLibro()
                .stream()
                .map(LibriDTO::fromEntityToDTO)
                .collect(Collectors.toSet()));
        return dto;
    }


    public static Autori fromDTOToEntity(AutoriDTO autore) {
        Autori dto = new Autori();
        BeanUtils.copyProperties(autore, dto,"libro");
        return dto;
    }
}
