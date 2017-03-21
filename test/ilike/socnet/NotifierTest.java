package ilike.socnet;

import static org.junit.Assert.assertEquals;

import java.util.Arrays;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import ilike.TestData;
import ilike.shared.ILikeException;
import ilike.shared.Review;
import ilike.shared.Topic;
import ilike.shared.User;

/**
 * Tests on Notifier, the class that propagates changes
 * 
 * @author José Paulo Leal <zp@dcc.fc.up.pt>
 */
public class NotifierTest extends TestData {
	
	User user1;
	User user2;
	
	Topic topic1;
	Topic topic2;
	
	Review reviewA;
	Review reviewB;
	Review reviewC;
	
	Items items;
	Notifier notifier;
	
	@Before
	public void setUp() throws Exception {
		items = new Items();
		notifier = new Notifier();
		
		user1 = new User(USER1_ID,NAME,null);
		user2 = new User(USER2_ID,NAME,null);
		
		topic1 = new Topic(TOPIC1_ID,NAME,getTags(TAG1),DESCRIPTION,NOW);
		topic2 = new Topic(TOPIC2_ID,NAME,getTags(TAG1,TAG2),DESCRIPTION,NOW);

		reviewA = new Review(REVIEW_A_ID,NAME,null,user1.getId(),topic1.getId(),RATING,DESCRIPTION);
		reviewB = new Review(REVIEW_B_ID,NAME,null,user2.getId(),topic1.getId(),RATING,DESCRIPTION);
		reviewC = new Review(REVIEW_C_ID,NAME,null,user1.getId(),topic2.getId(),RATING,DESCRIPTION);
		
		items.addItem(user1);
		items.addItem(user2);
		items.addItem(topic1);
		items.addItem(topic2);
	}

	/**
	 * Check if users following topics receives a new notification in their feeds 
	 * after (and only after) observer notification  
	 */
	@Test
	public void testFollowItem() {
		notifier.followItem(topic1.getId(), user1);
		notifier.followItem(topic2.getId(), user2);
		
		assertEquals("Empty feed expected",Arrays.asList(),user1.getFeed());
		assertEquals("Empty feed expected",Arrays.asList(),user2.getFeed());
		
		notifier.notifyObservers(topic1);
		
		assertEquals("Topic 1 expected",Arrays.asList(topic1.getId()),user1.getFeed());
		assertEquals("Empty feed expected",Arrays.asList(),user2.getFeed());
		
		notifier.notifyObservers(topic2);

		assertEquals("Topic 1 expected",Arrays.asList(topic1.getId()),user1.getFeed());
		assertEquals("Topic 2 expected",Arrays.asList(topic2.getId()),user2.getFeed());
	}
	
	/**
	 * Check if users following tags receives a new notification in their feeds 
	 * after (and only after) observer notification  
	 */
	@Test
	public void testFollowTag() {
		notifier.followTag(TAG1, user1);
		notifier.followTag(TAG2, user2);
		
		assertEquals("Empty feed expected",Arrays.asList(),user1.getFeed());
		assertEquals("Empty feed expected",Arrays.asList(),user2.getFeed());
		
		notifier.notifyObservers(topic1); // topic1 contains TAG1
		
		assertEquals("Topic 1 expected",Arrays.asList(TOPIC1_ID),user1.getFeed());
		assertEquals("Empty feed expected",Arrays.asList(),user2.getFeed());
		
		notifier.notifyObservers(topic2); // topic1 contains both TAG1 and TAG2
		
		assertEquals("Topics 1 & 2 expected",Arrays.asList(TOPIC2_ID,TOPIC1_ID),user1.getFeed());
		assertEquals("Topic 2 expected",Arrays.asList(TOPIC2_ID),user2.getFeed());
		
	}
	
	/**
	 * When a review is notified its related items should be in the feed
	 * @throws ILikeException
	 */
	@Test
	public void testFollowRelatedItems() throws ILikeException {
				
		notifier.followItem(topic1.getId(), user2);
		
		assertEquals(Arrays.asList(),user1.getFeed());
		assertEquals(Arrays.asList(),user2.getFeed());
		
		notifier.notifyObservers(reviewA);
		
		assertEquals(Arrays.asList(),user1.getFeed());
		assertEquals(Arrays.asList(reviewA.getId()),user2.getFeed());	
		
		notifier.notifyObservers(reviewB);
		
		assertEquals(Arrays.asList(),user1.getFeed());
		assertEquals(Arrays.asList(reviewB.getId(),reviewA.getId()),user2.getFeed());	
		
		notifier.notifyObservers(reviewC);
		
		assertEquals(Arrays.asList(),user1.getFeed());
		assertEquals(Arrays.asList(reviewB.getId(),reviewA.getId()),user2.getFeed());	

	}
	
	/**
	 * Test feed size with 10 (max of 10 items in feed)
	 * @throws ILikeException
	 */
	@Test
	public void testSetFeedSize10() throws ILikeException {
		testSetFeedSize(10);
	}

	/**
	 * Test feed size with 20 (max of 20 items in feed)
	 * @throws ILikeException
	 */
	@Test
	public void testSetFeedSize20() throws ILikeException {
		testSetFeedSize(20);
	}
	
	/**
	 * Test feed size with 30 (max of 30 items in feed)
	 * @throws ILikeException
	 */
	@Test
	public void testSetFeedSize30() throws ILikeException {
		testSetFeedSize(30);
	}
	
	private void testSetFeedSize(int feedSize) {
		notifier.followItem(topic1.getId(), user2);
		
		User.setFeedSize(feedSize);
				
		for(int i=1; i <= 2*feedSize; i++) {
			String id = "review"+i;
			Review review = new Review(id,"Anoter review",null,user1.getId(),topic1.getId(),RATING,DESCRIPTION);
			
			notifier.notifyObservers(review);
			
			List<String> feed = user2.getFeed();
			assertEquals(id,feed.get(0));
			assertEquals(Math.min(i, feedSize),feed.size());
		}
		
	}

}
