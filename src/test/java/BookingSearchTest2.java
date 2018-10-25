import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;

public class BookingSearchTest2 {
    private WebDriver driver;
@Before
public void setUp() throws InvocationTargetException, NoSuchMethodException, InstantiationException, IllegalAccessException, IOException {
    System.setProperty("webdriver.gecko.driver", "D:\\repositories\\example\\src\\main\\resources\\drivers\\geckodriver.exe");
    Configuration.load();
    String baseUrl = Configuration.get("baseUrl");
      System.setProperty("webdriver.chrome.driver", "D:\\repositories\\example\\src\\main\\resources\\drivers\\chromedriver.exe");
DesiredCapabilities cap = new DesiredCapabilities();
    Driver.add(Configuration.get("browser"));
    driver =Driver.current();
    driver.get(baseUrl);
}
@After
public void tearDown(){
    driver.close();
}
    @Test
    public void testValidSearch() {

        String s ="d";
    }
}
