package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class HomePage {


    static WebElement element;
    //static WebDriver driver;



    public static WebElement LoginClick(WebDriver driver) {
        element = driver.findElement(By.xpath("//a[@id='nav-link-accountList']/span[2]"));
        return element;
    }

    public static WebElement searchTxtBox(WebDriver driver) {
        element = driver.findElement(By.id("twotabsearchtextbox"));
        return element;
    }


    public static WebElement searchBtn(WebDriver driver) {
        element = driver.findElement(By.className("nav-input"));
        return element;
    }
}
