import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BaseTest {

    WebDriverWait delay;
    WebDriver driver;
    @BeforeAll
    public void setup(){
        WebDriverManager.firefoxdriver().setup();
        driver.get("https://www.gittigidiyor.com/");
        delay = new WebDriverWait(driver, 10);
    }

    @AfterAll
    public void tearDown(){
        driver.quit();
    }

    public void setById(String id,String text){
        driver.findElement(By.id(id)).clear();
        driver.findElement(By.id(id)).sendKeys(text);
    }
    public void clickById(String id){
        driver.findElement(By.id(id)).click();
    }
    public void getPath(String path){
        driver.get(path);
    }
}
