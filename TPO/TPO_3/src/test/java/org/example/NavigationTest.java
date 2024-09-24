package org.example;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class NavigationTest {

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
    public void navigate() {
        driver.get("https://archive.org/");
        WebElement link = (WebElement) jsExecutor.executeScript("return document.querySelector(\"body > app-root\").shadowRoot.querySelector(\"header > ia-topnav\").shadowRoot.querySelector(\"desktop-subnav\").shadowRoot.querySelector(\"ul > li:nth-child(6) > a\")");
        link.click();
        String currentUrl = driver.getCurrentUrl();
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        assertEquals(driver.getCurrentUrl(), currentUrl);
    }

    @Test
    public void navigateSecondly() {
        driver.get("https://archive.org/");
        WebElement link = (WebElement) jsExecutor.executeScript("return document.querySelector(\"body > app-root\").shadowRoot.querySelector(\"header > ia-topnav\").shadowRoot.querySelector(\"desktop-subnav\").shadowRoot.querySelector(\"ul > li:nth-child(6) > a\")");
        link.click();
        WebElement secondLink = (WebElement) jsExecutor.executeScript("return document.querySelector(\"#topnav > ia-topnav > desktop-subnav > ul > li:nth-child(2) > a\")");
        secondLink.click();
        String currentUrl = driver.getCurrentUrl();
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        assertEquals(driver.getCurrentUrl(), currentUrl);
    }
}
