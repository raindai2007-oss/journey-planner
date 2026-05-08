import java.util.ArrayList;
import java.util.HashMap;

public class Graph {

    ArrayList<Route> routes = new ArrayList<>();
    HashMap<String, Station> stations = new HashMap<>();

    public Station getStation(String name) {
        String key = name.toLowerCase();

        if (!stations.containsKey(key)) {
            stations.put(key, new Station(name));
        }

        return stations.get(key);
    }

    public void addRoute(String from, String to, double time, String lineColour) {
        Station fromStation = getStation(from);
        Station toStation = getStation(to);

        routes.add(new Route(fromStation, toStation, time, lineColour));
    }

    public ArrayList<Route> getRoutesFrom(Station station) {
        ArrayList<Route> matchingRoutes = new ArrayList<>();

        for (Route route : routes) {
            if (
                    route.from.name.equalsIgnoreCase(station.name)
                            || route.to.name.equalsIgnoreCase(station.name)
            ) {
                matchingRoutes.add(route);
            }
        }

        return matchingRoutes;
    }

    public boolean stationExists(String stationName) {
        return stations.containsKey(stationName.toLowerCase());
    }

    public void printStations() {
        for (Station station : stations.values()) {
            System.out.println("- " + station.name);
        }
    }

    public void printRoutes() {
        for (Route route : routes) {
            System.out.println(
                    route.from.name + " -> " +
                            route.to.name + " : " +
                            route.time + " mins (" +
                            route.lineColour + ")"
            );
        }
    }
}