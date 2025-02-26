package com.xablau.biblioteca_api.controller;

import com.xablau.biblioteca_api.dto.authorDtos.AuthorDto;
import com.xablau.biblioteca_api.dto.authorDtos.AuthorDtoUpdate;
import com.xablau.biblioteca_api.dto.authorDtos.AuthorResponse;
import com.xablau.biblioteca_api.dto.bookDtos.BookDtoResponse;
import com.xablau.biblioteca_api.service.interfaceService.AuthorService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/author")
public class AuthorController {

    private final AuthorService authorService;

    public AuthorController(AuthorService authorService) {
        this.authorService = authorService;
    }

    @GetMapping("{id}")
    public ResponseEntity<AuthorResponse> findById(@PathVariable(name = "id") UUID id){
        return ResponseEntity.status(HttpStatus.OK).body(new AuthorResponse(authorService.findById(id)));
    }

    @GetMapping
    public ResponseEntity<List<AuthorResponse>> findAll(){
        List<AuthorResponse> authorResponseList =
                authorService.findAll().stream().map(AuthorResponse::new).toList();
        return ResponseEntity.status(HttpStatus.OK).body(authorResponseList);
    }

    @GetMapping("{id}/books")
    public ResponseEntity<List<BookDtoResponse>> findAllBooksAuthor(@PathVariable(name = "id") UUID id){
        List<BookDtoResponse> bookDtoResponses = authorService.findAllBooksAuthor(id)
                .stream().map(BookDtoResponse::new).toList();
        return ResponseEntity.status(HttpStatus.OK).body(bookDtoResponses);
    }

    @PostMapping
    public ResponseEntity<AuthorResponse> save(@RequestBody @Valid AuthorDto authorDto){
        return ResponseEntity.status(HttpStatus.CREATED).body(new AuthorResponse(authorService.save(authorDto)));
    }

    @PutMapping
    public ResponseEntity<AuthorResponse> update(@RequestBody @Valid AuthorDtoUpdate authorDtoUpdate){
        return ResponseEntity.status(HttpStatus.OK).body(new AuthorResponse(authorService.update(authorDtoUpdate)));
    }

    @DeleteMapping
    public ResponseEntity<String> delete(UUID id){
        authorService.deleteById(id);
        return ResponseEntity.status(HttpStatus.OK).body("The author was successfully deleted");
    }



}
