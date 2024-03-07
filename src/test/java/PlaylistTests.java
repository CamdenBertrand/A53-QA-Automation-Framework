import Pages.HomePage;
import Pages.LoginPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class PlaylistTests extends BaseTest{
    @Test
    public void addSongToPlaylist() throws InterruptedException {
        LoginPage loginPage = new LoginPage(driver);
        HomePage homePage = new HomePage(driver);

        loginPage.logIn();
        homePage.searchSong("Dark");
        homePage.clickViewAllButton();
        homePage.clickFirstSong();
        homePage.clickAddToButton();
        homePage.clickPlaylist();

        //WebElement songMessage = driver.findElement(By.xpath("/html/body/div[2]/div[contains(text(),'Added 1 song into \"Automation playlist.\"')]"));
        WebElement songMessage = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div[2]/div[contains(text(),'Added 1 song into \"Playlist Test.\"')]")));

        Assert.assertEquals(songMessage.getText(), "Added 1 song into \"Playlist Test.\"");



    }



}
