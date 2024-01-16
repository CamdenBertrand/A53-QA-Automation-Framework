package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage extends BasePage{

    public LoginPage(WebDriver givenDriver){
        super(givenDriver);
    }

    //element locators

    By emailField = By.cssSelector("input[type='email']");

    By passwordField = By.cssSelector("input[type='password']");

    By submitBtn = By.cssSelector("button[type='submit']");



    //page methods

    public void provideEmail(String email){
        findElementUsingByLocator(emailField).sendKeys(email);
    }

    public void providePassword(String password){
        findElementUsingByLocator(passwordField).sendKeys(password);
    }

    public void clickSubmit(){
        findElementUsingByLocator(submitBtn).click();
    }

    public void logIn(){
        provideEmail("camden.bertrand@testpro.io");
        providePassword("te$t$tudent");
        clickSubmit();
    }
}
