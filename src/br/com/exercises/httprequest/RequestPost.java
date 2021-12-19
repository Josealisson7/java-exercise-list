package br.com.exercises.httprequest;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.time.Duration;

public class RequestPost {

    public static void main(String[] args) {
        String url = "https://postman-echo.com/post";
        String inputJson = "{ \"name\":\"tammy133\", \"salary\":\"5000\", \"age\":\"20\" }";
        try {
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create(url))
                    .POST(HttpRequest.BodyPublishers.ofString(inputJson))
                    .timeout(Duration.ofSeconds(20))
                    .build();
            HttpClient httpClient = HttpClient.newBuilder().connectTimeout(Duration.ofSeconds(20)).build();
            HttpResponse<String> response = httpClient.send(request, HttpResponse.BodyHandlers.ofString());
            System.out.println(response.body());
        } catch (Exception e) {
            System.out.println("An error occurred while trying to request : " + e.getMessage());
        }
    }
}
