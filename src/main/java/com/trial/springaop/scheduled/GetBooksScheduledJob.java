package com.trial.springaop.scheduled;

import com.trial.springaop.service.BookService;
import com.trial.springaop.util.RandomNumberCreator;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.Date;

@Slf4j
@Component
@RequiredArgsConstructor
public class GetBooksScheduledJob {

    private final Integer FIRST_INDEX_OF_BOOK_ARRAY = 1;
    private final Integer LAST_INDEX_OF_BOOK_ARRAY = 20;

    private final BookService bookService;

    @Scheduled(cron = "${cron-book}", zone = "${zone}")
    public void getRandomBookEvery_10_Second() {
        log.info("cron-book#getRandomBookEvery_10_Second start: " + new Date());
        try {
            Integer randomNumber = RandomNumberCreator.createNumberInRange(FIRST_INDEX_OF_BOOK_ARRAY, LAST_INDEX_OF_BOOK_ARRAY);
            log.info(bookService.getBook(Integer.toUnsignedLong(randomNumber)).get().toString());
        } catch (Exception e) {
            log.error("Error occured while #GetBooksScheduledJob: {}", e.getMessage());
        }
        log.info("cron-book#getRandomBookEvery_10_Second stop: " + new Date());
    }

    @Scheduled(fixedRate = 2000)
    public void getRandomBookEvery_2_Second() {
        log.info("cron-book#getRandomBookEvery_2_Second start: " + new Date());
        try {
            Integer randomNumber = RandomNumberCreator.createNumberInRange(FIRST_INDEX_OF_BOOK_ARRAY, LAST_INDEX_OF_BOOK_ARRAY);
            log.info(bookService.getBook(Integer.toUnsignedLong(randomNumber)).get().toString());
        } catch (Exception e) {
            log.error("Error occured while #GetBooksScheduledJob: {}", e.getMessage());
        }
        log.info("cron-book#getRandomBookEvery_2_Second stop: " + new Date());
    }


}
