package MyPractices;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

public class C03_Hamcrest extends TestBase {

    @Test
    public void test01() {

        //- http://szimek.github.io/signature_pad/ sayfasına gidiniz
        driver.get("http://szimek.github.io/signature_pad/");


        //- Çıkan ekrana istediğiniz çizgi yada şekli çiziniz
       WebElement drowing = driver.findElement(By.xpath("//*[@style='touch-action: none; user-select: none;']"));
        Actions actions = new Actions(driver);
        actions.clickAndHold(drowing).moveByOffset(200,120).moveByOffset(120,120).
                release(drowing).perform();



        //- Çizimden sonra clear butonuna basınız
        driver.findElement(By.xpath("//*[@class='button clear']")).click();





    }
}
