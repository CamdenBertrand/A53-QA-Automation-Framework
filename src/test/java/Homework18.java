import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Homework18 extends BaseTest{
    @Test
    public void playSong() throws InterruptedException {
        navigateToUrl();
        provideEmail("camden.bertrand@testpro.io");
        Thread.sleep(2000);
        providePassword("te$t$tudent");
        Thread.sleep(2000);
        clickSubmit();
        Thread.sleep(2000);
        clickPlayNextSong();
        Thread.sleep(2000);
        clickPlayButton();
        Thread.sleep(4000);
        WebElement soundBars = driver.findElement(By.cssSelector("img[alt='Sound bars']"));
        Assert.assertTrue(soundBars.isDisplayed());


    }

    private void clickPlayButton() {
        WebElement playButton = driver.findElement(By.cssSelector("span[data-testid='play-btn']"));
        playButton.click();
    }

    public void clickPlayNextSong() {
        WebElement nextSongBtn = driver.findElement(By.cssSelector("i[data-testid='play-next-btn']"));
        nextSongBtn.click();
    }


}
