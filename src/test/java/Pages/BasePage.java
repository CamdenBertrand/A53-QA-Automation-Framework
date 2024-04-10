package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class BasePage {
    protected WebDriver driver;
    protected WebDriverWait wait;
    protected Wait<WebDriver> fluentWait;

    protected Actions actions;

    //Elements
    By soundBarVisualizer = By.cssSelector("img[alt='Sound bars']");
    By allSongsList = By.cssSelector("li a.songs");

    By successShowMsg = By.cssSelector("div.success.show");

    By nextSongBtn = By.cssSelector("#mainFooter > div.side.player-controls > i.next.fa.fa-step-forward.control");

    By playBtn = By.cssSelector("#mainFooter > div.side.player-controls > span > span.play");




    public BasePage(WebDriver givenDriver){
        driver = givenDriver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        fluentWait = new FluentWait<WebDriver>(driver)
                .withTimeout(Duration.ofSeconds(10))
                .pollingEvery(Duration.ofSeconds(2))
                .ignoring(NoSuchElementException.class);

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
        findElementUsingByLocator(allSongsList).click();}

    public void choosePlaylistByName(String playlistName) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[contains(text(), '" + playlistName + "')]"))).click();
    }
    public WebElement successShowMsg(){
        return findElementUsingByLocator(successShowMsg);
    }


    public void clickPlayNextSong() {
        //WebElement nextSongBtn = driver.findElement(By.cssSelector("i[data-testid='play-next-btn']"));
        WebElement clickNextSongButton = fluentWait.until(ExpectedConditions.visibilityOfElementLocated(nextSongBtn));
        clickNextSongButton.click();
    }

    public void clickPlayButton() {
        //WebElement playButton = driver.findElement(By.cssSelector("span[data-testid='play-btn']"));
        WebElement playButton = fluentWait.until(ExpectedConditions.visibilityOfElementLocated(playBtn));
        playButton.click();
    }

}

