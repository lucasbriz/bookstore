package com.lucorp.bookstore.repositories;

import com.lucorp.bookstore.models.PublisherModel;
import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PublisherRepository extends JpaRepository<PublisherModel, UUID> {

}
