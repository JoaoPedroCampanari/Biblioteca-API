package com.xablau.biblioteca_api.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of = "id")
public class Author {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
    private String name;
    @Embedded
    private Address address;
    private Integer totalLoanedBooks;
    @ManyToMany(mappedBy = "authors")
    private Set<Book> books = new HashSet<>();
}
