package com.backend.Redis.server.book;

import java.util.List;

public interface BookService {

    Book createBooks(Book books);
    List<Book> getAllBooks();
    Book updateBooks(Book book, Long id);
    Book deleteBooks(Long id);
}