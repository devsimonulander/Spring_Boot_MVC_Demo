package com.SimonUlander.MVCDemo;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.web.server.LocalServerPort;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class SeleniumTests {
    @LocalServerPort
    private Integer port;


    private static WebDriver driver;
    private static WebDriverWait wait;

    // Setting up the WebDriver for the tests.
    @BeforeAll
    public static void beforeAll() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        wait = new WebDriverWait(driver, 20);
    }

    // Shutting down the WebDriver after all tests.
    @AfterAll
    public static void afterAll(){
        driver.quit();
    }

    String AutomatedSeleniumTest(String firstVal, String secondVal, String operator) throws InterruptedException {

        String returnVal = "";
        try {
            driver.get("http://localhost:" + port + "/");

            // Putting first into the first field.
            WebElement inputField1 = driver.findElement(By.name("FirstTerm"));
            inputField1.clear();
            inputField1.sendKeys(firstVal);

            // Putting secondVal into the second field.
            WebElement inputField2 = driver.findElement(By.name("SecondTerm"));
            inputField2.clear();
            inputField2.sendKeys(secondVal);

            // Selecting the operator.
            WebElement selection = driver.findElement(By.name("Operator"));
            selection.sendKeys(operator);

            // Pressing the submit button.
            WebElement submitButton = driver.findElement(By.name("Submit"));
            submitButton.submit();

            // Getting result.
            WebElement outputField = driver.findElement(By.name("Output"));

            returnVal = outputField.getAttribute("value");
        } finally {

        }
        return returnVal;
    }

    @Test // Addition
    void SeleniumAdditionTests() throws InterruptedException {
        assertEquals(AutomatedSeleniumTest("5","5","+"),"10.0");
        assertEquals(AutomatedSeleniumTest("5","-7","+"),"-2.0");
    }

    @Test // Subtraction
    void SeleniumSubtractionTests() throws InterruptedException {
        assertEquals(AutomatedSeleniumTest("7","5","-"),"2.0");
        assertEquals(AutomatedSeleniumTest("5","-2","-"),"7.0");
    }

    @Test // Multiplication
    void SeleniumMultiplicationTests() throws InterruptedException {
        assertEquals(AutomatedSeleniumTest("5","5","*"),"25.0");
        assertEquals(AutomatedSeleniumTest("5","-5","*"),"-25.0");
    }

    @Test // Division
    void SeleniumDivisionTests() throws InterruptedException {
        assertEquals(AutomatedSeleniumTest("10","5","/"),"2.0");
        assertEquals(AutomatedSeleniumTest("20","-10","/"),"-2.0");
    }

    @Test // Term 1 not being a number
    void SeleniumTerm1NotNumTests() throws InterruptedException {
        assertEquals(AutomatedSeleniumTest("abc","5","+"),"Error: Not proper numbers.");
        assertEquals(AutomatedSeleniumTest("abc","5","-"),"Error: Not proper numbers.");
        assertEquals(AutomatedSeleniumTest("abc","5","*"),"Error: Not proper numbers.");
        assertEquals(AutomatedSeleniumTest("abc","5","/"),"Error: Not proper numbers.");
    }

    @Test // Term 2 not being a number
    void SeleniumTerm2NotNumTests() throws InterruptedException {
        assertEquals(AutomatedSeleniumTest("5","abc","+"),"Error: Not proper numbers.");
        assertEquals(AutomatedSeleniumTest("5","abc","-"),"Error: Not proper numbers.");
        assertEquals(AutomatedSeleniumTest("5","abc","*"),"Error: Not proper numbers.");
        assertEquals(AutomatedSeleniumTest("5","abc","/"),"Error: Not proper numbers.");
    }

    @Test
    void SeleniumDivByZeroTests() throws InterruptedException {
        // Divide by zero
        assertEquals(AutomatedSeleniumTest("5","0","/"),"Error: Divide by zero.");
        assertEquals(AutomatedSeleniumTest("0","5","/"),"0.0");
    }

}
