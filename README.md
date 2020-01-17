
Selenium Amazon.com Example with Java

*****


Test Environment Information:
--


IDE : IntelliJ IDEA 2019.1
JRE: 1.8.0_202
Language : Java 
Selenium Web Driver : 3.141.59
Junit version : 4.13
Log4J version: 2.10.0
OS : macOS 10.13.6
Browser : Chrome 79.0.3945.88
Chrome Driver version : 79.0.3945.16

---




Configuraions:
----

 —- For TestNG Test:



1) You can add your amazon.com username and password in JunitTestcases.java. code is below.

        Login.enterEmail(driver).sendKeys("");
        Login.enterPassword(driver).sendKeys("********");

3) Run JunitTestcases.java . Test cases will start running.

—- For TestNG Test:

1) Edit the chrome driver in path in TestNG_Tesrcases.java. Code is below:
System.setProperty("webdriver.chrome.driver", “/Users/furkanleventoturaklioglu/Documents/Automation/Amazon/src/Drivers/chromedriver");

2) You can add your amazon.com username and password in TestNG_Tesrcases.java. code is below.

Login.enterEmail(driver).sendKeys("testuser.2019az@gmail.com");
Login.contiuneBtn(driver).click();
Login.enterPassword(driver).sendKeys(“testuser.2019");


3) Run TestNG_Tesrcases.java . Test cases will start running.

---



Test Scenarios:
--

