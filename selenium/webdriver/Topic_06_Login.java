package webdriver;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Topic_06_Login {
    WebDriver driver;

    @BeforeClass
    public void  initialBrowser() {
        driver = new FirefoxDriver();
    }

    @Test
    public void TC_01_Empty_Email_Password() {
        driver.get("http://live.techpanda.org/");

        driver.findElement(By.cssSelector("div.footer a[title='My Account']")).click();

        driver.findElement(By.cssSelector("button[title='Login']")).click();

        Assert.assertEquals(driver.findElement(By.id("advice-required-entry-email")).getText(),
                "This is a required field.");
        Assert.assertEquals(driver.findElement(By.id("advice-required-entry-pass")).getText(),
                "This is a required field.");

    }
    @Test
    public void TC_02_Invalid_Email() {
        driver.get("http://live.techpanda.org/");

        driver.findElement(By.cssSelector("div.footer a[title='My Account']")).click();

        driver.findElement(By.id("email")).sendKeys("12341234@123.123");
        driver.findElement(By.id("pass")).sendKeys("123456");
        driver.findElement(By.cssSelector("button[title='Login']")).click();

        Assert.assertEquals(driver.findElement(By.id("advice-validate-email-email")).getText(),
                "Please enter a valid email address. For example johndoe@domain.com.");

    }
    @Test
    public void TC_03_Password_6_Character() {
        driver.get("http://live.techpanda.org/");

        driver.findElement(By.cssSelector("div.footer a[title='My Account']")).click();

        driver.findElement(By.id("email")).sendKeys("automation@gmail.com");
        driver.findElement(By.id("pass")).sendKeys("123");
        driver.findElement(By.cssSelector("button[title='Login']")).click();

        Assert.assertEquals(driver.findElement(By.id("advice-validate-password-pass")).getText(),
                "Please enter 6 or more characters without leading or trailing spaces.");

    }
    @Test
    public void TC_04_Invalid_Email_Password() {
        driver.get("http://live.techpanda.org/");

        driver.findElement(By.cssSelector("div.footer a[title='My Account']")).click();

        driver.findElement(By.id("email")).sendKeys("automation@gmail.com");
        driver.findElement(By.id("pass")).sendKeys("123123123");
        driver.findElement(By.cssSelector("button[title='Login']")).click();

        Assert.assertEquals(driver.findElement(By.className("error-msg")).getText(),
                "Invalid login or password.");
    }

    @AfterClass
    public  void  cleanBrowser() {
        driver.quit();
    }
}