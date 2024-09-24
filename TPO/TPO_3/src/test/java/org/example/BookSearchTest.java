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

public class BookSearchTest {

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
    public void searchMetadata() {
        driver.get("https://archive.org/");
        WebElement searchInput = (WebElement) jsExecutor.executeScript("return document.querySelector(\"body > app-root\").shadowRoot.querySelector(\"#maincontent > div > router-slot > home-page\").shadowRoot.querySelector(\"#page-content-container > home-page-hero-block\").shadowRoot.querySelector(\"#collection-search-container > collection-search-input\").shadowRoot.querySelector(\"#search-input\").shadowRoot.querySelector(\"#text-input\")");
        searchInput.sendKeys("itmo\n");
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        WebElement foundMetadata = (WebElement) jsExecutor.executeScript("return document.querySelector(\"body > app-root\").shadowRoot.querySelector(\"#maincontent > div > router-slot > search-page\").shadowRoot.querySelector(\"#collection-browser-container > collection-browser\").shadowRoot.querySelector(\"#right-column > infinite-scroller\").shadowRoot.querySelector(\"#container > article:nth-child(3) > tile-dispatcher\").shadowRoot.querySelector(\"#container > a > item-tile\").shadowRoot.querySelector(\"div > div > div > image-block\").shadowRoot.querySelector(\"div > item-image\").shadowRoot.querySelector(\"div > img\")");
        assertEquals(foundMetadata.getAttribute("src"), "https://archive.org/services/img/twitter-867736628852404225");
    }

    @Test
    public void negativeSearch(){
        driver.get("https://archive.org/");
        WebElement searchInput = (WebElement) jsExecutor.executeScript("return document.querySelector(\"body > app-root\").shadowRoot.querySelector(\"#maincontent > div > router-slot > home-page\").shadowRoot.querySelector(\"#page-content-container > home-page-hero-block\").shadowRoot.querySelector(\"#collection-search-container > collection-search-input\").shadowRoot.querySelector(\"#search-input\").shadowRoot.querySelector(\"#text-input\")");
        searchInput.sendKeys("asfasfasnfjkaf\n");
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        WebElement foundMetadata = (WebElement) jsExecutor.executeScript("return document.querySelector(\"body > app-root\").shadowRoot.querySelector(\"#maincontent > div > router-slot > search-page\").shadowRoot.querySelector(\"#collection-browser-container > collection-browser\").shadowRoot.querySelector(\"#content-container > empty-placeholder\").shadowRoot.querySelector(\"div > h2\")");
        assertEquals(foundMetadata.getText().toLowerCase(), "your search did not match any items in the archive. try different keywords or a more general search.");
    }

    @Test
    public void searchMetadataInSearchPage() {
        driver.get("https://archive.org/search");
        WebElement searchInput = (WebElement) jsExecutor.executeScript("return document.querySelector(\"body > app-root\").shadowRoot.querySelector(\"#maincontent > div > router-slot > search-page\").shadowRoot.querySelector(\"#search-bar-content-container > collection-search-input\").shadowRoot.querySelector(\"#search-input\").shadowRoot.querySelector(\"#text-input\")");
        searchInput.sendKeys("itmo\n");
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        WebElement foundMetadata = (WebElement) jsExecutor.executeScript("return document.querySelector(\"body > app-root\").shadowRoot.querySelector(\"#maincontent > div > router-slot > search-page\").shadowRoot.querySelector(\"#collection-browser-container > collection-browser\").shadowRoot.querySelector(\"#right-column > infinite-scroller\").shadowRoot.querySelector(\"#container > article:nth-child(3) > tile-dispatcher\").shadowRoot.querySelector(\"#container > a > item-tile\").shadowRoot.querySelector(\"div > div > div > image-block\").shadowRoot.querySelector(\"div > item-image\").shadowRoot.querySelector(\"div > img\")");
        assertEquals(foundMetadata.getAttribute("src"), "https://archive.org/services/img/twitter-867736628852404225");
    }

    @Test
    public void negativeSearchInSearchPage(){
        driver.get("https://archive.org/search");
        WebElement searchInput = (WebElement) jsExecutor.executeScript("return document.querySelector(\"body > app-root\").shadowRoot.querySelector(\"#maincontent > div > router-slot > search-page\").shadowRoot.querySelector(\"#search-bar-content-container > collection-search-input\").shadowRoot.querySelector(\"#search-input\").shadowRoot.querySelector(\"#text-input\")");
        searchInput.sendKeys("asfasfasnfjkaf\n");
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        WebElement foundMetadata = (WebElement) jsExecutor.executeScript("return document.querySelector(\"body > app-root\").shadowRoot.querySelector(\"#maincontent > div > router-slot > search-page\").shadowRoot.querySelector(\"#collection-browser-container > collection-browser\").shadowRoot.querySelector(\"#content-container > empty-placeholder\").shadowRoot.querySelector(\"div > h2\")");
        assertEquals(foundMetadata.getText().toLowerCase(), "your search did not match any items in the archive. try different keywords or a more general search.");
    }
}
