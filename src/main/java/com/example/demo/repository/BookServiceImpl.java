package com.example.demo.repository;


import com.example.demo.entity.Book;
import com.example.demo.entity.BookDTO;
import com.example.demo.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class BookServiceImpl implements BookService {

    @Autowired
    private BookRepository bookRepository;


    @Override
    public void create(BookDTO dto) {
        Book book = new Book();
        book.setAuthor(dto.getAuthor());
        book.setName(dto.getName());
        book.setPrice(dto.getPrice());
        bookRepository.save(book);
    }

    @Override
    public List<BookDTO> findAll() {
        return bookRepository.findAll().stream()
                .map(book -> {
                    BookDTO bookDTO = new BookDTO();
                    bookDTO.setAuthor(book.getAuthor());
                    bookDTO.setId(book.getId());
                    bookDTO.setName(book.getName());
                    bookDTO.setPrice(book.getPrice());
                    return  bookDTO;
                }).collect(Collectors.toList());
    }
}
