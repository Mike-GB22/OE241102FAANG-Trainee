package task08junit;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ShoppingCartTest {

    ShoppingCart cart;
    static List<Product> productsListThisForTest;

    @BeforeAll
    static void constructor(){
        productsListThisForTest = new ArrayList<>(
                Arrays.asList(ProductsForTests.product1
                        , ProductsForTests.product2
                        , ProductsForTests.product3));
    }

    @BeforeEach
    void setUp(){
        cart = new ShoppingCart(productsListThisForTest);
    }

    @Test
    void addProduct() {
        //Arrange
        int countOfItemsWas = cart.getCountOfItems();
        double priceWas = cart.getTotalPrice();

        Product productForAdd = ProductsForTests.productForAdd;
        int countOfItemsExpected = countOfItemsWas + 1;
        double priceExpected = priceWas + productForAdd.getPrice();

        //Act
        cart.addProduct(productForAdd);

        //Assert
        assertEquals(countOfItemsExpected, cart.getCountOfItems());
        assertEquals(priceExpected, cart.getTotalPrice());
    }

    @Test
    void removeProduct() {
        //Arrange
        int countOfItemsWas = cart.getCountOfItems();
        double priceWas = cart.getTotalPrice();

        Product productForDelete = cart.getProducts().get(0);
        int countOfItemsExpected = countOfItemsWas - 1;
        double priceExpectd = priceWas - productForDelete.getPrice();

        //Act
        cart.removeProduct(productForDelete);

        //Assert
        assertEquals(countOfItemsExpected, cart.getCountOfItems());
        assertEquals(priceExpectd, cart.getTotalPrice());
    }

    @Test
    void getProducts() {
        //Arrange
        List<Product> products = cart.getProducts();

        //Assert
        assertEquals(productsListThisForTest.size(), products.size());
        assertTrue(products.equals(productsListThisForTest));
    }

    @Test
    void getTotalPrice() {
        //Arrange
        List<Product> products = cart.getProducts();
        double totalPriceExpected = 0.0;
        for (Product product : products)
            totalPriceExpected += product.getPrice();

        //Assert
        assertEquals(totalPriceExpected, cart.getTotalPrice());
    }

    @Test
    void getCountOfItems() {
        //Arrange
        List<Product> products = cart.getProducts();

        //Assert
        assertEquals(products.size(), cart.getCountOfItems());
    }
}