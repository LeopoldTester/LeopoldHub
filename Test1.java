package org.example;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.util.concurrent.TimeUnit;

public class Test1 {

    static FirefoxDriver driver;

    @BeforeClass
    public static void setup() {
        System.setProperty("webdriver.gecko.driver", "C:/Users/grant161119/IdeaProjects/geckodriver/geckodriver-v0.27.0-win64/geckodriver.exe");
        System.setProperty("webdriver.firefox.bin", "C:/Users/grant161119/AppData/Local/Mozilla Firefox/firefox.exe");
        driver  = new FirefoxDriver();
        driver.get("https://wstest.grant.ua/build/#/");
        driver.manage().window().setSize(new Dimension(1936, 1056));
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    @Test
    public void Test1() {

        WebElement elementListDb = driver.findElement(By.xpath("//div[@id='db-select']"));
        elementListDb.click();
        WebElement elementChoiceDb = driver.findElement(By.xpath("//li[contains(.,'titan.climber')]"));
        elementChoiceDb.click();
        WebElement elementListSms = driver.findElement(By.xpath("//div[@id='usecode-select']"));
        elementListSms.click();
        WebElement elementChoiсeLogin = driver.findElement(By.xpath("//li[contains(.,'Вход по логину (тест)')]"));
        elementChoiсeLogin.click();
        WebElement loginField = driver.findElement(By.id("login"));
        loginField.sendKeys("Кбмедид");
        WebElement passField = driver.findElement(By.id("password"));
        passField.sendKeys("123QWEasd");
        WebElement entryButton = driver.findElement(By.id("nextStepButton"));
        entryButton.click();
        WebDriverWait waitSms = new WebDriverWait(driver, 10);
        waitSms.until(ExpectedConditions.presenceOfElementLocated(By.id("smsCode")));
        WebElement smsField = driver.findElement(By.name("smsCode"));
        smsField.sendKeys("Кбмедид");
        WebElement smsEntryButton = driver.findElement(By.id("nextStepButton"));
        smsEntryButton.click();
        boolean  name =  driver.findElement(By.xpath("//h6[contains(.,'Валентин Павлович КБМЕДИД-Поборцев')]")).isDisplayed();
        WebElement exitButton = driver.findElement(By.xpath("/html/body/div[1]/div/header/div/div/div[4]/div/button[5]"));
        exitButton.click();
        WebElement exit = driver.findElement(By.xpath("//li[contains(.,'Выход')]"));
        exit.click();
        boolean enterText = driver.findElement(By.xpath("//h1[contains(.,'Вход в систему')]")).isDisplayed();


    }
   @AfterClass
    public static void clean() {
       driver.close();
    }

}

