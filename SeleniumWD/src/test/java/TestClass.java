import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.List;

public class TestClass {

    private static WebDriver WEBDRIVER;
    private static final int SLEEP = 2000;

    @BeforeClass
    public static void setWebDriver() {
        ChromeOptions options = new ChromeOptions();
        options.setBinary("C:/Program Files (x86)/Google/Chrome/Application/chrome.exe");

        System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
        WEBDRIVER = new ChromeDriver(options);
    }

    @Test
    public void test1() throws InterruptedException {
        WEBDRIVER.get("https://pn.com.ua/ct/1041/");
        List<WebElement> popularMakers = WEBDRIVER.findElements(By.xpath(".//span[@class='popular']"));
        List<WebElement> popularMakerOfGood = WEBDRIVER.findElements(By.xpath
                (".//span[@class='popular']/descendant::small"));

        if (popularMakers.size() > 0) {
            popularMakers.get(0).click();
            String manufacturer = popularMakers.get(0).getText().
                    replace(popularMakerOfGood.get(0).getText(), "");

            Thread.sleep(SLEEP);
            List<WebElement> list = WEBDRIVER.findElements(By.xpath(".//div[@class='catalog-block-head']"));
            for (WebElement good : list) {
                Assert.assertTrue(good.getText().contains(manufacturer));
            }
        }
    }

    @Test
    public void test2() throws InterruptedException {
        WEBDRIVER.get("https://pn.com.ua/ct/1041/");
        List<WebElement> popularMakers = WEBDRIVER.findElements(By.xpath(".//span[@class='popular']"));
        List<WebElement> popularMakerOfGood = WEBDRIVER.findElements(By.xpath
                (".//span[@class='popular']/descendant::small"));

        if (popularMakers.size() > 0) {
            int count1 = Integer.parseInt(popularMakerOfGood.get(0).getText());
            popularMakers.get(0).click();

            Thread.sleep(SLEEP);
            WebElement Makers = WEBDRIVER.findElement(By.xpath
                    (".//ul[@class='breadcrumb']/child::li[last()]/descendant::b"));
            int count2 = Integer.parseInt(Makers.getText());
            Assert.assertEquals(count1, count2);
        }
    }

    @Test
    public void test3() throws InterruptedException {
        WEBDRIVER.get("https://pn.com.ua/ct/1041/");
        List<WebElement> list = WEBDRIVER.findElements(By.xpath(".//a[@class='add-to-compare-link']"));
        if (list.size() >= 2) {
            list.get(0).click();
            Thread.sleep(SLEEP);
            list.get(1).click();
            WEBDRIVER.findElement(By.xpath(".//a[@data-href='/compare/1041/']")).click();
            Assert.assertEquals(2, WEBDRIVER.findElements(By.xpath(".//th[@class='item']")).size());
            Thread.sleep(SLEEP);
            WEBDRIVER.findElement(By.xpath(".//a[@data-method='post']")).click();
            Thread.sleep(SLEEP);
            WEBDRIVER.switchTo().alert().accept();
        }
    }

    @Test
    public void test4() throws InterruptedException {
        WEBDRIVER.get("https://pn.com.ua/ct/1041/");
        WEBDRIVER.findElement(By.xpath(".//li[@class='dropdown dropdown-sorting']")).click();
        WEBDRIVER.findElement(By.xpath(".//a[@data-sort='price']")).click();
        Thread.sleep(SLEEP);

        List<WebElement> priceList = WEBDRIVER.findElements(By.xpath(".//a[@class='price']/span/strong"));
        for (int i = 0; i < priceList.size() - 1; i++) {
            int current = Integer.parseInt(priceList.get(i).getText().
                    replace(" грн", "").replace(" ", ""));
            int next = Integer.parseInt(priceList.get(i + 1).getText().
                    replace(" грн", "").replace(" ", ""));
            Assert.assertTrue(current <= next);
        }
    }

    @Test
    public void test5() throws InterruptedException {
        WEBDRIVER.get("https://pn.com.ua/ct/1041/");
        List<WebElement> list = WEBDRIVER.findElements(By.xpath(".//a[@class='add-to-compare-link']"));
        if (list.size() >= 4) {
            list.get(0).click();
            Thread.sleep(SLEEP);
            list.get(1).click();
            Thread.sleep(SLEEP);
            list.get(2).click();
            Thread.sleep(SLEEP);
            list.get(3).click();
            Thread.sleep(SLEEP);
            WEBDRIVER.findElement(By.xpath(".//a[@data-href='/compare/1041/']")).click();
            Thread.sleep(SLEEP);
            WEBDRIVER.findElement(By.xpath(".//a[@data-method='post']")).click();
            Thread.sleep(SLEEP);
            WEBDRIVER.switchTo().alert().accept();
        }
    }

    @AfterClass
    public static void closeWebDriver() {
        WEBDRIVER.close();
    }
}
