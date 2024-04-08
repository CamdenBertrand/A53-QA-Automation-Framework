import Pages.BasePage;
import Pages.LoginPage;
import Pages.ProfilePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.UUID;

public class ProfileTest extends BaseTest{

    @Test
    public void changeProfileName() throws InterruptedException{
        LoginPage loginPage = new LoginPage(driver);
        ProfilePage profilePage = new ProfilePage(driver);
        BasePage basePage = new BasePage(driver);
        //login
        loginPage.logIn();
        //navigateToProfile
        profilePage.clickOnAvatar();
        //Random new name
        String randomNewName = profilePage.generateRandomName();
        //provide current password
        profilePage.provideCurrentPassword("te$t$tudent");
        //Provide new random name
        profilePage.provideNewName(randomNewName);
        //click on save button
        profilePage.clickSave();
        Assert.assertTrue(basePage.successShowMsg().isDisplayed());
        //assertion
        WebElement actualProfileName = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("a.view-profile>span")));
        Assert.assertEquals(actualProfileName.getText(), randomNewName);


    }


}
