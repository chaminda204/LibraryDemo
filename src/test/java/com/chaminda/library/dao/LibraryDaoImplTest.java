/**
 * 
 */
package com.chaminda.library.dao;

import junit.framework.Assert;

import org.junit.Before;
import org.junit.Test;

import com.chaminda.library.domain.Library;

/**
 * @author chamindaa
 * 
 *         date Oct 22, 2012
 */
public class LibraryDaoImplTest {

	ILibraryDao impl = null;

	@Before
	public void setUp() {

		// TODO Load from Spring
		impl = new LibraryDaoImpl();
	}

	@Test
	public void testGetAllLibraries() {
		Assert.assertEquals(5, impl.getAllLibraries().size());
	}

	@Test
	public void testGetLibraryByName() {
		Assert.assertEquals("Logan", impl.getLibraryByName("Logan").getName());
	}
	
	@Test
	public void testSaveLibrary() {
		Library newLibrary = new Library();
		newLibrary.setName("New Library");
		impl.saveLibrary(newLibrary);
		Assert.assertEquals("New Library", impl.getLibraryByName("New Library").getName());
	}

}
