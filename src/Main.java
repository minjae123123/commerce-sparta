import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Product> products = new ArrayList<>();
        products.add(new Product("Galaxy S24", 1200000, "  최신 안드로이드 스마트폰", 50));
        products.add(new Product("iPhone 16 ", 1350000, "  Apple의 최신 스마트폰", 50));
        products.add(new Product("MacBook Pro", 2400000, "  M3 칩셋이 탑재된 노트북", 50));
        products.add(new Product("AirPods Pro", 350000, "  노이즈 캔슬링 무선 이어폰", 50));

        while (true) {
            System.out.println("[실시간 커머스 플랫폼 - 전자제품]");

            for (int i = 0; i < products.size() ; i++) {
                Product p = products.get(i);
                System.out.println((i + 1)+"." + p.getName() + "     |" + p.getPrice() + "|" + p.getExplanation());
            }

            System.out.println("0. 종료          |프로그램 종료");

            int exit = scanner.nextInt();
            if(exit == 0) {
                System.out.println("커머스 플랫픔을 종료합니다.");
                break;
            }
        }
    }
}
