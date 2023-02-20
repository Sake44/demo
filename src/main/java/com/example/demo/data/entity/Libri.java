package com.example.demo.data.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.Hibernate;

import javax.persistence.*;
import java.io.Serial;
import java.io.Serializable;
import java.util.Date;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "LIBRI")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Libri implements Serializable {

    @Serial
    private static final long serialVersionUID = 8174169075513562327L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "LIBRI_ID")
    private Long libriId;

    @Column(name = "TITOLO")
    private String titolo;

    @Column(name = "DATA")
    private Date data;

    @Column(name = "TRAMA")
    private String trama;

    @Column(name = "COVER")
    private String cover;

    @ManyToMany(cascade = CascadeType.ALL)
    private Set<Genere> genere;

    @ManyToOne
    @JoinColumn(name = "AUTORE_ID")
    private Autori autore;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        Libri libri = (Libri) o;
        return libriId != null && Objects.equals(libriId, libri.libriId);
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}
