package org.example;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class AuthTest {

    private WebDriver driver;
    private JavascriptExecutor jsExecutor;

    @BeforeEach
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(40));
        jsExecutor = (JavascriptExecutor) driver;
    }

    @AfterEach
    public void tearDown() {
        driver.quit();
    }

    @Test
    public void loginCorrect() {
        driver.get("https://archive.org/");
        WebElement link = (WebElement) jsExecutor.executeScript("return document.querySelector(\"body > app-root\").shadowRoot.querySelector(\"header > ia-topnav\").shadowRoot.querySelector(\"div.topnav > primary-nav\").shadowRoot.querySelector(\"nav > div.user-info > login-button\").shadowRoot.querySelector(\"div > span > a:nth-child(2)\")");
        link.click();
        driver.findElement(By.xpath("//*[@id=\"maincontent\"]/div/div/div[2]/section[3]/form/label[1]/input"));
        driver.findElement(By.xpath("//*[@id=\"maincontent\"]/div/div/div[2]/section[3]/form/label[1]/input")).sendKeys("insanemeyt@gmail.com");
        driver.findElement(By.xpath("//*[@id=\"maincontent\"]/div/div/div[2]/section[3]/form/label[2]/div/input"));
        driver.findElement(By.xpath("//*[@id=\"maincontent\"]/div/div/div[2]/section[3]/form/label[2]/div/input")).sendKeys("qwerty");
        driver.findElement(By.xpath("//*[@id=\"maincontent\"]/div/div/div[2]/section[3]/form/input[3]")).click();
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        WebElement usernameEl = (WebElement) jsExecutor.executeScript("return document.querySelector(\"body > app-root\").shadowRoot.querySelector(\"header > ia-topnav\").shadowRoot.querySelector(\"div.topnav > primary-nav\").shadowRoot.querySelector(\"nav > div.user-info > button > span\")");
        assertEquals(usernameEl.getText().toLowerCase(), "itmo_archive_tester");
    }

    @Test
    public void loginIncorrect() {
        driver.get("https://archive.org/");
        WebElement link = (WebElement) jsExecutor.executeScript("return document.querySelector(\"body > app-root\").shadowRoot.querySelector(\"header > ia-topnav\").shadowRoot.querySelector(\"div.topnav > primary-nav\").shadowRoot.querySelector(\"nav > div.user-info > login-button\").shadowRoot.querySelector(\"div > span > a:nth-child(2)\")");
        link.click();
        String currentUrl = driver.getCurrentUrl();
        driver.findElement(By.xpath("//*[@id=\"maincontent\"]/div/div/div[2]/section[3]/form/label[1]/input"));
        driver.findElement(By.xpath("//*[@id=\"maincontent\"]/div/div/div[2]/section[3]/form/label[1]/input")).sendKeys("insanemeyt@gmail.com");
        driver.findElement(By.xpath("//*[@id=\"maincontent\"]/div/div/div[2]/section[3]/form/label[2]/div/input"));
        driver.findElement(By.xpath("//*[@id=\"maincontent\"]/div/div/div[2]/section[3]/form/label[2]/div/input")).sendKeys("qwertyyyyyy");
        driver.findElement(By.xpath("//*[@id=\"maincontent\"]/div/div/div[2]/section[3]/form/input[3]")).click();
        assertEquals(driver.getCurrentUrl(), currentUrl);
    }

    @Test
    public void logout() {
        driver.get("https://archive.org/");
        WebElement link = (WebElement) jsExecutor.executeScript("return document.querySelector(\"body > app-root\").shadowRoot.querySelector(\"header > ia-topnav\").shadowRoot.querySelector(\"div.topnav > primary-nav\").shadowRoot.querySelector(\"nav > div.user-info > login-button\").shadowRoot.querySelector(\"div > span > a:nth-child(2)\")");
        link.click();
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        driver.findElement(By.xpath("//*[@id=\"maincontent\"]/div/div/div[2]/section[3]/form/label[1]/input"));
        driver.findElement(By.xpath("//*[@id=\"maincontent\"]/div/div/div[2]/section[3]/form/label[1]/input")).sendKeys("insanemeyt@gmail.com");
        driver.findElement(By.xpath("//*[@id=\"maincontent\"]/div/div/div[2]/section[3]/form/label[2]/div/input"));
        driver.findElement(By.xpath("//*[@id=\"maincontent\"]/div/div/div[2]/section[3]/form/label[2]/div/input")).sendKeys("qwerty");
        driver.findElement(By.xpath("//*[@id=\"maincontent\"]/div/div/div[2]/section[3]/form/input[3]")).click();
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        WebElement userIcon = (WebElement) jsExecutor.executeScript("return document.querySelector(\"body > app-root\").shadowRoot.querySelector(\"header > ia-topnav\").shadowRoot.querySelector(\"div.topnav > primary-nav\").shadowRoot.querySelector(\"nav > div.user-info > button > img\")");
        userIcon.click();
        WebElement logoutButton = (WebElement) jsExecutor.executeScript("return document.querySelector(\"body > app-root\").shadowRoot.querySelector(\"header > ia-topnav\").shadowRoot.querySelector(\"user-menu\").shadowRoot.querySelector(\"div > nav > ul > li:nth-child(10) > a\")");
        logoutButton.click();
        WebElement newLink = (WebElement) jsExecutor.executeScript("return document.querySelector(\"body > app-root\").shadowRoot.querySelector(\"header > ia-topnav\").shadowRoot.querySelector(\"div.topnav > primary-nav\").shadowRoot.querySelector(\"nav > div.user-info > login-button\").shadowRoot.querySelector(\"div > span > a:nth-child(2)\")");
        assertEquals(newLink.getText().toLowerCase(), "log in");
    }

}

