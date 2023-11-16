package MyPractices;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import utilities.TestBase;

import java.util.Set;

public class C02 extends TestBase {


    @Test
    public void test01() {

        //-http://demo.automationtesting.in/Alerts.html sayfasına gidiniz
        driver.get("http://demo.automationtesting.in/Alerts.html");


        //-Alert with OK karşısındaki click the button to display an alert box: butonuna tıklayınız
        WebElement alert01 = driver.findElement(By.xpath("//*[@class='btn btn-danger']"));
        alert01.click();

        //-Çıkan alert üzerindeki yazıyı konsola yazdırınız ve tamam butonuna basınız
        waitForSecond(1);
       String text = driver.switchTo().alert().getText();
        System.out.println("text = " + text);
        driver.switchTo().alert().accept();

        //-Alert with OK & Cancel butonuna basınız ve sonrasında click the button to display a confirm box butonuna basınız
        WebElement okCancel = driver.findElement(By.xpath("(//*[@class='analystic'])[2]"));
        okCancel.click();

        driver.findElement(By.xpath("(//*[@class='btn btn-primary'])")).click();

        waitForSecond(1);
        //-Çıkan alert'te iptal butonuna basınız
        driver.switchTo().alert().dismiss();

        waitForSecond(1);
        //-Alert with Textbox butonuna basınız ve sonrasında click the button to demonstrate the prompt box butonuna basınız
        WebElement alertTheBox = driver.findElement(By.xpath("(//*[@class='analystic'])[3]"));
        alertTheBox.click();


        //-Alert with Textbox butonuna basınız ve sonrasında click the button to demonstrate the prompt box butonuna basınız

        driver.findElement(By.xpath("(//*[@class='btn btn-info'])")).click();


        //-Çıkan prompt box'a 'isminizi' yazdırınız ve Tamam'a basınız
        driver.switchTo().alert().sendKeys("Furkan");
        driver.switchTo().alert().accept();


        //-Çıkan mesajı konsola yazdırınız
       String writtenMassage = driver.findElement(By.xpath("//*[@id='demo1']")).getText();
        System.out.println("Massage ==> " + writtenMassage);

        //-Çıkan mesajın 'Hello Furkan How are you today' yazdığını doğrulayınız
        Assert.assertEquals("Hello Furkan How are you today",writtenMassage);




    }
}
