package io.github.dbgsprw.booklog.book;

import lombok.Builder;
import lombok.Value;

import javax.validation.constraints.NotNull;

@Builder
@Value
public class BookAuthor {
    @NotNull
    String name;
}