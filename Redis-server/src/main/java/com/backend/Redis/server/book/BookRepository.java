package com.backend.Redis.server.book;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookRepository extends JpaRepository<Book,Long> {
    @Query(value = "SELECT * FROM Book WHERE title = ?1", nativeQuery = true)
    List<Book> getBookByName(String bookName);
}