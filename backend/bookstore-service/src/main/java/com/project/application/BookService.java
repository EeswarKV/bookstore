package com.project.application;

import com.project.endpoints.dto.BooksResponseDTO;
import com.project.persistence.BookEntity;
import com.project.persistence.BookJpaRepository;
import org.springframework.stereotype.Service;
import java.util.Optional;

import java.util.List;
import java.util.UUID;

@Service
public class BookService {

    private final BookJpaRepository repository;

    public BookService(BookJpaRepository repository) {
        this.repository = repository;
    }

    public Optional<BooksResponseDTO> getBookByIdOptional(String id) {
        Optional<BookEntity> books = repository.findById(UUID.fromString(id));
        return books.map(book -> {
           return BooksResponseDTO.builder()
                            .id(book.getId())
                            .title(book.getTitle())
                            .author(book.getAuthor())
                            .price(book.getPrice())
                            .inStock(book.isInStock())
                            .build();
        });
    }
    public List<BooksResponseDTO> getBooks() {
        List<BookEntity> books = repository.findAll();
        return books.stream()
                .map(book -> {
                    return BooksResponseDTO.builder()
                            .id(book.getId())
                            .title(book.getTitle())
                            .author(book.getAuthor())
                            .price(book.getPrice())
                            .inStock(book.isInStock())
                            .build();
                    
                })
                .toList();
    }

    public BookEntity getBookById(String id) {
        return repository.findById(UUID.fromString(id))
                .orElseThrow(() -> new RuntimeException("Book not found"));
    }

    public BooksResponseDTO createBook(BooksResponseDTO booksDTO) {
        BookEntity book = BookEntity.builder()
                .id(UUID.randomUUID())
                .title(booksDTO.getTitle())
                .author(booksDTO.getAuthor())
                .price(booksDTO.getPrice())
                .inStock(booksDTO.isInStock())
                .build();
        BookEntity response = repository.save(book);
              return BooksResponseDTO.builder()
                            .id(response.getId())
                            .title(response.getTitle())
                            .author(response.getAuthor())
                            .price(response.getPrice())
                            .inStock(response.isInStock())
                            .build();
    }
    
}
