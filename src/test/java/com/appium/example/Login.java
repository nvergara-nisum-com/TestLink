package com.appium.example;

import bean.User;
import io.appium.java_client.MobileElement;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Login extends BaseAppium {

    public void login(User user) {
        WebDriverWait wait = new WebDriverWait(driver, 60);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("https://www.linkedin.com:id/login-submit")));

        MobileElement userElement = (MobileElement) driver.findElementById("https://www.linkedin.com:id/login-email");
        userElement.sendKeys(user.getUser());
        MobileElement passwordElement = (MobileElement) driver.findElementById("https://www.linkedin.com:id/login-password");
        passwordElement.sendKeys(user.getPassword());
        MobileElement buttonLogin = (MobileElement) driver.findElementById("https://www.linkedin.com:id/login-submit");
        buttonLogin.click();
    }
}
