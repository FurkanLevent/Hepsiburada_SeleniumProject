package Test_Clases;

import Functions.*;
import Functions.Utility;
import Functions.waitForPageLoad;
import Pages.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.*;
import java.io.File;
import java.util.List;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

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


    /*   Testacase:001
    https://www.hepsiburada.com/uyelik/hesabim/bize-sorun açılır ve sayfanın title'ni onaylar.
    Hata var ise screenshoot'unu alır.
     */

    @Test
    public void testCase_001() throws Exception{
        try{
        driver.get(baseURL);
        new waitForPageLoad();
        Assert.assertTrue(driver.getTitle().equals("Üye Giriş Sayfası – Hepsiburada.com"));
        System.out.println("Web Sitesi Açıldı");
        //Utility.captureScreenshot(driver,"page error");
        System.out.println("Sayfa kullanıcı girişi için hazır ...");


        }catch(Exception e){
            File screenshotFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
            FileUtils.copyFile(screenshotFile, new File("Screenshots/Testcase001.png"));
        }

    }


    /*   Testacase:002
    Login sayfasıneq username ve password girilir, sigin butonuna tıklanır.
    Sayfanın title'ni onaylanır
    Hata var ise screenshoot'unu alır.
     */

    @Test
    public void testCase_002()throws Exception{
        try{
        Login.enterEmail(driver).sendKeys("furkanleventoturaklioglu@gmail.com");
        Login.enterPassword(driver).sendKeys("120502031");
        Login.signinBtn(driver).click();
        new waitForPageLoad();
        System.out.println("Kullanıcı Girişi Başarılı ...");
       // Assert.assertTrue(driver.getTitle().equals("Bize Sorun"));
        //Utility.captureScreenshot(driver,"Logiin error");


    }catch(Exception e){
        File screenshotFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(screenshotFile, new File("Screenshots/Testcase002.png"));
    }

}

    /*   Testacase:003
    Bize ulasın sayfasındaki parametreler aşağıdaki şekilde doldurulur.
    -> Sipariş seçilir, sipariş kalemi seçilir.
    -> Ürün Bilgisi
    -> Ü̈rün Özellikleri
    -> Ürün Özellikleriyle ilgili ek bilgi nasıl edinebilirim?
    -> Bilgisayar
    -> Bu size yardımcı oldu mu sorusuna Hayır cevabı verilir.
     */


    @Test
    public void testCase_003() throws Exception{
        try{
        bizeUlasinPage.selectOrder(driver);
        bizeUlasinPage.selectOrderLine(driver);
        bizeUlasinPage.msgCategory(driver);
        bizeUlasinPage.msgGrrp(driver);
        bizeUlasinPage.msgFaq(driver);
        bizeUlasinPage.productCatefory(driver);
        bizeUlasinPage.question(driver).click();
        //Utility.captureScreenshot(driver,"select error");


        }catch(Exception e){
            File screenshotFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
            FileUtils.copyFile(screenshotFile, new File("Screenshots/Testcase003.png"));
        }
    }


    @AfterClass
    public void quit(){
        driver.close();

    }


}
