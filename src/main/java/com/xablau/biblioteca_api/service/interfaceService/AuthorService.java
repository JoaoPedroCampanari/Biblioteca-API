package com.xablau.biblioteca_api.service.interfaceService;

import com.xablau.biblioteca_api.dto.authorDtos.AuthorDto;
import com.xablau.biblioteca_api.dto.authorDtos.AuthorDtoUpdate;
import com.xablau.biblioteca_api.model.Author;
import com.xablau.biblioteca_api.model.Book;

import java.util.List;
import java.util.Set;
import java.util.UUID;

public interface AuthorService {

    Author findById(UUID id);

    List<Author> findAll();

    Author update(AuthorDtoUpdate authorDtoUpdate);

    Author save(AuthorDto authorDto);

    void deleteById(UUID id);

    Set<Book> findAllBooksAuthor(UUID id);
}
