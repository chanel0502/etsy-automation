package tests;

import com.github.javafaker.Faker;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import pages.EtsyHomePage;
import utilities.Config;
import utilities.Driver;

public class Etsy {

    EtsyHomePage etsyHomePage = new EtsyHomePage();
    @Test
    public void search(){

        Faker faker = new Faker();
        String testData = faker.lorem().word();
        Driver.getDriver().get(Config.readValue("EtsyUrl"));
       etsyHomePage.searchInput.sendKeys(testData + Keys.ENTER);
        String title = Driver.getDriver().getTitle();
        Assert.assertFalse("Title failed",title.contains(testData));

    }
}
