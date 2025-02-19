package com.xablau.biblioteca_api.repository;

import com.xablau.biblioteca_api.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface BookRepository extends JpaRepository<Book, UUID> {
}
