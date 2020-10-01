package io.github.dbgsprw.booklog.book;


import org.json.JSONObject;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;


@SpringBootTest
@AutoConfigureMockMvc
public class BookControllerTests {

    @Autowired
    MockMvc mvc;

    @Autowired
    BookRepository bookRepository;

    @Test
    void retrieveBookTest() throws Exception {
        Book insertingBook = Fixtures.getBook();
        bookRepository.insert(insertingBook);

        MvcResult result = mvc.perform(get("/books/" + insertingBook.getIsbn())
                .contentType(MediaType.APPLICATION_JSON)).andReturn();

        JSONObject jsonObject = new JSONObject(result.getResponse().getContentAsString());
        assertThat(jsonObject.getString("title")).isEqualTo("Factfulness");
    }

//    @Test
//    public void noParamGreetingShouldReturnDefaultMessage() throws Exception {
//
//        this.mockMvc.perform(get("/greeting")).andDo(print()).andExpect(status().isOk())
//                .andExpect(jsonPath("$.content").value("Hello, World!"));
//    }
//
//    @Test
//    public void paramGreetingShouldReturnTailoredMessage() throws Exception {
//
//        this.mockMvc.perform(get("/greeting").param("name", "Spring Community"))
//                .andDo(print()).andExpect(status().isOk())
//                .andExpect(jsonPath("$.content").value("Hello, Spring Community!"));
//    }
}
