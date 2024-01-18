package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage{

    public HomePage(WebDriver givenDriver){
        super(givenDriver);
    }



    private By userAvatarIcon = By.cssSelector("img.avatar");




    public WebElement getUserAvatar(){
        return findElementUsingByLocator(userAvatarIcon);
    }

    public WebElement allSongsList() {
        return findElementUsingByLocator(allSongsList);
    }

}

