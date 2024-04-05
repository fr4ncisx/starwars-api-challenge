package controllers;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

import com.google.gson.Gson;
import models.Movie;

public class FinderAPI {

    public static Movie findMovie(int id){
        URI address = URI.create("https://swapi.dev/api/films/" + id);
        HttpClient client = HttpClient.newHttpClient();

        HttpRequest request = HttpRequest.newBuilder()
                .uri(address)
                .build();
        try {
            HttpResponse<String> response;
            response = client
                    .send(request, HttpResponse.BodyHandlers.ofString());
            return new Gson().fromJson(response.body(),Movie.class);
        } catch (Exception e) {
            throw new RuntimeException("No encontré esa película");
        }

    }
}
