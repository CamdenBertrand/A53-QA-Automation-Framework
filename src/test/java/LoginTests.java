import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTests extends BaseTest {

    @Test
    public void navigateToKoel() {


        //navigateToUrl();
        Assert.assertEquals(driver.getCurrentUrl(), url);
    }

    @Test
    public void loginValidEmailPassword() throws InterruptedException {

        //navigateToUrl();

        provideEmail("demo@class.com");

        Thread.sleep(2000);

        providePassword("te$t$tudent");

        clickSubmit();

        WebElement avatarIcon = driver.findElement(By.cssSelector("img[class ='avatar']"));
        Assert.assertTrue(avatarIcon.isDisplayed());

    }
@Test (enabled = false)
    public void loginWithInvalidEmailValidPassword() throws InterruptedException {

        //navigateToUrl();

        provideEmail("bad@email.com");

        providePassword("te$t$tudent");

        clickSubmit();

        Thread.sleep(2000);
        Assert.assertEquals(driver.getCurrentUrl(), url);

        //driver.quit();
    }
    @Test (enabled = false)
    public void loginWithValidEmailInvalidPassword() throws InterruptedException {

        //navigateToUrl();

        provideEmail("demo@class.com");

        providePassword("badpassword");

        clickSubmit();

        Thread.sleep(2000);
        Assert.assertEquals(driver.getCurrentUrl(), url);

    }


}
