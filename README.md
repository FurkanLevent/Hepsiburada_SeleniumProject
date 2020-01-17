
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
ChromeBrowser : Chrome 79.0.3945.88
FF Browser : Firefox 72.0.
Chrome Driver version : 79.0.3945.16
Firefox Driver Version: Firefox 72.0.1

---




Configuraions:
----

 —- For TestNG Test:



1) You can add your amazon.com username and password in JunitTestcases.java. code is below.

        Login.enterEmail(driver).sendKeys("");
        Login.enterPassword(driver).sendKeys("********");

2) Run JunitTestcases.java . Test cases will start running.



---



Test Scenarios:
--

