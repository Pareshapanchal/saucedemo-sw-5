package com.saucedemo.www.testsuite;

import com.saucedemo.www.customlisteners.CustomListeners;
import com.saucedemo.www.pages.LoginPage;
import com.saucedemo.www.testbase.BaseTest;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners(CustomListeners.class)
public class LoginTest extends BaseTest {
LoginPage loginPage;
@BeforeMethod(alwaysRun = true)
   public void inIt(){
    loginPage = new LoginPage();
}
@Test(groups = {"sanity","regression"})
//1. userSholdLoginSuccessfullyWithValidCredentials

public void userSholdLoginSuccessfullyWithValidCredentials() {
    // * Enter “standard_user” username// * Enter “secret_sauce” password    // * Click on ‘LOGIN’ button
    loginPage.loginToLoginPageWithValidCredential("standard_user","secret_sauce");
    // * Verify the text “PRODUCTS”
    String expectedProductsTitle ="Products";
    String actualProductsTitle = loginPage.getProductsTitle();
    Assert.assertEquals(actualProductsTitle,expectedProductsTitle,"Not Match");
}
    @Test(groups = {"smoke","regression"})
    // 2. verifyThatSixProductsAreDisplayedOnPage
    public void verifyThatSixProductsAreDisplayedOnPage() {
        // * Enter “standard_user” username// * Enter “secret_sauce” password// * Click on ‘LOGIN’ button
        loginPage.loginToLoginPageWithValidCredential("standard_user","secret_sauce");

    // * Verify that six products are displayed on page
        int expectedNumberOfProductsDisplayed = 6;
        int actualNumberOfProductsDisplayed = loginPage.getNumberOfProductsDisplayed();
        Assert.assertEquals(actualNumberOfProductsDisplayed,expectedNumberOfProductsDisplayed,"Not Match");
    }

}
