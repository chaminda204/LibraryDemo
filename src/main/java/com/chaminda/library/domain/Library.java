/**
 * 
 */
package com.chaminda.library.domain;

import java.util.HashMap;
import java.util.Map;

/**
 * @author chamindaa
 * 
 *         date Oct 19, 2012
 */
public class Library extends AbstractEntity implements Comparable<Library> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 6642118798267932622L;

	private Long id;

	private String library;

	private Integer weighting;

	private Map<String,BookAllocation> allocations;

	public Library() {
		allocations = new HashMap<String,BookAllocation>();
	}

	/**
	 * Getter method for allocations
	 * 
	 * @return the allocations
	 */
	public Map<String,BookAllocation> getAllocations() {
		return allocations;
	}

	/**
	 * Setter method for allocations
	 * 
	 * @param allocations
	 *            for setting allocations value
	 */
	public void setAllocations(Map<String,BookAllocation> allocations) {
		this.allocations = allocations;
	}

	/**
	 * Getter method for id
	 * 
	 * @return the id
	 */
	public Long getId() {
		return id;
	}

	/**
	 * Setter method for id
	 * 
	 * @param id
	 *            for setting id value
	 */
	public void setId(final Long id) {
		this.id = id;
	}

	/**
	 * Getter method for name
	 * 
	 * @return the name
	 */
	public String getName() {
		return library;
	}

	/**
	 * Setter method for name
	 * 
	 * @param name
	 *            for setting name value
	 */
	public void setName(final String name) {
		this.library = name;
	}

	/**
	 * Getter method for weighting
	 * 
	 * @return the weighting
	 */
	public Integer getWeighting() {
		return weighting;
	}

	/**
	 * Setter method for weighting
	 * 
	 * @param weighting
	 *            for setting weighting value
	 */
	public void setWeighting(final Integer weighting) {
		this.weighting = weighting;
	}

	@Override
	public String toString() {

		final StringBuilder builder = new StringBuilder("DataObject [library=");
		builder.append(library);
		builder.append(", weighting=");
		builder.append(weighting + "  %");
		builder.append(" , weighting=");
		// builder.append(allocations);
		builder.append("]");
		return builder.toString();
	}

	@Override
	public int compareTo(Library library) {
		int result = 0;
		result =  weighting - library.getWeighting();
		return result;
	}
}
