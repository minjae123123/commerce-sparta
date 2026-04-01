public class Product {
    private String category;
    private String name;
    private int price;
    private String explanation;
    private int stock_quantity;

    public Product(String category, String name, int price, String explanation, int stock_quantity) {
        this.category = category;
        this.name = name;
        this.price = price;
        this.explanation = explanation;
        this.stock_quantity = stock_quantity;
    }

    public String getCategory() {
        return category;
    }

    public String getName() {
        return name;
    }

    public int getPrice() {
        return price;
    }

    public String getExplanation() {
        return explanation;
    }

    public int getStock_quantity() {
        return stock_quantity;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public void setStock_quantity(int stock_quantity) {
        this.stock_quantity = stock_quantity;
    }

    public void setExplanation(String explanation) {
        this.explanation = explanation;
    }
}
