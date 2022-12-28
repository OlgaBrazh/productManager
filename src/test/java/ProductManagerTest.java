//package org.example.ProductManager.domain;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;


public class ProductManagerTest {

    ProductRepository repo = new ProductRepository();
    ProductManager manager = new ProductManager(repo);

    Product product1 = new Product(1, "Сумка Алые розы", 3000);
    Book book1 = new Book(2, "Алые паруса", 1200, "Грин");
    //Product product2 = new Product(2, "игрушка", 300);
    //Product product3 = new Product(3, "шампунь", 350);
    Smartphone smartphone1 = new Smartphone(3, "Galaxy", 15000, "Samsung");

    @Test
    public void shouldAdd() {

        manager.add(book1);

        Product[] expected = {book1};
        Product[] actual = repo.getProducts();

        Assertions.assertArrayEquals(expected, actual);


    }

    @Test
    public void shouldAllAdd() {

        manager.add(product1);

        manager.add(book1);

        manager.add(smartphone1);

        Product[] expected = {product1, book1, smartphone1};
        Product[] actual = repo.getProducts();

        Assertions.assertArrayEquals(expected, actual);


    }

    @Test
    public void shouldIdentifyAMatchIfYes() {
        manager.add(book1);
        manager.matches(book1, "Алые");

        Boolean expected = true;
        Boolean actual = manager.matches(book1, "Алые");
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void shouldIdentifyAMatchIfNo() {
        manager.add(book1);
        manager.matches(book1, "Сумка");

        Boolean expected = false;
        Boolean actual = manager.matches(book1, "Сумка");
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void shouldSearchIfYesInTwo() {
        manager.add(product1);
        manager.add(book1);
        manager.add(smartphone1);

        manager.searchBy("Сумка");

        Product[] expected = {product1, book1};
        Product[] actual = manager.searchBy("Алые");
    }

    @Test
    public void shouldSearchIfYesInOne() {
        manager.add(product1);
        manager.add(book1);
        manager.add(smartphone1);

        manager.searchBy("Сумка");

        Product[] expected = {product1};
        Product[] actual = manager.searchBy("Сумка");
    }

    @Test
    public void shouldSearchIfNo() {
        manager.add(product1);
        manager.add(book1);
        manager.add(smartphone1);

        manager.searchBy("Карандаш");

        Product[] expected = {};
        Product[] actual = manager.searchBy("Карандаш");
    }
}
