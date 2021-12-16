package controller;

import java.util.List;
import java.util.Scanner;
import subway.domain.StationRepository;
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
        if (mainNumber.equals("2")) {
            String startStation = InputView.requireStartStation(scanner);
            String endStation = InputView.requireEndStation(scanner);
            List<String> shortestTimeStations = StationRepository
                .getShortestTimeStations(startStation, endStation);
            Integer distance = StationRepository.calculateDistnace(shortestTimeStations);
            Integer time = StationRepository.calculateTime(shortestTimeStations);
            System.out.println(distance);
            System.out.println(time);
        }

        if (mainNumber.equals("1")) {
            String startStation = InputView.requireStartStation(scanner);
            String endStation = InputView.requireEndStation(scanner);
            List<String> shortestDistnaceStations = StationRepository
                .getShortestDistanceStations(startStation, endStation);
            System.out.println(shortestDistnaceStations);
            Integer distance = StationRepository.calculateDistnace(shortestDistnaceStations);
            Integer time = StationRepository.calculateTime(shortestDistnaceStations);
            System.out.println(distance);
            System.out.println(time);
        }
    }
}
