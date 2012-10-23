/**
 * 
 */
package com.chaminda.library.dao;

import java.util.Collection;

import com.chaminda.library.domain.Library;

/**
 * @author chamindaa
 * 
 * date Oct 19, 2012
 */
public interface ILibraryDao {
	
	Collection<Library> getAllLibraries();
	
	Library getLibraryByName(final String name);
	
	void saveLibrary(final Library library);

	void saveLibraries(final Collection<Library> libraries);
}
