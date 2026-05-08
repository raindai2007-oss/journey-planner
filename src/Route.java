public class Route {

    // Starting station
    Station from;

    // Destination station
    Station to;

    // Journey time
    double time;

    // Line colour
    String lineColour;

    // Route constructor
    public Route(Station from, Station to, double time, String lineColour) {
        this.from = from;
        this.to = to;
        this.time = time;
        this.lineColour = lineColour;
    }

    // Get connected station
    public Station getOtherStation(Station station) {

        if (from.name.equalsIgnoreCase(station.name)) {
            return to;
        }

        if (to.name.equalsIgnoreCase(station.name)) {
            return from;
        }

        return null;
    }
}