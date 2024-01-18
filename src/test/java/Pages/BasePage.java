package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class BasePage {
    protected WebDriver driver;
    protected WebDriverWait wait;

    protected Actions actions;

    //Elements
    By soundBarVisualizer = By.cssSelector("img[alt='Sound bars']");
    By allSongsList = By.cssSelector("li a.songs");

    public BasePage(WebDriver givenDriver){
        driver = givenDriver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        actions = new Actions(driver);
        PageFactory.initElements(driver, this);
    }

    public WebElement findElementUsingByLocator(By locator){
        return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    public boolean isSongPlaying(){
        WebElement soundBars = wait.until(ExpectedConditions.visibilityOfElementLocated(soundBarVisualizer));
        return soundBars.isDisplayed();
    }

    public void goToAllSongsList(){
        findElementUsingByLocator(allSongsList).click();
    }

    public void choosePlaylistByName(String playlistName) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[contains(text(), '" + playlistName + "')]"))).click();
    }
}

