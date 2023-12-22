package MyPractices;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.github.javafaker.Faker;
import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import utilities.TestBase;

import javax.swing.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class C05 extends TestBase {










    @Test
    public void test01() {

        driver.get("https://gleeful-lamington-a9d9de.netlify.app/");


        //extentTest = extentReports.createTest("Verifying that the page title is 'Batch 189 Selenium' " +
        //        ", Verify that the page title displays 'Batch 189 Selenium'");

        //Sayfa başlığının "Batch 189 Selenium" olarak görüntülenip görüntülenmediğini test edin.
        String actualTitle = driver.getTitle();
        String acepteedTitle = "Batch 189 Selenium";
        Assert.assertEquals(acepteedTitle,actualTitle);

        Actions actions = new Actions(driver);
        actions.sendKeys(Keys.ENTER,Keys.PAGE_DOWN).perform();
        Faker faker = new Faker();


        //"Kullanıcı Adı" ve "Şifre" alanlarına faker ile değer girin ve formu gönderin.
        WebElement username = driver.findElement(By.xpath("//*[@name='username']"));
        WebElement password = driver.findElement(By.xpath("//*[@name='password']"));
        username.sendKeys(faker.name().fullName());
        password.sendKeys(faker.internet().password());

        waitForSecond(1);

        WebElement send = driver.findElement(By.xpath("//*[@type='submit']"));
        actions.scrollToElement(send).perform();
        waitForSecond(1);
        send.submit();

        // Başarılı mesajının ("Merhaba [Kullanıcı Adı]! İşlem başarılı.")
        WebElement actualWriting = driver.findElement(By.xpath("//*[@id='messageBox']"));
       Assert.assertTrue(actualWriting.isDisplayed());

       waitForSecond(2);



       actions.scrollToElement(password).perform();
        driver.findElement(By.xpath("//*[@name='username']")).clear();
        driver.findElement(By.xpath("//*[@name='password']")).clear();

        waitForSecond(1);
        actions.scrollToElement(send).perform();
        send.submit();

    }

    @Test
    public void test02() {

        driver.get("https://gleeful-lamington-a9d9de.netlify.app/");

        Actions actions = new Actions(driver);

        //"Kullanıcı Adı" ve "Şifre" alanlarını boş bırakın ve formu göndermeye çalışın.
        WebElement send = driver.findElement(By.xpath("//*[@type='submit']"));
        actions.scrollToElement(send).perform();
        waitForSecond(1);


        // İslemin basarili bir sekilde gerceklesmedigini dogrulayin.
        //Assert.assertFalse(send.isDisplayed());

    }


    @Test
    public void test03() {

        //Cinsiyet radio buttonlarından birini (örneğin "Erkek") seçin ve
        // Seçimin başarılı bir şekilde yapıldığını doğrulayın.

        driver.get("https://gleeful-lamington-a9d9de.netlify.app/");

        Actions actions = new Actions(driver);

        WebElement maleBox = driver.findElement(By.xpath("//*[@id='male']"));
        actions.scrollToElement(maleBox).perform();
        waitForSecond(1);
        maleBox.click();
        Assert.assertTrue(maleBox.isSelected());


        //"Ülke" drop-down menüsünden bir ülkeyi (örneğin "Türkiye") seçin.
        // Seçimin başarılı bir şekilde yapıldığını doğrulayın.

        WebElement dropDown = driver.findElement(By.xpath("//*[@id='country']"));
        actions.scrollToElement(dropDown).perform();
        waitForSecond(1);
        Select select = new Select(dropDown);

        select.selectByVisibleText("Türkiye");

        //"Dersler" bölümünden birden fazla ders seçin (örneğin "Java" ve "SQL").
        WebElement sql = driver.findElement(By.xpath("//*[@id='sql']"));
        actions.scrollToElement(sql);
        waitForSecond(1);
        WebElement HTML = driver.findElement(By.xpath("//*[@id='sdlc']"));
        WebElement CSS = driver.findElement(By.id("html-css"));
        sql.click();
        HTML.click();
        CSS.click();

        // Seçimlerin başarılı bir şekilde yapıldığını doğrulayın.
        Assert.assertTrue(sql.isSelected());
        Assert.assertTrue(HTML.isSelected());
        Assert.assertTrue(CSS.isSelected());

        //Sayfadaki Videoyu baslatin, daha sonra durdurun, daha sonra gönder butonunun etkilesime acik oldugunu doğrulayın.
        actions.sendKeys(Keys.PAGE_DOWN).perform();

        WebElement iframe = driver.findElement(By.xpath("//*[@src='https://www.youtube.com/embed/vElDevkTzn8']"));
        driver.switchTo().frame(iframe);

        WebElement playButton = driver.findElement(By.xpath("//*[@class='ytp-large-play-button ytp-button ytp-large-play-button-red-bg']"));

        playButton.click();

        WebElement youtubeWriting = driver.findElement(By.xpath("//*[@class='ytp-youtube-button ytp-button yt-uix-sessionlink']"));
        Assert.assertTrue(youtubeWriting.isDisplayed());

        WebElement stopButton = driver.findElement(By.xpath("//*[@class='ytp-play-button ytp-button']"));
        stopButton.click();

        driver.switchTo().defaultContent();
        WebElement send = driver.findElement(By.xpath("//*[@type='submit']"));
        actions.scrollToElement(send).perform();
        Assert.assertTrue(send.isEnabled());

    }


    @Test
    public void test04() {

        driver.get("https://gleeful-lamington-a9d9de.netlify.app/");

        //"Yorumlar" alanına bir yorum yazin ve yazinin basarili bir sekilde gönderildigini doğrulayin (JSEXECUTOR).
        Actions actions = new Actions(driver);

        WebElement send = driver.findElement(By.xpath("//*[@type='submit']"));
        actions.scrollToElement(send).perform();
        Assert.assertTrue(send.isEnabled());

        WebElement comment = driver.findElement(By.xpath("//textarea[@id='comments']"));
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].value='Ödev için Teşekkürler Hocam'",comment);

        String writtenCommend =js.executeScript("return document.getElementById('comments').value").toString();
        Assert.assertEquals(writtenCommend,"Ödev için Teşekkürler Hocam");

    }


    @Test
    public void test05() {

        //8. inci maddede belirtilen test senaryosunun extent html reporter kullanarak html raporunu alin

        extentReports = new ExtentReports();

        driver.get("https://gleeful-lamington-a9d9de.netlify.app/");


        String date = DateTimeFormatter.ofPattern("ddMMyyyy_HHmmss").format(LocalDateTime.now());
        String path = "target/extentReport/" + date + "htmlReport.html";
        extentHtmlReporter = new ExtentHtmlReporter(path);
        extentReports.attachReporter((extentHtmlReporter));
        extentHtmlReporter.config().setDocumentTitle("Batch 189 Test Otomasyon Formu");
        extentHtmlReporter.config().setReportName("Smoke Test");
        extentReports.setSystemInfo("Enviroment", "QA");
        extentReports.setSystemInfo("Browser", "Chrome");
        extentReports.setSystemInfo("Test Automation Engineer", "Kadir Furkan Kilic");
        extentTest=extentReports.createTest("Test Otomasyon Formu","Test Report");


    //Extent html reportunuzun sayfa basliginin ve test isminin sizin belirttiginiz isimler oldugunu otomasyon ile test edin

        String title =  extentHtmlReporter.config().getDocumentTitle();
        String testName = extentHtmlReporter.config().getReportName();


        Assert.assertEquals(title,"Batch 189 Test Otomasyon Formu");
        extentTest.pass("Html reportunuzun sayfa basliginin Batch 189 Test Otomasyon Formu olduğu doğrulandı");

        Assert.assertEquals(testName,"Smoke Test");
        extentTest.pass("Test isminin Smoke test olduğu doğrulandı");



        extentReports.flush();


    }
}
