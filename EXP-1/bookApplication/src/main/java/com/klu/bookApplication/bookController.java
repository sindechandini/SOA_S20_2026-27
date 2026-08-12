package com.klu.bookApplication;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class bookController {

    @Autowired
    private BookRepository br;

    // Insert a book
    @PostMapping("/add")
    public String addBook(@RequestBody book b) {
        br.save(b);
        return "Book added successfully";
    }

    // Retrieve all books
    @GetMapping("/listall")
    public List<book> listBooks() {
        return br.findAll();
    }

    // Retrieve one book by ID
    @GetMapping("/listonebook/{bno}")
    public Optional<book> listOneBook(@PathVariable int bno) {
        return br.findById(bno);
    }

    // Delete a book
    @DeleteMapping("/delete/{bno}")
    public String deleteBook(@PathVariable int bno) {
        br.deleteById(bno);
        return "Book deleted successfully";
    }

    // Update a book
    @PutMapping("/update/{bno}")
    public String updateBook(@PathVariable int bno, @RequestBody book b) {

        Optional<book> book = br.findById(bno);

        if (book.isPresent()) {

            br.save(b);
            return "Book updated successfully";
        } else {
            return "Book not found";
        }
    }
}