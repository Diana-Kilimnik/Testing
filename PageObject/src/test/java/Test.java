import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class Test {

    String siteHomePage = "https://pn.com.ua/ct/1041/";
    private static WebDriver driver;
    private static final int SLEEP = 2000;

    @org.testng.annotations.BeforeClass
    public void testBeforeClass() {
        System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
        driver = new ChromeDriver();
        driver.get(siteHomePage);
    }

    @org.testng.annotations.Test
    public void testCompare() throws InterruptedException {
        HomePage homepage = PageFactory.initElements(driver, HomePage.class);
        List<WebElement> list = homepage.List();
        if (list.size() >= 2) {
            list.get(0).click();
            Thread.sleep(SLEEP);
            list.get(1).click();
            Thread.sleep(SLEEP);
            ComparePage comparePage = homepage.choiceCompare();
            Assert.assertEquals(2, comparePage.size());
            Thread.sleep(SLEEP);
            comparePage.removing().accept();
            Thread.sleep(SLEEP);
        }
    }

    @org.testng.annotations.AfterClass
    public void closeWebDriver() {
        driver.close();
    }

}

