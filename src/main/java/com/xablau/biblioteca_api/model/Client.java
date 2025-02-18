package com.xablau.biblioteca_api.model;

import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.*;

@Entity
@Table(name = "client_tb")
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
    private BigDecimal balance = BigDecimal.ZERO;
    //total de livros alugados
    private Integer totalLoanedBooks = 0;
    //Multas por atraso na devolução
    private BigDecimal totalFines = BigDecimal.ZERO;
    private Boolean activeStatus = true;
    private LocalDate registrationDate = LocalDate.now();
    @OneToMany(mappedBy = "client")
    private List<BookLoan> bookLoans = new ArrayList<>();
}
