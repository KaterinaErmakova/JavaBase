import java.util.HashSet;
import java.util.Set;

public class Human implements Buyer {

    private String firstName;
    private String lastName;
    private double money; // денежный счет человека
    private Set<Product> products = new HashSet<>(); // купленные продукты

    public Human(String firstName, String lastName, double money) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.money = money;
    }

    public void buyProduct(Product product, Shop shop) {
        try {
            shop.sellProduct(product, this);
            products.add(product);
            money -= product.getPrice();
        }
        catch (SellProductException e) {
            switch (e.getReason())
            {
                case NO_MONEY -> {
                    System.out.printf("Уважаемый %s %s, для покупки товара недостаточно средств\n", firstName, lastName);
                }
                case NO_COUNT -> {
                    System.out.printf("Продукта с именем %s нет в наличии\n", product.getProductName());
                }
            }
        }

    }
    public double getMoney() {
        return money;
    }
    public String getFirstName() {
        return firstName;
    }
    public String getLastName() {
        return lastName;
    }


}
