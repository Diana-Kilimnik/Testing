import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;

public class Main {
    public static void main(String[] args) {
        String siteHomePage = "https://pn.com.ua/ct/1041/";
        System.setProperty("webdriver.chrome.driver", "PageObject/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get(siteHomePage);
        HomePage homepage;
        ComparePage comparePage;
        homepage = PageFactory.initElements(driver, HomePage.class);
        comparePage = homepage.choiceCompare();
    }
}