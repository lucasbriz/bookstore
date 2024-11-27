package com.lucorp.bookstore.repositories;

import com.lucorp.bookstore.models.BookModel;
import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository<BookModel, UUID> {

  BookModel findBookModelByTitle(String title);
}
