import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Homework17 extends BaseTest{
    @Test
    public void addSongToPlaylist() throws InterruptedException {
        navigateToUrl();

        provideEmail("camden.bertrand@testpro.io");
        providePassword("te$t$tudent");
        clickSubmit();

        Thread.sleep(2000);

        searchSong("Dark");

        Thread.sleep(2000);

        clickViewAllButton();

        Thread.sleep(4000);

        clickFirstSong();

        Thread.sleep(2000);

        clickAddToButton();

        Thread.sleep(4000);

        clickPlaylist();

        Thread.sleep(4000);

        WebElement songMessage = driver.findElement(By.xpath("/html/body/div[2]/div[contains(text(),'Added 1 song into \"Automation playlist.\"')]"));

        Assert.assertEquals(songMessage.getText(), "Added 1 song into \"Automation playlist.\"");



    }


    public void searchSong(String title){
        WebElement searchBar = driver.findElement(By.cssSelector("input[name='q']"));
        searchBar.clear();
        searchBar.sendKeys(title);
    }

    public void clickViewAllButton(){
        WebElement viewAllButton = driver.findElement(By.cssSelector("button[data-test='view-all-songs-btn']"));
        viewAllButton.click();
    }
    public void clickFirstSong() {
        WebElement firstSongResult = driver.findElement(By.cssSelector("#songResultsWrapper>div>div>div.item-container>table>tr:nth-child(1)>td.title"));
        firstSongResult.click();
    }

    public void clickAddToButton(){
        WebElement addToButton = driver.findElement(By.cssSelector("button.btn-add-to"));
        addToButton.click();
    }

    public void clickPlaylist(){
        WebElement selectedPlaylist = driver.findElement(By.cssSelector("#songResultsWrapper>header>div.song-list-controls>div>section.existing-playlists>ul>li:nth-child(5)"));
        selectedPlaylist.click();
    }

}
