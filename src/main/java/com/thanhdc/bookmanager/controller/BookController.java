package com.thanhdc.bookmanager.controller;

import com.thanhdc.bookmanager.model.Book;
import com.thanhdc.bookmanager.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/book")
public class BookController {

    @Autowired
    private BookService bookService;

    @GetMapping("/create")
    public ModelAndView formCreateBook() {
        ModelAndView modelAndView = new ModelAndView("/book/create");
        modelAndView.addObject("book", new Book());
        return modelAndView;
    }
    @PostMapping("/create")
    public ModelAndView createBook(@ModelAttribute("book") Book book){
        ModelAndView modelAndView = new ModelAndView("/book/create");
        bookService.save(book);
        modelAndView.addObject("message","New book was created succesfully");
        modelAndView.addObject("book", new Book());
        return modelAndView;
    }


}
