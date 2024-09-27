import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Homework19 extends BaseTest{
    @Test
    public void deletePlaylist() throws InterruptedException {
        navigateToUrl();
        provideEmail("camden.bertrand@testpro.io");
        providePassword("te$t$tudent");
        clickSubmit();
        clickPlaylist();
        clickXPlaylist();
        String deleteVerifyText = "Deleted playlist \"Automation playlist.\"";
        WebElement deleteVerifyMsg = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div.success.show")));
        Assert.assertEquals(deleteVerifyMsg.getText(), deleteVerifyText);
    }

    private void clickXPlaylist() {
        //WebElement xPlaylistButton = driver.findElement(By.cssSelector("button.del.btn-delete-playlist"));
        WebElement xPlaylistButton = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("button.del.btn-delete-playlist")));
        xPlaylistButton.click();
    }

    private void clickPlaylist() {
        //WebElement firstPlaylist = driver.findElement(By.xpath("//*[@id='playlists']/ul/li[3]"));
        WebElement firstPlaylist = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='playlists']/ul/li[3]")));
        firstPlaylist.click();
    }

}
