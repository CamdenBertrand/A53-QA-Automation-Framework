package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;

public class AllSongsPage extends BasePage{

    public AllSongsPage(WebDriver givenDriver){ super(givenDriver);}

    //Elements
    By firstSongInAllSongs = By.cssSelector(".all-songs tr.song-item:nth-child(1)");
    By playBtnInContextMenu = By.cssSelector("li.playback");

    By countSongsLocator = By.cssSelector("section#playlistWrapper td.title");

    By songListLocator = By.cssSelector("section#playlistWrapper td.title");

    //Methods

//    public WebElement firstSongInAllSongs() {
//        return findElementUsingByLocator(firstSongInAllSongs);
//    }

    public void contextClickFirstSong() throws InterruptedException {
        WebElement firstSongInTheList = wait.until(ExpectedConditions.visibilityOfElementLocated(firstSongInAllSongs));
        actions.contextClick(firstSongInTheList).perform();
    }

    public void choosePlayOption() throws InterruptedException{
        wait.until(ExpectedConditions.visibilityOfElementLocated(playBtnInContextMenu)).click();
    }

    public void displayAllSongs() throws InterruptedException {

        List<WebElement> songList = driver.findElements(songListLocator);
        System.out.println("Number of songs found: " + countSongs());
        for (WebElement e : songList) {
            System.out.println(e.getText());
        }
    }
    public int countSongs(){
        return driver.findElements(countSongsLocator).size();
    }

}
