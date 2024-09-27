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

    //helper methods

    public void clickOnAvatar(){
       // WebElement avatarIcon = driverdeleteVerifyMsg.findElement(By.cssSelector("img.avatar"));
        WebElement avatarIcon = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("img.avatar")));
        avatarIcon.click();
    }

    public String generateRandomName(){
        return UUID.randomUUID().toString().replace("-", "");
    }

    public void provideCurrentPassword(String password){
       // WebElement currentPasswordField = driver.findElement(By.cssSelector("[name='current_password']"));
        WebElement currentPasswordField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("[name='current_password']")));
        currentPasswordField.clear();
        currentPasswordField.sendKeys(password);
    }

    public void provideNewName(String newName){
       // WebElement profileNameField = driver.findElement(By.cssSelector("[name='name']"));
        WebElement profileNameField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("[name='name']")));
        profileNameField.clear();
        profileNameField.sendKeys(newName);
    }

    public void clickSave(){
        //WebElement saveButton = driver.findElement(By.cssSelector("button.btn-submit"));
        WebElement saveButton = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("button.btn-submit")));
        saveButton.click();
    }
}
