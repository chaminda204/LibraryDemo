/**
 * 
 */
package com.chaminda.library.domain;

import static org.junit.Assert.*;
import junit.framework.Assert;


import org.junit.Before;
import org.junit.Test;

/**
 * @author chamindaa
 * 
 *         date Oct 19, 2012
 */
public class BookAllocationTest {

	BookAllocation allocation;

	@Before
	public void setUpBeforeClass() throws Exception {
		allocation = new BookAllocation();
	}
	
	@Test
	public void setAndGetAllocatedQuantity(){
		allocation.setAllocatedQuantity(5);
		assertEquals((Integer)5, allocation.getAllocatedQuantity());
	}
	
	@Test
	public void setAndGetID(){
		allocation.setId(10L);
		assertEquals((Long)10L, allocation.getId());
	}
	
	@Test
	public void setAndGetTitle(){
		allocation.setTitle("Head First EJB");
		assertEquals("Head First EJB", allocation.getTitle());
	}

}
