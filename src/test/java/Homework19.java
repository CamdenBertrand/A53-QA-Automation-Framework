import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Homework19 extends BaseTest{
    @Test
    public void deletePlaylist() throws InterruptedException {
        navigateToUrl();
        provideEmail("camden.bertrand@testpro.io");
        Thread.sleep(2000);
        providePassword("te$t$tudent");
        Thread.sleep(2000);
        clickSubmit();
        Thread.sleep(2000);
        clickPlaylist();
        Thread.sleep(2000);
        clickXPlaylist();
        Thread.sleep(2000);
        String deleteVerifyText = "Deleted playlist \"Automation playlist.\"";
        WebElement deleteVerifyMsg = driver.findElement(By.cssSelector("div.success.show"));
        Assert.assertEquals(deleteVerifyMsg.getText(), deleteVerifyText);
    }

    private void clickXPlaylist() {
        WebElement xPlaylistButton = driver.findElement(By.cssSelector("button.del.btn-delete-playlist"));
        xPlaylistButton.click();
    }

    private void clickPlaylist() {
        WebElement firstPlaylist = driver.findElement(By.xpath("//*[@id='playlists']/ul/li[3]"));
        firstPlaylist.click();
    }

}
