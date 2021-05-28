package pages;

import entities.User;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import javax.annotation.Nullable;

public class LoginPage extends  BasePage{

    By userNameFieldBy =By.id("L-UserNameField");
    By passwordFieldBy =By.id("L-PasswordField");
    By loginButtonBy =By.id("gg-login-enter");
    public LoginPage(WebDriver webDriver) {
        super(webDriver);
    }

    public Homepage login(User user){

        sendKeys(userNameFieldBy,user.getEmail());
        sendKeys(passwordFieldBy,user.getPassword());
        click(loginButtonBy,2);
        Homepage homepage = new Homepage(webDriver);
        homepage.waitForLoad();
        return homepage;
    }
}
