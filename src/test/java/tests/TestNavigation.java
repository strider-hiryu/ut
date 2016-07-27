package tests;


/**
 * Created by pinkkirby on 7/26/2016.
 */

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Test;
import pageobjects.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import tests.Config;
import org.junit.Assert;

public class TestNavigation {

    private static WebDriver driver = null;
    private static Config config;

    public TestNavigation(){
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\pinkkirby\\Documents\\GitHub\\ut\\chromedriver.exe");
        driver = new ChromeDriver();
        config = new Config();
    }

    @After
    public void closeBrowser(){
        driver.quit();
    }

    @Test
    public void testMavigation_ApproachPage_by_menu() {
        System.out.println("Starting test " + new Object(){}.getClass().getEnclosingMethod().getName());
        driver.get(config.baseUrl + HomePage.url);
        HomePage.titleBar_link_approach(driver).click();
        //Validate we land on appraoch page after page load
        ApproachPage.waitForLoad(driver);
        Assert.assertEquals(config.baseUrl + ApproachPage.url, driver.getCurrentUrl());
    }

    @Test
    public void testMavigation_HomePage_by_logo() {
        System.out.println("Starting test " + new Object(){}.getClass().getEnclosingMethod().getName());
        driver.get(config.baseUrl + ApproachPage.url);
        ApproachPage.titleBar_logo(driver).click();
        //Validate we land on appraoch page after page load
        ApproachPage.waitForLoad(driver);
        Assert.assertEquals(config.baseUrl + HomePage.url, driver.getCurrentUrl());
    }
}
