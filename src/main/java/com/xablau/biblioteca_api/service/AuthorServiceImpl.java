package com.xablau.biblioteca_api.service;

import com.xablau.biblioteca_api.dto.authorDtos.AuthorDto;
import com.xablau.biblioteca_api.dto.authorDtos.AuthorDtoUpdate;
import com.xablau.biblioteca_api.exception.authorExceptions.AuthorEmailAreadyExist;
import com.xablau.biblioteca_api.exception.authorExceptions.AuthorNotFoundException;
import com.xablau.biblioteca_api.model.Author;
import com.xablau.biblioteca_api.model.Book;
import com.xablau.biblioteca_api.repository.AuthorRepository;
import com.xablau.biblioteca_api.service.interfaceService.AuthorService;
import org.springframework.beans.BeanUtils;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Set;
import java.util.UUID;

@Service
public class AuthorServiceImpl implements AuthorService {

    public AuthorServiceImpl(AuthorRepository authorRepository) {
        this.authorRepository = authorRepository;
    }

    private final AuthorRepository authorRepository;

    @Transactional(readOnly = true)
    @Override
    public Author findById(UUID id) {
        return authorRepository.findById(id)
                .orElseThrow(() -> new AuthorNotFoundException("Author doesn't exist", HttpStatus.NOT_FOUND));
    }

    @Transactional(readOnly = true)
    @Override
    public List<Author> findAll() {
        return authorRepository.findAll();
    }

    @Transactional
    @Override
    public Author update(AuthorDtoUpdate authorDtoUpdate) {
        Author author = authorRepository.findById(authorDtoUpdate.id())
                .orElseThrow(() -> new AuthorNotFoundException("Author doesn't exist", HttpStatus.NOT_FOUND));
        if (authorRepository.existsByEmail(authorDtoUpdate.email())){
            throw new AuthorEmailAreadyExist("Author email already exist", HttpStatus.CONFLICT);
        }
        author.atualizarDados(authorDtoUpdate);
        return author;
    }

    @Transactional
    @Override
    public Author save(AuthorDto authorDto) {
        if (authorRepository.existsByEmail(authorDto.email())){
            throw new AuthorEmailAreadyExist("Author email already exist", HttpStatus.CONFLICT);
        }
        Author author = new Author(authorDto);

        return authorRepository.save(author);
    }

    @Transactional
    @Override
    public void deleteById(UUID id) {
        try{
            authorRepository.deleteById(id);
        }catch (EmptyResultDataAccessException ex){
            throw new AuthorNotFoundException("Author doesn't exist", HttpStatus.NOT_FOUND);
        }
    }

    @Transactional(readOnly = true)
    @Override
    public Set<Book> findAllBooksAuthor(UUID id) {
        if (!authorRepository.existsById(id)){
            throw new AuthorNotFoundException("Author doesn't exist", HttpStatus.NOT_FOUND);
        }
        return authorRepository.getReferenceById(id).getBooks();
    }
}
