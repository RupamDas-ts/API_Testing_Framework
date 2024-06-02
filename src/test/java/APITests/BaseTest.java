package APITests;

import TestConfigSetup.TestProperties;
import Utils.TestUtils;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import java.util.HashMap;

public class BaseTest {
    TestUtils testUtils =  new TestUtils();
    @BeforeSuite
    @Parameters({"env_name"})
    public void setUpCreds(@Optional("production") String env_name) {
        testUtils.getBearerTokenViaLogin(env_name);
    }
}
