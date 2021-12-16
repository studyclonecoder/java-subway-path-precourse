package subway.domain;

import java.util.LinkedHashMap;
import java.util.Map;

public class Station {
    private String name;
    private Map shortestTime = new LinkedHashMap();
    private Map shortestDistance = new LinkedHashMap();

    public Station(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    // 추가 기능 구현
    public void addShortestDistance(String endStation, Integer distance) {
        shortestDistance.put(endStation, distance);
    }

    public void addShortestTime(String endStation, Integer time) {
        shortestTime.put(endStation, time);
    }
}
