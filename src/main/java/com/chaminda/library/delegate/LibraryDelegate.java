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
	 * 
	 * @param book
	 * @param quantity
	 * @return
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
