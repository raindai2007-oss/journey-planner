import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        // Create stations
        Station a = new Station("Piccadilly");
        Station b = new Station("Victoria");
        Station c = new Station("Deansgate");
        Station d = new Station("St Peters Square");
        Station e = new Station("MediaCityUK");
        Station f = new Station("Market Street");
        Station g = new Station("Shudehill");
        Station h = new Station("Cornbrook");
        Station i = new Station("Old Trafford");
        Station j = new Station("Altrincham");
        Station k = new Station("Eccles");
        Station l = new Station("Trafford Bar");

        // Store routes
        Graph graph = new Graph();

        // Add routes
        graph.addRoute(new Route(a, b, 5));
        graph.addRoute(new Route(b, c, 4));
        graph.addRoute(new Route(a, c, 12));
        graph.addRoute(new Route(c, d, 3));
        graph.addRoute(new Route(d, e, 6));
        graph.addRoute(new Route(b, e, 15));
        graph.addRoute(new Route(a, f, 4));
        graph.addRoute(new Route(f, g, 3));
        graph.addRoute(new Route(g, b, 4));
        graph.addRoute(new Route(d, h, 5));
        graph.addRoute(new Route(h, i, 6));
        graph.addRoute(new Route(i, j, 12));
        graph.addRoute(new Route(h, e, 8));
        graph.addRoute(new Route(e, k, 7));
        graph.addRoute(new Route(h, l, 4));
        graph.addRoute(new Route(l, i, 5));
        graph.addRoute(new Route(f, d, 5));
        graph.addRoute(new Route(g, e, 10));
        graph.addRoute(new Route(l, j, 14));
        graph.addRoute(new Route(k, h, 9));

        // Create planner object
        Planner planner = new Planner(graph);

        Scanner scanner = new Scanner(System.in);

        boolean running = true;

        // Main menu
        while (running) {

            System.out.println();
            System.out.println("====================================");
            System.out.println("Manchester Metrolink Journey Planner");
            System.out.println("====================================");
            System.out.println("1. Find Route");
            System.out.println("2. Show Routes");
            System.out.println("3. Exit");
            System.out.println("====================================");
            System.out.println("Choose an option:");

            String choice = scanner.nextLine();

            // Find route
            if (choice.equals("1")) {

                System.out.println();
                System.out.println("====================================");
                System.out.println("Available Stations");
                System.out.println("====================================");
                System.out.println("- Piccadilly");
                System.out.println("- Victoria");
                System.out.println("- Deansgate");
                System.out.println("- St Peters Square");
                System.out.println("- MediaCityUK");
                System.out.println("- Market Street");
                System.out.println("- Shudehill");
                System.out.println("- Cornbrook");
                System.out.println("- Old Trafford");
                System.out.println("- Altrincham");
                System.out.println("- Eccles");
                System.out.println("- Trafford Bar");
                System.out.println("====================================");
                System.out.println();

                System.out.println("Enter starting station:");
                String start = scanner.nextLine();

                System.out.println("Enter destination station:");
                String end = scanner.nextLine();

                System.out.println("Enter maximum number of changes:");

                int maxChanges;

                try {
                    maxChanges = Integer.parseInt(scanner.nextLine());
                } catch (NumberFormatException error) {
                    System.out.println();
                    System.out.println("====================================");
                    System.out.println("Please enter a valid number.");
                    System.out.println("====================================");
                    continue;
                }

                planner.findRoute(start, end, maxChanges);

            }

            // Show routes
            else if (choice.equals("2")) {

                System.out.println();
                System.out.println("====================================");
                System.out.println("Available Routes");
                System.out.println("====================================");
                graph.printRoutes();
                System.out.println("====================================");

            }

            // Exit program
            else if (choice.equals("3")) {

                running = false;
                System.out.println();
                System.out.println("====================================");
                System.out.println("Program closed.");
                System.out.println("====================================");

            }

            // Invalid input
            else {

                System.out.println();
                System.out.println("====================================");
                System.out.println("Invalid option.");
                System.out.println("====================================");
            }
        }

        scanner.close();
    }
}