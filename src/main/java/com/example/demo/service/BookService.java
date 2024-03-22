package com.example.demo.service;

import com.example.demo.entity.Book;
import com.example.demo.entity.BookDTO;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface BookService {
    void create(BookDTO dto);
    List<BookDTO> findAll();
}
