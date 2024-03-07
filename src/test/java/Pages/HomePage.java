package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class HomePage extends BasePage{

    public HomePage(WebDriver givenDriver){
        super(givenDriver);
    }



    private By userAvatarIcon = By.cssSelector("img.avatar");
    private By searchField = By.cssSelector("input[name='q']");
    private By viewAllBtn = By.cssSelector("button[data-test='view-all-songs-btn']");
    private By firstSong = By.cssSelector("#songResultsWrapper>div>div>div.item-container>table>tr:nth-child(1)>td.title");

    private By addToBtn = By.cssSelector("button.btn-add-to");

    private By selectedPlaylistBtn = By.cssSelector("#songResultsWrapper>header>div.song-list-controls>div>section.existing-playlists>ul>li:nth-child(5)");




    public WebElement getUserAvatar(){
        return findElementUsingByLocator(userAvatarIcon);
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

    public void clickPlaylist(){
        //WebElement selectedPlaylist = driver.findElement(By.cssSelector("#songResultsWrapper>header>div.song-list-controls>div>section.existing-playlists>ul>li:nth-child(5)"));
        WebElement selectedPlaylist = wait.until(ExpectedConditions.elementToBeClickable(selectedPlaylistBtn));
        selectedPlaylist.click();
    }


}

