package com.wehaul.rentalmanager;

import org.junit.jupiter.api.Test;
import org.skyscreamer.jsonassert.JSONAssert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.ActiveProfiles;

import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.http.HttpStatus.CREATED;
import static org.springframework.http.HttpStatus.OK;
import static org.springframework.http.MediaType.APPLICATION_JSON;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@ActiveProfiles("test")
class ApplicationTest {

    @Autowired
    private TestRestTemplate restTemplate;

    @Test
    void shouldPassHealthCheck() {
        var responseEntity = restTemplate.getForEntity("/actuator/health", String.class);

        assertThat(responseEntity.getStatusCode()).isEqualTo(OK);
    }

    @Test
    void shouldExposeOpenApiEndpoint() {
        var responseEntity = restTemplate.getForEntity("/api-docs", String.class);

        assertThat(responseEntity.getStatusCode()).isEqualTo(OK);
    }
}
