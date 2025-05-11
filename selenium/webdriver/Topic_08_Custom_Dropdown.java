package webdriver;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;

public class Topic_08_Custom_Dropdown {
    WebDriver driver;

    Select select;
    WebDriverWait explicitWait;

    @BeforeClass
    public void  initialBrowser() {
        driver = new FirefoxDriver();

        explicitWait = new WebDriverWait(driver, Duration.ofSeconds(15));

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

    }

    @Test
    public void TC_01_Jquery() throws InterruptedException {
        driver.get("http://jqueryui.com/resources/demos/selectmenu/default.html");

        selectIteminCustomDropdown("span#speed-button","ul#speed-menu>li>div","Slower");
        Assert.assertEquals(driver.findElement(By.cssSelector("span#speed-button>span.ui-selectmenu-text")).getText(),"Slower");

        selectIteminCustomDropdown("span#number-button","ul#number-menu>li>div","10");
        Assert.assertEquals(driver.findElement(By.cssSelector("span#number-button>span.ui-selectmenu-text")).getText(),"10");

        selectIteminCustomDropdown("span#salutation-button","ul#salutation-menu>li>div","Dr.");
        Assert.assertEquals(driver.findElement(By.cssSelector("span#salutation-button>span.ui-selectmenu-text")).getText(),"Dr.");


        //Các phần trong phạm vi bài học nhưng chưa học tới
        //Wait:  Riêng Selenium có 3 cách: ImplicitWait, WebDriverWait, FluentWait+ 1 cách của Java Thread.sleep()
            //ImplicitWait: wait cho việc tìm element
            //ExplicitWait: WebDriverWait:  wait cho element với 1 điều kiện rõ ràng: hiển thị/ko hiển thị/clickable/selected...
            //FluentWait: có thể sửa thời gian polling lại được
        //Biểu thức điều kiện:
                //If
                //If-else
                //If-else if-else
                //switch-case
        //Biểu thức vòng lặp (loop)
                //for
                //do-while
                //while
        //Java Collection
                //List
                //Queue
                //Set
                //Ngoài ra có Map
        //Break: dùng trong các biểu thức điều kiện
        //Nếu đã chọn 1 item r lại muốn chọn item khác, thay vì viết lại code từ đầu
        //=> Extract đoạn code đó thành 1 hàm, đặt tên hàm để tái sử dụng và không sinh ra quá nhiều dòng code
        // đặt tên biến có data type = String
        //=>Khi dùng thì truyền biến vào hàm là được

        //dự án thực tế: 1 hàm sẽ chỉ dùng đc trong 1 site/app
        //Tuy nhiên, hành vi khi sử dụng custom dropdown là giống nhau
    }

    @Test
    public void TC_02_ReactJS() throws InterruptedException {
        driver.get("https://react.semantic-ui.com/maximize/dropdown-example-selection/");

        selectIteminCustomDropdown("div.dropdown", "div.visible.menu.transition>div>span", "Elliot Fu");
        Assert.assertEquals(driver.findElement(By.cssSelector("div.divider.text")).getText(), "Elliot Fu");
    }

    @Test
    public void TC_03_VueJS() throws InterruptedException {
        driver.get("https://mikerodham.github.io/vue-dropdowns/");

        selectIteminCustomDropdown("li.dropdown-toggle", "ul.dropdown-menu>li>a", "Second Option");
        Assert.assertEquals(driver.findElement(By.cssSelector("li.dropdown-toggle")).getText(), "Second Option");
    }

    @Test
    public void TC_04_Editable() throws InterruptedException {
        driver.get("https://react.semantic-ui.com/maximize/dropdown-example-search-selection/");

        //Hành vi của Editable dropdown có thể input kí tự khác so với Custom Dropdown thông thường 1 chút

        inputIteminCustomDropdown("input.search", "div.item>span", "Albania");
        Assert.assertEquals(driver.findElement(By.cssSelector("div.divider.text")).getText(), "Albania");
    }

    private void selectIteminCustomDropdown(String parentCss, String childCss, String SelectDropdown) throws InterruptedException {
        //Hành vi để thao tác lên dropdown
        //1. Chờ để dropdown có thể thao tác lên được (clickable)
        //2. Click vào element để nó xổ ra các item
        explicitWait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(parentCss))).click();
        Thread.sleep(2000);

        //3. Chờ cho tất cả các item đc load ra (presence)
        //4. Tìm ra item được mong đợi
        //5. Click lên item đó
        List<WebElement> allItems = explicitWait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.cssSelector(childCss)));
        //Chỗ này presence vì có 2 loại: visible và invisible (presence)
        //Cần chờ đến khi load ra cả những item bên dưới (scroll nếu nhiều item)
        //Lấy đến thẻ div là thẻ chứa trực tiếp text

        for (WebElement item : allItems) {
            if (item.getText().equals(SelectDropdown)) {
                item.click();
                break;
            }
        }
    }

    private void inputIteminCustomDropdown(String parentCss, String childCss, String textItem) throws InterruptedException {
        //Hành vi để thao tác lên Editable dropdown
        //1. Chờ để dropdown có thể nhập được (visible)
        //2. sendkey vào textbox để nó xổ ra các item
        WebElement dropdownTextbox = explicitWait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(parentCss)));
        dropdownTextbox.clear();
        dropdownTextbox.sendKeys(textItem);
        Thread.sleep(2000);

        //3. Chờ cho tất cả các item đc load ra (presence)
        //4. Tìm ra item được mong đợi
        //5. Click lên item đó
        List<WebElement> allItems = explicitWait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.cssSelector(childCss)));
        //Chỗ này presence vì có 2 loại: visible và invisible (presence)
        //Cần chờ đến khi load ra cả những item bên dưới (scroll nếu nhiều item)
        //Lấy đến thẻ div là thẻ chứa trực tiếp text

        for (WebElement item : allItems) {
            if (item.getText().equals(textItem)) {
                item.click();
                break;
            }
        }
    }

    @AfterClass
    public  void  cleanBrowser() {

        driver.quit();
    }
}