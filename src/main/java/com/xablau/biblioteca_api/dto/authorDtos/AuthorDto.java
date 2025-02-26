package com.xablau.biblioteca_api.dto.authorDtos;


import com.xablau.biblioteca_api.dto.addressDtos.AddressDto;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record AuthorDto(
        @NotBlank(message = "The name field must not be null")
        String name,
        @NotNull
        Integer age,
        @NotBlank(message = "The email field must not be null")
        @Email(message = "Email must have valid format")
        String email,
        @Valid
        @NotNull(message = "Address must not be null")
        AddressDto addressDto) {
}
