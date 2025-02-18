package com.xablau.biblioteca_api.service.interfaceService;

import com.xablau.biblioteca_api.dto.authorDtos.AuthorDto;
import com.xablau.biblioteca_api.model.Author;

import java.util.List;
import java.util.UUID;

public interface AuthorService {

    Author getById(AuthorDto authorDto);

    List<Author> getAll();

    Author updateById(UUID id, AuthorDto authorDto);

}
