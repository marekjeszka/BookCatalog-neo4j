package com.bookcatalog.repositories;

import com.bookcatalog.model.Book;
import org.springframework.data.neo4j.repository.GraphRepository;

public interface BookRepository extends GraphRepository<Book> {
}
