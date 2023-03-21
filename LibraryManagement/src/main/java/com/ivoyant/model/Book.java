package com.ivoyant.model;


import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name="book",uniqueConstraints = @UniqueConstraint(columnNames = "isbn"))

public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "Bookname")
    private String name;
    @Column(name = "Author")
    private String authors;
    @Column(name = "isbn")
    private String isbn;
    @Column(name = "create_Date")
    private String createDate;
    @Column(name = "quantity")
    private Long quantity;

    public Book(String name, String authors, String isbn, String createDate, Long quantity) {
        this.name = name;
        this.authors = authors;
        this.isbn = isbn;
        this.createDate = createDate;
        this.quantity = quantity;
    }

    public Book() {

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAuthors() {
        return authors;
    }

    public void setAuthors(String authors) {
        this.authors = authors;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public String getCreateDate() {
        return createDate;
    }

    public void setCreateDate(String createDate) {
        this.createDate = createDate;
    }

    public Long getQuantity() {
        return quantity;
    }

    public void setQuantity(Long quantity) {
        this.quantity = quantity;
    }
}

