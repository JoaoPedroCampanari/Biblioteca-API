package com.xablau.biblioteca_api.model;

import jakarta.persistence.*;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.UUID;

@Entity
@Table(name = "bookloan_tb")
@Getter
@Setter
@NoArgsConstructor
@EqualsAndHashCode(of = "id")
public class BookLoan {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
    private LocalDate loanDate = LocalDate.now();
    private LocalDate returnDate;
    private BigDecimal totalValue = BigDecimal.ZERO;
    @ManyToOne
    @JoinColumn(name = "client_id")
    private Client client;
    @ManyToOne
    @JoinColumn(name = "book_id")
    private Book book;

    public void setDefaultReturnDate(){
        returnDate = loanDate.plusMonths(1);
    }



}
