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


    @Test
    public void navigateToKoel() {

        //navigateToUrl();
        Assert.assertEquals(driver.getCurrentUrl(), url);
    }

    @Test
    public void loginValidEmailPassword() throws InterruptedException {
        LoginPage loginPage = new LoginPage(driver);
        HomePage homePage = new HomePage(driver);

        //navigateToUrl();

        loginPage.logIn();

        Assert.assertTrue(homePage.getUserAvatar().isDisplayed());

    }
@Test
    public void loginWithInvalidEmailValidPassword() throws InterruptedException {

    LoginPage loginPage = new LoginPage(driver);


    loginPage.provideEmail("bad@email.com");
    loginPage.providePassword("teststudent");
    loginPage.clickSubmit();

        Assert.assertEquals(driver.getCurrentUrl(), url);

        //driver.quit();
    }
    @Test
    public void loginWithValidEmailInvalidPassword() {

        LoginPage loginPage = new LoginPage(driver);


        loginPage.provideEmail("camden.bertrand@testpro.io");
        loginPage.providePassword("teststudent");
        loginPage.clickSubmit();

        Assert.assertEquals(driver.getCurrentUrl(), url);

    }

    @Test (dataProvider = "IncorrectLoginData")
    public void loginEmptyEmailPassword(String email, String password) throws InterruptedException{
        LoginPage loginPage = new LoginPage(driver);
        loginPage.provideEmail(email);
        loginPage.providePassword(password);
        loginPage.clickSubmitBtnToLogin();

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
        LoginPage loginPage = new LoginPage(driver);
        HomePage homePage = new HomePage(driver);

        loginPage.provideEmail("camden.bertrand@testpro.io");
        loginPage.providePassword("te$t$tudent");
        loginPage.clickSubmit();
        Assert.assertTrue(homePage.getUserAvatar().isDisplayed());
    }
    /**
     * login with page factory and fluent interface.
     */
    @Test
    public void loginWithCorrectCredentialsUsingPageFactory(){
        LoginPage loginPage = new LoginPage(driver);
        HomePage homePage = new HomePage(driver);
        //steps
        loginPage.provideEmailToLogin("camden.bertrand@testpro.io")
                .providePasswordToLogin("te$t$tudent")
                .clickSubmitBtnToLogin();
        //assertion
        Assert.assertTrue(homePage.getUserAvatar().isDisplayed());
    }

}

