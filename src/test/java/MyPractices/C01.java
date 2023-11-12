package MyPractices;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

public class C01 extends TestBase {







    //12. Fill details: First name, Last name, Company, Address, Address2, Country, State, City, Zipcode, Mobile Number
    //13. Click 'Create Account button'
    //14. Verify that 'ACCOUNT CREATED!' is visible
    //15. Click 'Continue' button
    //16. Verify that 'Logged in as username' is visible
    //17. Click 'Delete Account' button
    //18. Verify that 'ACCOUNT DELETED!' is visible and click 'Continue' button


    @Test
    public void test01() {

        //1. Navigate to url 'http://automationexercise.com'
        driver.get("http://automationexercise.com");

        //2. Verify that home page is visible successfully
      WebElement homePage = driver.findElement(By.xpath("(//span)[2]"));

        //3. Verify that home page is visible successfully
        Assert.assertTrue(homePage.isEnabled());

        //4. Click on 'Signup / Login' button
        driver.findElement(By.xpath("(//a)[5]")).click();


        //5. Verify 'New User Signup!' is visible
        String actualData = driver.findElement(By.xpath("(//h2)[3]")).getText();
        String acceptedData = "New User Signup!";

        Assert.assertEquals(actualData,acceptedData);


        //6. Enter name and email address
       WebElement name = driver.findElement(By.xpath("//*[@name='name']"));

       name.sendKeys("John");

       WebElement email = driver.findElement(By.xpath("(//*[@name='email'])[2]"));

       email.sendKeys("dmauri.keyden@forkshape.com");


        //7. Click 'Signup' button
        driver.findElement(By.xpath("(//*[@type='submit'])[2]")).click();


        //8. Verify that 'ENTER ACCOUNT INFORMATION' is visible
       WebElement enter = driver.findElement(By.xpath("(//b)[1]"));

        Assert.assertTrue(enter.isDisplayed());

        //9. Fill details: Title, Name, Email, Password, Date of birth
       WebElement title = driver.findElement(By.xpath("(//*[@id='id_gender1'])[1]"));

        if (!title.isSelected()){

            title.click();
        }
        Assert.assertTrue(title.isSelected());

        WebElement password = driver.findElement(By.xpath("(//*[@id='password'])[1]"));

        password.sendKeys("password");


        //10. Select checkbox 'Sign up for our newsletter!'
        WebElement signUpFor = driver.findElement(By.xpath("//*[@id='newsletter'][1]"));

        if (!signUpFor.isSelected()){

            signUpFor.click();
        }
        Assert.assertTrue(signUpFor.isSelected());


        //11. Select checkbox 'Receive special offers from our partners!'
        WebElement receive = driver.findElement(By.xpath("//*[@id='optin'][1]"));

        if (!receive.isSelected()){

            receive.click();
        }
        Assert.assertTrue(receive.isSelected());





    }
}
