package com.thanhdc.bookmanager.reponsitory;

import com.thanhdc.bookmanager.model.Book;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface BookReponsitory extends PagingAndSortingRepository<Book, Integer> {
    Page<Book> findAllByName(String name, Pageable pageable);
}
