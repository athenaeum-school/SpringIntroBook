/*
* All Rights Reserved by Athenaeum Society 2015-
* Written by Inotakuya
*/
package com.as.springbook.domain;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import org.codehaus.jackson.annotate.JsonIgnore;


@Entity
@Table(name = "author")
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString(exclude = "books")
public class Author {



	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long authorId;

	private String firstName;

	private String lastName;

	@JsonIgnore
	@ManyToMany(mappedBy = "authors",cascade=CascadeType.ALL,fetch=FetchType.EAGER)
	private List<Book> books = new ArrayList<Book>();
	

}