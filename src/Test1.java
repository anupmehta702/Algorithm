import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Test1 {

    public static void main(String[] args) throws IOException {
        restCallForMarketPrice();


    }

    public static List<MarketPrice> restCallForMarketPrice() throws IOException {
        List<MarketPrice> inputMarketPriceList = new ArrayList<>();
        URL url = new URL("https://api.myjson.com/bins/1eleys");
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
        conn.setRequestMethod("GET");
        conn.setRequestProperty("Accept", "application/json");
        if (conn.getResponseCode() != 200) {
            throw new RuntimeException("Failed : HTTP error code : "
                    + conn.getResponseCode());
        }

        BufferedReader br = new BufferedReader(new InputStreamReader((conn.getInputStream())));

        String output;
        System.out.println("Output from Server .... \n");
        while ((output = br.readLine()) != null) {
            System.out.println(output);
            System.out.println("new line");
        }

        conn.disconnect();

        return inputMarketPriceList;
    }
}


/*
 "date": "20190506",
            "security": "ibm",
            "price": 23.54
 */
class MarketPrice {
    String date;
    String security;
    Double price;

    public MarketPrice() {
    }

    public MarketPrice(String date, String security, Double price) {
        this.date = date;
        this.security = security;
        this.price = price;
    }

    public String getSecurity() {
        return security;
    }

    public Double getPrice() {
        return price;
    }

    public String getDate() {
        return date;
    }
}

class SecurityWiseMarketPrice {
    Map<String, Double> securityWiseMarketPriceMap = new HashMap<>();

    public SecurityWiseMarketPrice() {
    }

    public void addSecurityWiseMarketPrice(MarketPrice inputMarketPrice) {
        securityWiseMarketPriceMap.put(inputMarketPrice.getSecurity(), inputMarketPrice.getPrice());

    }

    //TODO create clone and then send the map
    public Map<String, Double> getSecurityWiseMarketPriceMap() {
        return securityWiseMarketPriceMap;
    }

    public Double getMarketPriceFor(String security) {
        return securityWiseMarketPriceMap.get(security);
    }
}
/*
"date": "20190506",
            "security": "ibm",
            "quantity": 100,
            "portfolio": "portfolio_1"
 */

class SecurityHolding {
    String date;
    String security;
    Integer quantity = new Integer(0);
    String portfolio;

    public SecurityHolding() {
    }

    public SecurityHolding(String date, String security, Integer quantity, String portfolio) {
        this.date = date;
        this.security = security;
        this.quantity = quantity;
        this.portfolio = portfolio;
    }

    public String getDate() {
        return date;
    }

    public String getSecurity() {
        return security;
    }
}

class Portfolio {
    Map<String, List<SecurityHolding>> dayWiseSecurityHoldingMap = new HashMap<>();
    Map<String, SecurityWiseMarketPrice> dayWiseMarketPriceMap = new HashMap<>();

    public void populateSecurityHoldings(List<SecurityHolding> securityHoldings) {
        for (SecurityHolding sh : securityHoldings) {
            if (dayWiseSecurityHoldingMap.containsKey(sh.getDate())) {
                List<SecurityHolding> dateWiseSecurityHoldings = dayWiseSecurityHoldingMap.get(sh.getDate());
                dateWiseSecurityHoldings.add(sh);
            } else {
                List<SecurityHolding> dateWiseSecurityHolding = new ArrayList<>();
                dateWiseSecurityHolding.add(sh);
                dayWiseSecurityHoldingMap.put(sh.getDate(), dateWiseSecurityHolding);
            }
        }
    }

    public void populateMarketPrice(List<MarketPrice> inputMarketPriceList) {
        for (MarketPrice marketPrice : inputMarketPriceList) {
            if (dayWiseMarketPriceMap.containsKey(marketPrice.getDate())) {
                SecurityWiseMarketPrice securityWiseMarketPrice = dayWiseMarketPriceMap.get(marketPrice.getDate());
                securityWiseMarketPrice.addSecurityWiseMarketPrice(marketPrice);
            } else {
                SecurityWiseMarketPrice securityWiseMarketPrice = new SecurityWiseMarketPrice();
                securityWiseMarketPrice.addSecurityWiseMarketPrice(marketPrice);
                dayWiseMarketPriceMap.put(marketPrice.getDate(), securityWiseMarketPrice);
            }
        }

    }

    public double calculateHoldingValue(String date) {
        Double dateHoldingValue = new Double(0);
        if (dayWiseSecurityHoldingMap.containsKey(date)) {
            List<SecurityHolding> inputSecurityHoldingList = dayWiseSecurityHoldingMap.get(date);
            for (SecurityHolding inputSecurityHolding : inputSecurityHoldingList) {
                SecurityWiseMarketPrice dateMarketPrice = dayWiseMarketPriceMap.get(date);
                Double securityMarketPrice = dateMarketPrice.getMarketPriceFor(inputSecurityHolding.security);
                dateHoldingValue = dateHoldingValue + (securityMarketPrice * inputSecurityHolding.quantity);
            }
        } else {
            return 0.0;
        }
        return dateHoldingValue;
    }

}
