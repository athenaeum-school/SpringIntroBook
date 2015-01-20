/**
 * All Rigths Reserved by Athenaeum Society
 * 2015-
 * Written by Masaki Komatsu
 */

package com.as.springbook.domain;

import java.util.Date;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;

import org.hibernate.envers.Audited;
import org.hibernate.envers.NotAudited;

@Entity
@Audited
@Table(name="rental")
public class Rental extends BaseComponent {

	@ManyToOne
	@NotAudited
	@JoinColumn(name="inventory_id")
	private Inventory inventory;

	/**
	 * JPA annotation will not work with Hibernate
	 * Session API. It will work with newer Hibernate
	 * entity manager, but that is out of scope
	 * for this book.
	 */
	
	@PrePersist
    @PreUpdate
    private void prepareIndex() {
        if (inventory != null) {
            index = inventory.getRental().indexOf(this);
        }
    }
	
	@Column(name = "rental_index_column")
    Integer index = 0;
	
	@ManyToOne
	@NotAudited
	@JoinColumn(name="client_id")
	private Client client;
	
	@ManyToOne
	@NotAudited
	@JoinColumn(name="staff_id")
	private Staff staff;
	
	@Column(name="active")
	private Boolean active;
	
	/**
	 * Get the client object.
	 * @return Client
	 */
	public Client getClient() {
		return this.client;
	}

	public void setClient(Client client) {
		this.client = client;
	}


	/**
	 * Get the inventory object.
	 * @return Inventory
	 */
	public Inventory getInventory() {
		return this.inventory;
	}

	public void setInventory(Inventory inventory) {
		this.inventory = inventory;
	}
	
	public Boolean getActive() {
		return this.active;
	}
	
	public void setActive(Boolean active) {
		this.active = active;
	}
	
	public Integer getIndex() {
		return this.index;
	}
	
	public void setIndex(Integer index) {
		this.index = index;
	}
	
	
	/**
	 * Active Record pattern illustrated below.
	 */

	/**
	 * Checkout is limited to the act of renting.
	 * Method can be extended to the inter-library
	 * book shares for extensibility. 
	 * Default behaviour adds record to the rental table.
	 */
	public void Checkout(String isbn) {
		setActive(true);
	}

	/**
	 * ReturnBook simply means returning the book to the library
	 */
	public void ReturnBook() {
		setActive(false);
	}
	
    public static class RentalBuilder {
        Rental target;

        RentalBuilder(String title, Date publishedYear) {
            target = new Rental();
            //target.title = title;
            //target.publishedYear = publishedYear;
        }

        public Rental build() {
            return target;
        }
    }

}
