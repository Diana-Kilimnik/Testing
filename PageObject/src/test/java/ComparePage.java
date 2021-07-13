import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ComparePage {
    private final WebDriver driver;
    @FindBy(xpath = ".//a[@data-method='post']")
    private WebElement removing;

    public ComparePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public int size() {
        int s = driver.findElements(By.xpath(".//th[@class='item']")).size();
        System.out.println("count=" + s);
        return s;
    }

    public Alert removing() {
        removing.click();
        return driver.switchTo().alert();
    }
}
