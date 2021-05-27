import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class TestMethods extends BaseTest {

    Homepage homepage ;
    ProductsPage productsPage;
    ProductDetailPage productDetailPage;
    CartPage cartPage;

    @Test
    public void search_Product(){
        homepage.search("bilgisayar");
    }
    @Test
    public void go_To_Page(){
        productsPage.choosePage("2");
        Assertions.assertTrue(homepage.webDriver.getCurrentUrl().contains("2"),"page 2 could not be opened.");
    }
    @Test
    public void click_Product(){
        productsPage.selectProduct();
    }
    @Test
    public void add_Product_To_Cart(){
        productDetailPage.addToCart();
    }
    @Test
    public void go_To_Cart(){
        productDetailPage.goToCart();
    }

    @Test
    public boolean compare_Product_Price(){
        return cartPage.priceInCart()==productDetailPage.getPriceInDetailPage();

    }

    @Test
    public void setProductCountUp(){

        cartPage.setNumberOfProduct();
    }
    @Test
    public void deleteProductInCart(){
        cartPage.deleteProduct();
    }
    @Test
    public void isCartEmpty(){
        cartPage.isEmpty();
    }
}
