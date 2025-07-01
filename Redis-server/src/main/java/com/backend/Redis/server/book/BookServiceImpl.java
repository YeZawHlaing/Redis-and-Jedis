package com.backend.Redis.server.book;


import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookServiceImpl implements BookService {


    private final BookRepository bookRepository;

    @Autowired
    public BookServiceImpl(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @Override
    public Book createBooks(Book books) {
        return bookRepository.save(books);
    }

    @Override
    @Cacheable(value = "books")
    public List<Book> getAllBooks() {
        return bookRepository.findAll();
    }

    @Override
    @CacheEvict(value = "books", allEntries = true)
    public Book updateBooks(Book book, Long id) {
        Book is_exist=bookRepository.findById(id).orElseThrow(() -> new RuntimeException("Not Found"));
        is_exist.setTitle(book.getTitle());
        is_exist.setPrice(book.getPrice());
        bookRepository.save(is_exist);

        return is_exist;
    }

    @Override
    @CacheEvict(value = "books", allEntries = true)
    public Book deleteBooks(Long id) {
        Book is_exist=bookRepository.findById(id).orElseThrow(() -> new RuntimeException("Not Found"));
        bookRepository.deleteById(id);
        return is_exist;
    }
}
