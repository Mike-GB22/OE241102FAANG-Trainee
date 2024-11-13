package task08junit;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class OrderTest {

    Order order;
    static List<Product> productsListThisForTest;

    @BeforeAll
    static void constructor(){
        productsListThisForTest = new ArrayList<>(
                Arrays.asList(ProductsForTests.product1
                        , ProductsForTests.product2
                        , ProductsForTests.product3));
    }

    @BeforeEach
    void setUp() {
        order = new Order(new ShoppingCart(productsListThisForTest));
    }

    @Test
    void getProducts() {
        assertEquals(productsListThisForTest.size(), order.getProducts().size());
        assertEquals(productsListThisForTest, order.getProducts());
    }

    @Test
    void getTotalPrice() {
        //Arrange
        double totalPriceExpected = 0.0;
        for (Product product : order.getProducts())
            totalPriceExpected += product.getPrice();

        //Assert
        assertEquals(totalPriceExpected, order.getTotalPrice());
    }

    private void preparingForDiscount_Positive(){
        if(order.getTotalPrice() < 1000)
            throw new RuntimeException("ќжидалось, что в корзине товара на 1000 руб и больше");
    }

    @Test
    void getDiscount_Positive() {
        //Arrange
        preparingForDiscount_Positive();
        double totalPrice = order.getTotalPrice();
        double discountExpected = totalPrice * 0.05;

        //Assert
        assertEquals(discountExpected, order.getDiscount());
    }

    private void preparingForDiscount_Negative(){
        order = new Order(
                new ShoppingCart(
                        Arrays.asList(ProductsForTests.productWithPriceLessAs1000Rub)));

        if(order.getTotalPrice() >= 1000)
            throw new RuntimeException("ќжидалось, что в корзине товара меньше чем на 1000 руб");
    }

    @Test
    void getDiscount_Negative() {
        //Arrange
        preparingForDiscount_Negative();
        double discountExpected = 0.0;

        //Assert
        assertEquals(discountExpected, order.getDiscount());
    }

    @Test
    void getFinalPrice_Positive() {
        //Arrange
        preparingForDiscount_Positive();
        double finalPriceExpected = order.getTotalPrice() - order.getDiscount();

        //Assert
        assertEquals(finalPriceExpected, order.getFinalPrice());
    }

    @Test
    void getFinalPrice_Negative() {
        //Arrange
        preparingForDiscount_Negative();

        //Assert
        assertEquals(order.getTotalPrice(), order.getFinalPrice());
    }

    @Test
    void emptyOrder(){
        //Arrange
        order = new Order(new ShoppingCart(new ArrayList<>()));

        //Assert
        assertEquals(0.0, order.getTotalPrice());
        assertEquals(0.0, order.getDiscount());
        assertEquals(0.0, order.getFinalPrice());
        assertEquals(0, order.getProducts().size());
    }
}