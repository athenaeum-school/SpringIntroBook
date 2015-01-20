/**
 * All Rigths Reserved by Athenaeum Society
 * 2015-
 * Written by Masaki Komatsu
 */

package com.as.springbook.domain;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.OrderColumn;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.annotations.IndexColumn;

import com.as.springbook.annotation.PermissionRequired;
import com.as.springbook.annotation.RetryLock;

@Entity
@Table(name="book", uniqueConstraints={
		   @UniqueConstraint(columnNames={"published_year","author_first_name", "author_last_name"})
		})
public class Book extends BaseComponent {

	@Column(name="title")
	@NotNull
	@Size(min=2,max=40,message="Title is too long.")
	private String title;
	
	@OneToMany(fetch=FetchType.EAGER, targetEntity=Inventory.class, mappedBy="book")
	@IndexColumn(name = "inventory_index_column")
	private List<Inventory> inventories;
	
	@Column(name="isbn")
	private String isbn;
	
	/**
	 * author is treated as an atomic string, that is,
	 * only single author is assumed. ManyToMany relation
	 * is suitable for the multiple authors.
	 * 
	 */
	@Column(name="author_first_name")
	private String firstName;
	
	@Column(name="author_last_name")
	private String lastName;	
	
	/**
	 * description field commonly requires fulltext
	 * searches, but that is not included in our
	 * scope.
	 */
	@Column(name="description")
	@Size(max=255)
	private String description;
	
	@Column(name="published_year")
	private Date publishedYear;
	
	@Column(name="rental_duration")
	private Long duration;
	
	public Book() {
		super();
	}
	
	/**
	 * @author komatsu
	 * @param Set<InventoryImpl>
	 */
	public List<Inventory> getInventory() {
		return this.inventories;
	}

	public void setInventory(List<Inventory> inventories) {
		this.inventories = inventories;
	}

	public String getTitle() {
		return this.title;
	}

	/**
	 * 
	 * @param title
	 */
	public void setTitle(String title) {
		this.title = title;
	}

	/**
	 * 
	 * @return String description
	 */
	public String getDescription() {
		return this.description;
	}

	/**
	 * 
	 * @param description
	 */
	public void setDescription(String description) {
		this.description = description;
	}
	
	public Date getPublishedYear() {
		return this.publishedYear;
	}
	
	public void setPublishedYear(Date publishedYear) {
		this.publishedYear = publishedYear;
	}
	
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	
	public String getFirstName() {
		return this.firstName;
	}
	
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	
	public String getLastName() {
		return this.lastName;
	}
	
	public String getIsbn() {
		return this.isbn;
	}
	
	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}
	
	/**
	 * Active Record Pattern implemented below.
	 * @author komatsu
	 *
	 */

    public static class BookBuilder {
        Book target;

        BookBuilder(String title, String firstName, String lastName, String publishedYear) {
            target = new Book();
            target.title = title;
            target.firstName = firstName;
            target.lastName = lastName;
            
            SimpleDateFormat formatter = new SimpleDateFormat("yyyy");
  
        	try {         
        		target.publishedYear = formatter.parse(publishedYear);        
        	} catch (ParseException e) {
        		e.printStackTrace();
        	}
        }

        public Book build() {
            return target;
        }
    }

}
