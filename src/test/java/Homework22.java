import Pages.HomePage;
import Pages.LoginPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Homework22 extends BaseTest{

    LoginPage loginPage = new LoginPage(driver);

    @Test
    public void loginWithValidEmailInvalidPassword() {

        //navigateToUrl();

        loginPage.provideEmail("camden.bertrand@testpro.io");
        loginPage.providePassword("teststudent");
        loginPage.clickSubmit();

        Assert.assertEquals(driver.getCurrentUrl(), url);

    }
}
