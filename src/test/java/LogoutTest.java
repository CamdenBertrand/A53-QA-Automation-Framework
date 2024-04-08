import Pages.HomePage;
import Pages.LoginPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LogoutTest extends BaseTest{
    @Test
    public void logOut(){
        LoginPage loginPage = new LoginPage(driver);
        HomePage homePage = new HomePage(driver);

        loginPage.logIn();
        Assert.assertTrue(homePage.getUserAvatar().isDisplayed());
        homePage.clickLogOut();
        Assert.assertTrue(homePage.getLoginImage().isDisplayed());

    }

}
