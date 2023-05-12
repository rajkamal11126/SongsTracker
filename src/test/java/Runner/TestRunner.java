package Runner;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.testvagrant.RecentlyPlayedStoreTest;

/**
 * Test runner class that runs all the test classes for the RecentlyPlayedStore.
 */
@RunWith(Suite.class)
@Suite.SuiteClasses({ RecentlyPlayedStoreTest.class })
public class TestRunner {

}