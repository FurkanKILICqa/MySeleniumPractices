package MyPractices;

import com.github.javafaker.Faker;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import utilities.TestBase;

public class C01 extends TestBase {











    // Verify that 'ACCOUNT CREATED!' is visible
    // Click 'Continue' button
    // Verify that 'Logged in as username' is visible
    // Click 'Delete Account' button
    // Verify that 'ACCOUNT DELETED!' is visible and click 'Continue' button


    @Test
    public void test01() {



        driver.get("http://automationexercise.com");

         //2. Verify that home page is visible successfully
         WebElement homePage = driver.findElement(By.xpath("(//span)[2]"));

        //Verify that home page is visible successfully
        Assert.assertTrue(homePage.isEnabled());


        //Click on 'Signup / Login' button
       driver.findElement(By.xpath("(//a)[5]")).click();


        //Verify 'New User Signup!' is visible
        String actualTitle = driver.findElement(By.xpath("(//h2)[3]")).getText();
        String acceptedTitle = "New User Signup!";

        Assert.assertEquals(actualTitle,acceptedTitle);


        //Enter name
        Faker faker = new Faker();
        String name = faker.name().fullName();
        WebElement nameBox = driver.findElement(By.xpath("//*[@name='name'][1]"));
        nameBox.sendKeys(name);

        //email address
        String email = faker.internet().emailAddress();
        WebElement emailBox = driver.findElement(By.xpath("(//*[@name='email'])[2]"));
        emailBox.sendKeys(email);


        //Click 'Signup' button
        driver.findElement(By.xpath("(//*[@type='submit'])[2]")).click();


        //Verify that 'ENTER ACCOUNT INFORMATION' is visible
        String actualVerify = driver.findElement(By.xpath("//h2")).getText();
        String acceptedVerify = "ENTER ACCOUNT INFORMATION";

        Assert.assertEquals(actualVerify,acceptedVerify);


        //Fill details: Title, Name, Email, Password, Date of birth
        driver.findElement(By.xpath("(//*[@type='radio'])[1]")).click();

        Actions actions = new Actions(driver);
         actions.sendKeys(Keys.PAGE_DOWN).perform();

        String verfiedName = faker.name().fullName();


        WebElement name2 = driver.findElement(By.xpath("(//*[@class='form-control'])[1]"));

        name2.sendKeys(verfiedName,Keys.TAB,
                faker.internet().emailAddress(),Keys.TAB,
                faker.internet().password());

        WebElement day = driver.findElement(By.xpath("//*[@name='days']"));
        day.click();
        day.sendKeys("5");
        day.click();


        WebElement mount = driver.findElement(By.xpath("//*[@id='months']"));
        mount.click();
        mount.sendKeys("May");
        mount.click();

        WebElement year = driver.findElement(By.xpath("//*[@id='years']"));
        year.click();
        year.sendKeys("1996");
        year.click();


        // Select checkbox 'Sign up for our newsletter!'
        WebElement signBox = driver.findElement(By.xpath("//*[@name='newsletter']"));
        signBox.click();


        // Select checkbox 'Receive special offers from our partners!'
        WebElement reciveBox = driver.findElement(By.xpath("//*[@name='optin']"));
        reciveBox.click();


        waitForSecond(1);
        actions.sendKeys(Keys.PAGE_DOWN).perform();
        // Fill details: First name, Last name, Company, Address, Address2, Country, State, City, Zipcode, Mobile Number
        // Click 'Create Account button'
        String name3 = faker.name().fullName();

        WebElement fillAll = driver.findElement(By.xpath("//*[@id='first_name']"));
        fillAll.sendKeys(name3,Keys.TAB,
                faker.name().lastName(),
                Keys.TAB,faker.company().name(),Keys.TAB);

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
                Keys.TAB,faker.address().fullAddress(),
                Keys.TAB,faker.address().secondaryAddress(),
                Keys.TAB, faker.phoneNumber().cellPhone(),
                Keys.TAB, Keys.ENTER);
























































    }






    ////1. Navigate to url 'http://automationexercise.com'
    //        driver.get("http://automationexercise.com");
    //
    //        //2. Verify that home page is visible successfully
    //      WebElement homePage = driver.findElement(By.xpath("(//span)[2]"));
    //
    //        //3. Verify that home page is visible successfully
    //        Assert.assertTrue(homePage.isEnabled());
    //
    //        //4. Click on 'Signup / Login' button
    //        driver.findElement(By.xpath("(//a)[5]")).click();
    //
    //
    //        //5. Verify 'New User Signup!' is visible
    //        String actualData = driver.findElement(By.xpath("(//h2)[3]")).getText();
    //        String acceptedData = "New User Signup!";
    //
    //        Assert.assertEquals(actualData,acceptedData);
    //
    //
    //        //6. Enter name and email address
    //       WebElement name = driver.findElement(By.xpath("//*[@name='name']"));
    //
    //       name.sendKeys("John");
    //
    //       WebElement email = driver.findElement(By.xpath("(//*[@name='email'])[2]"));
    //
    //       email.sendKeys("dmauri.keyden@forkshape.com");
    //
    //
    //        //7. Click 'Signup' button
    //        driver.findElement(By.xpath("(//*[@type='submit'])[2]")).click();
    //
    //
    //        //8. Verify that 'ENTER ACCOUNT INFORMATION' is visible
    //       WebElement enter = driver.findElement(By.xpath("(//b)[1]"));
    //
    //        Assert.assertTrue(enter.isDisplayed());
    //
    //        //9. Fill details: Title, Name, Email, Password, Date of birth
    //       WebElement title = driver.findElement(By.xpath("(//*[@id='id_gender1'])[1]"));
    //
    //        if (!title.isSelected()){
    //
    //            title.click();
    //        }
    //        Assert.assertTrue(title.isSelected());
    //
    //        WebElement password = driver.findElement(By.xpath("(//*[@id='password'])[1]"));
    //
    //        password.sendKeys("password");
    //
    //
    //        //10. Select checkbox 'Sign up for our newsletter!'
    //        WebElement signUpFor = driver.findElement(By.xpath("//*[@id='newsletter'][1]"));
    //
    //        if (!signUpFor.isSelected()){
    //
    //            signUpFor.click();
    //        }
    //        Assert.assertTrue(signUpFor.isSelected());
    //
    //
    //        //11. Select checkbox 'Receive special offers from our partners!'
    //        WebElement receive = driver.findElement(By.xpath("//*[@id='optin'][1]"));
    //
    //        if (!receive.isSelected()){
    //
    //            receive.click();
    //        }
    //        Assert.assertTrue(receive.isSelected());
}
