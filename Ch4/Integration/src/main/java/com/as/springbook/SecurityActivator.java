package com.as.springbook;

import java.io.UnsupportedEncodingException;

import com.as.springbook.domain.Blog;

public class SecurityActivator {

	public Blog outPrint(Blog blog) throws UnsupportedEncodingException{
		System.out.println("securityActivator: " + blog);
		return blog;
	}
}
