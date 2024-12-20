package _02_Encapsulation.exercise._03_ShoppingSpree;

import java.util.ArrayList;
import java.util.List;

public class Person {
    private String name;
    private double money;
    private List<Product> products;


    public Person(String name, double money) {
        setName(name);
        setMoney(money);
        this.products = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    private void setName(String name) {
        if (name.trim().isEmpty()){
            throw new IllegalArgumentException("Name cannot be empty");
        } else {
            this.name = name;
        }
    }

    public double getMoney() {
        return money;
    }

    private void setMoney(double money) {
        if (money < 0){
            throw new IllegalArgumentException("Money cannot be negative");
        } else {
            this.money = money;
        }
    }

    public List<Product> getProducts() {
        return products;
    }

    public void buyProduct(Product product){
        if (this.money >= product.getCost()){
            this.products.add(product);
            this.money -= product.getCost();
        } else {
            throw new IllegalArgumentException(String.format("%s can't afford %s",
                    getName(), product.getName()));

        }
    }


}
