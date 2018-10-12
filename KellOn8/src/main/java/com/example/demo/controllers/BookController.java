package com.example.demo.controllers;

import com.example.demo.entities.Book;
import com.example.demo.repositories.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.Optional;

@Controller
public class BookController {
    @Autowired
    private BookRepository bookRepository;

    @RequestMapping(value = "/book", method = RequestMethod.POST)
    public ResponseEntity<Void> addBook(@RequestBody Book book) {
        bookRepository.save(book);
        return ResponseEntity.ok().build();
    }

    @RequestMapping(value = "/book", method = RequestMethod.GET)
    public ResponseEntity<Iterable<Book>> getBooks() {
        return ResponseEntity.ok(bookRepository.findAll());
    }

    @RequestMapping(value = "/book/{id}", method = RequestMethod.GET)
    public String getBootById(Model model, @PathVariable("id") Long id) {
        Optional<Book> book = bookRepository.findById(id);
        if (book.isPresent()) {
            System.out.println(book.get());
            model.addAttribute("book", book.get());

        } else {
            model.addAttribute("book", new Book());
        }
        return "book";
    }
}