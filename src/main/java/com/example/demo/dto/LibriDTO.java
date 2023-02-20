package com.example.demo.dto;

import com.example.demo.data.entity.Libri;
import lombok.Data;
import org.springframework.beans.BeanUtils;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

@Data
public class LibriDTO {
    private Long libriId;
    private String titolo;
    private Date data;
    private String trama;
    private String cover;
    private Set<GenereDTO> genere;
    private AutoriDTO autore;

    public LibriDTO() {
        this.genere = new HashSet<>();
    }

    public static LibriDTO fromEntityToDTO(Libri libri) {
        System.out.println(libri.getAutore());
        LibriDTO dto = new LibriDTO();
        BeanUtils.copyProperties(libri, dto, "genere", "autore");
        if (libri.getGenere() != null)
            dto.setGenere(libri.getGenere().stream()
                    .map(GenereDTO::fromEntityToDTOWithoutLibri)
                    .collect(Collectors.toSet()));
        if(libri.getAutore() != null)
            dto.setAutore(AutoriDTO.fromEntityToDTOWithoutLibri(libri.getAutore()));
        return dto;
    }

    public static LibriDTO fromEntityToDTOWithoutGenere(Libri libri) {
        LibriDTO dto = new LibriDTO();
        BeanUtils.copyProperties(libri, dto, "genere","autore");
        if(libri.getAutore() != null)
            dto.setAutore(AutoriDTO.fromEntityToDTOWithoutLibri(libri.getAutore()));
        return dto;
    }

    public static Libri fromDTOToEntity(LibriDTO libro) {
        Libri entity = new Libri();
        BeanUtils.copyProperties(libro, entity, "genere", "autore");
        if (libro.getGenere() != null)
            entity.setGenere(libro.getGenere().stream()
                    .map(GenereDTO::fromDTOToEntity)
                    .collect(Collectors.toSet()));
        if(libro.getAutore() != null)
            entity.setAutore(AutoriDTO.fromDTOToEntity(libro.getAutore()));
        return entity;
    }
}
