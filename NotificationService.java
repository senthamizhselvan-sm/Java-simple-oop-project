public class NotificationService implements StockObserver {
    @Override
    public void onPriceUpdate(Stock stock) {
        if (stock.getCurrentPrice() >= stock.getTargetPrice()) {
            System.out.println(" Stock " + stock.getSymbol() + " reached target price: " + stock.getCurrentPrice());
        }
    }
}
