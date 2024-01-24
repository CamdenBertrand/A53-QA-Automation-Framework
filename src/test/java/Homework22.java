import Pages.HomePage;
import Pages.LoginPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Homework22 extends BaseTest{



    @Test
    public void loginWithValidEmailInvalidPassword() {

        LoginPage loginPage = new LoginPage(driver);

        loginPage.provideEmail("camden.bertrand@testpro.io");
        loginPage.providePassword("teststudent");
        loginPage.clickSubmit();

        Assert.assertEquals(driver.getCurrentUrl(), url);

    }
}
