package com.as.springbook.web;

import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {
		"file:src/main/resources/spring/application-config.xml",
		"file:src/main/webapp/WEB-INF/mvc-config.xml" })
public class BookControllerTest {

	@Test
	public void testGetBooks() {
	}

	@Test
	public void testGetBook() {
	}

	@Test
	public void testPostBook() {
	}

	@Test
	public void testPutBook() {
	}

	@Test
	public void testDeleteBook() {
	}

}
