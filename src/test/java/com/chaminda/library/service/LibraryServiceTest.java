/**
 * 
 */
package com.chaminda.library.service;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.mockito.BDDMockito.given;
import static org.mockito.MockitoAnnotations.initMocks;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;

import com.chaminda.library.dao.ILibraryDao;
import com.chaminda.library.domain.BookAllocation;
import com.chaminda.library.domain.Library;

/**
 * @author chamindaa
 * 
 *         date Oct 22, 2012
 */
public class LibraryServiceTest {

	@InjectMocks
	ILibraryService iLibraryService;

	@Mock
	ILibraryDao dao;

	@Before
	public void beforeMethod() {
		iLibraryService = new LibraryServiceImpl();
		initMocks(this);
	}

	@Test
	public void testGetAllAllocations() {

		// Given

		given(iLibraryService.getAllLibraries()).willReturn(getLibrariesforGetAllLibraries());

		// When
		Collection<Library> libraries = iLibraryService.getAllLibraries();

		// Then
		assertEquals(5, libraries.size());

	}

	@Test
	public void bookAllocationForZeroBooks() {
		// Given 5 Libraries with different weighting.
		given(iLibraryService.getAllLibraries()).willReturn(getLibrariesforGetAllLibraries());

		// When allocate zero books
		Collection<Library> allocationforZeroBooks = iLibraryService.allocateBooks("Head First EJB", 0);

		// Then - The collection should be null
		assertNull("Allocation for zero books should return a null value", allocationforZeroBooks);

	}

	@Test
	public void bookAllocationsForThreeBooks() {

		// Given 5 Libraries with different weighting.
		given(iLibraryService.getAllLibraries()).willReturn(getLibrariesforGetAllLibraries());

		// When allocate Ten books
		Collection<Library> allocationforThreeBooks = iLibraryService.allocateBooks("Head First EJB", 3);

		// Then - Allocation for Mt Gravett Should be 1, Gold Coast 1, Logan 0,
		// Helenswale 0

		BookAllocation bookAllocationForMtGravettFor3Books = null;
		BookAllocation bookAllocationForGoldCoastFor3Books = null;
		BookAllocation bookAllocationForLoganFor3Books = null;
		BookAllocation bookAllocationForHellanswaleFor3Books = null;
		for (Library library : allocationforThreeBooks) {
			if (library.getName().equals("Mt Gravett")) {
				Map<String, BookAllocation> mtGravett = library.getAllocations();
				bookAllocationForMtGravettFor3Books = mtGravett.get("Head First EJB");
			}
			if (library.getName().equals("Gold Coast")) {
				Map<String, BookAllocation> goldCoast = library.getAllocations();
				bookAllocationForGoldCoastFor3Books = goldCoast.get("Head First EJB");
			}

			if (library.getName().equals("Logan")) {
				Map<String, BookAllocation> logan = library.getAllocations();
				bookAllocationForLoganFor3Books = logan.get("Head First EJB");
			}
			if (library.getName().equals("Hellanswale")) {
				Map<String, BookAllocation> logan = library.getAllocations();
				bookAllocationForHellanswaleFor3Books = logan.get("Head First EJB");
			}

		}
		assertEquals("Mt Gravett QTY was Wrong for 3 Books", (Integer) 1,
				bookAllocationForMtGravettFor3Books.getAllocatedQuantity());
		assertEquals("Gold Coast QTY was Wrong for 3 Books", (Integer) 1,
				bookAllocationForGoldCoastFor3Books.getAllocatedQuantity());
		assertNull("Logan should be null for 3 books", bookAllocationForLoganFor3Books);
		assertNull("Helenwale should be null for 3 books", bookAllocationForHellanswaleFor3Books);
	}

	@Test
	public void bookAllocationsForFiveBooks() {

		// Given 5 Libraries with different weighting.
		given(iLibraryService.getAllLibraries()).willReturn(getLibrariesforGetAllLibraries());

		// When allocate five books
		Collection<Library> allocationforFiveBooks = iLibraryService.allocateBooks("Head First EJB", 5);

		// Then - Allocation for Mt Gravett Should be 2, Gold Coast 1, Logan 1,
		// Helanswale 0
		BookAllocation bookAllocationForMtGravettFor5Books = null;
		BookAllocation bookAllocationForGoldCoastFor5Books = null;
		BookAllocation bookAllocationForLoganFor5Books = null;
		BookAllocation bookAllocationForHellanswaleFor5Books = null;

		for (Library library : allocationforFiveBooks) {
			if (library.getName().equals("Mt Gravett")) {
				Map<String, BookAllocation> mtGravett = library.getAllocations();
				bookAllocationForMtGravettFor5Books = mtGravett.get("Head First EJB");
			}
			if (library.getName().equals("Gold Coast")) {
				Map<String, BookAllocation> goldCoast = library.getAllocations();
				bookAllocationForGoldCoastFor5Books = goldCoast.get("Head First EJB");
			}

			if (library.getName().equals("Logan")) {
				Map<String, BookAllocation> mtGravett = library.getAllocations();
				bookAllocationForLoganFor5Books = mtGravett.get("Head First EJB");
			}
			if (library.getName().equals("Hellanswale")) {
				Map<String, BookAllocation> logan = library.getAllocations();
				bookAllocationForHellanswaleFor5Books = logan.get("Head First EJB");
			}
		}
		assertEquals("Mt Gravett QTY was Wrong for 5 Books", (Integer) 2,
				bookAllocationForMtGravettFor5Books.getAllocatedQuantity());
		assertEquals("Gold Coast QTY was Wrong for 5 Books", (Integer) 1,
				bookAllocationForGoldCoastFor5Books.getAllocatedQuantity());
		assertEquals("Logan QTY was Wrong for 5 Books", (Integer) 1,
				bookAllocationForLoganFor5Books.getAllocatedQuantity());
		assertEquals(4, allocationforFiveBooks.size());
		assertNull("Helenwale should be null for 5 books", bookAllocationForHellanswaleFor5Books);

	}

	@Test
	public void bookAllocationsForTenBooks() {

		// Given 5 Libraries with different weighting.
		given(iLibraryService.getAllLibraries()).willReturn(getLibrariesforGetAllLibraries());

		// When allocate Ten books
		Collection<Library> allocationforTenBooks = iLibraryService.allocateBooks("Head First EJB", 10);

		// Then - Allocation for Mt Gravett Should be 4, Gold Coast 3, Logan 1,
		// Helenswale 0

		BookAllocation bookAllocationForMtGravettFor10Books = null;
		BookAllocation bookAllocationForGoldCoastFor10Books = null;
		BookAllocation bookAllocationForLoganFor10Books = null;
		BookAllocation bookAllocationForHellanswaleFor10Books = null;
		for (Library library : allocationforTenBooks) {
			if (library.getName().equals("Mt Gravett")) {
				Map<String, BookAllocation> mtGravett = library.getAllocations();
				bookAllocationForMtGravettFor10Books = mtGravett.get("Head First EJB");
			}
			if (library.getName().equals("Gold Coast")) {
				Map<String, BookAllocation> goldCoast = library.getAllocations();
				bookAllocationForGoldCoastFor10Books = goldCoast.get("Head First EJB");
			}

			if (library.getName().equals("Logan")) {
				Map<String, BookAllocation> logan = library.getAllocations();
				bookAllocationForLoganFor10Books = logan.get("Head First EJB");
				if (library.getName().equals("Hellanswale")) {
					Map<String, BookAllocation> helenswale = library.getAllocations();
					bookAllocationForHellanswaleFor10Books = helenswale.get("Head First EJB");
				}
			}
		}
		assertEquals("Mt Gravett QTY was Wrong for 10 Books", (Integer) 4,
				bookAllocationForMtGravettFor10Books.getAllocatedQuantity());
		assertEquals("Gold Coast QTY was Wrong for 10 Books", (Integer) 3,
				bookAllocationForGoldCoastFor10Books.getAllocatedQuantity());
		assertEquals("Logan QTY was Wrong for 10 Books", (Integer) 1,
				bookAllocationForLoganFor10Books.getAllocatedQuantity());
		assertEquals("Collection should retutn 4 libraries", 4, allocationforTenBooks.size());
		assertNull("Helenwale should be null for 10 books", bookAllocationForHellanswaleFor10Books);
	}

	@Test
	public void bookAllocationsForTwelveBooks() {

		// Given 5 Libraries with different weighting.
		given(iLibraryService.getAllLibraries()).willReturn(getLibrariesforGetAllLibraries());

		// When allocate Ten books
		Collection<Library> allocationforTenBooks = iLibraryService.allocateBooks("Head First EJB", 12);

		// Then - Allocation for Mt Gravett Should be 5, Gold Coast 4, Logan 1,

		BookAllocation bookAllocationForMtGravettFor12Books = null;
		BookAllocation bookAllocationForGoldCoastFor12Books = null;
		BookAllocation bookAllocationForLoganFor12Books = null;

		for (Library library : allocationforTenBooks) {
			if (library.getName().equals("Mt Gravett")) {
				Map<String, BookAllocation> mtGravett = library.getAllocations();
				bookAllocationForMtGravettFor12Books = mtGravett.get("Head First EJB");
			}
			if (library.getName().equals("Gold Coast")) {
				Map<String, BookAllocation> goldCoast = library.getAllocations();
				bookAllocationForGoldCoastFor12Books = goldCoast.get("Head First EJB");
			}

			if (library.getName().equals("Logan")) {
				Map<String, BookAllocation> mtGravett = library.getAllocations();
				bookAllocationForLoganFor12Books = mtGravett.get("Head First EJB");
			}
		}
		assertEquals("Mt Gravett QTY was Wrong for 12 Books", (Integer) 5,
				bookAllocationForMtGravettFor12Books.getAllocatedQuantity());
		assertEquals("Gold Coast QTY was Wrong for 12 Books", (Integer) 4,
				bookAllocationForGoldCoastFor12Books.getAllocatedQuantity());
		assertEquals("Logan QTY was Wrong for 12 Books", (Integer) 1,
				bookAllocationForLoganFor12Books.getAllocatedQuantity());
	}

	private Collection<Library> getLibrariesforGetAllLibraries() {

		Map<String, Library> map = new HashMap<String, Library>();
		Library test = new Library();
		test.setId(1L);
		test.setName("Logan");
		test.setWeighting(10);
		map.put(test.getName(), test);

		Library test1 = new Library();
		test1.setId(2L);
		test1.setName("Gold Coast");
		test1.setWeighting(30);
		map.put(test1.getName(), test1);

		Library test2 = new Library();
		test2.setId(3L);
		test2.setName("Toowomba");
		test2.setWeighting(20);
		map.put(test2.getName(), test2);

		Library test3 = new Library();
		test3.setId(4L);
		test3.setName("Mt Gravett");
		test3.setWeighting(40);
		map.put(test3.getName(), test3);

		Library test4 = new Library();
		test4.setId(5L);
		test4.setName("Hellanswale");
		test4.setWeighting(0);
		map.put(test4.getName(), test4);

		return map.values();

	}

}
