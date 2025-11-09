public class Stock {
    private String symbol;
    private double currentPrice;
    private double targetPrice;

    public Stock(String symbol, double targetPrice) {
        this.symbol = symbol;
        this.targetPrice = targetPrice;
    }

    public String getSymbol() { return symbol; }
    public double getCurrentPrice() { return currentPrice; }
    public void setCurrentPrice(double price) { this.currentPrice = price; }

    public double getTargetPrice() { return targetPrice; }
}
