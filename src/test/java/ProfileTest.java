import Pages.LoginPage;
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
        //login
        loginPage.logIn();
        //navigateToProfile
        clickOnAvatar();
        //Random new name
        String randomNewName = generateRandomName();
        //provide current password
        provideCurrentPassword("te$t$tudent");
        //Provide new random name
        provideNewName(randomNewName);
        //click on save button
        clickSave();
        //assertion
        WebElement actualProfileName = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("a.view-profile>span")));
        Assert.assertEquals(actualProfileName.getText(), randomNewName);


    }

    //helper methods
    //navigate to profile page
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
