package com.example.demo.controller;

import com.example.demo.entity.BookDTO;
import com.example.demo.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/books")
public class BookController {

    @Autowired
    private BookService bookService;

    @PostMapping
    public void create(@RequestBody BookDTO dto) {
        bookService.create(dto);
    }

    @GetMapping
    public List<BookDTO> findAll() {
        return bookService.findAll();
    }
}