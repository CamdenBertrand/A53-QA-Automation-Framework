package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.UUID;

public class ProfilePage extends BasePage{

    public ProfilePage(WebDriver givenDriver) {
        super(givenDriver);
    }

    //elements

    @FindBy(css = "img.avatar")
    WebElement avatarIconPF;
    @FindBy(css = "[name='current_password']")
    WebElement currentPasswordField;

    @FindBy(css = "[name='name']")
    WebElement profileNameField;

    @FindBy(css = "button.btn-submit")
    WebElement saveButton;

    public ProfilePage clickOnAvatar() throws InterruptedException {
        Thread.sleep(2000);
        avatarIconPF.click();
        return this;
    }
    public String generateRandomName(){
        return UUID.randomUUID().toString().replace("-", "");
    }

    public ProfilePage provideCurrentPassword(String password) throws InterruptedException {
        Thread.sleep(2000);
        currentPasswordField.clear();
        currentPasswordField.sendKeys(password);
        return this;
    }

    public ProfilePage provideNewName(String newName) throws InterruptedException {
        Thread.sleep(2000);
        profileNameField.clear();
        profileNameField.sendKeys(newName);
        return this;
    }

    public ProfilePage clickSave(){
        saveButton.click();
        return this;
    }
}