package com.lucorp.bookstore.controllers;

import com.lucorp.bookstore.dtos.BookRecordDto;
import com.lucorp.bookstore.models.BookModel;
import com.lucorp.bookstore.services.BookService;
import java.util.List;
import java.util.UUID;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
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

  @GetMapping
  public ResponseEntity<List<BookModel>> getAllBooks() {
    return ResponseEntity.status(HttpStatus.OK).body(bookService.getAllBooks());
  }

  @PostMapping
  public ResponseEntity<BookModel> saveBook(@RequestBody BookRecordDto bookRecordDto) {
    return ResponseEntity.status(HttpStatus.CREATED).body(bookService.saveBook(bookRecordDto));
  }

  @DeleteMapping("/{id}")
  public ResponseEntity<String> deleteBook(@PathVariable UUID id) {
    bookService.deleteBook(id);
    return ResponseEntity.status(HttpStatus.OK).body("Book deleted successfully");
  }

}
