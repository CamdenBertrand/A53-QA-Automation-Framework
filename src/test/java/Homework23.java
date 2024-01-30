import Pages.HomePage;
import Pages.LoginPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Homework23 extends BaseTest{
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
