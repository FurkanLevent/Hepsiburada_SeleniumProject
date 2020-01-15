package Pages;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class bizeUlasinPage {

    static WebElement element;


    public static WebElement siparis (WebDriver driver) {
        Select oSelect = new Select(driver.findElement(By.name("selectedOrder")));
        oSelect.selectByValue("63824023");
      //  oSelect.selectByIndex(2);

        return element;
    }


    public static WebElement selectedLine (WebDriver driver) {
        Select oSelect = new Select(driver.findElement(By.name("selectedLine")));
        oSelect.selectByValue("2");
    //    oSelect.selectByIndex(2);

        return element;
    }

    public static WebElement msgCategory (WebDriver driver) {
        Select oSelect = new Select(driver.findElement(By.name("selectedFaqCategory")));
        oSelect.selectByValue("18");
        return element;
    }


    public static WebElement msgGrrp (WebDriver driver) {
        Select oSelect = new Select(driver.findElement(By.name("selectedFaqGroup")));
        oSelect.selectByValue("67");
        return element;
    }


    public static WebElement msgFaq (WebDriver driver) {
        Select oSelect = new Select(driver.findElement(By.name("selectedFaq")));
        oSelect.selectByValue("189");
        return element;
    }


    public static WebElement productCatefory (WebDriver driver) {
        Select oSelect = new Select(driver.findElement(By.name("productCategoryId")));
        oSelect.selectByValue("6802");
        return element;
    }

    public static WebElement question (WebDriver driver) {
        element = driver.findElement(By.xpath("//*[@id=\"inner-content\"]/div/div/div[3]/div/p[2]/a[2]"));

        return element;
    }




}
