package com.example.demo.data.entity;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.Hibernate;

import javax.persistence.*;
import java.io.Serial;
import java.io.Serializable;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "GENERE")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Genere implements Serializable {

    @Serial
    private static final long serialVersionUID = -1156119935328999897L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "GENERE_ID")
    private Long genereId;

    @Column(name = "GENERE")
    private String genere;

    @ManyToMany(mappedBy = "genere", fetch = FetchType.LAZY)
    private Set<Libri> libri;


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        Genere genere = (Genere) o;
        return genereId != null && Objects.equals(genereId, genere.genereId);
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}
