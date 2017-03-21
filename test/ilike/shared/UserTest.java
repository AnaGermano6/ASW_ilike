package ilike.shared;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.io.Serializable;
import java.util.Arrays;
import java.util.LinkedList;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import ilike.TestData;

/**
 * Test user class
 * 
 * @author José Paulo Leal <zp@dcc.fc.up.pt>
 */
public class UserTest extends TestData {	
	User user;
	
	@BeforeClass
	public static void setUpBeforeClass() {
		User.setFeedSize(SIZE);
	}
	
	@Before
	public void setUp() throws Exception {
		user = new User(ID1,NAME,null);
	}

	
	/**
	 * User must extend Item and be serializable
	 */
	@Test
	public void testUser() {
		assertTrue("User should be an Item",user instanceof Item);
		assertTrue("User should be serializable",user instanceof Serializable);
	}
	
	/**
	 * Check feed size setter and getter
	 */
	@Test
	public void testSetFeedSize() {
		for(int feedSize: INTS) {
			User.setFeedSize(feedSize);
			assertEquals("Unexpected feed size",feedSize,User.getFeedSize());
		}
	}


	/**
	 * Feed should report IDs in the reverse order they are updated.
	 * That is, the last update must show up first on the list.
	 */
	@Test
	public void testFeed() {
		assertEquals("Empty feed expected",Arrays.asList(),user.getFeed());
		
		user.update(null, ID1);
		assertEquals("Feed with one item id expected",Arrays.asList(ID1),user.getFeed());
		
		user.update(null, ID2);
		assertEquals("Feed with two item ids expected",Arrays.asList(ID2,ID1),user.getFeed());
	}
	
	/**
	 * Feed size must be equal of less to FEED_SIZE.
	 * First element must be the last inserted.
	 * Feed must be equal to the reversed list of inserted IDs,
	 * truncated to the first FEED_SIZE elements.
	 */
	@Test
	public void testFeedSize() {
		LinkedList<String> ids = new LinkedList<>();
		
		for(int i=1; i<= 2*SIZE;i++) {
			String id = "id"+i;
			int size = Math.min(i, SIZE);
	
			ids.offerFirst(id);
			user.update(null, id);
			
			assertEquals("Unexpected head element",id,user.getFeed().get(0));
			assertEquals("Unexpected list size",size,user.getFeed().size());
			assertEquals("Unexpected list",ids.subList(0, size),user.getFeed());
		}
	}

}
