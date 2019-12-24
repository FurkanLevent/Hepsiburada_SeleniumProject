package Test_Clases;

import Functions.waitForPageLoad;
import Pages.HomePage;
import Pages.Login;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.*;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class TestNG_Testcases {

    static public WebDriver driver;
    static public String baseURL;
    static public String selectedFavoriteProduct;
    static int wishListCount=0;
    static int willDeleteWishListCount=0;


    //WebDriverWait wait= new WebDriverWait(driver, 1000);

    @BeforeTest
    public static void setup(){

        System.setProperty("webdriver.chrome.driver", "/Users/furkanleventoturaklioglu/Documents/Automation/Amazon/src/Drivers/chromedriver");
        driver=new ChromeDriver();
        baseURL= "https://www.amazon.com";
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().window().maximize();
    }


    //1.  http://www.amazon.com sitesine gelecek ve anasayfanin acildigini onaylayacak,
    @Test
    public void testCase_001(){
        driver.get(baseURL);
        new waitForPageLoad();
        Assert.assertTrue(driver.getTitle().equals("Amazon.com: Online Shopping for Electronics, Apparel, Computers, Books, DVDs & more"));
        System.out.println("Web Sitesi Açıldı");
    }


    //2. Login ekranini acip, bir kullanici ile login olacak
    @Test
    public void testCase_002(){
        HomePage.LoginClick(driver).click();
        // wait.until(elementClickableById.elementClickableById("contiune"));
        //Assert.assertTrue(findById("continue").getText().equals("Sign-In"));
        System.out.println("Sayfa kullanıcı girişi için hazır ...");
        Login.enterEmail(driver).sendKeys("testuser.2019az@gmail.com");
        Login.contiuneBtn(driver).click();
        Login.enterPassword(driver).sendKeys("testuser.2019");
        Login.signinBtn(driver).click();
        new waitForPageLoad();
        //Assert.assertTrue(!findByClassName("username").getText().equals(""));
        System.out.println("Kullanıcı Girişi Başarılı ...");
    }


    //3. Ekranin ustundeki Search alanina 'samsung' yazip Ara butonuna tiklayacak,
    @Test
    public void testCase_003(){
        // wait.until(elementClickableById.elementClickableById("twotabsearchtextbox"));
        HomePage.searchTxtBox(driver).sendKeys("samsung");
        HomePage.searchBtn(driver).click();
        System.out.println("Samsung için sonuç bulundu");
    }


    //4. Gelen sayfada samsung icin sonuc bulundugunu onaylayacak,
    @Test
    public void testCase_004(){
        //wait.until(elementClickableByClassName("a-section a-spacing-small a-spacing-top-small"));
        String resultOk=Pages.SearchPage.searchResult(driver).getText();
        Assert.assertTrue(resultOk.contains("results for "));
        System.out.println("Samsung sonucu verify edildi.");

    }


    //5. Arama sonuclarindan 2. sayfaya tiklayacak ve acilan sayfada 2. sayfanin su an gosterimde oldugunu onaylayacak,
    @Test
    public void testCase_005(){
        Pages.SearchPage.nextPage(driver).click();
        new waitForPageLoad();
        Assert.assertTrue(driver.getPageSource().contains("2"));
        System.out.println("2. Sayfa Gösterimde ...");
    }


    //6. Ustten 3. urunun icindeki 'Add to List' butonuna tiklayacak,
    @Test
    public void testCase_006(){
        //Listede 3. Ürün Oluşana Kadar Bekle
        selectedFavoriteProduct=Pages.SearchPage.getElementTextBy(driver);
        Pages.SearchPage.thirdProduct(driver).click();
        Pages.SearchPage.wishListBtn(driver).click();
        System.out.println("Favoriye Eklenen Ürün Adı : "+selectedFavoriteProduct);
    }


    //7. Ekranin en ustundeki 'List' linkine tiklayacak içerisinden Wish listi seçecek,
    @Test
    public void testCase_007(){
        //JavascriptExecutor js = (JavascriptExecutor)driver;
        //js.executeScript("arguments[1].click();", driver.findElement(By.cssSelector("css=a.nav-link.nav-item > span.nav-text")));

        Pages.SearchPage.wishList(driver).click();

        new waitForPageLoad();
    }


    //8. Acilan sayfada bir onceki sayfada izlemeye alinmis urunun bulundugunu onaylayacak,
    @Test
    public void testCase_008(){
        List<WebElement> productTitles=Pages.WishList.wishList(driver);
        for (WebElement productTitle : productTitles) {
            wishListCount+=1;
            String watchesProduct=productTitle.getText();
            if (watchesProduct.equals(selectedFavoriteProduct)) {
                System.out.println("Favoriye Eklenen Ürün Onaylandı.Ürünün Başlığı :"+watchesProduct+"\n");
                willDeleteWishListCount=wishListCount;
                Assert.assertTrue(watchesProduct.equals(selectedFavoriteProduct));
            }
        }
    }


    //9. Favorilere alinan bu urunun yanindaki 'Delete' butonuna basarak, favorilerimden cikaracak,
    @Test
    public void testCase_009(){
        Pages.WishList.deleteBtn(driver).click();
        new waitForPageLoad();
    }


    //10. Sayfada bu urunun artik favorilere alinmadigini onaylayacak.
    @Test
    public void testCase_010(){
        boolean isThereProduct=false;
        List<WebElement> productTitles= Pages.WishList.wishList2(driver);
        for (WebElement productTitle : productTitles) {
            String watchesProduct=productTitle.getText();
            if (watchesProduct.equals(selectedFavoriteProduct)) {
                isThereProduct=true;
            }
        }

        Assert.assertFalse(isThereProduct);
        System.out.println("Favorilerim Sayfasında "+selectedFavoriteProduct+" isimli ürün artık bulunmuyor ...");
    }


    @AfterClass
    public static void tearDown(){
        driver.close();

    }


}
