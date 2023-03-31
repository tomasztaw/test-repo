package pl.taw;

import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

import java.io.IOException;

public class WeatherFetcher {

    private static final String API_KEY = "MY_API_KEY...";
    private static final String URL = "https://api.weather.com/v3/wx/forecast/daily/5day?apiKey=" +
            API_KEY + "&geocode=37.77,-122.48&format=json";

    public static void main(String[] args) throws IOException {

        HttpClient httpClient = HttpClients.createDefault();
        HttpGet request = new HttpGet(URL);
        String responseBody = httpClient.execute(request, response -> {
            int status = response.getStatusLine().getStatusCode();
            if (status >= 200 && status < 300) {
                return EntityUtils.toString(response.getEntity());
            } else {
                throw new RuntimeException("Unexpected response status: " + status);
            }
        });

        System.out.println("responseBody = " + responseBody);
    }
}
