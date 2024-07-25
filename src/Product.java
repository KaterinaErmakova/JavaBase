public class Product implements Comparable<Product> {
        private String productName;
        private double price;
    public Product(String productName, double price) {
        this.productName = productName;
        this.price = price;
    }
    @Override
    public int compareTo(Product o) {
            return (int) Math.signum(this.price - o.price);
    }
    public double getPrice() {
        return price;
    }

    public String getProductName() {
        return productName;
    }
}
