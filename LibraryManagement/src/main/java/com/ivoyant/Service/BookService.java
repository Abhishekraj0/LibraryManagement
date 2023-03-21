package com.ivoyant.Service;

import com.ivoyant.model.Book;
import org.springframework.data.domain.Page;

import java.util.List;

public interface BookService {

    List<Book> getAllBooks();
    public Book saveBook(Book book);
    Book getBookById(long id);
    void deleteBookById(long id);
    Page<Book> findPaginated(int pageNo, int pageSize, String sortField, String sortDirection);

}
