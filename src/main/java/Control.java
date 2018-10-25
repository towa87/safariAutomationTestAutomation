import org.omg.CORBA.TIMEOUT;
import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Control {
    public static final long TIMEOUT = Configuration.timeout();
    WebDriver driver;
    By locator;

    public Control(WebDriver driver, By locator) {
        this.driver = driver;
        this.locator = locator;
    }
    public WebElement getElement()
    {
        return driver.findElement(locator);
    }
    public boolean exists(long timeout)
    {
        WebDriverWait wait = new WebDriverWait(driver,timeout);
        try
        {
            wait.until(ExpectedConditions.presenceOfElementLocated(locator));
        }
        catch (TimeoutException e)
        {
            return false;
        }
        return true;
    }

    public boolean exist()
    {
        return exists(TIMEOUT);
    }
    public void click(){
        exist();
        this.getElement().click();
    }


    public void clear() {
        exist();
        this.getElement().clear();
    }

    public void setText(String value){
        this.click();
        this.getElement().clear();
        this.getElement().sendKeys(value);
    }
}
