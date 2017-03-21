package ilike.tag;

import static org.junit.Assert.assertEquals;

import java.util.Arrays;
import java.util.HashSet;

import org.junit.Before;
import org.junit.Test;

import ilike.shared.ILikeException;
import ilike.shared.Item;
import ilike.tag.Trie;

public class TrieTest {	
	Trie trie;
	
	@Before
	public void setUp() throws Exception {
		trie = new Trie();
	}

	@Test
	public void testAdd0Words() {
		
		assertEquals(Arrays.asList(),trie.getWordsStartingWith(""));
	}

	@Test
	public void test3wordsNoPrefix() throws ILikeException {
		trie.increaseTags(mkItem("ola","ole","oli"));
		
		assertEquals(Arrays.asList("ola","ole","oli"),trie.getWordsStartingWith(""));
	}
	
	@Test
	public void test3wordsNoPrefix2() throws ILikeException {
		trie.increaseTags(mkItem("ola","ole","oli"));
		trie.increaseTags(mkItem("oli"));
		
		assertEquals(Arrays.asList("oli","ola","ole"),trie.getWordsStartingWith(""));
	}
	
	@Test
	public void test3wordsNoPrefix3() throws ILikeException {
		trie.increaseTags(mkItem("ola","ole","oli"));
		trie.increaseTags(mkItem("ole","oli"));
		trie.increaseTags(mkItem("ole"));
		
		assertEquals(Arrays.asList("ole","oli","ola"),trie.getWordsStartingWith(""));
	}
	
	@Test
	public void test3wordsNoPrefixRemove() throws ILikeException {
		trie.increaseTags(mkItem("ola","ole","oli"));
		trie.increaseTags(mkItem("oli"));
		trie.decreaseTags(mkItem("oli"));
		
		assertEquals(Arrays.asList("ola","ole","oli"),trie.getWordsStartingWith(""));
		
		trie.decreaseTags(mkItem("oli"));
		
		assertEquals(Arrays.asList("ola","ole"),trie.getWordsStartingWith(""));
	
		trie.decreaseTags(mkItem("ola"));
		
		assertEquals(Arrays.asList("ole"),trie.getWordsStartingWith(""));
	}
	
	@Test
	public void test5wordsPrefix1Char() throws ILikeException {
		trie.increaseTags(mkItem("ola","ole","oli"));
		trie.increaseTags(mkItem("hello","holla"));
		
		assertEquals(Arrays.asList("ola","ole","oli"),trie.getWordsStartingWith("o"));
		
		assertEquals(Arrays.asList("hello","holla"),trie.getWordsStartingWith("h"));
		
		trie.decreaseTags(mkItem("ola"));
		
		assertEquals(Arrays.asList("ole","oli"),trie.getWordsStartingWith("o"));
		
		assertEquals(Arrays.asList("hello","holla"),trie.getWordsStartingWith("h"));

		trie.decreaseTags(mkItem("hello"));

		assertEquals(Arrays.asList("ole","oli"),trie.getWordsStartingWith("o"));
		
		assertEquals(Arrays.asList("holla"),trie.getWordsStartingWith("h"));
	}

	@Test
	public void test5wordsPrefix2Char() throws ILikeException {
		trie.increaseTags(mkItem("ola","ole","oli"));
		trie.increaseTags(mkItem("hello","holla"));
		
		assertEquals(Arrays.asList("ola","ole","oli"),trie.getWordsStartingWith("ol"));
		
		assertEquals(Arrays.asList("hello","holla"),trie.getWordsStartingWith("h"));
		assertEquals(Arrays.asList("hello"),trie.getWordsStartingWith("he"));
		assertEquals(Arrays.asList("holla"),trie.getWordsStartingWith("ho"));
		
		trie.increaseTags(mkItem("holla"));
		
		assertEquals(Arrays.asList("holla","hello"),trie.getWordsStartingWith("h"));
		assertEquals(Arrays.asList("hello"),trie.getWordsStartingWith("he"));
		assertEquals(Arrays.asList("holla"),trie.getWordsStartingWith("ho"));
		
		trie.decreaseTags(mkItem("hello"));
		
		assertEquals(Arrays.asList("holla"),trie.getWordsStartingWith("h"));
		assertEquals(Arrays.asList(),trie.getWordsStartingWith("he"));
		assertEquals(Arrays.asList("holla"),trie.getWordsStartingWith("ho"));
		
		trie.decreaseTags(mkItem("holla"));
		
		assertEquals(Arrays.asList("holla"),trie.getWordsStartingWith("h"));
		assertEquals(Arrays.asList(),trie.getWordsStartingWith("he"));
		assertEquals(Arrays.asList("holla"),trie.getWordsStartingWith("ho"));

		trie.decreaseTags(mkItem("holla"));
		
		assertEquals(Arrays.asList(),trie.getWordsStartingWith("h"));
		assertEquals(Arrays.asList(),trie.getWordsStartingWith("he"));
		assertEquals(Arrays.asList(),trie.getWordsStartingWith("ho"));
	}


	private Item mkItem(String... tags) {
		return new Item("id","name",new HashSet<>(Arrays.asList(tags)));
	}
}
