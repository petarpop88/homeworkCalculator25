import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

public class calculator {


    //Test the operation of the calculator https://testsheepnz.github.io/BasicCalculator.html. Test the operation of all operations separately.
    // Write the edge cases you come across, or fulfill some mathematical rules.
    // (divide by 0, divide by 1, large/small numbers, etc.). Write a minimum of 4 edge cases per test method, 16 in total (minimum),
    // operations: add, subtract, multiply and divide.
    // ignore Concatenate!

    private WebDriver driver;

    @BeforeClass
    public void setup () {
        System.setProperty ("webdriver.chrome.driver", "C:\\Users\\HP\\Local\\webdriver/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();

    }

    @BeforeMethod
    public void beforeMethod() {
        //before method secure that fields are empty so there is no need for .clear element method
        driver.get("https://testsheepnz.github.io/BasicCalculator.html");
    }

    @Test
    public void test1 () {
        //add with two positive
        String expectedResult = "7";

        WebElement field1 = driver.findElement(By.xpath("//*[@id=\"number1Field\"]"));
        field1.sendKeys("5");

        WebElement field2 = driver.findElement(By.xpath("//*[@id=\"number2Field\"]"));
        field2.sendKeys("2");

        WebElement calculateButton  = driver.findElement(By.xpath("//*[@id=\"calculateButton\"]"));
        calculateButton.click();

        WebElement result = driver.findElement(By.xpath("//*[@id=\"numberAnswerField\"]"));
        String actualResult = result.getAttribute("value");

        Assert.assertEquals(expectedResult, actualResult);

    }

    @Test
    public void test2 () {
        //add with two negatives
        String expectedResult = "-10";

        WebElement field1 = driver.findElement(By.xpath("//*[@id=\"number1Field\"]"));
        field1.sendKeys("-8");

        WebElement field2 = driver.findElement(By.xpath("//*[@id=\"number2Field\"]"));
        field2.sendKeys("-2");

        WebElement calculateButton  = driver.findElement(By.xpath("//*[@id=\"calculateButton\"]"));
        calculateButton.click();

        WebElement result = driver.findElement(By.xpath("//*[@id=\"numberAnswerField\"]"));
        String actualResult = result.getAttribute("value");

        Assert.assertEquals(expectedResult, actualResult);

    }
    @Test
    public void test3 () {
        //add with one negative and one positive
        String expectedResult = "-18";

        WebElement field1 = driver.findElement(By.xpath("//*[@id=\"number1Field\"]"));
        field1.sendKeys("-20");

        WebElement field2 = driver.findElement(By.xpath("//*[@id=\"number2Field\"]"));
        field2.sendKeys("2");

        WebElement calculateButton = driver.findElement(By.xpath("//*[@id=\"calculateButton\"]"));
        calculateButton.click();

        WebElement result = driver.findElement(By.xpath("//*[@id=\"numberAnswerField\"]"));
        String actualResult = result.getAttribute("value");

        Assert.assertEquals(expectedResult, actualResult);

    }
    @Test
    public void test4 () {
        //add with one positive and zero
        String expectedResult = "3";

        WebElement field1 = driver.findElement(By.xpath("//*[@id=\"number1Field\"]"));
        field1.sendKeys("3");

        WebElement field2 = driver.findElement(By.xpath("//*[@id=\"number2Field\"]"));
        field2.sendKeys("0");

        WebElement calculateButton = driver.findElement(By.xpath("//*[@id=\"calculateButton\"]"));
        calculateButton.click();

        WebElement result = driver.findElement(By.xpath("//*[@id=\"numberAnswerField\"]"));
        String actualResult = result.getAttribute("value");

        Assert.assertEquals(expectedResult, actualResult);

    }


    @Test
    public void test5 () {
        //subtract with two positive
        String expectedResult = "1";

        WebElement field1 = driver.findElement(By.xpath("//*[@id=\"number1Field\"]"));
        field1.sendKeys("10");

        WebElement field2 = driver.findElement(By.xpath("//*[@id=\"number2Field\"]"));
        field2.sendKeys("9");

        WebElement operation = driver.findElement(By.id("selectOperationDropdown"));
        Select select = new Select(operation);
        select.selectByVisibleText("Subtract");

        WebElement calculateButton = driver.findElement(By.xpath("//*[@id=\"calculateButton\"]"));
        calculateButton.click();

        WebElement result = driver.findElement(By.xpath("//*[@id=\"numberAnswerField\"]"));
        String actualResult = result.getAttribute("value");

        Assert.assertEquals(expectedResult, actualResult);
    }
    @Test
    public void test6 () {
        //subtract with two negatives
        String expectedResult = "-3";

        WebElement field1 = driver.findElement(By.xpath("//*[@id=\"number1Field\"]"));
        field1.sendKeys("-9");

        WebElement field2 = driver.findElement(By.xpath("//*[@id=\"number2Field\"]"));
        field2.sendKeys("-6");

        WebElement operation = driver.findElement(By.id("selectOperationDropdown"));
        Select select = new Select(operation);
        select.selectByVisibleText("Subtract");

        WebElement calculateButton = driver.findElement(By.xpath("//*[@id=\"calculateButton\"]"));
        calculateButton.click();

        WebElement result = driver.findElement(By.xpath("//*[@id=\"numberAnswerField\"]"));
        String actualResult = result.getAttribute("value");

        Assert.assertEquals(expectedResult, actualResult);

    }
    @Test
    public void test7 () {
        //subtract with zero
        String expectedResult = "5";

        WebElement field1 = driver.findElement(By.xpath("//*[@id=\"number1Field\"]"));
        field1.sendKeys("5");

        WebElement field2 = driver.findElement(By.xpath("//*[@id=\"number2Field\"]"));
        field2.sendKeys("0");

        WebElement operation = driver.findElement(By.id("selectOperationDropdown"));
        Select select = new Select(operation);
        select.selectByVisibleText("Subtract");

        WebElement calculateButton = driver.findElement(By.xpath("//*[@id=\"calculateButton\"]"));
        calculateButton.click();

        WebElement result = driver.findElement(By.xpath("//*[@id=\"numberAnswerField\"]"));
        String actualResult = result.getAttribute("value");

        Assert.assertEquals(expectedResult, actualResult);
    }
    @Test
    public void test8 () {
        //subtract negative and positive
        String expectedResult = "-46";

        WebElement field1 = driver.findElement(By.xpath("//*[@id=\"number1Field\"]"));
        field1.sendKeys("-36");

        WebElement field2 = driver.findElement(By.xpath("//*[@id=\"number2Field\"]"));
        field2.sendKeys("10");

        WebElement operation = driver.findElement(By.id("selectOperationDropdown"));
        Select select = new Select(operation);
        select.selectByVisibleText("Subtract");

        WebElement calculateButton = driver.findElement(By.xpath("//*[@id=\"calculateButton\"]"));
        calculateButton.click();

        WebElement result = driver.findElement(By.xpath("//*[@id=\"numberAnswerField\"]"));
        String actualResult = result.getAttribute("value");

        Assert.assertEquals(expectedResult, actualResult);
    }
    @Test
    public void test9 () {
        //subtract positive and negative
        String expectedResult = "136";

        WebElement field1 = driver.findElement(By.xpath("//*[@id=\"number1Field\"]"));
        field1.sendKeys("100");

        WebElement field2 = driver.findElement(By.xpath("//*[@id=\"number2Field\"]"));
        field2.sendKeys("-36");

        WebElement operation = driver.findElement(By.id("selectOperationDropdown"));
        Select select = new Select(operation);
        select.selectByVisibleText("Subtract");

        WebElement calculateButton = driver.findElement(By.xpath("//*[@id=\"calculateButton\"]"));
        calculateButton.click();

        WebElement result = driver.findElement(By.xpath("//*[@id=\"numberAnswerField\"]"));
        String actualResult = result.getAttribute("value");

        Assert.assertEquals(expectedResult, actualResult);
    }
    @Test
    public void test10 () {
        //multiply two positive
        String expectedResult = "200";

        WebElement field1 = driver.findElement(By.xpath("//*[@id=\"number1Field\"]"));
        field1.sendKeys("100");

        WebElement field2 = driver.findElement(By.xpath("//*[@id=\"number2Field\"]"));
        field2.sendKeys("2");

        WebElement operation = driver.findElement(By.id("selectOperationDropdown"));
        Select select = new Select(operation);
        select.selectByVisibleText("Multiply");

        WebElement calculateButton = driver.findElement(By.xpath("//*[@id=\"calculateButton\"]"));
        calculateButton.click();

        WebElement result = driver.findElement(By.xpath("//*[@id=\"numberAnswerField\"]"));
        String actualResult = result.getAttribute("value");

        Assert.assertEquals(expectedResult, actualResult);
    }

    @Test
    public void test11 () {
        //multiply two positive
        String expectedResult = "1000";

        WebElement field1 = driver.findElement(By.xpath("//*[@id=\"number1Field\"]"));
        field1.sendKeys("500");

        WebElement field2 = driver.findElement(By.xpath("//*[@id=\"number2Field\"]"));
        field2.sendKeys("2");

        WebElement operation = driver.findElement(By.id("selectOperationDropdown"));
        Select select = new Select(operation);
        select.selectByVisibleText("Multiply");

        WebElement calculateButton = driver.findElement(By.xpath("//*[@id=\"calculateButton\"]"));
        calculateButton.click();

        WebElement result = driver.findElement(By.xpath("//*[@id=\"numberAnswerField\"]"));
        String actualResult = result.getAttribute("value");

        Assert.assertEquals(expectedResult, actualResult);
    }

    @Test
    public void test12 () {
        //multiply two negative
        String expectedResult = "1000";

        WebElement field1 = driver.findElement(By.xpath("//*[@id=\"number1Field\"]"));
        field1.sendKeys("-500");

        WebElement field2 = driver.findElement(By.xpath("//*[@id=\"number2Field\"]"));
        field2.sendKeys("-2");

        WebElement operation = driver.findElement(By.id("selectOperationDropdown"));
        Select select = new Select(operation);
        select.selectByVisibleText("Multiply");

        WebElement calculateButton = driver.findElement(By.xpath("//*[@id=\"calculateButton\"]"));
        calculateButton.click();

        WebElement result = driver.findElement(By.xpath("//*[@id=\"numberAnswerField\"]"));
        String actualResult = result.getAttribute("value");

        Assert.assertEquals(expectedResult, actualResult);
    }

    @Test
    public void test13 () {
        //multiply with zero
        String expectedResult = "0";

        WebElement field1 = driver.findElement(By.xpath("//*[@id=\"number1Field\"]"));
        field1.sendKeys("5");

        WebElement field2 = driver.findElement(By.xpath("//*[@id=\"number2Field\"]"));
        field2.sendKeys("0");

        WebElement operation = driver.findElement(By.id("selectOperationDropdown"));
        Select select = new Select(operation);
        select.selectByVisibleText("Multiply");

        WebElement calculateButton = driver.findElement(By.xpath("//*[@id=\"calculateButton\"]"));
        calculateButton.click();

        WebElement result = driver.findElement(By.xpath("//*[@id=\"numberAnswerField\"]"));
        String actualResult = result.getAttribute("value");

        Assert.assertEquals(expectedResult, actualResult);
    }
    @Test
    public void test14 () {
        //divide two positive
        String expectedResult = "3";

        WebElement field1 = driver.findElement(By.xpath("//*[@id=\"number1Field\"]"));
        field1.sendKeys("9");

        WebElement field2 = driver.findElement(By.xpath("//*[@id=\"number2Field\"]"));
        field2.sendKeys("3");

        WebElement operation = driver.findElement(By.id("selectOperationDropdown"));
        Select select = new Select(operation);
        select.selectByVisibleText("Divide");

        WebElement calculateButton = driver.findElement(By.xpath("//*[@id=\"calculateButton\"]"));
        calculateButton.click();

        WebElement result = driver.findElement(By.xpath("//*[@id=\"numberAnswerField\"]"));
        String actualResult = result.getAttribute("value");

        Assert.assertEquals(expectedResult, actualResult);

    }
    @Test
    public void test15 () {
        //divide two zero
        String expectedResult = "0";

        WebElement field1 = driver.findElement(By.xpath("//*[@id=\"number1Field\"]"));
        field1.sendKeys("0");

        WebElement field2 = driver.findElement(By.xpath("//*[@id=\"number2Field\"]"));
        field2.sendKeys("5");

        WebElement operation = driver.findElement(By.id("selectOperationDropdown"));
        Select select = new Select(operation);
        select.selectByVisibleText("Divide");

        WebElement calculateButton = driver.findElement(By.xpath("//*[@id=\"calculateButton\"]"));
        calculateButton.click();

        WebElement result = driver.findElement(By.xpath("//*[@id=\"numberAnswerField\"]"));
        String actualResult = result.getAttribute("value");

        Assert.assertEquals(expectedResult, actualResult);
    }

    @Test
    public void test16 () {
        //divide with 1
        String expectedResult = "99";

        WebElement field1 = driver.findElement(By.xpath("//*[@id=\"number1Field\"]"));
        field1.sendKeys("99");

        WebElement field2 = driver.findElement(By.xpath("//*[@id=\"number2Field\"]"));
        field2.sendKeys("1");

        WebElement operation = driver.findElement(By.id("selectOperationDropdown"));
        Select select = new Select(operation);
        select.selectByVisibleText("Divide");

        WebElement calculateButton = driver.findElement(By.xpath("//*[@id=\"calculateButton\"]"));
        calculateButton.click();

        WebElement result = driver.findElement(By.xpath("//*[@id=\"numberAnswerField\"]"));
        String actualResult = result.getAttribute("value");

        Assert.assertEquals(expectedResult, actualResult);
    }

    @Test
    public void test17 () {
        //divide two negative
        String expectedResult = "33";

        WebElement field1 = driver.findElement(By.xpath("//*[@id=\"number1Field\"]"));
        field1.sendKeys("-99");

        WebElement field2 = driver.findElement(By.xpath("//*[@id=\"number2Field\"]"));
        field2.sendKeys("-3");

        WebElement operation = driver.findElement(By.id("selectOperationDropdown"));
        Select select = new Select(operation);
        select.selectByVisibleText("Divide");

        WebElement calculateButton = driver.findElement(By.xpath("//*[@id=\"calculateButton\"]"));
        calculateButton.click();

        WebElement result = driver.findElement(By.xpath("//*[@id=\"numberAnswerField\"]"));
        String actualResult = result.getAttribute("value");

        Assert.assertEquals(expectedResult, actualResult);
    }

    @AfterClass
    public void afterClass () {
        driver.quit();
    }
}
