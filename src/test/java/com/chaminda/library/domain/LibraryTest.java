/**
 * 
 */
package com.chaminda.library.domain;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.HashMap;
import java.util.Map;

import org.junit.Before;
import org.junit.Test;

/**
 * @author chamindaa
 * 
 *         date Oct 20, 2012
 */
public class LibraryTest {

	Library library;

	@Before
	public void SetUp() {
		library = new Library();

	}

	@Test
	public void setAndGetId() {
		library.setId(30L);
		assertEquals((Long) 30L, library.getId());
	}

	@Test
	public void setAndGetName() {
		library.setName("Logan");
		assertEquals("Logan", library.getName());
	}

	@Test
	public void setAndGetWeighting() {
		library.setWeighting(10);
		assertEquals((Integer) 10, library.getWeighting());
	}

	@Test
	public void setAndGetAllocations() {
		Map<String, BookAllocation> map = new HashMap<String, BookAllocation>();
		BookAllocation book = new BookAllocation();
		book.setTitle("Test");
		map.put(book.getTitle(), book);
		library.setAllocations(map);
		assertNotNull(library.getAllocations());
		assertEquals(1, library.getAllocations().size());
	}

}
