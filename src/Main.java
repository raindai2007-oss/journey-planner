import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Station a = new Station("Piccadilly");
        Station b = new Station("Victoria");
        Station c = new Station("Deansgate");
        Station d = new Station("St Peters Square");
        Station e = new Station("MediaCityUK");

        Graph graph = new Graph();

        graph.addRoute(new Route(a, b, 5));
        graph.addRoute(new Route(b, c, 4));
        graph.addRoute(new Route(a, c, 12));
        graph.addRoute(new Route(c, d, 3));
        graph.addRoute(new Route(d, e, 6));
        graph.addRoute(new Route(b, e, 15));

        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter starting station:");
        String start = scanner.nextLine();

        System.out.println("Enter destination station:");
        String end = scanner.nextLine();

        Planner planner = new Planner(graph);

        planner.findRoute(start, end);

        scanner.close();
    }
}