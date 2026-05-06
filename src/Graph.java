import java.util.ArrayList;

public class Graph {

    // Stores routes
    ArrayList<Route> routes = new ArrayList<>();

    // Add routes
    public void addRoute(Route route) {
        routes.add(route);
    }

    // Print routes
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