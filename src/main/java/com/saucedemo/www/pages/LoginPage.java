package com.saucedemo.www.pages;

import com.aventstack.extentreports.Status;
import com.saucedemo.www.customlisteners.CustomListeners;
import com.saucedemo.www.utilities.Utility;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.testng.Reporter;

import java.util.List;

public class LoginPage extends Utility {
@CacheLookup
@FindBy(xpath ="//input[@id='user-name']")
 WebElement username;
@CacheLookup
 @FindBy(xpath = "//input[@id='password']")
 WebElement password;
 @CacheLookup
 @FindBy(xpath = "//input[@id ='login-button']")
 WebElement loginButton;
 @CacheLookup
 @FindBy(xpath = "//span[@class='title']")
 WebElement productsTitle;
 @CacheLookup
 @FindBy(xpath = "//div[@class='inventory_item']")
 List<WebElement> numberOfProducts;
 public void loginToLoginPageWithValidCredential(String username,String password){
  enterUserName(username);
  enterPassword(password);
  clickOnLoginButton();
 }
 public void enterUserName(String text){
  Reporter.log("Enter UserName" );
  CustomListeners.test.log(Status.PASS,"Enter UserName");
  sendTextToElement(username,text);
 }
 public void enterPassword(String text){
  Reporter.log("Enter Password" );
  CustomListeners.test.log(Status.PASS,"Enter Password");
  sendTextToElement(password,text);
 }
 public void clickOnLoginButton(){
  Reporter.log("Click On LoginButton" );
  CustomListeners.test.log(Status.PASS,"Click On LonginButton");
  clickOnElement(loginButton);
 }
 public String getProductsTitle(){
  Reporter.log("Get Products Title" );
  CustomListeners.test.log(Status.PASS,"Get Products Title");
  return getTextFromElement(productsTitle);
 }
 public int getNumberOfProductsDisplayed(){
  Reporter.log("Get Number of product displayed" );
  CustomListeners.test.log(Status.PASS,"Get number of product displayed");
  return getTheNumberOfElementOnTheList( numberOfProducts);
 }



}
