public class Planner {

    // Stores the graph
    Graph graph;

    // Planner constructor
    public Planner(Graph graph) {
        this.graph = graph;
    }

    // Check if station exists
    public boolean stationExists(String stationName) {

        for (Route route : graph.routes) {

            if (
                    route.from.name.equalsIgnoreCase(stationName)
                            || route.to.name.equalsIgnoreCase(stationName)
            ) {
                return true;
            }
        }

        return false;
    }

    // Checks if a route matches the selected stations
    public boolean routeMatches(Route route, String start, String end) {
        return (
                route.from.name.equalsIgnoreCase(start)
                        && route.to.name.equalsIgnoreCase(end)
        ) || (
                route.from.name.equalsIgnoreCase(end)
                        && route.to.name.equalsIgnoreCase(start)
        );
    }

    // Returns the connected station from a route
    public String getOtherStation(Route route, String stationName) {

        if (route.from.name.equalsIgnoreCase(stationName)) {
            return route.to.name;
        }

        if (route.to.name.equalsIgnoreCase(stationName)) {
            return route.from.name;
        }

        return "";
    }

    // Finds the best route between two stations
    public void findRoute(String start, String end, int maxChanges) {

        // Check if station names are valid
        if (!stationExists(start) || !stationExists(end)) {
            System.out.println("Invalid station name.");
            return;
        }

        String bestRoute = "";
        int bestTime = Integer.MAX_VALUE;
        int changes = 0;

        // Search for direct routes
        if (maxChanges >= 0) {

            for (Route route : graph.routes) {

                if (routeMatches(route, start, end)) {

                    if (route.time < bestTime) {
                        bestTime = route.time;
                        changes = 0;
                        bestRoute = start + " -> " + end;
                    }
                }
            }
        }

        // Search for routes with one change
        if (maxChanges >= 1) {

            for (Route firstRoute : graph.routes) {

                String middleStation = getOtherStation(firstRoute, start);

                if (!middleStation.equals("")) {

                    for (Route secondRoute : graph.routes) {

                        if (routeMatches(secondRoute, middleStation, end)) {

                            int totalTime = firstRoute.time + secondRoute.time;

                            if (totalTime < bestTime) {
                                bestTime = totalTime;
                                changes = 1;
                                bestRoute = start + " -> " + middleStation + " -> " + end;
                            }
                        }
                    }
                }
            }
        }

        // Search for routes with two changes
        if (maxChanges >= 2) {

            for (Route firstRoute : graph.routes) {

                String firstMiddleStation = getOtherStation(firstRoute, start);

                if (!firstMiddleStation.equals("")) {

                    for (Route secondRoute : graph.routes) {

                        String secondMiddleStation = getOtherStation(secondRoute, firstMiddleStation);

                        if (!secondMiddleStation.equals("") && !secondMiddleStation.equalsIgnoreCase(start)) {

                            for (Route thirdRoute : graph.routes) {

                                if (routeMatches(thirdRoute, secondMiddleStation, end)) {

                                    int totalTime = firstRoute.time + secondRoute.time + thirdRoute.time;

                                    if (totalTime < bestTime) {
                                        bestTime = totalTime;
                                        changes = 2;
                                        bestRoute = start + " -> " + firstMiddleStation + " -> " + secondMiddleStation + " -> " + end;
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }

        // Show results
        if (bestTime == Integer.MAX_VALUE) {

            System.out.println("No route found with the selected constraint.");

        } else {

            System.out.println("Best route found:");
            System.out.println(bestRoute);
            System.out.println("Total time: " + bestTime + " mins");
            System.out.println("Changes: " + changes);
        }
    }
}