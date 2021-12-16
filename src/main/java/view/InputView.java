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

    public static String requirePathMain(Scanner scanner) {
        System.out.println("## 경로 기준");
        System.out.println("1. 최단 거리");
        System.out.println("2. 최소 시간");
        System.out.println("B. 돌아가기");
        System.out.println();
        System.out.println("## 원하는 기능을 선택하세요.");
        return scanner.nextLine();
    }

    public static String requireStartStation(Scanner scanner) {
        System.out.println("## 출발역을 입력하세요.");
        return scanner.nextLine();

    }

    public static String requireEndStation(Scanner scanner) {
        System.out.println("## 도착역을 입력하세요.");
        return scanner.nextLine();
    }
}
