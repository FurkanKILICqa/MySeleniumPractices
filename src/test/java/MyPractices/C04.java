package MyPractices;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import utilities.TestBase;

import java.util.List;

public class C04 extends TestBase {


    @Test
    public void test01() {

        //https://the-internet.herokuapp.com/dropdown adresine gidin.
        driver.get("https://the-internet.herokuapp.com/dropdown");


        //1.Index kullanarak Seçenek 1’i (Option 1) seçin ve yazdırın
        WebElement options = driver.findElement(By.xpath("//*[@id='dropdown']"));
        Select select = new Select(options);
        select.selectByIndex(1);
        waitForSecond(1);

        System.out.println("Option 1 ==>  = " + select.getFirstSelectedOption().getText());


        //2.Value kullanarak Seçenek 2'yi (Option 2) seçin ve yazdırın
        waitForSecond(1);
        select.selectByValue("2");
        System.out.println("Option 2 ==> " + select.getFirstSelectedOption().getText());


        //3.Visible Text(Görünen metin) kullanarak Seçenek 1’i (Option 1) seçin ve yazdırın
        select.selectByVisibleText("Option 1");
        System.out.println("Visible Option 1 ==> " + select.getFirstSelectedOption().getText());

        //4.Tüm dropdown değerleri(value) yazdırın
      List<WebElement> alldropdown =  select.getOptions();

        for (WebElement w:alldropdown) {
            System.out.println("All selected ==> = " + w.getText());

        }

        //5.Dropdown’un boyutunu bulun, Dropdown’da 4 öğe varsa konsolda True , degilse
        //False yazdırın.

        if (alldropdown.size()==4){
            System.out.println("Condition result ==> " + "True");

        }else System.out.println("Condition result ==> " + "False");



    }


}
