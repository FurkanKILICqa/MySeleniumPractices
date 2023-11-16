package Owerview;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

public class C02 extends TestBase {

    @Test
    public void test01() {

        // https://demoqa.com/droppable adresine gidiniz
        driver.get("https://demoqa.com/droppable");

        WebElement drag = driver.findElement(By.xpath("//*[@id='draggable']"));
        WebElement drop = driver.findElement(By.xpath("(//*[@id='droppable'])[1]"));

        // 'Drag me' kutusunu tutup 'Drop here' kutusunun ustune birakiniz
        Actions actions = new Actions(driver);
        actions.clickAndHold(drag).moveToElement(drop).release().perform();


        // 'Drop here' yazisi yerine 'Dropped!' oldugunu test ediniz
        String dropped = driver.findElement(By.xpath("(//p[text()='Dropped!'])[1]")).getText();
        Assert.assertEquals("Dropped!",dropped);

    }
}
