package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class WishList {

    static WebElement element;

    public static List<WebElement>  wishList(WebDriver driver) {
        List<WebElement> element=driver.findElements(By.xpath("//*[@id=\"itemName_I3UY3KS74XWIAA\"]"));
        return element;
    }

    public static WebElement deleteBtn(WebDriver driver) {
        element = driver.findElement(By.xpath("//*[@id=\"a-autoid-7\"]/span/input"));
        return element;
    }


    public static List<WebElement>  wishList2(WebDriver driver) {
        List<WebElement> element=driver.findElements(By.xpath("//*[@class='productTitle']/p/a"));
        return element;
    }


}
