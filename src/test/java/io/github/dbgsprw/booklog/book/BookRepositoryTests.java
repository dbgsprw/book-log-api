package io.github.dbgsprw.booklog.book;

import io.github.dbgsprw.booklog.test.DataInitializeExecutionListener;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestExecutionListeners;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
@TestExecutionListeners(
        listeners = DataInitializeExecutionListener.class,
        mergeMode = TestExecutionListeners.MergeMode.MERGE_WITH_DEFAULTS)
public class BookRepositoryTests {

    @Autowired
    private BookRepository bookRepository;

    @Test
    void insert() {
        Book book = Fixtures.getBook();

        this.bookRepository.insert(book);

        assertThat(this.bookRepository.findAll()).isNotEmpty();
        Book savedBook = this.bookRepository.findById(book.getIsbn()).get();
        assertThat(savedBook).isEqualTo(book);
        assertThat(savedBook.getBookAuthors()).extracting("name")
                .contains("Hans Rosling", "Ola Rosling", "Anna Rosling");
    }
}
