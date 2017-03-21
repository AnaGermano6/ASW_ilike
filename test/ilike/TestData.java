package ilike;

import java.util.Arrays;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import ilike.shared.Rating;

/**
 * Test data used in unit tests
 * 
 * @author José Paulo Leal <zp@dcc.fc.up.pt>
 */
public class TestData {

	protected static final String ID1 = "id1";
	protected static final String ID2 = "id2";
	protected static final String ID3 = "id3";
	protected static final String[] IDS = { ID1, ID2, ID3};
	
	protected static final String NAME = "name"; 
	protected static final String DESCRIPTION ="some description";
	
	protected static final String[] NAMES = {"One Name", "Another Name", "Yet Another Name"}; 
	
	protected static final String TAG1 = "tag1";
	protected static final String TAG2 = "tag2";
	protected static final String TAG3 = "tag3";
	protected static final Set<String> TAGS = getTags(TAG1, TAG2, TAG3);
	
	protected static final String TOPIC1_ID = "topic1";
	protected static final String TOPIC2_ID = "topic2";
	
	protected static final String AUTHOR1_ID = "author1";
	protected static final String AUTHOR2_ID = "author2";
	
	protected static final String USER1_ID = "user1";
	protected static final String USER2_ID = "user2";
	
	protected static String PASSWORD1 = "password1";
	protected static String PASSWORD2 = "password2";
	
	protected static final String REVIEW_A_ID = "reviewA";
	protected static final String REVIEW_B_ID = "reviewB";
	protected static final String REVIEW_C_ID = "reviewC";
	
	protected static final String WORDS[] = { "word1", "word2", "word3" };
	
	protected static final Rating RATING = Rating.values()[Rating.values().length-1];
	
	protected static final int REPETITIONS = 10;
	
	protected static Date NOW = new Date();
	protected static int  SLACK = 100; 
	protected static Date[] DATES = { NOW, new Date(NOW.getTime()+SLACK) };
	protected static String[] TEXTS = { "hello", "two words", "some more words"}; 
	protected static int[] INTS = { 10, 20, 30 };
		
	protected static final int SIZE = 20;

	protected static Set<String> getTags(String ... tags) {
		return new HashSet<>(Arrays.asList(tags));
	}
}
