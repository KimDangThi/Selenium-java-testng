package webdriver;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.Random;

public class Topic_07_Textbox_Textarea {
    WebDriver driver;
    Random rand;
    String firstName, lastName, emailAddress, password, fullName;

    @BeforeClass
    public void  initialBrowser() {
        driver = new FirefoxDriver();
        rand = new Random();

        firstName= "Alo";
        lastName = "Hello";
        fullName = firstName + " " + lastName;
        emailAddress ="AloHello" + rand.nextInt(9999)+ "@gmail.com";
        password = "123456789";
    }

    @Test
    public void TC_01_Textbox() throws InterruptedException {
        driver.get("http://live.techpanda.org/");

        driver.findElement(By.cssSelector("div.footer a[title='My Account']")).click();

        driver.findElement(By.cssSelector("a[title='Create an Account']")).click();

        //Đăng ký và verify lại thông tin
        driver.findElement(By.cssSelector("input#firstname")).sendKeys(firstName);
        driver.findElement(By.cssSelector("input#lastname")).sendKeys(lastName);
        driver.findElement(By.cssSelector("input#email_address")).sendKeys(emailAddress);
        driver.findElement(By.cssSelector("input#password")).sendKeys(password);
        driver.findElement(By.cssSelector("input#confirmation")).sendKeys(password);

        driver.findElement(By.cssSelector("button[title='Register']")).click();

        Assert.assertEquals(driver.findElement(By.cssSelector("li.success-msg span")).getText(),
                "Thank you for registering with Main Website Store.");

        String contactInformation = driver.findElement(By.xpath(
                "//h3[text()='Contact Information']//parent::div//following-sibling::div//p")).getText();

        Assert.assertTrue(contactInformation.contains(fullName)
                && contactInformation.contains(emailAddress));

//        //Verify trong trang tab Edit
//        driver.findElement(By.xpath("//h3[text()='Contact Information']//following-sibling::a")).click();
//
//        Assert.assertEquals(driver.findElement(By.id("firstname")).getAttribute("value"),firstName);
//        Assert.assertEquals(driver.findElement(By.id("lastname")).getAttribute("value"),lastName);
//        Assert.assertEquals(driver.findElement(By.id("email")).getAttribute("value"),emailAddress);
//
//        //Logout- Verify quay lại trang Home
//        driver.findElement(By.cssSelector("div.account-cart-wrapper>a")).click();
//
//        driver.findElement(By.cssSelector("a[title='Log Out']")).click();
//
//        Thread.sleep(6000);
//
//        Assert.assertEquals(driver.getTitle(),"Home Page");

        //Chuyển sang tab Mobile
        driver.findElement(By.xpath("//a[text()='Mobile']")).click();

        driver.findElement(By.cssSelector("img[alt='Samsung Galaxy']")).click();

        driver.findElement(By.xpath("//a[text()='Add Your Review']")).click();

        driver.findElement(By.cssSelector("input[id='Quality 1_5']")).click();
        driver.findElement(By.id("review_field")).sendKeys("Good application\nPretty easy to navigate.");
        driver.findElement(By.id("summary_field")).sendKeys("Best Phone");

        driver.findElement(By.cssSelector("button[title='Submit Review']")).click();

        Assert.assertEquals(driver.findElement(By.cssSelector("li.success-msg span")).getText(),"Your review has been accepted for moderation.");
    }

    @AfterClass
    public  void  cleanBrowser() {

        driver.quit();
    }
}