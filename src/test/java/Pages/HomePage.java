package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.testng.Assert;

import javax.swing.*;
import java.security.Key;

public class HomePage extends BasePage{

    public HomePage(WebDriver givenDriver){
        super(givenDriver);
    }


    String newPlaylistName = "Sample Edited Playlist";

    private By loginImage = By.cssSelector("#app > div > div > form > div.logo > img");

    private By userAvatarIcon = By.cssSelector("img.avatar");

    private By searchField = By.cssSelector("input[name='q']");

    private By viewAllBtn = By.cssSelector("button[data-test='view-all-songs-btn']");

    private By firstSong = By.cssSelector("#songResultsWrapper>div>div>div.item-container>table>tr:nth-child(1)>td.title");

    private By addToBtn = By.cssSelector("button.btn-add-to");

    private By createPlaylistButton = By.cssSelector("i.fa.fa-plus-circle.create");

    private By newPlaylistDropdown = By.cssSelector("li[data-testid='playlist-context-menu-create-simple']");

    private By playlistNameField = By.cssSelector("input[name='name']");

    private By firstSongPL = By.cssSelector("#playlistWrapper > div > div > div.item-container > table > tr:nth-child(1)> td.title");


    private By selectedPlaylistBtn = By.cssSelector("#songResultsWrapper>header>div.song-list-controls>div>section.existing-playlists>ul>li:nth-child(5)");




    public WebElement getUserAvatar(){
        return findElementUsingByLocator(userAvatarIcon);
    }

    public WebElement getLoginImage() { return findElementUsingByLocator(loginImage);
    }

    public void searchSong(String title){
        //WebElement searchBar = driver.findElement(By.cssSelector("input[name='q']"));
        WebElement searchInput = wait.until(ExpectedConditions.visibilityOfElementLocated(searchField));
        searchInput.clear();
        searchInput.sendKeys(title);
    }

    public void clickViewAllButton(){
        // WebElement viewAllButton = driver.findElement(By.cssSelector("button[data-test='view-all-songs-btn']"));
        WebElement viewAllButton = wait.until(ExpectedConditions.elementToBeClickable(viewAllBtn));
        viewAllButton.click();
    }

    public void clickFirstSong() {
        // WebElement firstSongResult = driver.findElement(By.cssSelector("#songResultsWrapper>div>div>div.item-container>table>tr:nth-child(1)>td.title"));
        WebElement firstSongResult = wait.until(ExpectedConditions.elementToBeClickable(firstSong));
        firstSongResult.click();
    }

    public void clickAddToButton(){
        // WebElement addToButton = driver.findElement(By.cssSelector("button.btn-add-to"));
        WebElement addToButton = wait.until(ExpectedConditions.elementToBeClickable(addToBtn));
        addToButton.click();
    }

    public void clickPlaylistDropdown(){
        //WebElement selectedPlaylist = driver.findElement(By.cssSelector("#songResultsWrapper>header>div.song-list-controls>div>section.existing-playlists>ul>li:nth-child(5)"));
        WebElement selectedPlaylist = wait.until(ExpectedConditions.elementToBeClickable(selectedPlaylistBtn));
        selectedPlaylist.click();
    }


    public void clickCreateNewPlaylist() {
        WebElement createNewPlaylistBtn = fluentWait.until(ExpectedConditions.elementToBeClickable(createPlaylistButton));
        createNewPlaylistBtn.click();
    }

    public void clickCreateNewDropdown() {
        WebElement createNewPlaylistDropdown = wait.until(ExpectedConditions.elementToBeClickable(newPlaylistDropdown));
        createNewPlaylistDropdown.click();
    }

    public void enterPlaylistName(String title) {
        WebElement playlistNameInput = wait.until(ExpectedConditions.visibilityOfElementLocated(playlistNameField));
        playlistNameInput.clear();
        playlistNameInput.sendKeys(title);
        playlistNameInput.sendKeys(Keys.RETURN);
    }

    public void clickXPlaylist() {
        //WebElement xPlaylistButton = driver.findElement(By.cssSelector("button.del.btn-delete-playlist"));
        WebElement xPlaylistButton = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("button.del.btn-delete-playlist")));
        xPlaylistButton.click();
    }

    public void clickPlaylist() {
        //WebElement firstPlaylist = driver.findElement(By.xpath("//*[@id='playlists']/ul/li[3]"));
        WebElement firstPlaylist = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='playlists']/ul/li[3]")));
        firstPlaylist.click();
    }

    public void clickFirstSongPL() {
        WebElement firstSongPlaylist = wait.until(ExpectedConditions.elementToBeClickable(firstSongPL));
        firstSongPlaylist.click();
        actions.sendKeys(Keys.DELETE).perform();
    }

    public void doubleClickPlaylist() {
        WebElement playlistElement = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(".playlist:nth-child(3)")));
        actions.doubleClick(playlistElement).perform();
    }

    public void enterNewPlaylistName(){
        WebElement playlistInputField = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("[name='name']")));
        playlistInputField.click();
        playlistInputField.sendKeys(Keys.chord(Keys.CONTROL,"A", Keys.BACK_SPACE));
        playlistInputField.sendKeys(newPlaylistName);
        playlistInputField.sendKeys(Keys.ENTER);
    }
    public WebElement hoverPlay() {
        WebElement playBtn = driver.findElement(By.cssSelector("#mainFooter > div.side.player-controls > span > span.play > i"));
        actions.moveToElement(playBtn).perform();
        return wait.until(ExpectedConditions.visibilityOf(playBtn));
    }
    public WebElement hoverCreatePlaylist() {
        WebElement playBtn = driver.findElement(By.cssSelector("#playlists > h1 > i"));
        actions.moveToElement(playBtn).perform();
        return wait.until(ExpectedConditions.visibilityOf(playBtn));
    }



    public void clickLogOut() {
        WebElement logOutButton = fluentWait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("a.logout.control")));
        actions.moveToElement(logOutButton).perform();
        logOutButton.click();
    }
    public void hoverPlayButton() throws InterruptedException{

        Assert.assertTrue(hoverPlay().isDisplayed());
    }
}

