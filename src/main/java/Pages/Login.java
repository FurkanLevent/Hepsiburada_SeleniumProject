package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class Login {

    static WebElement element;



    public static WebElement enterEmail(WebDriver driver) {
        element = driver.findElement(By.id("email"));
        return element;
    }


    public static WebElement enterPassword(WebDriver driver) {
        element = driver.findElement(By.id("password"));
        return element;
    }

    public static WebElement signinBtn(WebDriver driver) {
        element = driver.findElement(By.className("form-actions"));
        return element;
    }





}
