public class Route {
    Station from;
    Station to;
    double time;
    String lineColour;

    public Route(Station from, Station to, double time, String lineColour) {
        this.from = from;
        this.to = to;
        this.time = time;
        this.lineColour = lineColour;
    }

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