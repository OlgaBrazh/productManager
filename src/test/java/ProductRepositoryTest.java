
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;


import static org.junit.jupiter.api.Assertions.assertArrayEquals;

public class ProductRepositoryTest {

    Product product1 = new Product(1, "Сумка", 3000);
    Book book1 = new Book(2, "Алые паруса", 1200, "Грин");
    //Product product2 = new Product (2, "игрушка", 300);
    //Product product3 = new Product (3, "шампунь", 350);
    Book book2 = new Book (2, "Идиот", 1000, "Достоевский");
    Smartphone smartphone1 = new Smartphone(3, "Galaxy", 15000, "Samsung");


    @Test
    public void shouldSetId() {
        Product product = new Product(100, "ключ", 100);
        product.setId(10);
        System.out.println(product.id);
    }

    @Test
    public void shouldSetName() {
        Product product = new Product(100, "ключ", 100);
        product.setName("Тетрадь");
        System.out.println(product.name);
    }

    @Test
    public void shouldSetPrice() {
        Product product = new Product(100, "ключ", 100);
        product.setPrice(50);
        System.out.println(product.price);
    }

    @Test
    public void shouldGetPrice() {
        Product product = new Product(100, "ключ", 100);
        //return product.getPrice();
        Assertions.assertEquals(100, product.getPrice());

    }


    @Test
    public void shouldSaveProductIfIdNotExists() {
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
    public void shouldSaveProductIfIdAlreadyExists() {
        ProductRepository repo = new ProductRepository();
        repo.save(product1);
        repo.save(book1);
        repo.save(smartphone1);

        //repo.save(product3);

        Assertions.assertThrows(AlreadyExistsException.class, () -> {
            repo.save(book2);
        });
    }



    @Test
    public void shouldFindById() {
        ProductRepository repo = new ProductRepository();
        repo.save(product1);
        repo.save(book1);
        repo.save(smartphone1);

        repo.findById(2);

        Product expected = book1;
        Product actual = repo.findById(2);
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void shouldRemoveByLegalId() {
        ProductRepository repo = new ProductRepository();
        repo.save(product1);
        repo.save(book1);
        repo.save(smartphone1);

        repo.removeById(2);

        Product[] expected = {product1, smartphone1};
        Product[] actual = repo.getProducts();
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldThrowsMessageRemoveByNotFoundId() {
        ProductRepository repo = new ProductRepository();
        repo.save(product1);
        repo.save(book1);
        repo.save(smartphone1);

        Assertions.assertThrows(NotFoundException.class, () -> {
            repo.removeById(7);
        });
    }
}
