package view;

import java.util.Scanner;

public class InputView {

    public static String requireMain(Scanner scanner) {
        System.out.println("## 메인 화면");
        System.out.println("1. 경로 조회");
        System.out.println("Q. 종료");
        System.out.println();
        System.out.println("원하는 기능을 선택하세요.");
        return scanner.nextLine();
    }
}
