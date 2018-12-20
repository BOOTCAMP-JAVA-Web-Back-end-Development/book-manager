package com.thanhdc.bookmanager.service;

import com.thanhdc.bookmanager.model.Book;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface BookService {
    Page<Book> findAll(Pageable pageable);

    void save(Book book);

    Book findById(int id);

    void remove(int id);

    Page<Book> findAllByName(String name, Pageable pageable);
}
