public class Route {
    Station from;
    Station to;
    int time;

    public Route(Station from, Station to, int time) {
        this.from = from;
        this.to = to;
        this.time = time;
    }
}