import java.util.List;

public class Category {

    List<Product> products;

    public Category(List<Product> products) {
        this.products = products;
    }

    public List<Product> getProducts() {
        return products;
    }

    public void electronics() {
        System.out.println("[전자제품 카테고리]");
        printByCategory("전자제품");
    }

    public void clothes() {
        System.out.println("[의류 카테고리]");
        printByCategory("의류");
    }

    public void food() {
        System.out.println("[식품 카테고리]");
        printByCategory("식품");
    }

    private void printByCategory(String categoryName) {
        int number = 1;

        for (Product p : products) {
            if (p.getCategory().equals(categoryName)) {
                System.out.println(number + ". " + p.getName() + " | " + p.getPrice() + " | " + p.getExplanation() + " | 재고: " + p.getStock_quantity());
                number++;
            }
        }

        System.out.println("0. 뒤로가기");
    }
}