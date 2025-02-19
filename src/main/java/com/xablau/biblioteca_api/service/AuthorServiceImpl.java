package com.xablau.biblioteca_api.service;

import com.xablau.biblioteca_api.dto.authorDtos.AuthorDto;
import com.xablau.biblioteca_api.model.Author;
import com.xablau.biblioteca_api.model.Book;
import com.xablau.biblioteca_api.repository.AuthorRepository;
import com.xablau.biblioteca_api.service.interfaceService.AuthorService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class AuthorServiceImpl implements AuthorService {

    public AuthorServiceImpl(AuthorRepository authorRepository) {
        this.authorRepository = authorRepository;
    }

    private final AuthorRepository authorRepository;

    @Override
    public Author findById(AuthorDto authorDto) {
        return null;
    }

    @Override
    public List<Author> findAll() {
        return List.of();
    }

    @Override
    public Author update(UUID id, AuthorDto authorDto) {
        return null;
    }

    @Override
    public Author save(AuthorDto authorDto) {
        return null;
    }

    @Override
    public void deleteById(UUID id) {

    }

    @Override
    public List<Book> findAllBooksAuthor(UUID id) {
        return List.of();
    }
}
