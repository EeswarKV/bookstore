package com.project.endpoints;

import com.project.application.BookService;
import com.project.endpoints.dto.BooksResponseDTO;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/books")
public class BooksEndpoint {

    private final BookService bookService;

    public BooksEndpoint(BookService bookService) {
        this.bookService = bookService;
    }

    @GetMapping
    public ResponseEntity<List<BooksResponseDTO>> getBooks() {
        return ResponseEntity.ok(bookService.getBooks());
    }

    @GetMapping("/{id}")
    public ResponseEntity<BooksResponseDTO> getBookById(@PathVariable String id) {
        return bookService.getBookByIdOptional(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<BooksResponseDTO> createBook(@RequestBody BooksResponseDTO book) {
        BooksResponseDTO created = bookService.createBook(book);
        return ResponseEntity.status(HttpStatus.CREATED).body(created);
    }
}
