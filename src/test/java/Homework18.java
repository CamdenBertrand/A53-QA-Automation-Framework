import Pages.LoginPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Homework18 extends BaseTest{
    @Test
    public void playSong() throws InterruptedException {
        LoginPage loginPage = new LoginPage(driver);

        loginPage.logIn();
        clickPlayNextSong();
        clickPlayButton();
        //WebElement soundBars = driver.findElement(By.cssSelector("img[alt='Sound bars']"));
        WebElement soundBars = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("img[alt='Sound bars']")));
        Assert.assertTrue(soundBars.isDisplayed());


    }

    private void clickPlayButton() {
        //WebElement playButton = driver.findElement(By.cssSelector("span[data-testid='play-btn']"));
        WebElement playButton = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("span[data-testid='play-btn']")));
        playButton.click();
    }

    public void clickPlayNextSong() {
        //WebElement nextSongBtn = driver.findElement(By.cssSelector("i[data-testid='play-next-btn']"));
        WebElement nextSongBtn = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("i[data-testid='play-next-btn']")));
        nextSongBtn.click();
    }


}
