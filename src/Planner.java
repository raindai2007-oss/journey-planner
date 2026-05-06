public class Planner {

    Graph graph;

    public Planner(Graph graph) {
        this.graph = graph;
    }

    public void findRoute(String start, String end) {

        for (Route route : graph.routes) {

            if (
                    (route.from.name.equalsIgnoreCase(start)
                            && route.to.name.equalsIgnoreCase(end))

                            ||

                            (route.from.name.equalsIgnoreCase(end)
                                    && route.to.name.equalsIgnoreCase(start))
            ) {

                System.out.println("Direct route found:");
                System.out.println(route.from.name + " -> " + route.to.name);
                System.out.println("Time: " + route.time + " mins");
                return;
            }
        }

        for (Route firstRoute : graph.routes) {

            if (firstRoute.from.name.equalsIgnoreCase(start)) {

                String middleStation = firstRoute.to.name;

                for (Route secondRoute : graph.routes) {

                    if (
                            secondRoute.from.name.equalsIgnoreCase(middleStation)
                                    && secondRoute.to.name.equalsIgnoreCase(end)
                    ) {

                        int totalTime = firstRoute.time + secondRoute.time;

                        System.out.println("Route with one change found:");
                        System.out.println(
                                firstRoute.from.name
                                        + " -> "
                                        + middleStation
                                        + " -> "
                                        + secondRoute.to.name
                        );

                        System.out.println("Total time: " + totalTime + " mins");

                        return;
                    }
                }
            }
        }

        System.out.println("No route found.");
    }
}