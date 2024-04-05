package controllers;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import models.Movie;

import java.io.FileWriter;
import java.io.IOException;

public class JsonGenerator {

    public static void createJson(Movie movie){
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        try {
            FileWriter jsonWriter = new FileWriter(movie.title().concat(".json"));
            jsonWriter.write(gson.toJson(movie));
            jsonWriter.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
