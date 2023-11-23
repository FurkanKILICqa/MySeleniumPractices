package Owerview;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

import java.sql.Driver;

public class C03 extends TestBase {





        // 'Powerful,but easy to misuse' yazısının gorunur oldugunu test ediniz


    @Test
    public void test01() {

        // https://html.com/tags/iframe sayfasına gidiniz
        driver.get("https://html.com/tags/iframe");


        //Videoyu görecek kadar asagiya ininiz
        Actions actions = new Actions(driver);

        // Videoyu görecek kadar asagiya ininiz
        actions.sendKeys(Keys.PAGE_DOWN,Keys.PAGE_DOWN).perform();


        //Videoyu izlemek icin Play tusuna basiniz
        WebElement frame = driver.findElement(By.xpath("//iframe[@src='https://www.youtube.com/embed/owsfdh4gxyc']"));

        driver.switchTo().frame(frame);

        driver.findElement(By.xpath("//*[@class='ytp-large-play-button" +
                " ytp-button ytp-large-play-button-red-bg']")).click();
        waitForSecond(5);

        // Videoyu calistirdiginizi test ediniz





    }
}
