package ilike.tag;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({ CounterTest.class, IndexerTest.class, TrieTest.class })
public class AllTests {

}
