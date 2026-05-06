public class Planner {

    Graph graph;

    public Planner(Graph graph) {
        this.graph = graph;
    }

    public void findRoute(String start, String end) {

        String bestRoute = "";
        int bestTime = Integer.MAX_VALUE;

        for (Route route : graph.routes) {

            if (
                    (route.from.name.equalsIgnoreCase(start)
                            && route.to.name.equalsIgnoreCase(end))

                            ||

                            (route.from.name.equalsIgnoreCase(end)
                                    && route.to.name.equalsIgnoreCase(start))
            ) {

                if (route.time < bestTime) {

                    bestTime = route.time;

                    bestRoute =
                            route.from.name
                                    + " -> "
                                    + route.to.name;
                }
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

                        if (totalTime < bestTime) {

                            bestTime = totalTime;

                            bestRoute =
                                    firstRoute.from.name
                                            + " -> "
                                            + middleStation
                                            + " -> "
                                            + secondRoute.to.name;
                        }
                    }
                }
            }
        }

        if (bestTime == Integer.MAX_VALUE) {

            System.out.println("No route found.");

        } else {

            System.out.println("Best route found:");
            System.out.println(bestRoute);
            System.out.println("Total time: " + bestTime + " mins");
        }
    }
}