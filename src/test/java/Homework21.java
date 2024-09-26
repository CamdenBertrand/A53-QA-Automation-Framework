import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Homework21 extends BaseTest{
    String newPlaylistName = "Sample Edited Playlist";
    @Test
    public void renamePlaylist(){
        String updateplaylistMsg = "Updated playlist \"Sample Edited Playlist.\"";

        logInToKoelApp();
        doubleClickPlaylist();
        enterNewPlaylistName();
        //Assertion
        Assert.assertEquals(getRenamePlaylistSuccessMsg(), updateplaylistMsg);
    }

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
}
