//2024.11.13

package task08junit;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ProductTest {

    Product product1;
    final String NAME_OF_PRODUCT = "Posudomoika";
    final String NEW_NAME_OF_PRODUCT = "Posudomika ABC-1000";
    final double PRICE_OF_PRODUCT = 10_000d;
    final double NEW_PRICE_OF_PRODUCT = 11_111d;

    @BeforeEach
    void setUp() {
        product1 = new Product(NAME_OF_PRODUCT, PRICE_OF_PRODUCT);
    }

    @Test
    void getName() {
        assertEquals(NAME_OF_PRODUCT, product1.getName());
    }

    @Test
    void getPrice() {
        assertEquals(PRICE_OF_PRODUCT, product1.getPrice());
    }

    @Test
    void setName() {
        //ARRANGE
        //ACT
        product1.setName(NEW_NAME_OF_PRODUCT);
        //ASSERT
        assertEquals(NEW_NAME_OF_PRODUCT, product1.getName());
    }

    @Test
    void setPrice() {
        //ARRANGE
        //ACT
        product1.setPrice(NEW_PRICE_OF_PRODUCT);
        //ASSERT
        assertEquals(NEW_PRICE_OF_PRODUCT, product1.getPrice());
    }

    @Test
    void testEquals_Positive() {
        //ARRANGE
        Product product2 = new Product(NAME_OF_PRODUCT, PRICE_OF_PRODUCT);

        //ASSERT
        assertTrue(product1.equals(product2));
    }

    @Test
    void testEquals_Negative() {
        //ARRANGE
        Product product2 = new Product(NEW_NAME_OF_PRODUCT, NEW_PRICE_OF_PRODUCT);

        //ASSERT
        assertFalse(product1.equals(product2));
    }

}