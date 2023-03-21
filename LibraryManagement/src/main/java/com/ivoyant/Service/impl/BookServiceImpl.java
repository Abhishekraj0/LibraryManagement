package com.ivoyant.Service.impl;

import com.ivoyant.Repo.BookRepo;
import com.ivoyant.Service.BookService;
import com.ivoyant.model.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BookServiceImpl implements BookService {
    @Autowired
    private BookRepo bookRepo;
    @Override
    public List<Book> getAllBooks() {
        return bookRepo.findAll();
    }

    @Override
    public Book saveBook(Book book) {
        return bookRepo.save(book);
    }
    @Override
    public Book getBookById(long id) {
        Optional<Book> optional= bookRepo.findById(id);
        Book book= null;
        if(optional.isPresent()){
            book = optional.get();
        }
        else {
            throw new RuntimeException("Book is not found at this" +id);
        }
        return book;
    }
    @Override
    public void deleteBookById(long id) {
        this.bookRepo.deleteById(id);

    }
    @Override
    public Page<Book> findPaginated(int pageNo, int pageSize, String sortField, String sortDirection) {
        Sort sort = sortDirection.equalsIgnoreCase(Sort.Direction.ASC.name()) ? Sort.by(sortField).ascending() :
                Sort.by(sortField).descending();

        Pageable pageable = PageRequest.of(pageNo - 1, pageSize, sort);
        return this.bookRepo.findAll(pageable);
    }
}
