package suites;

import org.testng.annotations.BeforeTest;
import utils.Rest;

/**
 * <h1>API Suite class</h1>
 * <p>Generates API instance for Weatherstack service</p>
 *
 * @since 2020-03-23
 * @see <a href="https://weatherstack.com/documentation">Weatherstack Documentation</a>
 */
public class ApiSuite {

    protected Rest api;

    // general methods for all suites
    @BeforeTest
    public void setApiInstance() {
        api = new Rest();
    }
}