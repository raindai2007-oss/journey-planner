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

        Planner planner = new Planner(graph);

        Scanner scanner = new Scanner(System.in);

        boolean running = true;

        while (running) {

            System.out.println();
            System.out.println("Manchester Metrolink Journey Planner");
            System.out.println("1. Find Route");
            System.out.println("2. Exit");
            System.out.println("Choose an option:");

            String choice = scanner.nextLine();

            if (choice.equals("1")) {

                System.out.println("Enter starting station:");
                String start = scanner.nextLine();

                System.out.println("Enter destination station:");
                String end = scanner.nextLine();

                planner.findRoute(start, end);

            } else if (choice.equals("2")) {

                running = false;
                System.out.println("Program closed.");

            } else {

                System.out.println("Invalid option.");
            }
        }

        scanner.close();
    }
}