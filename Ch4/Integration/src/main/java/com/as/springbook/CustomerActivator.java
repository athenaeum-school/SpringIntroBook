package com.as.springbook;

import com.as.springbook.domain.Blog;

public class CustomerActivator {

	public Blog customerEnricher(Blog blog){
		blog.setCustomer("カスタマーサービス");
		System.out.println("customerActivator: " + blog);
		return blog;
	}
}
