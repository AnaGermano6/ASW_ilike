package ilike.shared;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.io.Serializable;

import org.junit.Test;

import ilike.TestData;

/**
 * Tests on items, container of item instances
 * 
 * @author José Paulo Leal <zp@dcc.fc.up.pt>
 */
public class ItemTest extends TestData {  
	
	/**
	 * Check item creation, must be serializable
	 */
	@Test
	public void testItem() {
		Item item = new Item(IDS[0],NAMES[0],null);
		
		assertNotNull(item);
		assertTrue(item instanceof Serializable);
	}

	/**
	 * Create items with different IDs and names
	 */
	@Test
	public void testId() {
		for(String id: IDS) {
			for(String name: NAMES) {
				Item item = new Item(id,name,TAGS);
		
				assertEquals(id,item.getId());
			}
		}
	}

	/**
	 * Test name setter and getter
	 */
	@Test
	public void testNameSetterGetter() {		
		Item item = new Item(IDS[0],NAMES[0],null);
		
		for(String name: NAMES) {
			item.setName(name);
			assertEquals(name,item.getName());
		}
	}

	/**
	 * Test tag getter and setter
	 * Tags must return an empty set, event if a null was inserted
	 */
	@Test
	public void testGetTags() {
		Item item = new Item(IDS[0],NAMES[0],null);
		
		assertEquals(0,item.getTags().size());
		item.setTags(TAGS);
		assertEquals(TAGS,item.getTags());
		
		item.setTags(null);
		assertEquals(0,item.getTags().size());
	}

	
	/**
	 * Check if instances are equal to themselves, 
	 * to other instances with the same properties,
	 * but different from instances with different properties.
	 */
	@Test
	public void testEquals() {
		Item item0 = new Item(IDS[0],NAMES[0],null);
		Item itemO = new Item(IDS[0],NAMES[0],null);
		Item item1 = new Item(IDS[1],NAMES[1],null);
		
		assertTrue(item0.equals(item0));
		assertTrue(item1.equals(item1));
		assertTrue(itemO.equals(itemO));
		
		assertEquals(item0,itemO);
		assertTrue(itemO.equals(item0));
		assertFalse(item0.equals(item1));
		assertFalse(item1.equals(item0));
		
		item0.setTags(TAGS);
		
		assertFalse(item0.equals(itemO));
		assertFalse(itemO.equals(item0));
		
		itemO.setTags(TAGS);
		
		assertTrue(itemO.equals(item0));
		assertTrue(item0.equals(itemO));
	}
}
