package com.xablau.biblioteca_api.dto.authorDtos;

import com.xablau.biblioteca_api.dto.addressDtos.AddressDto;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Email;

import java.util.UUID;

public record AuthorDtoUpdate(
        UUID id,
        String name,
        Integer age,
        @Email(message = "Email must have valid format")
        String email,
        @Valid
        AddressDto addressDto) {
}
