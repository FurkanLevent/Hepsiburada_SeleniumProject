Selenium Amazon.com Example with Java
----


Test Environment Information:
--


IDE : IntelliJ IDEA 2019.1
JRE: 1.8.0_202
Language : Java 
Selenium Web Driver : 3.141.59
Junit version : 4.13
TestNG version: 6.14.3
Log4J version: 2.10.0
OS : macOS 10.13.6
Browser : Chrome 79.0.3945.88
Chrome Driver version : 79.0.3945.16




Configuraions:
--

 —- For JUnit Test:

1) Edit the chrome driver in path in JunitTestcases.java. Code is below:

System.setProperty("webdriver.chrome.driver", “/Users/furkanleventoturaklioglu/Documents/Automation/Amazon/src/Drivers/chromedriver");

2) You can add your amazon.com username and password in JunitTestcases.java. code is below.

Login.enterEmail(driver).sendKeys("testuser.2019az@gmail.com");
Login.contiuneBtn(driver).click();
Login.enterPassword(driver).sendKeys(“testuser.2019");

3) Run JunitTestcases.java . Test cases will start running.

—- For TestNG Test:

1) Edit the chrome driver in path in TestNG_Tesrcases.java. Code is below:
System.setProperty("webdriver.chrome.driver", “/Users/furkanleventoturaklioglu/Documents/Automation/Amazon/src/Drivers/chromedriver");

2) You can add your amazon.com username and password in TestNG_Tesrcases.java. code is below.

Login.enterEmail(driver).sendKeys("testuser.2019az@gmail.com");
Login.contiuneBtn(driver).click();
Login.enterPassword(driver).sendKeys(“testuser.2019");


3) Run TestNG_Tesrcases.java . Test cases will start running.



Test Scenarios:
---
1) Open http://www.amazon.com site and confirm that the homepage is open,
2) Open the login screen and log in with a user (if it is already a member of the site)
3) Type 'samsung' in the Search field at the top of the screen and click the Search button,
4) Confirm that the result page has the result for samsung,
5) Click on page 2 of the search results and confirm that page 2 is currently displayed on the urgent page,
6) Click the 'Add to List' button in the 3rd product,
7) Click on the 'List' link at the top of the screen and select the Wish list,
8) To confirm the presence of the product in the Urgent page on the previous page,
9) By pressing the 'Delete' button next to this favorite product, it will be removed from my favorites,
10) On page it will confirm that this product is no longer bookmarked.
 
