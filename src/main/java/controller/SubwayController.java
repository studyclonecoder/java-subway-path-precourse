package controller;

import java.util.Scanner;
import view.InputView;

public class SubwayController {
    private final Scanner scanner;

    public SubwayController(Scanner scanner) {
        this.scanner = scanner;
    }

    public void run() {
        // ## 경로 기준
        // 1. 최단 거리
        // 2. 최소 시간
        // B. 돌아가기
        String mainNumber = InputView.requirePathMain(scanner);
        if (mainNumber.equals("1")) {
            String startStation = InputView.requireStartStation(scanner);
            String endStation = InputView.requireEndStation(scanner);
        }
    }
}
