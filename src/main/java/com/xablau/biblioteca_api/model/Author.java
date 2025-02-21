package com.xablau.biblioteca_api.model;

import com.xablau.biblioteca_api.dto.authorDtos.AuthorDto;
import com.xablau.biblioteca_api.dto.authorDtos.AuthorDtoUpdate;
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
    private Integer totalloanedbooks = 0;
    @ManyToMany(mappedBy = "authors")
    private Set<Book> books = new HashSet<>();


    public void atualizarDados(AuthorDtoUpdate update){
        if (update.name() != null){
            this.name = update.name();
        }
        if (update.age() != null){
            this.age = update.age();
        }
        if (update.email() != null){
            this.email = update.email();
        }
        if (update.addressDto() != null){
            this.address.atualizarDados(update.addressDto());
        }
    }

    public Author(AuthorDto authorDto) {
        this.name = authorDto.name();
        this.age = authorDto.age();
        this.email = authorDto.email();
        this.address = new Address();
        this.address.atualizarDados(authorDto.addressDto());
    }
}
