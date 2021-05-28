package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Homepage extends BasePage{
    By locatorbar = By.className("sc-1o6eogh-0");
    By slider = By.className("GG_hero-slider-pagination swiper-pagination-clickable swiper-pagination-bullets");

    public Homepage(WebDriver webDriver) {
        super(webDriver);
    }

    public boolean isOnHomePage(){
        return isDisplayed(slider);
    }

    public void waitForLoad() {
        WebDriverWait wait = new WebDriverWait(webDriver,10);
        wait.until(ExpectedConditions.urlToBe("https://www.gittigidiyor.com/"));
    }

}
