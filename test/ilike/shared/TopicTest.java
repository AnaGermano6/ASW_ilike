package ilike.shared;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import ilike.TestData;

/**
 * Tests on Topic, a specialization of Item
 * 
 * @author José Paulo Leal <zp@dcc.fc.up.pt>
 */
public class TopicTest extends TestData {	
	Topic topic;
	
	@Before
	public void setUp() throws Exception {
		topic = new Topic(ID1,NAME,null,"Topic description",NOW);
	}

	/**
	 * Topic must extend Item and be serializable
	 */
	@Test
	public void testTopic() {
		assertTrue("Topic shoudl be an Item,",topic instanceof Item);
		assertTrue("Topic shoudl be serializable,",topic instanceof Serializable);
	}
	
	/**
	 * Check date setter and getter
	 */
	@Test
	public void testDateSetterGetter() {
		
		for(Date date: DATES) {
			topic.setDate(date);
			assertEquals("Unexpected date",date,topic.getDate());
		}
	}
	
	/**
	 * Check description setter and getter
	 */
	@Test
	public void testDescriptionSetterGetter() {
		
		for(String text: TEXTS) {
			
			topic.setDescription(text);
			assertEquals("Unexpected description",text,topic.getDescription());
		}
	}

	/**
	 * Check if reviews are recorded in chronological order 
	 */
	@Test
	public void testAddReview() {
		List<String> ids = new ArrayList<>();
		

		for(int i=0; i<REPETITIONS; i++) {
			String id = "id"+i;
			
			ids.add(id);
			topic.addReview(id);
			assertEquals("Unexpected review",ids,topic.getReviews());
		}
	}

	/**
	 * Check if review IDs disappear in the order they are removed
	 */
	@Test
	public void testRemoveReview() {
		
		assertEquals("No reviews expected",Arrays.asList(),topic.getReviews());
		topic.addReview(ID1);
		
		assertEquals("One review expected",Arrays.asList(ID1),topic.getReviews());
		
		topic.addReview(ID2);
		
		assertEquals("Two reviews expected",Arrays.asList(ID1,ID2),topic.getReviews());
	
		topic.removeReview(ID2);
		
		assertEquals("Just one review expected",Arrays.asList(ID1),topic.getReviews());
		
		topic.removeReview(ID1);
		
		assertEquals("No reviews expected",Arrays.asList(),topic.getReviews());
	}
	
	/**
	 * Check if instances are equal to themselves, 
	 * to other instances with the same properties,
	 * but different from instances with different properties.
	 */
	@Test
	public void testEquals() {
		Topic topic0 = new Topic(IDS[0],NAMES[0],TAGS,DESCRIPTION,NOW);
		Topic topicO = new Topic(IDS[0],NAMES[0],TAGS,DESCRIPTION,NOW);
		Topic topic1 = new Topic(IDS[1],NAMES[1],TAGS,DESCRIPTION,NOW);
		
		assertTrue(topic0.equals(topic0));
		assertTrue(topic1.equals(topic1));
		assertTrue(topicO.equals(topicO));
		
		assertEquals(topic0,topicO);
		assertTrue(topicO.equals(topic0));
		assertFalse(topic0.equals(topic1));
		assertFalse(topic1.equals(topic0));
		
		topic0.setDescription(TEXTS[1]);
		
		assertFalse(topic0.equals(topicO));
		assertFalse(topicO.equals(topic0));
		
		topicO.setDescription(TEXTS[1]);
		
		assertTrue(topicO.equals(topic0));
		assertTrue(topic0.equals(topicO));
	}

}
