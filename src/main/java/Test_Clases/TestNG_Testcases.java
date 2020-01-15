package Test_Clases;

import Functions.Utility;
import Functions.waitForPageLoad;
import Pages.*;
import org.apache.tools.ant.util.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.*;
import java.io.File;
import java.util.List;

import java.util.concurrent.TimeUnit;
import org.testng.ITestResult;
import java.io.File;


public class TestNG_Testcases {

    WebDriver driver;
    String baseURL;
    static public String selectedFavoriteProduct;
    static int wishListCount=0;
    static int willDeleteWishListCount=0;

    //WebDriverWait wait= new WebDriverWait(driver, 1000);

    @BeforeTest
    @Parameters("browser")
    public void setup(String browser) throws Exception{
        //Check if parameter passed from TestNG is 'chrome'
        if(browser.equalsIgnoreCase("chrome")){
            //create chrome instance
            System.setProperty("webdriver.chrome.driver", "src/Drivers/chromedriver");
            driver=new ChromeDriver();
        }
        else if(browser.equalsIgnoreCase("firefox")){
            //set path to firefox
            System.setProperty("webdriver.gecko.driver", "src/Drivers/geckodriver");
            //create chrome instance
            driver = new FirefoxDriver();
        }
        else{
            //If no browser passed throw exception
            throw new Exception("Browser is not correct");
        }

        baseURL= "https://www.hepsiburada.com/hesabim/bize-sorun";
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().window().maximize();
    }


    //1.  https://www.hepsiburada.com/uyelik/hesabim/bize-sorun sitesine gelecek ve anasayfanin acildigini onaylayacak,
    @Test
    public void testCase_001(){
        driver.get(baseURL);
        new waitForPageLoad();
        Assert.assertTrue(driver.getTitle().equals("Üye Giriş Sayfası – Hepsiburada.com"));
        System.out.println("Web Sitesi Açıldı");
        Utility.captureScreenshot(driver,"page error");

        System.out.println("Sayfa kullanıcı girişi için hazır ...");
        Login.enterEmail(driver).sendKeys("furkanleventoturaklioglu@gmail.com");
        //Login.signinBtn(driver).click();// Login.enterEmail(driver).sendKeys("testuser.2019az@gmail.com");
        Login.enterPassword(driver).sendKeys("120502031");
        // Login.enterPassword(driver).sendKeys("test.2020");
        Login.signinBtn(driver).click();
        new waitForPageLoad();
        //Assert.assertTrue(!findByClassName("username").getText().equals(""));
        System.out.println("Kullanıcı Girişi Başarılı ...");
       // Assert.assertTrue(driver.getTitle().equals("Üye Giriş Sayfası – Hepsiburada.com"));
        Utility.captureScreenshot(driver,"Logiin error");

        bizeUlasinPage.siparis(driver);
        bizeUlasinPage.selectedLine(driver);
        bizeUlasinPage.msgCategory(driver);
        bizeUlasinPage.msgGrrp(driver);
        bizeUlasinPage.msgFaq(driver);
        bizeUlasinPage.productCatefory(driver);
        bizeUlasinPage.question(driver).click();
        Utility.captureScreenshot(driver,"select error");

    }

/*
    //2. Login ekranini acip, bir kullanici ile login olacak
    @Test
    public void testCase_002(){



    }


    //3. Ekranin ustundeki Search alanina 'samsung' yazip Ara butonuna tiklayacak,
    @Test
    public void testCase_003(){
*/



    @AfterClass
    public void quit(){
        driver.close();

    }


}
