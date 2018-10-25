import org.junit.*;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

@RunWith(Parameterized.class)
public class BookingsearchTestN {
    private static WebDriver driver;

    private String destination;
    private boolean isLeisure;
    private int numberOfAdults;

    public BookingsearchTestN(String destination, boolean isLeisure, int numberOfAdults) {
        this.destination = destination;
        this.isLeisure = isLeisure;
        this.numberOfAdults = numberOfAdults;
    }

    @Parameterized.Parameters
    public static List<Object[]> getParameters() {
        return Arrays.asList(
                new Object[][]{
                        {"London", true, 2},
                        {"NewYork", false, 1}
                });
    }

    @BeforeClass
    public static void setUp() throws Exception {
        //  driver = new FirefoxDriver();
        System.setProperty("webdriver.chrome.driver", "D:\\repositories\\example\\src\\main\\resources\\drivers\\chromedriver.exe");
        Configuration.load();
        Driver.add(Configuration.get("browser"));
        // baseUrl = Configuration.get("baseUrl");
        driver = Driver.current();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    }

    @AfterClass
    public static void tearDown() {
        driver.quit();
    }

    @Test
    public void testValidSearch() {
        Control editDestination = new Control(driver, By.id("ss"));
        Control destinationLonon = new Control(driver, By.xpath("//input[@id=\"ss\"]/../ul/li[1]//b"));
        Control test = new Control(driver, By.className("c-autocomplete__item sb-autocomplete__item sb-autocomplete__item-with_photo sb-autocomplete__item--district sb-autocomplete__item__item--elipsis sb-autocomplete__item--without-propertytype "));
        Control popupWindow = new Control(driver, By.xpath("//*[@class='bicon bicon-aclose header-signin-prompt__close']"));
        driver.get("https://www.booking.com/index.pl.html?label=gen173nr-1DCAEoggJCAlhYSDNYBGi2AYgBAZgBHsIBCndpbmRvd3MgMTDIAQ_YAQPoAQGSAgF5qAID;sid=c5c83e06b6fbaa60c160a8ee1ba17453;sb_price_type=total&");
        Control checkIn = new Control(driver, By.xpath("//*[@id=\"frm\"]/div[1]/div[2]/div/div[2]/div/div/div/div[1]/div/button"));
        Control checkInDate = new Control(driver, By.xpath("//*[@id=\"frm\"]/div[1]/div[2]/div/div[2]/div/div/div/div[2]/div[2]/div[3]/div/div/div[2]/table/tbody/tr[4]/td[2]/span"));
        Control comeCalendar = new Control(driver, By.xpath("//*[@id=\"frm\"]/div[1]/div[2]/div/div[2]/div/div/div/div[2]/div[2]/div[3]/div/div/div[2]/table/tbody/tr[3]/td[4]/span"));
        Control left = new Control(driver, By.xpath("//form[@id='frm']/div/div[2]/div/div[3]/div/div/div/div/div/button"));


        editDestination.clear();
        editDestination.setText(this.destination);
        if (popupWindow.exist()) {
            popupWindow.click();
            editDestination.click();
        }
        editDestination.click();
        destinationLonon.click();
//   firstDestination.click();
//checkIn.click();
//checkInDate.click();
//        //   driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
//   //    checkoutDayExpand.click();
//comeCalendar.click();
//        driver.findElement(By.xpath("//button[@type='button']")).click();
//        driver.findElement(By.xpath("//form[@id='frm']/div/div[2]/div/div[2]/div/div/div/div[2]/div[2]/div[3]/div/div/div/table/tbody/tr[3]/td[6]/span")).click();
//        driver.findElement(By.xpath("//label[@id='xp__guests__toggle']/span/span")).click();
//        driver.findElement(By.id("group_adults")).click();
//        new Select(driver.findElement(By.id("group_adults"))).selectByVisibleText(String.valueOf(this.numberOfAdults));
//        driver.findElement(By.xpath("(//option[@value='1'])[2]")).click();
//        driver.findElement(By.xpath("//button[@type='submit']")).click();
//        driver.findElement(By.id("basiclayout")).click();
    }
}
