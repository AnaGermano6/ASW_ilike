package ilike.tag;

import static org.junit.Assert.assertEquals;

import java.util.Arrays;

import org.junit.Before;
import org.junit.Test;

import ilike.TestData;

public class CounterTest extends TestData {
	Counter counter;
	
	@Before
	public void setUp() throws Exception {
		counter = new Counter();
	}

	
	/**
	 * No word, should return the empty list
	 */
	@Test
	public void testNoWord() {
		
		assertEquals(Arrays.asList(),counter.getSorted());
	}

	/**
	 * Put single word, once 
	 */
	@Test
	public void testPutSingleWordOnce() {
		
		counter.put(WORDS[0],1);
		assertEquals(1,counter.get(WORDS[0]).intValue());
		assertEquals(Arrays.asList(WORDS[0]),counter.getSorted());
	}

	/**
	 * Single word, twice
	 */
	@Test
	public void testPutSingleWordTwice() {
		
		counter.put(WORDS[0],2);
		assertEquals(2,counter.get(WORDS[0]).intValue());
		assertEquals(Arrays.asList(WORDS[0]),counter.getSorted());
	}

	/**
	 * Put two words, once, should be returned in lexicographic order
	 */
	@Test
	public void testPutTwoWordsOnce() {
		
		counter.put(WORDS[0],2);
		counter.put(WORDS[1],2);
	
		assertEquals(2,counter.get(WORDS[0]).intValue());
		assertEquals(2,counter.get(WORDS[1]).intValue());
		assertEquals(Arrays.asList(WORDS[0],WORDS[1]),counter.getSorted());
	}

	/**
	 * Put two words, twice, should be returned in lexicographic order
	 */
	@Test
	public void testPutTwoWordsTwice() {
		
		counter.put(WORDS[0],2);
		counter.put(WORDS[1],2);
	
		assertEquals(2,counter.get(WORDS[0]).intValue());
		assertEquals(2,counter.get(WORDS[1]).intValue());
		assertEquals(Arrays.asList(WORDS[0],WORDS[1]),counter.getSorted());
	}

	/**
	 * Put two words, twice and once, respectively, 
	 * should be returned in lexicographic order
	 */
	@Test
	public void testPutTwoWordsTwiceDifferentOrder() {
		
		
		counter.put(WORDS[1],2);
		counter.put(WORDS[0],2);
	
		assertEquals(2,counter.get(WORDS[0]).intValue());
		assertEquals(2,counter.get(WORDS[1]).intValue());
		assertEquals(Arrays.asList(WORDS[0],WORDS[1]),counter.getSorted());
	}

	/**
	 * Put two words, twice and once, different orders, 
	 * should be returned in lexicographic order
	 */
	@Test
	public void testPutTwoWordsTwiceOnceIncresingLexicographicOrder() {
		
		counter.put(WORDS[0],2);
		counter.put(WORDS[1],1);
		
		assertEquals(2,counter.get(WORDS[0]).intValue());
		assertEquals(1,counter.get(WORDS[1]).intValue());
		assertEquals(Arrays.asList(WORDS[0],WORDS[1]),counter.getSorted());
	}

	/**
	 * Put two words, once and twice, 
	 * should be returned in lexicographic order
	 */
	@Test
	public void testPutTwoWordsTwiceOnceDecresingLexicographicOrder() {
		
		counter.put(WORDS[0],1);
		counter.put(WORDS[1],2);
		
		assertEquals(1,counter.get(WORDS[0]).intValue());
		assertEquals(2,counter.get(WORDS[1]).intValue());
		assertEquals(Arrays.asList(WORDS[1],WORDS[0]),counter.getSorted());
	}

	/**
	 * Put three words in increasing lexicographic order
	 */
	@Test
	public void testPutThreerWordsIncresingLexicographicOrder() {
		
		counter.put(WORDS[0],3);
		counter.put(WORDS[1],2);
		counter.put(WORDS[2],1);
		
		assertEquals(3,counter.get(WORDS[0]).intValue());
		assertEquals(2,counter.get(WORDS[1]).intValue());
		assertEquals(1,counter.get(WORDS[2]).intValue());
		assertEquals(Arrays.asList(WORDS[0],WORDS[1],WORDS[2]),counter.getSorted());
	}

	/**
	 * Put three words in decreasing lexicographic order
	 */
	@Test
	public void testPutThreerWordsDecresingLexicographicOrder() {		

		counter.put(WORDS[0],1);
		counter.put(WORDS[1],2);
		counter.put(WORDS[2],3);
		
		assertEquals(1,counter.get(WORDS[0]).intValue());
		assertEquals(2,counter.get(WORDS[1]).intValue());
		assertEquals(3,counter.get(WORDS[2]).intValue());
		assertEquals(Arrays.asList(WORDS[2],WORDS[1],WORDS[0]),counter.getSorted());
	}

	/**
	 * Count single word, once 
	 */
	@Test
	public void testCountSingleWordOnce() {
		
		counter.count(WORDS[0]);
		assertEquals(1,counter.get(WORDS[0]).intValue());
		assertEquals(Arrays.asList(WORDS[0]),counter.getSorted());
	}

	/**
	 * Count single word, twice 
	 */
	@Test
	public void testCountSingleWordTwice() {
		
		counter.count(WORDS[0]);
		counter.count(WORDS[0]);
		assertEquals(2,counter.get(WORDS[0]).intValue());
		assertEquals(Arrays.asList(WORDS[0]),counter.getSorted());
	}
	
	/**
	 * Count two words should be returned in lexicographic order
	 */
	@Test
	public void testCountTwoWordsOnce() {
		
		counter.count(WORDS[0]);
		counter.count(WORDS[1]);
	
		assertEquals(1,counter.get(WORDS[0]).intValue());
		assertEquals(1,counter.get(WORDS[1]).intValue());
		assertEquals(Arrays.asList(WORDS[0],WORDS[1]),counter.getSorted());
	}

	/**
	 * Count two words should be returned in lexicographic order, 
	 * independent of order
	 */
	@Test
	public void testCountTwoWordsOnceReversed() {
		
		counter.count(WORDS[1]);
		counter.count(WORDS[0]);
	
		assertEquals(1,counter.get(WORDS[0]).intValue());
		assertEquals(1,counter.get(WORDS[1]).intValue());
		assertEquals(Arrays.asList(WORDS[0],WORDS[1]),counter.getSorted());
	}
	
	/**
	 * Count two words twice, should return in lexicographic order
	 */
	@Test
	public void testCountTwoWordsTwice() {
		
		counter.count(WORDS[0]);
		counter.count(WORDS[1]);
		counter.count(WORDS[0]);
		counter.count(WORDS[1]);
		
		assertEquals(2,counter.get(WORDS[0]).intValue());
		assertEquals(2,counter.get(WORDS[1]).intValue());
		assertEquals(Arrays.asList(WORDS[0],WORDS[1]),counter.getSorted());
	}

	/**
	 * Count two words twice, should return in lexicographic order,
	 * Independently of the order in which they were counted 
	 */
	@Test
	public void testCountTwoWordsTwiceDifferentOrder() {
		
		counter.count(WORDS[1]);
		counter.count(WORDS[0]);
		counter.count(WORDS[1]);
		counter.count(WORDS[0]);
		
		assertEquals(2,counter.get(WORDS[0]).intValue());
		assertEquals(2,counter.get(WORDS[1]).intValue());
		assertEquals(Arrays.asList(WORDS[0],WORDS[1]),counter.getSorted());
	}
	
	/**
	 * Count two words, twice and once, should be returned in lexicographic order
	 */
	@Test
	public void testCountTwoWordsTwiceOnceIncresingLexicographicOrder() {
		counter.count(WORDS[0]);
		counter.count(WORDS[1]);
		counter.count(WORDS[0]);
		
		assertEquals(2,counter.get(WORDS[0]).intValue());
		assertEquals(1,counter.get(WORDS[1]).intValue());
		assertEquals(Arrays.asList(WORDS[0],WORDS[1]),counter.getSorted());
	}

	/**
	 * Count two words, once and twice, 
	 * should be returned in reverse lexicographic order
	 */
	@Test
	public void testCountTwoWordsTwiceOnceDecresingLexicographicOrder() {
		

		counter.count(WORDS[1]);
		counter.count(WORDS[0]);
		counter.count(WORDS[1]);
		
		assertEquals(1,counter.get(WORDS[0]).intValue());
		assertEquals(2,counter.get(WORDS[1]).intValue());
		assertEquals(Arrays.asList(WORDS[1],WORDS[0]),counter.getSorted());
	}

	/**
	 * Count three words in lexicographic order,
	 * should be return in that order 
	 */
	@Test
	public void testCountThreerWordsIncresingLexicographicOrder() {
		

		counter.count(WORDS[0]);
		counter.count(WORDS[1]);
		counter.count(WORDS[2]);
		counter.count(WORDS[0]);
		counter.count(WORDS[1]);
		counter.count(WORDS[0]);
		
		assertEquals(3,counter.get(WORDS[0]).intValue());
		assertEquals(2,counter.get(WORDS[1]).intValue());
		assertEquals(1,counter.get(WORDS[2]).intValue());
		assertEquals(Arrays.asList(WORDS[0],WORDS[1],WORDS[2]),counter.getSorted());
	}
	
	/**
	 * Count three words in reverse lexicographic order,
	 * should be return in that order 
	 */
	@Test
	public void testCountThreerWordsDecresingLexicographicOrder() {		
		counter.count(WORDS[2]);
		counter.count(WORDS[1]);
		counter.count(WORDS[0]);
		counter.count(WORDS[2]);
		counter.count(WORDS[1]);
		counter.count(WORDS[2]);
		
		assertEquals(1,counter.get(WORDS[0]).intValue());
		assertEquals(2,counter.get(WORDS[1]).intValue());
		assertEquals(3,counter.get(WORDS[2]).intValue());
		assertEquals(Arrays.asList(WORDS[2],WORDS[1],WORDS[0]),counter.getSorted());
	}

}
