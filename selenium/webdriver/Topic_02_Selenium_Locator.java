package webdriver;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Topic_02_Selenium_Locator {
    WebDriver driver;

    @BeforeClass
    //Arrange
    public void  initialBrowser() {
        driver = new FirefoxDriver();
    }

    @Test
    public void Register_01_Empty_Data() {

        driver.get("https://alada.vn/tai-khoan/dang-ky.html");

        //Action
        driver.findElement(By.xpath("//button[@type='submit']")).click();

        //Verify
        Assert.assertEquals(driver.findElement(By.id("txtFirstname-error")).getText(),"Vui lòng nhập họ tên");
        Assert.assertEquals(driver.findElement(By.id("txtEmail-error")).getText(),"Vui lòng nhập email");
        Assert.assertEquals(driver.findElement(By.id("txtCEmail-error")).getText(),"Vui lòng nhập lại địa chỉ email");
        Assert.assertEquals(driver.findElement(By.id("txtPassword-error")).getText(),"Vui lòng nhập mật khẩu");
        Assert.assertEquals(driver.findElement(By.id("txtCPassword-error")).getText(),"Vui lòng nhập lại mật khẩu");
        Assert.assertEquals(driver.findElement(By.id("txtPhone-error")).getText(),"Vui lòng nhập số điện thoại.");


    }
    @Test
    public void Register_02_Invalid_Email() {
        driver.get("https://alada.vn/tai-khoan/dang-ky.html");

        driver.findElement(By.id("txtFirstname")).sendKeys("kim dang");
        driver.findElement(By.id("txtEmail")).sendKeys("kimdt");
        driver.findElement(By.id("txtCEmail")).sendKeys("kimdt");
        driver.findElement(By.id("txtPassword")).sendKeys("Dangkim1@");
        driver.findElement(By.id("txtCPassword")).sendKeys("Dangkim1@");
        driver.findElement(By.id("txtPhone")).sendKeys("0909090909");

        driver.findElement(By.xpath("//button[@type='submit']")).click();

        Assert.assertEquals(driver.findElement(By.id("txtEmail-error")).getText(),"Vui lòng nhập email hợp lệ");
        Assert.assertEquals(driver.findElement(By.id("txtCEmail-error")).getText(),"Email nhập lại không đúng");

    }
    @Test
    public void Register_03_Incorrect_Confirm_Email() {
        driver.get("https://alada.vn/tai-khoan/dang-ky.html");

        driver.findElement(By.id("txtFirstname")).sendKeys("kim dang");
        driver.findElement(By.id("txtEmail")).sendKeys("kimdt@gmail.com");
        driver.findElement(By.id("txtCEmail")).sendKeys("kimdt");
        driver.findElement(By.id("txtPassword")).sendKeys("Dangkim1@");
        driver.findElement(By.id("txtCPassword")).sendKeys("Dangkim1@");
        driver.findElement(By.id("txtPhone")).sendKeys("0909090909");

        driver.findElement(By.xpath("//button[@type='submit']")).click();

        Assert.assertEquals(driver.findElement(By.id("txtCEmail-error")).getText(),"Email nhập lại không đúng");
        
    }
    @Test
    public void Register_04_Incorrect_Password() {
        driver.get("https://alada.vn/tai-khoan/dang-ky.html");

        driver.findElement(By.id("txtFirstname")).sendKeys("kim dang");
        driver.findElement(By.id("txtEmail")).sendKeys("kimdt@gmail.com");
        driver.findElement(By.id("txtCEmail")).sendKeys("kimdt@gmail.com");
        driver.findElement(By.id("txtPassword")).sendKeys("Dan");
        driver.findElement(By.id("txtCPassword")).sendKeys("Dan");
        driver.findElement(By.id("txtPhone")).sendKeys("0909090909");

        driver.findElement(By.xpath("//button[@type='submit']")).click();

        Assert.assertEquals(driver.findElement(By.id("txtPassword-error")).getText(),"Mật khẩu phải có ít nhất 6 ký tự");
        Assert.assertEquals(driver.findElement(By.id("txtCPassword-error")).getText(),"Mật khẩu phải có ít nhất 6 ký tự");

    }
    @Test
    public void Register_05_Incorrect_Confirm_Password() {
        driver.get("https://alada.vn/tai-khoan/dang-ky.html");

        driver.findElement(By.id("txtFirstname")).sendKeys("kim dang");
        driver.findElement(By.id("txtEmail")).sendKeys("kimdt@gmail.com");
        driver.findElement(By.id("txtCEmail")).sendKeys("kimdt@gmail.com");
        driver.findElement(By.id("txtPassword")).sendKeys("Dangkim1@");
        driver.findElement(By.id("txtCPassword")).sendKeys("Dangggg");
        driver.findElement(By.id("txtPhone")).sendKeys("0909090909");

        driver.findElement(By.xpath("//button[@type='submit']")).click();

        Assert.assertEquals(driver.findElement(By.id("txtCPassword-error")).getText(),"Mật khẩu bạn nhập không khớp");

    }
    @Test
    public void Register_05_Incorrect_Phone_Number() {
        driver.get("https://alada.vn/tai-khoan/dang-ky.html");

        driver.findElement(By.id("txtFirstname")).sendKeys("kim dang");
        driver.findElement(By.id("txtEmail")).sendKeys("kimdt@gmail.com");
        driver.findElement(By.id("txtCEmail")).sendKeys("kimdt@gmail.com");
        driver.findElement(By.id("txtPassword")).sendKeys("Dangkim1@");
        driver.findElement(By.id("txtCPassword")).sendKeys("Dangkim1@");
        driver.findElement(By.id("txtPhone")).sendKeys("0909090");

        driver.findElement(By.xpath("//button[@type='submit']")).click();

        Assert.assertEquals(driver.findElement(By.id("txtPhone-error")).getText(),"Số điện thoại phải từ 10-11 số.");


        driver.findElement(By.id("txtPhone")).clear();

        driver.findElement(By.id("txtPhone")).sendKeys("090909012345");

        driver.findElement(By.xpath("//button[@type='submit']")).click();

        Assert.assertEquals(driver.findElement(By.id("txtPhone-error")).getText(),"Số điện thoại phải từ 10-11 số.");


        driver.findElement(By.id("txtPhone")).clear();

        driver.findElement(By.id("txtPhone")).sendKeys("7909090909");

        driver.findElement(By.xpath("//button[@type='submit']")).click();

        Assert.assertEquals(driver.findElement(By.id("txtPhone-error")).getText(),"Số điện thoại bắt đầu bằng: 09 - 03 - 012 - 016 - 018 - 019 - 088 - 03 - 05 - 07 - 08");

    }

    @AfterClass
    public  void  cleanBrowser() {
        driver.quit();
    }
}