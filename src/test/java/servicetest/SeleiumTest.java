package servicetest;

import com.github.dockerjava.api.model.Driver;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class SeleiumTest {
    private WebDriver driver;
    private WebDriverWait wait;
    private String baseUrl = "https://vitimex.com.vn/";

    @BeforeEach
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "E:\\chromedriver-win64\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
    }

    @Test
    void test() {
        driver.get(baseUrl);
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement username = wait.until(ExpectedConditions.presenceOfElementLocated(By.className("li_log")));
        username.click();
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[contains(text(),'Đăng ký tài khoản')]"))).click();

        //Đăng kí
        driver.findElement(By.cssSelector("#name.form-control")).sendKeys("Nguyen Van Ba");
        driver.findElement(By.cssSelector("#phone.form-control")).sendKeys("0388989816");
        driver.findElement(By.cssSelector("#email.form-control")).sendKeys("anhbanhoa110@gmail.com");
        driver.findElement(By.cssSelector("#pass-regis.form-control")).sendKeys("123456a");
        driver.findElement(By.cssSelector("#pass-confirm.form-control")).sendKeys("123456a");
        driver.findElement(By.id("register-btn")).click();

        //đăng xuất
        Actions actions = new Actions(driver);
        WebElement username1 = wait.until(ExpectedConditions.presenceOfElementLocated(By.className("username")));
        actions.moveToElement(username1).perform();
        WebElement loguot = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[contains(text(),'Đăng xuất')]")));
        loguot.click();

        //Đăng nhập
        WebElement login = wait.until(ExpectedConditions.presenceOfElementLocated(By.className("li_log")));
        login.click();
        driver.findElement(By.cssSelector("#account.form-control")).sendKeys("0388989816");
        driver.findElement(By.cssSelector("#pass.form-control")).sendKeys("123456a");
        driver.findElement(By.xpath("//a[contains(text(),'Đăng nhập')]")).click();
    }
}
