package com.example.demo.data.repository;

import com.example.demo.data.entity.Libri;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LibriRepository extends JpaRepository<Libri, Long> {


}
