package javaSDET;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;

public class Topic_03_Select_Library {

    WebDriver driver;
    Select select;
//    Actions actions;
//    WebDriverWait explicitWait;

    @BeforeClass
    public void initialBrowser() {
        //Dropdown có 2 loại: Default dropdown + Custom dropdown
        //Nếu check trong code HTML là thẻ Select- các lựa chọn là Option => Default dropdown
        // => Sử dụng thư viện Select để handle
        //Khác Select-Option => Custom Dropdown
        // => Viết hàm để handle

        // Khởi tạo Browser nghĩa là Mở browser
        driver = new FirefoxDriver();
        //Không nên khởi tạo thư viện Select ở @Before Class vì không có biến để truyền vào, dropdown chưa xuất hiện
        // => Khởi tạo ở @Test
        //Chỉ khởi tạo ở @Before Class những thứ nhận driver là tham số, VD:
//        actions = new Actions(driver);
//        explicitWait = new WebDriverWait(driver, Duration.ofSeconds(15));

    }

    @Test
    public void TC_01_Select() {
        driver.get("https://www.facebook.com/reg/");

        select = new Select(driver.findElement(By.id("day")));

//        //Các hàm của thư viện Select: 2 hàm đánh dấu đỏ là sử dụng nhiều nhất
//        //Các hàm có select ở đầu là hàm chọn giá trị
//        select.selectByIndex();         //chọn theo index của thẻ Option, bắt đầu từ 0
//        select.selectByValue();         //Chọn theo value trong code HTML
//        select.selectByVisibleText();   //Chọn text hiển thị bên ngoài
//        select.selectByContainsVisibleText();
//
//        //Các hàm bỏ chọn: có đầu là deselect
//        select.deselectAll();
//        select.deselectByIndex();
//        select.deselectByValue();
//        select.deSelectByContainsVisibleText();
//        select.deselectByVisibleText();
//
//        //Kiểm tra dropdown là single hay multiple
//        select.isMultiple();
//
//        //Kiểm tra giá trị vừa chọn
//        select.getFirstSelectedOption();
//
//        //Lấy ra các giá trị Options được chọn
//        select.getAllSelectedOptions();
//
//        //Lấy ra tất cả các option trong dropdown
//        select.getOptions();

        //Chọn 1 item
        select.selectByVisibleText("25");

        //Vrf đã chọn đúng hay chưa
        Assert.assertEquals(select.getFirstSelectedOption().getText(),"25");

        //Ktra dropdown có phải multiple ko
        Assert.assertFalse(select.isMultiple());

        //Check tổng số lượng
        Assert.assertEquals(select.getOptions().size(),31);

        //Nếu muốn check tiếp thì gán lại cho thẻ Select
        select = new Select(driver.findElement(By.id("month")));
        select.selectByVisibleText("Tháng 6");

        select = new Select(driver.findElement(By.id("year")));
        select.selectByVisibleText("1998");
    }
    @AfterClass
    public  void  cleanBrowser() {

       driver.quit();
    }
}
