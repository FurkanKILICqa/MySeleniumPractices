package TeamPractice;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

public class Practice02 extends TestBase {


    @Test
    public void test01() {


        extentTest=extentReports.createTest("Automation Exercise","Test Case 04");
        //Navigate to url 'http://automationexercise.com'
        driver.get("http://automationexercise.com");


        //Click on 'Products' button
        driver.findElement(By.xpath("//a[@href='/products']")).click();

        Actions actions = new Actions(driver);
        actions.sendKeys(Keys.PAGE_DOWN).perform();

        //Verify that Brands are visible on left side bar
       WebElement brands = driver.findElement(By.xpath("(//h2)[2]"));
       brands.isDisplayed();

        //Click on any brand name
        driver.findElement(By.xpath("//a[@href='/brand_products/Polo']")).click();


        //Verify that user is navigated to brand page and brand products are displayed
       WebElement poloBrand = driver.findElement(By.xpath("//*[@class='title text-center']"));
       WebElement HM = driver.findElement(By.xpath("//a[@href='/brand_products/H&M']"));
       poloBrand.isDisplayed();
       actions.scrollToElement(HM).perform();



        //On left side bar, click on any other brand link
        driver.findElement(By.xpath("//a[@href='/brand_products/H&M']")).click();


        //Verify that user is navigated to that brand page and can see products
       WebElement hmBrand = driver.findElement(By.xpath("//*[@class='title text-center']"));
        hmBrand.isDisplayed();





    }
}
