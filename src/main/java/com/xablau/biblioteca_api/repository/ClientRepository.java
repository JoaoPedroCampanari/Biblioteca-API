package com.xablau.biblioteca_api.repository;

import com.xablau.biblioteca_api.model.Client;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface ClientRepository extends JpaRepository<UUID, Client> {
}
