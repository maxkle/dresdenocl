package org.dresdenocl.examples.royalandloyal.ocl22javacode.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.dresdenocl.examples.royalandloyal.ocl22javacode.Customer;
import org.dresdenocl.examples.royalandloyal.ocl22javacode.CustomerCard;
import org.dresdenocl.examples.royalandloyal.ocl22javacode.Date;
import org.dresdenocl.examples.royalandloyal.ocl22javacode.LoyaltyAccount;
import org.dresdenocl.examples.royalandloyal.ocl22javacode.Membership;
import org.junit.Test;


/**
 * <p>
 * Provides some tests to tests the generated aspects for body constraints.
 * </p>
 * 
 * @author Claas Wilke
 */
public class TestBodyAspects {

	/**
	 * <p>
	 * Tests the generated Aspect {@link BodyAspect2}.
	 * </p>
	 */
	@Test
	public void testBodyAspect2() {
	
		LoyaltyAccount account1;
		Membership membership1;
		CustomerCard card1;
		Customer owner1;
		
		account1 = new LoyaltyAccount();
		
		membership1 = new Membership();
		account1.setMembership(membership1);
		
		card1 = new CustomerCard();
		membership1.setCard(card1);
		
		owner1 = new Customer(21);
		card1.setOwner(owner1);
		
		assertEquals("", account1.getCustomerName());
		
		owner1.setName("owner1");
		assertEquals("owner1", account1.getCustomerName());
	}

	/**
	 * <p>
	 * Tests the generated Aspect {@link BodyAspect3}.
	 * </p>
	 */
	@Test
	public void testBodyAspect3() {
		
		assertNotNull(Date.nowAsString());	
	}
}