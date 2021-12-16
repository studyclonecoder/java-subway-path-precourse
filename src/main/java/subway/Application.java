package subway;

import controller.SubwayController;
import java.util.Scanner;
import view.InputView;

public class Application {
    public static void main(String[] args) {
        final Scanner scanner = new Scanner(System.in);
        SubwayController subwayController = new SubwayController(scanner);
        // TODO: 프로그램 구현

        // ## 메인 화면
        // 1. 경로 조회
        // Q. 종료
        String mainSelect = InputView.requireMain(scanner);
        if (mainSelect.equals("1")) {
            subwayController.run();
        }
    }
}
