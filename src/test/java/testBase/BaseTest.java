package testBase;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.opencsv.CSVReader;
import com.opencsv.CSVWriter;
import com.opencsv.exceptions.CsvException;
import com.opencsv.exceptions.CsvValidationException;
import objectRepo.propertyObjects;
import org.apache.commons.configuration2.*;
import org.apache.commons.configuration2.builder.FileBasedConfigurationBuilder;
import org.apache.commons.configuration2.ex.ConfigurationException;
import org.apache.commons.io.FileUtils;
import org.apache.commons.io.FilenameUtils;
import org.json.simple.parser.JSONParser;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.tracing.opentelemetry.SeleniumSpanExporter;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.*;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import javax.swing.*;
import java.awt.*;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.io.*;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.*;
import java.util.List;


public class BaseTest extends propertyObjects {

    //***************************************Declaration of variables***************************************
    public static ExtentReports extent;
    public static ExtentTest test;
    public static ExtentSparkReporter es;

    public Field variableValue;
    public static ITestContext context;
    public WebDriver driver;
    public Properties mainExecProp;
    public Properties suppExecProp;
    public SoftAssert softAssert;
    public String screenshotFolderPath = System.getProperty("user.dir") + "\\screenShots";
    public String xpath = "xpath";
    public String id = "id";
    public String name = "name";
    public String css = "css";
    public CompositeConfiguration config1;
    public String orExecPropPath = System.getProperty("user.dir") + "\\src\\test\\propFiles\\objectRepo.properties";
    public String exceptionVal = "n";
    public String objectRepoPropPath = System.getProperty("user.dir") + "\\src\\test\\propFiles\\objectRepo.properties";
    public String propFilesFolderPath = System.getProperty("user.dir") + "\\src\\test\\propFiles\\";
    public String methodNameValue = "";

    //***************************************Declaration of variables End***************************************

    //***************************************Annotations for tests***************************************
    @BeforeTest
    public void initializeTheTestAndLogin() throws IOException, ConfigurationException {
        // String region = commonMethods.readProperty("regionVal").toUpperCase();
        String testNameVal = this.getClass().getName();
        String timeStamp = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new java.util.Date());
        // String reportPath = System.getProperty("user.dir")+"\\reports\\APIAutomation_report_"+region+"_"+timeStamp+".html";
        String reportPath = System.getProperty("user.dir") + "\\reports\\PortalAutomation_" + testNameVal + "_" + timeStamp + ".html";
        es = new ExtentSparkReporter(reportPath);
        extent = new ExtentReports();
        extent.attachReporter(es);
        test = extent.createTest("loginValidation");
        setApplPropFilePath("objectRepo.properties");
        // mainExecProp=loadProperties(propFilesPath+"\\mainExecPropFile.properties");
        // suppExecProp=loadProperties(propFilesPath+"\\suppExecPropFile.properties");
        String browser = getPropertyVal("browserVal");
        String urlVal = getPropertyVal(getPropertyVal("env") + getPropertyVal("role").toLowerCase() + "URL");
        String userIDVal = getPropertyVal(getPropertyVal("env") + getPropertyVal("region") + getPropertyVal("role").toLowerCase());
        String pwdVal = getPropertyVal(getPropertyVal("env") + getPropertyVal("region") + getPropertyVal("role").toLowerCase() + "pwd");
        openBrowserAndLogin(browser, urlVal, userIDVal, pwdVal);
        setExceptionValToY();


    }

    @BeforeMethod
    public void beforeMethodTierup(ITestContext context, Method methodName) throws ConfigurationException {
        methodNameValue = methodName.getName();
        test = extent.createTest(methodNameValue);
        this.context = context;
        context.setAttribute("test", test);
        setApplPropFilePath("objectRepo.properties");

    }

    @AfterTest
    public void logoutandFlushReports() {
        driver.quit();
        extent.flush();

    }
    //***************************************Annotations for test end ***************************************

    //*******************************************************************************************************
    public String returnLocalizationPath(String fileNameVal) {
        String filePathVal = System.getProperty("user.dir") + "\\src\\test\\localizationInputFiles\\" + fileNameVal;
        return filePathVal;
    }

    public void log(String msg) {
        System.out.println(msg);
        test.log(Status.INFO, msg);
    }

    public void logPass(String msg) {
        System.out.println("Pass: " + msg);
        test.log(Status.PASS, msg);
    }

    public void logFail(String msg) {
        try {
            System.out.println(msg);
            Date d = new Date();
            String screenshotFile = d.toString().replace(":", "_").replace(" ", "_") + ".png";
            File srcFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
            String screenShotPath = screenshotFolderPath + "//" + screenshotFile;
            FileUtils.copyFile(srcFile, new File(screenshotFolderPath + "//" + screenshotFile));
            test.fail(msg, MediaEntityBuilder.createScreenCaptureFromPath(screenShotPath).build());// failure in extent reports


        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void logFailWithOutScreenshot(String msg) {
        try {
            System.out.println(msg);
            test.fail(msg);// failure in extent reports
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void deleteALLFilesInDownload() throws IOException {
        File filePath = new File(System.getProperty("user.dir") + "\\download");
        FileUtils.cleanDirectory(filePath);
    }

    public void takeScreenShot() {
        // fileName of the screenshot
        Date d = new Date();
        String screenshotFile = d.toString().replace(":", "_").replace(" ", "_") + ".png";
        // take screenshot
        File srcFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        try {
            // get the dynamic folder name
            String screenShotPath = screenshotFolderPath + "//" + screenshotFile;
            FileUtils.copyFile(srcFile, new File(screenshotFolderPath + "//" + screenshotFile));
            //put screenshot file in reports
            //test.log(Status.INFO,"Screenshot-> "+ test.addScreenCaptureFromPath(screenshotFolderPath+"//"+screenshotFile));
            test.info(MediaEntityBuilder.createScreenCaptureFromPath(screenShotPath).build());
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }
    //********************************************************************************************************

    //*******************************************************************************************************
    public void openBrowserAndLogin(String browser, String urlVal, String userNameVal, String passWordVal) throws ConfigurationException {
        if (browser.equalsIgnoreCase("chrome")) {
            try {
                HashMap<String, Object> chromePrefs = new HashMap<String, Object>();
                chromePrefs.put("profile.default_content_settings.popups", 0);
                chromePrefs.put("download.default_directory", System.getProperty("user.dir") + "\\download\\");
                WebDriverManager.chromedriver().setup();
                ChromeOptions options = new ChromeOptions();
                options.setExperimentalOption("prefs", chromePrefs);
                options.addArguments("--no-sandbox");
                options.addArguments("--disable-dev-shm-usage");
                options.addArguments("--disable-gpu");
                options.addArguments("--allow-insecure-localhost");
                options.addArguments("--remote-allow-origins=*");
                System.out.println("Opening the browser");
                driver = new ChromeDriver(options);
                Duration duration = Duration.ofSeconds(20);
                driver.manage().timeouts().implicitlyWait(duration);
                navigateToUrl(driver, urlVal);

                type("loginuserid_id", userNameVal);
                click("loginnext_id");
                if (getElements(otpSessionCode_xpath).size() == 4) {
                    click(otpResend_xpath);
                    wait(5);
                    type(otp1stchar_xpath, "1");
                    type(otp2ndchar_xpath, "1");
                    type(otp3rdchar_xpath, "1");
                    type(otp4thchar_xpath, "1");
                    jsclick(loginnext_xpath);

                }
                driver.findElement(By.id(getPropertyVal("loginpwd_id"))).sendKeys(passWordVal);
                wait(1);
                click("loginnext_id");
                if (isElementPresent("logout_xpath")) {
                    logPass("Application got logged in.");
                } else {
                    logFail("Application did NOT get logged in.");

                }
            } catch (Exception ignored) {
                System.out.println("Could not able to navigate to the URL : " + urlVal);

            }
            wait(200);
            selectLocale("English");

        } else if (browser.equalsIgnoreCase("firefox")) {
            try {
                HashMap<String, Object> chromePrefs = new HashMap<String, Object>();
                FirefoxOptions options = new FirefoxOptions()
                        .addPreference("browser.download.dir", System.getProperty("user.dir") + "\\download\\");
                options.setBinary("C:\\Users\\2424975\\AppData\\Local\\Mozilla Firefox\\firefox.exe");


                // chromePrefs.put("profile.default_content_settings.popups", 0);
            /*    chromePrefs.put("download.default_directory", System.getProperty("user.dir")+"\\download\\");
                WebDriverManager.chromedriver().setup();
                ChromeOptions options = new ChromeOptions();
                options.setExperimentalOption("prefs", chromePrefs);
                options.addArguments("--no-sandbox");
                options.addArguments("--disable-dev-shm-usage");
                options.addArguments("--disable-gpu");
                options.addArguments("--allow-insecure-localhost");*/
                System.out.println("Opening the browser");
                WebDriverManager.firefoxdriver().avoidBrowserDetection().setup();
                driver = new FirefoxDriver(options);
                Duration duration = Duration.ofSeconds(20);
                driver.manage().timeouts().implicitlyWait(duration);
                navigateToUrl(driver, urlVal);

                type("loginuserid_id", userNameVal);
                click("loginnext_id");
                driver.findElement(By.id(getPropertyVal("loginpwd_id"))).sendKeys(passWordVal);
                wait(1);
                click("loginnext_id");
                if (isElementPresent("logout_xpath")) {
                    logPass("Application got logged in.");
                } else {
                    logFail("Application did NOT get logged in.");

                }
            } catch (Exception ignored) {
                System.out.println("Could not able to navigate to the URL : " + urlVal);

            }
            wait(200);
            selectLocale("English");

        }


    }
    //********************************************************************************************************

    //*******************************************************************************************************
    public Properties loadProperties(String pathVal) throws IOException {
        Properties prop = new Properties();
        FileInputStream fs = new FileInputStream(pathVal);
        prop.load(fs);
        return prop;
    }
    //*******************************************************************************************************


    //*********************************Getting the locator Key instance ************************************
    public By getLocator(String locatorKey) throws ConfigurationException {
        By by = null;

        if (locatorKey.toLowerCase().contains("_id"))
            by = By.id(getPropertyVal(locatorKey));
        else if (locatorKey.toLowerCase().contains("_xpath"))
            by = By.xpath(getPropertyVal(locatorKey));
        else if (locatorKey.toLowerCase().contains("_css"))
            by = By.cssSelector(getPropertyVal(locatorKey));
        else if (locatorKey.toLowerCase().contains("_name"))
            by = By.name(getPropertyVal(locatorKey));
        else
            logFail("Identifier mechanism i.e. xpath or id or css....etc is not provided in the element name. Pls check");

        System.out.println(locatorKey + " : " + getPropertyVal(locatorKey));
        wait(100);
        return by;
    }
//************************************************************************************************************************************

    //************************************************************************************************************************************
    public boolean isElementPresent(String locatorKey) {

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        try {
            wait.until(ExpectedConditions.presenceOfElementLocated(getLocator(locatorKey)));

        } catch (Exception e) {
            return false;
        }
        return true;
    }
//************************************************************************************************************************************

    //************************************************************************************************************************************
    public boolean isElementVisible(String locatorKey) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(getLocator(locatorKey)));
        } catch (Exception e) {
            return false;
        }
        return true;
    }
//************************************************************************************************************************************

    //************************************************************************************************************************************
    public WebElement getElement(String locatorKey) throws ConfigurationException {
        //  check the presence
        String logicalName = locatorKey.split("_")[0];
        if (isElementPresent(locatorKey)) {
            if (isElementVisible(locatorKey)) {
            } else {
                // report failure
                logFail(logicalName + "Element is not visible ");
            }

        } else {
            // report failure
            logFail(logicalName + "Element is not present ");
        }
        //  check the visibility


        WebElement e = driver.findElement(getLocator(locatorKey));

        return e;
    }


    public List<WebElement> getElements(String locatorKey) throws ConfigurationException {
        //  check the presence
        String logicalName = locatorKey.split("_")[0];

        List<WebElement> e = driver.findElements(getLocator(locatorKey));

        return e;
    }
//************************************************************************************************************************************

    //************************************************************************************************************************************
    public void waitForPageToLoad() {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        int i = 0;
        // ajax status
        while (i != 10) {
            String state = (String) js.executeScript("return document.readyState;");
            System.out.println(state);

            if (state.equals("complete"))
                break;
            else
                wait(2);

            i++;
        }


    }
//************************************************************************************************************************************

    //************************************************************************************************************************************
    public void wait(int time) {
        try {
            Thread.sleep(time * 10);
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
//************************************************************************************************************************************
    /*public List<WebElement> getListOfElement(String locatorKey)
    {
        return driver.findElements(B)
    }*/

    public void click(String locatorKey) {
        try {
            String logicalNameOfElement = locatorKey.split("_")[0];
            // log("Trying to click on the element - " + logicalNameOfElement);
            getElement(locatorKey).click();
            wait(500);
            log("Clicked on the element - " + logicalNameOfElement);
        } catch (Exception ignore) {
            String logicalNameOfElement = locatorKey.split("_")[0];
            logFail("Failed to click on the element - " + logicalNameOfElement);
        }

    }

    public void clickWithOutWait(String locatorKey) {
        try {
            String logicalNameOfElement = locatorKey.split("_")[0];
            // log("Trying to click on the element - " + logicalNameOfElement);
            getElement(locatorKey).click();
            log("Clicked on the element - " + logicalNameOfElement);
        } catch (Exception ignore) {
            String logicalNameOfElement = locatorKey.split("_")[0];
            logFail("Failed to click on the element - " + logicalNameOfElement);
        }

    }

    public void jsclick(String locatorKey) {
        try {
            String logicalNameOfElement = locatorKey.split("_")[0];
            //    log("Trying to click on the element - " + logicalNameOfElement);
            JavascriptExecutor executor = (JavascriptExecutor) driver;
            executor.executeScript("arguments[0].click();", getElement(locatorKey));
            wait(500);
            log("Clicked on the element - " + logicalNameOfElement);
        } catch (Exception ignore) {
            String logicalNameOfElement = locatorKey.split("_")[0];
            logFail("Failed to click on the element - " + logicalNameOfElement);
        }

    }

    public void actionsClick(String locatorKey) {
        try {
            String logicalNameOfElement = locatorKey.split("_")[0];
            log("Trying to click on the element - " + logicalNameOfElement);
            Actions actions = new Actions(driver);
            actions.moveToElement(getElement(locatorKey)).click().build().perform();
            wait(500);
            log("Clicked on the element - " + logicalNameOfElement);
        } catch (Exception ignore) {
            String logicalNameOfElement = locatorKey.split("_")[0];
            logFail("Failed to click on the element - " + logicalNameOfElement);
        }

    }

    public static WebDriverWait driverWait;

    public void driverWaitClick(String locatorKey) {
        try {
            String logicalNameOfElement = locatorKey.split("_")[0];
            //log("Trying to click on the element - " + logicalNameOfElement);
            WebDriverWait driverWait = new WebDriverWait(driver, Duration.ofSeconds(10));
            driverWait.until(ExpectedConditions.elementToBeClickable(getElement(locatorKey))).click();
            wait(500);
            log("Clicked on the element - " + logicalNameOfElement);
        } catch (Exception ignore) {
            String logicalNameOfElement = locatorKey.split("_")[0];
            logFail("Failed to click on the element - " + logicalNameOfElement);
        }

    }

    public void dblClick(String locatorKey) {
        try {
            String logicalNameOfElement = locatorKey.split("_")[0];
            log("Trying to click on the element - " + logicalNameOfElement);
            Actions actions = new Actions(driver);
            actions.moveToElement(getElement(locatorKey)).doubleClick().build().perform();
            wait(1);
            logPass("Clicked on the element - " + logicalNameOfElement);
        } catch (Exception ignore) {
            String logicalNameOfElement = locatorKey.split("_")[0];
            logFail("Failed to click on the element - " + logicalNameOfElement);
        }

    }

    public void type(String locatorKey, String data) {
        try {
            String logicalName = locatorKey.split("_")[0];
            // log("Trying to type "+" the text '"+ data+"' in "+logicalName+" textbox.");
            getElement(locatorKey).sendKeys(data);
            wait(1);
            log("Entered the text '" + data + "'" + " in " + logicalName + " textbox");
        } catch (Exception ignore) {
            String logicalName = locatorKey.split("_")[0];
            logFail("Failed to enter the text '" + data + "'" + " in " + logicalName + " textbox");
        }

    }


    public void clear(String locatorKey) {
        try {
            String logicalName = locatorKey.split("_")[0];
            log("Trying to clear the text field " + logicalName);
            getElement(locatorKey).clear();
            wait(1);
            logPass("Cleared the value in text box -" + logicalName);
        } catch (Exception ignore) {
            String logicalName = locatorKey.split("_")[0];
            logFail("Failed to clear the value in text box -" + logicalName);
        }
    }

    public void clickEnterButton(String locatorKey) {
        try {
            String logicalName = locatorKey.split("_")[0];
            log("Trying to click enter in - " + logicalName);
            getElement(locatorKey).sendKeys(Keys.ENTER);
            wait(1);
            log("Clicked enter button in" + logicalName);
        } catch (Exception ignored) {
            String logicalName = locatorKey.split("_")[0];
            logFail("Failed to click on enter button in" + logicalName);

        }
    }

    public void navigateToUrl(WebDriver driver1, String urlVal) {
        try {
            // log("Trying to navigate to the url - "+urlVal);
            driver1.get(urlVal);
            driver1.manage().window().maximize();
            wait(500);
            logPass("Navigated to the url - " + urlVal);
        } catch (Exception ignore) {
            logFail("Failed to navigate to the url" + urlVal);
        }
    }


    public String getText(String locatorKey) throws ConfigurationException {

        //   log("Retreiving the text in the element "+locatorKey.split("_")[0]);
        String extractedTextVal = "";
        try {
            extractedTextVal = getElement(locatorKey).getText();
            // log("Extracted the text for the element - "+locatorKey.split("_")[0]);
        } catch (Exception ignore) {
            logFail("Failed to extract the text for the element - " + locatorKey.split("_")[0]);
        }
        return extractedTextVal;
    }

    public String getAttributeVal(String locatorKey, String attributeName) throws ConfigurationException {

        String extractedAttrVal = "";
        try {
            extractedAttrVal = getElement(locatorKey).getAttribute(attributeName);
            //  log("Extracted the attribute - "+attributeName+", for the element - "+locatorKey.split("_")[0]);
        } catch (Exception ignore) {

            logFail("Failed to extract the attribute - " + attributeName + ", for the element - " + locatorKey.split("_")[0]);

        }
        return extractedAttrVal;

    }

    public void assertAll() {
        softAssert.assertAll();
    }

    public static String readJSON(String filepath, String find) throws IOException, org.json.simple.parser.ParseException {
        String strVal = "";
        try {
            org.json.simple.parser.JSONParser jsonParser = new JSONParser();
            org.json.simple.JSONObject jsonObject = (org.json.simple.JSONObject) jsonParser.parse(new FileReader(filepath));
            strVal = (String) jsonObject.get(find);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (org.json.simple.parser.ParseException e) {
            e.printStackTrace();
        }

        return strVal;

    }


//*****************************************************************************************************************
    //Application specific methods

    public void selectLocale() {
        click("localeDropDown_xpath");
        click("English_xpath");
        click("saveLocale_xpath");

    }

    public void selectLocale(String langVal) throws ConfigurationException {
        log("Selecting the \"" + langVal + "\" locale.");
        setApplPropFilePath("objectRepo.properties");
        setPropertyVal(locale_xpath2, langVal);
        click("localeDropDown_xpath");
        click(locale_xpath);
        click("saveLocale_xpath");
        String actVal = getText("localeDropDown_xpath");
        setLocalePropFilePath("localeButtonObj.properties");
        String expVal = getPropertyVal(langVal);
        if (actVal.equalsIgnoreCase(expVal)) {
            logPass("Locale \"" + langVal + "\" got selected successfully.");
        } else {
            logFail("Locale \"" + langVal + "\" did NOT get selected successfully.");
        }
        setApplPropFilePath("objectRepo.properties");

    }

    public void refreshBrowser() {
        driver.navigate().refresh();
    }

    public int getDropDownItemsCount(String webElementToFind) throws ConfigurationException {
        List<WebElement> elements = getElements(webElementToFind);
        return elements.size();
    }

    public String getHeaderNumber(String locatorKey, String headerNameVal) throws ConfigurationException {
        List<WebElement> elements = getElements(locatorKey);
        int headersSize = elements.size();
        int i = 0;
        for (WebElement element : elements) {
            if (element.getText().equalsIgnoreCase(headerNameVal)) {
                i = i + 1;
                break;
            }
        }
        String s = Integer.toString(i);
        return s;

    }

    public void verifyExportAfterSelectingRows() throws ConfigurationException, CsvValidationException, IOException {
        int rowsCountVal = Integer.parseInt(getEntireTableCountForCol());
        if (rowsCountVal == 0) {
            verifyNoDataValueInSessActTable();
        } else if (rowsCountVal == 1) {
            setPropertyVal(checkboxCol_xpath2, "1");
            click(checkboxCol_xpath);
            if (getElements(sessActivityTableCheckedRows_xpath).size() == 1) {
                logPass("1 row got checked in the grid.");
                setPropertyVal(textOnExportAfterSel_Val2, "1");
                if (getText(sessActivityExportAll_xpath).equalsIgnoreCase(getPropertyVal(textOnExportAfterSel_Val))) {
                    logPass("Text on Export all button is same as that of the selected 1 row i.e. " + (getPropertyVal(textOnExportAfterSel_Val)));
                } else {
                    logFail("Text on Export all button is NOT same as that of the selected 1 row  i.e. " + (getPropertyVal(textOnExportAfterSel_Val)));
                }
                click(sessActivityExportAll_xpath);
                List<String> sessionIDs = getColDataInExpFile(getPropertyVal(sessionIDColName_Val));
                if (sessionIDs.size() == 1) {
                    logPass("Session id count in the exported file is same as the expected count as per row selection.");
                } else {
                    logFail("Session id count in the exported file is NOT same as the expected count as per row selection.");
                }

            } else if ((getElements(sessActivityTableCheckedRows_xpath).size() > 1)) {
                logFail("More than 1 row got checked in the grid.");
            } else {
                logFail("No rows got checked in the grid.");
            }


        } else if (rowsCountVal == 2) {
            setPropertyVal(checkboxCol_xpath2, "1");
            click(checkboxCol_xpath);
            setPropertyVal(checkboxCol_xpath2, "2");
            click(checkboxCol_xpath);
            if (getElements(sessActivityTableCheckedRows_xpath).size() == 2) {
                logPass("2 rows got checked in the grid.");
                setPropertyVal(textOnExportAfterSel_Val2, "2");
                if (getText(sessActivityExportAll_xpath).equalsIgnoreCase(getPropertyVal(textOnExportAfterSel_Val))) {
                    logPass("Text on Export all button is same as that of the selected 2 rows i.e. " + (getPropertyVal(textOnExportAfterSel_Val)));
                } else {
                    logFail("Text on Export all button is NOT same as that of the selected 2 rows  i.e. " + (getPropertyVal(textOnExportAfterSel_Val)));
                }
                click(sessActivityExportAll_xpath);
                List<String> sessionIDs = getColDataInExpFile(getPropertyVal(sessionIDColName_Val));
                if (sessionIDs.size() == 2) {
                    logPass("Session id count in the exported file is same as the expected count as per row selection.");
                } else {
                    logFail("Session id count in the exported file is NOT same as the expected count as per row selection.");
                }
            } else if ((getElements(sessActivityTableCheckedRows_xpath).size() > 2)) {
                logFail("More than 2 rows got checked in the grid.");
            } else if ((getElements(sessActivityTableCheckedRows_xpath).size() == 1)) {
                logFail("Only 1 row got checked in the grid.");
            } else {
                logFail("No rows got checked in the grid.");
            }

        } else if (rowsCountVal >= 3) {
            setPropertyVal(checkboxCol_xpath2, "1");
            click(checkboxCol_xpath);
            setPropertyVal(checkboxCol_xpath2, "2");
            click(checkboxCol_xpath);
            setPropertyVal(checkboxCol_xpath2, "3");
            click(checkboxCol_xpath);
            if (getElements(sessActivityTableCheckedRows_xpath).size() == 3) {
                logPass("3 rows got checked in the grid.");
                setPropertyVal(textOnExportAfterSel_Val2, "3");
                if (getText(sessActivityExportAll_xpath).equalsIgnoreCase(getPropertyVal(textOnExportAfterSel_Val))) {
                    logPass("Text on Export all button is same as that of the selected 3 rows i.e. " + (getPropertyVal(textOnExportAfterSel_Val)));
                } else {
                    logFail("Text on Export all button is NOT same as that of the selected 3 rows  i.e. " + (getPropertyVal(textOnExportAfterSel_Val)));
                }
                click(sessActivityExportAll_xpath);
                List<String> sessionIDs = getColDataInExpFile(getPropertyVal(sessionIDColName_Val));
                if (sessionIDs.size() == 3) {
                    logPass("Session id count in the exported file is same as the expected count as per row selection.");
                } else {
                    logFail("Session id count in the exported file is NOT same as the expected count as per row selection.");
                }
            } else if ((getElements(sessActivityTableCheckedRows_xpath).size() > 3)) {
                logFail("More than 3 rows got checked in the grid.");
            } else if ((getElements(sessActivityTableCheckedRows_xpath).size() == 2)) {
                logFail("Only 2 row got checked in the grid.");
            } else if ((getElements(sessActivityTableCheckedRows_xpath).size() == 1)) {
                logFail("Only 1 row got checked in the grid.");
            } else {
                logFail("No rows got checked in the grid.");
            }

        } else {
            verifyNoDataValueInSessActTable();
        }
    }

    public int getSessionActTableRowsCount() throws ConfigurationException {
        List<WebElement> elements = getElements(sessionActivityTbl_xpath);
        int rowsCount = elements.size();
        return rowsCount;
    }

    public void verifyNoDataValueInSessActTable() throws ConfigurationException {
        int fullCountVal = Integer.parseInt(getEntireTableCountForCol());
        if (fullCountVal == 0) {
            if (getText(noDataInTable_xpath).equalsIgnoreCase(getPropertyVal(noDataInTable_val))) {
                logPass("No Data got populated in the table grid.");
            } else {
                logFail("No Data did NOT got populated in the table grid.");
            }
        }
    }

    public String[] getFilesInDownloadDir(String folderPathVal) {
        File directoryPath = new File(folderPathVal);
        //List of all files and directories
        String contents[] = directoryPath.list();
        return contents;
    }

    public boolean verifyWhetherDataIsExported() throws CsvValidationException, IOException {
        String[] filesVal = getFilesInDownloadDir(System.getProperty("user.dir") + "\\download");
        if (filesVal.length == 1) {
            logPass("File got exported.");
            return true;
        } else if (filesVal.length > 1) {
            logFail("Multiple files got exported after clicking on export.");
            return false;
        } else {
            logFail("Clicking on export button did NOT export file.");
            return false;
        }
    }

    public void verifyWhetherImageIsDownloaded(String pageNumberVal, String rowNumberVal, String imageNoVal) throws CsvValidationException, IOException {
        String[] filesVal = getFilesInDownloadDir(System.getProperty("user.dir") + "\\download");
        if (filesVal.length == 1) {
            logPass("On the page no: " + pageNumberVal + " and at row no " + rowNumberVal + " the image no: " + imageNoVal + " got downloaded.");
            for (String file1 : filesVal) {
                String extVal=FilenameUtils.getExtension(System.getProperty("user.dir") + "\\download\\" + file1);
                if (extVal.equalsIgnoreCase("jpg") || extVal.equalsIgnoreCase("jpeg")) {
                    logPass("Image which got downloaded is jpg or jpeg.");
                } else {
                    logFail("Image which got downloaded is NOT jpg or jpeg.");
                }
            }

        } else if (filesVal.length > 1) {
            logFail("Multiple images got downloaded.");

        } else {
            logFail("On the page no: " + pageNumberVal + " and at row no " + rowNumberVal + " the image no: " + imageNoVal + " did NOT get downloaded.");

        }
    }

    public String getExportedFilePath() throws CsvValidationException, IOException {
        String exportedFilePath = "";
        String[] filesVal = getFilesInDownloadDir(System.getProperty("user.dir") + "\\download");
        if (filesVal.length == 1) {
            exportedFilePath = getFilesInDownloadDir(System.getProperty("user.dir") + "\\download")[0];
        }
        String exportedFilePathVal = System.getProperty("user.dir") + "\\download\\" + exportedFilePath;
        return exportedFilePathVal;
    }

    public int getExportedCSVRowsCount(String filePathVal) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new FileReader(filePathVal));
        String input;
        int count = 0;
        while ((input = bufferedReader.readLine()) != null) {
            count++;
        }
        return count;

    }

    public int verifyNgetTheExportedDataContainTheReqdCol(String colNameVal) throws CsvValidationException, IOException {
        String exportedFilePathVal = getExportedFilePath();
        CSVReader reader = new CSVReader(new FileReader(exportedFilePathVal));
        String[] header = reader.readNext();
        int iCounter = 0;
        int iVal1 = 0;
        for (int iVal = 0; iVal < header.length; iVal++) {
            if (header[iVal].trim().equalsIgnoreCase(colNameVal)) {
                iCounter = iCounter + 1;
                iVal1 = iVal;
            }
        }
        if (iCounter == 1) {
            logPass("The header " + colNameVal + " got populated in the exported csv.");
            reader.close();
            return iVal1;
        } else if (iCounter > 1) {
            logFailWithOutScreenshot("The header " + colNameVal + " got populated for multiple times in the exported csv.");
            reader.close();
            return iVal1;
        } else {
            logFailWithOutScreenshot("The header " + colNameVal + " did NOT get populated in the exported csv.");
            reader.close();
            return iVal1;
        }

    }

    public void verifySessionIDCountInExportedFile() throws ConfigurationException, CsvValidationException, IOException {
        boolean boolVal = verifyWhetherDataIsExported();
        if (boolVal) {
            List<String> sessionIDs = getColDataInExpFile(getPropertyVal(sessionIDColName_Val));
            int rowCount = Integer.parseInt(getEntireTableCountForCol());
            int sessionIDsCount = sessionIDs.size();
            if (rowCount == sessionIDsCount) {
                logPass("Session ID count is same as that of the count in the data that got displayed in grid.");
            } else {
                logFail("Session ID count is NOT same as that of the count in the data that got displayed in grid.");
            }
        }
    }

    public void verifyNoDataAndThenClickExportAndVerifySessCount() throws ConfigurationException, CsvValidationException, IOException {
        int fullCountVal = Integer.parseInt(getEntireTableCountForCol());
        if (fullCountVal == 0) {
            verifyNoDataValueInSessActTable();
            if (getElement(sessActivityExportAll_xpath).isEnabled()) {
                logFail("Export button is present, and is NOT disabled.");
            }else{
                logPass("Export button is present, and is disabled.");
            }
        } else {
            if (getElement(sessActivityExportAll_xpath).isEnabled()) {

                click(sessActivityExportAll_xpath);
                verifySessionIDCountInExportedFile();
            } else {
                logFail("Export button is present, and is disabled.");
            }

        }

    }

    public List<String> getColDataInExpFile(String colName) throws CsvValidationException, IOException {
        int colNO = verifyNgetTheExportedDataContainTheReqdCol(colName);
        // int rowsCount = getExportedCSVRowsCount(exportedFilePathVal);
        List<String> colVals = new ArrayList<String>();
        String exportedFilePathVal = getExportedFilePath();
        CSVReader reader = new CSVReader(new FileReader(exportedFilePathVal));
        String line[];
        int jVal = 0;
        while ((line = reader.readNext()) != null) {
            if (jVal > 0) {
                if (!colVals.contains(line[colNO])) {
                    colVals.add(line[colNO].trim());
                }
            }
            jVal = jVal + 1;
        }
        reader.close();
        return colVals;
    }

    public List<String> getColDataInTable(String locatorKey) throws ConfigurationException {
        List<WebElement> elements = getElements(locatorKey);
        List<String> listVal = new ArrayList<String>();
        int rowCountsPerPage = getSessionActTableRowsCount();
        int fullCountVal = Integer.parseInt(getEntireTableCountForCol());
        int totalRowCount = 0;
        if (fullCountVal == 0) {
            if (getText(noDataInTable_xpath).equalsIgnoreCase(getPropertyVal(noDataInTable_val))) {
                logPass("No Data got populated in the table grid.");
            } else {
                logFail("No Data did NOT got populated in the table grid.");
            }
        } else {
            if (rowCountsPerPage < 25 && rowCountsPerPage == fullCountVal) {
                for (WebElement element : elements) {
                    listVal.add(element.getText());
                }

            } else {
                do {
                    List<WebElement> elements1 = getElements(locatorKey);
                    for (WebElement element : elements1) {
                        listVal.add(element.getText());
                    }
                    click(navRightArrowButton_xpath);
                    int rowCountsPerPage1 = getSessionActTableRowsCount();
                    if (rowCountsPerPage1 < 25) {
                        List<WebElement> elements2 = getElements(locatorKey);
                        for (WebElement element : elements2) {
                            listVal.add(element.getText());
                        }
                    }

                } while (!getAttributeVal(navRghtEnbDisbl_xpath, "class").toString().equalsIgnoreCase(getPropertyVal(navDisbl_clssval)));
            }
        }
        String s = "abc";

        return listVal;
    }

    public List<String> getTextValues(String locatorKey) throws ConfigurationException {
        List<WebElement> elements1 = getElements(locatorKey);
        List<String> listVal = new ArrayList<String>();
        for (WebElement element : elements1) {
            listVal.add(element.getText());
        }
        return listVal;
    }


    public void verifyDateStringListInDescSortingOrder(List<String> listToEvaluate, String logicalName, String pageNumber, String dateFormatVal) throws ConfigurationException, ParseException {
        List<Date> listDateToEvaluate = new ArrayList<Date>();
        for (String element : listToEvaluate) {
            listDateToEvaluate.add(convertTheStringDateIntoDate(element, getPropertyVal(dateFormatVal)));
        }
        List tempEvaluate = new ArrayList(listDateToEvaluate);
        Collections.sort(tempEvaluate, Collections.reverseOrder());
        int iCounterVal = 0;
        String finalVal = "";
        for (int iVal = 0; iVal < listDateToEvaluate.size(); iVal++) {
            if (!tempEvaluate.get(iVal).toString().equalsIgnoreCase(listDateToEvaluate.get(iVal).toString())) {
                if ((tempEvaluate.size() - iVal) >= 6) {
                    int row1 = iVal + 1;
                    int row2 = iVal + 2;
                    int row3 = iVal + 3;
                    int row4 = iVal + 4;
                    int row5 = iVal + 5;
                    String s1 = Integer.toString(row1);
                    String s2 = Integer.toString(row2);
                    String s3 = Integer.toString(row3);
                    String s4 = Integer.toString(row4);
                    String s5 = Integer.toString(row5);


                    finalVal = "The sorting order is not in descending order for "
                            + logicalName
                            + "<br>=================================================================================================="
                            + "<br> Sorting got broked On page no: " + pageNumber + " at row number " + s1 + ". Details of the values are as below."
                            + "<br> ********************Expected Values till 5 rows**********************"
                            + "<br> ExpectedValue : At row number " + s1 + ":\"" + tempEvaluate.get(iVal).toString()
                            + "<br> ExpectedValue : At row number " + s2 + ":\"" + tempEvaluate.get(iVal + 1).toString()
                            + "<br> ExpectedValue : At row number " + s3 + ":\"" + tempEvaluate.get(iVal + 2).toString()
                            + "<br> ExpectedValue : At row number " + s4 + ":\"" + tempEvaluate.get(iVal + 3).toString()
                            + "<br> ExpectedValue : At row number " + s5 + ":\"" + tempEvaluate.get(iVal + 4).toString()
                            + "<br> ********************Act Values till 5 rows**********************"
                            + "<br> ActualValue : At row number " + s1 + ":\"" + listDateToEvaluate.get(iVal).toString()
                            + "<br> ActualValue : At row number " + s2 + ":\"" + listDateToEvaluate.get(iVal + 1).toString()
                            + "<br> ActualValue : At row number " + s3 + ":\"" + listDateToEvaluate.get(iVal + 2).toString()
                            + "<br> ActualValue : At row number " + s4 + ":\"" + listDateToEvaluate.get(iVal + 3).toString()
                            + "<br> ActualValue : At row number " + s5 + ":\"" + listDateToEvaluate.get(iVal + 4).toString()
                            + "<br>==================================================================================================";
                } else if ((tempEvaluate.size() - iVal) == 5) {
                    int row1 = iVal + 1;
                    int row2 = iVal + 2;
                    int row3 = iVal + 3;
                    int row4 = iVal + 4;

                    String s1 = Integer.toString(row1);
                    String s2 = Integer.toString(row2);
                    String s3 = Integer.toString(row3);
                    String s4 = Integer.toString(row4);

                    finalVal = "The sorting order is not in descending order for "
                            + logicalName
                            + "<br>=================================================================================================="
                            + "<br> Sorting got broked On page no: " + pageNumber + " at row number " + s1 + ". Details of the values are as below."
                            + "<br> ********************Expected Values till 4 rows**********************"
                            + "<br> ExpectedValue : At row number " + s1 + ":\"" + tempEvaluate.get(iVal).toString()
                            + "<br> ExpectedValue : At row number " + s2 + ":\"" + tempEvaluate.get(iVal + 1).toString()
                            + "<br> ExpectedValue : At row number " + s3 + ":\"" + tempEvaluate.get(iVal + 2).toString()
                            + "<br> ExpectedValue : At row number " + s4 + ":\"" + tempEvaluate.get(iVal + 3).toString()

                            + "<br> ********************Act Values till 4 rows**********************"
                            + "<br> ActualValue : At row number " + s1 + ":\"" + listDateToEvaluate.get(iVal).toString()
                            + "<br> ActualValue : At row number " + s2 + ":\"" + listDateToEvaluate.get(iVal + 1).toString()
                            + "<br> ActualValue : At row number " + s3 + ":\"" + listDateToEvaluate.get(iVal + 2).toString()
                            + "<br> ActualValue : At row number " + s4 + ":\"" + listDateToEvaluate.get(iVal + 3).toString()

                            + "<br>==================================================================================================";
                } else if ((tempEvaluate.size() - iVal) == 4) {
                    int row1 = iVal + 1;
                    int row2 = iVal + 2;
                    int row3 = iVal + 3;


                    String s1 = Integer.toString(row1);
                    String s2 = Integer.toString(row2);
                    String s3 = Integer.toString(row3);


                    finalVal = "The sorting order is not in descending order for "
                            + logicalName
                            + "<br>=================================================================================================="
                            + "<br> Sorting got broked On page no: " + pageNumber + " at row number " + s1 + ". Details of the values are as below."
                            + "<br> ********************Expected Values till 3 rows**********************"
                            + "<br> ExpectedValue : At row number " + s1 + ":\"" + tempEvaluate.get(iVal).toString()
                            + "<br> ExpectedValue : At row number " + s2 + ":\"" + tempEvaluate.get(iVal + 1).toString()
                            + "<br> ExpectedValue : At row number " + s3 + ":\"" + tempEvaluate.get(iVal + 2).toString()


                            + "<br> ********************Act Values till 3 rows**********************"
                            + "<br> ActualValue : At row number " + s1 + ":\"" + listDateToEvaluate.get(iVal).toString()
                            + "<br> ActualValue : At row number " + s2 + ":\"" + listDateToEvaluate.get(iVal + 1).toString()
                            + "<br> ActualValue : At row number " + s3 + ":\"" + listDateToEvaluate.get(iVal + 2).toString()


                            + "<br>==================================================================================================";
                } else if ((tempEvaluate.size() - iVal) == 3) {
                    int row1 = iVal + 1;
                    int row2 = iVal + 2;
                    int row3 = iVal + 3;


                    String s1 = Integer.toString(row1);
                    String s2 = Integer.toString(row2);
                    String s3 = Integer.toString(row3);


                    finalVal = "The sorting order is not in descending order for "
                            + logicalName
                            + "<br>=================================================================================================="
                            + "<br> Sorting got broked On page no: " + pageNumber + " at row number " + s1 + ". Details of the values are as below."
                            + "<br> ********************Expected Values till 3 rows**********************"
                            + "<br> ExpectedValue : At row number " + s1 + ":\"" + tempEvaluate.get(iVal).toString()
                            + "<br> ExpectedValue : At row number " + s2 + ":\"" + tempEvaluate.get(iVal + 1).toString()
                            + "<br> ExpectedValue : At row number " + s3 + ":\"" + tempEvaluate.get(iVal + 2).toString()


                            + "<br> ********************Act Values till 3 rows**********************"
                            + "<br> ActualValue : At row number " + s1 + ":\"" + listDateToEvaluate.get(iVal).toString()
                            + "<br> ActualValue : At row number " + s2 + ":\"" + listDateToEvaluate.get(iVal + 1).toString()
                            + "<br> ActualValue : At row number " + s3 + ":\"" + listDateToEvaluate.get(iVal + 2).toString()


                            + "<br>==================================================================================================";
                } else if ((tempEvaluate.size() - iVal) == 2) {
                    int row1 = iVal + 1;
                    int row2 = iVal + 2;


                    String s1 = Integer.toString(row1);
                    String s2 = Integer.toString(row2);


                    finalVal = "The sorting order is not in descending order for "
                            + logicalName
                            + "<br>=================================================================================================="
                            + "<br> Sorting got broked On page no: " + pageNumber + " at row number " + s1 + ". Details of the values are as below."
                            + "<br> ********************Expected Values till 2 rows**********************"
                            + "<br> ExpectedValue : At row number " + s1 + ":\"" + tempEvaluate.get(iVal).toString()
                            + "<br> ExpectedValue : At row number " + s2 + ":\"" + tempEvaluate.get(iVal + 1).toString()


                            + "<br> ********************Act Values till 2 rows**********************"
                            + "<br> ActualValue : At row number " + s1 + ":\"" + listDateToEvaluate.get(iVal).toString()
                            + "<br> ActualValue : At row number " + s2 + ":\"" + listDateToEvaluate.get(iVal + 1).toString()


                            + "<br>==================================================================================================";
                }
                int row1 = iVal + 1;
                int row2 = iVal + 2;
                String s1 = Integer.toString(row1);
                String s2 = Integer.toString(row2);
                logFailWithOutScreenshot(finalVal);
                iCounterVal = iCounterVal + 1;
                break;
            }
        }
        if (iCounterVal == 0) {
            logPass("The sorting order is in descending for " + logicalName);
        }

    }

    public void verifyASCSortingOrderStringInGrid(String ascOrderlocatorKey, String colLocatorKey) throws ConfigurationException {
        List<String> orgEntireCoLDate = getColDataInTable(colLocatorKey);
        Collections.sort(orgEntireCoLDate);
        navToFirstPage();
        actionsClick(ascOrderlocatorKey);
        List<String> actEntireColDate = getColDataInTable(colLocatorKey);
        int iCounterVal = 0;
        for (int iVal = 0; iVal < orgEntireCoLDate.size(); iVal++) {
            if (!actEntireColDate.get(iVal).toString().equalsIgnoreCase(orgEntireCoLDate.get(iVal).toString())) {

                String statementToLog = sortingFailureStatementVal(orgEntireCoLDate, actEntireColDate, iVal, colLocatorKey.split("_")[0], "Ascending");
                logFailWithOutScreenshot(statementToLog);
                iCounterVal = iCounterVal + 1;
                break;

            }
        }
        if (iCounterVal == 0) {
            logPass(colLocatorKey.split("_")[0] + " got sorted in ascending order successfully.");
        }
    }

    public void verifyDateASCSortingOrderStringInGrid(String ascOrderlocatorKey, String colLocatorKey, String dateFormatVal) throws ConfigurationException, ParseException {
        List<String> orgEntireCoLDate = getColDataInTable(colLocatorKey);
        List<Date> orgEntireColDateVal = new ArrayList<Date>();
        for (String element : orgEntireCoLDate) {
            if (element.equalsIgnoreCase("")) {
                orgEntireColDateVal.add(null);
            } else {
                orgEntireColDateVal.add(convertTheStringDateIntoDate(element, dateFormatVal));
            }
        }
        Collections.sort(orgEntireColDateVal);
        navToFirstPage();
        jsclick(ascOrderlocatorKey);
        List<String> actEntireColDate = getColDataInTable(colLocatorKey);
        List<Date> actEntireColDateVal = new ArrayList<Date>();
        for (String element : actEntireColDate) {
            actEntireColDateVal.add(convertTheStringDateIntoDate(element, dateFormatVal));
        }
        int iCounterVal = 0;
        for (int iVal = 0; iVal < orgEntireCoLDate.size(); iVal++) {
            if (!actEntireColDateVal.get(iVal).toString().equalsIgnoreCase(orgEntireColDateVal.get(iVal).toString())) {

                String statementToLog = sortingDateFailureStatementVal(orgEntireColDateVal, actEntireColDateVal, iVal, colLocatorKey.split("_")[0], "Ascending");
                logFailWithOutScreenshot(statementToLog);
                iCounterVal = iCounterVal + 1;
                break;

            }
        }
        if (iCounterVal == 0) {
            logPass(colLocatorKey.split("_")[0] + " got sorted in ascending order successfully.");
        }
    }

    public String convertTheDateFormatNRetStr(String dateVal, String dateFormatVal, String dateTargetVal) throws ParseException {
        SimpleDateFormat originalDateFormat = new SimpleDateFormat(dateFormatVal);
        SimpleDateFormat targetFormat = new SimpleDateFormat(dateTargetVal);
        Date date1 = originalDateFormat.parse(dateVal);
        String formattedDate = targetFormat.format(date1);
        return formattedDate;
    }

    public void verifyDateStrASCSortingOrderStringInGrid(String ascOrderlocatorKey, String colLocatorKey, String dateFormatVal) throws ConfigurationException, ParseException {
        List<String> orgEntireCoLDate = getColDataInTable(colLocatorKey);
        List<String> orgEntireColDateVal = new ArrayList<String>();
        for (String element : orgEntireCoLDate) {
            if (element.equalsIgnoreCase("")) {
                orgEntireColDateVal.add("");
            } else {
                orgEntireColDateVal.add(convertTheDateFormatNRetStr(element, dateFormatVal, "yyyy-MM-dd HH:mm"));
            }
        }
        Collections.sort(orgEntireColDateVal);
        navToFirstPage();
        jsclick(ascOrderlocatorKey);
        List<String> actEntireColDate = getColDataInTable(colLocatorKey);
        List<String> actEntireColDateVal = new ArrayList<String>();
        for (String element : actEntireColDate) {
            if (element.equalsIgnoreCase("")) {
                actEntireColDateVal.add("");
            } else {
                actEntireColDateVal.add(convertTheDateFormatNRetStr(element, dateFormatVal, "yyyy-MM-dd HH:mm"));
            }

        }
        int iCounterVal = 0;
        for (int iVal = 0; iVal < orgEntireCoLDate.size(); iVal++) {
            if (!actEntireColDateVal.get(iVal).toString().equalsIgnoreCase(orgEntireColDateVal.get(iVal).toString())) {

                String statementToLog = sortingFailureStatementVal(orgEntireCoLDate, actEntireColDate, iVal, colLocatorKey.split("_")[0], "Ascending");
                logFailWithOutScreenshot(statementToLog);
                iCounterVal = iCounterVal + 1;
                break;

            }
        }
        if (iCounterVal == 0) {
            logPass(colLocatorKey.split("_")[0] + " got sorted in ascending order successfully.");
        }
    }

    public void verifyDateStrDescSortingOrderStringInGrid(String ascOrderlocatorKey, String colLocatorKey, String dateFormatVal) throws ConfigurationException, ParseException {
        List<String> orgEntireCoLDate = getColDataInTable(colLocatorKey);
        List<String> orgEntireColDateVal = new ArrayList<String>();
        for (String element : orgEntireCoLDate) {
            if (element.equalsIgnoreCase("")) {
                orgEntireColDateVal.add("");
            } else {
                orgEntireColDateVal.add(convertTheDateFormatNRetStr(element, dateFormatVal, "yyyy-MM-dd HH:mm"));
            }
        }
        Collections.sort(orgEntireColDateVal, Collections.reverseOrder());
        navToFirstPage();
        jsclick(ascOrderlocatorKey);
        List<String> actEntireColDate = getColDataInTable(colLocatorKey);
        List<String> actEntireColDateVal = new ArrayList<String>();
        for (String element : actEntireColDate) {
            if (element.equalsIgnoreCase("")) {
                actEntireColDateVal.add("");
            } else {
                actEntireColDateVal.add(convertTheDateFormatNRetStr(element, dateFormatVal, "yyyy-MM-dd HH:mm"));
            }

        }
        int iCounterVal = 0;
        for (int iVal = 0; iVal < orgEntireCoLDate.size(); iVal++) {
            if (!actEntireColDateVal.get(iVal).toString().equalsIgnoreCase(orgEntireColDateVal.get(iVal).toString())) {

                String statementToLog = sortingFailureStatementVal(orgEntireCoLDate, actEntireColDate, iVal, colLocatorKey.split("_")[0], "Descending");
                logFailWithOutScreenshot(statementToLog);
                iCounterVal = iCounterVal + 1;
                break;

            }
        }
        if (iCounterVal == 0) {
            logPass(colLocatorKey.split("_")[0] + " got sorted in descending order successfully.");
        }
    }

    public int getPageNumber(int iVal, int totalCount, int rowsPerPage) {
        iVal = iVal + 1;
        int noOfPagesInit = totalCount / rowsPerPage;
        int noOfRowsInit = noOfPagesInit * rowsPerPage;
        int diffVal = totalCount - noOfRowsInit;
        int sumVal1 = 0;
        int sumVal2 = 25;
        int pageNumberVal = 0;
        if (diffVal > 0) {
            for (int i = 1; i <= noOfPagesInit; i++) {
                if (iVal > sumVal1 && iVal < sumVal2) {
                    pageNumberVal = pageNumberVal + 1;
                    return pageNumberVal;
                }
                sumVal1 = sumVal1 + rowsPerPage;
                sumVal2 = sumVal2 + rowsPerPage;
            }
            if (iVal > sumVal1 && iVal < sumVal2) {
                pageNumberVal = pageNumberVal + 1;
                return pageNumberVal;
            }

        } else {
            if (iVal > sumVal1 && iVal < sumVal2) {
                pageNumberVal = pageNumberVal + 1;
                return pageNumberVal;
            }
            sumVal1 = sumVal1 + rowsPerPage;
            sumVal2 = sumVal2 + rowsPerPage;
        }
        return pageNumberVal;
    }

    public String sortingFailureStatementVal(List<String> tempEvaluate, List<String> listToEvaluate, int iVal, String logicalName, String sortingOrder) {
        String finalVal = "";
        int pageNumber = getPageNumber(iVal, tempEvaluate.size(), 25);
        if ((tempEvaluate.size() - iVal) >= 6) {
            int row1 = iVal + 1;
            int row2 = iVal + 2;
            int row3 = iVal + 3;
            int row4 = iVal + 4;
            int row5 = iVal + 5;
            String s1 = Integer.toString(row1);
            String s2 = Integer.toString(row2);
            String s3 = Integer.toString(row3);
            String s4 = Integer.toString(row4);
            String s5 = Integer.toString(row5);


            finalVal = "The sorting order is not in " + sortingOrder + " order for "
                    + logicalName
                    + "<br>=================================================================================================="
                    + "<br> Sorting got broken On page no: " + pageNumber + " at row number " + s1 + ". Details of the values are as below."
                    + "<br> ********************Expected Values till 5 rows**********************"
                    + "<br> ExpectedValue : At row number " + s1 + ":\"" + tempEvaluate.get(iVal)
                    + "<br> ExpectedValue : At row number " + s2 + ":\"" + tempEvaluate.get(iVal + 1)
                    + "<br> ExpectedValue : At row number " + s3 + ":\"" + tempEvaluate.get(iVal + 2)
                    + "<br> ExpectedValue : At row number " + s4 + ":\"" + tempEvaluate.get(iVal + 3)
                    + "<br> ExpectedValue : At row number " + s5 + ":\"" + tempEvaluate.get(iVal + 4)
                    + "<br> ********************Act Values till 5 rows**********************"
                    + "<br> ActualValue : At row number " + s1 + ":\"" + listToEvaluate.get(iVal)
                    + "<br> ActualValue : At row number " + s2 + ":\"" + listToEvaluate.get(iVal + 1)
                    + "<br> ActualValue : At row number " + s3 + ":\"" + listToEvaluate.get(iVal + 2)
                    + "<br> ActualValue : At row number " + s4 + ":\"" + listToEvaluate.get(iVal + 3)
                    + "<br> ActualValue : At row number " + s5 + ":\"" + listToEvaluate.get(iVal + 4)
                    + "<br>==================================================================================================";
        } else if ((tempEvaluate.size() - iVal) == 5) {
            int row1 = iVal + 1;
            int row2 = iVal + 2;
            int row3 = iVal + 3;
            int row4 = iVal + 4;

            String s1 = Integer.toString(row1);
            String s2 = Integer.toString(row2);
            String s3 = Integer.toString(row3);
            String s4 = Integer.toString(row4);

            finalVal = "The sorting order is not in " + sortingOrder + " order for "
                    + logicalName
                    + "<br>=================================================================================================="
                    + "<br> Sorting got broked On page no: " + pageNumber + " at row number " + s1 + ". Details of the values are as below."
                    + "<br> ********************Expected Values till 4 rows**********************"
                    + "<br> ExpectedValue : At row number " + s1 + ":\"" + tempEvaluate.get(iVal)
                    + "<br> ExpectedValue : At row number " + s2 + ":\"" + tempEvaluate.get(iVal + 1)
                    + "<br> ExpectedValue : At row number " + s3 + ":\"" + tempEvaluate.get(iVal + 2)
                    + "<br> ExpectedValue : At row number " + s4 + ":\"" + tempEvaluate.get(iVal + 3)

                    + "<br> ********************Act Values till 4 rows**********************"
                    + "<br> ActualValue : At row number " + s1 + ":\"" + listToEvaluate.get(iVal)
                    + "<br> ActualValue : At row number " + s2 + ":\"" + listToEvaluate.get(iVal + 1)
                    + "<br> ActualValue : At row number " + s3 + ":\"" + listToEvaluate.get(iVal + 2)
                    + "<br> ActualValue : At row number " + s4 + ":\"" + listToEvaluate.get(iVal + 3)

                    + "<br>==================================================================================================";
        } else if ((tempEvaluate.size() - iVal) == 4) {
            int row1 = iVal + 1;
            int row2 = iVal + 2;
            int row3 = iVal + 3;


            String s1 = Integer.toString(row1);
            String s2 = Integer.toString(row2);
            String s3 = Integer.toString(row3);


            finalVal = "The sorting order is not in " + sortingOrder + " order for "
                    + logicalName
                    + "<br>=================================================================================================="
                    + "<br> Sorting got broked On page no: " + pageNumber + " at row number " + s1 + ". Details of the values are as below."
                    + "<br> ********************Expected Values till 3 rows**********************"
                    + "<br> ExpectedValue : At row number " + s1 + ":\"" + tempEvaluate.get(iVal)
                    + "<br> ExpectedValue : At row number " + s2 + ":\"" + tempEvaluate.get(iVal + 1)
                    + "<br> ExpectedValue : At row number " + s3 + ":\"" + tempEvaluate.get(iVal + 2)


                    + "<br> ********************Act Values till 3 rows**********************"
                    + "<br> ActualValue : At row number " + s1 + ":\"" + listToEvaluate.get(iVal)
                    + "<br> ActualValue : At row number " + s2 + ":\"" + listToEvaluate.get(iVal + 1)
                    + "<br> ActualValue : At row number " + s3 + ":\"" + listToEvaluate.get(iVal + 2)


                    + "<br>==================================================================================================";
        } else if ((tempEvaluate.size() - iVal) == 3) {
            int row1 = iVal + 1;
            int row2 = iVal + 2;
            int row3 = iVal + 3;


            String s1 = Integer.toString(row1);
            String s2 = Integer.toString(row2);
            String s3 = Integer.toString(row3);


            finalVal = "The sorting order is not in " + sortingOrder + " order for "
                    + logicalName
                    + "<br>=================================================================================================="
                    + "<br> Sorting got broked On page no: " + pageNumber + " at row number " + s1 + ". Details of the values are as below."
                    + "<br> ********************Expected Values till 3 rows**********************"
                    + "<br> ExpectedValue : At row number " + s1 + ":\"" + tempEvaluate.get(iVal)
                    + "<br> ExpectedValue : At row number " + s2 + ":\"" + tempEvaluate.get(iVal + 1)
                    + "<br> ExpectedValue : At row number " + s3 + ":\"" + tempEvaluate.get(iVal + 2)


                    + "<br> ********************Act Values till 3 rows**********************"
                    + "<br> ActualValue : At row number " + s1 + ":\"" + listToEvaluate.get(iVal)
                    + "<br> ActualValue : At row number " + s2 + ":\"" + listToEvaluate.get(iVal + 1)
                    + "<br> ActualValue : At row number " + s3 + ":\"" + listToEvaluate.get(iVal + 2)


                    + "<br>==================================================================================================";
        } else if ((tempEvaluate.size() - iVal) == 2) {
            int row1 = iVal + 1;
            int row2 = iVal + 2;


            String s1 = Integer.toString(row1);
            String s2 = Integer.toString(row2);


            finalVal = "The sorting order is not in " + sortingOrder + " order for "
                    + logicalName
                    + "<br>=================================================================================================="
                    + "<br> Sorting got broked On page no: " + pageNumber + " at row number " + s1 + ". Details of the values are as below."
                    + "<br> ********************Expected Values till 2 rows**********************"
                    + "<br> ExpectedValue : At row number " + s1 + ":\"" + tempEvaluate.get(iVal)
                    + "<br> ExpectedValue : At row number " + s2 + ":\"" + tempEvaluate.get(iVal + 1)


                    + "<br> ********************Act Values till 2 rows**********************"
                    + "<br> ActualValue : At row number " + s1 + ":\"" + listToEvaluate.get(iVal)
                    + "<br> ActualValue : At row number " + s2 + ":\"" + listToEvaluate.get(iVal + 1)


                    + "<br>==================================================================================================";
        }
        return finalVal;
    }

    public String sortingDateFailureStatementVal(List<Date> tempEvaluate, List<Date> listToEvaluate, int iVal, String logicalName, String sortingOrder) {
        String finalVal = "";
        int pageNumber = getPageNumber(iVal, tempEvaluate.size(), 25);
        if ((tempEvaluate.size() - iVal) >= 6) {
            int row1 = iVal + 1;
            int row2 = iVal + 2;
            int row3 = iVal + 3;
            int row4 = iVal + 4;
            int row5 = iVal + 5;
            String s1 = Integer.toString(row1);
            String s2 = Integer.toString(row2);
            String s3 = Integer.toString(row3);
            String s4 = Integer.toString(row4);
            String s5 = Integer.toString(row5);


            finalVal = "The sorting order is not in " + sortingOrder + " order for "
                    + logicalName
                    + "<br>=================================================================================================="
                    + "<br> Sorting got broken On page no: " + pageNumber + " at row number " + s1 + ". Details of the values are as below."
                    + "<br> ********************Expected Values till 5 rows**********************"
                    + "<br> ExpectedValue : At row number " + s1 + ":\"" + tempEvaluate.get(iVal).toString()
                    + "<br> ExpectedValue : At row number " + s2 + ":\"" + tempEvaluate.get(iVal + 1).toString()
                    + "<br> ExpectedValue : At row number " + s3 + ":\"" + tempEvaluate.get(iVal + 2).toString()
                    + "<br> ExpectedValue : At row number " + s4 + ":\"" + tempEvaluate.get(iVal + 3).toString()
                    + "<br> ExpectedValue : At row number " + s5 + ":\"" + tempEvaluate.get(iVal + 4).toString()
                    + "<br> ********************Act Values till 5 rows**********************"
                    + "<br> ActualValue : At row number " + s1 + ":\"" + listToEvaluate.get(iVal).toString()
                    + "<br> ActualValue : At row number " + s2 + ":\"" + listToEvaluate.get(iVal + 1).toString()
                    + "<br> ActualValue : At row number " + s3 + ":\"" + listToEvaluate.get(iVal + 2).toString()
                    + "<br> ActualValue : At row number " + s4 + ":\"" + listToEvaluate.get(iVal + 3).toString()
                    + "<br> ActualValue : At row number " + s5 + ":\"" + listToEvaluate.get(iVal + 4).toString()
                    + "<br>==================================================================================================";
        } else if ((tempEvaluate.size() - iVal) == 5) {
            int row1 = iVal + 1;
            int row2 = iVal + 2;
            int row3 = iVal + 3;
            int row4 = iVal + 4;

            String s1 = Integer.toString(row1);
            String s2 = Integer.toString(row2);
            String s3 = Integer.toString(row3);
            String s4 = Integer.toString(row4);

            finalVal = "The sorting order is not in ascending order for "
                    + logicalName
                    + "<br>=================================================================================================="
                    + "<br> Sorting got broked On page no: " + pageNumber + " at row number " + s1 + ". Details of the values are as below."
                    + "<br> ********************Expected Values till 4 rows**********************"
                    + "<br> ExpectedValue : At row number " + s1 + ":\"" + tempEvaluate.get(iVal).toString()
                    + "<br> ExpectedValue : At row number " + s2 + ":\"" + tempEvaluate.get(iVal + 1).toString()
                    + "<br> ExpectedValue : At row number " + s3 + ":\"" + tempEvaluate.get(iVal + 2).toString()
                    + "<br> ExpectedValue : At row number " + s4 + ":\"" + tempEvaluate.get(iVal + 3).toString()

                    + "<br> ********************Act Values till 4 rows**********************"
                    + "<br> ActualValue : At row number " + s1 + ":\"" + listToEvaluate.get(iVal).toString()
                    + "<br> ActualValue : At row number " + s2 + ":\"" + listToEvaluate.get(iVal + 1).toString()
                    + "<br> ActualValue : At row number " + s3 + ":\"" + listToEvaluate.get(iVal + 2).toString()
                    + "<br> ActualValue : At row number " + s4 + ":\"" + listToEvaluate.get(iVal + 3).toString()

                    + "<br>==================================================================================================";
        } else if ((tempEvaluate.size() - iVal) == 4) {
            int row1 = iVal + 1;
            int row2 = iVal + 2;
            int row3 = iVal + 3;


            String s1 = Integer.toString(row1);
            String s2 = Integer.toString(row2);
            String s3 = Integer.toString(row3);


            finalVal = "The sorting order is not in ascending order for "
                    + logicalName
                    + "<br>=================================================================================================="
                    + "<br> Sorting got broked On page no: " + pageNumber + " at row number " + s1 + ". Details of the values are as below."
                    + "<br> ********************Expected Values till 3 rows**********************"
                    + "<br> ExpectedValue : At row number " + s1 + ":\"" + tempEvaluate.get(iVal).toString()
                    + "<br> ExpectedValue : At row number " + s2 + ":\"" + tempEvaluate.get(iVal + 1).toString()
                    + "<br> ExpectedValue : At row number " + s3 + ":\"" + tempEvaluate.get(iVal + 2).toString()


                    + "<br> ********************Act Values till 3 rows**********************"
                    + "<br> ActualValue : At row number " + s1 + ":\"" + listToEvaluate.get(iVal).toString()
                    + "<br> ActualValue : At row number " + s2 + ":\"" + listToEvaluate.get(iVal + 1).toString()
                    + "<br> ActualValue : At row number " + s3 + ":\"" + listToEvaluate.get(iVal + 2).toString()


                    + "<br>==================================================================================================";
        } else if ((tempEvaluate.size() - iVal) == 3) {
            int row1 = iVal + 1;
            int row2 = iVal + 2;
            int row3 = iVal + 3;


            String s1 = Integer.toString(row1);
            String s2 = Integer.toString(row2);
            String s3 = Integer.toString(row3);


            finalVal = "The sorting order is not in ascending order for "
                    + logicalName
                    + "<br>=================================================================================================="
                    + "<br> Sorting got broked On page no: " + pageNumber + " at row number " + s1 + ". Details of the values are as below."
                    + "<br> ********************Expected Values till 3 rows**********************"
                    + "<br> ExpectedValue : At row number " + s1 + ":\"" + tempEvaluate.get(iVal).toString()
                    + "<br> ExpectedValue : At row number " + s2 + ":\"" + tempEvaluate.get(iVal + 1).toString()
                    + "<br> ExpectedValue : At row number " + s3 + ":\"" + tempEvaluate.get(iVal + 2).toString()


                    + "<br> ********************Act Values till 3 rows**********************"
                    + "<br> ActualValue : At row number " + s1 + ":\"" + listToEvaluate.get(iVal).toString()
                    + "<br> ActualValue : At row number " + s2 + ":\"" + listToEvaluate.get(iVal + 1).toString()
                    + "<br> ActualValue : At row number " + s3 + ":\"" + listToEvaluate.get(iVal + 2).toString()


                    + "<br>==================================================================================================";
        } else if ((tempEvaluate.size() - iVal) == 2) {
            int row1 = iVal + 1;
            int row2 = iVal + 2;


            String s1 = Integer.toString(row1);
            String s2 = Integer.toString(row2);


            finalVal = "The sorting order is not in ascending order for "
                    + logicalName
                    + "<br>=================================================================================================="
                    + "<br> Sorting got broked On page no: " + pageNumber + " at row number " + s1 + ". Details of the values are as below."
                    + "<br> ********************Expected Values till 2 rows**********************"
                    + "<br> ExpectedValue : At row number " + s1 + ":\"" + tempEvaluate.get(iVal).toString()
                    + "<br> ExpectedValue : At row number " + s2 + ":\"" + tempEvaluate.get(iVal + 1).toString()


                    + "<br> ********************Act Values till 2 rows**********************"
                    + "<br> ActualValue : At row number " + s1 + ":\"" + listToEvaluate.get(iVal).toString()
                    + "<br> ActualValue : At row number " + s2 + ":\"" + listToEvaluate.get(iVal + 1).toString()


                    + "<br>==================================================================================================";
        }
        return finalVal;
    }

    public void verifySortingOrder(String ascLocator, String descLocator, String colLocator) throws ConfigurationException {
        navToFirstPage();
        verifyASCSortingOrderStringInGrid(ascLocator, colLocator);
        navToFirstPage();
        verifyDESCSortingOrderStringInGrid(descLocator, colLocator);
    }

    public void verifyDateSortingOrder(String ascLocator, String descLocator, String colLocator, String dateFormatVal) throws ConfigurationException, ParseException {
        navToFirstPage();
        verifyDateASCSortingOrderStringInGrid(ascLocator, colLocator, dateFormatVal);
        navToFirstPage();
        verifyDateDESCSortingOrderStringInGrid(descLocator, colLocator, dateFormatVal);
    }

    public void verifyDateNStrSortingOrder(String ascLocator, String descLocator, String colLocator, String dateFormatVal) throws ConfigurationException, ParseException {
        navToFirstPage();
        verifyDateStrASCSortingOrderStringInGrid(ascLocator, colLocator, dateFormatVal);
        navToFirstPage();
        verifyDateStrDescSortingOrderStringInGrid(descLocator, colLocator, dateFormatVal);
    }

//verifyDateStrASCSortingOrderStringInGrid

    public void navToFirstPage() throws ConfigurationException {
        String s = getText(sessActPageNumberActive_xpath);
        int activePageNumber = Integer.parseInt(s);
        int diff = activePageNumber - 1;
        if (diff > 0) {
            for (int iVal = 0; iVal < diff; iVal++) {
                click(sessActPageNavitationLeft_xpath);
            }

        }

    }

    public void verifyDESCSortingOrderStringInGrid(String descOrderlocatorKey, String colLocatorKey) throws ConfigurationException {
        List<String> orgEntireCoLDate = getColDataInTable(colLocatorKey);
        Collections.sort(orgEntireCoLDate, Collections.reverseOrder());
        navToFirstPage();
        jsclick(descOrderlocatorKey);
        List<String> actEntireColDate = getColDataInTable(colLocatorKey);
        int iCounterVal = 0;
        for (int iVal = 0; iVal < orgEntireCoLDate.size(); iVal++) {
            if (!actEntireColDate.get(iVal).toString().equalsIgnoreCase(orgEntireCoLDate.get(iVal).toString())) {

                String statementToLog = sortingFailureStatementVal(orgEntireCoLDate, actEntireColDate, iVal, colLocatorKey.split("_")[0], "Descending");
                logFailWithOutScreenshot(statementToLog);
                iCounterVal = iCounterVal + 1;
                break;

            }
        }
        if (iCounterVal == 0) {
            logPass(colLocatorKey.split("_")[0] + " got sorted in descending order successfully.");
        }

    }


    public void verifyDateDESCSortingOrderStringInGrid(String descOrderlocatorKey, String colLocatorKey, String dateFormatVal) throws ConfigurationException, ParseException {
        List<String> orgEntireCoLDate = getColDataInTable(colLocatorKey);
        List<Date> orgEntireColDateVal = new ArrayList<Date>();
        for (String element : orgEntireCoLDate) {
            if (element.equalsIgnoreCase("")) {
                orgEntireColDateVal.add(null);
            } else {
                orgEntireColDateVal.add(convertTheStringDateIntoDate(element, dateFormatVal));
            }
        }
        Collections.sort(orgEntireColDateVal, Collections.reverseOrder());
        navToFirstPage();
        jsclick(descOrderlocatorKey);
        List<String> actEntireColDate = getColDataInTable(colLocatorKey);
        List<Date> actEntireColDateVal = new ArrayList<>();
        for (String element : actEntireColDate) {
            actEntireColDateVal.add(convertTheStringDateIntoDate(element, dateFormatVal));
        }
        int iCounterVal = 0;
        for (int iVal = 0; iVal < orgEntireCoLDate.size(); iVal++) {
            if (!actEntireColDateVal.get(iVal).toString().equalsIgnoreCase(orgEntireColDateVal.get(iVal).toString())) {

                String statementToLog = sortingDateFailureStatementVal(orgEntireColDateVal, actEntireColDateVal, iVal, colLocatorKey.split("_")[0], "Descending");
                logFailWithOutScreenshot(statementToLog);
                iCounterVal = iCounterVal + 1;
                break;

            }
        }
        if (iCounterVal == 0) {
            logPass(colLocatorKey.split("_")[0] + " got sorted in descending order successfully.");
        }
    }

    public String getEntireTableCountForCol() throws ConfigurationException {
        String s = getText(totalRowCntTxt_xpath).split("of")[1].trim();
        return s;
    }

    public void verifyHostVal(List<String> listFinal, String locatorOfHostDropdown, String expValLocator, String actValLocator) throws ConfigurationException {
        int i = 1;

        setPropertyVal(expValLocator, getText(locatorOfHostDropdown));
        for (String val : listFinal) {
            if(val.contains(" "))
            {
                setPropertyVal(actValLocator, val.toString());
                String strTemp = "false";
                if(val.toString().split(" ")[0].equalsIgnoreCase(getPropertyVal(expValLocator).split(" ")[0]))
                {
                    strTemp ="true";
                }
                else if(val.toString().split(" ")[0].contains(getPropertyVal(expValLocator).split(" ")[0]))
                {
                    strTemp="true";
                }
                else if(getPropertyVal(expValLocator).toString().split(" ")[0].contains(val.split(" ")[0]))
                {
                    strTemp="true";
                }
                if (strTemp.equalsIgnoreCase("false")) {

                        i = i + 1;
                    break;
                }

            }
            else
            {
                setPropertyVal(actValLocator, val.toString());
                if (!val.toString().equalsIgnoreCase(getPropertyVal(expValLocator))) {
                    if (!getPropertyVal(expValLocator).toLowerCase().contains(val.toLowerCase()))
                        i = i + 1;
                    break;
                }



            }

        }
        if (i > 1) {
            test.fail("After selecting the value - " + getPropertyVal(expValLocator) + " in Host Dropdown, then, the " + getPropertyVal(expValLocator) + " related records did NOT get populated in table and broken at " + i + "row number.");
        } else {
            test.pass(("After selecting the value - " + getPropertyVal(expValLocator) + " in Host Dropdown, then, the " + getPropertyVal(expValLocator) + " related records got populated in table."));
        }
    }

    public void verifyDataInGridAfterHostSel() throws ConfigurationException {
        if (getEntireTableCountForCol().equalsIgnoreCase("0")) {
            verifyNoDataValueInSessActTable();
        } else {
            click(sessionActivityhostDropDown_xpath);
            for (int i = 1; i <= getDropDownItemsCount(sessionActivityhostDropDownList_xpath); i++) {
                String s = Integer.toString(i);
                setPropertyVal(hostDropDownList_xpath2, s);
                jsclick(hostDropDownItem_xpath);
                List<String> listFinal = getColDataInTable(sessionActivityHostCol_xpath);
                verifyHostVal(listFinal, hostDropDownValue_xpath, expectedHostVal_value, actualHostVal_value);
                verifyAfterRemovingHostInDrpDown();
            }
        }
    }

    public void verifyAfterRemovingHostInDrpDown() throws ConfigurationException {
        click(removeHostInDropDown_xpath);
        if (!isElementPresent(hostDropDownValue_xpath)) {
            logPass("Host selection got removed and Select any one option got displayed.");
        } else {
            logFail("Host selection did NOT get removed and Select any one option did NOT get displayed.");
        }
    }

    public void verifyDataCountInGridDuringRightNav(String rowsPerPageVal) throws ConfigurationException {
        if (getEntireTableCountForCol().equalsIgnoreCase("0")) {
            verifyNoDataValueInSessActTable();
        } else {
            int val = 0;
            if (getPropertyVal(rowsPerPageVal).equalsIgnoreCase("twentyFive")) {
                click(twentyFiveRowsPerPageElement_xpath);
                val = 25;
            } else if (getPropertyVal(rowsPerPageVal).equalsIgnoreCase("fifty")) {
                click(fiftyRowsPerPageElement_xpath);
                val = 50;
            } else {
                click(hundredRowsPerPageElement_xpath);
                val = 100;
            }
            int rowCountPerPage = getSessionActTableRowsCount();
            int fullCountVal = Integer.parseInt(getEntireTableCountForCol());

            if (rowCountPerPage < val) {
                if (rowCountPerPage == fullCountVal) {
                    String s = Integer.toString(val);
                    logPass("In the first page only, the total no of rows are less than " + s + " and all rows got displayed.");
                } else {
                    String s = Integer.toString(val);
                    logFail("In the first page only, the total no of rows are less than " + s + " and all rows did NOT get displayed.");
                }
            } else if (rowCountPerPage == val) {
                int iCounter = 0;
                int i = 0;
                int sumOfRows = 0;
                int tempNo = fullCountVal / val;
                int tempDiff = fullCountVal - (tempNo * val);
                int navFinalCount = 0;
                if (tempDiff > 0) {
                    navFinalCount = tempNo;
                } else {
                    navFinalCount = tempNo - 1;
                }


                //while (!getAttributeVal(navRghtEnbDisbl_xpath, "class").toString().equalsIgnoreCase(getPropertyVal(navDisbl_clssval)))
                for (int jVal = 0; jVal < navFinalCount; jVal++) {
                    rowCountPerPage = getSessionActTableRowsCount();
                    sumOfRows = sumOfRows + rowCountPerPage;
                    i = i + 1;

                    if (rowCountPerPage != val) {
                        iCounter = iCounter + 1;
                        break;
                    }
                    click(navRightArrowButton_xpath);
                }
                rowCountPerPage = getSessionActTableRowsCount();
                sumOfRows = sumOfRows + rowCountPerPage;
                if (rowCountPerPage > val) {
                    iCounter = iCounter + 1;
                    i = i + 1;
                }
                if (iCounter > 0) {
                    String s = Integer.toString(val);
                    logFail(s + " rows per page did NOT get displayed and got broken on " + i + " page.");
                } else {
                    if (sumOfRows == fullCountVal) {
                        String s = Integer.toString(val);
                        logPass(s + " rows got displayed per page and all rows got displayed with navigation.");
                    } else {
                        String s = Integer.toString(val);
                        logFail(s + " rows got displayed per page but all rows did NOT got displayed with navigation.");
                    }
                }
            } else {
                String s = Integer.toString(val);
                logFail("More than " + s + " no of rows got displayed in the first page.");
            }


        }
    }

    public Date convertTheStringDateIntoDate(String dateVal, String dateFormatVal) throws ParseException {
        SimpleDateFormat originalDateFormat = new SimpleDateFormat(dateFormatVal);
        Date date1 = originalDateFormat.parse(dateVal);
        return date1;
    }

    public Date convertTheStringDateIntoAnotherDateFormat(String dateVal, String dateFormatVal) throws ParseException {
        SimpleDateFormat originalDateFormat = new SimpleDateFormat(dateFormatVal);
        Date date1 = originalDateFormat.parse(dateVal);
        return date1;
    }

    public int getDayNumberInMonth(String dateVal, String dateFormatVal) throws ParseException {
        SimpleDateFormat originalDateFormat = new SimpleDateFormat(dateFormatVal);
        Date date1 = originalDateFormat.parse(dateVal);
        Calendar cal = Calendar.getInstance();
        cal.setTime(date1);
        int dayNumberVal = cal.get(Calendar.DAY_OF_MONTH);
        return dayNumberVal;
    }

    public int getDayNumberInWeek(String dateVal, String dateFormatVal) throws ParseException {
        SimpleDateFormat originalDateFormat = new SimpleDateFormat(dateFormatVal);
        Date date1 = originalDateFormat.parse(dateVal);
        Calendar cal = Calendar.getInstance();
        cal.setTime(date1);
        int dayNumberVal = cal.get(Calendar.DAY_OF_WEEK);
        return dayNumberVal;
    }

    public int getWeekNumberInMonth(String dateValue, String dateFormatValue) throws ParseException {
        //SimpleDateFormat sdf = new SimpleDateFormat("EEE MMMM dd, yyyy hh:mm a");
        SimpleDateFormat sdf = new SimpleDateFormat(dateFormatValue);
        Date dateVal = sdf.parse(dateValue);
        Calendar cal = Calendar.getInstance();
        cal.setTime(dateVal);

        int week = cal.get(Calendar.WEEK_OF_MONTH);

        return week;
    }

    public int getMonthNumberInYear(String dateValue, String dateFormatValue) throws ParseException {
        //SimpleDateFormat sdf = new SimpleDateFormat("EEE MMMM dd, yyyy hh:mm a");
        SimpleDateFormat sdf = new SimpleDateFormat(dateFormatValue);
        Date dateVal = sdf.parse(dateValue);
        Calendar cal = Calendar.getInstance();
        cal.setTime(dateVal);
        int monthVal = cal.get(Calendar.MONTH);
        return monthVal;
    }

    public int getCurrentDateMonthNumber() {
        Date d1 = new Date();
        Calendar cl = Calendar.getInstance();
        cl.setTime(d1);
        int currentMonthNumber = cl.get(Calendar.MONTH);
        return currentMonthNumber;
    }

    public int getCurrentWeekMonthNumber() {
        Date d1 = new Date();
        Calendar cl = Calendar.getInstance();
        cl.setTime(d1);
        int currentWeekNumber = cl.get(Calendar.WEEK_OF_MONTH);
        return currentWeekNumber;
    }

    public int getCurrentDayNumber() {
        Date d1 = new Date();
        Calendar cl = Calendar.getInstance();
        cl.setTime(d1);
        int currentDayNumber = cl.get(Calendar.DAY_OF_MONTH);
        return currentDayNumber;
    }

    public void verifyImageDownloadforPages(int noOfPages) throws ConfigurationException, IOException, CsvValidationException {
        int pageNumberVal = 1;
        for (int iValRight = 1; iValRight <= noOfPages; iValRight++) {
            for (int iRowVal = 1; iRowVal <= getElements(sessActImgRows_xpath).size(); iRowVal++) {
                for (int iValue = 1; iValue <= getElements(sessActImgDownloadButtons_xpath).size(); iValue++) {
                    deleteALLFilesInDownload();
                    setPropertyVal(sessActImgRow_val, Integer.toString(iRowVal));
                    setPropertyVal(sessActImgDownloadButtons_xpath2, Integer.toString(iValue));
                    click(sessActImgDownloadButton_xpath);
                    wait(100);
                    verifyWhetherImageIsDownloaded(Integer.toString(pageNumberVal), Integer.toString(iRowVal), Integer.toString(iValue));
                }
            }
            click(navRightArrowButton_xpath);
            pageNumberVal = pageNumberVal + 1;
        }
    }

    public void verifyImageDownloadFromTableGrid() throws IOException, ConfigurationException, CsvValidationException {
        int totalCountVal = Integer.parseInt(getEntireTableCountForCol());
        if (totalCountVal == 0) {
            verifyNoDataValueInSessActTable();
        } else if (totalCountVal > 0) {
            int rowsPerPage = 25;
            int noOfPages = totalCountVal / rowsPerPage;
            int diffVal = totalCountVal - noOfPages;
            int pageNumberVal = 1;
            if (diffVal > 0) {
                verifyImageDownloadforPages(noOfPages);
            } else if (diffVal == 0) {
                verifyImageDownloadforPages(noOfPages - 1);
            }
        }
    }

    public void verifyTodayInSessActivityTable() throws ConfigurationException, ParseException {
        List<String> startTimeVals = getColDataInTable(sessActivityTableStartTime_xpath);
        if (startTimeVals.size() > 0) {
            int iCounterVal = 0;
            int iValue = 0;
            for (String startTimeVal : startTimeVals) {
                int todayNumberFromGrid = getDayNumberInMonth(startTimeVal, getPropertyVal(tableStartTimeDateFormat_Val));
                int currentDayNumber = getCurrentDayNumber();
                if (todayNumberFromGrid != currentDayNumber) {
                    iCounterVal = iCounterVal + 1;
                    iValue = iValue + 1;
                    break;

                }
            }
            if (iCounterVal == 0) {
                logPass("Data in the grid got populated in today range.");
            } else {
                iValue = iValue + 1;
                logFail("Data in the grid did NOT populated in today range and the failure is observed at row no - ." + iValue);
            }
        }
    }

    public void logExceptionFailure(Exception e) {
        logFail("This test got failed due to exception" + e.getMessage());
    }

    public void verifyThisWeekRangeInSessActivityTable() throws ConfigurationException, ParseException {
        List<String> startTimeVals = getColDataInTable(sessActivityTableStartTime_xpath);
        int iCounterVal = 0;
        int iValue = 0;
        for (String startTimeVal : startTimeVals) {
            int weekNumberFromGrid = getWeekNumberInMonth(startTimeVal, getPropertyVal(tableStartTimeDateFormat_Val));
            int currentWeekNumber = getCurrentWeekMonthNumber();
            if(weekNumberFromGrid==currentWeekNumber)
            {
                iCounterVal = iCounterVal + 1;
            }
            //if (weekNumberFromGrid != currentWeekNumber) {
            //    iCounterVal = iCounterVal + 1;
           //     iValue = iValue + 1;
            //    break;

           // }
        }
        if (iCounterVal > 0) {
            logPass("Data in the grid got populated in this week range.");
        } else {
            iValue = iValue + 1;
            logFail("Data in the grid did NOT populated in this week range and the failure is observed at row no - ." + iValue);
        }
    }

    public void verifyThisMonthRangeInSessActivityTable() throws ConfigurationException, ParseException {
        List<String> startTimeVals = getColDataInTable(sessActivityTableStartTime_xpath);
        int iCounterVal = 0;
        int iValue = 0;
        for (String startTimeVal : startTimeVals) {
            int monthNumberFromGrid = getMonthNumberInYear(startTimeVal, getPropertyVal(tableStartTimeDateFormat_Val));
            int currentMonthNumber = getCurrentDateMonthNumber();
            if (monthNumberFromGrid != currentMonthNumber) {
                iCounterVal = iCounterVal + 1;
                iValue = iValue + 1;
                break;

            }
        }
        if (iCounterVal == 0) {
            logPass("Data in the grid got populated in this month range.");
        } else {
            iValue = iValue + 1;
            logFail("Data in the grid did NOT populated in this month range and the failure is observed at row no - ." + iValue);
        }
    }

    public void selectFromDate() throws ConfigurationException, ParseException {
        click(fromDateCalenderButt_xpath);
        String dateValFromCalender = getText(monthAndYerValFrom_xpath);
        SimpleDateFormat originalDateFormat = new SimpleDateFormat("dd/MM/yyyy");
        SimpleDateFormat targetFormat = new SimpleDateFormat("MMMM yyyy");
        Date date1 = originalDateFormat.parse(getPropertyVal(fromDate_Val));
        String formattedDate = targetFormat.format(date1);
        Date date2 = targetFormat.parse(formattedDate);
        Date date3 = targetFormat.parse(dateValFromCalender);
        int val = date2.compareTo(date3);
        Calendar cal = Calendar.getInstance();
        cal.setTime(date2);
        int month1 = cal.get(Calendar.MONTH);
        cal.setTime(date3);
        int month2 = cal.get(Calendar.MONTH);
        int year1 = Integer.parseInt(formattedDate.split(" ")[1]);
        int year2 = Integer.parseInt(dateValFromCalender.split(" ")[1]);


        if (val < 0) {
            int noOfYears = year2 - year1;
            int noOfMonths1 = noOfYears * 11;
            int month2Val = noOfMonths1 + month2;
            int finalDiff = month2Val - month1;
            int finalDiffVal = finalDiff + noOfYears;

            for (int j = 0; j < finalDiffVal; j++) {
                jsclick(fromDatePickerPrev_xpath);
            }
        } else if (val > 0) {
            int noOfMonths = month1 - month2;
            for (int j = 0; j < noOfMonths; j++)
            //while(!getText(monthAndYerValFrom_xpath).equalsIgnoreCase(formattedDate))
            {
                click(fromDatePickerNext_xpath);
            }
        }

        SimpleDateFormat originalDateFormatVal = new SimpleDateFormat("dd/MM/yyyy");
        SimpleDateFormat targetFormatVal = new SimpleDateFormat("MMMM dd");
        Date dateVal1 = originalDateFormatVal.parse(getPropertyVal(fromDate_Val));
        String formattedDateVal = targetFormatVal.format(dateVal1);
        if (formattedDateVal.contains("01") || formattedDateVal.contains("02") || formattedDateVal.contains("03") || formattedDateVal.contains("04") || formattedDateVal.contains("05") || formattedDateVal.contains("06") || formattedDateVal.contains("07") || formattedDateVal.contains("08") || formattedDateVal.contains("09")) {
            setPropertyVal("selDateInFromDate_xpath2", formattedDateVal.replace("0", ""));
        } else {
            setPropertyVal("selDateInFromDate_xpath2", formattedDateVal);
        }
        jsclick(selDateInFromDate_xpath);
        if (getAttributeVal(fromDataTxtBox_xpath, "value").toString().equalsIgnoreCase(getPropertyVal(fromDate_Val))) {
            logPass("Successfully selected the date - " + getPropertyVal(fromDate_Val) + ", in From date.");
        } else {
            logFail("Failed to select the date - " + getPropertyVal(fromDate_Val) + ", in From date.");
        }
    }

    public void selectToDate() throws ConfigurationException, ParseException {
        click(toDateCalenderButt_xpath);
        String dateValFromCalender = getText(monthAndYerValTo_xpath);
        SimpleDateFormat originalDateFormat = new SimpleDateFormat("dd/MM/yyyy");
        SimpleDateFormat targetFormat = new SimpleDateFormat("MMMM yyyy");
        Date date1 = originalDateFormat.parse(getPropertyVal(toDate_Val));
        String formattedDate = targetFormat.format(date1);
        Date date2 = targetFormat.parse(formattedDate);
        Date date3 = targetFormat.parse(dateValFromCalender);
        int val = date2.compareTo(date3);
        Calendar cal = Calendar.getInstance();
        cal.setTime(date2);
        int month1 = cal.get(Calendar.MONTH);
        cal.setTime(date3);
        int month2 = cal.get(Calendar.MONTH);
        int year1 = Integer.parseInt(formattedDate.split(" ")[1]);
        int year2 = Integer.parseInt(dateValFromCalender.split(" ")[1]);
        if (val < 0) {
            //while(!getText(monthAndYerValTo_xpath).equalsIgnoreCase(formattedDate))
            int noOfYears = year2 - year1;
            int noOfMonths1 = noOfYears * 11;
            int month2Val = noOfMonths1 + month2;
            int finalDiff = month2Val - month1;
            int finalDiffVal = finalDiff + noOfYears;

            for (int j = 0; j < finalDiffVal; j++) {
                jsclick(toDatePickerPrev_xpath);
            }
        } else if (val > 0) {
            while (!getText(monthAndYerValTo_xpath).equalsIgnoreCase(formattedDate)) {
                click(toDatePickerNext_xpath);
            }
        }

        // int i = Integer.parseInt(getPropertyVal(toDate_Val).split("/")[0]);
        //  String s= Integer.toString(i);
        SimpleDateFormat originalDateFormatVal = new SimpleDateFormat("dd/MM/yyyy");
        SimpleDateFormat targetFormatVal = new SimpleDateFormat("MMMM dd");
        Date dateVal1 = originalDateFormatVal.parse(getPropertyVal(toDate_Val));
        String formattedDateVal = targetFormatVal.format(dateVal1);
        if (formattedDateVal.contains("01") || formattedDateVal.contains("02") || formattedDateVal.contains("03") || formattedDateVal.contains("04") || formattedDateVal.contains("05") || formattedDateVal.contains("06") || formattedDateVal.contains("07") || formattedDateVal.contains("08") || formattedDateVal.contains("09")) {
            setPropertyVal("selDateInToDate_xpath2", formattedDateVal.replace("0", ""));
        } else {
            setPropertyVal("selDateInToDate_xpath2", formattedDateVal);
        }

        jsclick(selDateInToDate_xpath);
        if (getAttributeVal(toDataTxtBox_xpath, "value").toString().equalsIgnoreCase(getPropertyVal(toDate_Val))) {
            logPass("Successfully selected the date - " + getPropertyVal(toDate_Val) + ", in to date.");
        } else {
            logFail("Failed to select the date - " + getPropertyVal(toDate_Val) + ", in to date.");
        }
    }


    public void selFromDateAndToDateAsCurrDte() throws ConfigurationException, ParseException {
        selectFromDate();
        SimpleDateFormat formatter = new SimpleDateFormat(getPropertyVal(dateFormatInApplication_Val));
        Date date1 = new Date();
        String formattedDate = formatter.format(date1);
        setPropertyVal(toDate_Val, formattedDate);
        selectToDate();
        jsclick(custDateSearchBtn_xpath);
    }

    public void verifySessPageTitle(String propVal) throws ConfigurationException {
        if (getText(sessPageTitle_xpath).equalsIgnoreCase(getPropertyVal(propVal))) {
            logPass("\"" + getPropertyVal(propVal) + "\" got displayed.");
        } else {
            logFail("\"" + getPropertyVal(propVal) + "\" did NOT get displayed.");
        }
    }


//****************************************************************************************************************

    //************************************************************************************************************
    public String getPropertyVal(String locatorKey) throws ConfigurationException {
        String propertyVal = config1.getString(locatorKey);
        return propertyVal;
    }

    public String[] getPropertyVals(String locatorKey) throws ConfigurationException {
      /*  String mainExecPropPath=System.getProperty("user.dir")+"\\src\\test\\propFiles\\objectRepo.properties";
        org.apache.commons.configuration2.builder.fluent.Parameters params = new org.apache.commons.configuration2.builder.fluent.Parameters();
        FileBasedConfigurationBuilder<FileBasedConfiguration> builder =
                new FileBasedConfigurationBuilder<FileBasedConfiguration>(PropertiesConfiguration.class)
                        .configure(params.properties()
                                .setFileName(mainExecPropPath));

        Configuration config = builder.getConfiguration();
       // CompositeConfiguration config1 = new CompositeConfiguration();
        config1.addConfiguration(new SystemConfiguration());
        config1.addConfiguration(config);
        //config1.setProperty("langValue","Spanish");*/

        String[] propertyVal = config1.getStringArray(locatorKey);
        return propertyVal;
    }
//****************************************************************************************************************************************

    //****************************************************************************************************************************************
    public void setPropertyVal(String locatorKey, String valToSet) {
        try {
       /*String mainExecPropPath = System.getProperty("user.dir") + "\\src\\test\\propFiles\\objectRepo.properties";
       org.apache.commons.configuration2.builder.fluent.Parameters params = new org.apache.commons.configuration2.builder.fluent.Parameters();
       FileBasedConfigurationBuilder<FileBasedConfiguration> builder =
               new FileBasedConfigurationBuilder<FileBasedConfiguration>(PropertiesConfiguration.class)
                       .configure(params.properties()
                               .setFileName(mainExecPropPath));

       Configuration config = builder.getConfiguration();
       CompositeConfiguration config2 = new CompositeConfiguration();
       config2.addConfiguration(new SystemConfiguration());
       config2.addConfiguration(config);*/
            config1.setProperty(locatorKey, valToSet);
        } catch (Exception e) {
            logFail("Could not able to set the value for the property key");
        }
        //String propertyVal= config1.getString(locatorKey);
        // return propertyVal;
    }

    //****************************************************************************************************************************************
    public CompositeConfiguration getCompositeConfigVal(String execPathVal) throws ConfigurationException {
        String mainExecPropPath = execPathVal;
        org.apache.commons.configuration2.builder.fluent.Parameters params = new org.apache.commons.configuration2.builder.fluent.Parameters();
        FileBasedConfigurationBuilder<FileBasedConfiguration> builder =
                new FileBasedConfigurationBuilder<FileBasedConfiguration>(PropertiesConfiguration.class)
                        .configure(params.properties()
                                .setFileName(mainExecPropPath));

        Configuration config = builder.getConfiguration();
        CompositeConfiguration config2 = new CompositeConfiguration();
        config2.addConfiguration(new SystemConfiguration());
        config2.addConfiguration(config);
        return config2;
    }

    public String[] getLocaleLangs(String methodNameVal) throws ConfigurationException {
        String[] langs = getPropertyVal(methodNameVal).split(",");
        return langs;
    }

    public void navigateToUserSessionActivity() throws ConfigurationException {
        if (getPropertyVal("role").contains("user")) {
            driverWaitClick("Analytics_xpath");
            wait(50);
            if (!isElementVisible("UserAnalyticsSessionActivity_xpath")) {
                driverWaitClick("Analytics_xpath");
                wait(50);
            }
            wait(10);
            click("UserAnalyticsSessionActivity_xpath");
            wait(50);
        }
         else {
            driverWaitClick("Analytics_xpath");
            wait(50);
            if (!isElementVisible("adminAnalyticsSessionActivity_xpath")) {
                driverWaitClick("Analytics_xpath");
            }
            wait(10);
            click("adminAnalyticsSessionActivity_xpath");
            wait(50);
        }


    }




    public void setExceptionValToN()
    {

        this.exceptionVal = "n";

    }

    public void setExceptionValToY() {
        this.exceptionVal = "y";
    }

    public String getExceptionVal() {
        return this.exceptionVal;
    }
//***********************************************************************************************************
//validation logics

    public void compareTwoEqualValues(String expectedVal, String actualVal) throws ConfigurationException, ConfigurationException {
        if (getPropertyVal(expectedVal).toString().equalsIgnoreCase(getPropertyVal(actualVal))) {
            logPass("Expected value for \"" + expectedVal.split("_")[0] + "\" is :\"" + getPropertyVal(expectedVal) + "\" which is same as that of the actual value i.e, \"" + getPropertyVal(actualVal) + "\"");
        } else {
            logFail("Expected value for \"" + expectedVal.split("_")[0] + "\" is :\"" + getPropertyVal(expectedVal) + "\" which is NOT same as as that of the actual value i.e, \"" + getPropertyVal(actualVal) + "\"");
        }
    }


    public void compareTwoNOTEqualValues(String var1, String var2) throws ConfigurationException {
        if (!getPropertyVal(var1).toString().equalsIgnoreCase(getPropertyVal(var2))) {
            logPass(var1 + " is not same as that of " + var2);
        } else {
            logFail(var1 + " is same as that of " + var2);
        }
    }

    public void verifyTheTextToDisplay(String elementVal, String expectedVar, String actualVar) throws ConfigurationException {
        if (getPropertyVal(actualVar).toString().equalsIgnoreCase(getPropertyVal(expectedVar))) {
            logPass("Expected value to be displayed on the " + elementVal.split("_")[0] + " is \"" + getPropertyVal(expectedVar) + "\" which is the same as that of, the actual value which got displayed i.e.: \"" + getPropertyVal(actualVar) + "\"");

        } else {
            logFail("Expected value to be displayed on the " + elementVal.split("_")[0] + " is \"" + getPropertyVal(expectedVar) + "\" which is NOT the same as that of, the actual value which got displayed i.e.: \"" + getPropertyVal(actualVar) + "\"");
        }
    }

    public void verifyTheTextNOTToDisplay(String elementVal, String expectedVar, String actualVar) throws ConfigurationException {
        if (!getPropertyVal(actualVar).toString().equalsIgnoreCase(getPropertyVal(expectedVar))) {
            logPass("Expected value to be displayed on the " + elementVal + " is \"" + getPropertyVal(expectedVar) + "\" which is the same as that of, the actual value which got displayed i.e.: \"" + getPropertyVal(actualVar) + "\"");

        } else {
            logFail("Expected value to be displayed on the " + elementVal + " is \"" + getPropertyVal(expectedVar) + "\" which is NOT the same as that of, the actual value which got displayed i.e.: \"" + getPropertyVal(actualVar) + "\"");
        }
    }

//***********************************************************************************************************

    public void setPropFilePath(String propFileName) throws ConfigurationException {
        this.config1 = getCompositeConfigVal(propFilesFolderPath + propFileName);
    }

    public void setApplPropFilePath(String propFileName) throws ConfigurationException {
        this.config1 = getCompositeConfigVal(propFilesFolderPath + "applicationObjectProperties\\" + propFileName);
    }

    public void setLocalePropFilePath(String propFileName) throws ConfigurationException {
        this.config1 = getCompositeConfigVal(propFilesFolderPath + "localizationProperties\\" + propFileName);
    }
    //***********************************************************************************************************

    public void ImageDownload(String imgDownloadBtnKey) throws ConfigurationException, AWTException {
        List<WebElement> sessionImagesList = getElements(imgDownloadBtnKey);
        for (WebElement sessImg : sessionImagesList) {
//               click(sessImg);
//                saveUsingRobotclass();
//                saveUsingRobotclass();
        }
//        }
    }

    public String getAlphaNumericString(int n) {
        int lowerLimit = 97;
        int upperLimit = 122;
        Random random = new Random();
        StringBuffer r = new StringBuffer(n);
        for (int i = 0; i < n; i++) {
            int nextRandomChar = lowerLimit
                    + (int) (random.nextFloat()
                    * (upperLimit - lowerLimit + 1));
            r.append((char) nextRandomChar);
        }
        return r.toString();
    }

    public void saveUsingRobotclass() throws AWTException {

        StringSelection str = new StringSelection(getAlphaNumericString(5));
        Toolkit.getDefaultToolkit().getSystemClipboard().setContents(str, null);
        Robot robot = new Robot();
       /* robot.keyPress(KeyEvent.VK_ENTER);
        robot.keyRelease(KeyEvent.VK_ENTER);*/
        robot.keyPress(KeyEvent.VK_CONTROL);
        robot.keyPress(KeyEvent.VK_V);
        robot.keyRelease(KeyEvent.VK_V);
        robot.keyRelease(KeyEvent.VK_CONTROL);
        robot.keyPress(KeyEvent.VK_ENTER);
        robot.keyRelease(KeyEvent.VK_ENTER);
    }

    public int returnfileSize(File fileTmpDir) {
        File[] listOfFiles = fileTmpDir.listFiles();
        return listOfFiles.length;
    }

    public String returnfilename(File fileTmpDir) {
        File[] listOfFiles = fileTmpDir.listFiles();
        String fileName1 = null;
        for (int i = 0; i < listOfFiles.length; i++) {
            if (listOfFiles[i].isFile()) {
                System.out.println("File " + listOfFiles[i].getName());
                try {
                    fileName1 = listOfFiles[i].getName();
                } catch (Exception e) {
                }
            }
        }
        return fileName1;
    }

    public void verifyDownliadImage() throws CsvValidationException, IOException {
        String filename = getExportedFilePath();
        if (filename.contains(downloadedImage_val)) {
            logPass("One Image got downloaded");
        } else {
            logFail("No one image got downloaded");
        }
    }

    public void verifyAlertMessage(String successAlertMsg) throws ConfigurationException {
        String alertMessage = getText(successAlertMsg);
        if (alertMessage.equalsIgnoreCase(imagesSuccessAlertMsg_val)) {
            logPass("Image Uploaded Successfully");
        } else {
            logFail("Image not get Uploaded Successfully");
        }
    }

    public void textEditableOrNot(String locator, String text) throws ConfigurationException {
        List lstElmnt1 = getElements(locator);
        if (lstElmnt1.size() <= 0) {
            logPass((text) + " Text field is not editable");
        } else {
            logFail((text) + " Text field is editable");
        }
    }


    public String getlocalePath(String localeVal) {
        String localePath = "";
        if (localeVal.equalsIgnoreCase("french")) {
            localePath = System.getProperty("user.dir") + "\\src\\test\\jsonFiles\\french.json";
        } else if (localeVal.equalsIgnoreCase("italian")) {
            localePath = System.getProperty("user.dir") + "\\src\\test\\jsonFiles\\italian.json";
        }
        return localePath;
    }

    public String getLocaleKeyValue(String localeVal, String key) throws IOException, org.json.simple.parser.ParseException {
        String jsonFilePath = getlocalePath(localeVal);
        String keyVal = readJSON(jsonFilePath, key);
        return keyVal;
    }

    public void compareTwoEqualLocaleValues(String expectedValKey, String actualValue, String langValue, String logicalName) throws ConfigurationException {
        if (expectedValKey.toString().equalsIgnoreCase(actualValue)) {
            logPass("For the selected language \"" + langValue + "\" and for the element \"" + logicalName + "\" the actual value i.e. \"" + actualValue + "\" is same as that of the expected value \"" + expectedValKey + "\"");
        } else {
            logFail("For the selected language \"" + langValue + "\" and for the element \"" + logicalName + "\" the actual value i.e. \"" + actualValue + "\" is NOT same as that of the expected value \"" + expectedValKey + "\"");
        }
    }

    public void logFailWithException(String msg) {
        logFail(msg);
        throw new SkipException(msg);
    }


    public void navigateToUserSessionMap() throws ConfigurationException {
        if (getPropertyVal("role").contains("user")) {
            driverWaitClick("Analytics_xpath");
            wait(50);
            if (!isElementVisible("UserAnalyticsSessionActivity_xpath")) {

                driverWaitClick("Analytics_xpath");
                wait(50);
            }
                wait(10);
                click(userAnalyticsSessionMap_xpath);
                wait(50);
            }
        else {
                driverWaitClick("Analytics_xpath");
                wait(50);
                if (!isElementVisible("adminAnalyticsSessionMap_xpath")) {
                    driverWaitClick("Analytics_xpath");
                }
                wait(10);
                click("adminAnalyticsSessionMap_xpath");
                wait(50);
            }
        }


    public String replaceValue(String val) {
        return val.replace("“", "\"").replace("”", "\"").replace("\n", " ");
    }


    public void isElelmentEnabledorDisabled(String localeVal, String val) throws ConfigurationException {
        if (!getElement(localeVal).isEnabled()) {
            logPass(" With out edit functionality " + getPropertyVal(val) + " button got displayed and disabled");
        } else {
            logFail(" With out edit functionality " + getPropertyVal(val) + " button got displayed and Enabled");
        }

    }

    public void verifySessMapHostVal(List<String> listFinal, String expValLocator) throws ConfigurationException {
        int i = 1;
        int iRow = 0;
        int iRowVal = 0;
        int pageNumVal = 1;
        for (String val : listFinal) {
            iRow = iRow + 1;
            if (iRow % 25 == 0) {
                pageNumVal = pageNumVal + 1;
                if (iRow < 25) {
                    iRowVal = iRow;
                } else {
                    iRowVal = 25;
                }

            } else {
                iRowVal = iRow % 25;
            }
            if(expValLocator.contains(" "))
            {
                String strTemp="false";
                if(expValLocator.split(" ")[0].equalsIgnoreCase(val.split(" ")[0]))
                {
                    strTemp="true";
                }
                else if(expValLocator.split(" ")[0].contains(val.split(" ")[0]))
                {
                    strTemp="true";
                }
                else if(val.split(" ")[0].contains(expValLocator.split(" ")[0]))
                {
                    strTemp="true";
                }
                if (strTemp.equalsIgnoreCase("false")) {
                    i = i + 1;
                    break;
                }
            }
            else
            {
                if (!expValLocator.toLowerCase().contains(val.toLowerCase())) {
                    i = i + 1;
                    break;
                }
            }


        }
        if (i > 1) {
            test.fail("After selecting the value - " + expValLocator + " in Host Dropdown, then, the " + expValLocator + " related records did NOT get populated in table and broken at " + iRowVal + "row number and on page no " + pageNumVal);
        } else {
            test.pass(("After selecting the value - " + expValLocator + " in Host Dropdown, then, the " + expValLocator + " related records got populated in table."));
        }

    }


    public void veriyHostDataInSessionMap() throws ConfigurationException {

        Select s = new Select(getElement(hostDropDown_xpath));
        List<String> optionValue = new ArrayList<>();
        if (!getElement(sessMapSeeActivityInTable_xpath).isEnabled()) {
            logPass("See activity in Table is not enabled.");
        } else {
            for (int iVal = 1; iVal < s.getOptions().size(); iVal++) {
                s.selectByIndex(iVal);
                WebElement o = s.getFirstSelectedOption();
                String expVal = o.getText();
                log("Selected \"" + expVal + "\" in the hostval.");

                click(sessMapSeeActivityInTable_xpath);


                List<String> listFinal = getColDataInTable(sessMapHostCol_xpath);
                verifySessMapHostVal(listFinal, expVal);
                click(sessMapSeeActivityClose_xpath);


            }

        }

    }

    public void verifySessMapDataCountInGrid(String rowsPerPageVal) throws ConfigurationException {
        Select s1 = new Select(getElement(hostDropDown_xpath));
        if (!getElement(sessMapSeeActivityInTable_xpath).isEnabled()) {
            logPass("See activity in Table is not enabled.");
        } else {
            s1.selectByIndex(1);
            click(sessMapSeeActivityInTable_xpath);
            int val = 0;
            if (getPropertyVal(rowsPerPageVal).equalsIgnoreCase("twentyFive")) {
                click(twentyFiveRowsPerPageElement_xpath);
                val = 25;
            } else if (getPropertyVal(rowsPerPageVal).equalsIgnoreCase("fifty")) {
                click(fiftyRowsPerPageElement_xpath);
                val = 50;
            } else {
                click(hundredRowsPerPageElement_xpath);
                val = 100;
            }
            int rowCountPerPage = getSessionActTableRowsCount();
            int fullCountVal = Integer.parseInt(getEntireTableCountForCol());

            if (rowCountPerPage < val) {
                if (rowCountPerPage == fullCountVal) {
                    String s = Integer.toString(val);
                    logPass("In the first page only, the total no of rows are less than " + s + " and all rows got displayed.");
                } else {
                    String s = Integer.toString(val);
                    logFail("In the first page only, the total no of rows are less than " + s + " and all rows did NOT get displayed.");
                }
            } else if (rowCountPerPage == val) {
                int iCounter = 0;
                int i = 0;
                int sumOfRows = 0;
                int tempNo = fullCountVal / val;
                int tempDiff = fullCountVal - (tempNo * val);
                int navFinalCount = 0;
                if (tempDiff > 0) {
                    navFinalCount = tempNo;
                } else {
                    navFinalCount = tempNo - 1;
                }


                //while (!getAttributeVal(navRghtEnbDisbl_xpath, "class").toString().equalsIgnoreCase(getPropertyVal(navDisbl_clssval)))
                for (int jVal = 0; jVal < navFinalCount; jVal++) {
                    rowCountPerPage = getSessionActTableRowsCount();
                    sumOfRows = sumOfRows + rowCountPerPage;
                    i = i + 1;

                    if (rowCountPerPage != val) {
                        iCounter = iCounter + 1;
                        break;
                    }
                    click(navRightArrowButton_xpath);
                }
                rowCountPerPage = getSessionActTableRowsCount();
                sumOfRows = sumOfRows + rowCountPerPage;
                if (rowCountPerPage > val) {
                    iCounter = iCounter + 1;
                    i = i + 1;
                }
                if (iCounter > 0) {
                    String s = Integer.toString(val);
                    logFail(s + " rows per page did NOT get displayed and got broken on " + i + " page.");
                } else {
                    if (sumOfRows == fullCountVal) {
                        String s = Integer.toString(val);
                        logPass(s + " rows got displayed per page and all rows got displayed with navigation.");
                    } else {
                        String s = Integer.toString(val);
                        logFail(s + " rows got displayed per page but all rows did NOT got displayed with navigation.");
                    }
                }
            } else {
                String s = Integer.toString(val);
                logFail("More than " + s + " no of rows got displayed in the first page.");
            }
            click(sessMapSeeActivityClose_xpath);
        }


    }

    public void verifySessMapRange(String rangeVal) throws ConfigurationException, ParseException {
        Select s = new Select(getElement(hostDropDown_xpath));
        if (!getElement(sessMapSeeActivityInTable_xpath).isEnabled()) {
            logPass("See activity in Table is not enabled.");
        } else {
            s.selectByIndex(1);
            click(sessMapSeeActivityInTable_xpath);
            if (rangeVal.equalsIgnoreCase("ThisMonth")) {
                verifyThisMonthRangeInSessActivityTable();
            } else if (rangeVal.equalsIgnoreCase("ThisWeek")) {
                verifyThisWeekRangeInSessActivityTable();
            } else if (rangeVal.equalsIgnoreCase("Today")) {
                verifyTodayInSessActivityTable();
            }
            click(sessMapSeeActivityClose_xpath);
        }
    }

    public boolean clickSeeActivityInTable() throws ConfigurationException {
        Select s = new Select(getElement(hostDropDown_xpath));
        if (!getElement(sessMapSeeActivityInTable_xpath).isEnabled()) {
            logPass("See activity in Table is not enabled.");
            return false;
        } else {
            s.selectByIndex(1);
            click(sessMapSeeActivityInTable_xpath);
            return true;
        }
    }


    public void vrifyisTabDisplayedOrNot(String locator, String val) throws ConfigurationException {
        if (isElementPresent(locator)) {
            logFail(getPropertyVal(val) + " Tab is displayed");
        } else {
            logPass(getPropertyVal(val) + " Tab is not get Displayed");
        }

    }

    public void navigateToMyProfilePage() {
        driverWaitClick(myProfileBtn_xpath);

    }

    public void verifyExperiencesText() throws ConfigurationException {
        wait(20);
        if (isElementVisible(experiencesText_xpath)) {
            String experienceActVal = getText(experiencesText_xpath);
            setPropertyVal("ExperienceActVal", experienceActVal);
            setPropertyVal("experienceExpeVal", getPropertyVal(experienceText_val));
            compareTwoEqualValues("experienceExpeVal", "ExperienceActVal");
        } else if (isElementVisible(experienceBuilderText_xpath)) {
            String experienceActVal = getText(experienceBuilderText_xpath);
            setPropertyVal("ExperienceActVal", experienceActVal);
            setPropertyVal("experienceExpeVal", getPropertyVal(experienceBuilderText_val));
            compareTwoEqualValues("experienceExpeVal", "ExperienceActVal");
        }
    }

    public void navigateatoExperiencePage() throws ConfigurationException {
        String strClassVal = getAttributeVal(contentTab_xpath,"class").trim();
        if (strClassVal.equalsIgnoreCase("nav-item nav-dropdown")) {
            click(contentTab_xpath);
            click(experiencesTab_xpath);
            verifyExperiencesText();
        } else if (strClassVal.equalsIgnoreCase("nav-item nav-dropdown open")) {
            click(experiencesTab_xpath);
            verifyExperiencesText();
        } else {
            logFail("Experiences page not get openend up");
        }
    }

    public void openNewWindowTab() {
        driver.switchTo().newWindow(WindowType.TAB);

    }

    public void switchToNewWindow(int i) {
        Set<String> windows = driver.getWindowHandles();
        List<String> windowList = new ArrayList<>();
        for (String window : windows) {
            windowList.add(window);
        }
        driver.switchTo().window(windowList.get(i));
    }


    public void closeActiveWindowMoveToActiveWindow() {
        this.driver.close();
        Set<String> windows = driver.getWindowHandles();
        List<String> windowList = new ArrayList<>();
        for (String window : windows) {
            windowList.add(window);
        }
        driver.switchTo().window(windowList.get(0));
    }

    public void actionsMovetoElement(String localElement) throws ConfigurationException {
        Actions ac = new Actions(driver);
        ac.moveToElement(getElement(localElement)).build().perform();
    }


    public String getRandomNumericValue(int n) {
        int lowerLimit = 0;
        int upperLimit = 9;
        Random random = new Random();
        StringBuffer r = new StringBuffer(n);
        for (int i = 0; i < n; i++) {
            int nextRandomChar = lowerLimit
                    + (int) (random.nextFloat()
                    * (upperLimit - lowerLimit + 1));
            r.append((int) nextRandomChar);
        }
        return r.toString();
    }

    public void verifyNoMatchingDataValueInSessActTable() throws ConfigurationException {
        int fullCountVal = Integer.parseInt(getEntireTableCountForCol());
        if (fullCountVal == 0) {
            if (getText(noDataInTable_xpath).equalsIgnoreCase(getPropertyVal(noMatchingDataInTable_val) )|| getText(noDataInTable_xpath).equalsIgnoreCase(getPropertyVal(noDataInTable_val))) {
                logPass("No Matching Data got populated in the table grid.");
            } else {
                logFail("No Matching Data did NOT got populated in the table grid.");
            }
        }
    }

    public void verifySurveysText() throws ConfigurationException {
        wait(20);
        String experienceActVal = getText(surveysText_xpath);
        setPropertyVal("ExperienceActVal", experienceActVal);
        setPropertyVal("experienceExpeVal", getPropertyVal(surveysText_val));
        compareTwoEqualValues("experienceExpeVal", "ExperienceActVal");
    }

    public void navigateToSurveysBuilder() throws ConfigurationException {
        if (!isElementVisible(surveyBuilderTab_xpath)) {
            click(contentTab_xpath);
            click(surveyBuilderTab_xpath);
            verifySurveysText();
        } else if (isElementVisible(surveyBuilderTab_xpath)) {
            click(surveyBuilderTab_xpath);
            verifySurveysText();
        } else {
            logFail("Surveys page not get openend up");
        }
    }

    public void verifySurveyDataInGridAfterHostSel(int i) throws ConfigurationException {
        if (getEntireTableCountForCol().equalsIgnoreCase("0")) {
            verifyNoDataValueInSessActTable();
        } else {
            click(sessionActivityhostDropDown_xpath);
            String s = Integer.toString(i);
            setPropertyVal(hostDropDownList_xpath2, s);
            jsclick(hostDropDownItem_xpath);
            List<String> listFinal = getColDataInTable(sessionActivityHostCol_xpath);
            verifyHostVal(listFinal, hostDropDownValue_xpath, expectedHostVal_value, actualHostVal_value);

        }

    }

    public void navigateToAdministrationMenu() {
        jsclick(administrationMenu_xpath);
    }

    public void typeWithOutThrwngException(String locatorKey, String data) {
        try {
            String logicalName = locatorKey.split("_")[0];
            // log("Trying to type "+" the text '"+ data+"' in "+logicalName+" textbox.");
            getElement(locatorKey).sendKeys(data);
            wait(1);
            log("Entered the text '" + data + "'" + " in " + logicalName + " textbox");
        } catch (Exception ignore) {
            String logicalName = locatorKey.split("_")[0];

        }

    }

    public void verifyElmntEdtbleOrNot(String locatorKey) throws ConfigurationException {
        typeWithOutThrwngException(locatorKey, "abc");
        String s = getElement(locatorKey).getText();
        if (s.equalsIgnoreCase("abc")) {
            logFail(locatorKey.split("_")[0] + " is editable");
        } else {
            logPass(locatorKey.split("_")[0] + " is NOT editable");
        }
    }

    public void verifyElmntTxt(String locatorKey, String ExpctdValue) throws ConfigurationException {
        String s = getText(locatorKey);
        if (s.equalsIgnoreCase(ExpctdValue)) {
            logPass("For \"" + locatorKey.split("_")[0] + "\" actual text for the element from application i.e. \"" + s + "\" is same as expectedvalue from the application i.e. \"" + ExpctdValue + "\"");
        } else {
            logFail("For \"" + locatorKey.split("_")[0] + "\" actual text for the element from application i.e. \"" + s + "\" is NOT same as  expectedvalue from the application i.e. \"" + ExpctdValue + "\"");
        }
    }

    public void verifyWhthrToggleBtnEnbldOrDisabld(String locatorKey) throws ConfigurationException {
        String classVal = getAttributeVal(locatorKey, "class");
        clickWithOutMsg(locatorKey);
        String classVal1 = getAttributeVal(locatorKey, "class");
        if (classVal1.equalsIgnoreCase(classVal)) {
            logPass(locatorKey.split("_")[0] + " toggle button is not enabled.");
        } else {
            logFail(locatorKey.split("_")[0] + " toggle button is enabled.");
        }
    }

    public void clickWithOutMsg(String locatorKey) {
        try {
            String logicalNameOfElement = locatorKey.split("_")[0];
            // log("Trying to click on the element - " + logicalNameOfElement);
            getElement(locatorKey).click();
            wait(500);

        } catch (Exception ignore) {
            String logicalNameOfElement = locatorKey.split("_")[0];

        }

    }

    public void verifyWhthElementIsDisbld(String locatorKey) throws ConfigurationException {
        if (!getElement(locatorKey).isEnabled()) {
            logPass(locatorKey.split("_")[0] + " element is disabled.");
        } else {
            logFail(locatorKey.split("_")[0] + " element is enabled.");
        }
    }

    public void verifyWhthElementIsEnbld(String locatorKey) throws ConfigurationException {
        if (getElement(locatorKey).isEnabled()) {
            logPass(locatorKey.split("_")[0] + " element is enabled.");
        } else {
            logFail(locatorKey.split("_")[0] + " element is disabled.");
        }
    }


    public void navigateToConnectorsMenu() throws ConfigurationException {
        jsclick(connectorsMenu_xpath);
        verifyElmntTxt(connectorsHeader_xpath, "Connectors");
    }


    public void createSurveyQuestions() throws ConfigurationException {
        setApplPropFilePath("objectRepo.properties");
        String surveyQuestionrequired = getPropertyVal("surveyQuestionrequired");
        String surveyQuestionType = getPropertyVal("surveyQuestionType");
        String surveyQuestionUserType = getPropertyVal("surveyQuestionUserType");
//        setApplPropFilePath("creatorRoleTestcases.properties");
        for (int i = 0; i < surveyQuestionrequired.split(",").length; i++) {
            for (int j = 0; j < surveyQuestionType.split(",").length; j++) {
                for (int k = 0; k < surveyQuestionUserType.split(",").length; k++) {
                    setApplPropFilePath("creatorRoleTestcases.properties");
                    textEditableOrNot(indexInput_xpath, "Index");
                    click(addNewSurveyButton_xpath);
                    String surveyQuestionValue = getAlphaNumericString(10);
                    clearType(surveyQuestionInput_xpath, surveyQuestionValue);
                    setPropertyVal(surveyQuestionRequired_xpath2, Integer.toString(i + 1));
                    setPropertyVal(surveyQuestionType_xpath2, Integer.toString(j + 1));
                    setPropertyVal(surveyQuestionUserType_xpath2, Integer.toString(k + 1));
                    click(surveyQuestionRequired_xpath);
                    String val=getText(surveyQuestionRequired_xpath);
                    click(surveyQuestionType_xpath);
                    String val1=getText(surveyQuestionType_xpath);
                    if (Integer.toString(j + 1).equalsIgnoreCase("2")) {
                        String additionalDataVal = getAlphaNumericString(10);
                        clearType(additionalDataInput_xpath, additionalDataVal);

                    } else if (Integer.toString(j + 1).equalsIgnoreCase("5")) {
                        String additionalDataVal = getAlphaNumericString(10);
                        clearType(additionalDataInput_xpath, additionalDataVal);
                    }
                    click(surveyQuestionUserType_xpath);
                    String val2=getText(surveyQuestionUserType_xpath);
                    clickWithOutWait(surveyQuestionCreateButton_xpath);
                    String actAlertMsg = getText(imageSuccessAlertMsg_xpath);
                    log("Survey question added with  (Required = '"+val+"' Type = '"+val1+"' User Type =  '"+val2+"')");
                    setPropertyVal("surveyQuestionActAlertMsg", actAlertMsg);
                    setPropertyVal("surveyQuestionExpAlertMsg", getPropertyVal(surveyQuestionSuccessAlertMsg));
                    compareTwoEqualValues("surveyQuestionExpAlertMsg", "surveyQuestionActAlertMsg");
                if(actAlertMsg.equalsIgnoreCase(getPropertyVal(surveyQuestionErrorAlertMsg))){
                    driverWaitClick(surveyQuestionCancelBtn_xpath);
                }
                }
            }
        }
    }


    public void verifyEleAttributeVal(String locatorKey, String attrVal, String expectedVal) throws ConfigurationException {
        String actAttrVal = getAttributeVal(locatorKey, attrVal);
        if (getAttributeVal(locatorKey, attrVal).equalsIgnoreCase(expectedVal)) {
            logPass("For the Element \"" + locatorKey.split("_")[0] + "\" and for the attribute \"" + attrVal + "\" the actual value i.e. \"" + actAttrVal + "\" is same as that of expected value i.e.  \"" + expectedVal + "\"");
        } else {
            logFail("For the Element \"" + locatorKey.split("_")[0] + "\" and for the attribute \"" + attrVal + "\" the actual value i.e. \"" + actAttrVal + "\" is NOT same as that of expected value i.e.  \"" + expectedVal + "\"");
        }
    }

    public void verifyWhtrNewTabGotPopulated(String locatorKey, String expectedVal) throws ConfigurationException {
        List<String> browserTabs = new ArrayList<String>(driver.getWindowHandles());
        if (browserTabs.size() == 2) {
            logPass("New tab got populated.");
            wait(10);
            driver.switchTo().window(browserTabs.get(1));
            wait(10);
            verifyElmntTxt(locatorKey, expectedVal);
            driver.close();
            wait(10);
            driver.switchTo().window(browserTabs.get(0));
        } else {
            logFail("New tab did NOT get populated.");
        }
    }

    public List<String> verifyEditButtonInUsersTableGrid(String locator) throws ConfigurationException {
        int count = 0;
        List<String> errorValues = new ArrayList<>();
        int rowsCountVal = Integer.parseInt(getEntireTableCountForCol());
        if (rowsCountVal == 0) {
            verifyNoDataValueInSessActTable();
        } else {
            do {
                int rowCount = getSessionActTableRowsCount();
                for (int i = 1; i <= rowCount; i++) {
                    setPropertyVal(usersEditRecordButton_xpath2, Integer.toString(i));
                    setPropertyVal(userTableEmailText_xpath2, Integer.toString(i));
                    setPropertyVal(tableRow_xpath2, Integer.toString(i));
                    actionsMovetoElement(tableRow_xpath);
                    if (isElementPresent(locator)) {
                        count = count + 1;
                        errorValues.add(getText(userTableEmailText_xpath));
                    }

                }
            } while (!getAttributeVal(navRghtEnbDisbl_xpath, "class").toString().equalsIgnoreCase(getPropertyVal(navDisbl_clssval)));

        }
        return errorValues;
    }

    public void navigateToUsersEditPage(String userIDVal) throws ConfigurationException {
        click(usersTab_xpath);
        type(usersPageSearchBox_xpath, userIDVal);
        actionsMovetoElement(sessionActivityTbl_xpath);
        actionsClick(usersEditRecordButton_xpath);
    }

    public void clearWithDelete(String locatorKey) {
        try {
            String logicalName = locatorKey.split("_")[0];
            log("Trying to clear the text field " + logicalName);
            getElement(locatorKey).sendKeys(Keys.CONTROL + "a" + Keys.DELETE);
            wait(1);
            logPass("Cleared the value in text box -" + logicalName);
        } catch (Exception ignore) {
            String logicalName = locatorKey.split("_")[0];
            logFail("Failed to clear the value in text box -" + logicalName);
        }

    }


    public void clearType(String locator, String value) {
        clearWithDelete(locator);
        type(locator, value);
    }


    public void dismissUploadIfPresent() {
        if (isElementPresent(closeUploadDlgBtn_xpath)) {
            click(closeUploadDlgBtn_xpath);
        }
    }


    public void navigateToRolesPage() throws ConfigurationException {
        click(usersTab_xpath);
        if (!isElementVisible(rolesTab_xpath)) {
            click(usersTab_xpath);
            click(rolesTab_xpath);
        } else {
            click(rolesTab_xpath);

        }
        String actText = getText(rolesText_xpath);
        setPropertyVal("rolesActText", actText);
        setPropertyVal("rolesExpText", getPropertyVal(rolesText_val));
        compareTwoEqualValues("rolesExpText", "rolesActText");
    }

    public void verifyRolesCheckbox(String roleName, String headerText, String checkboxAttribute) throws ConfigurationException {
        String allowSnapshotText = getText(headerText);
        String roleCheckBoxValue = getAttributeVal(checkboxAttribute, "class");
        wait(10);
        if (roleCheckBoxValue.equalsIgnoreCase(getPropertyVal(checkBoxAttribute_val))) {

            logPass(roleName + " role " + allowSnapshotText + " CheckBox selected, and not enabled");
        } else if (roleCheckBoxValue.equalsIgnoreCase(getPropertyVal(checkBoxAttribute_val1))) {

            logPass(roleName + " role " + allowSnapshotText + " CheckBox is not selected, and not enabled");
        } else {

            logFail(roleName + " role " + allowSnapshotText + " CheckBox not selected , and enabled");
        }
    }


    public void verifyDownLoadOfImages() throws ConfigurationException, IOException, CsvValidationException {
        setApplPropFilePath("sessionActivity.properties");
        int rowsCountVal = Integer.parseInt(getEntireTableCountForCol());
        if (rowsCountVal == 0) {
            verifyNoDataValueInSessActTable();
        } else if (rowsCountVal <= 25) {
            int rowCountVal = Integer.parseInt(getEntireTableCountForCol());
            for (int i = 1; i <= rowCountVal; i++) {

                setPropertyVal("imgDownLoadButton_xpath2", Integer.toString(i));
                int noOfImgsPerRow = getElements(imgsPerRow_xpath).size();
                if (noOfImgsPerRow > 0) {

                    for (int eleCount = 1; eleCount <= noOfImgsPerRow; eleCount++) {
                        deleteALLFilesInDownload();
                        setPropertyVal("imgDownLoadButton_xpath5", Integer.toString(eleCount));
                        click(imgDownLoadButton_xpath);
                        String pageNumberVal = "1";
                        String rowNumberVal = Integer.toString(i);
                        String imageNoVal = Integer.toString(eleCount);
                        verifyWhetherImageIsDownloaded(pageNumberVal, rowNumberVal, imageNoVal);
                    }
                }

            }

        } else {
            deleteALLFilesInDownload();
            int rowCountVal = Integer.parseInt(getEntireTableCountForCol());
            int reminderVal = rowCountVal % 25;
            int totalNoOfNavs;
            int noOfTimes = rowCountVal / 25;
            if (reminderVal > 0) {
                totalNoOfNavs = noOfTimes;
                for (int i = 1; i <= totalNoOfNavs; i++) {
                    for (int j = 1; j <= 25; j++) {
                        setPropertyVal("imgDownLoadButton_xpath2", Integer.toString(j));
                        int noOfImgsPerRow = getElements(imgsPerRow_xpath).size();
                        if (noOfImgsPerRow > 0) {

                            for (int eleCount = 1; eleCount <= noOfImgsPerRow; eleCount++) {
                                deleteALLFilesInDownload();
                                setPropertyVal("imgDownLoadButton_xpath5", Integer.toString(eleCount));
                                click(imgDownLoadButton_xpath);
                                String pageNumberVal = Integer.toString(i);
                                String rowNumberVal = Integer.toString(j);
                                String imageNoVal = Integer.toString(eleCount);
                                verifyWhetherImageIsDownloaded(pageNumberVal, rowNumberVal, imageNoVal);
                            }
                        }
                    }
                    click(navRightArrowButton_xpath);
                    for (int j = 1; j <= reminderVal; j++) {
                        setPropertyVal("imgDownLoadButton_xpath2", Integer.toString(j));
                        int noOfImgsPerRow = getElements(imgsPerRow_xpath).size();
                        if (noOfImgsPerRow > 0) {
                            deleteALLFilesInDownload();
                            for (int eleCount = 1; eleCount <= noOfImgsPerRow; eleCount++) {
                                deleteALLFilesInDownload();
                                setPropertyVal("imgDownLoadButton_xpath5", Integer.toString(eleCount));
                                click(imgDownLoadButton_xpath);
                                String pageNumberVal = Integer.toString(i + 1);
                                String rowNumberVal = Integer.toString(j);
                                String imageNoVal = Integer.toString(eleCount);
                                verifyWhetherImageIsDownloaded(pageNumberVal, rowNumberVal, imageNoVal);
                            }
                        }
                    }
                }

            } else {
                totalNoOfNavs = noOfTimes - 1;
                for (int i = 1; i <= totalNoOfNavs; i++) {
                    for (int j = 1; j <= 25; j++) {
                        setPropertyVal("imgDownLoadButton_xpath2", Integer.toString(j));
                        int noOfImgsPerRow = getElements(imgsPerRow_xpath).size();
                        if (noOfImgsPerRow > 0) {

                            for (int eleCount = 1; eleCount <= noOfImgsPerRow; eleCount++) {
                                deleteALLFilesInDownload();
                                setPropertyVal("imgDownLoadButton_xpath5", Integer.toString(eleCount));
                                click(imgDownLoadButton_xpath);
                                String pageNumberVal = Integer.toString(i);
                                String rowNumberVal = Integer.toString(j);
                                String imageNoVal = Integer.toString(eleCount);
                                verifyWhetherImageIsDownloaded(pageNumberVal, rowNumberVal, imageNoVal);
                            }
                        }
                    }
                }
            }

        }
    }


    public void verifyDownLoadOfImage() throws ConfigurationException, IOException, CsvValidationException {
//        setApplPropFilePath("sessionActivity.properties");
        int rowsCountVal = Integer.parseInt(getEntireTableCountForCol());
        if (rowsCountVal == 0) {
            verifyNoDataValueInSessActTable();
        } else if (rowsCountVal <= 25) {
            int rowCountVal = Integer.parseInt(getEntireTableCountForCol());
            for (int i = 1; i <= rowCountVal; i++) {

                setPropertyVal("imgDownLoadButton_xpath2", Integer.toString(i));
                int noOfImgsPerRow = getElements(imgsPerRow_xpath).size();
                if (noOfImgsPerRow > 0) {
                    deleteALLFilesInDownload();
                    setPropertyVal("imgDownLoadButton_xpath5", Integer.toString(1));
                    click(imgDownLoadButton_xpath);
                    String pageNumberVal = "1";
                    String rowNumberVal = Integer.toString(i);
                    String imageNoVal = Integer.toString(1);
                    verifyWhetherImageIsDownloaded(pageNumberVal, rowNumberVal, imageNoVal);
                    break;

                }

            }

        } else {
            deleteALLFilesInDownload();
            int rowCountVal = Integer.parseInt(getEntireTableCountForCol());
            int reminderVal = rowCountVal % 25;
            int totalNoOfNavs;
            int noOfTimes = rowCountVal / 25;
            if (reminderVal > 0) {
                totalNoOfNavs = noOfTimes;
                for (int i = 1; i <= totalNoOfNavs; i++) {

                    for (int j = 1; j <= 25; j++) {
                        setPropertyVal("imgDownLoadButton_xpath2", Integer.toString(j));
                        int noOfImgsPerRow = getElements(imgsPerRow_xpath).size();
                        if (noOfImgsPerRow > 0) {
                            deleteALLFilesInDownload();
                            setPropertyVal("imgDownLoadButton_xpath5", Integer.toString(1));
                            click(imgDownLoadButton_xpath);
                            String pageNumberVal = "1";
                            String rowNumberVal = Integer.toString(i);
                            String imageNoVal = Integer.toString(1);
                            verifyWhetherImageIsDownloaded(pageNumberVal, rowNumberVal, imageNoVal);
                            break;
                        }
                    }
                    click(navRightArrowButton_xpath);

                }
                for (int j = 1; j <= reminderVal; j++) {
                    setPropertyVal("imgDownLoadButton_xpath2", Integer.toString(j));
                    int noOfImgsPerRow = getElements(imgsPerRow_xpath).size();
                    if (noOfImgsPerRow > 0) {
                        deleteALLFilesInDownload();
                        setPropertyVal("imgDownLoadButton_xpath5", Integer.toString(1));
                        click(imgDownLoadButton_xpath);
                        String pageNumberVal = "1";
                        String rowNumberVal = Integer.toString(j);
                        String imageNoVal = Integer.toString(1);
                        verifyWhetherImageIsDownloaded(pageNumberVal, rowNumberVal, imageNoVal);
                        break;
                    }
                }

            } else {
                totalNoOfNavs = noOfTimes - 1;
                for (int i = 1; i <= totalNoOfNavs; i++) {
                    for (int j = 1; j <= 25; j++) {
                        setPropertyVal("imgDownLoadButton_xpath2", Integer.toString(j));
                        int noOfImgsPerRow = getElements(imgsPerRow_xpath).size();
                        if (noOfImgsPerRow > 0) {
                            deleteALLFilesInDownload();
                            setPropertyVal("imgDownLoadButton_xpath5", Integer.toString(1));
                            click(imgDownLoadButton_xpath);
                            String pageNumberVal = "1";
                            String rowNumberVal = Integer.toString(i);
                            String imageNoVal = Integer.toString(1);
                            verifyWhetherImageIsDownloaded(pageNumberVal, rowNumberVal, imageNoVal);
                            break;
                        }
                    }
                }
            }

        }
    }

    public void verifyASCSortingOrderIntegerInGrid(String ascOrderlocatorKey, String colLocatorKey) throws ConfigurationException {
        List<String> orgEntireCoLDate = getColDataInTable(colLocatorKey);
        List<Integer> intList = new ArrayList<Integer>();
        for (String s : orgEntireCoLDate) {
            if(s.equalsIgnoreCase(""))
            {
                intList.add(0);
            }
            else {
                intList.add(Integer.valueOf(s.replace("+", "").trim()));
            }
        }
        Collections.sort(intList);
        List<String> intStrList = new ArrayList<String>();
        for (Integer iVal : intList) {
            intStrList.add(Integer.toString(iVal));
        }
        navToFirstPage();
        jsclick(ascOrderlocatorKey);
        List<String> actEntireColDate = getColDataInTable(colLocatorKey);
        int iCounterVal = 0;
        for (int iVal = 0; iVal < orgEntireCoLDate.size(); iVal++) {
            if (Integer.parseInt(actEntireColDate.get(iVal).toString()) != intList.get(iVal)) {

                String statementToLog = sortingFailureStatementVal(orgEntireCoLDate, actEntireColDate, iVal, colLocatorKey.split("_")[0], "Ascending");
                logFailWithOutScreenshot(statementToLog);
                iCounterVal = iCounterVal + 1;
                break;

            }
        }
        if (iCounterVal == 0) {
            logPass(colLocatorKey.split("_")[0] + " got sorted in ascending order successfully.");
        }
    }

    public void verifyASCSortingOrderLongInGrid(String ascOrderlocatorKey, String colLocatorKey) throws ConfigurationException {
        List<String> orgEntireCoLDate = getColDataInTable(colLocatorKey);
        List<Long> intList = new ArrayList<Long>();
        for (String s : orgEntireCoLDate) {
            if(s.equalsIgnoreCase(""))
            {
                intList.add(0L);
            }
            else {
                intList.add(Long.parseLong(s.replace("+", "").trim()));
            }
        }
        Collections.sort(intList);
        List<String> intStrList = new ArrayList<String>();
        for (Long iVal : intList) {
            intStrList.add(Long.toString(iVal));
        }
        navToFirstPage();
        jsclick(ascOrderlocatorKey);
        List<String> actEntireColDate = getColDataInTable(colLocatorKey);
        int iCounterVal = 0;
        Long actValue=0L;
        for (int iVal = 0; iVal < orgEntireCoLDate.size(); iVal++) {
            if(actEntireColDate.get(iVal).toString().equalsIgnoreCase(""))
            {
                actValue=(0L);
            }
            else {
                actValue=Long.parseLong(actEntireColDate.get(iVal).toString().replace("+", "").trim());
            }
            String temp1=Long.toString(actValue);
            String temp2=Long.toString(intList.get(iVal));
            if (!temp1.equalsIgnoreCase(temp2)) {

                String statementToLog = sortingFailureStatementVal(orgEntireCoLDate, actEntireColDate, iVal, colLocatorKey.split("_")[0], "Ascending");
                logFailWithOutScreenshot(statementToLog);
                iCounterVal = iCounterVal + 1;
                break;

            }
        }
        if (iCounterVal == 0) {
            logPass(colLocatorKey.split("_")[0] + " got sorted in ascending order successfully.");
        }
    }

    public void verifyDESCSortingOrderIntegerInGrid(String descOrderlocatorKey, String colLocatorKey) throws ConfigurationException {
        List<String> orgEntireCoLDate = getColDataInTable(colLocatorKey);
        List<Integer> intList = new ArrayList<Integer>();
        for (String s : orgEntireCoLDate) {
            intList.add(Integer.valueOf(s.replace("+","").trim()));
        }
        Collections.sort(intList, Collections.reverseOrder());
        List<String> intStrList = new ArrayList<String>();
        for (Integer iVal : intList) {
            intStrList.add(Integer.toString(iVal));
        }
        navToFirstPage();
        jsclick(descOrderlocatorKey);
        List<String> actEntireColDate = getColDataInTable(colLocatorKey);
        int iCounterVal = 0;
        for (int iVal = 0; iVal < orgEntireCoLDate.size(); iVal++) {
            if (Integer.parseInt(actEntireColDate.get(iVal).toString()) != intList.get(iVal)) {

                String statementToLog = sortingFailureStatementVal(intStrList, actEntireColDate, iVal, colLocatorKey.split("_")[0], "Descending");
                logFailWithOutScreenshot(statementToLog);
                iCounterVal = iCounterVal + 1;
                break;

            }
        }
        if (iCounterVal == 0) {
            logPass(colLocatorKey.split("_")[0] + " got sorted in descending order successfully.");
        }

    }

    public void verifyDESCSortingOrderLongInGrid(String descOrderlocatorKey, String colLocatorKey) throws ConfigurationException {
        List<String> orgEntireCoLDate = getColDataInTable(colLocatorKey);
        List<Long> intList = new ArrayList<Long>();
        for (String s : orgEntireCoLDate) {
            if(s.equalsIgnoreCase(""))
            {
                intList.add(0L);
            }
            else {
                intList.add(Long.parseLong(s.replace("+", "").trim()));
            }
        }
        Collections.sort(intList, Collections.reverseOrder());
        List<String> intStrList = new ArrayList<String>();
        for (Long iVal : intList) {
            intStrList.add(Long.toString(iVal));
        }
        navToFirstPage();
        jsclick(descOrderlocatorKey);
        List<String> actEntireColDate = getColDataInTable(colLocatorKey);
        int iCounterVal = 0;
        Long actValue=0L;
        for (int iVal = 0; iVal < orgEntireCoLDate.size(); iVal++) {
            if(actEntireColDate.get(iVal).toString().equalsIgnoreCase(""))
            {
                actValue=(0L);
            }
            else {
                actValue=Long.parseLong(actEntireColDate.get(iVal).toString().replace("+", "").trim());
            }
            String temp1=Long.toString(actValue);
            String temp2=Long.toString(intList.get(iVal));
            if (!temp1.equalsIgnoreCase(temp2)) {
                String statementToLog = sortingFailureStatementVal(orgEntireCoLDate, actEntireColDate, iVal, colLocatorKey.split("_")[0], "Descending");
                logFailWithOutScreenshot(statementToLog);
                iCounterVal = iCounterVal + 1;
                break;

            }
        }
        if (iCounterVal == 0) {
            logPass(colLocatorKey.split("_")[0] + " got sorted in descending order successfully.");
        }

    }

    public void verifyIntegerSortingOrder(String ascLocator, String descLocator, String colLocator) throws ConfigurationException {
        navToFirstPage();
        verifyASCSortingOrderIntegerInGrid(ascLocator, colLocator);
        navToFirstPage();
        verifyDESCSortingOrderIntegerInGrid(descLocator, colLocator);
    }

    public void verifyLongSortingOrder(String ascLocator, String descLocator, String colLocator) throws ConfigurationException {
        navToFirstPage();
        verifyASCSortingOrderLongInGrid(ascLocator, colLocator);
        navToFirstPage();
        verifyDESCSortingOrderLongInGrid(descLocator, colLocator);
    }

    public void navigateToAnalytics(String loactrElement) throws ConfigurationException {

        driverWaitClick(analyticsMenu_xpath);
        if (isElementVisible(loactrElement)) {
            driverWaitClick(loactrElement);
        } else {
            click(analyticsMenu_xpath);
            driverWaitClick(loactrElement);
        }

    }

    public void fileUpload(String filePath) throws AWTException {
        StringSelection str = new StringSelection(filePath);
        Toolkit.getDefaultToolkit().getSystemClipboard().setContents(str, null);
        Robot robot = new Robot();
        robot.keyPress(KeyEvent.VK_CONTROL);
        robot.keyPress(KeyEvent.VK_V);
        robot.keyRelease(KeyEvent.VK_V);
        robot.keyRelease(KeyEvent.VK_CONTROL);
        robot.delay(3000);
        robot.keyPress(KeyEvent.VK_ENTER);
        robot.keyRelease(KeyEvent.VK_ENTER);
        /*System.Windows.Forms.SendKeys.SendWait("complete path of the file");
        System.Windows.Forms.SendKeys.SendWait("{ENTER}");*/
        //  type(filePathVal_xpath,filePath);


    }


    public void verifyDeleteOfImage() throws ConfigurationException, IOException, CsvValidationException {
//        setApplPropFilePath("sessionActivity.properties");
        int rowsCountVal = Integer.parseInt(getEntireTableCountForCol());
        if (rowsCountVal == 0) {
            verifyNoDataValueInSessActTable();
        } else if (rowsCountVal <= 25) {
            int rowCountVal = Integer.parseInt(getEntireTableCountForCol());
            for (int i = 1; i <= rowCountVal; i++) {

                setPropertyVal("imgDeleteButton_xpath2", Integer.toString(i));
                int noOfImgsPerRow = getElements(imgsPerRowDlT_xpath).size();
                if (noOfImgsPerRow > 0) {
                    deleteALLFilesInDownload();
                    setPropertyVal("imgDeleteButton_xpath5", Integer.toString(1));
                    click(imgDeleteButton_xpath);
                    click(confirmDeleteImg_xpath);
                    int noOfImgsPerRow1 = getElements(imgsPerRowDlT_xpath).size();
                    String pageNumberVal = "1";
                    String rowNumberVal = Integer.toString(i);
                    String imageNoVal = Integer.toString(1);
                    if (noOfImgsPerRow1 == noOfImgsPerRow - 1) {
                        logPass("On Page No: " + pageNumberVal + " and at rownumber " + rowNumberVal + " and the image no: " + imageNoVal + " got deleted.");
                    } else {
                        logFail("On Page No: " + pageNumberVal + " and at rownumber " + rowNumberVal + " and the image no: " + imageNoVal + " did NOT get deleted.");
                    }
                    break;

                }

            }

        } else {
            deleteALLFilesInDownload();
            int rowCountVal = Integer.parseInt(getEntireTableCountForCol());
            int reminderVal = rowCountVal % 25;
            int totalNoOfNavs;
            int noOfTimes = rowCountVal / 25;
            if (reminderVal > 0) {
                totalNoOfNavs = noOfTimes;
                for (int i = 1; i <= totalNoOfNavs; i++) {

                    for (int j = 1; j <= 25; j++) {
                        setPropertyVal("imgDeleteButton_xpath2", Integer.toString(j));
                        int noOfImgsPerRow = getElements(imgsPerRowDlT_xpath).size();
                        if (noOfImgsPerRow > 0) {
                            deleteALLFilesInDownload();
                            setPropertyVal("imgDeleteButton_xpath5", Integer.toString(1));
                            click(imgDeleteButton_xpath);
                            click(confirmDeleteImg_xpath);
                            int noOfImgsPerRow1 = getElements(imgsPerRowDlT_xpath).size();
                            String pageNumberVal = Integer.toString(i);
                            String rowNumberVal = Integer.toString(j);
                            String imageNoVal = Integer.toString(1);
                            if (noOfImgsPerRow1 == noOfImgsPerRow - 1) {
                                logPass("On Page No: " + pageNumberVal + " and at rownumber " + rowNumberVal + " and the image no: " + imageNoVal + " got deleted.");
                            } else {
                                logFail("On Page No: " + pageNumberVal + " and at rownumber " + rowNumberVal + " and the image no: " + imageNoVal + " did NOT get deleted.");
                            }
                            break;
                        }
                    }
                    click(navRightArrowButton_xpath);

                }
                for (int j = 1; j <= reminderVal; j++) {
                    setPropertyVal("imgDeleteButton_xpath2", Integer.toString(j));
                    int noOfImgsPerRow = getElements(imgsPerRowDlT_xpath).size();
                    if (noOfImgsPerRow > 0) {
                        deleteALLFilesInDownload();
                        setPropertyVal("imgDeleteButton_xpath5", Integer.toString(1));
                        click(imgDeleteButton_xpath);
                        click(confirmDeleteImg_xpath);
                        int noOfImgsPerRow1 = getElements(imgsPerRowDlT_xpath).size();
                        String pageNumberVal = Integer.toString(totalNoOfNavs + 1);
                        String rowNumberVal = Integer.toString(j);
                        String imageNoVal = Integer.toString(1);
                        if (noOfImgsPerRow1 == noOfImgsPerRow - 1) {
                            logPass("On Page No: " + pageNumberVal + " and at rownumber " + rowNumberVal + " and the image no: " + imageNoVal + " got deleted.");
                        } else {
                            logFail("On Page No: " + pageNumberVal + " and at rownumber " + rowNumberVal + " and the image no: " + imageNoVal + " did NOT get deleted.");
                        }
                        break;
                    }
                }

            } else {
                totalNoOfNavs = noOfTimes - 1;
                for (int i = 1; i <= totalNoOfNavs; i++) {
                    for (int j = 1; j <= 25; j++) {
                        setPropertyVal("imgDeleteButton_xpath2", Integer.toString(j));
                        int noOfImgsPerRow = getElements(imgsPerRowDlT_xpath).size();
                        if (noOfImgsPerRow > 0) {
                            deleteALLFilesInDownload();
                            setPropertyVal("imgDeleteButton_xpath5", Integer.toString(1));
                            click(imgDeleteButton_xpath);
                            click(confirmDeleteImg_xpath);
                            int noOfImgsPerRow1 = getElements(imgsPerRowDlT_xpath).size();
                            String pageNumberVal = Integer.toString(i);
                            String rowNumberVal = Integer.toString(j);
                            String imageNoVal = Integer.toString(1);
                            if (noOfImgsPerRow1 == noOfImgsPerRow - 1) {
                                logPass("On Page No: " + pageNumberVal + " and at rownumber " + rowNumberVal + " and the image no: " + imageNoVal + " got deleted.");
                            } else {
                                logFail("On Page No: " + pageNumberVal + " and at rownumber " + rowNumberVal + " and the image no: " + imageNoVal + " did NOT get deleted.");
                            }
                            break;
                        }
                    }
                }
            }
        }
    }

    public void verifyNONDeleteOfImage() throws ConfigurationException, IOException, CsvValidationException {
//        setApplPropFilePath("sessionActivity.properties");
        int rowsCountVal = Integer.parseInt(getEntireTableCountForCol());
        if (rowsCountVal == 0) {
            verifyNoDataValueInSessActTable();
        } else if (rowsCountVal <= 25) {
            int rowCountVal = Integer.parseInt(getEntireTableCountForCol());
            int iCount=0;
            for (int i = 1; i <= rowCountVal; i++) {

                setPropertyVal("imgDeleteButton_xpath2", Integer.toString(i));
                int noOfImgsPerRow = getElements(imgsPerRowDlT_xpath).size();
                if (noOfImgsPerRow > 0) {
                    deleteALLFilesInDownload();

                    String pageNumberVal = "1";
                    String rowNumberVal = Integer.toString(i);
                    String imageNoVal = Integer.toString(1);
                        iCount = iCount+1;
                        logFail("On Page No: " + pageNumberVal + " and at rownumber " + rowNumberVal + " and the image no: " + imageNoVal + " has delete button.");

                    break;

                }

            }
        if(iCount==0)
        {
            logPass("Delete button for images are not visible.");
        }
        } else {
            deleteALLFilesInDownload();
            int rowCountVal = Integer.parseInt(getEntireTableCountForCol());
            int reminderVal = rowCountVal % 25;
            int totalNoOfNavs;
            int noOfTimes = rowCountVal / 25;
            if (reminderVal > 0) {
                totalNoOfNavs = noOfTimes;
                int iCount=0;
                for (int i = 1; i <= totalNoOfNavs; i++) {

                    for (int j = 1; j <= 25; j++) {
                        setPropertyVal("imgDeleteButton_xpath2", Integer.toString(j));
                        int noOfImgsPerRow = getElements(imgsPerRowDlT_xpath).size();
                        if (noOfImgsPerRow > 0) {


                            String pageNumberVal = Integer.toString(i);
                            String rowNumberVal = Integer.toString(j);
                            String imageNoVal = Integer.toString(1);
                                iCount=iCount+1;
                                logFail("On Page No: " + pageNumberVal + " and at rownumber " + rowNumberVal + " and the image no: " + imageNoVal + " did NOT get deleted.");

                            break;
                        }
                    }
                    click(navRightArrowButton_xpath);

                }

                for (int j = 1; j <= reminderVal; j++) {
                    setPropertyVal("imgDeleteButton_xpath2", Integer.toString(j));
                    int noOfImgsPerRow = getElements(imgsPerRowDlT_xpath).size();
                    if (noOfImgsPerRow > 0) {

                        String pageNumberVal = Integer.toString(totalNoOfNavs + 1);
                        String rowNumberVal = Integer.toString(j);
                        String imageNoVal = Integer.toString(1);
                        iCount = iCount+1;
                            logFail("On Page No: " + pageNumberVal + " and at rownumber " + rowNumberVal + " and the image no: " + imageNoVal + " delete button got displayed.");

                        break;
                    }
                }
                if(iCount==0)
                {
                    logPass("Delete button for images are not visible.");
                }

            } else {
                totalNoOfNavs = noOfTimes - 1;
                int iCount=0;
                for (int i = 1; i <= totalNoOfNavs; i++) {
                    for (int j = 1; j <= 25; j++) {
                        setPropertyVal("imgDeleteButton_xpath2", Integer.toString(j));
                        int noOfImgsPerRow = getElements(imgsPerRowDlT_xpath).size();
                        if (noOfImgsPerRow > 0) {

                            String pageNumberVal = Integer.toString(i);
                            String rowNumberVal = Integer.toString(j);
                            String imageNoVal = Integer.toString(1);
                                iCount=iCount+1;
                                logFail("On Page No: " + pageNumberVal + " and at rownumber " + rowNumberVal + " and the image no: " + imageNoVal + " did NOT get deleted.");

                            break;
                        }
                    }
                }
                if(iCount==0)
                {
                    logPass("Delete button for images are not visible.");
                }
            }
        }
    }

    public void navigateToAIServicesImageRecognitonPage() {
        if (isElementVisible(imageRecognitionTab_xpath)) {
            driverWaitClick(imageRecognitionTab_xpath);
        } else {
            driverWaitClick(aIServicesBtn_xpath);
            driverWaitClick(imageRecognitionTab_xpath);
        }
        if (isElementPresent(cllectionsPageTab_xpath)) {
            logPass("Image recognition page got opened up");
        } else if (isElementPresent(upgradeYorPlan_xpath)) {
            logPass("Image recognition page got opened up");
        } else {
            logFail("Image recognition page not get opened up");
        }
    }

    public void navigateToAIServicesIntelligentSearchPage() {
        if (isElementVisible(intelligetSearchTab_xpath)) {
            driverWaitClick(intelligetSearchTab_xpath);
        } else {
            driverWaitClick(aIServicesBtn_xpath);
            driverWaitClick(intelligetSearchTab_xpath);
        }
        if (isElementPresent(indexText_xpath)) {
            logPass("Inelligent search page got opened up");
        } else if (isElementPresent(upgradeYorPlan_xpath)) {
            logPass("Inelligent search page got opened up");
        } else {
            logFail("Inelligent search page not get opened up");
        }
    }

    public void verifyNoIndexesAvailableInIntelligentSearchPage() throws ConfigurationException {
        if (isElementVisible(noIdexesAvailable_xpath)) {
            if (getText(noIdexesAvailable_xpath).equalsIgnoreCase(getPropertyVal(noIdexesAvailable_val))) {
                logPass("No Indexes available data got populated in the Idexes page.");
            } else {
                logFail("No Data did NOT got populated in the Idexes page.");
            }
        }
    }

    public void addIndex(String indexVal) throws ConfigurationException, AWTException {
        if (indexVal.equalsIgnoreCase("1")) {
            driverWaitClick(indexButton_xpath);
            String inputName = getAlphaNumericString(6);
            clearType(indexNameInput_xpath, inputName);
//            type(sourceInput_xpath,"XML Sitemap");
            wait(50);
            driverWaitClick(indexSourceDropdown_xpath);
            driverWaitClick(selectXmlSiteMapFrmDropDown_xpath);
            driverWaitClick(createIndexNextButton_xpath);
            type(xmlSiteMapUrl_xpath, getPropertyVal(createIndexUrl_val));
            driverWaitClick(createIndexNextButton_xpath);
            driverWaitClick(createIndexNextButton_xpath);
            clickWithOutWait(createIndexButton_xpath);
            String actAlert = getText(indexSuccesAlertMsg_xpath);
            setPropertyVal("actIndexcreatedSuccessAlrtMsg", actAlert);
            setPropertyVal("expIndexcreatedSuccessAlrtMsg", getPropertyVal(indexCreatedSuccessAlertMsg_val));
            compareTwoEqualValues("expIndexcreatedSuccessAlrtMsg", "actIndexcreatedSuccessAlrtMsg");

        } else if (indexVal.equalsIgnoreCase("2")) {
            driverWaitClick(indexButton_xpath);
            String inputName = getAlphaNumericString(7);
            clearType(indexNameInput_xpath, inputName);
            driverWaitClick(indexSourceDropdown_xpath);
            driverWaitClick(selectUploadIndexFileFrmDropDown_xpath);
            driverWaitClick(createIndexNextButton_xpath);
            driverWaitClick(chooseFileButton_xpath);
            String uploadFile = System.getProperty("user.dir") + "\\src\\test\\java\\Images\\out_land_on_page_combined_injected.json";
            fileUpload(uploadFile);
            /*wait(30);
            type(chooseFileButton_xpath,uploadFile);
            wait(30);*/
            clickWithOutWait(createIndexButton_xpath);
            String actAlert = getText(indexSuccesAlertMsg_xpath);
            setPropertyVal("actIndexcreatedSuccessAlrtMsg", actAlert);
            setPropertyVal("expIndexcreatedSuccessAlrtMsg", getPropertyVal(indexCreatedSuccessAlertMsg_val));
            compareTwoEqualValues("expIndexcreatedSuccessAlrtMsg", "actIndexcreatedSuccessAlrtMsg");
        }
    }

    public void editExperienceNameWithOutUpdate() throws ConfigurationException {
        actionsMovetoElement(experienceNameInputField_xpath);
        driverWaitClick(experienceNameEditBtn_xpath);
        clickWithOutWait(experienceNameSaveBtn_xpath);
        String noUpdateAlrtMsg = getText(experienceEditAlrtMsg_xpath);
        setPropertyVal("experienceNameActAlertMsg", noUpdateAlrtMsg);
        setPropertyVal("experienceNameExpAlertMsg", getPropertyVal(experienceNoUpdateAlertMsg_val));
        compareTwoEqualValues("experienceNameExpAlertMsg", "experienceNameActAlertMsg");
    }

    public String editExperienceNameUpdate() throws ConfigurationException {
        actionsMovetoElement(experienceNameInputField_xpath);
        driverWaitClick(experienceNameEditBtn_xpath);
        String val = getAlphaNumericString(10);
        clearType(experienceNameInputField_xpath, val);
        clickWithOutWait(experienceNameSaveBtn_xpath);
        String noUpdateAlrtMsg = getText(experienceEditAlrtMsg_xpath);
        setPropertyVal("experienceNameActAlertMsg", noUpdateAlrtMsg);
        setPropertyVal("experienceNameExpAlertMsg", getPropertyVal(experienceEditSuccessAlrtMsg_val));
        compareTwoEqualValues("experienceNameExpAlertMsg", "experienceNameActAlertMsg");
        return val;
    }

    public String renameExperienceInBulderPage() throws ConfigurationException {
        actionsMovetoElement(experienceRenameEditToggle_xpath);
        driverWaitClick(experienceRenameEditBtn_xpath);
        String val = getAlphaNumericString(10);
        clearType(experienceRenameEditField_xpath, val);
        driverWaitClick(experienceRenameSaveBtn_xpath);
        return val;
    }

    public void editDescriptionWithOutUpdate() throws ConfigurationException {
        actionsMovetoElement(experienceDescriptionInput_xpath);
        driverWaitClick(experienceDescriptionEditBtn_xpath);
        clickWithOutWait(experienceDescriptionSaveBtn_xpath);
        String noUpdateAlrtMsg = getText(experienceEditAlrtMsg_xpath);
        setPropertyVal("experienceNameActAlertMsg", noUpdateAlrtMsg);
        setPropertyVal("experienceNameExpAlertMsg", getPropertyVal(experienceNoUpdateAlertMsg_val));
        compareTwoEqualValues("experienceNameExpAlertMsg", "experienceNameActAlertMsg");
    }

    public String editDescriptionUpdate() throws ConfigurationException {
        actionsMovetoElement(experienceDescriptionInput_xpath);
        driverWaitClick(experienceDescriptionEditBtn_xpath);
        String val = getAlphaNumericString(12);
        clearType(experienceDescriptionInput_xpath, val);
        clickWithOutWait(experienceDescriptionSaveBtn_xpath);
        String noUpdateAlrtMsg = getText(experienceEditAlrtMsg_xpath);
        setPropertyVal("experienceNameActAlertMsg", noUpdateAlrtMsg);
        setPropertyVal("experienceNameExpAlertMsg", getPropertyVal(experienceEditSuccessAlrtMsg_val));
        compareTwoEqualValues("experienceNameExpAlertMsg", "experienceNameActAlertMsg");
        return val;
    }

    public void copyExperienceId() throws ConfigurationException {
        actionsMovetoElement(experienceIdInputField_xpath);
        clickWithOutWait(experienceIdCopyBtn_xpath);
        String alrtMsg = getText(experienceCopyAlertMsg_xpath);
        setPropertyVal("experienceIdCopyActAlertMsg", alrtMsg);
        setPropertyVal("experienceIdCopyExpAlertMsg", getPropertyVal(experienceCopyAlertMsg_val));
        compareTwoEqualValues("experienceIdCopyExpAlertMsg", "experienceIdCopyActAlertMsg");
    }

    public void indexEdit(String option) throws ConfigurationException {
        if (isElementVisible(noIdexesAvailable_xpath)) {
            verifyNoIdexesAvalableInTable();
        } else {
            setPropertyVal(tableData_xpath2, "1");
            List tableRecordSize = getElements(tableData_xpath);
            for (int i = 0; i < tableRecordSize.size(); i++) {

                setPropertyVal(tableData_xpath2, Integer.toString(i+1));
                actionsMovetoElement(tableData_xpath);
                String toolTipText = getText(toolTipText_xpath);

                if (toolTipText.equalsIgnoreCase(getPropertyVal(indexFileText_val))) {
                    setPropertyVal(touchRipple_xpath2, Integer.toString(i+1));
                    actionsClick(touchRipple_xpath);
                    if (getText(renameIndex_xpath).equalsIgnoreCase(option)) {
                        driverWaitClick(renameIndex_xpath);
                        String renameIndex = getAlphaNumericString(7);
                        clearType(renameIndexInput_xpath, renameIndex);
                        clickWithOutWait(renameIndexSaveBtn_xpath);
                        String actAlertMsg = getText(indexSuccesAlertMsg_xpath);
                        setPropertyVal("actIndexSuccessAlrtMsg", actAlertMsg);
                        setPropertyVal("expIndexSuccessAlrtMsg", getPropertyVal(updateIndexSuccesAlertMsg_val));
                        compareTwoEqualValues("expIndexSuccessAlrtMsg", "actIndexSuccessAlrtMsg");
                        break;
                    } else if (getText(editIndex_xpath).equalsIgnoreCase(option)) {
                        driverWaitClick(editIndex_xpath);
                        String renameIndex = getAlphaNumericString(8);
                        clearType(renameIndexInput_xpath, renameIndex);
                        clickWithOutWait(renameIndexSaveBtn_xpath);
                        String actAlertMsg = getText(indexSuccesAlertMsg_xpath);
                        setPropertyVal("actIndexSuccessAlrtMsg", actAlertMsg);
                        setPropertyVal("expIndexSuccessAlrtMsg", getPropertyVal(editIndexSuccessAlertMsg_val));
                        compareTwoEqualValues("expIndexSuccessAlrtMsg", "actIndexSuccessAlrtMsg");
                        break;
                    } else if (getText(deleteIndex_xpath).equalsIgnoreCase(option)) {
                        driverWaitClick(deleteIndex_xpath);
                        clickWithOutWait(areYouSureDeleteIndexBtn_xpath);
                        String actAlertMsg = getText(indexSuccesAlertMsg_xpath);
                        setPropertyVal("actIndexSuccessAlrtMsg", actAlertMsg);
                        setPropertyVal("expIndexSuccessAlrtMsg", getPropertyVal(dleteIndexAlertMsg_val));
                        compareTwoEqualValues("expIndexSuccessAlrtMsg", "actIndexSuccessAlrtMsg");
                        break;

                    }
                }
            }


        }
    }

    private void verifyNoIdexesAvalableInTable() throws ConfigurationException {

        if (getText(noIdexesAvailable_xpath).equalsIgnoreCase(getPropertyVal(noIdexesAvailable_val))) {

            logPass("No Indexes Available data got populated in the table grid.");
        } else {
            logFail("No Indexes Available Data did NOT got populated in the table grid.");

        }

    }

    public void indexEditForXmlSiteMap(String option) throws ConfigurationException {
        if (isElementVisible(noIdexesAvailable_xpath)) {
            verifyNoIdexesAvalableInTable();
        } else {
            setPropertyVal(tableData_xpath2, "1");
            List tableRecordSize = getElements(tableData_xpath);
            for (int i = 0; i < tableRecordSize.size(); i++) {

                setPropertyVal(tableData_xpath2, Integer.toString(i+1));
                actionsMovetoElement(tableData_xpath);
                String toolTipText = getText(toolTipText_xpath);
                if (toolTipText.equalsIgnoreCase(getPropertyVal(siteMapXML_val))) {
                    setPropertyVal(touchRipple_xpath2, Integer.toString(i+1));
                    actionsClick(touchRipple_xpath);
                    if (getText(renameIndex_xpath).equalsIgnoreCase(option)) {
                        driverWaitClick(renameIndex_xpath);
                        String renameIndex = getAlphaNumericString(7);
                        clearType(renameIndexInput_xpath, renameIndex);
                        clickWithOutWait(renameIndexSaveBtn_xpath);
                        String actAlertMsg = getText(indexSuccesAlertMsg_xpath);
                        setPropertyVal("actIndexSuccessAlrtMsg", actAlertMsg);
                        setPropertyVal("expIndexSuccessAlrtMsg", getPropertyVal(updateIndexSuccesAlertMsg_val));
                        compareTwoEqualValues("expIndexSuccessAlrtMsg", "actIndexSuccessAlrtMsg");
                        break;
                    } else if (getText(editIndex_xpath).equalsIgnoreCase(option)) {
                        driverWaitClick(editIndex_xpath);
                        String renameIndex = getAlphaNumericString(8);
                        clearType(renameIndexInput_xpath, renameIndex);
                        driverWaitClick(createIndexNextButton_xpath);
                        driverWaitClick(createIndexNextButton_xpath);
                        driverWaitClick(createIndexNextButton_xpath);
                        clickWithOutWait(createIndexButton_xpath);
                        String actAlertMsg = getText(indexSuccesAlertMsg_xpath);
                        setPropertyVal("actIndexSuccessAlrtMsg", actAlertMsg);
                        setPropertyVal("expIndexSuccessAlrtMsg", getPropertyVal(editIndexSuccessAlertMsg_val));
                        compareTwoEqualValues("expIndexSuccessAlrtMsg", "actIndexSuccessAlrtMsg");
                        break;
                    } else if (getText(updateIndex_xpath).equalsIgnoreCase(option)) {
                        driverWaitClick(updateIndex_xpath);
                        clickWithOutWait(indexUpdateNowButton_xpath);
                        String actAlertMsg = getText(indexSuccesAlertMsg_xpath);
                        setPropertyVal("actIndexSuccessAlrtMsg", actAlertMsg);
                        setPropertyVal("expIndexSuccessAlrtMsg", getPropertyVal(editIndexSuccessAlertMsg_val));
                        compareTwoEqualValues("expIndexSuccessAlrtMsg", "actIndexSuccessAlrtMsg");
                        break;
                    } else if (getText(deleteIndex_xpath).equalsIgnoreCase(option)) {
                        driverWaitClick(deleteIndex_xpath);
                        clickWithOutWait(areYouSureDeleteIndexBtn_xpath);
                        String actAlertMsg = getText(indexSuccesAlertMsg_xpath);
                        setPropertyVal("actIndexSuccessAlrtMsg", actAlertMsg);
                        setPropertyVal("expIndexSuccessAlrtMsg", getPropertyVal(dleteIndexAlertMsg_val));
                        compareTwoEqualValues("expIndexSuccessAlrtMsg", "actIndexSuccessAlrtMsg");
                        break;

                    }
                }
            }


        }
    }

    public void dismissUpdateNowIfPresent() {
        if (isElementVisible(updateIndexCancelBtn_xpath)) {
            driverWaitClick(updateIndexCancelBtn_xpath);
        }
    }

    public void verifyExportFileInSurveys() throws ConfigurationException, IOException, CsvValidationException {
        for (int i = 1; i <= 3; i++) {
            driverWaitClick(surveysDropdown_xpath);
            setPropertyVal(surveysDrpDownList_xpath2, Integer.toString(i));
            String dropdownText = getText(surveysDrpDownList_xpath);
            driverWaitClick(surveysDrpDownList_xpath);
            if (getText(surveysNoData_xpath).equalsIgnoreCase(getPropertyVal(surveysNodata_val))) {
                verifyNoDataValueInSurveys(dropdownText);
                if (getElement(surveysExportButton_xpath).isEnabled()) {
                    logFail("Export button is present, and is NOT disabled.");
                }
            } else {
                if (getElement(surveysExportButton_xpath).isEnabled()) {
                    deleteALLFilesInDownload();
                    click(surveysExportButton_xpath);
                    log("Clicked on " + dropdownText + " type export button");
                    if(verifyWhetherDataIsExported()==true){
                        List<String> actEntireColDate = getColDataInExpFile("User Type");

                    }
                    if (getElement(surveysExportButton_xpath).isEnabled()) {
                        logPass("After download the Export file,Export button is present, and is NOT disabled.");
                    } else {
                        logFail("After download the Export file,Export button is present, and is disabled.");
                    }

                } else {
                    logFail("Export button is present, and is disabled.");
                }

            }
        }
    }

    public void verifyNoDataValueInSurveys(String text) throws ConfigurationException {
        if (getText(surveysNoData_xpath).equalsIgnoreCase(getPropertyVal(surveysNodata_val))) {
            logPass(text+" Selected from Host Drop down No Data got populated in the table grid.");
        } else {
            logFail(text+" Selected from Host Drop down No Data did NOT got populated in the table grid.");
        }
    }


    public void verifySortingOrderIntelligent(String ascLocator, String descLocator, String colLocator) throws ConfigurationException {

        verifyASCSortingOrderStringInGridIntelligent(ascLocator, colLocator);
        verifyDESCSortingOrderStringInGridIntelligent(descLocator, colLocator);

    }

    public void verifyASCSortingOrderStringInGridIntelligent(String ascOrderlocatorKey, String colLocatorKey) throws ConfigurationException {
        List<String> orgEntireCoLDate = getColDataInTableIntelligent(colLocatorKey);
        Collections.sort(orgEntireCoLDate);
//        actionsMovetoElement();
        actionsClick(ascOrderlocatorKey);
        List<String> actEntireColDate = getColDataInTableIntelligent(colLocatorKey);
        int iCounterVal = 0;
        for (int iVal = 0; iVal < orgEntireCoLDate.size(); iVal++) {
            if (!actEntireColDate.get(iVal).toString().equalsIgnoreCase(orgEntireCoLDate.get(iVal).toString())) {

                String statementToLog = sortingFailureStatementVal(orgEntireCoLDate, actEntireColDate, iVal, colLocatorKey.split("_")[0], "Ascending");
                logFailWithOutScreenshot(statementToLog);
                iCounterVal = iCounterVal + 1;
                break;

            }
        }
        if (iCounterVal == 0) {
            logPass(colLocatorKey.split("_")[0] + " got sorted in ascending order successfully.");
        }
    }

    public List<String> getColDataInTableIntelligent(String locatorKey) throws ConfigurationException {
        List<WebElement> elements = getElements(locatorKey);
        List<String> listVal = new ArrayList<String>();
        int rowCountsPerPage = getSessionActTableRowsCount();
        if (rowCountsPerPage == 0) {
            verifyNoIndexesAvailableInIntelligentSearchPage();
        } else {

            for (WebElement element : elements) {
                listVal.add(element.getText());
            }

        }
        String s = "abc";

        return listVal;
    }

    public void verifyDESCSortingOrderStringInGridIntelligent(String descOrderlocatorKey, String colLocatorKey) throws ConfigurationException {
        List<String> orgEntireCoLDate = getColDataInTableIntelligent(colLocatorKey);
        Collections.sort(orgEntireCoLDate, Collections.reverseOrder());
        jsclick(descOrderlocatorKey);
        List<String> actEntireColDate = getColDataInTableIntelligent(colLocatorKey);
        int iCounterVal = 0;
        for (int iVal = 0; iVal < orgEntireCoLDate.size(); iVal++) {
            if (!actEntireColDate.get(iVal).toString().equalsIgnoreCase(orgEntireCoLDate.get(iVal).toString())) {

                String statementToLog = sortingFailureStatementVal(orgEntireCoLDate, actEntireColDate, iVal, colLocatorKey.split("_")[0], "Descending");
                logFailWithOutScreenshot(statementToLog);
                iCounterVal = iCounterVal + 1;
                break;

            }
        }
        if (iCounterVal == 0) {
            logPass(colLocatorKey.split("_")[0] + " got sorted in descending order successfully.");
        }

    }


    public void custDateClearInSurveys() throws ConfigurationException {
        if (getElement(clearButton_xpath).isEnabled()) {
            driverWaitClick(clearButton_xpath);
        }

    }


    public static List<String> readEachcolumndata(String filePath, int column, String removeHeader) {
        String[] nextLine = {""};
        List<String> nextLine1 = new ArrayList<>();
        try {
            //csv file containing data
            String strFile = "D:\\FunctionalScripts_User\\FunctionalScripts_Analyst\\FunctionalScripts_Analyst\\src\\main\\java\\configuration\\Users_20220710_220448.csv";
            CSVReader reader = new CSVReader(new FileReader(filePath));

            int lineNumber = 0;
            while ((nextLine = reader.readNext()) != null) {
                lineNumber++;
                nextLine1.add(nextLine[column]);
                nextLine1.remove(removeHeader);
            }
            reader.close();
        } catch (Exception e) {
            e.printStackTrace();

        }
        return nextLine1;

    }

    public void verifyUsersTableDataWithSheetData(String colLocatorKey, String removeHeader) throws ConfigurationException, CsvValidationException, IOException {
        List<String> orgEntireCoLData = getColDataInTable(colLocatorKey);
        Collections.sort(orgEntireCoLData);
        driverWaitClick(exportBtn_xpath);
        if (verifyWhetherDataIsExported() == true) {
            List<String> namedataSheet = getColDataInExpFile(removeHeader);
            namedataSheet.remove(removeHeader);
            Collections.sort(namedataSheet);
            wait(20);
            namedataSheet.removeAll(orgEntireCoLData);
            if (namedataSheet.size() == 0) {
                logPass("Data between the " + removeHeader + " column, in application and in exported file got matched up");

            } else {
                logFail(namedataSheet + "These  error data populated in Names column");

            }
        }

    }

//

    public void verifyUsersTableDateValidationWithSheetData(String colLocatorKey, String colName, String dateFormatVal, String dateFormataVal1) throws ConfigurationException, CsvValidationException, IOException, ParseException {
        List<String> orgEntireCoLData = getColDataInTable(colLocatorKey);
        List<String> orgEntireColDateVal = new ArrayList<String>();
        List<String> actEntireColDateVal = new ArrayList<String>();
        driverWaitClick(exportBtn_xpath);
        if (verifyWhetherDataIsExported() == true) {
            if (colName.equalsIgnoreCase("Joined Date")) {
                List<String> actEntireColDate = getColDataInExpFile(colName);
                for (String element : actEntireColDate) {
                    if (element.equalsIgnoreCase("")) {
//                actEntireColDateVal.add("");
                    } else {
                        actEntireColDateVal.add(convertTheDateFormatNRetStr(element, dateFormatVal, "EEE, MMM dd yyyy"));
                    }
                }
                actEntireColDateVal.remove(colName);
                Collections.sort(actEntireColDateVal);
                actEntireColDateVal.remove("");
                actEntireColDateVal.removeAll(orgEntireCoLData);
            }

        } else {
            for (String element : orgEntireCoLData) {
                if (element.equalsIgnoreCase("")) {
//            orgEntireColDateVal.add("");
                } else {
                    orgEntireColDateVal.add(convertTheDateFormatNRetStr(element, dateFormataVal1, "EEE d MMMM yyyy HH:mm"));
                }
            }
            Collections.sort(orgEntireColDateVal);
            List<String> actEntireColDate = getColDataInExpFile(colName);
            for (String element : actEntireColDate) {
                if (element.equalsIgnoreCase("")) {
//                actEntireColDateVal.add("");
                } else {
                    actEntireColDateVal.add(convertTheDateFormatNRetStr(element, dateFormatVal, "EEE d MMMM yyyy HH:mm"));
                }

            }
            actEntireColDateVal.remove(colName);
            Collections.sort(actEntireColDateVal);
            actEntireColDateVal.remove("");
            actEntireColDateVal.removeAll(orgEntireColDateVal);

        }

        if (actEntireColDateVal.size() == 0) {
            logPass("Data between the " + colName + " column, in application and in exported file got matched up");

        } else {
            logFail(actEntireColDateVal + "These  error data populated in Names column" + orgEntireColDateVal);

        }
    }

    public void verifyWhetherQrCodeIsDownloaded() throws CsvValidationException, IOException {
        String[] filesVal=getFilesInDownloadDir(System.getProperty("user.dir")+"\\download");
        if(filesVal.length==1)
        {
            logPass("QRCode file got downloaded");

        }
        else if(filesVal.length>1)
        {
            logFail("Multiple QRCode files got downloaded.");

        }
        else
        {
            logFail("QRCode file did not get downloaded ");

        }
    }


    public List<String> findBrokenLinks(List<String> urlLinksList) throws IOException {
        List<String> invalidlinks=new ArrayList<>();
        for (String urlLink : urlLinksList) {

            /*linkUrl = E1.getAttribute("href");*/
            if (!urlLink.isEmpty()) {
                java.net.URL url = new URL(urlLink);
                HttpURLConnection httpURLConnect = (HttpURLConnection) url.openConnection();
                httpURLConnect.setConnectTimeout(5000);
                httpURLConnect.connect();
                if (httpURLConnect.getResponseCode() >= 400) {
                    System.out.println(urlLink + " - " + httpURLConnect.getResponseMessage() + "is a broken link");
                    invalidlinks.add(urlLink);
                }
            }
        }
        return invalidlinks;
    }

    public void verifyEcperienceTblUrl(String colLocatorKey) throws ConfigurationException, IOException {
        List<String> orgEntireCoLDate=getColDataInTable(colLocatorKey);
        List<String> brokenLinks=findBrokenLinks(orgEntireCoLDate);
        if(brokenLinks.size()==0){
            logPass("All URl's displayed in Experiences table url colum are valid links");
        }else {

            logFail(brokenLinks+" are broken links displayed in Experiences table url colum ");
        }

    }

    public void verifyExperienceUpgradeplanText() throws ConfigurationException {
        String actText=getText(upgradePlanTab_xpath);
        String actText1=getText(experiencesUpgradePlanText_xpath);
        String actText2=getText(experiencesUpgradeBuildText_xpath);
        setPropertyVal("ExperinceActText",actText);
        setPropertyVal("ExperinceExpText",getPropertyVal(upgradePlanTab_val));
        compareTwoEqualValues("ExperinceExpText","ExperinceActText");
        setPropertyVal("ExperinceActText",actText1);
        setPropertyVal("ExperinceExpText",getPropertyVal(experiencesUpgradePlanText_val));
        compareTwoEqualValues("ExperinceExpText","ExperinceActText");
        setPropertyVal("ExperinceActText",actText2);
        setPropertyVal("ExperinceExpText",getPropertyVal(experiencesUpgradeBuildText_val));
        compareTwoEqualValues("ExperinceExpText","ExperinceActText");
    }

    public void scrollBarNavToRightNLeft() throws ConfigurationException {
        int rowsCountVal=Integer.parseInt(getEntireTableCountForCol());
        if(rowsCountVal==0)
        {
            verifyNoDataValueInSessActTable();
        }
        else {

            if (getAttributeVal(tableleftScrollBtnDsable_xpath, "class").equalsIgnoreCase(getPropertyVal(tableleftScrollBtnDsable_val))) {
                do {

                    driverWaitClick(tableRightScrollBtn_xpath);

                } while (!getAttributeVal(tableRightScrollBtnDsable_xpath, "class").toString().equalsIgnoreCase(getPropertyVal(tableRightScrollBtnDsable_val)));

                if (getAttributeVal(tableRightScrollBtnDsable_xpath, "class").equalsIgnoreCase(getPropertyVal(tableRightScrollBtnDsable_val))) {
                    logPass("Table scroll bar navigated to right side");
                } else {
                    logFail("Table scroll bar did not navigated to right side");
                }
            }
            if (getAttributeVal(tableRightScrollBtnDsable_xpath, "class").equalsIgnoreCase(getPropertyVal(tableRightScrollBtnDsable_val))) {

                do {
                    driverWaitClick(tableLeftScrollBtn_xpath);
                } while (!getAttributeVal(tableleftScrollBtnDsable_xpath, "class").equalsIgnoreCase(getPropertyVal(tableleftScrollBtnDsable_val)));

                if (getAttributeVal(tableleftScrollBtnDsable_xpath, "class").toString().equalsIgnoreCase(getPropertyVal(tableleftScrollBtnDsable_val))) {

                    logPass("Table scroll bar navigated to left side");
                } else {
                    logFail("Table scroll bar did not navigated to left side");
                }
            }
        }
    }

    public void verifySessionMapOptions() throws ConfigurationException {
        String actText=getText(sessionMapControlZoom_xpath);
        setPropertyVal("sessionMapPageActText",actText);
        setPropertyVal("sessionMapPageExpText",getPropertyVal(sessionMapControlZoom_val));
        compareTwoEqualValues("sessionMapPageExpText","sessionMapPageActText");
        verifyMarkersInSessionMap();
    }

    public void verifyMarkersInSessionMap(){
        if(isElementVisible(sessionMapHostMarker_xpath)){
            logPass("Session map Host marker pin displayed");
        }else{
            logFail("Session map Host marker pin did not get displayed");
        }

        if(isElementVisible(sessionMapGuestMarker_xpath)){
            logPass("Session map Guest marker pin displayed");
        }else{
            logFail("Session map Guest marker pin did not get displayed");
        }

        if(isElementVisible(sessionMapSwitchSlider_xpath)){
            logPass("Session map Group Marker slider displayed");
        }else{
            logFail("Session map Group Marker slider did not get displayed");
        }
    }

    public void verifyDeleteOfImageIsDisplayedOrNot() throws ConfigurationException, IOException, CsvValidationException {
//        setApplPropFilePath("sessionActivity.properties");
        int rowsCountVal = Integer.parseInt(getEntireTableCountForCol());
        if (rowsCountVal == 0) {
            verifyNoDataValueInSessActTable();
        } else if (rowsCountVal <= 25) {
            int rowCountVal = Integer.parseInt(getEntireTableCountForCol());
            if (!isElementVisible(noImgDeleteButton_xpath)) {
                String pageNumberVal = "1";
                logPass("On Page No: " + pageNumberVal + " Image delete button did not get displayed");
            }else {
            for (int i = 1; i <= rowCountVal; i++) {
                setPropertyVal("imgDeleteButton_xpath2", Integer.toString(i));
                int noOfImgsPerRow = getElements(imgsPerRowDlT_xpath).size();
//                if (noOfImgsPerRow > 0) {
                deleteALLFilesInDownload();
                setPropertyVal("imgDeleteButton_xpath5", Integer.toString(1));
                if (isElementVisible(imgDeleteButton_xpath)) {
                    int noOfImgsPerRow1 = getElements(imgsPerRowDlT_xpath).size();
                    String pageNumberVal = "1";
                    String rowNumberVal = Integer.toString(i);
                    String imageNoVal = Integer.toString(1);
                    if (noOfImgsPerRow1 == noOfImgsPerRow - 1) {
                        logFail("On Page No: " + pageNumberVal + " and at rownumber " + rowNumberVal + " and the image no: " + imageNoVal + " has delete button.");
                        break;
                    }
                }
            }
//                }
            }

        } else {
            deleteALLFilesInDownload();
            int rowCountVal = Integer.parseInt(getEntireTableCountForCol());
            int reminderVal = rowCountVal % 25;
            int totalNoOfNavs;
            int noOfTimes = rowCountVal / 25;
            if (reminderVal > 0) {
                totalNoOfNavs = noOfTimes;
                if (!isElementVisible(noImgDeleteButton_xpath)) {
                    logPass("Image delete button not get displayed");

                } else {
                    for (int i = 1; i <= totalNoOfNavs; i++) {

                        for (int j = 1; j <= 25; j++) {
                            setPropertyVal("imgDeleteButton_xpath2", Integer.toString(j));

                            int noOfImgsPerRow = getElements(imgsPerRowDlT_xpath).size();
                            if (noOfImgsPerRow > 0) {
                                deleteALLFilesInDownload();
                                setPropertyVal("imgDeleteButton_xpath5", Integer.toString(1));
                                if (isElementVisible(imgDeleteButton_xpath)) {
                                    int noOfImgsPerRow1 = getElements(imgsPerRowDlT_xpath).size();
                                    String pageNumberVal = "1";
                                    String rowNumberVal = Integer.toString(i);
                                    String imageNoVal = Integer.toString(1);
                                    if (noOfImgsPerRow1 == noOfImgsPerRow - 1) {
                                        logFail("On Page No: " + pageNumberVal + " and at rownumber " + rowNumberVal + " and the image no: " + imageNoVal + " has delete button.");
                                        break;
                                    }
                                }
                            }

                        }

                    }
                    click(navRightArrowButton_xpath);

                }
                if (!isElementVisible(noImgDeleteButton_xpath)) {
                    logPass("Image delete button not get displayed");

                } else {
                    for (int j = 1; j <= reminderVal; j++) {
                        setPropertyVal("imgDeleteButton_xpath2", Integer.toString(j));

                        int noOfImgsPerRow = getElements(imgsPerRowDlT_xpath).size();
                        if (noOfImgsPerRow > 0) {
                            deleteALLFilesInDownload();
                            setPropertyVal("imgDeleteButton_xpath5", Integer.toString(1));
                            if (isElementVisible(imgDeleteButton_xpath)) {
                                int noOfImgsPerRow1 = getElements(imgsPerRowDlT_xpath).size();
                                String pageNumberVal = "1";
                                String rowNumberVal = Integer.toString(j);
                                String imageNoVal = Integer.toString(1);
                                if (noOfImgsPerRow1 == noOfImgsPerRow - 1) {
                                    logFail("On Page No: " + pageNumberVal + " and at rownumber " + rowNumberVal + " and the image no: " + imageNoVal + " has delete button.");
                                    break;
                                }
                            }

                        }
                    }
                }
            } else {
                totalNoOfNavs = noOfTimes - 1;
                if (!isElementVisible(noImgDeleteButton_xpath)) {
                    logPass("Image delete button not get displayed");

                } else {
                    for (int i = 1; i <= totalNoOfNavs; i++) {
                        for (int j = 1; j <= 25; j++) {
                            setPropertyVal("imgDeleteButton_xpath2", Integer.toString(j));
                            int noOfImgsPerRow = getElements(imgsPerRowDlT_xpath).size();
                            if (noOfImgsPerRow > 0) {
                                deleteALLFilesInDownload();
                                setPropertyVal("imgDeleteButton_xpath5", Integer.toString(1));
                                if (isElementVisible(imgDeleteButton_xpath)) {
                                    int noOfImgsPerRow1 = getElements(imgsPerRowDlT_xpath).size();
                                    String pageNumberVal = "1";
                                    String rowNumberVal = Integer.toString(i);
                                    String imageNoVal = Integer.toString(1);
                                    if (noOfImgsPerRow1 == noOfImgsPerRow - 1) {
                                        logFail("On Page No: " + pageNumberVal + " and at rownumber " + rowNumberVal + " and the image no: " + imageNoVal + " has delete button.");
                                        break;
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }

    }

    public void dragAndDrop(String from,String to) throws ConfigurationException {
         WebElement From=getElement(from);
         WebElement To=getElement(to);
        Actions act = new Actions(driver);
        act.dragAndDrop(From,To).build().perform();
    }

    public void deleteTenantsWithSpfc(String emailIDVal) throws ConfigurationException {
        List<String> tenantAdminEmails=getTenantAdminColDataInTable(tenantAdminEmailVal_xpath);
        for(String emailIDValue:tenantAdminEmails)
        {
            if(emailIDVal.contains("automation"))
            {
                type(tenantAdminSearch_xpath,emailIDValue);
                jsclick(searchTenantAdminButton_xpath);
                setPropertyVal(tenantRowVal_xpath,Integer.toString(1));
                jsclick(tenantadmin_xpathrow);
                jsclick(tenantAdminDelete_xpath);
                jsclick(deleteButtonTenantAdmin_xpath);
                wait(50);
                clear(tenantAdminSearch_xpath);
            }
        }
        /*List<WebElement> elements = getElements(tenantadmin_xpath);
        int rowCountsPerPage = getSuperTenantAdminRowCount();
        int fullCountVal = Integer.parseInt(getEntireTableCountForCol());
        int totalRowCount = 0;
        if (fullCountVal == 0) {
            if (getText(noDataInTable_xpath).equalsIgnoreCase(getPropertyVal(noDataInTable_val))) {
                logPass("No Data got populated in the table grid.");
            } else {
                logFail("No Data did NOT got populated in the table grid.");
            }
        } else {
            if (rowCountsPerPage < 25 && rowCountsPerPage == fullCountVal) {
                for (int iVal=1; iVal<=elements.size();iVal++)
                {
                    setPropertyVal(tenantRowVal_xpath,Integer.toString(iVal));
                    if(getText(tenantAdminEmail_xpath).contains(emailIDVal))
                    {
                        jsclick(tenantadmin_xpathrow);
                        jsclick(tenantAdminDelete_xpath);
                        jsclick(deleteButtonTenantAdmin_xpath);
                        wait(50);

                    }
                }

            } else {
                do {
                    List<WebElement> elements1 = getElements(tenantadmin_xpath);
                    for (int iVal=1; iVal<=elements1.size();iVal++)
                    {
                        setPropertyVal(tenantRowVal_xpath,Integer.toString(iVal));
                        if(getText(tenantAdminEmail_xpath).contains(emailIDVal))
                        {
                            jsclick(tenantadmin_xpathrow);
                            jsclick(tenantAdminDelete_xpath);
                            jsclick(deleteButtonTenantAdmin_xpath);
                            wait(50);

                        }
                    }
                    click(navRightArrowButton_xpath);
                    int rowCountsPerPage1 = getSessionActTableRowsCount();
                    if (rowCountsPerPage1 < 25) {
                        List<WebElement> elements2 = getElements(tenantadmin_xpath);
                        for (int iVal=1; iVal<=elements2.size();iVal++)
                        {
                            setPropertyVal(tenantRowVal_xpath,Integer.toString(iVal));
                            if(getText(tenantAdminEmail_xpath).contains(emailIDVal))
                            {
                                jsclick(tenantadmin_xpathrow);
                                jsclick(tenantAdminDelete_xpath);
                                jsclick(deleteButtonTenantAdmin_xpath);
                                wait(50);

                            }
                        }
                    }

                } while (!getAttributeVal(navRghtEnbDisbl_xpath, "class").toString().equalsIgnoreCase(getPropertyVal(navDisbl_clssval)));
            }
        }
        String s = "abc";
*/

    }

    public int getSuperTenantAdminRowCount() throws ConfigurationException {
        List<WebElement> elements = getElements(tenantadmin_xpath);
        int rowsCount = elements.size();
        return rowsCount;
    }

    public List<String> getTenantAdminColDataInTable(String locatorKey) throws ConfigurationException {
        List<WebElement> elements = getElements(locatorKey);
        List<String> listVal = new ArrayList<String>();
        int rowCountsPerPage = getSuperTenantAdminRowCount();
        int fullCountVal = Integer.parseInt(getEntireTableCountForCol());
        int totalRowCount = 0;
        if (fullCountVal == 0) {
            if (getText(noDataInTable_xpath).equalsIgnoreCase(getPropertyVal(noDataInTable_val))) {
                logPass("No Data got populated in the table grid.");
            } else {
                logFail("No Data did NOT got populated in the table grid.");
            }
        } else {
            if (rowCountsPerPage < 25 && rowCountsPerPage == fullCountVal) {
                for (WebElement element : elements) {
                    listVal.add(element.getText());
                }

            } else {
                do {
                    List<WebElement> elements1 = getElements(locatorKey);
                    for (WebElement element : elements1) {
                        listVal.add(element.getText());
                    }
                    click(navRightArrowButton_xpath);
                    int rowCountsPerPage1 = getSuperTenantAdminRowCount();
                    if (rowCountsPerPage1 < 25) {
                        List<WebElement> elements2 = getElements(locatorKey);
                        for (WebElement element : elements2) {
                            listVal.add(element.getText());
                        }
                    }

                } while (!getAttributeVal(navRghtEnbDisbl_xpath, "class").toString().equalsIgnoreCase(getPropertyVal(navDisbl_clssval)));
            }
        }
        String s = "abc";

        return listVal;
    }

    public void addNewUser() throws ConfigurationException {
        String addNewUserVal=getPropertyVal("addUserValues");
        for(int i=1;i<addNewUserVal.split(",").length+1;i++) {
            driverWaitClick(addNewUseBtn_xpath);
            String emailId = "automation" + getRandomNumericValue(4) + "@gmail.com";
            String fname = "auto" + getAlphaNumericString(4);
            String lname = "auto" + getAlphaNumericString(4);
            String pphNumber = "+91" + getRandomNumericValue(10);
            String sphNumber = "+91" + getRandomNumericValue(10);
            String jobDesctiption = "Description " + getRandomNumericValue(4);
            clearType(userEditPageEmailInput_id, emailId);
            clearType(userEditPageFirstNameInput_id, fname);
            clearType(userEditPageLastnameInput_id, lname);
            clearType(userEditPagePrimaryPhNumber_id, pphNumber);
            clearType(userEditPageSecondaryPhNumberInput_id, sphNumber);
            clearType(userEditPageJobDescriptionInput_id, jobDesctiption);
            jsclick(usersEditPageRoleDropdown_xpath);
            setPropertyVal(selectRoleFrmDropDown_xpath2,Integer.toString(i));
            driverWaitClick(selectRoleFrmDropDown_xpath);
            String selectedRoleText=getText(selectedRoleVal_xpath);
            verifyUserGroup();
            clickWithOutWait(userEditPageSaveButton_xpath);
            String alertMsg=getText(imageSuccessAlertMsg_xpath);
            setPropertyVal("actAlertMsg",alertMsg);
            setPropertyVal("expAlertMsg",getPropertyVal(userAddedAlrtMsg_val));
            compareTwoEqualValues("expAlertMsg","actAlertMsg");
            log("User has been created with role \" "+selectedRoleText+"\" with user Id \" "+emailId);
        }
    }
    public String verifyUserGroup() throws ConfigurationException {
        String groupNameText="";
        if(isElementVisible(addNewUserGroup_xpath)){
            driverWaitClick(addNewUserGroup_xpath);
            String groupName=getAlphaNumericString(5);
            clearType(groupNameInput_id,groupName);
            clickWithOutWait(grpNameAddBtn_xpath);
            String alertMsg=getText(imageSuccessAlertMsg_xpath);
            setPropertyVal("grpAddedActAlertMsg",alertMsg);
            setPropertyVal("grpAddedExpAlertMsg",getPropertyVal(grpAddSuccessAlrtMsg_val));
            compareTwoEqualValues("grpAddedExpAlertMsg","grpAddedActAlertMsg");
            groupNameText=getText(selectedUserGroupText_xpath);
            log("Selected group name is \" "+groupNameText);
        }else {
            jsclick(userEditPageUserGroup_xpath);
            setPropertyVal(selectUserGrp_xpath2,Integer.toString(1));
            jsclick(selectUserGrp_xpath);
            groupNameText=getText(selectedUserGroupText_xpath);
            log("Selected group name is \" "+groupNameText);
        }
        return groupNameText;
    }

    public void verifyDeleteUser() throws ConfigurationException {
        type(usersPageSearchBox_xpath,"automation");
        if (getEntireTableCountForCol().equalsIgnoreCase("0")) {
            verifyNoDataValueInSessActTable();
        }else {
            String emaliIdVal = getText(usersTableEmail_xpath);
            setPropertyVal(tableRow_xpath2,"1");
            actionsMovetoElement(tableRow_xpath);
            setPropertyVal(usersDeleteRecordButton_xpath2, "1");
            driverWaitClick(usersDeleteRecordButton_xpath);
            clickWithOutWait(areYouSurePopUpConfirmBtn_xpath);
            String alertMsg = getText(imageSuccessAlertMsg_xpath);
            setPropertyVal("actAlertMsg", alertMsg);
            setPropertyVal("expAlertMsg", getPropertyVal(userDeletedAlrtMsg_val));
            compareTwoEqualValues("expAlertMsg", "actAlertMsg");
            log("User has been deleted with user id \" " + emaliIdVal);
        }
    }

    public void verifyDisableAndEnableUser() throws ConfigurationException {
        String emaliIdVal="";
        String alertMsg="";
        type(usersPageSearchBox_xpath,"automation");
        if (getEntireTableCountForCol().equalsIgnoreCase("0")) {
            verifyNoDataValueInSessActTable();
        }else {
            emaliIdVal = getText(usersTableEmail_xpath);
            setPropertyVal(tableRow_xpath2,"1");
            actionsMovetoElement(tableRow_xpath);
            setPropertyVal(usersEnableOrDisableRecord_xpath2, "1");
            driverWaitClick(usersEnableOrDisableRecord_xpath);
            clickWithOutWait(areYouSurePopUpConfirmBtn_xpath);
            alertMsg = getText(imageSuccessAlertMsg_xpath);
            setPropertyVal("actAlertMsg", alertMsg);
            setPropertyVal("expAlertMsg", getPropertyVal(userDisableAlrtMsg_val));
            compareTwoEqualValues("expAlertMsg", "actAlertMsg");
            log("User has been Disabled with user id \" " + emaliIdVal);

             emaliIdVal = getText(usersTableEmail_xpath);
            setPropertyVal(tableRow_xpath2,"1");
            actionsMovetoElement(tableRow_xpath);
            setPropertyVal(usersEnableOrDisableRecord_xpath2, "1");
            driverWaitClick(usersEnableOrDisableRecord_xpath);
            clickWithOutWait(areYouSurePopUpConfirmBtn_xpath);
            alertMsg = getText(imageSuccessAlertMsg_xpath);
            setPropertyVal("actAlertMsg", alertMsg);
            setPropertyVal("expAlertMsg", getPropertyVal(userEnableAlrtMsg_val));
            compareTwoEqualValues("expAlertMsg", "actAlertMsg");
            log("User has been Enabled with user id \" " + emaliIdVal);
        }
    }

    public void verifyEditBtnInUsersGrid() throws ConfigurationException {
        String nameVal="";
        String alertMsg="";
        type(usersPageSearchBox_xpath,"automation");
        if (getEntireTableCountForCol().equalsIgnoreCase("0")) {
            verifyNoDataValueInSessActTable();
        }else {
            nameVal = getText(usersTableName_xpath);
            setPropertyVal(tableRow_xpath2,"1");
            actionsMovetoElement(tableRow_xpath);
            setPropertyVal(usersEditRecordButton_xpath2, "1");
            driverWaitClick(usersEditRecordButton_xpath);
            String fname = "auto" + getAlphaNumericString(4);
            String lname = "auto" + getAlphaNumericString(4);
            String pphNumber = "+91" + getRandomNumericValue(10);
            String sphNumber = "+91" + getRandomNumericValue(10);
            String jobDesctiption = "Description " + getRandomNumericValue(4);
            clearType(userEditPageFirstNameInput_id, fname);
            clearType(userEditPageLastnameInput_id, lname);
            clearType(userEditPagePrimaryPhNumber_id, pphNumber);
            clearType(userEditPageSecondaryPhNumberInput_id, sphNumber);
            clearType(userEditPageJobDescriptionInput_id, jobDesctiption);
            clickWithOutWait(userEditPageSaveButton_xpath);
            alertMsg = getText(imageSuccessAlertMsg_xpath);
            setPropertyVal("actAlertMsg", alertMsg);
            setPropertyVal("expAlertMsg", getPropertyVal(userUpdateSuccessAlrtMsg_val));
            compareTwoEqualValues("expAlertMsg", "actAlertMsg");
            String nameVal1=fname+" "+lname;
            log(nameVal+ "\" user name has been updated with name  \" "+ nameVal1+"\"");

        }
    }

    public void addGroup() throws ConfigurationException {
        driverWaitClick(addGroupBtn_xpath);
        String groupName=getAlphaNumericString(5);
        clearType(groupNameInput_id,groupName);
        clickWithOutWait(grpNameAddBtn_xpath);
        String alertMsg=getText(imageSuccessAlertMsg_xpath);
        setPropertyVal("grpAddedActAlertMsg",alertMsg);
        setPropertyVal("grpAddedExpAlertMsg",getPropertyVal(grpAddSuccessAlrtMsg_val));
        compareTwoEqualValues("grpAddedExpAlertMsg","grpAddedActAlertMsg");
    }

    public void verifyNoGroups() throws ConfigurationException {
               if (getText(noGroups_xpath).equalsIgnoreCase(getPropertyVal(noGroups_val))) {
                   logPass("No Groups got populated in the group grid.");
               }
               else {
                   logFail("No Groups did NOT got populated in the group grid.");
               }
    }

    public void editUserGroup() throws ConfigurationException {
        if (isElementVisible(noGroups_xpath)) {
            verifyNoGroups();
        }else {
            driverWaitClick(userGroupEditTab_xpath);
            String val = getAlphaNumericString(5);
            clearType(groupNameInput_id, val);
            clickWithOutWait(grpNameAddBtn_xpath);
            String alertMsg = getText(imageSuccessAlertMsg_xpath);
            setPropertyVal("grpUpdatedActAlertMsg", alertMsg.replace("\n", " "));
            setPropertyVal("grpUpdatedExpAlertMsg", getPropertyVal(groupUpdatedAlertMsg_val));
            compareTwoEqualValues("grpUpdatedExpAlertMsg", "grpUpdatedActAlertMsg");
        }
    }

    public void deleteUserGroup() throws ConfigurationException {
        if (isElementVisible(noGroups_xpath)) {
            verifyNoGroups();
        }else {
            driverWaitClick(userGroupsDeleteTab_xpath);
            clickWithOutWait(areYouSurePopUpConfirmBtn_xpath);
            String alertMsg=getText(imageSuccessAlertMsg_xpath);
            setPropertyVal("grpDeletedActAlertMsg",alertMsg.replace("\n"," "));
            setPropertyVal("grpDeletedExpAlertMsg",getPropertyVal(groupDeletedAlertMsg_val));
            compareTwoEqualValues("grpDeletedExpAlertMsg","grpDeletedActAlertMsg");
        }
    }

    public void readNwriteCSVdata(String replace,int row,int col) throws CsvException, IOException {
        String exportedFilePathVal = getExportedFilePath();
        File inputFile = new File(exportedFilePathVal);
        CSVReader reader = new CSVReader(new FileReader(inputFile));
        List<String[]> csvBody = reader.readAll();
        csvBody.get(row)[col] =replace;
        reader.close();

        CSVWriter writer = new CSVWriter(new FileWriter(inputFile));
        writer.writeAll(csvBody);
        writer.flush();
        writer.close();
    }

    public String createCSVFile(String region) throws IOException {
        String timeStamp = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new java.util.Date());
        String reportPath = System.getProperty("user.dir")+"\\reports\\csvFile\\UiAutomation_report_"+region+"_"+timeStamp+".csv";
        File csvFileVal = new File(reportPath);
        csvFileVal.createNewFile();
        return  reportPath;
    }

    public void writeToCSVHeaders(String csvFilePathVal) throws IOException {
        File file = new File(csvFilePathVal);
        FileWriter outputfile = new FileWriter(file,true);
        CSVWriter writer = new CSVWriter(outputfile);
        //Writing data to a csv file
         String line1[] = {"Groups"};
         //Writing data to the csv file
         writer.writeNext(line1);
         //Flushing data from writer to file
         writer.flush();
    }

    public void verifyElmntEdtbleOrNot(String locatorKey,String setVal) throws ConfigurationException {
        setPropertyVal(textEditable_xpath2,setVal);
        typeWithOutThrwngException(locatorKey, "abc");
        String s = getElement(locatorKey).getText();
        if (s.equalsIgnoreCase("abc")) {
            logFail(locatorKey.split("_")[0] + " is editable");
        } else {
            logPass(locatorKey.split("_")[0] + " is NOT editable");
        }
    }

    public void verifyToggleBtnEnbldOrDisabld(String locatorKey) throws ConfigurationException {
        String classVal = getAttributeVal(locatorKey, "class");
        clickWithOutMsg(locatorKey);
        String classVal1 = getAttributeVal(locatorKey, "class");
        if (classVal1.equalsIgnoreCase(classVal)) {
            logFail(locatorKey.split("_")[0] + " toggle button is not enabled.");
        } else {
            logPass(locatorKey.split("_")[0] + " toggle button is enabled.");
        }
    }

    public void verifyElementIsDisbld(String locatorKey) throws ConfigurationException {
        if (!getElement(locatorKey).isEnabled()) {
           logFail(locatorKey.split("_")[0] + " element is disabled.");
        } else {
            logPass(locatorKey.split("_")[0] + " element is enabled.");
        }
    }

    public void verifyShareLinkCopy() throws ConfigurationException {
        clickWithOutWait(shareLink_xpath);
        String shareLinkCopy=getText(imageSuccessAlertMsg_xpath);
        setPropertyVal("actAlertMsg",shareLinkCopy);
        setPropertyVal("expAlertMsg",getPropertyVal(shareLinkCopy_val));
        compareTwoEqualValues("expAlertMsg","actAlertMsg");
    }

    public void downloadCarearApp(String locatorKey,String expectedVal) throws ConfigurationException, IOException {
        driverWaitClick(careArAppDownloadBtn_xpath);
        List<String> browserTabs = new ArrayList<String>(driver.getWindowHandles());
        if (browserTabs.size() == 2) {
            logPass("New tab got populated.");
            wait(10);
            driver.switchTo().window(browserTabs.get(1));
            if(isElementVisible(careARAppLinkPageText_xpath)){
                logPass("User navigate to the download page");
            }else{
                logFail("User unable to navigate download page");
            }
            wait(10);
            verifyElmntTxt(locatorKey, expectedVal);
            deleteALLFilesInDownload();
            driver.close();
            wait(10);
            driver.switchTo().window(browserTabs.get(0));
        } else {
            logFail("New tab did NOT get populated.");
        }
    }

    public void verifyAdminstrationPage() throws ConfigurationException {
        if(isElementVisible(administrationText_xpath)){
            logPass("User got lands on adminstration page");
            verifyElmntTxt(administrationText_xpath,getPropertyVal(administrationText_val));
        }else {
            logFail("User not get lands on adminstration page");
        }
    }

    public void verifyMobleAppFeatureOnSideBadMenu(){
        wait(10);
        if(isElementPresent(appDownloadFeature_xpath)){
            logPass("Download CareAr mobile app feature got available in sidebar menu");
        }else{
            logFail("Download CareAr mobile app feature not gat available in sidebar menu");
        }
    }

    public void verifyDownloadNShareLinkBtn(){
        if(isElementPresent(careArAppDownloadBtn_xpath)){
            logPass("User able to see Download button and share link button");
        }else {
            logFail("User not able to see Download button and share link button");
        }
        if(isElementPresent(shareLink_xpath)){
            logPass("User able to see share link button");
        }else {
            logFail("User able to see share link button");
        }
    }

    public String verifyuploadHeroImageForExperience(String nameVal,String imageval) throws ConfigurationException {
        if(isElementPresent(experinceBlankImage_xpath)){
            jsclick(experinceBlankImage_xpath);
        } else if (isElementPresent(experinceContainsImage_xpath)) {
            jsclick(experinceContainsImage_xpath);
        }
//        driverWaitClick(selectedImageElement_xpath);
       if(isElementPresent(imageUrlRadioBtn_xpath)){
           jsclick(imageUrlRadioBtn_xpath);
       }
        clearType(imageUrlInputField_xpath,imageval);
        driverWaitClick(experiencePublishButton_xpath);
        return imageval;
    }

    public void verifyImageAfterUpload(String imageSrc,String nameVal) throws ConfigurationException {
        driverWaitClick(experiencesTab_xpath);
        clearType(experiencesSearchBox_xpath, nameVal);
        actionsMovetoElement(experienceTableHeroImage_xpath);
        if(getAttributeVal(experienceTableHeroImage_xpath, "src").equalsIgnoreCase(getPropertyVal(imageSrc))){
            logPass("User can see the hero image when that experience have upload the image in the launch page of the instruct builder only");
        }else {
            logFail("User can not see the hero image when that experience have upload the image in the launch page of the instruct builder only");
        }
    }

    public void verifyHeroImageInExperiences() throws ConfigurationException {
        String imageSrc="";
        String nameVal = getText(experiencesTblName_xpath);
        clearType(experiencesSearchBox_xpath, nameVal);
        driverWaitClick(tableRow_xpath);
        driverWaitClick(experienceEditInBuilderBtn_xpath);
        List<String> browserTabs = new ArrayList<String>(driver.getWindowHandles());
        if (browserTabs.size() == 2) {
            logPass("New tab got populated.");
            wait(10);
            driver.switchTo().window(browserTabs.get(1));
            if(isElementPresent(welcomeExperiencePgNextButton_xpath)) {
                click(welcomeExperiencePgNextButton_xpath);
                click(experienceNextButton_xpath);
                click(experienceNextButton_xpath);
                click(experienceNextButton_xpath);
            }
            if (isElementVisible(experinceBlankImage_xpath))
            {
                if(getAttributeVal(experinceBlankImage_xpath, "src").contains("no-hero-image")|| getAttributeVal(experinceBlankImage_xpath, "src").contains("blankImage")) {
                    imageSrc = verifyuploadHeroImageForExperience(nameVal, getPropertyVal(image_val));
                    wait(10);
                    driver.close();
                    wait(10);
                    driver.switchTo().window(browserTabs.get(0));
                    verifyImageAfterUpload(image_val, nameVal);
                }
            }
            else if (isElementVisible(experinceContainsImage_xpath) && getAttributeVal(experinceContainsImage_xpath, "src").equalsIgnoreCase(getPropertyVal(image_val))) {
                {
                    imageSrc= verifyuploadHeroImageForExperience(nameVal, getPropertyVal(image1_val));
                    wait(10);
                    driver.close();
                    wait(10);
                    driver.switchTo().window(browserTabs.get(0));
                    verifyImageAfterUpload(image1_val,nameVal);
                }
            }
            else if (isElementVisible(experinceContainsImage_xpath) && getAttributeVal(experinceContainsImage_xpath, "src").equalsIgnoreCase(getPropertyVal(image1_val))) {
                {
                    imageSrc=  verifyuploadHeroImageForExperience(nameVal, getPropertyVal(image_val));
                    wait(10);
                    driver.close();
                    wait(10);
                    driver.switchTo().window(browserTabs.get(0));
                    verifyImageAfterUpload(image_val,nameVal);
                }
            }
            else {
                imageSrc= verifyuploadHeroImageForExperience(nameVal, getPropertyVal(image_val));
                wait(10);
                driver.close();
                wait(10);
                driver.switchTo().window(browserTabs.get(0));
                verifyImageAfterUpload(image_val,nameVal);
            }

        }else {
            logFail("New tab did NOT get populated.");
        }
    }

    public void verifyAlertMsg(String locator,String expVal) throws ConfigurationException {
        String alertVal=getText(locator);
        setPropertyVal("actAlertMasgValue",alertVal);
        setPropertyVal("ExpAlertMsgValue",getPropertyVal(expVal));
        compareTwoEqualValues("ExpAlertMsgValue","actAlertMasgValue");
    }

    public void verifyMyprofileEditProfilePage() throws ConfigurationException {
        driverWaitClick(editProfile_xpath);
        if(getText(editProfileText_xpath).equalsIgnoreCase(getPropertyVal(editProfileText_val))){
            logPass("User redirected to edit profile page");
            verifyElmntEdtbleOrNot(emailInput_xpath);
            verifyElmntEdtbleOrNot(nameInput_xpath);
            verifyElmntEdtbleOrNot(jobDescriptionInput_xpath);
            verifyWhthElementIsEnbld(primaryPhoneNumberTxt_xpath);
            verifyWhthElementIsEnbld(secondaryPhoneNumberTxt_xpath);
        }else {
            logFail("User unable to redirect edit profile page");
        }
        driverWaitClick(cancelButton_xpath);
    }
    public void verifyMyProfileChangePasswordPage() throws ConfigurationException {
        driverWaitClick(changePasswordBtn_xpath);
        if(getText(changePasswordText_xpath).equalsIgnoreCase(getPropertyVal(changePasswordText_val))) {
            logPass("User redirected to changePassword page");

        }else {
            logFail("User unable to redirect to changePassword page");
        }
        changePassword("Testing1","Password1");
        verifyAlertMsg(imageSuccessAlertMsg1_xpath,chabgePasswordAlertMsg_val);
        driverWaitClick(changePasswordBtn_xpath);
        changePassword("Password1","Testing1");
    }
    public void changePassword(String oldPwd,String newPwd){
        clearType(oldPassword_id,oldPwd);
        clearType(newPassword_id,newPwd);
        clearType(confirmPassword_id,newPwd);
        clickWithOutWait(changeBtn_xpath);
    }


    public String[] verifyUserMandatoryFields() throws ConfigurationException {
            driverWaitClick(addNewUseBtn_xpath);
            String emailId = "automation" + getRandomNumericValue(4) + "@gmail.com";
            String fname = "auto" + getAlphaNumericString(4);
            String lname = "auto" + getAlphaNumericString(4);
            clearType(userEditPageEmailInput_id, emailId);
            clearType(userEditPageFirstNameInput_id, fname);
            clearType(userEditPageLastnameInput_id, lname);

            clickWithOutWait(userEditPageSaveButton_xpath);
            String alertMsg = getText(imageSuccessAlertMsg_xpath);
            setPropertyVal("actAlertMsg", alertMsg);
            setPropertyVal("expAlertMsg", getPropertyVal(userAddedAlrtMsg_val));
            compareTwoEqualValues("expAlertMsg", "actAlertMsg");
            String fullName[]={fname+" "+lname,emailId};
            return fullName;

    }

    public String[] verifyUserGroupName() throws ConfigurationException {
        driverWaitClick(addNewUseBtn_xpath);
        String emailId = "automation" + getRandomNumericValue(4) + "@gmail.com";
        String fname = "auto" + getAlphaNumericString(4);
        String lname = "auto" + getAlphaNumericString(4);
        clearType(userEditPageEmailInput_id, emailId);
        clearType(userEditPageFirstNameInput_id, fname);
        clearType(userEditPageLastnameInput_id, lname);
        String selectedGroup=verifyUserGroup();
        clickWithOutWait(userEditPageSaveButton_xpath);
        String alertMsg = getText(imageSuccessAlertMsg_xpath);
        setPropertyVal("actAlertMsg", alertMsg);
        setPropertyVal("expAlertMsg", getPropertyVal(userAddedAlrtMsg_val));
        compareTwoEqualValues("expAlertMsg", "actAlertMsg");
        String [] values={emailId,selectedGroup};
        return values;

    }

    public void verifyMyprofilePage() throws ConfigurationException {
        if(getText(myProfileText_xpath).equalsIgnoreCase(getPropertyVal(myProfile_val))){
            logPass("User got lands on Myprofile page");
        }else{
            logFail("User did not get lands on Myprofile page");
        }
        if(isElementVisible(editProfile_xpath)){
            logPass("User able to see edit profile option");
        }else{
            logFail("User Unable to see edit profile option");
        }
        if(isElementVisible(editProfile_xpath)){
            logPass("User able to see change Password option");
        }else{
            logFail("User Unable to see change Password option");
        }
    }

    public void verifiedRequiredFieldsInAnalytics() throws ConfigurationException {
        if(getElement(analyticsLastSevenDays_xpath).isEnabled()){
            logPass("Clicked on Last 7 days tab corresponding page got displayed");
        }else {
            logFail("Clicked on Last 7 days not tab corresponding page did not get displayed");
        }

        if(getElement(analyticsLast12Months_xpath).isEnabled()){
            logPass("Clicked on Last 12 months tab corresponding page got displayed");
        }else {
            logFail("Unable to Clicked on Last 12 months tab corresponding page did not get displayed");
        }

        if(getElement(analyticsLast30Days_xpath).isEnabled()){
            logPass("Clicked on Last 30 days tab corresponding page got displayed");
        }else {
            logFail("Unable to Clicked on Last 30 days tab corresponding page did not get displayed");
        }

        if(getElement(analyticsCurrentBillingCycle_xpath).isEnabled()){
            logPass("Clicked on Crrent Billing cycle tab corresponding page got displayed");
        }else {
            logFail("Unable to Clicked on Crrent Billing cycle tab corresponding page did not get displayed");
        }

        if(getElement(analyticsCustomDate_xpath).isEnabled()){
            logPass("Clicked on Custom date tab corresponding page got displayed");
        }else {
            logFail("Unable to Clicked on Custom date tab corresponding page did not get displayed");
        }
    }

}





