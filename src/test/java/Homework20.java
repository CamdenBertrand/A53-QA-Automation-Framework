import Pages.LoginPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Homework20 extends BaseTest{
    @Test
    public void deletePlaylist() throws InterruptedException {
        LoginPage loginPage = new LoginPage(driver);

        loginPage.logIn();
        clickPlaylist();
        clickXPlaylist();
        String deleteVerifyText = "Deleted playlist \"Automation playlist.\"";
        WebElement deleteVerifyMsg = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div.success.show")));
        Assert.assertEquals(deleteVerifyMsg.getText(), deleteVerifyText);
    }

    private void clickXPlaylist() {
        WebElement xPlaylistButton = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("button.del.btn-delete-playlist")));
        xPlaylistButton.click();
    }

    private void clickPlaylist() {
        WebElement firstPlaylist = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='playlists']/ul/li[3]")));
        firstPlaylist.click();
    }
}
