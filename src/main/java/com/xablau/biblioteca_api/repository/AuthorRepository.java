package com.xablau.biblioteca_api.repository;

import com.xablau.biblioteca_api.model.Author;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface AuthorRepository extends JpaRepository<Author, UUID> {
    boolean findByEmail(String email);
}
