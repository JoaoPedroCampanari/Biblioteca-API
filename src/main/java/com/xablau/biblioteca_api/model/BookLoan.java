package com.xablau.biblioteca_api.model;

import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.UUID;

@Entity
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
    private Client client;
    @ManyToOne
    private Book book;

    public void setReturnDate(){
        returnDate = loanDate.plusMonths(1);
    }



}
