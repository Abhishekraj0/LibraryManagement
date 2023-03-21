package com.ivoyant.controller;

import com.ivoyant.Repo.BookRepo;
import com.ivoyant.Service.BookService;
import com.ivoyant.dto.UserRegistrationDto;
import com.ivoyant.model.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/addBook")
public class AddBookController {

    @Autowired
    private BookService bookService;
    private final BookRepo bookRepo;

    public AddBookController(BookRepo bookRepo) {
        this.bookRepo = bookRepo;
    }

    @GetMapping
    public ModelAndView AddBookPage(){
        ModelAndView mav=new ModelAndView("AddBook");
        Book book=new Book();
        mav.addObject("book",book);
        return mav;

    }
    @PostMapping
    public ModelAndView saveBook(@ModelAttribute("book") Book book) {
        // save books to database
        ModelAndView modelAndView=new ModelAndView("redirect:/book");
        bookService.saveBook(book);
        return modelAndView;

    }
    @ResponseBody
    @PostMapping("/save")
    public Book saveByApi(@RequestBody Book book){
       return bookService.saveBook(book);

    }

}
