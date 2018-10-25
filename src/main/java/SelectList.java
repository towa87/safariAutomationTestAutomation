
import org.openqa.selenium.By;
        import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class SelectList extends Control {
    public SelectList(WebDriver driver, By locator) {
        super(driver, locator);
    }

    public Select getSelect() {
        return new Select(this.getElement());
    }

    public void selectByText(String value) {
        this.exist();
        this.getSelect().selectByVisibleText(value);
    }
   public java.util.List<WebElement> getElemets()
    {
        return this.driver.findElements(this.locator);
    }
}
