package ilike;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({
	ilike.shared.AllTests.class,
	ilike.tag.AllTests.class,
	ilike.socnet.AllTests.class,
})
public class AllTests {

}
