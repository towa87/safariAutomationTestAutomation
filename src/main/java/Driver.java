import org.openqa.selenium.Capabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import static javax.swing.UIManager.put;

public class Driver {
    private static WebDriver driver;
    public static ConcurrentHashMap<String, WebDriver> driverTheadMap = new ConcurrentHashMap<>();
    public static final Map<String, Class<?>> driverMap = new HashMap<String, Class<?>>() {
        {
            put("chrome", ChromeDriver.class);
            put("firefox", FirefoxDriver.class);
        }
    };

    public static String getThreadName() {
        return Thread.currentThread().getName() + "-" + Thread.currentThread().getId();
    }

    public static void add(String browser) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {

        Class<?> driverClass = driverMap.get(browser);
        driver = (WebDriver) driverClass.getConstructor().newInstance();
        String threadName = getThreadName();
       driverTheadMap.put(threadName, driver);
    }

    public static WebDriver current() {
    String threadName = getThreadName();
       return driverTheadMap.get(threadName);
    }
}
