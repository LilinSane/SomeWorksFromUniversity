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

public class WebSearchTest {

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
    public void search() {
        driver.get("https://archive.org/");
        WebElement searchInput = (WebElement) jsExecutor.executeScript("return document.querySelector(\"body > app-root\").shadowRoot.querySelector(\"#maincontent > div > router-slot > home-page\").shadowRoot.querySelector(\"#wayback-search-container > ia-wayback-search\").shadowRoot.querySelector(\"#url\")");
        searchInput.sendKeys("itmo\n");
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        WebElement foundUrl = (WebElement) jsExecutor.executeScript("return document.querySelector(\"#react-wayback-search > div.search-result-container.container > ul > li:nth-child(3) > div.result-details > div.result-item-heading > a\")");
        foundUrl.click();
        assertEquals(driver.getCurrentUrl(), "https://itmo.ru/");
    }

    @Test
    public void negativeSearch(){
        driver.get("https://archive.org/");
        WebElement searchInput = (WebElement) jsExecutor.executeScript("return document.querySelector(\"body > app-root\").shadowRoot.querySelector(\"#maincontent > div > router-slot > home-page\").shadowRoot.querySelector(\"#wayback-search-container > ia-wayback-search\").shadowRoot.querySelector(\"#url\")");
        searchInput.sendKeys("asfasfasnfjkaf\n");
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        WebElement notFoundMsg = (WebElement) jsExecutor.executeScript("return document.querySelector(\"#react-wayback-search > div.search-result-container.container > p\")");
        assertEquals(notFoundMsg.getText().toLowerCase(), "no results found. please try a different search query");
    }
}
