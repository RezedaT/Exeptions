package ru.netology;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import ru.netoloqy.AlreadyExistsException;
import ru.netoloqy.NotFoundException;
import ru.netoloqy.Product;

public class ShopRepositoryTest {

    @Test
    public void shouldRemoveWhenProductExist() {
        ShopRepository repo = new ShopRepository();
        Product product1 = new Product(10, "книга1", 1_000);
        Product product2 = new Product(20, "книга2", 20_000);
        Product product3 = new Product(30, "книга3", 30_000_000);

        repo.add(product1);
        repo.add(product2);
        repo.add(product3);
        repo.removeById(20);

        Product[] actual = repo.findAll();
        Product[] expected = {product1, product3};
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldExceptionRemoveWhenProductNotExist() {
        ShopRepository repo = new ShopRepository();
        Product product1 = new Product(10, "книга1", 1_000);
        Product product2 = new Product(20, "книга2", 20_000);
        Product product3 = new Product(30, "книга3", 30_000_000);

        repo.add(product1);
        repo.add(product2);
        repo.add(product3);

        Assertions.assertThrows(NotFoundException.class, () -> repo.removeById(40)
        );
    }

    @Test
    public void shouldAddWhenProductNotExist() {
        ShopRepository repo = new ShopRepository();
        Product product1 = new Product(10, "книга1", 1_000);
        Product product2 = new Product(20, "книга2", 20_000);
        Product product3 = new Product(30, "книга3", 30_000_000);
        Product product4 = new Product(40, "книга4", 999);

        repo.add(product1);
        repo.add(product2);
        repo.add(product3);
        repo.add(product4);

        Product[] actual = repo.findAll();
        Product[] expected = {product1, product2, product3, product4};
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldExceptionAddWhenProductExist() {
        ShopRepository repo = new ShopRepository();
        Product product1 = new Product(10, "книга1", 1_000);
        Product product2 = new Product(20, "книга2", 20_000);
        Product product3 = new Product(30, "книга3", 30_000_000);

        repo.add(product1);
        repo.add(product2);
        repo.add(product3);

        Assertions.assertThrows(AlreadyExistsException.class, () -> repo.add(product1)
        );
    }
}