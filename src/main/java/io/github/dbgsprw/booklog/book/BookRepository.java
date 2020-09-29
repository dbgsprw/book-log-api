package io.github.dbgsprw.booklog.book;

import io.github.dbgsprw.booklog.support.WithInsert;
import org.springframework.data.repository.CrudRepository;

public interface BookRepository extends CrudRepository<Book, Long>, WithInsert<Book> {
}