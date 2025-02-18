package com.xablau.biblioteca_api.entity;

import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.UUID;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of = "id")
public class Client {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
    private String name;
    @Embedded
    private Address address;
    private String phoneNumber;
    private BigDecimal balance;
    //total de livros emprestrados
    private Integer totalLoanedBooks;
    //Multas por atraso na devolução
    private BigDecimal totalFines;
    private Boolean activeStatus;
    private LocalDate registrationDate;
}
