package com.trial.springaop.scheduled;

import com.trial.springaop.service.BookService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;

@Configuration
@RequiredArgsConstructor
public class ScheduledJobManagement {

    private final BookService bookService;
    private final Environment environment;

    @Value("${cron.book.enabled}")
    private Boolean cronActivated;

    @Bean
    public GetBooksScheduledJob runGetBooksScheduledJob() {
        if (cronActivated) {
            return new GetBooksScheduledJob(bookService, environment);
        }
        return null;
    }

}
