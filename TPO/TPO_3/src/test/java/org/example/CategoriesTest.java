package org.example;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CategoriesTest {

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
    public void followCategory() {
        driver.get("https://archive.org/");
        WebElement categoryButton = (WebElement) jsExecutor.executeScript("return document.querySelector(\"body > app-root\").shadowRoot.querySelector(\"#maincontent > div > router-slot > home-page\").shadowRoot.querySelector(\"#page-content-container > home-page-hero-block\").shadowRoot.querySelector(\"#icon-block-container > home-page-hero-block-icon-bar\").shadowRoot.querySelector(\"#mediacount-icon-container > a:nth-child(3)\")");
        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        categoryButton.click();
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        WebElement foundResource = (WebElement) jsExecutor.executeScript("return document.querySelector(\"body > app-root\").shadowRoot.querySelector(\"#maincontent > div > router-slot > details-page-router > collection-page\").shadowRoot.querySelector(\"#collection-browser-container > collection-browser\").shadowRoot.querySelector(\"#right-column > infinite-scroller\").shadowRoot.querySelector(\"#container > article:nth-child(2) > tile-dispatcher\").shadowRoot.querySelector(\"#container > a > collection-tile\").shadowRoot.querySelector(\"#title > h4\")");
        assertEquals(foundResource.getText().toLowerCase(), "additional collections - video");
    }
}
