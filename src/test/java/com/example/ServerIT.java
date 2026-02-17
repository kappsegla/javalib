package com.example;

import org.junit.jupiter.api.Test;
import org.testcontainers.containers.GenericContainer;
import org.testcontainers.images.builder.ImageFromDockerfile;
import org.testcontainers.junit.jupiter.Container;
import org.testcontainers.junit.jupiter.Testcontainers;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.nio.file.Paths;

import static org.assertj.core.api.Assertions.assertThat;

@Testcontainers
class ServerIT {

    @Container
    static GenericContainer<?> app =
            new GenericContainer<>(
                    new ImageFromDockerfile()
                            .withDockerfile(Paths.get("./Dockerfile"))
            )
                    .withExposedPorts(8080);

    @Test
    void respondsToHealthCheck() throws IOException, InterruptedException {
        String baseUrl = "http://" + app.getHost() + ":" + app.getMappedPort(8080);
        String url = baseUrl + "/health";
        HttpResponse<String> response;
        try (HttpClient client = HttpClient.newHttpClient()) {
            HttpRequest request = HttpRequest.newBuilder().uri(URI.create(url)).GET().build();
            response = client.send(request, HttpResponse.BodyHandlers.ofString());
        }
        assertThat(response.statusCode()).isEqualTo(200);
        assertThat(response.headers().firstValue("content-length")).contains("2");
        assertThat(response.body()).isEqualTo("OK");
    }
}
