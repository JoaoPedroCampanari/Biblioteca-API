package com.xablau.biblioteca_api.dto.addressDtos;

import jakarta.validation.constraints.NotBlank;


public record AddressDto(
        String neighborhood,
        String street,
        String number) {
}
