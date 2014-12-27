package com.as.springbook.domain;

import javax.persistence.*;

@Entity
@Table(name = "book")
public class Book {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "book_id")
	private long bookId;

	@Column(name = "title")
	private String title;

	@Column(name = "price")
	private int price;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "authorId")
	private Author author;

	public long getBookId() {
		return bookId;
	}

	public void setBookId(long bookId) {
		this.bookId = bookId;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public Author getAuthor() {
		return author;
	}

	public void setAuthor(Author author) {
		this.author = author;
	}

	@Override
	public String toString() {
		return "Book [bookId=" + bookId + ", title=" + title + ", price="
				+ price + ", author=" + author + "]";
	}

	
}
