import entities.User;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.*;

import javax.annotation.Nullable;

import static java.lang.Thread.sleep;

public class TestMethods extends BaseTest {
    Homepage homepage ;
    ProductsPage productsPage;
    ProductDetailPage productDetailPage;
    CartPage cartPage;
    String email="testselenium1016@gmail.com";
    String password="Test.1016";
    @Test
    @Order(1)
    public void login() {
        Log4j.info("Go to login page");
        Homepage homepage = new Homepage(driver);
        LoginPage loginPage = homepage.getLoginPage();
        Log4j.info("email address : " + email+" ,password : "+password);
        User user = new User(email,password);
        loginPage.login(user);
        Assertions.assertTrue(homepage.isOnHomePage(),"Login failed.");
        Log4j.info("LOGGED!");
    }
    @Test
    @Order(2)
    public void search_Product(){
        homepage = new Homepage(driver);
        productsPage= new ProductsPage(driver);
        ProductsPage productsPage= homepage.search("bilgisayar");
        Log4j.info("bilgisayar keyword entered");
        delay = new WebDriverWait(driver, 3);
        productsPage.scrollToPage("7200");
        productsPage.choosePage("2");
        delay = new WebDriverWait(driver, 3);
        Assertions.assertTrue(driver.getCurrentUrl().contains("2"),
                "page 2 could not be opened");
        Log4j.info("2nd page opened.");

    }
    @Test
    @Order(3)
    public void click_Product(){
        productsPage= new ProductsPage(driver);
        productsPage.selectProduct();
        Log4j.info("Product selected.");

    }
    @Test
    @Order(4)
    public void add_Product_To_Cart() throws InterruptedException {
        productDetailPage = new ProductDetailPage(driver);
        productsPage = new ProductsPage(driver);
        productsPage.scrollToPage("700");
        productDetailPage.addToCart();
        Log4j.info("product added to cart");

        delay = new WebDriverWait(driver, 3);

       CartPage cartPage= productDetailPage.goToCart();
       Assertions.assertEquals(productDetailPage.productPrice(),cartPage.priceInCart());
        Log4j.info("cart opened");
    }
    @Test
    @Order(5)
    public void set_Product_CountUp(){

        cartPage = new CartPage(driver);
        cartPage.setNumberOfProduct();
        delay = new WebDriverWait(driver, 3);
        Assertions.assertTrue(cartPage.getNumberProduct().contains("2"),"stock is not enough");
        Log4j.info("2 product added");
    }
    @Test
    @Order(6)
    public void empty_Cart_Check(){
        cartPage = new CartPage(driver);
        cartPage.deleteProduct();
        delay = new WebDriverWait(driver, 3);
        Assertions.assertEquals("0",cartPage.isEmpty());

    }
}
