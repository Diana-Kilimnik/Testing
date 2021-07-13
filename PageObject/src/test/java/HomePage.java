import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class HomePage {
    private final WebDriver driver;
    @FindBy(xpath = ".//a[@data-href='/compare/1041/']")
    private WebElement compareCategory;

    public HomePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public ComparePage choiceCompare() {
        compareCategory.click();
        return new ComparePage(driver);
    }

    public List<WebElement> List() {
        return driver.findElements(By.xpath(".//a[@class='add-to-compare-link']"));
    }
}