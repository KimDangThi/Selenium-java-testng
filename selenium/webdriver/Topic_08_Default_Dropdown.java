package webdriver;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.List;

public class Topic_08_Default_Dropdown {
    WebDriver driver;

    Select select;

    @BeforeClass
    public void  initialBrowser() {
        driver = new FirefoxDriver();

    }

    @Test
    public void TC_04_rodecode() {
        driver.get("https://rode.com/en/support/where-to-buy");

        new Select(driver.findElement(By.id("country"))).selectByVisibleText("Vietnam");

        Assert.assertFalse(new Select(driver.findElement(By.id("country"))).isMultiple());

        driver.findElement(By.id("map_search_query")).sendKeys("HO CHI MINH");

        driver.findElement(By.xpath("//button[text()='Search']")).click();

        List<WebElement> dealers = driver.findElements(By.xpath(
                "//h3[text()='Dealers']/following-sibling::div//h4"));

        Assert.assertEquals(dealers.size(),16);

        for (WebElement element:dealers) {
            System.out.println(element.getText());
        }
    }

    @AfterClass
    public  void  cleanBrowser() {

        driver.quit();
    }
}