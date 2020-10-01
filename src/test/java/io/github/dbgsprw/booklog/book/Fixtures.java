package io.github.dbgsprw.booklog.book;

import java.util.HashSet;
import java.util.Set;

public class Fixtures {
    static Book getBook() {
        Long testISBN = 9781250107817L;
        String testTitle = "Factfulness";

        return Book.builder()
                .isbn(testISBN)
                .title(testTitle)
                .bookAuthors(new HashSet<>(
                        Set.of(
                                BookAuthor.builder().name("Hans Rosling").build(),
                                BookAuthor.builder().name("Ola Rosling").build(),
                                BookAuthor.builder().name("Anna Rosling").build()
                        )
                )).build();
    }
}
