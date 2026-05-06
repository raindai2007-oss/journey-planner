public class Main {
    public static void main(String[] args) {

        Station a = new Station("Piccadilly");
        Station b = new Station("Victoria");

        Route r = new Route(a, b, 5);

        System.out.println(
                r.from.name + " -> " +
                        r.to.name + " : " +
                        r.time + " mins"
        );
    }
}