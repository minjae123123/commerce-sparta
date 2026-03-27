public class Product {
    private String name;
    private int price;
    private String explanation;
    private int stock_quantity;

    public Product(String name, int price, String explanation, int stock_quantity) {
        this.name = name;
        this.price = price;
        this.explanation = explanation;
        this.stock_quantity = stock_quantity;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getExplanation() {
        return explanation;
    }

    public void setExplanation(String explanation) {
        this.explanation = explanation;
    }

    public int getStock_quantity() {
        return stock_quantity;
    }

    public void setStock_quantity(int stock_quantity) {
        this.stock_quantity = stock_quantity;
    }
}
