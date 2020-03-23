import org.testng.TestNG;
import org.testng.collections.Lists;

import java.util.List;


public class Runner {

    public static void main(String[] args) {
        List<String> suits = Lists.newArrayList();
        suits.add("testng.xml");
        TestNG testng = new TestNG();
        testng.setTestSuites(suits);
        testng.run();
    }
}