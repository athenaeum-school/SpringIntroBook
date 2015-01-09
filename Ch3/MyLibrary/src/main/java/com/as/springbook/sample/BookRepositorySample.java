package com.as.springbook.sample;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.as.springbook.config.HibernateConfig;
import com.as.springbook.domain.BookImpl;
import com.as.springbook.repository.BookRepository;

public class BookRepositorySample {

	public static void main(String[] args) {
        //ApplicationContext context = new AnnotationConfigApplicationContext(HibernateConfig.class);
        //final BookRepository bookRepository = context.getBean(BookRepository.class);
        final BookRepository bookRepository = new BookRepository();
        final BookImpl foo = new BookImpl();
		foo.setTitle("My Name");
		foo.setId(1l);
		bookRepository.create(foo);		
	}

}
