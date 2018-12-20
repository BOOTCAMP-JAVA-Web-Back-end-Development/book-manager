package com.thanhdc.bookmanager.controller;

import com.thanhdc.bookmanager.model.Book;
import com.thanhdc.bookmanager.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
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

    @GetMapping("/list")
    public ModelAndView listBook(@PageableDefault(size = 5) Pageable pageable){
        Page<Book> books;
        ModelAndView modelAndView = new ModelAndView("/book/list");
        books = bookService.findAll(pageable);
        modelAndView.addObject("books", books);
        return modelAndView;
    }

    @GetMapping("/edit/{id}")
    public ModelAndView formEditBook(@PathVariable int id){
        ModelAndView modelAndView = new ModelAndView("/book/edit");
        modelAndView.addObject("book", bookService.findById(id));
        return modelAndView;
    }

    @PostMapping("/edit")
    public ModelAndView editBook(Book book){
        ModelAndView modelAndView = new ModelAndView("/book/edit");
        bookService.save(book);
        modelAndView.addObject("message","Book was edited succesfully");
        return modelAndView;
    }

    @GetMapping("/delete/{id}")
    public ModelAndView formDeleteBook(@PathVariable int id){
        ModelAndView modelAndView = new ModelAndView("/book/delete");
        modelAndView.addObject("book", bookService.findById(id));
        return modelAndView;
    }

    @PostMapping("/delete")
    public ModelAndView deleteBook(@RequestParam("id") int id, Book book){
        book = bookService.findById(id);
        bookService.remove(id);
        ModelAndView modelAndView = new ModelAndView("/book/delete");
        modelAndView.addObject("message", "Delete Success");
        return modelAndView;
    }


}
