import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        APIFetcher fetcher = new APIFetcher();

        while (true) {
            System.out.print("Enter stock symbol (or 'exit' to quit): ");
            String symbol = scanner.nextLine().trim();

            if (symbol.equalsIgnoreCase("exit")) {
                System.out.println("Exiting...");
                break;
            }

            System.out.print("Target price: ");
            double targetPrice = Double.parseDouble(scanner.nextLine());

            double currentPrice = fetcher.fetchPrice(symbol);
            if (currentPrice == -1) {
                System.out.println("Could not fetch price for " + symbol);
                continue;
            }

            System.out.println("Current price of " + symbol + ": " + currentPrice);

            if (currentPrice >= targetPrice) {
                System.out.println(" Target reached or exceeded!");
            } else {
                System.out.println(" Target not reached.");
            }
        }

        scanner.close();
    }
}
