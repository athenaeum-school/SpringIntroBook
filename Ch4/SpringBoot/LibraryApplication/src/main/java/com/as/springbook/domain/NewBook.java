/*
* All Rights Reserved by Athenaeum Society 2015-
* Written by Inotakuya
*/
package com.as.springbook.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import lombok.Data;

@Entity
@Data
public class NewBook {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long bookId;

	private String title;

	private int price;

	@ManyToOne
	@JoinColumn(name = "id")
	private Person person;
}
