/**
 * 
 */
package com.chaminda.library.delegate;

import java.util.Collection;

import com.chaminda.library.domain.Library;
import com.chaminda.library.service.ILibraryService;

/**
 * @author chamindaa
 * 
 *         date Oct 21, 2012
 */
public class LibraryDelegate {

	ILibraryService libraryService;

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
	public Collection<Library> allocateBooks(final String book, int quantity) {

		Collection<Library> allocatedBooks = libraryService.allocateBooks(book, quantity);

		return allocatedBooks;

	}

	public Collection<Library> getAllLibraries() {

		final Collection<Library> books = libraryService.getAllLibraries();

		return books;
	}

	/**
	 * Setter method for libraryService
	 * 
	 * @param libraryService
	 *            for setting libraryService value
	 */
	public void setLibraryService(ILibraryService libraryService) {
		this.libraryService = libraryService;
	}

}
