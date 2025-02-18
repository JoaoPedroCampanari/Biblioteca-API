package com.xablau.biblioteca_api.service.interfaceService;

import com.xablau.biblioteca_api.dto.authorDtos.AuthorDto;
import com.xablau.biblioteca_api.model.Author;
import com.xablau.biblioteca_api.model.Book;

import java.util.List;
import java.util.UUID;

public interface AuthorService {

    Author findById(AuthorDto authorDto);

    List<Author> findAll();

    Author update(UUID id, AuthorDto authorDto);

    Author save(AuthorDto authorDto);

    void deleteById(UUID id);

    List<Book> findAllBooksAuthor(UUID id);
}
