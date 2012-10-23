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

    Collection<Library> allocateBooks(final String book, final int quantity);

    Collection<Library> getAllLibraries();
}
