/*
 * All Rights Reserved by Athenaeum Society 2015-
 * Written by Inotakuya
 */
package com.as.springbook.domain;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "book")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Book {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long bookId;

	private String title;

	private int price;

	@ManyToMany
	private List<Author> authors = new ArrayList<Author>();

}
