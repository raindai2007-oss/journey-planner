import java.util.ArrayList;

public class PathState {

    // Current station
    Station station;

    // Total journey time
    double totalTime;

    // Number of line changes
    int changes;

    // Current line colour
    String currentLine;

    // Stores the route path
    ArrayList<Route> path;

    // PathState constructor
    public PathState(Station station, double totalTime, int changes, String currentLine, ArrayList<Route> path) {
        this.station = station;
        this.totalTime = totalTime;
        this.changes = changes;
        this.currentLine = currentLine;
        this.path = path;
    }
}