/**
 * 
 */
package com.chaminda.library.service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;

import com.chaminda.library.dao.ILibraryDao;
import com.chaminda.library.domain.BookAllocation;
import com.chaminda.library.domain.Library;

/**
 * @author chamindaa
 * 
 *         date Oct 19, 2012
 */
public class LibraryServiceImpl implements ILibraryService {

	private static final int VALUE_ONE = 1;
	private static final int VALUE_ZERO = 0;
	private static final double VALUE_HUNDRED_PERCENT = .01;

	ILibraryDao libraryDao;

	public Collection<Library> allocateBooks(final String book, int quantity) {
		Collection<Library> allocatedLibraries = null;
		if (validateQuantity(quantity)) {

			final Collection<Library> allLibrariesToBeAllocated = libraryDao.getAllLibraries();

			if (allLibrariesToBeAllocated != null && !allLibrariesToBeAllocated.isEmpty()) {

				// To make sure highest weighting gets the priority.
				List<Library> listOfLibrariesToBeAllocated = new ArrayList<Library>();
				listOfLibrariesToBeAllocated.addAll(allLibrariesToBeAllocated);
				Collections.sort(listOfLibrariesToBeAllocated, Collections.reverseOrder());

				// Temp allocation logic depends on the Sorted Collection
				allocatedLibraries = allocateBooksForLibraries(book, quantity, listOfLibrariesToBeAllocated);

				// Save allocated libraries
				libraryDao.saveLibraries(allocatedLibraries);

			}

		}

		return allocatedLibraries;
	}

	private boolean validateQuantity(int quantity) {
		return quantity > 0;
	}

	/*
	 * Calculate the number of books to be allocated and returns remaining
	 * quantity to be allocated. The libraries to be allocated is a sorted
	 * collection.
	 */
	private Collection<Library> allocateBooksForLibraries(final String book, final int quantity,
			final Collection<Library> allLibrariesToBeAllocated) {

		final Collection<Library> allocatedLibraries = new HashSet<Library>();

		int remaningQty = quantity;

		for (Library library : allLibrariesToBeAllocated) {

			if (library.getWeighting() != null && library.getWeighting() > 0) {

				int noOfBooksToBeAllocated = (int) (quantity * (library.getWeighting() * VALUE_HUNDRED_PERCENT));

				// if there are books to be allocated and the weighting is low.
				// Then, allocate books for less priority libraries
				if (noOfBooksToBeAllocated == VALUE_ZERO) {
					noOfBooksToBeAllocated = VALUE_ONE;
				}

				// If the book is already in the library,add the book
				if (library.getAllocations().containsKey(book)) {
					BookAllocation allocatedBook = library.getAllocations().get(book);
					allocatedBook.setAllocatedQuantity(allocatedBook.getAllocatedQuantity() + noOfBooksToBeAllocated);
				} else {
					// New Book
					final BookAllocation newAllocation = new BookAllocation();
					newAllocation.setTitle(book);
					newAllocation.setAllocatedQuantity(noOfBooksToBeAllocated);
					library.getAllocations().put(book, newAllocation);
				}

				allocatedLibraries.add(library);
				remaningQty = remaningQty - noOfBooksToBeAllocated;

				// If the books are less than the libraries, exit.
				if (remaningQty == VALUE_ZERO) {
					break;
				}
			}

		}

		// If there is a remainder allocate one each for highest priority.
		if (validateQuantity(remaningQty)) {

			for (Library library : allLibrariesToBeAllocated) {
				if (remaningQty == VALUE_ZERO) {
					break;
				}
				remaningQty--;

				final BookAllocation allocatedBook = library.getAllocations().get(book);
				allocatedBook.setAllocatedQuantity(allocatedBook.getAllocatedQuantity() + VALUE_ONE);
				allocatedLibraries.add(library);
			}
		}

		return allocatedLibraries;
	}

	/**
	 * 
	 */
	public Collection<Library> getAllLibraries() {

		final Collection<Library> books = libraryDao.getAllLibraries();
		return books;
	}

	/**
	 * Setter method for libraryDao
	 * 
	 * @param libraryDao
	 *            for setting libraryDao value
	 */
	public void setLibraryDao(ILibraryDao libraryDao) {
		this.libraryDao = libraryDao;
	}

}
