package io.github.dbgsprw.booklog.book;

import lombok.Builder;
import lombok.Value;
import org.springframework.data.annotation.Id;

import javax.validation.constraints.NotNull;

@Builder
@Value
public class BookAuthor {
    @Id
    Long id;

    @NotNull
    String name;
}