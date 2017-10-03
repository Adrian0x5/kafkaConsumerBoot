package com.example.controller;


import com.example.dao.BookDao;
import com.example.model.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class BookController {

    @Autowired
    @Qualifier("mysqlDao")
    private BookDao bookDao;

    @RequestMapping(value = "/getAll", method = RequestMethod.GET)
    public ResponseEntity<List<Book>> getAllBooks() {
        List<Book> list = bookDao.getAllBooks();
        return new ResponseEntity<>(list, HttpStatus.OK);
    }
}
