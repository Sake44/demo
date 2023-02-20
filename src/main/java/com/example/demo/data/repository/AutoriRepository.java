package com.example.demo.data.repository;

import com.example.demo.data.entity.Autori;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AutoriRepository extends JpaRepository<Autori, Long> {


}
