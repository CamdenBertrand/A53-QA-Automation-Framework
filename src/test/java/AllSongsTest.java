import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class AllSongsTest extends BaseTest{

    String newPlaylistName = "Sample Edited Playlist";
    //Tests start here.
    @Test
    public void playSongByContextClick() throws InterruptedException{
        logInToKoelApp();
        chooseAllsongList();
        contextClickFirstSong();
        choosePlayOption();
        //Assertions
        Assert.assertTrue(isSongPlaying());
    }

    @Test
    public void hoveroverPlayButton() throws InterruptedException{
        logInToKoelApp();
        Thread.sleep(2000);
        //Assertion
        Assert.assertTrue(hoverPlay().isDisplayed());
    }

    @Test
    public void countSongsInPlaylist() throws InterruptedException {
        logInToKoelApp();
        choosePlaylistByName("Playlist Demo");
        displayAllSongs();
        Thread.sleep(2000);
        //Assertion
        Assert.assertTrue(getPlaylistDetails().contains(String.valueOf(countSongs())));
    }

    @Test
    public void renamePlaylist(){
        String updateplaylistMsg = "Updated playlist \"Sample Edited Playlist.\"";

        logInToKoelApp();
        doubleClickPlaylist();
        enterNewPlaylistName();
        //Assertion
        Assert.assertEquals(getRenamePlaylistSuccessMsg(), updateplaylistMsg);
    }



    //create a test to hover over play btn, click play, and verify song plays.

    //Tests end here.

    //helper methods start here.

    public void doubleClickPlaylist() {
        WebElement playlistElelment = fluentWait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".playlist:nth-child(3)")));
        actions.doubleClick(playlistElelment).perform();
    }

    public void enterNewPlaylistName(){
        WebElement playlistInputField = fluentWait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("[name='name']")));
        playlistInputField.sendKeys(Keys.chord(Keys.CONTROL,"A", Keys.BACK_SPACE));
        playlistInputField.sendKeys(newPlaylistName);
        playlistInputField.sendKeys(Keys.ENTER);
    }

    public String getRenamePlaylistSuccessMsg() {
        WebElement notification = fluentWait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div.success.show")));
        return notification.getText();
    }

    private void choosePlayOption() throws InterruptedException{
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("li.playback"))).click();
    }

    public void contextClickFirstSong() throws InterruptedException {
        WebElement firstSongInTheList = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".all-songs tr.song-item:nth-child(1)")));
        actions.contextClick(firstSongInTheList).perform();
    }

    public void chooseAllsongList() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("li a.songs"))).click();
    }

    public boolean isSongPlaying(){
        WebElement soundBars = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("img[alt='Sound bars']")));
        return soundBars.isDisplayed();
    }

    public WebElement hoverPlay(){
        WebElement playBtn = driver.findElement(By.cssSelector("span.play"));
        actions.moveToElement(playBtn).perform();
        return wait.until(ExpectedConditions.visibilityOf(playBtn));
    }
    public void displayAllSongs() throws InterruptedException {
        Thread.sleep(2000);
        List<WebElement> songList = driver.findElements(By.cssSelector("section#playlistWrapper td.title"));
        System.out.println("Number of songs found: " + countSongs());
        for (WebElement e : songList) {
            System.out.println(e.getText());
        }
    }

    public void choosePlaylistByName(String playlistName) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[contains(text(), '" + playlistName + "')]"))).click();
    }

    public int countSongs(){
        return driver.findElements(By.cssSelector("section#playlistWrapper td.title")).size();
    }

    public String getPlaylistDetails(){ //retrives playlist details from playlist header (displays number of songs in playlist)
        return driver.findElement(By.cssSelector("span.meta.text-secondary span.meta")).getText();
    }
//helper methods end here.
}
