package com.xablau.biblioteca_api.dto.authorDtos;

import com.xablau.biblioteca_api.dto.addressDtos.AddressDto;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;

import java.util.UUID;

public record AuthorDtoUpdate(
        @NotNull(message = "Id must not be null")
        UUID id,
        String name,
        Integer age,
        @Email(message = "Email must have valid format")
        String email,
        AddressDto addressDto) {
}
