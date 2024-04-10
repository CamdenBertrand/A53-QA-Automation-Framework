import Pages.HomePage;
import Pages.LoginPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class PlaySongTest extends BaseTest{
    @Test
    public void playSong() {
        LoginPage loginPage = new LoginPage(getDriver());
        HomePage homePage = new HomePage(getDriver());

        loginPage.logIn();
        homePage.hoverPlay();
        homePage.clickPlayNextSong();
        homePage.clickPlayButton();
        //WebElement soundBars = driver.findElement(By.cssSelector("img[alt='Sound bars']"));
        Assert.assertTrue(homePage.isSongPlaying());


    }


}
