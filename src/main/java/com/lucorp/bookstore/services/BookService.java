package com.lucorp.bookstore.services;

import com.lucorp.bookstore.dtos.BookRecordDto;
import com.lucorp.bookstore.models.BookModel;
import com.lucorp.bookstore.models.ReviewModel;
import com.lucorp.bookstore.repositories.AuthorRepository;
import com.lucorp.bookstore.repositories.BookRepository;
import com.lucorp.bookstore.repositories.PublisherRepository;
import java.util.stream.Collectors;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class BookService {

  private final BookRepository bookRepository;
  private final AuthorRepository authorRepository;
  private final PublisherRepository publisherRepository;

  public BookService(BookRepository bookRepository, AuthorRepository authorRepository,
      PublisherRepository publisherRepository) {
    this.bookRepository = bookRepository;
    this.authorRepository = authorRepository;
    this.publisherRepository = publisherRepository;
  }

  @Transactional
  public BookModel saveBook(BookRecordDto bookRecordDto) {
    BookModel book = new BookModel();
    book.setTitle(bookRecordDto.title());
    book.setPublisher(publisherRepository.findById(bookRecordDto.publisherId()).get());
    book.setAuthors(authorRepository.findAllById(bookRecordDto.authorIds()).stream().collect(
        Collectors.toSet()));

    ReviewModel reviewModel = new ReviewModel();
    reviewModel.setComment(bookRecordDto.reviewComment());
    reviewModel.setBook(book);
    book.setReview(reviewModel);

    return bookRepository.save(book);
  }
}