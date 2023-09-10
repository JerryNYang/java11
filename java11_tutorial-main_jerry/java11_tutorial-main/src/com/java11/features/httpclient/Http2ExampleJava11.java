package com.java11.features.httpclient;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.time.Duration;
import java.util.concurrent.CompletableFuture;

public class Http2ExampleJava11 {
    public static void main(String[] args) {
        //synchronousCall();
        asyncCall();
    }

    public static void asyncCall(){
        HttpRequest request = HttpRequest.newBuilder()
                .timeout(Duration.ofSeconds(10))
                .uri(URI.create("https://postman-echo.com/get?foo1=bar1&foo2=bar2"))
                .GET()
                .build();
        HttpResponse.BodyHandler<String> bodyHandlers = HttpResponse.BodyHandlers.ofString();
        HttpClient client = HttpClient.newHttpClient();
        CompletableFuture<HttpResponse<String>> future= client.sendAsync(request,bodyHandlers);
        future.thenApply(HttpResponse::body).thenAccept(System.out :: println).join();
    }
    public static void synchronousCall(){
        HttpClient httpClient = HttpClient.newBuilder()
                .connectTimeout(Duration.ofSeconds(10))
                .build();
        HttpResponse response = null;
        try{
            String endpointUrl = "https://postman-echo.com/get?foo1=bar1&foo2=bar2";
            URI uri = URI.create(endpointUrl);
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(uri)
                    .build();
            response = httpClient.send(request,HttpResponse.BodyHandlers.ofString());
        }catch(Exception e){
            e.printStackTrace();
        }
        System.out.println("Status Code :"+response.statusCode());
        System.out.println("Headers :"+response.headers().allValues("content-type"));
        System.out.println("Body :"+response.body());
    }
}
