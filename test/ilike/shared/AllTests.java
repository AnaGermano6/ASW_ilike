package ilike.shared;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({ 
	ItemTest.class, 
	ReviewTest.class, 
	TopicTest.class, 
	UserTest.class })
public class AllTests {

}
