package com.rocheproject.ApiTest;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.ResponseEntity;

import com.rocheproject.ApiTest.controller.util.RequestParams;
import com.rocheproject.ApiTest.controller.util.Statistics;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Map;
import java.util.Map.Entry;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class ApiTestApplicationTests {

    @Autowired
    private TestRestTemplate restTemplate;

    @Test
    void testFizzBuzzEndpoint() {
        String url = "http://localhost:8080/fizzbuzzapi?int1=3&int2=5&limit=15&str1=fizz&str2=buzz";

         String[] result = restTemplate.getForObject(url, String[].class);

        assertEquals("1", result[0]);
        assertEquals("2", result[1]);
        assertEquals("fizz", result[2]);
        assertEquals("4", result[3]);
        assertEquals("buzz", result[4]);
        assertEquals("fizz", result[5]);
        assertEquals("7", result[6]);
        assertEquals("8", result[7]);
        assertEquals("fizz", result[8]);
        assertEquals("buzz", result[9]);
        assertEquals("11", result[10]);
        assertEquals("fizz", result[11]);
        assertEquals("13", result[12]);
        assertEquals("14", result[13]);
        assertEquals("fizzbuzz", result[14]);
    }

    @Test
    void testStatisticsEndpoint() {
        String url = "http://localhost:8080/statistics";
        ResponseEntity<Map> responseEntity = restTemplate.getForEntity(url, Map.class);
        Map<String, Object> responseBody = responseEntity.getBody();
        //System.out.println(responseBody);
        assertTrue(responseBody != null && !responseBody.isEmpty());
        
    }
}
