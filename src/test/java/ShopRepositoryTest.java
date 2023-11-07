import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class ShopRepositoryTest {
    @Test
    public void testRemovingOneProduct() {
        ShopRepository repo = new ShopRepository();
        Product product1 = new Product(67, "21 роза", 4_200);
        Product product2 = new Product(3, "5 лилий", 2_400);
        Product product3 = new Product(123, "55 ромашек", 4_895);

        repo.add(product1);
        repo.add(product2);
        repo.add(product3);
        repo.remove(3);
        Product[] actual = repo.findAll();
        Product[] expected = {product1, product3};

        Assertions.assertArrayEquals(expected, actual);

    }

    @Test
    public void testNoRemovingProduct() {
        ShopRepository repo = new ShopRepository();
        Product product1 = new Product(67, "21 роза", 4_200);
        Product product2 = new Product(3, "5 лилий", 2_400);
        Product product3 = new Product(123, "55 ромашек", 4_895);

        repo.add(product1);
        repo.add(product2);
        repo.add(product3);


        Assertions.assertThrows(NotFoundException.class,
                () -> repo.remove(1000000)
        );

    }
}