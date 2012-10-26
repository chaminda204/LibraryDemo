/**
 * 
 */
package com.chaminda.library.service;

import java.util.Collection;

import com.chaminda.library.domain.Library;

/**
 * @author chamindaa
 * 
 *         date Oct 19, 2012
 */
public interface ILibraryService {

	/**
	 * This operation allocate books to the libraries which are in the database.
	 * The books will be allocated based on the weighting.
	 * 
	 * @param book
	 *            name of the book to be allocated.
	 * @param quantity
	 *            no of books to be allocated.
	 * @return Collection of allocated libraries.
	 */
	Collection<Library> allocateBooks(final String book, final int quantity);

	/**
	 * returns all the libraries in the databse.
	 * 
	 * @return collection of libraries.
	 */
	Collection<Library> getAllLibraries();
}
