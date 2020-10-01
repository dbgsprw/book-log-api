package io.github.dbgsprw.booklog.book;

import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class BookController {
    private final BookRepository bookRepository;

    public BookController(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @GetMapping("/books")
    List<Book> getBooks() {
        List<Book> result = new ArrayList<>();
        bookRepository.findAll().forEach(result::add);
        return result;
    }

    @GetMapping("/books/{id}")
    Book getBook(@PathVariable Long id) {
        return bookRepository.findById(id).orElseThrow(BookNotFoundException::new);
    }

    @PostMapping("/books")
    Book postBook(@RequestBody Book book) {
        return bookRepository.insert(book);
    }
}
