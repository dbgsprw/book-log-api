package io.github.dbgsprw.booklog.book;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
public class BookRepositoryTest {

    @Autowired
    private BookRepository bookRepository;

    @Test
    void insert() {
        // GIVEN
        Long testISBN = 9781250107817L;
        String testTitle = "Factfulness";
        Book book = Book.builder()
                .isbn(testISBN)
                .title(testTitle)
                .bookAuthors(new ArrayList<>(
                        List.of(
                                BookAuthor.builder().name("Hans Rosling").build(),
                                BookAuthor.builder().name("Ola Rosling").build(),
                                BookAuthor.builder().name("Anna Rosling").build()
                        )
                )).build();

        // WHEN
        this.bookRepository.insert(book);

        // THEN
        assertThat(this.bookRepository.findAll()).isNotEmpty();
        Book savedBook = this.bookRepository.findById(testISBN).get();
        assertThat(savedBook).isEqualTo(book);
        assertThat(savedBook.getBookAuthors()).extracting("name")
                .contains("Hans Rosling", "Ola Rosling", "Anna Rosling");
    }
}
