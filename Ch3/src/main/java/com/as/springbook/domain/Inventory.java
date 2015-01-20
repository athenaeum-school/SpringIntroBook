/**
 * All Rigths Reserved by Athenaeum Society
 * 2015-
 * Written by Masaki Komatsu
 */

package com.as.springbook.domain;

import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OrderColumn;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;
import javax.persistence.Id;

import org.hibernate.annotations.IndexColumn;
import org.hibernate.envers.Audited;
import org.hibernate.envers.NotAudited;
import org.joda.time.DateTime;

@Entity
@Audited
@Table(name="inventory")
public class Inventory extends BaseComponent {

	@ManyToOne
	@NotAudited
	@JoinColumn(name="book_id")
	private Book book;
	
	/**
	 * JPA annotation does not work with Hibernate
	 * Session API. It will work with newer Hibernate
	 * entity manager, but that is out of scope
	 * for this book.
	 */
	
	@PrePersist
    @PreUpdate
    private void prepareIndex() {
        if (book != null) {
            index = book.getInventory().indexOf(this);
        }
    }
	
	@Column(name = "inventory_index_column")
    Integer index = 0;
	
	@OneToMany(fetch=FetchType.EAGER, targetEntity=Rental.class, mappedBy="inventory")
	@IndexColumn(name="rental_index_column")
	private List<Rental> rentals;
	
	@ManyToOne
	@NotAudited
	@JoinColumn(name="library_id")
	private Library library;
	
	@Column(name="return_date")
	private Date return_date;
	
	@Column(name="rental_date")
	private Date rental_date;
	
	@Column(name="stock")
	private Long stock;
	
	public Inventory() {
		super();
	}

    public Inventory(final Book book) {
        super();
        this.book = book;
    }

	 /**
     * <p>Availability is concerned with whether the inventory exists on the group of libraries. A inventory could be marked as
     * unavailable but still be considered 'active' where you have the book left on the search but not actually rent
     * it. This defaults to true</p>
     * 
     */
	public Boolean isAvailable() {
		
		return true;
	}

	 /**
     * <p>Return Date is the current date adding duration 
     * as well as the staff's manual input.
     * This defaults to one week after the rental date.</p>
     * 
     */
	public Date getReturnDate() {
		// TODO Auto-generated method stub
		return null;
	}

	public void setReturnDate() {
		// TODO Auto-generated method stub
		
	}

	public Date getRentalDate() {
		// TODO Auto-generated method stub
		return null;
	}

	public void setRentalDate() {
		// TODO Auto-generated method stub
		
	}

	public Book getBook() {
		return this.book;
	}

	public void setBook(Book book) {
		this.book = book;
	}

	public List<Rental> getRental() {
		return this.rentals;
	}

	public void setRental(List<Rental> rentals) {
		this.rentals = rentals;
	}
	
	public Long getStock() {
		return this.stock;
	}
	
	public void setStock(Long stock) {
		this.stock = stock;
	}
	
	public int getIndex(){
		return this.index;
	}
	
	public void setIndex(Integer index) {
		this.index = index;
	}

    public static class InventoryBuilder {
        Inventory target;
        Book dependant;

        InventoryBuilder(String title, String firstName, String lastName, Date publishedYear) {
            target = new Inventory();
            dependant = new Book();
            dependant.setTitle(title);
            dependant.setFirstName(firstName);
            dependant.setLastName(lastName);
            dependant.setPublishedYear(publishedYear);
            target.setBook(dependant);
        }

        public Inventory build() {
            return target;
        }
    }

}
