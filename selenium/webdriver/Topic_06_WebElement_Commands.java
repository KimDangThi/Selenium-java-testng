package webdriver;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static org.openqa.selenium.By.*;

public class Topic_06_WebElement_Commands {
    WebDriver driver;

    @BeforeClass
    public void  initialBrowser() {
        driver = new FirefoxDriver();
    }

    @Test
    public void TC_01_Displayed() {
        driver.get("https://automationfc.github.io/basic-form/index.html");

        WebElement Email = driver.findElement(By.id("mail"));
        if (Email.isDisplayed()) {
            System.out.println("Email is displayed");
            Email.sendKeys("Automation Testing");
        } else {
            System.out.println("Email is not displayed");
        }

        WebElement AgeUnder18 = driver.findElement(xpath("//label[text()='Under 18']"));
        if (AgeUnder18.isDisplayed()) {
            System.out.println("AgeUnder18 is displayed");
            AgeUnder18.click();
        } else {
            System.out.println("AgeUnder18 is not displayed");
        }

        WebElement Education = driver.findElement(xpath("//textarea[@name='user_edu']"));
        if (Education.isDisplayed()) {
            System.out.println("Education is displayed");
            Education.sendKeys("Automation Testing");
        } else {
            System.out.println("Education is not displayed");
        }

        WebElement NameUser5 = driver.findElement(xpath("//h5[text()='Name: User5']"));
        if (NameUser5.isDisplayed()) {
            System.out.println("NameUser5 is displayed");
        } else {
            System.out.println("NameUser5 is not displayed");
        }
    }
    @Test
    public void TC_02_Enable_Disable() {
        driver.get("https://automationfc.github.io/basic-form/index.html");

        WebElement Email = driver.findElement(By.id("mail"));
        if (Email.isEnabled()) {
            System.out.println("Email is enabled");
        } else {
            System.out.println("Email is disabled");
        }

        WebElement AgeUnder18 = driver.findElement(xpath("//label[text()='Under 18']"));
        if (AgeUnder18.isEnabled()) {
            System.out.println("AgeUnder18 is enabled");
        } else {
            System.out.println("AgeUnder18 is disabled");
        }

        WebElement Education = driver.findElement(xpath("//textarea[@name='user_edu']"));
        if (Education.isEnabled()) {
            System.out.println("Education is enabled");
        } else {
            System.out.println("Education is disabled");
        }

        WebElement JobRole01 = driver.findElement(cssSelector("select#job1"));
        if (JobRole01.isEnabled()) {
            System.out.println("JobRole01 is enabled");
        } else {
            System.out.println("JobRole01 is disabled");
        }

        WebElement JobRole02 = driver.findElement(cssSelector("select#job2"));
        if (JobRole02.isEnabled()) {
            System.out.println("JobRole02 is enabled");
        } else {
            System.out.println("JobRole02 is disabled");
        }

        WebElement InterestDevelopment = driver.findElement(cssSelector("input#development"));
        if (InterestDevelopment.isEnabled()) {
            System.out.println("InterestDevelopment Checkbox is enabled");
        } else {
            System.out.println("InterestDevelopment Checkbox is disabled");
        }

        WebElement Slider01 = driver.findElement(cssSelector("input#slider-1"));
        if (JobRole01.isEnabled()) {
            System.out.println("Slider01 is enabled");
        } else {
            System.out.println("Slider01 is disabled");
        }

        WebElement Password = driver.findElement(cssSelector("input#disable_password"));
        if (Password.isEnabled()) {
            System.out.println("Password is enabled");
        } else {
            System.out.println("Password is disabled");
        }

        WebElement AgeRadioButton = driver.findElement(cssSelector("input#radio-disabled"));
        if (AgeRadioButton.isEnabled()) {
            System.out.println("AgeRadioButton is enabled");
        } else {
            System.out.println("AgeRadioButton is disabled");
        }

        WebElement Biography = driver.findElement(cssSelector("textarea#bio"));
        if (Biography.isEnabled()) {
            System.out.println("Biography is enabled");
        } else {
            System.out.println("Biography is disabled");
        }

        WebElement JobRole03 = driver.findElement(cssSelector("select#job3"));
        if (JobRole03.isEnabled()) {
            System.out.println("JobRole03 is enabled");
        } else {
            System.out.println("JobRole03 is disabled");
        }

        WebElement InterestCheckbox = driver.findElement(cssSelector("input#check-disbaled"));
        if (InterestCheckbox.isEnabled()) {
            System.out.println("InterestCheckbox is enabled");
        } else {
            System.out.println("InterestCheckbox is disabled");
        }

        WebElement Slider02 = driver.findElement(cssSelector("input#slider-2"));
        if (Slider02.isEnabled()) {
            System.out.println("Slider02 is enabled");
        } else {
            System.out.println("Slider02 is disabled");
        }
    }
    @Test
    public void TC_03_Selected() {
        driver.get("https://automationfc.github.io/basic-form/index.html");

        WebElement AgeUnder18 = driver.findElement(xpath("//label[text()='Under 18']"));
        AgeUnder18.click();

        if (AgeUnder18.isSelected()) {
            System.out.println("AgeUnder18 is selected");
        } else {
            System.out.println("AgeUnder18 is not selected");
        }

        WebElement LanguageJava = driver.findElement(cssSelector("input#java"));
        LanguageJava.click();

        if (LanguageJava.isSelected()) {
            System.out.println("LanguageJava is selected");
        } else {
            System.out.println("LanguageJava is not selected");
        }

        LanguageJava.click();

        if (LanguageJava.isSelected()) {
            System.out.println("LanguageJava is selected");
        } else {
            System.out.println("LanguageJava is not selected");
        }
    }
    @Test
    public void TC_04_MailChimp_Validate() {
        driver.get("https://login.mailchimp.com/signup/");

        driver.findElement(cssSelector("input#email")).sendKeys("autotest@gmail.com");
        driver.findElement(cssSelector("input#email")).sendKeys(Keys.TAB);

        WebElement password =driver.findElement(id("new_password"));

        password.sendKeys("1111");
        password.sendKeys(Keys.TAB);
        Assert.assertTrue(driver.findElement(cssSelector("li.lowercase-char.not-completed")).isDisplayed());
        Assert.assertTrue(driver.findElement(cssSelector("li.uppercase-char.not-completed")).isDisplayed());
        Assert.assertTrue(driver.findElement(cssSelector("li.number-char.completed")).isDisplayed());
        Assert.assertTrue(driver.findElement(cssSelector("li.special-char.not-completed")).isDisplayed());
        Assert.assertTrue(driver.findElement(xpath("//li[@class='8-char not-completed']")).isDisplayed());
        Assert.assertTrue(driver.findElement(cssSelector("li.username-check.completed")).isDisplayed());

        password.clear();
        password.sendKeys("abcd");
        password.sendKeys(Keys.TAB);
        Assert.assertTrue(driver.findElement(cssSelector("li.lowercase-char.completed")).isDisplayed());
        Assert.assertTrue(driver.findElement(cssSelector("li.uppercase-char.not-completed")).isDisplayed());
        Assert.assertTrue(driver.findElement(cssSelector("li.number-char.not-completed")).isDisplayed());
        Assert.assertTrue(driver.findElement(cssSelector("li.special-char.not-completed")).isDisplayed());
        Assert.assertTrue(driver.findElement(xpath("//li[@class='8-char not-completed']")).isDisplayed());
        Assert.assertTrue(driver.findElement(cssSelector("li.username-check.completed")).isDisplayed());

        password.clear();
        password.sendKeys("ABCD");
        password.sendKeys(Keys.TAB);
        Assert.assertTrue(driver.findElement(cssSelector("li.lowercase-char.not-completed")).isDisplayed());
        Assert.assertTrue(driver.findElement(cssSelector("li.uppercase-char.completed")).isDisplayed());
        Assert.assertTrue(driver.findElement(cssSelector("li.number-char.not-completed")).isDisplayed());
        Assert.assertTrue(driver.findElement(cssSelector("li.special-char.not-completed")).isDisplayed());
        Assert.assertTrue(driver.findElement(xpath("//li[@class='8-char not-completed']")).isDisplayed());
        Assert.assertTrue(driver.findElement(cssSelector("li.username-check.completed")).isDisplayed());

        password.clear();
        password.sendKeys("@#$%");
        password.sendKeys(Keys.TAB);
        Assert.assertTrue(driver.findElement(cssSelector("li.lowercase-char.not-completed")).isDisplayed());
        Assert.assertTrue(driver.findElement(cssSelector("li.uppercase-char.not-completed")).isDisplayed());
        Assert.assertTrue(driver.findElement(cssSelector("li.number-char.not-completed")).isDisplayed());
        Assert.assertTrue(driver.findElement(cssSelector("li.special-char.completed")).isDisplayed());
        Assert.assertTrue(driver.findElement(xpath("//li[@class='8-char not-completed']")).isDisplayed());
        Assert.assertTrue(driver.findElement(cssSelector("li.username-check.completed")).isDisplayed());

        password.clear();
        password.sendKeys("Aa123$%^&hj");
        password.sendKeys(Keys.TAB);
        Assert.assertFalse(driver.findElement(cssSelector("li.lowercase-char.completed")).isDisplayed());
        Assert.assertFalse(driver.findElement(cssSelector("li.uppercase-char.completed")).isDisplayed());
        Assert.assertFalse(driver.findElement(cssSelector("li.number-char.completed")).isDisplayed());
        Assert.assertFalse(driver.findElement(cssSelector("li.special-char.completed")).isDisplayed());
        Assert.assertFalse(driver.findElement(xpath("//li[@class='8-char completed']")).isDisplayed());
        Assert.assertFalse(driver.findElement(cssSelector("li.username-check.completed")).isDisplayed());

    }

    @AfterClass
    public  void  cleanBrowser() {
        driver.quit();
    }
}