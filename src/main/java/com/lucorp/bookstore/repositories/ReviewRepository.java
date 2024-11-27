package com.lucorp.bookstore.repositories;

import com.lucorp.bookstore.models.ReviewModel;
import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReviewRepository extends JpaRepository<ReviewModel, UUID> {

}
