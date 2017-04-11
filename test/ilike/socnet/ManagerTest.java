package ilike.socnet;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import ilike.TestData;
import ilike.shared.ILikeException;
import ilike.shared.Item;
import ilike.shared.Review;
import ilike.shared.Topic;
import ilike.shared.User;
import ilike.tag.Indexer;

/**
 * Tests on Manager, the facade of the ILike model
 * 
 * @author José Paulo Leal <zp@dcc.fc.up.pt>
 */
public class ManagerTest extends TestData {
	static Manager manager;
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		manager = new Manager();
	}
	
	User user1;
	User user2;
	
	Topic topic1;
	Topic topic2;
	
	Review reviewA;
	Review reviewB;
	Review reviewC;
	
	/**
	 * Reset singleton before each test
	 * @throws Exception
	 */
	@Before
	public void setUp() throws Exception {
		manager.reset();
		
	}


	/**
	 * Users can be registered only once and cannot be authenticated before registering.
	 * They must only authenticate with the password they were registered.
	 * Passwords of one user should not influence other user.
	 */
	@Test
	public void testRegisterAuthenticate() {
		assertTrue(manager.register(USER1_ID, PASSWORD1));	
	}

	/**
	 * Only registered users can change their passwords.
	 * After changing password, authentication should change accordingly
	 */
	@Test
	public void testUpdatePassword() {
		HashMap<String, String> users = manager.getAuthenticator().getUsers(); 
		manager.register(USER1_ID, PASSWORD1);
		manager.updatePassword(USER1_ID, PASSWORD1, PASSWORD2);
		assertEquals(PASSWORD2, users.get(USER1_ID));
	}


	/**
	 * Only inserted IDs should be recovered
	 * @throws ILikeException 
	 */
	@Test
	public void testAddGetItem() throws ILikeException {
		Item item = new Item(ID1,NAME,TAGS);
		manager.addItem(item);
		
		assertEquals(item, manager.getItem(ID1));
	}


	/**
	 * Only recorded items can be changed
	 * Items return changed values after being changed
	 * @throws ILikeException 
	 */
	@Test
	public void testChangeItem() throws ILikeException {
		Item item = new Item(ID1,NAME,TAGS);
		manager.changeItem(item);
		
		assertEquals(NAME, manager.getItem(ID1).getName());
	}


	/**
	 * Items can be removed only after being inserted
	 * An item is not returned after being removed, and only them. 
	 * @throws ILikeException 
	 */
	@Test
	public void testRemoveItem() throws ILikeException {
		Item item = new Item(ID1,NAME,TAGS);
		manager.removeItem(item);
		
		assertNull(manager.getItem(ID1));
	}

	/**
	 * Feeds can only be returned to users. 
	 * An ILikeException must be thrown if the given ID does not correspond 
	 * to a valid user (even if if it a valid item of a different kind).
	 * 
	 * @throws ILikeException
	 */
	@Test
	public void testGetFeedExceptions() throws ILikeException {
		fail("Unimplemented yet");
	}
	

	/**
	 * Only users can follow items. 
	 * An ILikeException must be thrown if the given ID does not correspond 
	 * to a valid user (even if if it a valid item of a different kind).
	 * 
	 * @throws ILikeException
	 */
	@Test
	public void testFollowItemExceptions() throws ILikeException {
		fail("Unimplemented yet");
	}
	
	/**
	 * Only users can follow items. 
	 * An ILikeException must be thrown if the given ID does not correspond 
	 * to a valid user (even if if it a valid item of a different kind).
	 * 
	 * @throws ILikeException
	 */
	@Test
	public void testFollowTagExceptions() throws ILikeException {
		fail("Unimplemented yet");
	}
	
	/**
	 * Check if users following topics receives a new notification in their feeds 
	 * after (and only after) observer notification  
	 * @throws ILikeException 
	 */
	@Test
	public void testFollowItem() throws ILikeException {
		fail("Unimplemented yet");
	}
	
	/**
	 * Check if users following tags receives a new notification in their feeds 
	 * after (and only after) observer notification  
	 * @throws ILikeException 
	 */
	@Test
	public void testFollowTag() throws ILikeException {
		fail("Unimplemented yet");
	}

	/**
	 * Check items obtained when searching with different tags
	 * @throws ILikeException
	 */
	@Test
	public void testSearchItems() throws ILikeException {
		fail("Unimplemented yet");
	}

	/**
	 * Check tags returned after inserting different items 
	 * @throws ILikeException
	 */
	@Test
	public void testGetTags() throws ILikeException {
		fail("Unimplemented yet");
	}

}
