import java.util.List;
import java.util.Scanner;

public class ConsoleService {
    private Shop shop;
    private Human human;

    public void start() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Задайте имя и стартовый капитал магазина");
        shop = new Shop(scanner.next(), scanner.nextDouble());
        System.out.println("Укажите количество товаров");
        int count = scanner.nextInt();
        for (int i = 0; i < count; i++) {
            System.out.println("Заполните в формате: название товара, его стоимость и количество в наличии\n" +
                    "       К примеру - Пылесос 6000.00 3");
            Product product = new Product(scanner.next(), scanner.nextDouble());
            shop.addProduct(product, scanner.nextInt());
        }
        System.out.println("Заполни данные о человеке - имя, фамилия,\n" +
                "       и количество денежных средств\n" +
                "       К примеру - Иван Иванов 200000.00");
        human = new Human(scanner.next(), scanner.next(), scanner.nextDouble());
        System.out.println("1. Посмотреть список товаров\n" +
        "2. Выход");
        try {
            if (scanner.nextInt() == 1) {
                List<Product> productList = shop.printAndGetAllProductsWithCount();
                Product product = productList.get(scanner.nextInt() - 1);
                human.buyProduct(product, shop);
            }
        }
        catch (Exception e) {
        }
    }
}
