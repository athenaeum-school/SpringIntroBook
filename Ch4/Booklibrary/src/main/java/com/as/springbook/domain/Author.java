package com.as.springbook.domain;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import com.fasterxml.jackson.annotation.JsonIgnore;

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
	@ManyToMany(mappedBy = "authors",cascade=CascadeType.ALL)
	private List<Book> books = new ArrayList<Book>();
	

}