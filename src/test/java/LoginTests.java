import Pages.LoginPage;
import Pages.HomePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class LoginTests extends BaseTest {

    LoginPage loginPage = new LoginPage(driver);
    HomePage homePage = new HomePage(driver);
    @Test
    public void navigateToKoel() {

        //navigateToUrl();
        Assert.assertEquals(driver.getCurrentUrl(), url);
    }

    @Test
    public void loginValidEmailPassword() throws InterruptedException {

        //navigateToUrl();

        logInToKoelApp();

        WebElement avatarIcon = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("img[class='avatar']")));
        Assert.assertTrue(avatarIcon.isDisplayed());

    }
@Test
    public void loginWithInvalidEmailValidPassword() throws InterruptedException {

        //navigateToUrl();

    loginPage.provideEmail("bad@email.com");
    loginPage.providePassword("teststudent");
    loginPage.clickSubmit();

        Assert.assertEquals(driver.getCurrentUrl(), url);

        //driver.quit();
    }
    @Test
    public void loginWithValidEmailInvalidPassword() {

        //navigateToUrl();

        loginPage.provideEmail("camden.bertrand@testpro.io");
        loginPage.providePassword("teststudent");
        loginPage.clickSubmit();

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

    @Test
    public void loginWithCorrectCredentials(){

        loginPage.provideEmail("camden.bertrand@testpro.io");
        loginPage.providePassword("te$t$tudent");
        loginPage.clickSubmit();
        Assert.assertTrue(homePage.getUserAvatar().isDisplayed());
    }

}
