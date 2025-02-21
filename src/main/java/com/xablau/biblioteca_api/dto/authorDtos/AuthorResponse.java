package com.xablau.biblioteca_api.dto.authorDtos;

import com.xablau.biblioteca_api.model.Author;
import jakarta.validation.constraints.Email;

import java.util.UUID;

public record AuthorResponse(
        UUID id,
        String name,
        Integer age,
        String email,
        Integer totalLoanedBooks) {
    public AuthorResponse (Author author){
        this(author.getId(), author.getName(), author.getAge(), author.getEmail(), author.getTotalloanedbooks());
    }
}
