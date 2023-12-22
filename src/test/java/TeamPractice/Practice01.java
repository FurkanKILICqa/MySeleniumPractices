package TeamPractice;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

public class Practice01 extends TestBase {

    @Test
    public void test01() {

        //Navigate to url 'http://automationexercise.com'
        driver.get("http://automationexercise.com");


        //Verify that home page is visible successfully
        WebElement automationWriting = driver.findElement(By.xpath("(//*[.='Automation'])[1]"));
        automationWriting.isDisplayed();

        //Login butonuna basalım
        driver.findElement(By.xpath("//a[@href='/login']")).click();


        WebElement loginToAccount = driver.findElement(By.xpath("//*[.='Login to your account']"));
        loginToAccount.isDisplayed();


        WebElement mail = driver.findElement(By.xpath("(//*[@name='email'])[1]"));
        WebElement pass = driver.findElement(By.xpath("(//*[@name='password'])[1]"));
        WebElement loginBox = driver.findElement(By.xpath("(//*[@class='btn btn-default'])[1]"));

        mail.sendKeys("jordan.arjen@forkshape.com");
        pass.sendKeys("123456789");
        loginBox.submit();

        //Verify that 'Logged in as username' is visible
        WebElement LoggedIn = driver.findElement(By.xpath("//*[.='Furkan Can']"));
        LoggedIn.isDisplayed();


        //Click 'Logout' button
        WebElement logOutButton = driver.findElement(By.xpath("((//*[@data-qa='login-button'])"));
        logOutButton.click();



        //Verify that user is navigated to login page
        WebElement afterLoggedOut = driver.findElement(By.xpath("//*[.='Login to your account']"));
        afterLoggedOut.isDisplayed();


    }
}
