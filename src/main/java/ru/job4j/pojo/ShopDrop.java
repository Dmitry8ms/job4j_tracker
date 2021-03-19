package ru.job4j.pojo;

public class ShopDrop {

    public static Product[] leftShift(Product[] products, int index) {
        products[index] = null;
        for (int i = index; i < products.length - 1; i++) {
            products[i] = products[i + 1];
            products[i + 1] = null;
        }
        return products;
    }

    public static void main(String[] args) {
        Product[] products = new Product[5];
        products[0] = null;
        products[1] = new Product("Milk", 10);
        products[2] = new Product("Egg", 19);
        for (Product product : products) {
            if (product != null) {
                System.out.println(product.getName());
            } else {
                System.out.println("null");
            }
        }
        leftShift(products, Shop.indexOfNull(products));
        for (Product product : products) {
            if (product != null) {
                System.out.println(product.getName());
            } else {
                System.out.println("null");
            }
        }
    }
}
