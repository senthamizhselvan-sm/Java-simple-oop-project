import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class APIFetcher {
    private static final String API_KEY = "EDLBDI048TOUTR1L"; // Replace with your actual API key

    public double fetchPrice(String symbol) {
        try {
            String apiUrl = "https://www.alphavantage.co/query?function=GLOBAL_QUOTE&symbol=" + symbol + "&apikey=" + API_KEY;

            URL url = new URL(apiUrl);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("GET");

            BufferedReader reader = new BufferedReader(new InputStreamReader(conn.getInputStream()));
            StringBuilder json = new StringBuilder();
            String line;
            while ((line = reader.readLine()) != null) {
                json.append(line);
            }
            reader.close();

            // Simple parsing without libraries
            String jsonStr = json.toString();
            String searchKey = "\"05. price\": \"";
            int index = jsonStr.indexOf(searchKey);
            if (index != -1) {
                int start = index + searchKey.length();
                int end = jsonStr.indexOf("\"", start);
                String priceStr = jsonStr.substring(start, end);
                return Double.parseDouble(priceStr);
            } else {
                System.out.println("Price not found in response.");
                return -1;
            }

        } catch (Exception e) {
            System.err.println("Error fetching price: " + e.getMessage());
            return -1;
        }
    }
}
