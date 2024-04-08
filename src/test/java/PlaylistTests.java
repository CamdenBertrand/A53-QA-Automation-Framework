import Pages.HomePage;
import Pages.LoginPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class PlaylistTests extends BaseTest{

    @Test
    public void smokePlaylist(){
        LoginPage loginPage = new LoginPage(driver);
        HomePage homePage = new HomePage(driver);

        loginPage.logIn();
        homePage.clickCreateNewPlaylist();
        homePage.clickCreateNewDropdown();
        homePage.enterPlaylistName("Playlist Test");
        Assert.assertTrue(homePage.successShowMsg().isDisplayed());
        homePage.searchSong("Dark");
        homePage.clickViewAllButton();
        homePage.clickFirstSong();
        homePage.clickAddToButton();
        homePage.clickPlaylistDropdown();
        WebElement addSongMessage = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div[2]/div[contains(text(),'Added 1 song into \"Playlist Test.\"')]")));
        Assert.assertEquals(addSongMessage.getText(), "Added 1 song into \"Playlist Test.\"");
        homePage.clickPlaylist();
        homePage.clickFirstSongPL();
        WebElement removeSongMessage = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div[2]/div[contains(text(),'Removed 1 song from \"Playlist Test.\"')]")));
        Assert.assertEquals(removeSongMessage.getText(), "Removed 1 song from \"Playlist Test.\"");
        Assert.assertTrue(homePage.getUserAvatar().isDisplayed());
        homePage.doubleClickPlaylist();
        Assert.assertTrue(homePage.getUserAvatar().isDisplayed());
        homePage.enterNewPlaylistName();
        String updateplaylistMsg = "Updated playlist \"Sample Edited Playlist.\"";
        WebElement updatePlaylistVerifyMsg = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div[2]/div[contains(text(),'Updated playlist \"Sample Edited Playlist.\"')]")));
        Assert.assertEquals(updatePlaylistVerifyMsg.getText(), updateplaylistMsg);
        homePage.clickPlaylist();
        homePage.clickXPlaylist();
        String deleteVerifyText = "Deleted playlist \"Sample Edited Playlist.\"";
        WebElement deleteVerifyMsg = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div[2]/div[contains(text(),'Deleted playlist \"Sample Edited Playlist.\"')]")));
        Assert.assertEquals(deleteVerifyMsg.getText(), deleteVerifyText);


    }



}
