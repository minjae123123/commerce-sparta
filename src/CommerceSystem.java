import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CommerceSystem {
    List<Product> products = new ArrayList<>();
    List<Product> carts = new ArrayList<>();
    Scanner scanner = new Scanner(System.in);

    public CommerceSystem() {
        products.add(new Product("전자제품", "Galaxy S24", 1200000, "최신 안드로이드 스마트폰", 15));
        products.add(new Product("전자제품", "iPhone 15", 1350000, "Apple의 최신 스마트폰", 5));
        products.add(new Product("전자제품", "MacBook Pro", 2400000, "M3 칩셋이 탑재된 노트북", 10));
        products.add(new Product("전자제품", "AirPods Pro", 350000, "노이즈 캔슬링 무선 이어폰", 30));

        products.add(new Product("의류", "하얀색 셔츠", 40000, "깔끔한 느낌의 셔츠", 200));
        products.add(new Product("의류", "검정 슬랙스", 60000, "보들보들한 재질의 슬랙스", 150));
        products.add(new Product("의류", "연청바지", 65000, "고급 원단을 사용한 청바지", 240));
        products.add(new Product("의류", "회색 후드티", 53000, "착용감이 편안한 후드티", 50));

        products.add(new Product("식품", "계란", 5000, "30판 들어있습니다", 20));
        products.add(new Product("식품", "두부", 3500, "찌개용입니다", 15));
        products.add(new Product("식품", "고추", 2800, "청양고추입니다", 40));
        products.add(new Product("식품", "콩나물", 3000, "싱싱합니다", 35));
    }

    public void start() {
        Category category = new Category(products);
        int sum = 0;

        while (true) {
            System.out.println("[실시간 커머스 플랫폼 메인]");
            System.out.println("1. 전자제품");
            System.out.println("2. 의류");
            System.out.println("3. 식품");
            System.out.println("0. 종료          |프로그램 종료");

            if (!carts.isEmpty()) {
                System.out.println("[주문 관리]");
                System.out.println("4. 장바구니 확인    |장바구니 확인 후 주문합니다.");
                System.out.println("5. 주문 취소    |진행중인 주문을 취소합니다.");
            }

            try {
                int select = scanner.nextInt();

                if (select == 0) {
                    System.out.println("커머스 플랫폼을 종료합니다.");
                    scanner.close();
                    break;
                }

                switch (select) {
                    case 1:
                        category.electronics();
                        select_product("전자제품");
                        break;
                    case 2:
                        category.clothes();
                        select_product("의류");
                        break;
                    case 3:
                        category.food();
                        select_product("식품");
                        break;
                    case 4:
                        sum = 0;

                        System.out.println("아래와 같이 주문하시겠습니까?");
                        System.out.println("[장바구니 내역]");
                        for (Product cart : carts) {
                            System.out.println(cart.getName() + " | " + cart.getPrice() + " | " + cart.getExplanation() + " | 수량: " + cart.getCartCount());
                            sum += cart.getPrice() * cart.getCartCount();
                        }

                        System.out.println("[총 주문 금액]");
                        System.out.println(sum + "원");

                        System.out.println("1. 주문 확정    2. 메인으로 돌아가기");
                        int confirm_order = scanner.nextInt();

                        if (confirm_order == 1) {
                            System.out.println("주문이 완료되었습니다! 총 금액: " + sum + "원");

                            for (Product cart : carts) {
                                int currentStock = cart.getStock_quantity();

                                if (currentStock > 0) {
                                    cart.setStock_quantity(currentStock - 1);
                                    System.out.println(cart.getName() + "의 재고가 "
                                            + currentStock + "개 -> " + cart.getStock_quantity() + "개로 업데이트되었습니다.");
                                } else {
                                    System.out.println(cart.getName() + "은(는) 재고가 없습니다.");
                                }
                                cart.setCartCount(0);
                                carts.clear();
                            }
                        }
                        break;

                    case 5:
                        carts.clear();
                        System.out.println("진행중인 주문이 취소되었습니다.");
                        break;

                    default:
                        System.out.println("올바른 번호를 입력해주세요.");
                }

            } catch (Exception e) {
                System.out.println("숫자를 입력해주세요.");
                scanner.nextLine();
            }
        }
    }

    private boolean select_product(String categoryName) {
        try {
            int product_select = scanner.nextInt();

            if (product_select == 0) {
                return true;
            }

            List<Product> filteredProducts = new ArrayList<>();

            for (Product p : products) {
                if (p.getCategory().equals(categoryName)) {
                    filteredProducts.add(p);
                }
            }

            if (product_select >= 1 && product_select <= filteredProducts.size()) {
                Product p = filteredProducts.get(product_select - 1);
                System.out.println("★ 선택한 상품: " + p.getName() + " | " + p.getPrice() + "원 | " + p.getExplanation() + " | 재고: " + p.getStock_quantity() + "개");
                add_carts(p);
            } else {
                System.out.println("올바른 상품 번호를 입력해주세요.");
            }

        } catch (Exception e) {
            System.out.println("상품 번호를 입력해주세요.");
            scanner.nextLine();
        }
        return false;
    }

    private void add_carts(Product p) {
        if (p.getStock_quantity() <= 0) {
            System.out.println("재고가 없는 상품입니다.");
            return;
        }

        System.out.println("위 상품을 장바구니에 추가하시겠습니까?");
        System.out.println("1.확인        2.취소");
        int addCart = scanner.nextInt();

        if (addCart == 1) {
            if(carts.contains(p)) {
                p.setCartCount(p.getCartCount() + 1);
            } else {
                p.setCartCount(1);
                carts.add(p);
            }

            System.out.println(p.getName() + "가 장바구니에 추가되었습니다.");
        }
    }
}