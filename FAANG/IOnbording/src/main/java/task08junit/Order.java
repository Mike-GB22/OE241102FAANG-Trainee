package task08junit;

import lombok.Data;
import lombok.Getter;

import java.util.List;


@Getter
public class Order {
    private List<Product> products;
    private double totalPrice;
    private double discount;
    private double finalPrice;

    public Order(ShoppingCart cart) {
        this.products = cart.getProducts();
        calculateTotalPrice();
        calculateDiscount();
        calculateFinalPrice();
    }

    private void calculateTotalPrice() {
        totalPrice = products.stream().mapToDouble(Product::getPrice).sum();
    }

    private void calculateDiscount() {
        // ������: ������ 5% ��� ����� ������ �� 1000 ������
        if (totalPrice >= 1000) {
            discount = totalPrice * 0.05;
        } else {
            discount = 0;
        }
    }

    private void calculateFinalPrice() {
        finalPrice = totalPrice - discount;
    }
}