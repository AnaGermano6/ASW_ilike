package ilike.socnet;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({ 
	AuthenticatorTest.class, 
	ItemsTest.class, 
	ManagerTest.class, 
	NotifierTest.class })
public class AllTests {

}
