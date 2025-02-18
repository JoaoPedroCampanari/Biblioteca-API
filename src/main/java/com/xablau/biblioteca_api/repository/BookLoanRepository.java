package com.xablau.biblioteca_api.repository;

import com.xablau.biblioteca_api.model.BookLoan;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface BookLoanRepository extends JpaRepository<UUID, BookLoan> {
}
