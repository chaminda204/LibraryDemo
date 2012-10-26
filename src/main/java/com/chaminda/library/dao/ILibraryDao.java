/**
 * 
 */
package com.chaminda.library.dao;

import java.util.Collection;

import com.chaminda.library.domain.Library;

/**
 * @author chamindaa
 * 
 *         date Oct 19, 2012
 */
public interface ILibraryDao {

	/**
	 * this operations returns all the libraries in the database.
	 * 
	 * @return collection of libraries.
	 */
	Collection<Library> getAllLibraries();

	/**
	 * This operation returns the requested library by name.
	 * 
	 * @param name
	 *            name of the library to be returned.
	 * @return requested library instance.
	 */
	Library getLibraryByName(final String name);

	/**
	 * saves the given library.
	 * 
	 * @param library
	 *            to be saved.
	 */
	void saveLibrary(final Library library);

	/**
	 * Saves collection of libraries to be saved.
	 * 
	 * @param libraries
	 *            collection of libraries to be saved.
	 */
	void saveLibraries(final Collection<Library> libraries);
}
