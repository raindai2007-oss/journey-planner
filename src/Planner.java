import java.util.ArrayList;

public class Planner {
    Graph graph;

    public Planner(Graph graph) {
        this.graph = graph;
    }

    public void findDirectRoute(String start, String end) {
        boolean found = false;

        for (Route route : graph.routes) {
            if (
                    (route.from.name.equalsIgnoreCase(start)
                            && route.to.name.equalsIgnoreCase(end))

                            ||

                            (route.from.name.equalsIgnoreCase(end)
                                    && route.to.name.equalsIgnoreCase(start))
            ) {

                System.out.println("Route found:");
                System.out.println(route.from.name + " -> " + route.to.name);
                System.out.println("Time: " + route.time + " mins");
                found = true;
            }
        }

        if (!found) {
            System.out.println("No direct route found.");
        }
    }
}