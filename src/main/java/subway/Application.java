package subway;

import controller.SubwayController;
import java.util.Scanner;
import subway.domain.Line;
import subway.domain.LineRepository;
import subway.domain.Station;
import subway.domain.StationRepository;
import view.InputView;

public class Application {
    public static void main(String[] args) {
        final Scanner scanner = new Scanner(System.in);
        SubwayController subwayController = new SubwayController(scanner);
        // TODO: 프로그램 구현

        initShortest();
        // ## 메인 화면
        // 1. 경로 조회
        // Q. 종료
        String mainSelect = InputView.requireMain(scanner);
        if (mainSelect.equals("1")) {
            subwayController.run();
        }


    }

    private static void initShortest() {
        Line line = new Line("LINE2");

        Station station = new Station("GYODAE");
        station.addShortestDistance("GANGNAM", 2);
        station.addShortestTime("GANGNAM", 3);
        StationRepository.addStation(station);

        station = new Station("GANGNAM");
        station.addShortestDistance("GYODAE", 2);
        station.addShortestTime("GYODAE", 3);
        station.addShortestDistance("YEOKSAM", 2);
        station.addShortestTime("YEOKSAM", 3);
        StationRepository.addStation(station);

        station = new Station("YEOKSAM");
        station.addShortestDistance("GANGNAM", 2);
        station.addShortestTime("GANGNAM", 3);
        StationRepository.addStation(station);
        LineRepository.addLine(line);

        line = new Line("LINE3");
        station = new Station("GYODAE");
        station.addShortestDistance("SOUTH", 3);
        station.addShortestTime("SOUTH", 2);
        StationRepository.addStation(station);

        station = new Station("SOUTH");
        station.addShortestDistance("GYODAE", 3);
        station.addShortestTime("GYODAE", 2);
        station.addShortestDistance("YANGJAE", 6);
        station.addShortestTime("YANGJAE", 5);
        StationRepository.addStation(station);

        station = new Station("YANGJAE");
        station.addShortestDistance("SOUTH", 6);
        station.addShortestTime("SOUTH", 5);
        station.addShortestDistance("MAEBONG", 1);
        station.addShortestTime("MAEBONG", 1);

        station = new Station("MAEBONG");
        station.addShortestDistance("YANGJAE", 1);
        station.addShortestTime("YANGJAE", 1);
        LineRepository.addLine(line);

        line = new Line("NEW");
        station = new Station("GANGNAM");
        station.addShortestDistance("YANGJAE", 2);
        station.addShortestTime("YANGJAE", 8);
        StationRepository.addStation(station);

        station = new Station("YANGJAE");
        station.addShortestDistance("GANGNAM", 2);
        station.addShortestTime("GANGNAM", 8);
        station.addShortestDistance("YANGJAEFOREST", 10);
        station.addShortestTime("YANGJAEFOREST", 3);
        StationRepository.addStation(station);

        station = new Station("YANGJAEFOREST");
        station.addShortestDistance("YANGJAE", 10);
        station.addShortestTime("YANGJAE", 3);
        LineRepository.addLine(line);
    }
}
