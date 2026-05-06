public class Planner {

    Graph graph;

    public Planner(Graph graph) {
        this.graph = graph;
    }

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

    public boolean routeMatches(Route route, String start, String end) {
        return (
                route.from.name.equalsIgnoreCase(start)
                        && route.to.name.equalsIgnoreCase(end)
        ) || (
                route.from.name.equalsIgnoreCase(end)
                        && route.to.name.equalsIgnoreCase(start)
        );
    }

    public String getOtherStation(Route route, String stationName) {

        if (route.from.name.equalsIgnoreCase(stationName)) {
            return route.to.name;
        }

        if (route.to.name.equalsIgnoreCase(stationName)) {
            return route.from.name;
        }

        return "";
    }

    public void findRoute(String start, String end) {

        if (!stationExists(start) || !stationExists(end)) {
            System.out.println("Invalid station name.");
            return;
        }

        String bestRoute = "";
        int bestTime = Integer.MAX_VALUE;
        int changes = 0;

        for (Route route : graph.routes) {

            if (routeMatches(route, start, end)) {

                if (route.time < bestTime) {
                    bestTime = route.time;
                    changes = 0;
                    bestRoute = start + " -> " + end;
                }
            }
        }

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

        if (bestTime == Integer.MAX_VALUE) {

            System.out.println("No route found.");

        } else {

            System.out.println("Best route found:");
            System.out.println(bestRoute);
            System.out.println("Total time: " + bestTime + " mins");
            System.out.println("Changes: " + changes);
        }
    }
}