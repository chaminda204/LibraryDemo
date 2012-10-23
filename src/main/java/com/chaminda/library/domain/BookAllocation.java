/**
 * 
 */
package com.chaminda.library.domain;

/**
 * @author chamindaa
 * 
 * date Oct 19, 2012
 */
public class BookAllocation extends AbstractEntity {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -218407475786512079L;

	private Long id;
	
	private String title;
	
	private Integer allocatedQuantity;

	
	/**
	 * Getter method for id
	 *
	 * @return the id
	 */
	public Long getId() {
		return id;
	}

	/**
	 * Getter method for allocatedQuantity
	 *
	 * @return the allocatedQuantity
	 */
	public Integer getAllocatedQuantity() {
		return allocatedQuantity;
	}

	/**
	 * Setter method for allocatedQuantity
	 *
	 * @param allocatedQuantity for setting allocatedQuantity value
	 */
	public void setAllocatedQuantity(Integer allocatedQuantity) {
		this.allocatedQuantity = allocatedQuantity;
	}

	/**
	 * Setter method for id
	 *
	 * @param id for setting id value
	 */
	public void setId(Long id) {
		this.id = id;
	}

	/**
	 * Getter method for title
	 *
	 * @return the title
	 */
	public String getTitle() {
		return title;
	}

	/**
	 * Setter method for title
	 *
	 * @param title for setting title value
	 */
	public void setTitle(String title) {
		this.title = title;
	}


	
}
