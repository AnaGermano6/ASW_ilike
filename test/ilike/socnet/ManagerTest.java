package ilike.socnet;

import static org.junit.Assert.fail;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import ilike.TestData;
import ilike.shared.ILikeException;
import ilike.shared.Review;
import ilike.shared.Topic;
import ilike.shared.User;

/**
 * Tests on Manager, the facade of the ILike model
 * 
 * @author José Paulo Leal <zp@dcc.fc.up.pt>
 */
public class ManagerTest extends TestData {
	static Manager manager;
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		manager = Manager.getInstance();
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
		fail("Unimplemented yet");
	}

	/**
	 * Only registered users can change their passwords.
	 * After changing password, authentication should change accordingly
	 */
	@Test
	public void testUpdatePassword() {
		fail("Unimplemented yet");
	}


	/**
	 * Only inserted IDs should be recovered
	 * @throws ILikeException 
	 */
	@Test
	public void testAddGetItem() throws ILikeException {
		fail("Unimplemented yet");
	}


	/**
	 * Only recorded items can be changed
	 * Items return changed values after being changed
	 * @throws ILikeException 
	 */
	@Test
	public void testChangeItem() throws ILikeException {
		fail("Unimplemented yet");
	}


	/**
	 * Items can be removed only after being inserted
	 * An item is not returned after being removed, and only them. 
	 * @throws ILikeException 
	 */
	@Test
	public void testRemoveItem() throws ILikeException {
		fail("Unimplemented yet");
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
