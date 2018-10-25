import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;


public class BookingSearchTest {
    String baseUrl ;
    WebDriver driver;

    @Before
    public void setUp() throws InvocationTargetException, NoSuchMethodException, InstantiationException, IllegalAccessException, IOException {

      //  System.setProperty("webdriver.chrome.driver", "D:\\repositories\\example\\src\\main\\resources\\drivers\\chromedriver.exe");
       Configuration.load();
      Driver.add(Configuration.get("browser"));
      baseUrl = Configuration.get("baseUrl");
        driver = Driver.current();

    }

    @After
    public void tearDown() {
        driver.quit();
    }

    @Test
    public void testValidSearch() {

        driver.get(baseUrl);
        String s ="d";
    }
}
