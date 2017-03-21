package ilike.socnet;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import java.util.Arrays;
import java.util.LinkedList;

import org.junit.Before;
import org.junit.Test;

import ilike.TestData;
import ilike.shared.Item;

/**
 * Tests on Itens, a container of Item instances
 * 
 * @author José Paulo Leal <zp@dcc.fc.up.pt>
 */
public class ItemsTest extends TestData {

	Items items;
	
	@Before
	public void setUp() throws Exception {
		items = new Items();
		
		Items.setRecentSize(SIZE);
	}

	/**
	 * Check recent size  setter an getter
	 */
	@Test
	public void testRecentSizeGetterSetter() {
		for(int value: INTS) {
			Items.setRecentSize(value);
			assertEquals("Unexpected recent size",value,Items.getRecentSize());
		}
	}

	/**
	 * Only inserted IDs should be recovered
	 */
	@Test
	public void testAddGetItem() {
		Item item1 = new Item(ID1,NAME,TAGS);
		Item item2 = new Item(ID2,NAME,TAGS);
		Item item3 = new Item(ID3,NAME,TAGS);

		assertNull("This item was NOT inserted",items.getItem(ID1));
		assertNull("This item was NOT inserted",items.getItem(ID2));
		assertNull("This item was NOT inserted",items.getItem(ID3));
		
		assertTrue("Non existing IDs can be inserted",items.addItem(item1));
		assertFalse("Existing IDs cannot be reinserted",items.addItem(item1));
		
		assertEquals("This item was inserted",item1,items.getItem(ID1));
		assertNull("This item was NOT inserted",items.getItem(ID2));
		assertNull("This item was NOT inserted",items.getItem(ID3));
		
		assertTrue("Non existing IDs can be inserted",items.addItem(item2));
		assertFalse("Existing IDs cannot be inserted",items.addItem(item2));
		
		assertEquals("This item was inserted",item1,items.getItem(ID1));
		assertEquals("This item was inserted",item2,items.getItem(ID2));
		assertNull("This item was NOT inserted",items.getItem(ID3));
		
		assertTrue("Non existing IDs can be inserted",items.addItem(item3));
		assertFalse("Existing IDs cannot be inserted",items.addItem(item3));
		
		assertEquals("This item was inserted",item1,items.getItem(ID1));
		assertEquals("This item was inserted",item2,items.getItem(ID2));
		assertEquals("This item was inserted",item3,items.getItem(ID3));
	}

	/**
	 * Test getting items of sets of IDs, only added items should be returned
	 */
	@Test
	public void testAddGetItems() {
		Item item1 = new Item(ID1,NAME,TAGS);
		Item item2 = new Item(ID2,NAME,TAGS);
		Item item3 = new Item(ID3,NAME,TAGS);

		assertEquals("No items inserted yet ",
				Arrays.asList(null,null,null), 
				items.getItems(Arrays.asList(ID1,ID2,ID3)));		
		assertEquals("No items inserted yet ",
				Arrays.asList(null,null,null), 
				items.getItems(Arrays.asList(ID2,ID1,ID3)));
		assertEquals("No items inserted yet ",
				Arrays.asList(null,null,null), 
				items.getItems(Arrays.asList(ID3,ID2,ID1)));
		
		items.addItem(item1);
		
		assertEquals("Only item1 was inserted",
				Arrays.asList(item1,null,null), 
				items.getItems(Arrays.asList(ID1,ID2,ID3)));		
		assertEquals("Only item1 was inserted",
				Arrays.asList(null,item1,null), 
				items.getItems(Arrays.asList(ID2,ID1,ID3)));
		assertEquals("Only item1 was inserted",
				Arrays.asList(null,null,item1), 
				items.getItems(Arrays.asList(ID3,ID2,ID1)));		


		
		items.addItem(item2);
		
		assertEquals("Item 3 was not yet inserted",
				Arrays.asList(item1,item2,null), 
				items.getItems(Arrays.asList(ID1,ID2,ID3)));		
		assertEquals("Item 3 was not yet inserted",
				Arrays.asList(item2,item1,null), 
				items.getItems(Arrays.asList(ID2,ID1,ID3)));		
		assertEquals("Item 3 was not yet inserted",
				Arrays.asList(null,item2,item1), 
				items.getItems(Arrays.asList(ID3,ID2,ID1)));		


		items.addItem(item3);

		assertEquals("All inserted ietms were expected",
				Arrays.asList(item1,item2,item3), 
				items.getItems(Arrays.asList(ID1,ID2,ID3)));		
		assertEquals("All inserted ietms were expected",
				Arrays.asList(item2,item1,item3), 
				items.getItems(Arrays.asList(ID2,ID1,ID3)));		
		assertEquals("All inserted ietms were expected",
				Arrays.asList(item3,item2,item1), 
				items.getItems(Arrays.asList(ID3,ID2,ID1)));		


	}

	/**
	 * Only recorded items can be changed
	 * Items return changed values after being changed
	 */
	@Test
	public void testChangeItem() {
		
		assertEquals("This item was NOT inserted",null,items.getItem(ID1));
		
		assertFalse("Cannot be changed yet",items.changeItem(new Item(ID1,NAMES[1],TAGS)));
		
		assertTrue("Can be inserted",items.addItem(new Item(ID1,NAMES[1],TAGS)));
		
		assertEquals("Unexpected name",NAMES[1],items.getItem(ID1).getName());
		
		assertTrue("Item cam be changed",items.changeItem(new Item(ID1,NAMES[2],TAGS)));
		
		assertEquals("Unexpected name",NAMES[2],items.getItem(ID1).getName());
	}

	/**
	 * Items can be removed only after being inserted
	 * An item is not returned after being removed, and only them. 
	 */
	@Test
	public void testRemoveItem() {
		Item item = new Item(ID1,NAME,TAGS);
		
		assertNull("This item was NOT inserted",items.getItem(ID1));
		
		assertFalse("Item cannot be removed yet",items.removeItem(item));	
		
		assertTrue("Item can be added",items.addItem(item));
		
		assertNotNull("Item should be available",items.getItem(ID1));
		
		assertTrue("Item should be removable",items.removeItem(item));	

		assertNull("Item should have been removed",items.getItem(ID1));
	}
	/**
	 * Recent size must be equal of less to SIZE.
	 * First element must be the last inserted.
	 * List must be equal to the reversed list of inserted IDs,
	 * truncated to the first SIZE elements.
	 */
	@Test
	public void testGetRecent() {
		LinkedList<Item> recent = new LinkedList<>();
		
		for(int i=1; i<= SIZE;i++) {
			String id = "id"+i;
			Item item = new Item(id,NAME,null);

			items.addItem(item);
			recent.offerFirst(item);
			
			assertEquals("Unexpected first item",item,items.getRecent().get(0));
			assertEquals("Unexpected list size",i,items.getRecent().size());
			assertEquals("Wrong list",recent,items.getRecent());
		}

		
		for(int i=1; i<= SIZE;i++) {
			String id = "id"+(SIZE+i);
			Item item = new Item(id,NAME,null);

			items.addItem(item);
			recent.offerFirst(item);
			
			assertEquals("Unexpected first item",item,items.getRecent().get(0));
			assertEquals("Unexpected list size",SIZE,items.getRecent().size());
			assertEquals("Wrong list",recent.subList(0, SIZE),items.getRecent());
		}
	}
	
}
