package io.github.dbgsprw.booklog.book;

import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Value;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.MappedCollection;

import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;

@Builder
@Value
@EqualsAndHashCode(of = "isbn")
public class Book {
    @Id
    Long isbn;

    @NotNull
    String title;

    @MappedCollection(idColumn = "BOOK_ISBN", keyColumn = "ID")
    @Builder.Default
    List<BookAuthor> bookAuthors = new ArrayList<>();
}