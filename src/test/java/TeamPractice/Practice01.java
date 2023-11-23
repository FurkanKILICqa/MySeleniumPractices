package TeamPractice;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class Practice01 extends TestBase {


    //Verify that 'Logged in as username' is visible
    //Click 'Logout' button
    //Verify that user is navigated to login page

    @Test
    public void test01() throws IOException {

        //Navigate to url 'http://automationexercise.com'
        driver.get("http://automationexercise.com");

        //Verify that home page is visible successfully
         WebElement homePage = driver.findElement(By.xpath("(//*[.='Automation'])[1]"));
         homePage.isDisplayed();

        //Click on 'Signup / Login' button
        driver.findElement(By.xpath("(//a)[5]")).click();

        //Verify 'Login to your account' is visible
        WebElement loginTo = driver.findElement(By.xpath("//*[.='Login to your account']"));
        loginTo.isDisplayed();

        String path = "C:\\Users\\hpvic\\IdeaProjects\\MySeleniumPractices\\src\\test\\java\\zrecources\\Başlıksız e-tablo.xlsx";
        FileInputStream fis = new  FileInputStream(path);
        Workbook workbook = WorkbookFactory.create(fis);

        //Enter correct email address and password
        String mail = workbook.getSheet("Sayfa1").getRow(1).getCell(0).toString();
        String password = workbook.getSheet("Sayfa1").getRow(1).getCell(1).toString();

        WebElement mailCell = driver.findElement(By.xpath("(//*[@name='email'])[1]"));
        WebElement passCell = driver.findElement(By.xpath("(//*[@name='password'])[1]"));

        mailCell.sendKeys(mail);
        passCell.sendKeys(password);

        System.out.println(mail+""+password);


        //Click 'login' button
        driver.findElement(By.xpath("(//*[@class='btn btn-default'])[1]")).click();



        //Verify that 'Logged in as username' is visible

















    }
}
