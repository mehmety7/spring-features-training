package com.trial.springaop.scheduled;

import com.trial.springaop.service.BookService;
import com.trial.springaop.util.RandomNumberCreator;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.env.Environment;
import org.springframework.scheduling.annotation.Scheduled;

import java.util.Arrays;
import java.util.Date;

@Slf4j
@RequiredArgsConstructor
public class GetBooksScheduledJob {

    private final Integer FIRST_INDEX_OF_BOOK_ARRAY = 1;
    private final Integer LAST_INDEX_OF_BOOK_ARRAY = 8;

    private final BookService bookService;
    private final Environment environment;

    @Scheduled(cron = "${cron.book.time}", zone = "${cron.zone}")
    public void getBookRandomByCronExpression() {
        log.info(Arrays.toString(environment.getActiveProfiles()) + " cron-book#getRandomBookEvery_10_Second start: " + new Date());
        try {
            Integer randomNumber = RandomNumberCreator.createNumberInRange(FIRST_INDEX_OF_BOOK_ARRAY, LAST_INDEX_OF_BOOK_ARRAY);
            log.info(bookService.getBook(Integer.toUnsignedLong(randomNumber)).get().toString());
        } catch (Exception e) {
            log.error("Error occured while #GetBooksScheduledJob: {}", e.getMessage());
        }
        log.info(Arrays.toString(environment.getActiveProfiles()) + " cron-book#getRandomBookEvery_10_Second stop: " + new Date());
    }

    @Scheduled(fixedRateString = "${cron.book.rate}", initialDelayString = "${cron.book.rate}")
    public void getBookRandomByFixedRate() {
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
