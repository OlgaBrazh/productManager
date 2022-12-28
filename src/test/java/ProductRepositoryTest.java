
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;


import static org.junit.jupiter.api.Assertions.assertArrayEquals;

public class ProductRepositoryTest {

    Product product1 = new Product(1, "Сумка", 3000);
    Book book1 = new Book(2, "Алые паруса", 1200, "Грин");
    //Product product2 = new Product (2, "игрушка", 300);
    //Product product3 = new Product (3, "шампунь", 350);
    Smartphone smartphone1 = new Smartphone(3, "Galaxy", 15000, "Samsung");

    @Test
    public void shouldSaveProduct() {
        ProductRepository repo = new ProductRepository();
        repo.save(product1);
        repo.save(book1);
        repo.save(smartphone1);
        //repo.save(product2);
        //repo.save(product3);

        Product[] expected = {product1, book1, smartphone1};
        Product[] actual = repo.getProducts();

        Assertions.assertArrayEquals(expected, actual);

    }

    @Test
    public void shouldRemoveById() {
        ProductRepository repo = new ProductRepository();
        repo.save(product1);
        repo.save(book1);
        repo.save(smartphone1);

        repo.removeById(2);

        Product[] expected = {product1, smartphone1};
        Product[] actual = repo.getProducts();
    }


}
