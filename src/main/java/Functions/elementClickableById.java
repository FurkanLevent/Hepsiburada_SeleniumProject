package Functions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class elementClickableById {

    public static ExpectedCondition<WebElement> elementClickableById(String name){
        ExpectedCondition<WebElement> clickable= ExpectedConditions.elementToBeClickable((By.id(name)));
        return clickable;
    }
}
