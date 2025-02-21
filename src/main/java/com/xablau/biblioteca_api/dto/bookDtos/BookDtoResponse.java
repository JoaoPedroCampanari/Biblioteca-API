package com.xablau.biblioteca_api.dto.bookDtos;

import com.xablau.biblioteca_api.model.Book;
import com.xablau.biblioteca_api.model.Category;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.UUID;

public record BookDtoResponse(
        UUID id,
        String name,
        Category category,
        Integer quantity,
        LocalDate publishedYear,
        BigDecimal value) {
    public BookDtoResponse(Book book){
        this(book.getId(),book.getName(),book.getCategory()
                ,book.getQuantity(),book.getPublishedYear()
                ,book.getValue());
    }
}
