package task08junit;

import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;


@Getter
public class ShoppingCart {
    private List<Product> products;
    private double totalPrice;

    public ShoppingCart() {
        this.products = new ArrayList<>();
        this.totalPrice = 0.0;
    }

    public ShoppingCart(List<Product> products){
        this.products = new ArrayList<>(products);
        recalcTotalPrice();
    }

    public void addProduct(Product product) {
        products.add(product);
        totalPrice += product.getPrice();
    }

    public void removeProduct(Product product) {
        products.remove(product);
        //totalPrice -= product.getPrice();
        recalcTotalPrice();
    }

    private void recalcTotalPrice(){
        double newTotalPrice = 0.0;
        for (Product product : products){
            newTotalPrice += product.getPrice();
        }
        totalPrice = newTotalPrice;
    }

    public int getCountOfItems(){
        return products.size();
    }
}