import Pages.HomePage;
import Pages.LoginPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LogoutTest extends BaseTest{
    @Test
    public void logOut(){
        LoginPage loginPage = new LoginPage(getDriver());
        HomePage homePage = new HomePage(getDriver());

        loginPage.logIn();
        Assert.assertTrue(homePage.getUserAvatar().isDisplayed());
        homePage.clickLogOut();
        Assert.assertTrue(homePage.getLoginImage().isDisplayed());

    }

}
