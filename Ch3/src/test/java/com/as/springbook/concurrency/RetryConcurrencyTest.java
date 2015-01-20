/**
 * All Rigths Reserved by Athenaeum Society
 * 2015-
 * Written by Masaki Komatsu
 */
package com.as.springbook.concurrency;

import static org.junit.Assert.*;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicInteger;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate3.HibernateOptimisticLockingFailureException;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.support.AnnotationConfigContextLoader;

import com.as.springbook.config.HibernateConfig;
import com.as.springbook.domain.Book;
import com.as.springbook.service.BookService;

/**
 * @author komatsu
 *
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = { HibernateConfig.class }, loader = AnnotationConfigContextLoader.class)
public class RetryConcurrencyTest {

	private static final Logger logger = LoggerFactory.getLogger(RetryConcurrencyTest.class);
	
    @Autowired
    private BookService bookService;

    @Test
    public void testRetries() throws InterruptedException {
        final Book book = new Book();
        book.setTitle("Tv");
        bookService.create(book);

        final int threadsNumber = 10;

        final AtomicInteger atomicInteger = new AtomicInteger();
        final CountDownLatch startLatch = new CountDownLatch(threadsNumber + 1);
        final CountDownLatch endLatch = new CountDownLatch(threadsNumber + 1);

        for (; atomicInteger.get() < threadsNumber; atomicInteger.incrementAndGet()) {
            logger.info("Scheduling thread {}", atomicInteger.get());
            Thread testThread = new Thread(new Runnable() {
                @Override
                public void run() {
                    try {
                        startLatch.countDown();
                        startLatch.await();
                        book.setTitle("MyTitle-" + Math.random());
                        bookService.update(book);
                        
                    } catch (InterruptedException e) {
                        Thread.currentThread().interrupt();
                    } catch (HibernateOptimisticLockingFailureException e) {
                    	logger.error("OptimisticLockingFailureException thrown!");
                    } catch (Exception e) {
                        logger.error("Exception thrown!");
                    } finally {
                        endLatch.countDown();
                    }
                }
            });
            testThread.start();
        }
        startLatch.countDown();
        logger.info("Waiting for threads to be done");
        endLatch.countDown();
        endLatch.await();
        logger.info("All Finished");
    }

}
