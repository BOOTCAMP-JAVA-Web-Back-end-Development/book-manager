package com.thanhdc.bookmanager.service.impl;

import com.thanhdc.bookmanager.model.Book;
import com.thanhdc.bookmanager.reponsitory.BookReponsitory;
import com.thanhdc.bookmanager.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class BookServiceImpl implements BookService {

    @Autowired
    private BookReponsitory bookReponsitory;

    @Override
    public Page<Book> findAll(Pageable pageable) {
        return bookReponsitory.findAll(pageable);
    }

    @Override
    public void save(Book book) {
        bookReponsitory.save(book);
    }

    @Override
    public Book findById(int id) {
        return bookReponsitory.findById(id).orElse(null);
    }

    @Override
    public void remove(int id) {
        bookReponsitory.deleteById(id);
    }

    @Override
    public Page<Book> findAllByName(String name, Pageable pageable) {
        return bookReponsitory.findAllByName(name, pageable);
    }
}
