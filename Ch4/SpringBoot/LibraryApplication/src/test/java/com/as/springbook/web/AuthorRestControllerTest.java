package com.as.springbook.web;

import static org.hamcrest.Matchers.*;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.springframework.test.web.servlet.result.ModelResultMatchers.*;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.IntegrationTest;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.web.context.WebApplicationContext;

import com.as.springbook.LibraryApp;
import com.as.springbook.domain.Author;
import com.as.springbook.repository.AuthorRepository;
import com.as.springbook.service.AuthorService;
import com.fasterxml.jackson.databind.ObjectMapper;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = LibraryApp.class)
@WebAppConfiguration
@IntegrationTest({ "spring.datasource.initialize=false","server.port=8000" })
public class AuthorRestControllerTest {

	@Autowired
	private WebApplicationContext wac;

	@Autowired
	private AuthorService authorService;

	@Autowired
	private AuthorRepository authorRepository;

	private MockMvc mockMvc;

	private static Author author;
	private static Author author2;

	@Before
	public void setup() {
		mockMvc = webAppContextSetup(wac).build();
		if (authorService.findOne(1) == null) {
			author = new Author();
			author.setFirstName("yamamoto");
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
				.andExpect(jsonPath("$[0].firstName", is("yamamoto")))
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
				post("/as/authors").contentType(
						MediaType.APPLICATION_JSON_VALUE).content(
						jsonString.getBytes())).andExpect(
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
				put("/as/authors/2").contentType(
						MediaType.APPLICATION_JSON_VALUE).content(
						jsonString.getBytes())).andDo(print())
				.andExpect(jsonPath("$.firstName", is("ikeda")));

		mockMvc.perform(get("/as/authors"))
				.andExpect(jsonPath("$", hasSize(2)))
				.andExpect(jsonPath("$[1].lastName", is("tomoaki")));

		String jsonString2 = new ObjectMapper()
				.writerWithDefaultPrettyPrinter().writeValueAsString(author2);

		mockMvc.perform(
				put("/as/authors/2").contentType(
						MediaType.APPLICATION_JSON_VALUE).content(
						jsonString2.getBytes())).andExpect(
				jsonPath("$.firstName", is("kaneko")));
	}

	@Test
	public void testDeleteAuthor() throws Exception {
		Author author4 = new Author();
		author4.setFirstName("nakamura");
		author4.setLastName("tarou");
		authorService.create(author4);
		mockMvc.perform(get("/as/authors")).andExpect(jsonPath("$", hasSize(3)));
		
		long id = authorRepository.findByFirstName("nakamura").getAuthorId();
		mockMvc.perform(delete("/as/authors/" + id));

		mockMvc.perform(get("/as/authors"))
				.andExpect(jsonPath("$", hasSize(2)));
		
	}

}
