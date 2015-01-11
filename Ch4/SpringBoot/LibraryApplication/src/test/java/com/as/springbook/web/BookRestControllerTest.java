package com.as.springbook.web;

import static org.hamcrest.Matchers.*;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.springframework.test.web.servlet.result.ModelResultMatchers.*;

import java.util.ArrayList;
import java.util.Arrays;

import javax.print.attribute.standard.Sides;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.IntegrationTest;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.context.WebApplicationContext;

import com.as.springbook.LibraryApp;
import com.as.springbook.domain.Author;
import com.as.springbook.domain.Book;
import com.as.springbook.repository.AuthorRepository;
import com.as.springbook.repository.BookRepository;
import com.as.springbook.service.AuthorService;
import com.as.springbook.service.BookService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = LibraryApp.class)
@WebAppConfiguration
@IntegrationTest({ "spring.datasource.initialize=false", "server.port=8000"})
@Transactional
@TransactionConfiguration(defaultRollback = false)
public class BookRestControllerTest {

	@Autowired
	private WebApplicationContext wac;

	@Autowired
	private AuthorService authorService;

	@Autowired
	private AuthorRepository authorRepository;

	@Autowired
	private BookService bookService;

	@Autowired
	private BookRepository bookRepository;

	private MockMvc mockMvc;

	private static Author author;
	private static Author author2;
	private static Book book;
	private static Book book2;

	@Before
	public void setup() {
		mockMvc = webAppContextSetup(wac).build();
		System.out.println("---------------------------------------------");
		System.out.println(bookService.findAll());

		if (bookRepository.findByTitle("初めてのjava").size() == 0) {
			authorRepository.deleteAll();
			author = new Author();
			author.setAuthorId(1);
			author.setFirstName("yamamoto");
			author.setLastName("itirou");
			authorService.create(author);
			book = new Book();
			book.setTitle("初めてのjava");
			book.setPrice(2000);
			bookService.create(book,
					authorRepository.findByFirstName("yamamoto").getAuthorId());

			author2 = new Author();
			author2.setFirstName("kaneko");
			author2.setLastName("keisuke");
			authorService.create(author2);
			book2 = new Book();
			book2.setTitle("初めてのspring");
			book2.setPrice(1500);
			bookService.create(book2,
					authorRepository.findByFirstName("yamamoto").getAuthorId());
			bookService.update(null, bookRepository.findByTitle("初めてのspring")
					.get(0).getBookId(),
					authorRepository.findByFirstName("kaneko").getAuthorId());

		}
	}

	@Test
	public void testGetBooks() throws Exception {
		long id = authorRepository.findByFirstName("yamamoto").getAuthorId();
		mockMvc.perform(get("/as/authors/"+id+"/books"))
				.andDo(print())
				.andExpect(jsonPath("$", hasSize(2)))
				.andExpect(jsonPath("$[1].title", is("初めてのspring")))
				.andExpect(
						jsonPath("$[0].authors[0].firstName", is("yamamoto")));
	}

	@Test
	public void testGetBook() throws Exception {

		long id = bookRepository.findByTitle("初めてのjava").get(0).getBookId();
		mockMvc.perform(get("/as/authors/1/books/" + id)).andDo(print())
				.andExpect(jsonPath("$.title", is("初めてのjava")))
				.andExpect(jsonPath("$.authors[0].firstName", is("yamamoto")));
	}

	@Test
	public void testPostBook() throws Exception {

		Book book3 = new Book();
		book3.setTitle("Gradle入門");
		book3.setPrice(2500);
		String jsonString1 = new ObjectMapper()
				.writerWithDefaultPrettyPrinter().writeValueAsString(book3);
		long id = authorRepository.findByFirstName("yamamoto").getAuthorId();
		mockMvc.perform(
				post("/as/authors/" + id + "/books").contentType(
						MediaType.APPLICATION_JSON).content(
						jsonString1.getBytes())).andDo(print());

		mockMvc.perform(get("/as/authors/" + id + "/books")).andDo(print());

	}

	@Test
	public void testPutBook() throws Exception {
		Book book4 = new Book();
		book4.setBookId(4);
		book4.setTitle("BackBoneの基礎");
		book4.setPrice(1800);
		String jsonString4 = new ObjectMapper()
				.writerWithDefaultPrettyPrinter().writeValueAsString(book4);
		long id = bookRepository.findByTitle("初めてのspring").get(0).getBookId();
		System.out.println(bookService.findOne(id));
		mockMvc.perform(
				put("/as/authors/1/books/" + id).contentType(
						MediaType.APPLICATION_JSON).content(
						jsonString4.getBytes())).andDo(print())
				.andExpect(jsonPath("$.title", is("BackBoneの基礎")))
				.andExpect(jsonPath("$.authors[0].firstName", is("yamamoto")));

		mockMvc.perform(get("/as/authors/1/books/" + id)).andDo(print())
				.andExpect(jsonPath("$.title", is("BackBoneの基礎")))
				.andExpect(jsonPath("$.authors[0].lastName", is("itirou")));

	}

}
