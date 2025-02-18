package com.xablau.biblioteca_api.dto.addressDtos;

import jakarta.validation.constraints.NotBlank;


public record AddressDto(
        @NotBlank(message = "The neighborhood field must not be null")
        String neighborhood,
        @NotBlank(message = "the street field must not be null")
        String street,
        @NotBlank(message = "the number field must not be null")
        String number) {
}
