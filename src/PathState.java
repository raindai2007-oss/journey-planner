import java.util.ArrayList;

public class PathState {

    Station station;
    double totalTime;
    int changes;
    String currentLine;
    ArrayList<Route> path;

    public PathState(Station station, double totalTime, int changes, String currentLine, ArrayList<Route> path) {
        this.station = station;
        this.totalTime = totalTime;
        this.changes = changes;
        this.currentLine = currentLine;
        this.path = path;
    }
}
Main.java