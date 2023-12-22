package TeamPractice;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

import java.io.FileInputStream;
import java.io.IOException;

public class Practice01WithError extends TestBase {


    @Test
    public void test01() throws IOException {

        //https://www.bluerentalcars.com/ sayfasına gidelim
        driver.get("http://automationexercise.com");


        //Verify that home page is visible successfully



        //Login butonuna basalım
        driver.findElement(By.xpath("//a[@href='/login']")).click();

        String path = "C:\\Users\\hpvic\\IdeaProjects\\MySeleniumPractices\\src\\test\\java\\recources\\Başlıksız e-tablo.xlsx";
        FileInputStream fis = new FileInputStream(path);
        Workbook workbook = WorkbookFactory.create(fis);

        //Excel dosyasından aldığımız bir kullanıcı adı ve password ile login olalim
        String userMail = workbook.getSheet("Sayfa1").getRow(1).getCell(0).toString();
        String userPass = workbook.getSheet("Sayfa1").getRow(1).getCell(1).toString();

        System.out.println(userMail+" "+userPass);

        WebElement mail = driver.findElement(By.xpath("(//*[@name='email'])[1]"));
        WebElement pass = driver.findElement(By.xpath("(//*[@name='password'])[1]"));
        WebElement loginBox = driver.findElement(By.xpath("(//*[@class='btn btn-default'])[1]"));

        mail.sendKeys(userMail);
        pass.sendKeys(userPass);
        loginBox.click();

      // //Login olduğumuzu doğrulayalım
      // WebElement loginTest = driver.findElement(By.id("dropdown-basic-button"));
      // Assert.assertEquals("ayhan can",loginTest.getText());
















    }
}
