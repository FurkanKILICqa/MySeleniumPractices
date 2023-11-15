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


       //Verify that 'ACCOUNT CREATED!' is visible
      String actualCreatedSuccess = driver.findElement(By.xpath("//b")).getText();
      String acceptedCreatedSucces = "ACCOUNT CREATED!";

      Assert.assertEquals(actualCreatedSuccess,acceptedCreatedSucces);


     // Click 'Continue' button
      driver.findElement(By.xpath("//*[@data-qa='continue-button']")).click();


     // Verify that 'Logged in as username' is visible
     WebElement loggedIn = driver.findElement(By.xpath("//b"));

     Assert.assertTrue(loggedIn.isEnabled());

     // Click 'Delete Account' button


    }


}
