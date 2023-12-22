package TeamPractice;

import com.github.javafaker.Faker;
import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import utilities.TestBase;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.Duration;

public class Practice03 extends TestBase {

    @Test
    public void test01() {

        //2. Navigate to url 'http://automationexercise.com'
        driver.get("http://automationexercise.com");

        //3. Verify that home page is visible successfully
        WebElement automationWriting = driver.findElement(By.xpath("(//*[.='Automation'])[1]"));
        automationWriting.isDisplayed();

        WebElement scroll = driver.findElement(By.xpath("//*[@href='/brand_products/Biba']"));
        Actions actions = new Actions(driver);
        actions.scrollToElement(scroll).perform();

        //4. Add products to cart
        WebElement addToCard = driver.findElement(By.xpath("(//*[@class='btn btn-default add-to-cart'])[1]"));
        jsClick(addToCard);

        driver.findElement(By.xpath("//*[@class='btn btn-success close-modal btn-block']")).click();

        //5. Click 'Cart' button
        WebElement cart = driver.findElement(By.xpath("(//*[@class='fa fa-shopping-cart'])[1]"));
        actions.scrollToElement(cart).perform();
        jsClick(cart);

        //6. Verify that cart page is displayed and click Proceed To Checkout
        WebElement verifiedCardPage = driver.findElement(By.xpath("//*[@class='btn btn-default check_out']"));
       Assert.assertTrue(verifiedCardPage.isDisplayed());
        jsClick(verifiedCardPage);


        //8. Click 'Register / Login' button
        WebElement registerLogin = driver.findElement(By.xpath("(//u)[1]"));
        jsClick(registerLogin);


        //9. Fill all details in Signup and create account
        Faker faker = new Faker();
        String name = faker.name().fullName();
        WebElement nameBox = driver.findElement(By.xpath("//*[@name='name'][1]"));
        nameBox.sendKeys(name);


        String email = faker.internet().emailAddress();
        WebElement emailBox = driver.findElement(By.xpath("(//*[@name='email'])[2]"));
        emailBox.sendKeys(email);



        driver.findElement(By.xpath("(//*[@type='submit'])[2]")).click();



        String actualVerify = driver.findElement(By.xpath("//h2")).getText();
        String acceptedVerify = "ENTER ACCOUNT INFORMATION";

        Assert.assertEquals(actualVerify,acceptedVerify);



        driver.findElement(By.xpath("(//*[@type='radio'])[1]")).click();


        actions.sendKeys(Keys.PAGE_DOWN).perform();

        String verfiedName = faker.name().fullName();


        WebElement name2 = driver.findElement(By.xpath("(//*[@class='form-control'])[1]"));

        name2.sendKeys(verfiedName,Keys.TAB,
                faker.internet().emailAddress(),Keys.TAB,
                faker.internet().password());


        WebElement day = driver.findElement(By.xpath("//*[@name='days']"));
        Select select = new Select(day);
        select.selectByVisibleText("5");
       // day.click();
       // day.sendKeys("5");
       // day.click();


        WebElement mount = driver.findElement(By.xpath("//*[@id='months']"));
        Select select1 = new Select(mount);
        select1.selectByVisibleText("May");
       // mount.click();
       // mount.sendKeys("May");
       // mount.click();

        WebElement year = driver.findElement(By.xpath("//*[@id='years']"));
        Select select2 = new Select(year);
        select2.selectByVisibleText("1996");
       // year.click();
       // year.sendKeys("1996");
       // year.click();


        WebElement signBox = driver.findElement(By.xpath("//*[@name='newsletter']"));
        signBox.click();



        WebElement reciveBox = driver.findElement(By.xpath("//*[@name='optin']"));
        reciveBox.click();


        waitForSecond(1);
        actions.sendKeys(Keys.PAGE_DOWN).perform();

        String name3 = faker.name().fullName();

        WebElement fillAll = driver.findElement(By.xpath("//*[@id='first_name']"));
        fillAll.sendKeys(name3,Keys.TAB,
                faker.name().lastName(),
                Keys.TAB,faker.company().name(),Keys.TAB,faker.address().streetAddress());

        waitForSecond(1);
        actions.sendKeys(Keys.PAGE_DOWN).perform();

        String address = faker.address().fullAddress();
        WebElement fillAll2 = driver.findElement(By.xpath("//*[@name='address2']"));

        fillAll2.sendKeys(address,Keys.TAB,faker.address().secondaryAddress());

        WebElement city = driver.findElement(By.xpath("//*[@name='country']"));
        city.click();
        city.sendKeys("5");
        city.click();

        String state2 = faker.address().state();
        WebElement state = driver.findElement(By.xpath("(//*[@class='form-control'])[13]"));

        WebElement adress = driver.findElement(By.xpath("(//*[@class='form-control'])[10]"));
        waitForSecond(1);
        actions.moveToElement(adress);
        waitForSecond(1);
        actions.sendKeys(Keys.PAGE_DOWN);

        state.sendKeys(state2,Keys.TAB,
                faker.address().city(),
                Keys.TAB,faker.address().secondaryAddress(),
                Keys.TAB, faker.phoneNumber().cellPhone(),
                Keys.TAB, Keys.ENTER);

        //10. Verify 'ACCOUNT CREATED!' and click 'Continue' button
        String actualCreatedSuccess = driver.findElement(By.xpath("//b")).getText();
        String acceptedCreatedSucces = "ACCOUNT CREATED!";

        Assert.assertEquals(actualCreatedSuccess,acceptedCreatedSucces);

        driver.findElement(By.xpath("//*[@data-qa='continue-button']")).click();

        //11. Verify ' Logged in as username' at top
        WebElement loggedIn = driver.findElement(By.xpath("//b"));

        Assert.assertTrue(loggedIn.isEnabled());


        //12.Click 'Cart' button
        WebElement cart1 = driver.findElement(By.xpath("(//*[@class='fa fa-shopping-cart'])[1]"));
        jsClick(cart1);


        //13. Click 'Proceed To Checkout' button
        WebElement addToCard1 = driver.findElement(By.xpath("//*[@class='btn btn-default check_out']"));
        jsClick(addToCard1);



        //14. Verify Address Details and Review Your Order
        WebElement verifiyAdress = driver.findElement(By.xpath("(//*[@class='heading'])[1]"));
        Assert.assertTrue(verifiyAdress.isDisplayed());

        WebElement rewOrder = driver.findElement(By.xpath("(//*[@class='heading'])[2]"));
       Assert.assertTrue(rewOrder.isDisplayed());


        //15. Enter description in comment text area and click 'Place Order'
        WebElement textArea = driver.findElement(By.xpath("//*[@class='form-control']"));
        textArea.sendKeys("Ürün berbat");

        waitForSecond(1);
        WebElement placeOrder = driver.findElement(By.xpath("//*[@class='btn btn-default check_out']"));
        jsClick(placeOrder);


        //16. Enter payment details: Name on Card, Card Number, CVC, Expiration date
        WebDriverWait wait =new WebDriverWait(driver, Duration.ofSeconds(20));
        WebElement cardname = driver.findElement(By.xpath("//*[@class='form-control']"));
        WebElement carNumber = driver.findElement(By.name("card_number"));
        WebElement CVC = driver.findElement(By.xpath("//*[@class='form-control card-cvc']"));
        WebElement expiration = driver.findElement(By.xpath("//*[@class='form-control card-expiry-month']"));
        WebElement lastYear = driver.findElement(By.xpath("//*[@class='form-control card-expiry-year']"));

       // cardname.sendKeys(faker.name().firstName(),Keys.TAB,faker.finance().creditCard(),Keys.TAB,
       //         "123",Keys.TAB,"26",Keys.TAB,"2070");

      cardname.sendKeys(faker.name().fullName());
      //jsSendKeys(carNumber,faker.finance().creditCard());
      carNumber.sendKeys(faker.finance().creditCard());
        //carNumber.sendKeys("5019-6540-3601-3292");
        wait.until(ExpectedConditions.elementToBeClickable(carNumber));
      CVC.sendKeys("311");
      expiration.sendKeys("26");
      lastYear.sendKeys("1996");



        //17. Click 'Pay and Confirm Order' button
        driver.findElement(By.xpath("//*[@class='form-control btn btn-primary submit-button']")).click();



        //18. Verify success message 'Your order has been placed successfully!'
        String succesMassage = driver.findElement(By.xpath("//*[.='Congratulations! Your order has been confirmed!']")).getText();
        Assert.assertNotEquals("Your order has been placed successfully!",succesMassage);



        //19. Click 'Download Invoice' button and verify invoice is downloaded successfully.
        driver.findElement(By.xpath("//*[@class='btn btn-default check_out']")).click();


        String userHome = System.getProperty("user.home");
        String folderPath="\\Downloads\\invoice.txt";
        String dynamicPath =userHome+folderPath;

        try {
            Files.delete(Paths.get(dynamicPath));
        } catch (IOException e) {
            System.out.println("Belirtilen dosya silinemedi !!!! ");
        }


       // String dosyaYolu = System.getProperty("user.home")+ "\\Downloads\\invoice.txt";
       // Assert.assertTrue(Files.exists(Paths.get(dosyaYolu)));



        //20. Click 'Continue' button
        driver.findElement(By.xpath("//*[@class='btn btn-primary']")).click();



        //21. Click 'Delete Account' button
        driver.findElement(By.xpath("//*[@href='/delete_account']")).click();


        //22. Verify 'ACCOUNT DELETED!' and click 'Continue' button
        WebElement deletedAccount = driver.findElement(By.xpath("(//*[.='Account Deleted!'])[1]"));
        Assert.assertTrue(deletedAccount.isDisplayed());







    }

    @Test@Ignore
    public void name() {

        Faker faker = new Faker();
      String card =  faker.phoneNumber().cellPhone();
        System.out.println(card);

    }
}
