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

public class FilterSearchTest {

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
    public void searchVideo() {
        driver.get("https://archive.org/search");
        WebElement searchInput = (WebElement) jsExecutor.executeScript("return document.querySelector(\"body > app-root\").shadowRoot.querySelector(\"#maincontent > div > router-slot > search-page\").shadowRoot.querySelector(\"#search-bar-content-container > collection-search-input\").shadowRoot.querySelector(\"#search-input\").shadowRoot.querySelector(\"#text-input\")");
        searchInput.sendKeys("");
        WebElement filterButton = (WebElement) jsExecutor.executeScript("return document.querySelector(\"body > app-root\").shadowRoot.querySelector(\"#maincontent > div > router-slot > search-page\").shadowRoot.querySelector(\"#search-bar-content-container > collection-search-input\").shadowRoot.querySelector(\"#button-collapser > ul > li:nth-child(3) > label > input[type=radio]\")");
        filterButton.click();
        searchInput.sendKeys("itmo\n");
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        WebElement foundResource = (WebElement) jsExecutor.executeScript("return document.querySelector(\"#ikind-search > div > div:nth-child(2) > div.C234 > div.item-ttl.C.C2 > a > div.tile-img > img\")");
        assertEquals(foundResource.getAttribute("src"), "https://archive.org/download/NTV_20220607_052500_Moi_universiteti._Budushchee_za_nastoyashchim/NTV_20220607_052500_Moi_universiteti._Budushchee_za_nastoyashchim.thumbs/NTV_20220607_052500_Moi_universiteti._Budushchee_za_nastoyashchim_002667.jpg");
    }

    @Test
    public void negativeSearchVideo(){
        driver.get("https://archive.org/search");
        WebElement searchInput = (WebElement) jsExecutor.executeScript("return document.querySelector(\"body > app-root\").shadowRoot.querySelector(\"#maincontent > div > router-slot > search-page\").shadowRoot.querySelector(\"#search-bar-content-container > collection-search-input\").shadowRoot.querySelector(\"#search-input\").shadowRoot.querySelector(\"#text-input\")");
        searchInput.sendKeys("");
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        WebElement filterButton = (WebElement) jsExecutor.executeScript("return document.querySelector(\"body > app-root\").shadowRoot.querySelector(\"#maincontent > div > router-slot > search-page\").shadowRoot.querySelector(\"#search-bar-content-container > collection-search-input\").shadowRoot.querySelector(\"#button-collapser > ul > li:nth-child(3) > label > input[type=radio]\")");
        filterButton.click();
        searchInput.sendKeys("asfasfasnfjkaf\n");
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        WebElement foundResource = (WebElement) jsExecutor.executeScript("return document.querySelector(\"#search-fail > h2\")");
        assertEquals(foundResource.getText().toLowerCase(), "sorry, we couldn't find a match.");
    }

    @Test
    public void searchVideoWithAdditionals() {
        driver.get("https://archive.org/search");
        WebElement searchInput = (WebElement) jsExecutor.executeScript("return document.querySelector(\"body > app-root\").shadowRoot.querySelector(\"#maincontent > div > router-slot > search-page\").shadowRoot.querySelector(\"#search-bar-content-container > collection-search-input\").shadowRoot.querySelector(\"#search-input\").shadowRoot.querySelector(\"#text-input\")");
        searchInput.sendKeys("");
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        WebElement filterButton = (WebElement) jsExecutor.executeScript("return document.querySelector(\"body > app-root\").shadowRoot.querySelector(\"#maincontent > div > router-slot > search-page\").shadowRoot.querySelector(\"#search-bar-content-container > collection-search-input\").shadowRoot.querySelector(\"#button-collapser > ul > li:nth-child(3) > label > input[type=radio]\")");
        filterButton.click();
        searchInput.sendKeys("itmo\n");
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        WebElement additionalFilterButton = (WebElement) jsExecutor.executeScript("return document.querySelector(\"#maincontent > div.container.container-ia.nopad > div > div.columns-facets > div > div:nth-child(8) > div > div.fatable.facet-creator > label:nth-child(1) > a > div:nth-child(1) > input\")");
        additionalFilterButton.click();
        WebElement foundResource = (WebElement) jsExecutor.executeScript("return document.querySelector(\"#ikind-search > div > div:nth-child(2) > div.C234 > div.item-ttl.C.C2 > a > div.tile-img > img\")");
        assertEquals(foundResource.getAttribute("src"), "https://archive.org/download/RUSSIA24_20230307_083000_RIK_Rossiya_24/RUSSIA24_20230307_083000_RIK_Rossiya_24.thumbs/RUSSIA24_20230307_083000_RIK_Rossiya_24_001528.jpg");
    }
}
