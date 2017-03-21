package ilike.shared;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.io.Serializable;
import java.util.Arrays;
import java.util.HashSet;

import org.junit.Before;
import org.junit.Test;

import ilike.TestData;

/**
 * Tests on Review, a specialization of Item
 * 
 * @author José Paulo Leal <zp@dcc.fc.up.pt>
 */
public class ReviewTest extends TestData {
	
	Review review;
	
	@Before
	public void setUp() throws Exception {
		review = new Review(ID1, NAME, null, AUTHOR1_ID, TOPIC1_ID, RATING, DESCRIPTION);
	}

	
	/**
	 * Review must extend Item and be serializable
	 */
	@Test
	public void testReview() {
		assertTrue("Revire should be an Item",review instanceof Item);
		assertTrue("Review should be serializable",review instanceof Serializable);
	}


	/**
	 * Check author id setter and getter
	 */
	@Test
	public void testGetAuthorId() {
		for(String id: IDS) {
			review.setAuthorId(id);
			assertEquals("Unexpected id",id,review.getAuthorId());
		}
	}

	/**
	 * Check topic id setter and getter
	 */
	@Test
	public void testGetTopicId() {
		for(String id: IDS) {
			review.setTopicId(id);
			assertEquals("Unexpected yopic id",id,review.getTopicId());
		}
	}

	/**
	 * Check rating setter and getter
	 */
	@Test
	public void testRatingSetterGetter() {
		for(Rating rating: Rating.values()) {
			
			review.setRating(rating);
			assertEquals("Unexpected rating",rating,review.getRating());
		}
	}

	/**
	 * Check description setter and getter
	 */
	@Test
	public void testDescriptionSetterGetter() {
		
		for(String text: TEXTS) {
			
			review.setDescription(text);
			assertEquals("Unexpected description",text,review.getDescription());
		}
	}
	
	/**
	 * Check if related items IDs is the set with author and topic
	 */
	@Test
	public void testGetRelatedItemIds() {
		assertEquals("Unexpected related items",
				new HashSet<>(Arrays.asList(AUTHOR1_ID,TOPIC1_ID)),
				review.getRelatedItemIds());
	}


	/**
	 * Check if instances are equal to themselves, 
	 * to other instances with the same properties,
	 * but different from instances with different properties.
	 */
	@Test
	public void testEquals() {
		Review review0 = new Review(IDS[0],NAMES[0],TAGS,AUTHOR1_ID,TOPIC1_ID,RATING,DESCRIPTION);
		Review reviewO = new Review(IDS[0],NAMES[0],TAGS,AUTHOR1_ID,TOPIC1_ID,RATING,DESCRIPTION);
		Review review1 = new Review(IDS[1],NAMES[1],TAGS,AUTHOR1_ID,TOPIC1_ID,RATING,DESCRIPTION);
		
		assertTrue(review0.equals(review0));
		assertTrue(review1.equals(review1));
		assertTrue(reviewO.equals(reviewO));
		
		assertEquals(review0,reviewO);
		assertTrue(reviewO.equals(review0));
		assertFalse(review0.equals(review1));
		assertFalse(review1.equals(review0));
		
		review0.setDescription(TEXTS[1]);
		
		assertFalse(review0.equals(reviewO));
		assertFalse(reviewO.equals(review0));
		
		reviewO.setDescription(TEXTS[1]);
		
		assertTrue(reviewO.equals(review0));
		assertTrue(review0.equals(reviewO));
	}

}
