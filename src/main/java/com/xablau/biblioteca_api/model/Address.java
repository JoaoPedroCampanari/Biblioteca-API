package com.xablau.biblioteca_api.model;

import com.xablau.biblioteca_api.dto.addressDtos.AddressDto;
import jakarta.persistence.Embeddable;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Embeddable
public class Address {

    private String neighborhood;
    private String street;
    private String number;

    public void atualizarDados(AddressDto addressDto) {
        if (addressDto.neighborhood() != null){
            this.neighborhood = addressDto.neighborhood();
        }
        if (addressDto.number() != null){
            this.number = addressDto.number();
        }
        if (addressDto.street() != null){
            this.street = addressDto.street();
        }
    }
}
