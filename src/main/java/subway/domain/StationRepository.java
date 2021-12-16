package subway.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import org.jgrapht.alg.shortestpath.DijkstraShortestPath;
import org.jgrapht.graph.DefaultWeightedEdge;
import org.jgrapht.graph.WeightedMultigraph;

public class StationRepository {

    public StationRepository() {

    }

    private static final List<Station> stations = new ArrayList<>();

    public static List<Station> stations() {
        return Collections.unmodifiableList(stations);
    }

    public static void addStation(Station station) {
        stations.add(station);
    }

    public static boolean deleteStation(String name) {
        return stations.removeIf(station -> Objects.equals(station.getName(), name));
    }

    public static void deleteAll() {
        stations.clear();
    }

    public static List<String> getShortestTimeStations(String startStation, String endStation) {
        WeightedMultigraph<String, DefaultWeightedEdge> graph = new WeightedMultigraph(DefaultWeightedEdge.class);
        for (Station station : stations) {
            String startStationName = station.getName();
            graph.addVertex(startStationName);
        }

        for (Station station : stations) {
            String startStationName = station.getName();
            System.out.println(startStationName);

            Map<String, Integer> shortestTime = station.getShortestTime();
            for (String endStationName : shortestTime.keySet()) {
                Integer time = shortestTime.get(endStationName);
                System.out.println(endStationName);
                graph.setEdgeWeight(graph.addEdge(startStationName, endStationName), time);
            }
            System.out.println();
        }
        DijkstraShortestPath dijkstraShortestPath = new DijkstraShortestPath(graph);
        List<String> vertextList = dijkstraShortestPath.getPath(startStation, endStation).getVertexList();

        return vertextList;

    }

    public static Integer calculateDistnace(List<String> vertexList) {

        int totalDistance = 0;
        for (int i = 1; i < vertexList.size(); i++) {
            int startStationIndex = i - 1;
            int endStationIndex = i;
            Integer distance = stations.stream()
                .filter(
                    station -> Objects.equals(station.getName(), vertexList.get(startStationIndex)))
                .filter(station -> station.canGo(vertexList.get(endStationIndex)))
                .map(station -> station.distance(vertexList.get(endStationIndex)))
                .findFirst()
                .get();
            totalDistance += distance;
        }
        return totalDistance;
    }

    public static Integer calculateTime(List<String> vertexList) {

        int totalDistance = 0;
        for (int i = 1; i < vertexList.size(); i++) {
            int startStationIndex = i - 1;
            int endStationIndex = i;
            Integer distance = stations.stream()
                .filter(
                    station -> Objects.equals(station.getName(), vertexList.get(startStationIndex)))
                .filter(station -> station.canGo(vertexList.get(endStationIndex)))
                .map(station -> station.time(vertexList.get(endStationIndex))).findFirst()
                .orElse(-1);
            totalDistance += distance;
        }
        return totalDistance;
    }

    public static List<String> getShortestDistanceStations(String startStation, String endStation) {
        WeightedMultigraph<String, DefaultWeightedEdge> graph = new WeightedMultigraph(DefaultWeightedEdge.class);
        for (Station station : stations) {
            String startStationName = station.getName();
            graph.addVertex(startStationName);
        }

        for (Station station : stations) {
            String startStationName = station.getName();
            System.out.println(startStationName);

            Map<String, Integer> shortestDistance = station.getShortestDistance();
            for (String endStationName : shortestDistance.keySet()) {
                Integer time = shortestDistance.get(endStationName);
                System.out.println(endStationName);
                graph.setEdgeWeight(graph.addEdge(startStationName, endStationName), time);
            }
            System.out.println();
        }
        DijkstraShortestPath dijkstraShortestPath = new DijkstraShortestPath(graph);
        List<String> vertextList = dijkstraShortestPath.getPath(startStation, endStation).getVertexList();

        return vertextList;
    }
}
