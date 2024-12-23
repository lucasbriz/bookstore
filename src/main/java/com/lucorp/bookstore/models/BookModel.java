package com.lucorp.bookstore.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import java.io.Serial;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

@Entity
@Table(name = "tb_book")
public class BookModel implements Serializable {

  @Serial
  private static final long serialVersionUID = 1L;

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private UUID uuid;

  @Column(nullable = false, unique = true)
  private String title;

  @JsonProperty(access = Access.WRITE_ONLY)
  @ManyToOne(fetch = FetchType.EAGER)
  @JoinColumn(name = "publisher_id") //fk
  private PublisherModel publisher;

  @JsonProperty(access = Access.WRITE_ONLY)
  @ManyToMany(fetch = FetchType.EAGER)
  @JoinTable(
      name = "tb_book_author",
      joinColumns = @JoinColumn(name = "book_id"),
      inverseJoinColumns = @JoinColumn(name = "author_id")
  )
  private Set<AuthorModel> authors = new HashSet<>();

  @OneToOne(mappedBy = "book", cascade = CascadeType.ALL)
  private ReviewModel review;

  public UUID getUuid() {
    return uuid;
  }

  public void setUuid(UUID uuid) {
    this.uuid = uuid;
  }

  public String getTitle() {
    return title;
  }

  public void setTitle(String title) {
    this.title = title;
  }

  public PublisherModel getPublisher() {
    return publisher;
  }

  public void setPublisher(PublisherModel publisher) {
    this.publisher = publisher;
  }

  public Set<AuthorModel> getAuthors() {
    return authors;
  }

  public void setAuthors(Set<AuthorModel> authors) {
    this.authors = authors;
  }

  public ReviewModel getReview() {
    return review;
  }

  public void setReview(ReviewModel review) {
    this.review = review;
  }
}
