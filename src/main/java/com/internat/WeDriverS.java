package com.internat;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class WeDriverS {
    public static void main(String[] args){
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        WebDriverWait webwait = new WebDriverWait(driver, Duration.ofSeconds(10));
        driver.get("https://www.amazon.fr/");
        if (isElementPresent(driver,By.id("sp-cc-rejectall-link"))){
            WebElement RejectCookie_btn = driver.findElement(By.id("sp-cc-rejectall-link"));
            RejectCookie_btn.click();
        }

        WebElement searchField = driver.findElement(By.id("twotabsearchtextbox"));
        searchField.sendKeys("iphone");
        searchField.sendKeys(Keys.ENTER);
        List<WebElement> AllResult = webwait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.cssSelector("a[class='a-link-normal s-no-outline']")));
        WebElement firstResult = AllResult.get(0);
        firstResult.click();
        WebElement quantity_select = driver.findElement(By.id("quantity"));
        Select quantity_selector = new Select(quantity_select);
        quantity_selector.selectByVisibleText("2");
        WebElement outertable = driver.findElement(By.cssSelector("table[class='a-normal a-spacing-micro'] tbody"));
        WebElement marque_apple = outertable.findElements(By.tagName("tr")).get(2);
        if (marque_apple.getText().contains("Apple")){
            System.out.println("good product");
        }else {
            System.out.println(marque_apple.getText());
        }




        driver.close();

    }
    static boolean isElementPresent(WebDriver driver, By by){
        try {
            driver.findElement(by);
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}
