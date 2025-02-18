package com.xablau.biblioteca_api.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

@Entity
@Table(name = "author_tb")
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
    private Integer age;
    private String email;
    @Embedded
    private Address address;
    //total de livros emprestados
    private Integer totalLoanedBooks = 0;
    @ManyToMany(mappedBy = "authors")
    private Set<Book> books = new HashSet<>();
}
