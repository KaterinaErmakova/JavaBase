import java.util.*;

public class Shop {
    private String name;
    private double money; // денежный счет магазина
    private Map<Product, Integer> products = new HashMap<>(); // продукты и их количество
    //  количество может быть 0 !

    public Shop(String name, double money) {
        this.name = name;
        this.money = money;
    }

    public void sellProduct(Product product, Human human) throws SellProductException {
        if (products.get(product) == 0) {
            throw new SellProductException(SellExceptionReason.NO_COUNT);
        } else if (human.getMoney() < product.getPrice()) {
            throw new SellProductException(SellExceptionReason.NO_MONEY);
        } else {
            products.replace(product, products.get(product) - 1);
            money += product.getPrice() - calculateNds(product.getPrice());
            System.out.printf("%s, вы успешно совершили покупку! C уважением, %s", human.getFirstName(), name);
        }

    }

    public void addProduct(Product product, Integer count) {
        products.put(product, count);
    }

    private double calculateNds(double price) {
        return price * 0.13;
    }

    public List<Product> printAndGetAllProductsWithCount() {
        List<Product> list = new ArrayList<Product>(products.keySet());
        Collections.sort(list);
        for (int i = 0; i < list.size(); i++) {
            Product product = list.get(i);
            System.out.println(i + 1 + ". " + product.getProductName() + " - " + products.get(product) + " - " + product.getPrice());
        }
        return list;
    }
}
