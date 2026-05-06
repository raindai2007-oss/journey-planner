import java.util.ArrayList;

public class Graph {

    ArrayList<Route> routes = new ArrayList<>();

    public void addRoute(Route route) {
        routes.add(route);
    }

    public void printRoutes() {
        for (Route r : routes) {
            System.out.println(
                    r.from.name + " -> " +
                            r.to.name + " : " +
                            r.time + " mins"
            );
        }
    }
}