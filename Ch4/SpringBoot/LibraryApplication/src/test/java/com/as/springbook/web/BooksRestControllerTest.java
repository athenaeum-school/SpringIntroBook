package com.as.springbook.web;

import static org.hamcrest.Matchers.*;
import static org.junit.Assert.*;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.springframework.test.web.servlet.result.ModelResultMatchers.*;

import java.util.Arrays;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.IntegrationTest;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.context.WebApplicationContext;

import com.as.springbook.LibraryApp;
import com.as.springbook.domain.Author;
import com.as.springbook.domain.Book;
import com.as.springbook.repository.AuthorRepository;
import com.as.springbook.repository.BookRepository;
import com.as.springbook.service.AuthorService;
import com.as.springbook.service.BookService;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = LibraryApp.class)
@WebAppConfiguration
@IntegrationTest({ "spring.datasource.initialize=false", "server.port=8000" })
@Transactional
@TransactionConfiguration(defaultRollback=false)
public class BooksRestControllerTest {

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
		/*author = new Author();
		author.setAuthorId(1);
		author.setFirstName("yamamoto");
		author.setLastName("itirou");
		author2 = new Author();
		author2.setAuthorId(2);
		author2.setFirstName("kaneko");
		author2.setLastName("keisuke");
		book = new Book(1, "初めてのjava", 2000, Arrays.asList(author));
		book2 = new Book(2, "初めてのspring", 1500, Arrays.asList(author, author2));
		bookService.create(book);
		bookService.create(book2);*/
		
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

	@Test
	public void testGetAllBooks() throws Exception {
		mockMvc.perform(get("/as/books"))
				.andExpect(jsonPath("$.size", is(5)))
				.andExpect(jsonPath("$.number", is(0)))
				.andExpect(jsonPath("$.content", hasSize(2)))
				.andExpect(jsonPath("$.content[0].title", is("初めてのjava")))
				.andExpect(
						jsonPath("$.content[1].authors[1].firstName",
								is("kaneko")));
	}

	@Test
	public void testSize() throws Exception {
		mockMvc.perform(get("/as/books").param("size", "1"))
				.andExpect(jsonPath("$.size", is(1)))
				.andExpect(jsonPath("$.number", is(0)))
				.andExpect(jsonPath("$.content", hasSize(1)));
	}

	@Test
	public void testPage() throws Exception {
		mockMvc.perform(get("/as/books").param("page", "1"))
				.andExpect(jsonPath("$.number", is(1)))
				.andExpect(jsonPath("$.content", hasSize(0)));

	}

	@Test
	public void testSearchTitle() throws Exception {
		mockMvc.perform(get("/as/books").param("search", "java"))
				.andExpect(jsonPath("$.content", hasSize(1)))
				.andExpect(jsonPath("$.content[0].price", is(2000)));

	}

	@Test
	public void testSearchAuthorFirstName() throws Exception {
		mockMvc.perform(get("/as/books").param("search", "neko"))
				.andExpect(jsonPath("$.content", hasSize(1)))
				.andExpect(jsonPath("$.content[0].title", is("初めてのspring")));
	}

	@Test
	public void testSearchAuthorLastName() throws Exception {
		mockMvc.perform(get("/as/books").param("search", "tiro"))
				.andExpect(jsonPath("$.content", hasSize(2)))
				.andExpect(jsonPath("$.content[0].title", is("初めてのjava")))
				.andExpect(jsonPath("$.content[1].title", is("初めてのspring")));

	}

}
