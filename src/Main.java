import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Graph graph = new Graph();

        graph.addRoute("Bury", "Radcliffe", 6, "yellow");
        graph.addRoute("Radcliffe", "Whitefield", 3, "yellow");
        graph.addRoute("Whitefield", "Besses o'th' Barn", 2.5, "yellow");
        graph.addRoute("Besses o'th' Barn", "Prestwich", 2, "yellow");
        graph.addRoute("Prestwich", "Heaton Park", 2.5, "yellow");
        graph.addRoute("Heaton Park", "Bowker Vale", 2, "yellow");
        graph.addRoute("Bowker Vale", "Crumpsall", 1.5, "yellow");
        graph.addRoute("Crumpsall", "Abraham Moss", 2, "yellow");
        graph.addRoute("Abraham Moss", "Queens Road", 2.5, "yellow");
        graph.addRoute("Queens Road", "Victoria", 5, "yellow");
        graph.addRoute("Victoria", "Shudehill", 2, "yellow");
        graph.addRoute("Shudehill", "Market Street", 2, "yellow");
        graph.addRoute("Market Street", "Piccadilly Gardens", 2, "yellow");
        graph.addRoute("Piccadilly Gardens", "Piccadilly Station", 3, "yellow");

        graph.addRoute("Altrincham", "Navigation Road", 1.5, "purple");
        graph.addRoute("Navigation Road", "Timperley", 2, "purple");
        graph.addRoute("Timperley", "Brooklands", 2.5, "purple");
        graph.addRoute("Brooklands", "Sale", 1, "purple");
        graph.addRoute("Sale", "Dane Road", 1, "purple");
        graph.addRoute("Dane Road", "Stretford", 2.5, "purple");
        graph.addRoute("Stretford", "Old Trafford", 2, "purple");
        graph.addRoute("Old Trafford", "Trafford Bar", 2.5, "purple");
        graph.addRoute("Trafford Bar", "Cornbrook", 3, "purple");
        graph.addRoute("Cornbrook", "Deansgate/Castlefield", 2, "purple");
        graph.addRoute("Deansgate/Castlefield", "St. Peter's Square", 1, "purple");
        graph.addRoute("St. Peter's Square", "Piccadilly Gardens", 1.5, "purple");
        graph.addRoute("Piccadilly Gardens", "Piccadilly Station", 2, "purple");

        graph.addRoute("Eccles", "Ladywell", 1.5, "lightblue");
        graph.addRoute("Ladywell", "Weaste", 3, "lightblue");
        graph.addRoute("Weaste", "Langworthy", 2.5, "lightblue");
        graph.addRoute("Langworthy", "Broadway", 2, "lightblue");
        graph.addRoute("Broadway", "Media CityUK", 2, "lightblue");
        graph.addRoute("Media CityUK", "Harbour City", 2, "lightblue");
        graph.addRoute("Harbour City", "Anchorage", 1.5, "lightblue");
        graph.addRoute("Anchorage", "Salford Quays", 2, "lightblue");
        graph.addRoute("Salford Quays", "Exchange Quay", 2, "lightblue");
        graph.addRoute("Exchange Quay", "Pomona", 2, "lightblue");
        graph.addRoute("Pomona", "Cornbrook", 3, "lightblue");
        graph.addRoute("Cornbrook", "Deansgate/Castlefield", 3.5, "lightblue");

        Planner planner = new Planner(graph);

        Scanner scanner = new Scanner(System.in);
        boolean running = true;

        while (running) {

            System.out.println();
            System.out.println("====================================");
            System.out.println("Manchester Metrolink Journey Planner");
            System.out.println("====================================");
            System.out.println("1. Find shortest time route");
            System.out.println("2. Find route with fewest changes");
            System.out.println("3. Show Stations");
            System.out.println("4. Show Routes");
            System.out.println("5. Exit");
            System.out.println("====================================");
            System.out.println("Choose an option:");

            String choice = scanner.nextLine();

            if (choice.equals("1") || choice.equals("2")) {

                System.out.println("Enter starting station:");
                String start = scanner.nextLine();

                System.out.println("Enter destination station:");
                String end = scanner.nextLine();

                if (choice.equals("1")) {
                    planner.findRoute(start, end, "time");
                } else {
                    planner.findRoute(start, end, "changes");
                }

            } else if (choice.equals("3")) {

                graph.printStations();

            } else if (choice.equals("4")) {

                graph.printRoutes();

            } else if (choice.equals("5")) {

                running = false;
                System.out.println("Program closed.");

            } else {

                System.out.println("Invalid option.");
            }
        }

        scanner.close();
    }
}