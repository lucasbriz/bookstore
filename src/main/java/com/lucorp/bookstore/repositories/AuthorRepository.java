package com.lucorp.bookstore.repositories;

import com.lucorp.bookstore.models.AuthorModel;
import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AuthorRepository extends JpaRepository<AuthorModel, UUID> {

}
