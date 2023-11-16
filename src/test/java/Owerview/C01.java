package Owerview;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WindowType;
import utilities.TestBase;

public class C01 extends TestBase {


    @Test
    public void test01() {

        // 1- https://www.amazon.com sayfasina gidelim
        driver.get("https://www.amazon.com");
        driver.navigate().refresh();
        driver.navigate().refresh();
        String amznHandle = driver.getWindowHandle();

        // 2- url'in 'amazon' icerdigini test edelim
        Assert.assertTrue(driver.getCurrentUrl().contains("amazon"));


        // 3- yeni bir pencere acip https://www.bestbuy.com sayfasina gidelim
        driver.switchTo().newWindow(WindowType.WINDOW);
        driver.get("https://www.bestbuy.com");
        String bestHandle = driver.getWindowHandle();

        // 4- title'in 'Best Buy' icerdigini test edelim
        Assert.assertTrue(driver.getTitle().contains("Best Buy"));


        // 5- ilk sayfaya(amazon) donup sayfada java aratalım
        driver.switchTo().window(amznHandle);
        WebElement searcBox = driver.findElement(By.xpath("//*[@id='twotabsearchtextbox']"));
        searcBox.sendKeys("java",Keys.ENTER);



        // 6- arama sonuclarının 'java' icerdigini test edelim
        WebElement checkResult = driver.findElement(By.xpath("//*[@class='a-section a-spacing-small a-spacing-top-small']"));
        Assert.assertTrue(checkResult.getText().contains("java"));



        // 7- ikinci sayfaya(bestbuy) donelim
        driver.switchTo().window(bestHandle);


        // 8- logonun gorundugunu test edelim
       WebElement logo = driver.findElement(By.xpath("(//*[@class='logo'])[1]"));
       logo.isDisplayed();

    }
}
