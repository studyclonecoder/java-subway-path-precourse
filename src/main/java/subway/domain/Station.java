package subway.domain;

import java.util.LinkedHashMap;
import java.util.Map;

public class Station {
    private String name;
    private Map<String, Integer> shortestTime = new LinkedHashMap();
    private Map<String, Integer> shortestDistance = new LinkedHashMap();

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

    public Map getShortestTime() {
        return shortestTime;
    }

    public Map getShortestDistance() {
        return shortestDistance;
    }

    public Integer distance(String station) {
        return shortestDistance.get(station);
    }

    public Integer time(String station) {
        return shortestTime.get(station);
    }
}
