package com.bookcatalog.web;

import com.bookcatalog.model.Book;
import com.bookcatalog.repositories.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/api")
public class RestController {
    @Autowired
    private BookRepository bookRepository;

    @RequestMapping("/books")
    @ResponseBody
    public Iterable<Book> getAllBooks() {
        return bookRepository.findAll();
    }
}
