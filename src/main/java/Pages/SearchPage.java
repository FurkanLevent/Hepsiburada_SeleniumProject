package Pages;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class SearchPage {

    static WebElement element;


    public static WebElement searchResult(WebDriver driver) {
        element = driver.findElement(By.xpath("//*[@id=\"search\"]/span[2]/h1/div/div[1]/div/div"));
        return element;
    }

    public static WebElement nextPage(WebDriver driver) {
        element = driver.findElement(By.xpath("//*[@id=\"search\"]/div[1]/div[2]/div/span[8]/div/span/div/div/ul/li[3]/a"));
        return element;
    }


    public static WebElement thirdProduct(WebDriver driver) {
        element = driver.findElement(By.xpath("//div[@id='search']/div/div[2]/div/span[4]/div/div[4]/div/span/div/div/div[2]/div[2]/div/div/div/div/div/h2/a/span"));
        return element;
    }

    public static WebElement wishListBtn(WebDriver driver) {
        element = driver.findElement(By.id("add-to-wishlist-button-submit"));
        return element;

    }

    public static WebElement wishList(WebDriver driver) {
        element = driver.findElement(By.xpath("//*[@id=\"WLHUC_viewlist\"]/span"));
        return element;
    }

    public static String getElementTextBy(WebDriver driver){
        return driver.findElement(By.xpath("//*[@id=\"search\"]/div[1]/div[2]/div/span[4]/div[1]/div[4]/div/span/div/div/div[2]/div[2]/div/div[1]/div/div/div[1]/h2/a/span")).getText();
    }

}
