package com.example.demo.data.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.Hibernate;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "AUTORI")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Autori implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "AUTORE_ID")
    private Long autoreId;

    @Column(name = "NOME_COGNOME")
    private String nomeCognome;

    @OneToMany(mappedBy = "autore", fetch = FetchType.LAZY)
    private Set<Libri> libro;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        Autori autori = (Autori) o;
        return autoreId != null && Objects.equals(autoreId, autori.autoreId);
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}
