package io.github.dbgsprw.booklog.test;

import io.github.dbgsprw.booklog.book.Book;
import org.springframework.context.ApplicationContext;
import org.springframework.data.jdbc.core.JdbcAggregateOperations;
import org.springframework.test.context.TestContext;
import org.springframework.test.context.support.AbstractTestExecutionListener;

public class DataInitializeExecutionListener extends AbstractTestExecutionListener {
    @Override
    public void afterTestMethod(TestContext testContext) {
        ApplicationContext applicationContext = testContext.getApplicationContext();
        JdbcAggregateOperations jdbcAggregateOperations = applicationContext.getBean(JdbcAggregateOperations.class);
        jdbcAggregateOperations.deleteAll(Book.class);
    }
}
