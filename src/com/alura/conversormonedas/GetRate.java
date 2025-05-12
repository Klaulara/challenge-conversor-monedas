package com.alura.conversormonedas;

import com.google.gson.Gson;
import io.github.cdimascio.dotenv.Dotenv;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class GetRate {
    public Rate findRate(String coinOne, String coinTwo){

        Dotenv dotenv = Dotenv.load();
        var key = dotenv.get("API_KEY");
        var api_url = dotenv.get("API_URL");

        URI url = URI.create(api_url+key+"/pair/"+coinOne+"/"+coinTwo);

        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(url)
                .build();
        try {
            HttpResponse<String> response = client
                    .send(request, HttpResponse.BodyHandlers.ofString());

            return new Gson().fromJson(response.body(), Rate.class);
        } catch (Exception e) {
            throw new RuntimeException("Hay un error");
        }
    }
}
