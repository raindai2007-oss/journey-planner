import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.PriorityQueue;

public class Planner {

    Graph graph;

    public Planner(Graph graph) {
        this.graph = graph;
    }

    public void findRoute(String startName, String endName, String option) {

        if (!graph.stationExists(startName) || !graph.stationExists(endName)) {
            System.out.println("Invalid station name.");
            return;
        }

        Station start = graph.getStation(startName);
        Station end = graph.getStation(endName);

        PriorityQueue<PathState> queue = new PriorityQueue<>(new Comparator<PathState>() {
            public int compare(PathState a, PathState b) {

                if (option.equals("changes")) {
                    if (a.changes != b.changes) {
                        return a.changes - b.changes;
                    }

                    return Double.compare(a.totalTime, b.totalTime);
                }

                if (a.totalTime != b.totalTime) {
                    return Double.compare(a.totalTime, b.totalTime);
                }

                return a.changes - b.changes;
            }
        });

        HashMap<String, Double> bestScore = new HashMap<>();

        queue.add(new PathState(start, 0, 0, "", new ArrayList<Route>()));

        while (!queue.isEmpty()) {

            PathState current = queue.poll();

            if (current.station.name.equalsIgnoreCase(end.name)) {
                printJourney(current);
                return;
            }

            String key = current.station.name.toLowerCase() + "-" + current.currentLine;
            double score;

            if (option.equals("changes")) {
                score = current.changes;
            } else {
                score = current.totalTime;
            }

            if (bestScore.containsKey(key) && bestScore.get(key) <= score) {
                continue;
            }

            bestScore.put(key, score);

            for (Route route : graph.getRoutesFrom(current.station)) {

                Station nextStation = route.getOtherStation(current.station);

                if (nextStation == null) {
                    continue;
                }

                int newChanges = current.changes;

                if (!current.currentLine.equals("") && !current.currentLine.equals(route.lineColour)) {
                    newChanges++;
                }

                ArrayList<Route> newPath = new ArrayList<>(current.path);
                newPath.add(route);

                queue.add(new PathState(
                        nextStation,
                        current.totalTime + route.time,
                        newChanges,
                        route.lineColour,
                        newPath
                ));
            }
        }

        System.out.println("No route found.");
    }

    public void printJourney(PathState result) {

        System.out.println();
        System.out.println("====================================");
        System.out.println("Best Route Found");
        System.out.println("====================================");

        if (result.path.size() == 0) {
            System.out.println("Start and destination are the same.");
            return;
        }

        Route firstRoute = result.path.get(0);
        System.out.println("Start: " + firstRoute.from.name);

        for (Route route : result.path) {
            System.out.println(
                    "Take " + route.lineColour +
                            " line to " + route.to.name +
                            " (" + route.time + " mins)"
            );
        }

        System.out.println("Total time: " + result.totalTime + " mins");
        System.out.println("Line changes: " + result.changes);
        System.out.println("====================================");
    }
}