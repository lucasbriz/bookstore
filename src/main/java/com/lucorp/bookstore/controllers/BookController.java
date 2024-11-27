package com.lucorp.bookstore.controllers;

import com.lucorp.bookstore.dtos.BookRecordDto;
import com.lucorp.bookstore.models.BookModel;
import com.lucorp.bookstore.services.BookService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/bookstore/books")
public class BookController {

  private final BookService bookService;

  public BookController(BookService bookService) {
    this.bookService = bookService;
  }

  @PostMapping
  public ResponseEntity<BookModel> saveBook(@RequestBody BookRecordDto bookRecordDto) {
    return ResponseEntity.status(HttpStatus.CREATED).body(bookService.saveBook(bookRecordDto));
  }
}
