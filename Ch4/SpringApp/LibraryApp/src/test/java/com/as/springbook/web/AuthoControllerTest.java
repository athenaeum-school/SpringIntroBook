package com.as.springbook.web;

import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.Matchers.is;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.webAppContextSetup;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.context.WebApplicationContext;

import com.as.springbook.domain.Author;
import com.as.springbook.repository.AuthorRepository;
import com.as.springbook.repository.BookRepository;
import com.as.springbook.service.AuthorService;
import com.fasterxml.jackson.databind.ObjectMapper;

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration(locations = {
		"file:src/main/resources/spring/application-config.xml",
		"file:src/main/webapp/WEB-INF/mvc-config.xml" })
@Transactional
@TransactionConfiguration(defaultRollback = false)
public class AuthoControllerTest {

	@Autowired
	private WebApplicationContext wac;

	@Autowired
	private AuthorService authorService;

	@Autowired
	private AuthorRepository authorRepository;

	@Autowired
	private BookRepository bookRepository;

	private MockMvc mockMvc;

	private static Author author;
	private static Author author2;

	@Rule
	public ExpectedException expectedException = ExpectedException.none();

	@Before
	public void setup() {
		mockMvc = webAppContextSetup(wac).build();

		if (authorRepository.findByFirstName("takahasi") == null) {
			authorRepository.deleteAll();
			author = new Author();
			author.setFirstName("takahasi");
			author.setLastName("itirou");
			authorService.create(author);
			author2 = new Author();
			author2.setFirstName("kaneko");
			author2.setLastName("keisuke");
			authorService.create(author2);
		}
	}

	@Test
	public void testGetAuthors() throws Exception {
		mockMvc.perform(get("/as/authors")).andDo(print())
				.andExpect(jsonPath("$", hasSize(2)))
				.andExpect(jsonPath("$[0].firstName", is("takahasi")))
				.andExpect(jsonPath("$[1].lastName", is("keisuke")));
	}

	@Test
	public void testGetAuthor() throws Exception {
		mockMvc.perform(get("/as/authors/1")).andDo(print())
				.andExpect(jsonPath("$.lastName", is("itirou")));
	}

	@Test
	public void testPostAuthor() throws Exception {
		Author author = new Author();
		author.setFirstName("tanaka");
		author.setLastName("daisuke");
		ObjectMapper mapper = new ObjectMapper();
		String jsonString = mapper.writerWithDefaultPrettyPrinter()
				.writeValueAsString(author);
		mockMvc.perform(
				post("/as/authors").contentType(MediaType.APPLICATION_JSON)
						.content(jsonString.getBytes())).andExpect(
				jsonPath("$.firstName", is("tanaka")));

		mockMvc.perform(get("/as/authors")).andDo(print())
				.andExpect(jsonPath("$", hasSize(3)))
				.andExpect(jsonPath("$[2].lastName", is("daisuke")));

		long id = authorRepository.findByFirstName("tanaka").getAuthorId();
		mockMvc.perform(delete("/as/authors/" + id));
	}

	@Test
	public void testPutAuthor() throws Exception {
		Author author3 = new Author();
		author3.setFirstName("ikeda");
		author3.setLastName("tomoaki");
		String jsonString = new ObjectMapper().writerWithDefaultPrettyPrinter()
				.writeValueAsString(author3);

		mockMvc.perform(
				put("/as/authors/2").contentType(MediaType.APPLICATION_JSON)
						.content(jsonString.getBytes())).andDo(print())
				.andExpect(jsonPath("$.firstName", is("ikeda")));

		mockMvc.perform(get("/as/authors"))
				.andExpect(jsonPath("$", hasSize(2)))
				.andExpect(jsonPath("$[1].lastName", is("tomoaki")));

		String jsonString2 = new ObjectMapper()
				.writerWithDefaultPrettyPrinter().writeValueAsString(author2);

		mockMvc.perform(
				put("/as/authors/2").contentType(MediaType.APPLICATION_JSON)
						.content(jsonString2.getBytes())).andExpect(
				jsonPath("$.firstName", is("kaneko")));
	}

	@Test
	public void testDeleteAuthor() throws Exception {
		Author author4 = new Author();
		author4.setFirstName("nakamura");
		author4.setLastName("tarou");
		authorService.create(author4);
		mockMvc.perform(get("/as/authors"))
				.andExpect(jsonPath("$", hasSize(3)));

		long id = authorRepository.findByFirstName("nakamura").getAuthorId();
		mockMvc.perform(delete("/as/authors/" + id));

		mockMvc.perform(get("/as/authors"))
				.andExpect(jsonPath("$", hasSize(2)));

	}

	@Test
	public void testGetAuthors2() throws Exception {
		mockMvc.perform(get("/as/author")).andExpect(status().isNotFound());
	}

	@Test
	public void testGetAuthor2() throws Exception {
		mockMvc.perform(get("/as/authors/abc")).andExpect(
				status().isBadRequest());
	}

	@Test
	public void testPostAuthor2() throws Exception {
		mockMvc.perform(post("/as/authors")).andExpect(
				status().isUnsupportedMediaType());
	}

	@Test
	public void testPutAuthor2() throws Exception {
		mockMvc.perform(put("/as/authors")).andExpect(
				status().isMethodNotAllowed());
	}

	@Test
	public void testDeleteAuthor2() throws Exception {

		expectedException.expect(Exception.class);
		expectedException.expectMessage("There were 2 errors");
		mockMvc.perform(delete("/as/authors/10"));

	}
}
