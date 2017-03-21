package ilike.tag;

import static org.junit.Assert.assertEquals;

import java.util.Arrays;

import org.junit.Before;
import org.junit.Test;

import ilike.TestData;
import ilike.shared.ILikeException;
import ilike.shared.Item;

/**
 * Test class for indexer
 * 
 * @author José Paulo Leal <zp@dcc.fc.up>
 */
public class IndexerTest extends TestData {
	static Indexer indexer;
	Item item1 = new Item(ID1,NAME,getTags(TAG1));
	Item item2 = new Item(ID2,NAME,getTags(TAG1,TAG2));
	Item item3 = new Item(ID3,NAME,getTags(TAG1,TAG2,TAG3));
	

	@Before
	public void setUp() throws Exception {
		indexer = new Indexer();
	}
	
	/**
	 * No items inserted, tags shouldn't retreive anything
	 * 
	 * @throws ILikeException
	 */
	@Test
	public void testNoIndexSearch() throws ILikeException {
		check0();
	}
	
	/**
	 * Single item inserted 
	 */
	@Test
	public void testIndex1Search() {		
		indexer.index(item1);
		
		check1();
	}

	/**
	 * Item inserted but removed. 
	 * Should act as if not item was inserted
	 */
	public void testIndex1Unindex1Search() {
		indexer.index(item1);
		indexer.unindex(item1);
		
		check0();
	}
		
	/**
	 * Two items inserted with 2 different tags
	 */
	@Test
	public void testIndex12Search()  {
		indexer.index(item1);
		indexer.index(item2);
		
		check12();	
	}
	
	/**
	 * Order of indexing should be irrelevant
	 */
	@Test
	public void testIndex21Search() {	
		indexer.index(item2);
		indexer.index(item1);
		
		check12();
	}
	
	/**
	 * Removing an item should be similar to not have inserted it in first place 
	 */
	@Test
	public void testIndex12Unindex2Search() {
		indexer.index(item1);
		indexer.index(item2);
		indexer.unindex(item2);
		
		check1();	
	}	
	
	/**
	 * Order of removing should be irrelevant
	 */
	@Test
	public void testIndex2Unindex2Index1Search() {
		indexer.index(item2);
		indexer.unindex(item2);
		indexer.index(item1);
		
		check1();	
	}	
	
	/**
	 *  Check retrieving with 3 items 
	 * @throws ILikeException
	 */
	@Test
	public void testIndex123Search() throws ILikeException {
		indexer.index(item1);
		indexer.index(item2);
		indexer.index(item3);
		
		check123();
	}
	
	/**
	 * After unindexing tag should not retrieve item 
	 * 
	 * @throws ILikeException
	 */
	@Test
	public void testIndex123Unindex2Search() throws ILikeException {
		indexer.index(item1);
		indexer.index(item2);
		indexer.index(item3);
		indexer.unindex(item3);;
		
		check12();
	}
	
	/**
	 * 
	 */
	private void check0() {
		assertEquals(Arrays.asList(),indexer.search(getTags()));
		assertEquals(Arrays.asList(),indexer.search(getTags(TAG1)));
		assertEquals(Arrays.asList(),indexer.search(getTags(TAG2)));
		assertEquals(Arrays.asList(),indexer.search(getTags(TAG3)));
	}

	/**
	 * Check retrieving items with just tag 1 
	 */
	private void check1() {
		assertEquals(Arrays.asList(),indexer.search(getTags()));
		
		assertEquals(Arrays.asList(ID1),indexer.search(getTags(TAG1)));
		assertEquals(Arrays.asList(),indexer.search(getTags(TAG2)));
		assertEquals(Arrays.asList(),indexer.search(getTags(TAG3)));
	}

	/**
	 * Check retrieving items with tags 1 or 2
	 */
	private void check12() {
		assertEquals(Arrays.asList(),indexer.search(getTags()));
		
		
		assertEquals(Arrays.asList(ID1,ID2),indexer.search(getTags(TAG1)));		
		assertEquals(Arrays.asList(ID2),indexer.search(getTags(TAG2)));
		assertEquals(Arrays.asList(),indexer.search(getTags(TAG3)));

		assertEquals(Arrays.asList(ID2,ID1),indexer.search(getTags(TAG1,TAG2)));
		assertEquals(Arrays.asList(ID2,ID1),indexer.search(getTags(TAG2,TAG1)));
		assertEquals(Arrays.asList(ID2,ID1),indexer.search(getTags(TAG1,TAG2,TAG3)));
	}
	
	/**
	 * Check retrieving tags 1, 2 or 3
	 */
	private void check123() {
		assertEquals(Arrays.asList(),indexer.search(getTags()));
		
		assertEquals(Arrays.asList(ID1,ID2,ID3),indexer.search(getTags(TAG1)));
		assertEquals(Arrays.asList(ID2,ID3),indexer.search(getTags(TAG2)));
		assertEquals(Arrays.asList(ID3),indexer.search(getTags(TAG3)));
		

		assertEquals(Arrays.asList(ID2,ID3,ID1),indexer.search(getTags(TAG1,TAG2)));
		assertEquals(Arrays.asList(ID2,ID3,ID1),indexer.search(getTags(TAG2,TAG1)));
		assertEquals(Arrays.asList(ID3,ID1,ID2),indexer.search(getTags(TAG1,TAG3)));		
		assertEquals(Arrays.asList(ID3,ID1,ID2),indexer.search(getTags(TAG3,TAG1)));		
		assertEquals(Arrays.asList(ID3,ID2),indexer.search(getTags(TAG2,TAG3)));
		assertEquals(Arrays.asList(ID3,ID1,ID2),indexer.search(getTags(TAG3,TAG1)));
		assertEquals(Arrays.asList(ID3,ID1,ID2),indexer.search(getTags(TAG1,TAG3)));
		assertEquals(Arrays.asList(ID3,ID2),indexer.search(getTags(TAG2,TAG3)));
		assertEquals(Arrays.asList(ID3,ID2),indexer.search(getTags(TAG3,TAG2)));
		
		assertEquals(Arrays.asList(ID3,ID2,ID1),indexer.search(getTags(TAG1,TAG2,TAG3)));
		assertEquals(Arrays.asList(ID3,ID2,ID1),indexer.search(getTags(TAG1,TAG3,TAG2)));
		assertEquals(Arrays.asList(ID3,ID2,ID1),indexer.search(getTags(TAG2,TAG3,TAG1)));
	}
}
