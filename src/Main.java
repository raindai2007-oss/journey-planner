public class Main {
    public static void main(String[] args) {

        Station a = new Station("Piccadilly");
        Station b = new Station("Victoria");
        Station c = new Station("Deansgate");

        Graph graph = new Graph();

        graph.addRoute(new Route(a, b, 5));
        graph.addRoute(new Route(b, c, 4));
        graph.addRoute(new Route(a, c, 12));

        graph.printRoutes();
    }
}