package com.ivoyant.controller;

import com.ivoyant.Repo.BookRepo;
import com.ivoyant.Service.BookService;
import com.ivoyant.dto.UserRegistrationDto;
import com.ivoyant.model.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/book")
public class BookController {
    @Autowired
    private BookService bookService;
    private final BookRepo bookRepo;

    public BookController(BookRepo bookRepo) {
        this.bookRepo = bookRepo;
    }
   @GetMapping
    public ModelAndView showBooks() {
        ModelAndView modelAndView = new ModelAndView("Book");
        modelAndView.addObject("book", bookService.getAllBooks());
        return modelAndView;
    }
    @ResponseBody
    @GetMapping("/listBooks")
    public Book listBookS(@RequestBody Book book){
        return (Book) bookService.getAllBooks();
    }
    @RequestMapping(value = "/edit/{id}", method = RequestMethod.GET)
    public String editBookPage(@PathVariable(name = "id") Long id, Model model) {
        Book book = bookService.getBookById(id);
        if( book != null ) {
            model.addAttribute("book", book);
            return "/AddBook";
        } else {
            return "redirect:/addBook";
        }
    }
}
