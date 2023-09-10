package com.java11.features.httpclient;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.time.Duration;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Http2ClientVerifyURl {
    public static void main(String[] args) {
        fetchUriResponse();
    }
    static void fetchUriResponse(){
        List<URI> uris = Stream.of("https://www.google.com","https://www.github.com","https://www.xyxyxyx.com")
                .map(URI :: create).collect(Collectors.toList());
        HttpClient client = HttpClient.newBuilder()
                .connectTimeout(Duration.ofSeconds(10))
                .followRedirects(HttpClient.Redirect.ALWAYS)
                .build();

        CompletableFuture[] futures = uris.stream()
                .map(uri -> verifyUrl(client,uri))
                .toArray(CompletableFuture[]::new);
        CompletableFuture.allOf(futures).join();

    }

    static CompletableFuture<Void> verifyUrl(HttpClient client , URI uri){
        HttpRequest request = HttpRequest.newBuilder()
                .timeout(Duration.ofSeconds(10))
                .uri(uri)
                .build();
        return client.sendAsync(request, HttpResponse.BodyHandlers.ofString())
                .thenApply(HttpResponse::statusCode)
                .thenApply(statusCode -> statusCode == 200)
                .exceptionally(ex -> false)
                .thenAccept(valid -> {
                    if(valid){
                        System.out.println("[SUCCESS] Verified "+uri);
                    }else{
                        System.out.println("[FAILURE] Count not Connect "+uri);
                    }
                });
    }
}
