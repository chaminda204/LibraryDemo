/**
 * 
 */
package com.chaminda.library.dao;

import java.util.*;

import com.chaminda.library.domain.Library;
import com.chaminda.library.util.DatabaseUtil;

/**
 * This class represents the CRUD operations of the database. the data will be
 * held on a map and will not be saved to a database. Once the program exits,
 * the data will be lost.
 * 
 * @author chamindaa
 * 
 *         date Oct 19, 2012
 */
public class LibraryDaoImpl implements ILibraryDao {

	private Map<String, Library> database;

	public LibraryDaoImpl() {
		database = new HashMap<String, Library>();
		database = DatabaseUtil.loadInitialData();
	}

	public Collection<Library> getAllLibraries() {
		return database.values();
	}

	public Library getLibraryByName(final String name) {
		Library library = null;

		if (database.containsKey(name)) {
			library = database.get(name);
		}

		return library;
	}

	public void saveLibrary(final Library library) {
		database.put(library.getName(), library);

	}

	public void saveLibraries(final Collection<Library> libraries) {
		for (Library library : libraries) {
			database.put(library.getName(), library);
		}

	}

}
