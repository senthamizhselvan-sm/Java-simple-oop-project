import java.util.*;

public class StockTracker {
    private List<Stock> stocks = new ArrayList<>();
    private List<StockObserver> observers = new ArrayList<>();

    public void addStock(Stock stock) {
        stocks.add(stock);
    }

    public void addObserver(StockObserver observer) {
        observers.add(observer);
    }

    public void checkPrices(APIFetcher fetcher) {
        for (Stock stock : stocks) {
            double price = fetcher.fetchPrice(stock.getSymbol());
            stock.setCurrentPrice(price);
            for (StockObserver o : observers) {
                o.onPriceUpdate(stock);
            }
        }
    }
}
