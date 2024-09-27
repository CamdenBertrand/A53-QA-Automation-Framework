import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
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
        providePassword("te$t$tudent");
        clickSubmit();

        WebElement avatarIcon = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("img[class='avatar']")));
        Assert.assertTrue(avatarIcon.isDisplayed());

    }
@Test (enabled = false)
    public void loginWithInvalidEmailValidPassword() throws InterruptedException {

        //navigateToUrl();

        provideEmail("bad@email.com");

        providePassword("te$t$tudent");

        clickSubmit();

        Assert.assertEquals(driver.getCurrentUrl(), url);

        //driver.quit();
    }
    @Test (enabled = false)
    public void loginWithValidEmailInvalidPassword() throws InterruptedException {

        //navigateToUrl();

        provideEmail("demo@class.com");

        providePassword("badpassword");

        clickSubmit();

        Assert.assertEquals(driver.getCurrentUrl(), url);

    }

    @Test (dataProvider = "IncorrectLoginData")
    public void loginEmptyEmailPassword(String email, String password) throws InterruptedException{
        provideEmail(email);
        providePassword(password);
        clickSubmit();

        Assert.assertEquals(driver.getCurrentUrl(), url);
    }

    @DataProvider(name="IncorrectLoginData")
    public static Object[][] getDataFromDataProviders(){
        return new Object[][] {
                {"invalid@mail.com","invalidPassword"},
                {"demo@class.com", ""},
                {"", ""}
        };
    }

}
